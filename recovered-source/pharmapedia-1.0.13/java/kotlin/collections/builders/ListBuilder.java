// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.collections.builders;
public final class ListBuilder extends ha.e implements java.util.List, java.util.RandomAccess, java.io.Serializable {
    public static final kotlin.collections.builders.ListBuilder j;
    public Object[] g;
    public int h;
    public boolean i;

    static ListBuilder()
    {
        kotlin.collections.builders.ListBuilder v0_1 = new kotlin.collections.builders.ListBuilder(0);
        v0_1.i = 1;
        kotlin.collections.builders.ListBuilder.j = v0_1;
        return;
    }

    public ListBuilder(int p1)
    {
        if (p1 < 0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("capacity must be non-negative.");
            throw 0;
        } else {
            int v1_3 = new Object[p1];
            this.g = v1_3;
            return;
        }
    }

    public static final synthetic int c(kotlin.collections.builders.ListBuilder p0)
    {
        return p0.modCount;
    }

    private final Object writeReplace()
    {
        if (!this.i) {
            throw new java.io.NotSerializableException("The list cannot be serialized while it is being built.");
        } else {
            return new kotlin.collections.builders.SerializedCollection(this, 0);
        }
    }

    public final int a()
    {
        return this.h;
    }

    public final void add(int p3, Object p4)
    {
        this.g();
        Object[] v0_0 = this.h;
        if ((p3 < null) || (p3 > v0_0)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.l("index: ", ", size: ", p3, v0_0));
            return;
        } else {
            this.modCount = (this.modCount + 1);
            this.j(p3, 1);
            this.g[p3] = p4;
            return;
        }
    }

    public final boolean add(Object p4)
    {
        this.g();
        int v0 = this.h;
        this.modCount = (this.modCount + 1);
        this.j(v0, 1);
        this.g[v0] = p4;
        return 1;
    }

    public final boolean addAll(int p3, java.util.Collection p4)
    {
        p4.getClass();
        this.g();
        int v0_1 = this.h;
        if ((p3 < 0) || (p3 > v0_1)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.l("index: ", ", size: ", p3, v0_1));
            return 0;
        } else {
            int v0_0 = p4.size();
            this.e(p3, p4, v0_0);
            if (v0_0 <= 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public final boolean addAll(java.util.Collection p3)
    {
        p3.getClass();
        this.g();
        int v0 = p3.size();
        this.e(this.h, p3, v0);
        if (v0 <= 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public final Object b(int p4)
    {
        this.g();
        int v0 = this.h;
        if ((p4 < null) || (p4 >= v0)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.l("index: ", ", size: ", p4, v0));
            return 0;
        } else {
            return this.k(p4);
        }
    }

    public final void clear()
    {
        this.g();
        this.l(0, this.h);
        return;
    }

    public final void e(int p5, java.util.Collection p6, int p7)
    {
        this.modCount = (this.modCount + 1);
        this.j(p5, p7);
        java.util.Iterator v6_1 = p6.iterator();
        int v0_2 = 0;
        while (v0_2 < p7) {
            this.g[(p5 + v0_2)] = v6_1.next();
            v0_2++;
        }
        return;
    }

    public final boolean equals(Object p7)
    {
        if (p7 != this) {
            if ((p7 instanceof java.util.List)) {
                int v2 = this.h;
                if (v2 == ((java.util.List) p7).size()) {
                    int v3_0 = 0;
                    while (v3_0 < v2) {
                        if (kotlin.jvm.internal.f.a(this.g[v3_0], ((java.util.List) p7).get(v3_0))) {
                            v3_0++;
                        }
                    }
                    return 1;
                }
            }
            return 0;
        }
        return 1;
    }

    public final void f(int p3, Object p4)
    {
        this.modCount = (this.modCount + 1);
        this.j(p3, 1);
        this.g[p3] = p4;
        return;
    }

    public final void g()
    {
        if (this.i) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.v();
            return;
        } else {
            return;
        }
    }

    public final Object get(int p4)
    {
        Object[] v0_0 = this.h;
        if ((p4 < null) || (p4 >= v0_0)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.l("index: ", ", size: ", p4, v0_0));
            return 0;
        } else {
            return this.g[p4];
        }
    }

    public final int hashCode()
    {
        Object[] v0 = this.g;
        int v1 = this.h;
        int v2_0 = 1;
        int v4 = 0;
        while (v4 < v1) {
            int v5_0;
            int v5_1 = v0[v4];
            int v2_1 = (v2_0 * 31);
            if (v5_1 == 0) {
                v5_0 = 0;
            } else {
                v5_0 = v5_1.hashCode();
            }
            v2_0 = (v2_1 + v5_0);
            v4++;
        }
        return v2_0;
    }

    public final int indexOf(Object p3)
    {
        int v0 = 0;
        while (v0 < this.h) {
            if (!kotlin.jvm.internal.f.a(this.g[v0], p3)) {
                v0++;
            } else {
                return v0;
            }
        }
        return -1;
    }

    public final boolean isEmpty()
    {
        if (this.h != 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public final java.util.Iterator iterator()
    {
        return this.listIterator(0);
    }

    public final void j(int p6, int p7)
    {
        Object[] v0_1 = (this.h + p7);
        if (v0_1 < null) {
            throw new OutOfMemoryError();
        } else {
            int v1_1 = this.g;
            if (v0_1 > v1_1.length) {
                int v2_3 = v1_1.length;
                int v2_0 = (v2_3 + (v2_3 >> 1));
                if ((v2_0 - v0_1) < 0) {
                    v2_0 = v0_1;
                }
                if ((v2_0 - 2147483639) > 0) {
                    if (v0_1 <= 2147483639) {
                        v2_0 = 2147483639;
                    } else {
                        v2_0 = 2147483647;
                    }
                }
                this.g = java.util.Arrays.copyOf(v1_1, v2_0);
            }
            ha.i.I((p6 + p7), p6, this.h, this.g, this.g);
            this.h = (this.h + p7);
            return;
        }
    }

    public final Object k(int p5)
    {
        this.modCount = (this.modCount + 1);
        int v0_3 = this.g;
        Object v1 = v0_3[p5];
        ha.i.I(p5, (p5 + 1), this.h, v0_3, v0_3);
        int v5_3 = this.g;
        int v0_2 = (this.h - 1);
        v5_3.getClass();
        v5_3[v0_2] = 0;
        this.h = (this.h - 1);
        return v1;
    }

    public final void l(int p4, int p5)
    {
        if (p5 > 0) {
            this.modCount = (this.modCount + 1);
        }
        ha.i.I(p4, (p4 + p5), this.h, this.g, this.g);
        int v0_3 = this.h;
        g6.f0.p(this.g, (v0_3 - p5), v0_3);
        this.h = (this.h - p5);
        return;
    }

    public final int lastIndexOf(Object p3)
    {
        int v0_1 = (this.h - 1);
        while (v0_1 >= 0) {
            if (!kotlin.jvm.internal.f.a(this.g[v0_1], p3)) {
                v0_1--;
            } else {
                return v0_1;
            }
        }
        return -1;
    }

    public final java.util.ListIterator listIterator()
    {
        return this.listIterator(0);
    }

    public final java.util.ListIterator listIterator(int p4)
    {
        ia.a v0_0 = this.h;
        if ((p4 < 0) || (p4 > v0_0)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.l("index: ", ", size: ", p4, v0_0));
            return 0;
        } else {
            return new ia.a(this, p4);
        }
    }

    public final int m(int p6, int p7, java.util.Collection p8, boolean p9)
    {
        int v0 = 0;
        int v1_0 = 0;
        while(true) {
            Object[] v2_0 = this.g;
            if (v0 >= p7) {
                break;
            }
            Object v3_0 = (p6 + v0);
            if (p8.contains(v2_0[v3_0]) != p9) {
                v0++;
            } else {
                Object[] v2_3 = this.g;
                int v4 = (v1_0 + 1);
                v0++;
                v2_3[(v1_0 + p6)] = v2_3[v3_0];
                v1_0 = v4;
            }
        }
        int v8_1 = (p7 - v1_0);
        ha.i.I((p6 + v1_0), (p7 + p6), this.h, v2_0, v2_0);
        int v7_1 = this.h;
        g6.f0.p(this.g, (v7_1 - v8_1), v7_1);
        if (v8_1 > 0) {
            this.modCount = (this.modCount + 1);
        }
        this.h = (this.h - v8_1);
        return v8_1;
    }

    public final boolean remove(Object p1)
    {
        this.g();
        int v1_1 = this.indexOf(p1);
        if (v1_1 >= 0) {
            this.b(v1_1);
        }
        if (v1_1 < 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public final boolean removeAll(java.util.Collection p3)
    {
        p3.getClass();
        this.g();
        if (this.m(0, this.h, p3, 0) <= 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public final boolean retainAll(java.util.Collection p4)
    {
        p4.getClass();
        this.g();
        if (this.m(0, this.h, p4, 1) <= 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public final Object set(int p3, Object p4)
    {
        this.g();
        Object[] v0_0 = this.h;
        if ((p3 < 0) || (p3 >= v0_0)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.l("index: ", ", size: ", p3, v0_0));
            return 0;
        } else {
            Object[] v0_1 = this.g;
            Object v1_0 = v0_1[p3];
            v0_1[p3] = p4;
            return v1_0;
        }
    }

    public final java.util.List subList(int p8, int p9)
    {
        a.a.d(p8, p9, this.h);
        return new kotlin.collections.builders.ListBuilder$BuilderSubList(this.g, p8, (p9 - p8), 0, this);
    }

    public final Object[] toArray()
    {
        return ha.i.M(this.g, 0, this.h);
    }

    public final Object[] toArray(Object[] p5)
    {
        p5.getClass();
        int v1_1 = this.h;
        Object[] v2 = this.g;
        if (p5.length >= v1_1) {
            ha.i.I(0, 0, v1_1, v2, p5);
            int v0_1 = this.h;
            if (v0_1 < p5.length) {
                p5[v0_1] = 0;
            }
            return p5;
        } else {
            Object[] v5_2 = java.util.Arrays.copyOfRange(v2, 0, v1_1, p5.getClass());
            v5_2.getClass();
            return v5_2;
        }
    }

    public final String toString()
    {
        return g6.f0.a(this.g, 0, this.h, this);
    }
}
