// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package wb;
public final class e extends a7.j {
    public final boolean i;

    public e(cc.z p1, boolean p2)
    {
        super(p1);
        super.i = p2;
        return;
    }

    public final void c(byte p2)
    {
        if (!this.i) {
            String v2_4 = String.valueOf((p2 & 255));
            v2_4.getClass();
            ((cc.z) this.h).r(v2_4);
            return;
        } else {
            this.h(String.valueOf((p2 & 255)));
            return;
        }
    }

    public final void e(int p7)
    {
        if (!this.i) {
            String v7_2 = Long.toString((((long) p7) & 4294967295), 10);
            v7_2.getClass();
            ((cc.z) this.h).r(v7_2);
            return;
        } else {
            this.h(Long.toString((((long) p7) & 4294967295), 10));
            return;
        }
    }

    public final void f(long p14)
    {
        int v1 = 63;
        String v4_1 = "0";
        if (!this.i) {
            char[] v0_4 = p14 cmp 0;
            if (v0_4 != null) {
                if (v0_4 <= null) {
                    char[] v0_1 = new char[64];
                    long v3_1 = ((p14 >> 1) / ((long) 5));
                    v0_1[63] = Character.forDigit(((int) (p14 - (v3_1 * ((long) 10)))), 10);
                    while (v3_1 > 0) {
                        v1--;
                        v0_1[v1] = Character.forDigit(((int) (v3_1 % ((long) 10))), 10);
                        v3_1 /= ((long) 10);
                    }
                    v4_1 = new String(v0_1, v1, (64 - v1));
                } else {
                    v4_1 = Long.toString(p14, 10);
                }
            }
            v4_1.getClass();
            ((cc.z) this.h).r(v4_1);
            return;
        } else {
            char[] v0_2 = p14 cmp 0;
            if (v0_2 != null) {
                if (v0_2 <= null) {
                    char[] v0_3 = new char[64];
                    long v3_4 = ((p14 >> 1) / ((long) 5));
                    v0_3[63] = Character.forDigit(((int) (p14 - (v3_4 * ((long) 10)))), 10);
                    while (v3_4 > 0) {
                        v1--;
                        v0_3[v1] = Character.forDigit(((int) (v3_4 % ((long) 10))), 10);
                        v3_4 /= ((long) 10);
                    }
                    v4_1 = new String(v0_3, v1, (64 - v1));
                } else {
                    v4_1 = Long.toString(p14, 10);
                }
            }
            this.h(v4_1);
            return;
        }
    }

    public final void g(short p3)
    {
        if (!this.i) {
            String v3_4 = String.valueOf((p3 & 65535));
            v3_4.getClass();
            ((cc.z) this.h).r(v3_4);
            return;
        } else {
            this.h(String.valueOf((p3 & 65535)));
            return;
        }
    }
}
