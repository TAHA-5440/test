// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public final class n {
    public final synthetic int a;
    public boolean b;
    public boolean c;
    public Object d;
    public Object e;
    public java.io.Serializable f;
    public Object g;
    public Object h;
    public Object i;

    public synthetic n()
    {
        this.a = 1;
        return;
    }

    public synthetic n(boolean p11, boolean p12, oc.w p13, Long p14, Long p15, Long p16, Long p17)
    {
        this.a = 0;
        this(p11, p12, p13, p14, p15, p16, p17, kotlin.collections.a.G());
        return;
    }

    public n(boolean p2, boolean p3, oc.w p4, Long p5, Long p6, Long p7, Long p8, java.util.Map p9)
    {
        this.a = 0;
        p9.getClass();
        this.b = p2;
        this.c = p3;
        this.d = p4;
        this.e = p5;
        this.f = p6;
        this.g = p7;
        this.h = p8;
        this.i = kotlin.collections.a.N(p9);
        return;
    }

    public void a(androidx.constraintlayout.core.widgets.analyzer.a p10, int p11, java.util.ArrayList p12, y.g p13)
    {
        java.util.ArrayList v10_1 = p10.d;
        androidx.constraintlayout.core.widgets.analyzer.a v1_0 = v10_1.i;
        int v2_0 = v10_1.h;
        if (v10_1.c == null) {
            int v0_10 = ((x.e) this.d);
            if ((v10_1 != v0_10.d) && (v10_1 != v0_10.e)) {
                if (p13 == null) {
                    p13 = new y.g();
                    p13.a = 0;
                    p13.b = new java.util.ArrayList();
                    p13.a = v10_1;
                    p12.add(p13);
                }
                v10_1.c = p13;
                p13.b.add(v10_1);
                int v0_5 = v2_0.k;
                int v3_0 = v0_5.size();
                int v4 = 0;
                androidx.constraintlayout.core.widgets.analyzer.a v5_0 = 0;
                while (v5_0 < v3_0) {
                    int v6_8 = v0_5.get(v5_0);
                    v5_0++;
                    int v6_0 = ((y.d) v6_8);
                    if ((v6_0 instanceof androidx.constraintlayout.core.widgets.analyzer.a)) {
                        this.a(((androidx.constraintlayout.core.widgets.analyzer.a) v6_0), p11, p12, p13);
                    }
                }
                int v0_6 = v1_0.k;
                int v3_1 = v0_6.size();
                androidx.constraintlayout.core.widgets.analyzer.a v5_1 = 0;
                while (v5_1 < v3_1) {
                    int v6_5 = v0_6.get(v5_1);
                    v5_1++;
                    int v6_6 = ((y.d) v6_5);
                    if ((v6_6 instanceof androidx.constraintlayout.core.widgets.analyzer.a)) {
                        this.a(((androidx.constraintlayout.core.widgets.analyzer.a) v6_6), p11, p12, p13);
                    }
                }
                if ((p11 == 1) && ((v10_1 instanceof androidx.constraintlayout.core.widgets.analyzer.e))) {
                    int v3_6 = ((androidx.constraintlayout.core.widgets.analyzer.e) v10_1).k.k;
                    androidx.constraintlayout.core.widgets.analyzer.a v5_2 = v3_6.size();
                    int v6_2 = 0;
                    while (v6_2 < v5_2) {
                        androidx.constraintlayout.core.widgets.analyzer.a v7_1 = v3_6.get(v6_2);
                        v6_2++;
                        androidx.constraintlayout.core.widgets.analyzer.a v7_2 = ((y.d) v7_1);
                        if ((v7_2 instanceof androidx.constraintlayout.core.widgets.analyzer.a)) {
                            this.a(((androidx.constraintlayout.core.widgets.analyzer.a) v7_2), p11, p12, p13);
                        }
                    }
                }
                int v2_1 = v2_0.l;
                int v3_7 = v2_1.size();
                androidx.constraintlayout.core.widgets.analyzer.a v5_3 = 0;
                while (v5_3 < v3_7) {
                    int v6_3 = v2_1.get(v5_3);
                    v5_3++;
                    this.a(((androidx.constraintlayout.core.widgets.analyzer.a) v6_3), p11, p12, p13);
                }
                androidx.constraintlayout.core.widgets.analyzer.a v1_1 = v1_0.l;
                int v2_2 = v1_1.size();
                int v3_8 = 0;
                while (v3_8 < v2_2) {
                    androidx.constraintlayout.core.widgets.analyzer.a v5_4 = v1_1.get(v3_8);
                    v3_8++;
                    this.a(((androidx.constraintlayout.core.widgets.analyzer.a) v5_4), p11, p12, p13);
                }
                if ((p11 == 1) && ((v10_1 instanceof androidx.constraintlayout.core.widgets.analyzer.e))) {
                    java.util.ArrayList v10_4 = ((androidx.constraintlayout.core.widgets.analyzer.e) v10_1).k.l;
                    int v0_11 = v10_4.size();
                    while (v4 < v0_11) {
                        androidx.constraintlayout.core.widgets.analyzer.a v1_2 = v10_4.get(v4);
                        v4++;
                        this.a(((androidx.constraintlayout.core.widgets.analyzer.a) v1_2), p11, p12, p13);
                    }
                }
            }
        }
        return;
    }

    public void b(x.e p26)
    {
        int v1_0 = p26.p0;
        float v2_1 = p26.S;
        int v3_4 = v1_0.size();
        float v4_9 = 0;
        int v5 = 0;
        while (v5 < v3_4) {
            int v6_0 = v1_0.get(v5);
            v5++;
            x.d v8_1 = ((x.d) v6_0);
            int v6_4 = v8_1.S;
            oc.n v7_1 = v8_1.P;
            int v9_3 = v8_1.K;
            int v10_2 = v8_1.I;
            int v11_2 = v8_1.J;
            int v12_2 = v8_1.H;
            int v13 = v6_4[v4_9];
            int v6_8 = v6_4[1];
            int v16 = v4_9;
            if (v8_1.g0 != 8) {
                float v4_3 = v8_1.w;
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour v15_2 = androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour.i;
                if ((v4_3 < 1065353216) && (v13 == v15_2)) {
                    v8_1.r = 2;
                }
                float v14_6 = v8_1.z;
                if ((v14_6 < 1065353216) && (v6_8 == v15_2)) {
                    v8_1.s = 2;
                }
                int v19_3;
                int v22;
                int v0_75 = androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour.h;
                java.util.ArrayList v21 = v1_0;
                int v1_2 = androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour.g;
                if (v8_1.W <= 0) {
                    v19_3 = v2_1;
                    v22 = v3_4;
                } else {
                    if ((v13 != v15_2) || ((v6_8 != v0_75) && (v6_8 != v1_2))) {
                        v19_3 = v2_1;
                        if ((v6_8 != v15_2) || ((v13 != v0_75) && (v13 != v1_2))) {
                            if ((v13 != v15_2) || (v6_8 != v15_2)) {
                            } else {
                                v22 = v3_4;
                                if (v8_1.r == 0) {
                                    v8_1.r = 3;
                                }
                                if (v8_1.s == 0) {
                                    v8_1.s = 3;
                                }
                            }
                        } else {
                            v8_1.s = 3;
                        }
                    } else {
                        v19_3 = v2_1;
                        v8_1.r = 3;
                    }
                }
                if ((v13 == v15_2) && ((v8_1.r == 1) && ((v12_2.f == null) || (v11_2.f == null)))) {
                    v13 = v0_75;
                }
                if ((v6_8 == v15_2) && ((v8_1.s == 1) && ((v10_2.f == null) || (v9_3.f == null)))) {
                    v6_8 = v0_75;
                }
                float v2_17 = v8_1.d;
                v2_17.d = v13;
                int v3_9 = v8_1.r;
                v2_17.a = v3_9;
                float v2_18 = v8_1.e;
                v2_18.d = v6_8;
                float v23 = v4_3;
                float v4_10 = v8_1.s;
                v2_18.a = v4_10;
                float v2_0 = androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour.j;
                if (((v13 != v2_0) && ((v13 != v1_2) && (v13 != v0_75))) || ((v6_8 != v2_0) && ((v6_8 != v1_2) && (v6_8 != v0_75)))) {
                    if ((v13 != v15_2) || ((v6_8 != v0_75) && (v6_8 != v1_2))) {
                        int v9_0 = v0_75;
                        int v11_0 = v6_8;
                    } else {
                        if (v3_9 != 3) {
                            v9_0 = v0_75;
                            int v11_1 = v1_2;
                            if (v3_9 != 1) {
                                int v0_2 = v6_8;
                                if (v3_9 != 2) {
                                    v1_2 = v11_1;
                                    v11_0 = v0_2;
                                    if ((v7_1[v16].f == null) || (v7_1[1].f == null)) {
                                        this.f(v8_1, v9_0, 0, v11_0, 0);
                                        v8_1.d.e.d(v8_1.o());
                                        v8_1.e.e.d(v8_1.i());
                                        v8_1.a = 1;
                                        v4_9 = v16;
                                        v2_1 = v19_3;
                                        v1_0 = v21;
                                        v3_4 = v22;
                                    }
                                } else {
                                    int v1_5 = v19_3[v16];
                                    if ((v1_5 != v11_1) && (v1_5 != v2_0)) {
                                        v1_2 = v11_1;
                                        v11_0 = v0_2;
                                    } else {
                                        this.f(v8_1, v11_1, ((int) ((v23 * ((float) p26.o())) + 1056964608)), v0_2, v8_1.i());
                                        v8_1.d.e.d(v8_1.o());
                                        v8_1.e.e.d(v8_1.i());
                                        v8_1.a = 1;
                                    }
                                }
                            } else {
                                this.f(v8_1, v9_0, 0, v6_8, 0);
                                v8_1.d.e.m = v8_1.o();
                            }
                        } else {
                            if (v6_8 == v0_75) {
                                this.f(v8_1, v0_75, 0, v0_75, 0);
                            }
                            int v12_12 = v8_1.i();
                            this.f(v8_1, v1_2, ((int) ((((float) v12_12) * v8_1.W) + 1056964608)), v1_2, v12_12);
                            v8_1.d.e.d(v8_1.o());
                            v8_1.e.e.d(v8_1.i());
                            v8_1.a = 1;
                        }
                    }
                    if ((v11_0 != v15_2) || ((v13 != v9_0) && (v13 != v1_2))) {
                        int v10_1 = v9_0;
                        int v6_5 = v11_0;
                        int v0_10 = 1;
                        int v9_2 = v1_2;
                        int v1_6 = v13;
                    } else {
                        if (v4_10 != 3) {
                            if (v4_10 != 1) {
                                v10_1 = v9_0;
                                int v9_4 = v13;
                                if (v4_10 != 2) {
                                    v9_2 = v1_2;
                                    v1_6 = v9_4;
                                    if ((v7_1[2].f == null) || (v7_1[3].f == null)) {
                                        this.f(v8_1, v10_1, 0, v11_0, 0);
                                        v8_1.d.e.d(v8_1.o());
                                        v8_1.e.e.d(v8_1.i());
                                        v8_1.a = 1;
                                    }
                                } else {
                                    int v6_7 = v19_3[1];
                                    if ((v6_7 != v1_2) && (v6_7 != v2_0)) {
                                        v9_2 = v1_2;
                                        v1_6 = v9_4;
                                    } else {
                                        this.f(v8_1, v9_4, v8_1.o(), v1_2, ((int) ((v14_6 * ((float) p26.i())) + 1056964608)));
                                        v8_1.d.e.d(v8_1.o());
                                        v8_1.e.e.d(v8_1.i());
                                        v8_1.a = 1;
                                    }
                                }
                                v6_5 = v11_0;
                                v0_10 = 1;
                            } else {
                                this.f(v8_1, v13, 0, v9_0, 0);
                                v8_1.e.e.m = v8_1.i();
                            }
                        } else {
                            if (v13 == v9_0) {
                                this.f(v8_1, v9_0, 0, v9_0, 0);
                            }
                            int v10_9 = v8_1.o();
                            int v0_45 = v8_1.W;
                            if (v8_1.X == -1) {
                                v0_45 = (1065353216 / v0_45);
                            }
                            this.f(v8_1, v1_2, v10_9, v1_2, ((int) ((((float) v10_9) * v0_45) + 1056964608)));
                            v8_1.d.e.d(v8_1.o());
                            v8_1.e.e.d(v8_1.i());
                            v8_1.a = 1;
                        }
                    }
                    if ((v1_6 == v15_2) && (v6_5 == v15_2)) {
                        if ((v3_9 != v0_10) && (v4_10 != v0_10)) {
                            if ((v4_10 == 2) && ((v3_9 == 2) && ((v19_3[v16] == v9_2) && (v19_3[v0_10] == v9_2)))) {
                                this.f(v8_1, v9_2, ((int) ((v23 * ((float) p26.o())) + 1056964608)), v9_2, ((int) ((v14_6 * ((float) p26.i())) + 1056964608)));
                                v8_1.d.e.d(v8_1.o());
                                v8_1.e.e.d(v8_1.i());
                                v8_1.a = 1;
                            }
                        } else {
                            int v9_6 = v10_1;
                            this.f(v8_1, v9_6, 0, v9_6, 0);
                            v8_1.d.e.m = v8_1.o();
                            v8_1.e.e.m = v8_1.i();
                        }
                    }
                } else {
                    int v0_66 = v1_2;
                    int v1_28 = v13;
                    int v3_1 = v8_1.o();
                    if (v1_28 == v2_0) {
                        v3_1 = ((p26.o() - v12_2.g) - v11_2.g);
                        v1_28 = v0_66;
                    }
                    int v11_13;
                    float v4_6 = v8_1.i();
                    if (v6_8 != v2_0) {
                        v11_13 = v6_8;
                    } else {
                        v4_6 = ((p26.i() - v10_2.g) - v9_3.g);
                        v11_13 = v0_66;
                    }
                    this.f(v8_1, v1_28, v3_1, v11_13, v4_6);
                    v8_1.d.e.d(v8_1.o());
                    v8_1.e.e.d(v8_1.i());
                    v8_1.a = 1;
                }
            } else {
                v8_1.a = 1;
                v4_9 = v16;
            }
        }
        return;
    }

    public void c()
    {
        androidx.constraintlayout.core.widgets.analyzer.e v0_1 = ((x.e) this.d);
        java.util.ArrayList v1_1 = ((java.util.ArrayList) this.i);
        androidx.constraintlayout.core.widgets.analyzer.d v2_2 = ((java.util.ArrayList) this.f);
        v2_2.clear();
        x.e v3_1 = ((x.e) this.e);
        v3_1.d.f();
        v3_1.e.f();
        v2_2.add(v3_1.d);
        v2_2.add(v3_1.e);
        int v4_3 = v3_1.p0;
        int v5_0 = v4_3.size();
        java.util.HashSet v6_0 = 0;
        x.d v8_0 = 0;
        while (v8_0 < v5_0) {
            int v10_2 = v4_3.get(v8_0);
            v8_0++;
            int v10_3 = ((x.d) v10_2);
            if (!(v10_3 instanceof x.f)) {
                if (!v10_3.v()) {
                    v2_2.add(v10_3.d);
                } else {
                    if (v10_3.b == null) {
                        v10_3.b = new y.c(v10_3, 0);
                    }
                    if (v6_0 == null) {
                        v6_0 = new java.util.HashSet();
                    }
                    v6_0.add(v10_3.b);
                }
                if (!v10_3.w()) {
                    v2_2.add(v10_3.e);
                } else {
                    if (v10_3.c == null) {
                        v10_3.c = new y.c(v10_3, 1);
                    }
                    if (v6_0 == null) {
                        v6_0 = new java.util.HashSet();
                    }
                    v6_0.add(v10_3.c);
                }
                if ((v10_3 instanceof x.a)) {
                    v2_2.add(new androidx.constraintlayout.core.widgets.analyzer.c(v10_3));
                }
            } else {
                androidx.constraintlayout.core.widgets.analyzer.c v9_7 = new y.f(v10_3);
                v10_3.d.f();
                v10_3.e.f();
                v9_7.f = ((x.f) v10_3).t0;
                v2_2.add(v9_7);
            }
        }
        if (v6_0 != null) {
            v2_2.addAll(v6_0);
        }
        int v4_4 = v2_2.size();
        int v5_1 = 0;
        while (v5_1 < v4_4) {
            java.util.HashSet v6_3 = v2_2.get(v5_1);
            v5_1++;
            ((androidx.constraintlayout.core.widgets.analyzer.f) v6_3).f();
        }
        int v4_5 = v2_2.size();
        int v5_2 = 0;
        while (v5_2 < v4_5) {
            java.util.HashSet v6_1 = v2_2.get(v5_2);
            v5_2++;
            java.util.HashSet v6_2 = ((androidx.constraintlayout.core.widgets.analyzer.f) v6_1);
            if (v6_2.b != v3_1) {
                v6_2.d();
            }
        }
        v1_1.clear();
        this.e(v0_1.d, 0, v1_1);
        this.e(v0_1.e, 1, v1_1);
        this.b = 0;
        return;
    }

    public int d(x.e p20, int p21)
    {
        long v0_0 = p20;
        long v3_4 = ((java.util.ArrayList) this.i);
        int v4_5 = v3_4.size();
        float v5_4 = 0;
        int v7 = 0;
        long v8 = 0;
        while (v7 < v4_5) {
            long v0_11;
            int v18;
            java.util.ArrayList v17;
            long v10_5 = ((y.g) v3_4.get(v7)).a;
            if (!(v10_5 instanceof y.c)) {
                if (p21 != 0) {
                    if ((v10_5 instanceof androidx.constraintlayout.core.widgets.analyzer.e)) {
                        long v11_6;
                        if (p21 != 0) {
                            v11_6 = v0_0.e;
                        } else {
                            v11_6 = v0_0.d;
                        }
                        boolean v12_0;
                        if (p21 != 0) {
                            v12_0 = v0_0.e;
                        } else {
                            v12_0 = v0_0.d;
                        }
                        boolean v12_1 = v12_0.i;
                        androidx.constraintlayout.core.widgets.analyzer.a v13 = v10_5.h;
                        androidx.constraintlayout.core.widgets.analyzer.a v14 = v10_5.i;
                        long v11_8 = v13.l.contains(v11_6.h);
                        boolean v12_2 = v14.l.contains(v12_1);
                        long v15_2 = v10_5.j();
                        if ((v11_8 == 0) || (!v12_2)) {
                            v17 = v3_4;
                            v18 = v4_5;
                            if (v11_8 == 0) {
                                if (!v12_2) {
                                    v0_11 = ((v10_5.j() + ((long) v13.f)) - ((long) v14.f));
                                } else {
                                    v0_11 = Math.max((- y.g.a(v14, ((long) v14.f))), (((long) (- v14.f)) + v15_2));
                                }
                            } else {
                                v0_11 = Math.max(y.g.b(v13, ((long) v13.f)), (((long) v13.f) + v15_2));
                            }
                        } else {
                            long v11_9 = y.g.b(v13, v5_4);
                            long v0_23 = y.g.a(v14, v5_4);
                            long v11_10 = (v11_9 - v15_2);
                            float v5_5 = v14.f;
                            v17 = v3_4;
                            v18 = v4_5;
                            if (v11_10 >= ((long) (- v5_5))) {
                                v11_10 += ((long) v5_5);
                            }
                            long v3_19 = ((long) v13.f);
                            long v0_1 = (((- v0_23) - v15_2) - v3_19);
                            if (v0_1 >= v3_19) {
                                v0_1 -= v3_19;
                            }
                            long v3_1;
                            long v3_0 = v10_5.b;
                            if (p21 != 0) {
                                if (p21 != 1) {
                                    v3_0.getClass();
                                    v3_1 = -1082130432;
                                } else {
                                    v3_1 = v3_0.e0;
                                }
                            } else {
                                v3_1 = v3_0.d0;
                            }
                            long v0_3;
                            if (v3_1 <= 0) {
                                v0_3 = 0;
                            } else {
                                v0_3 = ((long) ((((float) v11_10) / (1065353216 - v3_1)) + (((float) v0_1) / v3_1)));
                            }
                            long v0_6 = ((float) v0_3);
                            v0_11 = ((((long) v13.f) + ((((long) ((v0_6 * v3_1) + 1056964608)) + v15_2) + ((long) (((1065353216 - v3_1) * v0_6) + 1056964608)))) - ((long) v14.f));
                        }
                    } else {
                        v17 = v3_4;
                        v18 = v4_5;
                        v0_11 = v5_4;
                    }
                } else {
                    if ((v10_5 instanceof androidx.constraintlayout.core.widgets.analyzer.d)) {
                    }
                }
            } else {
                if (((y.c) v10_5).f == p21) {
                }
            }
            v8 = Math.max(v8, v0_11);
            v7++;
            v0_0 = p20;
            v3_4 = v17;
            v4_5 = v18;
            v5_4 = 0;
        }
        return ((int) v8);
    }

    public void e(androidx.constraintlayout.core.widgets.analyzer.f p9, int p10, java.util.ArrayList p11)
    {
        androidx.constraintlayout.core.widgets.analyzer.a v1_0 = p9.i;
        int v0_2 = p9.h.k;
        boolean v2_2 = v0_2.size();
        int v3 = 0;
        androidx.constraintlayout.core.widgets.analyzer.a v4_5 = 0;
        while (v4_5 < v2_2) {
            boolean v6_2 = v0_2.get(v4_5);
            v4_5++;
            boolean v6_3 = ((y.d) v6_2);
            if (!(v6_3 instanceof androidx.constraintlayout.core.widgets.analyzer.a)) {
                if ((v6_3 instanceof androidx.constraintlayout.core.widgets.analyzer.f)) {
                    this.a(((androidx.constraintlayout.core.widgets.analyzer.f) v6_3).h, p10, p11, 0);
                }
            } else {
                this.a(((androidx.constraintlayout.core.widgets.analyzer.a) v6_3), p10, p11, 0);
            }
        }
        int v0_4 = v1_0.k;
        androidx.constraintlayout.core.widgets.analyzer.a v1_1 = v0_4.size();
        boolean v2_0 = 0;
        while (v2_0 < v1_1) {
            androidx.constraintlayout.core.widgets.analyzer.a v4_0 = v0_4.get(v2_0);
            v2_0++;
            androidx.constraintlayout.core.widgets.analyzer.a v4_1 = ((y.d) v4_0);
            if (!(v4_1 instanceof androidx.constraintlayout.core.widgets.analyzer.a)) {
                if ((v4_1 instanceof androidx.constraintlayout.core.widgets.analyzer.f)) {
                    this.a(((androidx.constraintlayout.core.widgets.analyzer.f) v4_1).i, p10, p11, 0);
                }
            } else {
                this.a(((androidx.constraintlayout.core.widgets.analyzer.a) v4_1), p10, p11, 0);
            }
        }
        if (p10 == 1) {
            java.util.ArrayList v9_3 = ((androidx.constraintlayout.core.widgets.analyzer.e) p9).k.k;
            int v0_3 = v9_3.size();
            while (v3 < v0_3) {
                androidx.constraintlayout.core.widgets.analyzer.a v1_2 = v9_3.get(v3);
                v3++;
                androidx.constraintlayout.core.widgets.analyzer.a v1_3 = ((y.d) v1_2);
                if ((v1_3 instanceof androidx.constraintlayout.core.widgets.analyzer.a)) {
                    this.a(((androidx.constraintlayout.core.widgets.analyzer.a) v1_3), p10, p11, 0);
                }
            }
        }
        return;
    }

    public void f(x.d p2, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour p3, int p4, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour p5, int p6)
    {
        int v3_4;
        y.b v0_1 = ((y.b) this.h);
        v0_1.a = p3;
        v0_1.b = p5;
        v0_1.c = p4;
        v0_1.d = p6;
        ((a0.f) this.g).b(p2, v0_1);
        p2.K(v0_1.e);
        p2.H(v0_1.f);
        p2.E = v0_1.h;
        int v3_3 = v0_1.g;
        p2.a0 = v3_3;
        if (v3_3 <= 0) {
            v3_4 = 0;
        } else {
            v3_4 = 1;
        }
        p2.E = v3_4;
        return;
    }

    public void g()
    {
        androidx.constraintlayout.core.widgets.analyzer.b v0_0 = this;
        java.util.ArrayList v6 = ((x.e) this.d).p0;
        int v7 = v6.size();
        int v8_1 = 0;
        int v1_4 = 0;
        while (v1_4 < v7) {
            int v9 = (v1_4 + 1);
            int v1_2 = ((x.d) v6.get(v1_4));
            if (!v1_2.a) {
                int v2_4;
                int v2_2 = v1_2.S;
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour v10 = v2_2[v8_1];
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour v12 = v2_2[1];
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour v13 = androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour.i;
                int v4_0 = androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour.h;
                if ((v10 != v4_0) && ((v10 != v13) || (v1_2.r != 1))) {
                    v2_4 = v8_1;
                } else {
                    v2_4 = 1;
                }
                if ((v12 != v4_0) && ((v12 != v13) || (v1_2.s != 1))) {
                    int v3_1 = v8_1;
                } else {
                    v3_1 = 1;
                }
                int v5_1 = v1_2.d.e;
                boolean v14 = v5_1.j;
                androidx.constraintlayout.core.widgets.analyzer.b v15_1 = v1_2.e.e;
                int v8_0 = v15_1.j;
                int v2_5 = androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour.g;
                if ((!v14) || (v8_0 == 0)) {
                    if ((!v14) || (v3_1 == 0)) {
                        if ((v8_0 != 0) && (v2_4 != 0)) {
                            this.f(v1_2, v4_0, v5_1.g, v2_5, v15_1.g);
                            androidx.constraintlayout.core.widgets.analyzer.b v0_3 = v1_2.d;
                            if (v10 != v13) {
                                v0_3.e.d(v1_2.o());
                                v1_2.a = 1;
                            } else {
                                v0_3.e.m = v1_2.o();
                            }
                        }
                    } else {
                        this.f(v1_2, v2_5, v5_1.g, v4_0, v15_1.g);
                        androidx.constraintlayout.core.widgets.analyzer.b v0_7 = v1_2.e;
                        if (v12 != v13) {
                            v0_7.e.d(v1_2.i());
                            v1_2.a = 1;
                        } else {
                            v0_7.e.m = v1_2.i();
                        }
                    }
                } else {
                    v0_0.f(v1_2, v2_5, v5_1.g, v2_5, v15_1.g);
                    v1_2.a = 1;
                }
                if (v1_2.a) {
                    androidx.constraintlayout.core.widgets.analyzer.b v0_12 = v1_2.e.l;
                    if (v0_12 != null) {
                        v0_12.d(v1_2.a0);
                    }
                }
                v8_1 = 0;
                v0_0 = this;
            }
            v1_4 = v9;
        }
        return;
    }

    public String toString()
    {
        switch (this.a) {
            case 0:
                String v0_2 = ((java.util.Map) this.i);
                StringBuilder v1_1 = ((Long) this.h);
                String v2_5 = ((Long) this.g);
                long v3_6 = ((Long) this.f);
                String v4_1 = ((Long) this.e);
                java.util.ArrayList v5_1 = new java.util.ArrayList();
                if (this.b) {
                    v5_1.add("isRegularFile");
                }
                if (this.c) {
                    v5_1.add("isDirectory");
                }
                if (v4_1 != null) {
                    String v6_5 = new StringBuilder("byteCount=");
                    v6_5.append(v4_1.longValue());
                    v5_1.add(v6_5.toString());
                }
                if (v3_6 != 0) {
                    String v4_4 = new StringBuilder("createdAt=");
                    v4_4.append(v3_6.longValue());
                    v5_1.add(v4_4.toString());
                }
                if (v2_5 != null) {
                    long v3_2 = new StringBuilder("lastModifiedAt=");
                    v3_2.append(v2_5.longValue());
                    v5_1.add(v3_2.toString());
                }
                if (v1_1 != null) {
                    String v2_2 = new StringBuilder("lastAccessedAt=");
                    v2_2.append(v1_1.longValue());
                    v5_1.add(v2_2.toString());
                }
                if (!v0_2.isEmpty()) {
                    StringBuilder v1_5 = new StringBuilder("extras=");
                    v1_5.append(v0_2);
                    v5_1.add(v1_5.toString());
                }
                return ha.j.I(v5_1, ", ", "FileMetadata(", ")", 0, 56);
            default:
                return super.toString();
        }
    }
}
