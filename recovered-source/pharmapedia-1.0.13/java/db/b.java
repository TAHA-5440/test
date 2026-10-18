// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package db;
public final class b implements java.util.Iterator, va.a {
    public int g;
    public int h;
    public int i;
    public ab.c j;
    public int k;
    public final synthetic db.c l;

    public b(db.c p3)
    {
        this.l = p3;
        this.g = -1;
        int v3_3 = p3.a.length();
        if (v3_3 < 0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u(r1.a.h(v3_3, "Cannot coerce value to an empty range: maximum ", " is less than minimum 0."));
            throw 0;
        } else {
            if (v3_3 >= 0) {
                v3_3 = 0;
            }
            this.h = v3_3;
            this.i = v3_3;
            return;
        }
    }

    public final void a()
    {
        int v0_0 = this.l;
        int v1_0 = v0_0.a;
        ab.c v2_2 = this.i;
        int v3 = 0;
        if (v2_2 >= null) {
            int v4_1 = v0_0.b;
            int v6 = 1;
            if (v4_1 <= 0) {
                if (v2_2 <= v1_0.length()) {
                    int v0_3 = ((kotlin.Pair) v0_0.c.invoke(v1_0, Integer.valueOf(this.i)));
                    if (v0_3 != 0) {
                        int v1_3 = ((Number) v0_3.g).intValue();
                        int v0_6 = ((Number) v0_3.h).intValue();
                        this.j = com.bumptech.glide.d.C(this.h, v1_3);
                        int v1_4 = (v1_3 + v0_6);
                        this.h = v1_4;
                        if (v0_6 == 0) {
                            v3 = 1;
                        }
                        this.i = (v1_4 + v3);
                    } else {
                        ab.c v2_5 = this.h;
                        v1_0.getClass();
                        this.j = new ab.c(v2_5, (v1_0.length() - v6), v6);
                        this.i = -1;
                    }
                } else {
                    ab.c v2_6 = this.h;
                    v1_0.getClass();
                    this.j = new ab.c(v2_6, (v1_0.length() - v6), v6);
                    this.i = -1;
                }
            } else {
                int v7_0 = (this.k + 1);
                this.k = v7_0;
                if (v7_0 >= v4_1) {
                }
            }
            this.g = 1;
            return;
        } else {
            this.g = 0;
            this.j = 0;
            return;
        }
    }

    public final boolean hasNext()
    {
        if (this.g == -1) {
            this.a();
        }
        if (this.g != 1) {
            return 0;
        } else {
            return 1;
        }
    }

    public final Object next()
    {
        if (this.g == -1) {
            this.a();
        }
        if (this.g == 0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.c();
            return 0;
        } else {
            int v0_3 = this.j;
            v0_3.getClass();
            this.j = 0;
            this.g = -1;
            return v0_3;
        }
    }

    public final void remove()
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
