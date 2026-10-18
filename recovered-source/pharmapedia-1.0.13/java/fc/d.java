// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public final class d {
    public final oc.i a;
    public int b;
    public boolean c;
    public int d;
    public fc.b[] e;
    public int f;
    public int g;
    public int h;

    public d(oc.i p1)
    {
        this.a = p1;
        this.b = 2147483647;
        this.d = 4096;
        int v1_4 = new fc.b[8];
        this.e = v1_4;
        this.f = 7;
        return;
    }

    public final void a(int p5)
    {
        if (p5 > 0) {
            int v0_5 = (this.e.length - 1);
            int v1 = 0;
            while(true) {
                int v2_8 = this.f;
                if ((v0_5 < v2_8) || (p5 <= 0)) {
                    break;
                }
                int v2_2 = this.e[v0_5];
                v2_2.getClass();
                p5 -= v2_2.c;
                int v2_4 = this.h;
                int v3_3 = this.e[v0_5];
                v3_3.getClass();
                this.h = (v2_4 - v3_3.c);
                this.g = (this.g - 1);
                v1++;
                v0_5--;
            }
            int v2_9 = (v2_8 + 1);
            System.arraycopy(this.e, v2_9, this.e, (v2_9 + v1), this.g);
            int v0_3 = (this.f + 1);
            java.util.Arrays.fill(this.e, v0_3, (v0_3 + v1), 0);
            this.f = (this.f + v1);
        }
        return;
    }

    public final void b(fc.b p7)
    {
        int v0_0 = p7.c;
        int v1_0 = this.d;
        if (v0_0 <= v1_0) {
            this.a(((this.h + v0_0) - v1_0));
            fc.b[] v3_0 = this.e;
            if ((this.g + 1) > v3_0.length) {
                int v1_3 = new fc.b[(v3_0.length * 2)];
                System.arraycopy(v3_0, 0, v1_3, v3_0.length, v3_0.length);
                this.f = (this.e.length - 1);
                this.e = v1_3;
            }
            int v1_4 = this.f;
            this.f = (v1_4 - 1);
            this.e[v1_4] = p7;
            this.g = (this.g + 1);
            this.h = (this.h + v0_0);
            return;
        } else {
            int v7_5 = this.e;
            ha.i.N(v7_5, 0, v7_5.length);
            this.f = (this.e.length - 1);
            this.g = 0;
            this.h = 0;
            return;
        }
    }

    public final void c(okio.ByteString p12)
    {
        p12.getClass();
        int v1_2 = 0;
        int v3_2 = 0;
        oc.i v5_2 = 0;
        int v4_3 = 0;
        while (v4_3 < p12.e()) {
            v5_2 += ((long) fc.a0.b[(p12.j(v4_3) & 255)]);
            v4_3++;
        }
        oc.i v5_1 = this.a;
        if (((int) ((v5_2 + ((long) 7)) >> 3)) >= p12.e()) {
            this.e(p12.e(), 127, 0);
            v5_1.m0(p12);
            return;
        } else {
            int v0_4 = new oc.i();
            int v4_2 = p12.e();
            int v7_1 = 0;
            while (v3_2 < v4_2) {
                int v8_1 = (p12.j(v3_2) & 255);
                int v8_2 = fc.a0.b[v8_1];
                v1_2 = ((v1_2 << v8_2) | ((long) fc.a0.a[v8_1]));
                v7_1 += v8_2;
                while (v7_1 >= 8) {
                    v7_1 -= 8;
                    v0_4.o0(((int) (v1_2 >> v7_1)));
                }
                v3_2++;
            }
            if (v7_1 > 0) {
                v0_4.o0(((int) ((v1_2 << (8 - v7_1)) | (255 >> v7_1))));
            }
            okio.ByteString v12_3 = v0_4.j(v0_4.h);
            this.e(v12_3.e(), 127, 128);
            v5_1.m0(v12_3);
            return;
        }
    }

    public final void d(java.util.ArrayList p14)
    {
        if (this.c) {
            int v0_4 = this.b;
            if (v0_4 < this.d) {
                this.e(v0_4, 31, 32);
            }
            this.c = 0;
            this.b = 2147483647;
            this.e(this.d, 31, 32);
        }
        int v0_3 = p14.size();
        int v2_0 = 0;
        while (v2_0 < v0_3) {
            int v6_4;
            int v8_0;
            int v3_3 = ((fc.b) p14.get(v2_0));
            int v4_4 = v3_3.a.r();
            okio.ByteString v5 = v3_3.b;
            int v6_3 = ((Integer) fc.e.b.get(v4_4));
            if (v6_3 == 0) {
                v6_4 = -1;
                v8_0 = -1;
            } else {
                int v6_5 = v6_3.intValue();
                v8_0 = (v6_5 + 1);
                if ((2 <= v8_0) && (v8_0 < 8)) {
                    int v9_2 = fc.e.a;
                    if (!kotlin.jvm.internal.f.a(v9_2[v6_5].b, v5)) {
                        if (kotlin.jvm.internal.f.a(v9_2[v8_0].b, v5)) {
                            int v12 = v8_0;
                            v8_0 = (v6_5 + 2);
                            v6_4 = v12;
                            if (v8_0 == -1) {
                                int v9_7 = (this.f + 1);
                                int v10_4 = this.e.length;
                                while (v9_7 < v10_4) {
                                    int v11_1 = this.e[v9_7];
                                    v11_1.getClass();
                                    if (kotlin.jvm.internal.f.a(v11_1.a, v4_4)) {
                                        int v11_5 = this.e[v9_7];
                                        v11_5.getClass();
                                        if (!kotlin.jvm.internal.f.a(v11_5.b, v5)) {
                                            if (v6_4 == -1) {
                                                v6_4 = ((v9_7 - this.f) + fc.e.a.length);
                                            }
                                        } else {
                                            v8_0 = (fc.e.a.length + (v9_7 - this.f));
                                            break;
                                        }
                                    }
                                    v9_7++;
                                }
                            }
                            if (v8_0 == -1) {
                                if (v6_4 != -1) {
                                    okio.ByteString v7_3 = fc.b.d;
                                    v4_4.getClass();
                                    v7_3.getClass();
                                    if ((!v4_4.m(0, v7_3, v7_3.e())) || (kotlin.jvm.internal.f.a(fc.b.i, v4_4))) {
                                        this.e(v6_4, 63, 64);
                                        this.c(v5);
                                        this.b(v3_3);
                                    } else {
                                        this.e(v6_4, 15, 0);
                                        this.c(v5);
                                    }
                                } else {
                                    this.a.o0(64);
                                    this.c(v4_4);
                                    this.c(v5);
                                    this.b(v3_3);
                                }
                            } else {
                                this.e(v8_0, 127, 128);
                            }
                            v2_0++;
                        }
                    } else {
                        v6_4 = v8_0;
                    }
                }
                v6_4 = v8_0;
                v8_0 = -1;
            }
        }
        return;
    }

    public final void e(int p2, int p3, int p4)
    {
        oc.i v0 = this.a;
        if (p2 >= p3) {
            v0.o0((p4 | p3));
            int v2_1 = (p2 - p3);
            while (v2_1 >= 128) {
                v0.o0((128 | (v2_1 & 127)));
                v2_1 >>= 7;
            }
            v0.o0(v2_1);
            return;
        } else {
            v0.o0((p2 | p4));
            return;
        }
    }
}
