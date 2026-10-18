// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ac;
public final class e {
    public final synthetic int a;
    public boolean b;
    public final Object c;
    public final Object d;
    public Object e;

    public e(ac.k p2, ac.g p3)
    {
        boolean[] v2_1;
        this.a = 0;
        this.e = p2;
        this.c = p3;
        if (!p3.e) {
            p2.getClass();
            v2_1 = new boolean[2];
        } else {
            v2_1 = 0;
        }
        this.d = v2_1;
        return;
    }

    public e(g7.z p3, l3.n p4)
    {
        this.a = 1;
        this.e = new f7.a(this, 1);
        this.d = p3;
        this.c = p4;
        return;
    }

    public e(String p3)
    {
        this.a = 2;
        int v0_2 = new androidx.lifecycle.j(25);
        this.d = v0_2;
        this.e = v0_2;
        this.b = 0;
        this.c = p3;
        return;
    }

    public e(u2.d p2, u2.c p3)
    {
        boolean[] v2_2;
        this.a = 3;
        this.e = p2;
        this.c = p3;
        if (!p3.e) {
            v2_2 = new boolean[p2.m];
        } else {
            v2_2 = 0;
        }
        this.d = v2_2;
        return;
    }

    public void a()
    {
        switch (this.a) {
            case 0:
                if (this.b) {
                    throw new IllegalStateException("Check failed.");
                } else {
                    if (kotlin.jvm.internal.f.a(((ac.g) this.c).g, this)) {
                        ((ac.k) this.e).h(this, 0);
                    }
                    this.b = 1;
                    return;
                }
            default:
                u2.d.d(((u2.d) this.e), this, 0);
                return;
        }
    }

    public void b(Object p3, String p4)
    {
        androidx.lifecycle.j v0_1 = new androidx.lifecycle.j(25);
        ((androidx.lifecycle.j) this.e).j = v0_1;
        this.e = v0_1;
        v0_1.i = p3;
        v0_1.h = p4;
        return;
    }

    public void c(String p1, long p2)
    {
        this.e(p1, String.valueOf(p2));
        return;
    }

    public void d(String p1, boolean p2)
    {
        this.e(p1, String.valueOf(p2));
        return;
    }

    public void e(String p3, String p4)
    {
        t5.g v0_1 = new t5.g(25);
        ((androidx.lifecycle.j) this.e).j = v0_1;
        this.e = v0_1;
        v0_1.i = p4;
        v0_1.h = p3;
        return;
    }

    public void f()
    {
        if (this.b) {
            throw new IllegalStateException("Check failed.");
        } else {
            if (kotlin.jvm.internal.f.a(((ac.g) this.c).g, this)) {
                ((ac.k) this.e).h(this, 1);
            }
            this.b = 1;
            return;
        }
    }

    public void g()
    {
        int v0_1 = ((ac.g) this.c);
        if (kotlin.jvm.internal.f.a(v0_1.g, this)) {
            int v1_4 = ((ac.k) this.e);
            if (!v1_4.r) {
                v0_1.f = 1;
            } else {
                v1_4.h(this, 0);
                return;
            }
        }
        return;
    }

    public java.io.File h()
    {
        java.io.File v1_3 = ((u2.c) this.c);
        if (v1_3.f != this) {
            throw new IllegalStateException();
        } else {
            if (!v1_3.e) {
                ((boolean[]) this.d)[0] = 1;
            }
            java.io.File v1_0 = v1_3.b(0);
            ((u2.d) this.e).g.mkdirs();
            return v1_0;
        }
    }

    public oc.b0 i(int p5)
    {
        ac.k v0_1 = ((ac.k) this.e);
        if (this.b) {
            throw new IllegalStateException("Check failed.");
        } else {
            if (kotlin.jvm.internal.f.a(((ac.g) this.c).g, this)) {
                if (!((ac.g) this.c).e) {
                    ac.l v1_6 = ((boolean[]) this.d);
                    v1_6.getClass();
                    v1_6[p5] = 1;
                }
                oc.f v5_2 = ((oc.w) ((ac.g) this.c).d.get(p5));
                ac.l v1_11 = v0_1.h;
                v1_11.getClass();
                v5_2.getClass();
                return new ac.l(v1_11.d0(v5_2), new ac.d(0, v0_1, this));
            } else {
                return new oc.f();
            }
        }
    }

    public String toString()
    {
        switch (this.a) {
            case 2:
                String v0_2 = this.b;
                StringBuilder v1_1 = new StringBuilder(32);
                v1_1.append(((String) this.c));
                v1_1.append(123);
                androidx.lifecycle.j v2_3 = ((androidx.lifecycle.j) ((androidx.lifecycle.j) this.d).j);
                String v3_0 = "";
                while (v2_3 != null) {
                    int v4_0 = v2_3.i;
                    if (((v2_3 instanceof t5.g)) || ((v4_0 != 0) || (v0_2 == null))) {
                        v1_1.append(v3_0);
                        String v3_2 = ((String) v2_3.h);
                        if (v3_2 != null) {
                            v1_1.append(v3_2);
                            v1_1.append(61);
                        }
                        if ((v4_0 == 0) || (!v4_0.getClass().isArray())) {
                            v1_1.append(v4_0);
                        } else {
                            String v3_7 = java.util.Arrays.deepToString(new Object[] {v4_0}));
                            v1_1.append(v3_7, 1, (v3_7.length() - 1));
                        }
                        v3_0 = ", ";
                    }
                    v2_3 = ((androidx.lifecycle.j) v2_3.j);
                }
                v1_1.append(125);
                return v1_1.toString();
            default:
                return super.toString();
        }
    }
}
