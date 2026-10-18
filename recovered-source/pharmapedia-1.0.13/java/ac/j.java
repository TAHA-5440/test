// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ac;
public final class j extends oc.o {
    public final oc.o h;

    public j(oc.o p1)
    {
        p1.getClass();
        this.h = p1;
        return;
    }

    public final void B(oc.w p2)
    {
        p2.getClass();
        this.h.B(p2);
        return;
    }

    public final java.util.List M(oc.w p3)
    {
        java.util.Iterator v3_1 = this.h.M(p3);
        java.util.ArrayList v0_2 = new java.util.ArrayList();
        java.util.Iterator v3_2 = v3_1.iterator();
        while (v3_2.hasNext()) {
            oc.w v1_1 = ((oc.w) v3_2.next());
            v1_1.getClass();
            v0_2.add(v1_1);
        }
        ha.n.z(v0_2);
        return v0_2;
    }

    public final oc.n Z(oc.w p11)
    {
        p11.getClass();
        Object v11_2 = this.h.Z(p11);
        if (v11_2 != null) {
            oc.w v4_1 = ((oc.w) v11_2.d);
            if (v4_1 != null) {
                boolean v2 = v11_2.b;
                boolean v3 = v11_2.c;
                Long v5_1 = ((Long) v11_2.e);
                Long v6_1 = ((Long) v11_2.f);
                Long v7_1 = ((Long) v11_2.g);
                Long v8_1 = ((Long) v11_2.h);
                java.util.Map v9_1 = ((java.util.Map) v11_2.i);
                v9_1.getClass();
                return new oc.n(v2, v3, v4_1, v5_1, v6_1, v7_1, v8_1, v9_1);
            } else {
                return v11_2;
            }
        } else {
            return 0;
        }
    }

    public final oc.g c0(oc.w p2)
    {
        return this.h.c0(p2);
    }

    public final void close()
    {
        this.h.close();
        return;
    }

    public final oc.b0 d(oc.w p2)
    {
        p2.getClass();
        return this.h.d(p2);
    }

    public final oc.b0 d0(oc.w p4)
    {
        p4.getClass();
        oc.w v0_2 = p4.b();
        if (v0_2 != null) {
            oc.w v1_4 = new ha.h();
            while ((v0_2 != null) && (!this.L(v0_2))) {
                v1_4.addFirst(v0_2);
                v0_2 = v0_2.b();
            }
            oc.w v0_0 = v1_4.iterator();
            while (v0_0.hasNext()) {
                this.i(((oc.w) v0_0.next()));
            }
        }
        return this.h.d0(p4);
    }

    public final oc.d0 e0(oc.w p2)
    {
        p2.getClass();
        return this.h.e0(p2);
    }

    public final void h(oc.w p2, oc.w p3)
    {
        p2.getClass();
        p3.getClass();
        this.h.h(p2, p3);
        return;
    }

    public final void i(oc.w p2)
    {
        p2.getClass();
        this.h.i(p2);
        return;
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder();
        v0_1.append(kotlin.jvm.internal.h.a(ac.j).c());
        v0_1.append(40);
        v0_1.append(this.h);
        v0_1.append(41);
        return v0_1.toString();
    }
}
