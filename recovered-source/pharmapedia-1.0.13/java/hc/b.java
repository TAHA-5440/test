// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package hc;
public abstract class b {
    public static final okio.ByteString a;

    static b()
    {
        hc.b.a = n5.f.o("xn--");
        return;
    }

    public static int a(int p0, boolean p1, int p2)
    {
        int v0_1;
        if (p1 == 0) {
            v0_1 = (p0 / 2);
        } else {
            v0_1 = (p0 / 700);
        }
        int v1_1 = ((v0_1 / p2) + v0_1);
        int v0_2 = 0;
        while (v1_1 > 455) {
            v1_1 /= 35;
            v0_2 += 36;
        }
        return (((v1_1 * 36) / (v1_1 + 38)) + v0_2);
    }

    public static int b(int p3)
    {
        if (p3 >= 26) {
            if (p3 >= 36) {
                StringBuilder v1_1 = new StringBuilder("unexpected digit: ");
                v1_1.append(p3);
                throw new IllegalStateException(v1_1.toString().toString());
            } else {
                return (p3 + 22);
            }
        } else {
            return (p3 + 97);
        }
    }
}
