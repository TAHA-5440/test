// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public final class c {
    public int a;
    public final java.util.ArrayList b;
    public final oc.y c;
    public fc.b[] d;
    public int e;
    public int f;
    public int g;

    public c(fc.s p2)
    {
        this.a = 4096;
        this.b = new java.util.ArrayList();
        this.c = new oc.y(p2);
        int v2_1 = new fc.b[8];
        this.d = v2_1;
        this.e = 7;
        return;
    }

    public final int a(int p5)
    {
        int v0 = 0;
        if (p5 > 0) {
            int v1_2 = (this.d.length - 1);
            while(true) {
                int v2_7 = this.e;
                if ((v1_2 < v2_7) || (p5 <= 0)) {
                    break;
                }
                int v2_3 = this.d[v1_2];
                v2_3.getClass();
                int v2_4 = v2_3.c;
                p5 -= v2_4;
                this.g = (this.g - v2_4);
                this.f = (this.f - 1);
                v0++;
                v1_2--;
            }
            System.arraycopy(this.d, (v2_7 + 1), this.d, ((v2_7 + 1) + v0), this.f);
            this.e = (this.e + v0);
        }
        return v0;
    }

    public final okio.ByteString b(int p4)
    {
        if (p4 >= null) {
            String v0_0 = fc.e.a;
            if (p4 <= (v0_0.length - 1)) {
                return v0_0[p4].a;
            }
        }
        int v1_0 = ((this.e + 1) + (p4 - fc.e.a.length));
        if (v1_0 >= 0) {
            String v0_1 = this.d;
            if (v1_0 < v0_1.length) {
                okio.ByteString v4_3 = v0_1[v1_0];
                v4_3.getClass();
                return v4_3.a;
            }
        }
        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.d((p4 + 1), "Header index too large ");
        return 0;
    }

    public final void c(fc.b p7)
    {
        this.b.add(p7);
        int v0_1 = p7.c;
        int v1_6 = this.a;
        if (v0_1 <= v1_6) {
            this.a(((this.g + v0_1) - v1_6));
            fc.b[] v3_0 = this.d;
            if ((this.f + 1) > v3_0.length) {
                int v1_4 = new fc.b[(v3_0.length * 2)];
                System.arraycopy(v3_0, 0, v1_4, v3_0.length, v3_0.length);
                this.e = (this.d.length - 1);
                this.d = v1_4;
            }
            int v1_5 = this.e;
            this.e = (v1_5 - 1);
            this.d[v1_5] = p7;
            this.f = (this.f + 1);
            this.g = (this.g + v0_1);
            return;
        } else {
            int v7_5 = this.d;
            ha.i.N(v7_5, 0, v7_5.length);
            this.e = (this.d.length - 1);
            this.f = 0;
            this.g = 0;
            return;
        }
    }

    public final okio.ByteString d()
    {
        oc.i v1_0;
        int v0_0 = this.c;
        oc.i v1_2 = v0_0.readByte();
        int v4_1 = 0;
        if ((v1_2 & 128) != 128) {
            v1_0 = 0;
        } else {
            v1_0 = 1;
        }
        long v2_1 = ((long) this.e((v1_2 & 255), 127));
        if (v1_0 == null) {
            return v0_0.j(v2_1);
        } else {
            oc.i v1_3 = new oc.i();
            Class vtmp3 = v0_0.getClass();
            fc.z v5 = fc.a0.c;
            fc.z v9_0 = v5;
            long v7 = 0;
            int v6_1 = 0;
            while (v7 < v2_1) {
                v4_1 = ((v4_1 << 8) | (v0_0.readByte() & 255));
                v6_1 += 8;
                while (v6_1 >= 8) {
                    int v10_7 = ((v4_1 >> (v6_1 - 8)) & 255);
                    fc.z v9_2 = ((fc.z[]) v9_0.c);
                    v9_2.getClass();
                    v9_0 = v9_2[v10_7];
                    v9_0.getClass();
                    if (((fc.z[]) v9_0.c) != null) {
                        v6_1 -= 8;
                    } else {
                        v1_3.o0(v9_0.a);
                        v6_1 -= v9_0.b;
                        v9_0 = v5;
                    }
                }
                v7++;
            }
            while (v6_1 > 0) {
                int v0_4 = ((v4_1 << (8 - v6_1)) & 255);
                long v2_3 = ((fc.z[]) v9_0.c);
                v2_3.getClass();
                int v0_5 = v2_3[v0_4];
                v0_5.getClass();
                long v2_4 = v0_5.b;
                if ((((fc.z[]) v0_5.c) != null) || (v2_4 > v6_1)) {
                    break;
                }
                v1_3.o0(v0_5.a);
                v6_1 -= v2_4;
                v9_0 = v5;
            }
            return v1_3.j(v1_3.h);
        }
    }

    public final int e(int p4, int p5)
    {
        int v4_1 = (p4 & p5);
        if (v4_1 >= p5) {
            int v4_3 = 0;
            while(true) {
                int v0_3 = this.c.readByte();
                if ((v0_3 & 128) == 0) {
                    break;
                }
                p5 += ((v0_3 & 127) << v4_3);
                v4_3 += 7;
            }
            return (p5 + ((v0_3 & 255) << v4_3));
        } else {
            return v4_1;
        }
    }
}
