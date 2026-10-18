// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package pc;
public final class i extends oc.o {
    public static final oc.w k;
    public final ClassLoader h;
    public final oc.o i;
    public final ga.e j;

    static i()
    {
        pc.i.k = ea.c.u("/");
        return;
    }

    public i(ClassLoader p2)
    {
        int v0_0 = oc.o.g;
        v0_0.getClass();
        this.h = p2;
        this.i = v0_0;
        this.j = kotlin.a.b(new androidx.activity.e(this, 7));
        return;
    }

    public final void B(oc.w p3)
    {
        p3.getClass();
        String v0_1 = new StringBuilder();
        v0_1.append(this);
        v0_1.append(" is read-only");
        throw new java.io.IOException(v0_1.toString());
    }

    public final java.util.List M(oc.w p17)
    {
        String v1_0 = pc.i.k;
        v1_0.getClass();
        String v3_0 = pc.c.b(v1_0, p17, 1).c(v1_0).g.t();
        java.util.LinkedHashSet v4_1 = new java.util.LinkedHashSet();
        java.util.Iterator v6_3 = ((java.util.List) this.j.getValue()).iterator();
        int v8 = 0;
        while (v6_3.hasNext()) {
            oc.w v9_2 = ((kotlin.Pair) v6_3.next());
            oc.w v9_4 = ((oc.w) v9_2.h);
            java.util.ArrayList v10_2 = ((oc.o) v9_2.g).M(v9_4.d(v3_0));
            java.util.ArrayList v11_2 = new java.util.ArrayList();
            java.util.ArrayList v10_3 = v10_2.iterator();
            while (v10_3.hasNext()) {
                int v12_4 = v10_3.next();
                if (pc.h.c(((oc.w) v12_4))) {
                    v11_2.add(v12_4);
                }
            }
            java.util.ArrayList v10_5 = new java.util.ArrayList(ha.l.y(v11_2, 10));
            int v12_3 = v11_2.size();
            int v13_0 = 0;
            while (v13_0 < v12_3) {
                String v14_0 = v11_2.get(v13_0);
                v13_0++;
                String v14_1 = ((oc.w) v14_0);
                v14_1.getClass();
                int v2_2 = db.i.g0(v14_1.g.t(), v9_4.g.t()).replace(92, 47);
                v2_2.getClass();
                v10_5.add(v1_0.d(v2_2));
            }
            ha.j.A(v10_5, v4_1);
            v8 = 1;
        }
        if (v8 == 0) {
            oc.l.l(p17, "file not found: ");
            return 0;
        } else {
            return ha.j.U(v4_1);
        }
    }

    public final oc.n Z(oc.w p4)
    {
        p4.getClass();
        if (pc.h.c(p4)) {
            java.util.Iterator v0_5 = pc.i.k;
            v0_5.getClass();
            int v4_3 = pc.c.b(v0_5, p4, 1).c(v0_5).g.t();
            java.util.Iterator v0_3 = ((java.util.List) this.j.getValue()).iterator();
            while (v0_3.hasNext()) {
                oc.n v1_2 = ((kotlin.Pair) v0_3.next());
                oc.n v1_6 = ((oc.o) v1_2.g).Z(((oc.w) v1_2.h).d(v4_3));
                if (v1_6 != null) {
                    return v1_6;
                }
            }
        }
        return 0;
    }

    public final oc.g c0(oc.w p6)
    {
        if (!pc.h.c(p6)) {
            oc.l.l(p6, "file not found: ");
        } else {
            String v0_4 = pc.i.k;
            v0_4.getClass();
            String v0_3 = pc.c.b(v0_4, p6, 1).c(v0_4).g.t();
            java.util.Iterator v2_3 = ((java.util.List) this.j.getValue()).iterator();
            while (v2_3.hasNext()) {
                oc.w v3_2 = ((kotlin.Pair) v2_3.next());
                p6 = ((oc.o) v3_2.g).c0(((oc.w) v3_2.h).d(v0_3));
                return p6;
            }
            oc.l.l(p6, "file not found: ");
        }
        return 0;
    }

    public final oc.b0 d(oc.w p3)
    {
        p3.getClass();
        String v0_1 = new StringBuilder();
        v0_1.append(this);
        v0_1.append(" is read-only");
        throw new java.io.IOException(v0_1.toString());
    }

    public final oc.b0 d0(oc.w p3)
    {
        p3.getClass();
        String v0_1 = new StringBuilder();
        v0_1.append(this);
        v0_1.append(" is read-only");
        throw new java.io.IOException(v0_1.toString());
    }

    public final oc.d0 e0(oc.w p5)
    {
        p5.getClass();
        if (!pc.h.c(p5)) {
            oc.l.l(p5, "file not found: ");
            return 0;
        } else {
            java.net.JarURLConnection v0_8 = pc.i.k;
            v0_8.getClass();
            java.net.JarURLConnection v0_4 = this.h.getResource(pc.c.b(v0_8, p5, 0).c(v0_8).g.t());
            if (v0_4 == null) {
                oc.l.l(p5, "file not found: ");
                return 0;
            } else {
                oc.d v5_2 = v0_4.openConnection();
                if ((v5_2 instanceof java.net.JarURLConnection)) {
                    ((java.net.JarURLConnection) v5_2).setUseCaches(0);
                }
                oc.d v5_3 = v5_2.getInputStream();
                v5_3.getClass();
                return oc.b.g(v5_3);
            }
        }
    }

    public final void h(oc.w p2, oc.w p3)
    {
        p2.getClass();
        p3.getClass();
        String v3_2 = new StringBuilder();
        v3_2.append(this);
        v3_2.append(" is read-only");
        throw new java.io.IOException(v3_2.toString());
    }

    public final void i(oc.w p3)
    {
        p3.getClass();
        String v0_1 = new StringBuilder();
        v0_1.append(this);
        v0_1.append(" is read-only");
        throw new java.io.IOException(v0_1.toString());
    }
}
