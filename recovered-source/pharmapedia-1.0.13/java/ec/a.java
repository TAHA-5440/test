// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ec;
public final class a {
    public final synthetic int a;
    public long b;
    public Object c;

    public a()
    {
        this.a = 2;
        this.b = 0;
        return;
    }

    public a(g7.d p2, long p3)
    {
        this.a = 1;
        this.c = p2;
        this.b = p3;
        return;
    }

    public a(oc.y p3)
    {
        this.a = 0;
        p3.getClass();
        this.c = p3;
        this.b = 262144;
        return;
    }

    public void a(int p5)
    {
        if (p5 < 64) {
            this.b = (this.b & (~ (1 << p5)));
            return;
        } else {
            ec.a v1_0 = ((ec.a) this.c);
            if (v1_0 != null) {
                v1_0.a((p5 - 64));
            }
            return;
        }
    }

    public int b(int p7)
    {
        int v0_1 = ((ec.a) this.c);
        if (v0_1 != 0) {
            if (p7 >= 64) {
                return (Long.bitCount(this.b) + v0_1.b((p7 - 64)));
            } else {
                return Long.bitCount((this.b & ((1 << p7) - 1)));
            }
        } else {
            long v4_2 = this.b;
            if (p7 < 64) {
                return Long.bitCount((((1 << p7) - 1) & v4_2));
            } else {
                return Long.bitCount(v4_2);
            }
        }
    }

    public void c()
    {
        if (((ec.a) this.c) == null) {
            this.c = new ec.a();
        }
        return;
    }

    public boolean d(int p5)
    {
        if (p5 < 64) {
            if ((this.b & (1 << p5)) == 0) {
                return 0;
            } else {
                return 1;
            }
        } else {
            this.c();
            return ((ec.a) this.c).d((p5 - 64));
        }
    }

    public void e(int p10, boolean p11)
    {
        if (p10 < 64) {
            int v2_0;
            long v0_4 = this.b;
            if ((-9223372036854775808 & v0_4) == 0) {
                v2_0 = 0;
            } else {
                v2_0 = 1;
            }
            long v7_1 = ((1 << p10) - 1);
            this.b = (((v0_4 & (~ v7_1)) << 1) | (v0_4 & v7_1));
            if (!p11) {
                this.a(p10);
            } else {
                this.h(p10);
            }
            if ((v2_0 == 0) && (((ec.a) this.c) == null)) {
                return;
            } else {
                this.c();
                ((ec.a) this.c).e(0, v2_0);
                return;
            }
        } else {
            this.c();
            ((ec.a) this.c).e((p10 - 64), p11);
            return;
        }
    }

    public boolean f(int p11)
    {
        if (p11 < 64) {
            int v11_1;
            long v2_4 = (1 << p11);
            long v4_1 = this.b;
            if ((v4_1 & v2_4) == 0) {
                v11_1 = 0;
            } else {
                v11_1 = 1;
            }
            long v4_0 = (v4_1 & (~ v2_4));
            this.b = v4_0;
            long v2_0 = (v2_4 - 1);
            this.b = ((v4_0 & v2_0) | Long.rotateRight(((~ v2_0) & v4_0), 1));
            ec.a v0_5 = ((ec.a) this.c);
            if (v0_5 != null) {
                if (v0_5.d(0)) {
                    this.h(63);
                }
                ((ec.a) this.c).f(0);
            }
            return v11_1;
        } else {
            this.c();
            return ((ec.a) this.c).f((p11 - 64));
        }
    }

    public void g()
    {
        this.b = 0;
        ec.a v0_2 = ((ec.a) this.c);
        if (v0_2 != null) {
            v0_2.g();
        }
        return;
    }

    public void h(int p5)
    {
        if (p5 < 64) {
            this.b = (this.b | (1 << p5));
            return;
        } else {
            this.c();
            ((ec.a) this.c).h((p5 - 64));
            return;
        }
    }

    public String toString()
    {
        switch (this.a) {
            case 2:
                String v0_1;
                if (((ec.a) this.c) != null) {
                    String v0_7 = new StringBuilder();
                    v0_7.append(((ec.a) this.c).toString());
                    v0_7.append("xx");
                    v0_7.append(Long.toBinaryString(this.b));
                    v0_1 = v0_7.toString();
                } else {
                    v0_1 = Long.toBinaryString(this.b);
                }
                return v0_1;
            default:
                return super.toString();
        }
    }
}
