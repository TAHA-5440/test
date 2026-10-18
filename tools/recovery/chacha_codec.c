/* Analysis/recovery primitive, not a recommendation for new encryption.
 * Implements the public ChaCha ARX permutation with an explicit round count.
 * Never loads or executes any of the app's native libraries.
 */
#include <stddef.h>
#include <stdint.h>

static uint32_t load32(const uint8_t *p) {
    return (uint32_t)p[0] | (uint32_t)p[1] << 8 |
           (uint32_t)p[2] << 16 | (uint32_t)p[3] << 24;
}
static void store32(uint8_t *p, uint32_t v) {
    for (unsigned i = 0; i < 4; ++i) p[i] = (uint8_t)(v >> (8 * i));
}
static uint32_t rol(uint32_t x, unsigned n) {
    return (x << n) | (x >> (32 - n));
}
#define QR(a,b,c,d) do { \
    x[a] += x[b]; x[d] = rol(x[d] ^ x[a], 16); \
    x[c] += x[d]; x[b] = rol(x[b] ^ x[c], 12); \
    x[a] += x[b]; x[d] = rol(x[d] ^ x[a], 8); \
    x[c] += x[d]; x[b] = rol(x[b] ^ x[c], 7); \
} while (0)

/* Caller supplies buffers, a 32-byte key, and a 12-byte nonce. Returns 0 on
 * success, -1 for invalid rounds, or -2 if a 32-bit block counter would wrap.
 * A fresh call starts on a block boundary; use 64-byte-aligned chunk sizes.
 */
int recovery_chacha_xor(uint8_t *out, const uint8_t *in, size_t length,
                        const uint8_t key[32], const uint8_t nonce[12],
                        uint32_t counter, unsigned rounds) {
    if (rounds < 2 || rounds > 40 || (rounds & 1)) return -1;
    uint32_t state[16] = {0x61707865,0x3320646e,0x79622d32,0x6b206574};
    for (unsigned i = 0; i < 8; ++i) state[4+i] = load32(key+4*i);
    state[12] = counter;
    for (unsigned i = 0; i < 3; ++i) state[13+i] = load32(nonce+4*i);
    while (length) {
        uint32_t x[16]; uint8_t stream[64];
        for (unsigned i = 0; i < 16; ++i) x[i] = state[i];
        for (unsigned r = 0; r < rounds; r += 2) {
            QR(0,4,8,12); QR(1,5,9,13); QR(2,6,10,14); QR(3,7,11,15);
            QR(0,5,10,15); QR(1,6,11,12); QR(2,7,8,13); QR(3,4,9,14);
        }
        for (unsigned i = 0; i < 16; ++i) store32(stream+4*i,x[i]+state[i]);
        size_t n = length < 64 ? length : 64;
        for (size_t i = 0; i < n; ++i) out[i] = in[i] ^ stream[i];
        out += n; in += n; length -= n;
        if (length && state[12] == UINT32_MAX) return -2;
        ++state[12];
    }
    return 0;
}
