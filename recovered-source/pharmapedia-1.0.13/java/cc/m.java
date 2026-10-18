// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cc;
public final class m implements cc.j {
    public final cc.y a;
    public final bc.d b;
    public long c;
    public final java.util.concurrent.CopyOnWriteArrayList d;
    public final java.util.concurrent.LinkedBlockingDeque e;

    public m(cc.y p1, bc.d p2)
    {
        p2.getClass();
        this.a = p1;
        this.b = p2;
        this.c = -9223372036854775808;
        this.d = new java.util.concurrent.CopyOnWriteArrayList();
        this.e = new java.util.concurrent.LinkedBlockingDeque();
        return;
    }

    public final void a()
    {
        java.util.concurrent.CopyOnWriteArrayList v0 = this.d;
        java.util.Iterator v1 = v0.iterator();
        v1.getClass();
        while (v1.hasNext()) {
            cc.x v2_1 = ((cc.x) v1.next());
            v2_1.cancel();
            cc.x v2_2 = v2_1.c();
            if (v2_2 != null) {
                this.a.g().addLast(v2_2);
            }
        }
        v0.clear();
        return;
    }

    public final cc.s b()
    {
        cc.s v0_0 = this.d;
        java.io.IOException v2 = 0;
        try {
            do {
                ha.h v4_0 = this.a;
            } while(cc.x v3_9 == null);
            v4_0.g().addFirst(v3_9);
        } catch (cc.s v0_5) {
            this.a();
            throw v0_5;
        }
        if ((v0_0.isEmpty()) && (!v4_0.a(0))) {
            this.a();
            v2.getClass();
            throw v2;
        } else {
            if (v4_0.e()) {
                throw new java.io.IOException("Canceled");
            } else {
                cc.x v3_4;
                java.io.IOException v5_0 = System.nanoTime();
                int v7_1 = (this.c - v5_0);
                if (v0_0.isEmpty()) {
                    v3_4 = this.d();
                    v7_1 = 250000000;
                    this.c = (v5_0 + 250000000);
                } else {
                    if (v7_1 > 0) {
                        v3_4 = 0;
                    } else {
                    }
                }
                if (v3_4 == null) {
                    if (!v0_0.isEmpty()) {
                        v3_4 = ((cc.w) this.e.poll(v7_1, java.util.concurrent.TimeUnit.NANOSECONDS));
                        if (v3_4 != null) {
                            v0_0.remove(v3_4.a);
                        } else {
                            v3_4 = 0;
                        }
                    }
                    if (v3_4 == null) {
                    }
                }
                boolean v6_2;
                java.io.IOException v5_5 = v3_4.a;
                int v7_2 = 0;
                if ((v3_4.b != null) || (v3_4.c != null)) {
                    v6_2 = 0;
                } else {
                    v6_2 = 1;
                }
                if (v6_2) {
                    this.a();
                    if (!v5_5.b()) {
                        v3_4 = v5_5.g();
                    }
                    if ((v3_4.b == null) && (v3_4.c == null)) {
                        v7_2 = 1;
                    }
                    if (v7_2 != 0) {
                        cc.s v0_4 = v3_4.a.d();
                        this.a();
                        return v0_4;
                    }
                }
                java.io.IOException v5_8 = v3_4.c;
                if (v5_8 != null) {
                    if (!(v5_8 instanceof java.io.IOException)) {
                        throw v5_8;
                    } else {
                        if (v2 != null) {
                            com.bumptech.glide.i.d(v2, v5_8);
                        } else {
                            v2 = ((java.io.IOException) v5_8);
                        }
                    }
                }
                v3_9 = v3_4.b;
                if (v3_9 != null) {
                }
            }
        }
    }

    public final cc.y c()
    {
        return this.a;
    }

    public final cc.w d()
    {
        String v0_0 = this.a;
        if (v0_0.a(0)) {
            try {
                cc.k v2_0 = v0_0.h();
            } catch (cc.k v2_3) {
                v2_0 = new cc.k(v2_3);
            }
            if (!v2_0.b()) {
                if (!(v2_0 instanceof cc.k)) {
                    this.d.add(v2_0);
                    bc.b v3_4 = new StringBuilder();
                    v3_4.append(zb.e.b);
                    v3_4.append(" connect ");
                    v3_4.append(v0_0.d().h.h());
                    this.b.d().d(new cc.l(v3_4.toString(), v2_0, this), 0);
                } else {
                    return ((cc.k) v2_0).a;
                }
            } else {
                return new cc.w(v2_0, 0, 6);
            }
        }
        return 0;
    }
}
