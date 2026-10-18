"""Independent controls for the portable decoder; no app inputs or secrets needed."""
import ctypes
from pathlib import Path
import shutil
import subprocess
import tempfile
import unittest
from Crypto.Cipher import ChaCha20


MASK = 0xffffffff


def reference_block(key, nonce, counter, rounds):
    import struct
    state = list(struct.unpack("<4I", b"expand 32-byte k"))
    state += list(struct.unpack("<8I", key)) + [counter] + list(struct.unpack("<3I", nonce))
    x = state.copy()

    def rol(v, count):
        return ((v << count) | (v >> (32 - count))) & MASK

    def quarter(a, b, c, d):
        x[a] = (x[a] + x[b]) & MASK; x[d] = rol(x[d] ^ x[a], 16)
        x[c] = (x[c] + x[d]) & MASK; x[b] = rol(x[b] ^ x[c], 12)
        x[a] = (x[a] + x[b]) & MASK; x[d] = rol(x[d] ^ x[a], 8)
        x[c] = (x[c] + x[d]) & MASK; x[b] = rol(x[b] ^ x[c], 7)

    for _ in range(rounds // 2):
        for indexes in ((0,4,8,12),(1,5,9,13),(2,6,10,14),(3,7,11,15),
                        (0,5,10,15),(1,6,11,12),(2,7,8,13),(3,4,9,14)):
            quarter(*indexes)
    return struct.pack("<16I", *((a + b) & MASK for a, b in zip(x, state)))


class CipherControls(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        if shutil.which("cc") is None:
            raise unittest.SkipTest("C compiler unavailable")
        cls.directory = tempfile.TemporaryDirectory()
        library = Path(cls.directory.name) / "codec.so"
        subprocess.run(["cc", "-O2", "-Wall", "-Wextra", "-Werror", "-std=c11",
                        "-shared", "-fPIC", str(Path(__file__).with_name("chacha_codec.c")),
                        "-o", str(library)], check=True)
        cls.library = ctypes.CDLL(str(library))
        cls.function = cls.library.recovery_chacha_xor
        cls.function.argtypes = [ctypes.c_void_p, ctypes.c_void_p, ctypes.c_size_t,
                                 ctypes.c_void_p, ctypes.c_void_p,
                                 ctypes.c_uint32, ctypes.c_uint]
        cls.function.restype = ctypes.c_int

    @classmethod
    def tearDownClass(cls):
        cls.directory.cleanup()

    def decode(self, data, key, nonce, counter, rounds):
        output = ctypes.create_string_buffer(len(data))
        code = self.function(output, data, len(data), key, nonce, counter, rounds)
        self.assertEqual(code, 0)
        return output.raw

    def test_standard_twenty_round_control(self):
        key, nonce = bytes(range(32)), bytes(range(12))
        for length in (0, 1, 63, 64, 65, 513):
            for counter in (0, 1, 4096):
                with self.subTest(length=length, counter=counter):
                    data = bytes(i % 256 for i in range(length))
                    independent = ChaCha20.new(key=key, nonce=nonce)
                    independent.seek(counter * 64)
                    self.assertEqual(self.decode(data, key, nonce, counter, 20),
                                     independent.encrypt(data))

    def test_eight_round_reference(self):
        key, nonce = bytes(reversed(range(32))), bytes(reversed(range(12)))
        for counter in (0, 1, 12345):
            self.assertEqual(self.decode(bytes(64), key, nonce, counter, 8),
                             reference_block(key, nonce, counter, 8))

    def test_block_aligned_streaming(self):
        key, nonce = bytes(range(32)), bytes(range(12))
        data = bytes(range(256)) * 4 + b"partial"
        whole = self.decode(data, key, nonce, 0, 8)
        pieces = self.decode(data[:512], key, nonce, 0, 8)
        pieces += self.decode(data[512:], key, nonce, 8, 8)
        self.assertEqual(whole, pieces)
        self.assertEqual(self.decode(whole, key, nonce, 0, 8), data)

    def test_invalid_rounds_rejected(self):
        output = ctypes.create_string_buffer(64)
        for rounds in (0, 1, 3, 41, 42):
            self.assertEqual(self.function(output, bytes(64), 64, bytes(32),
                                            bytes(12), 0, rounds), -1)

    def test_counter_wrap_rejected(self):
        output = ctypes.create_string_buffer(65)
        self.assertEqual(self.function(output, bytes(65), 65, bytes(32),
                                        bytes(12), MASK, 8), -2)


if __name__ == "__main__":
    unittest.main()
