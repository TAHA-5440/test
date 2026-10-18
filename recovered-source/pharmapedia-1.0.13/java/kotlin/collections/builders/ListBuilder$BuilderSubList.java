// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.collections.builders;
public final class ListBuilder$BuilderSubList extends ha.e implements java.util.List, java.util.RandomAccess, java.io.Serializable {
    public Object[] g;
    public final int h;
    public int i;
    public final kotlin.collections.builders.ListBuilder$BuilderSubList j;
    public final kotlin.collections.builders.ListBuilder k;

    public ListBuilder$BuilderSubList(Object[] p1, int p2, int p3, kotlin.collections.builders.ListBuilder$BuilderSubList p4, kotlin.collections.builders.ListBuilder p5)
    {
        p1.getClass();
        p5.getClass();
        this.g = p1;
        this.h = p2;
        this.i = p3;
        this.j = p4;
        this.k = p5;
        this.modCount = kotlin.collections.builders.ListBuilder.c(p5);
        return;
    }

    public static final synthetic int c(kotlin.collections.builders.ListBuilder$BuilderSubList p0)
    {
        return p0.modCount;
    }

    private final void readObject(java.io.ObjectInputStream p2)
    {
        throw new java.io.InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace()
    {
        if (!this.k.i) {
            throw new java.io.NotSerializableException("The list cannot be serialized while it is being built.");
        } else {
            return new kotlin.collections.builders.SerializedCollection(this, 0);
        }
    }

    public final int a()
    {
        this.g();
        return this.i;
    }

    public final void add(int p3, Object p4)
    {
        this.j();
        this.g();
        int v0_2 = this.i;
        if ((p3 < null) || (p3 > v0_2)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.l("index: ", ", size: ", p3, v0_2));
            return;
        } else {
            this.f((this.h + p3), p4);
            return;
        }
    }

    public final boolean add(Object p3)
    {
        this.j();
        this.g();
        this.f((this.h + this.i), p3);
        return 1;
    }

    public final boolean addAll(int p3, java.util.Collection p4)
    {
        p4.getClass();
        this.j();
        this.g();
        int v0_1 = this.i;
        if ((p3 < 0) || (p3 > v0_1)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.l("index: ", ", size: ", p3, v0_1));
            return 0;
        } else {
            int v0_0 = p4.size();
            this.e((this.h + p3), p4, v0_0);
            if (v0_0 <= 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public final boolean addAll(java.util.Collection p4)
    {
        p4.getClass();
        this.j();
        this.g();
        int v0 = p4.size();
        this.e((this.h + this.i), p4, v0);
        if (v0 <= 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public final Object b(int p4)
    {
        this.j();
        this.g();
        int v0_2 = this.i;
        if ((p4 < null) || (p4 >= v0_2)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.l("index: ", ", size: ", p4, v0_2));
            return 0;
        } else {
            return this.k((this.h + p4));
        }
    }

    public final void clear()
    {
        this.j();
        this.g();
        this.l(this.h, this.i);
        return;
    }

    public final void e(int p3, java.util.Collection p4, int p5)
    {
        this.modCount = (this.modCount + 1);
        kotlin.collections.builders.ListBuilder v0_2 = this.k;
        kotlin.collections.builders.ListBuilder v1 = this.j;
        if (v1 == null) {
            v0_2.e(p3, p4, p5);
        } else {
            v1.e(p3, p4, p5);
        }
        this.g = v0_2.g;
        this.i = (this.i + p5);
        return;
    }

    public final boolean equals(Object p7)
    {
        this.g();
        if (p7 != this) {
            if ((p7 instanceof java.util.List)) {
                int v2 = this.i;
                if (v2 == ((java.util.List) p7).size()) {
                    int v3_0 = 0;
                    while (v3_0 < v2) {
                        if (kotlin.jvm.internal.f.a(this.g[(this.h + v3_0)], ((java.util.List) p7).get(v3_0))) {
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
        kotlin.collections.builders.ListBuilder v0_2 = this.k;
        kotlin.collections.builders.ListBuilder v1 = this.j;
        if (v1 == null) {
            v0_2.f(p3, p4);
        } else {
            v1.f(p3, p4);
        }
        this.g = v0_2.g;
        this.i = (this.i + 1);
        return;
    }

    public final void g()
    {
        if (kotlin.collections.builders.ListBuilder.c(this.k) != this.modCount) {
            throw new java.util.ConcurrentModificationException();
        } else {
            return;
        }
    }

    public final Object get(int p4)
    {
        this.g();
        Object[] v0_0 = this.i;
        if ((p4 < null) || (p4 >= v0_0)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.l("index: ", ", size: ", p4, v0_0));
            return 0;
        } else {
            return this.g[(this.h + p4)];
        }
    }

    public final int hashCode()
    {
        this.g();
        Object[] v0 = this.g;
        int v1 = this.i;
        int v2_1 = 1;
        int v4 = 0;
        while (v4 < v1) {
            int v5_1;
            int v5_0 = v0[(this.h + v4)];
            int v2_0 = (v2_1 * 31);
            if (v5_0 == 0) {
                v5_1 = 0;
            } else {
                v5_1 = v5_0.hashCode();
            }
            v2_1 = (v2_0 + v5_1);
            v4++;
        }
        return v2_1;
    }

    public final int indexOf(Object p4)
    {
        this.g();
        int v0 = 0;
        while (v0 < this.i) {
            if (!kotlin.jvm.internal.f.a(this.g[(this.h + v0)], p4)) {
                v0++;
            } else {
                return v0;
            }
        }
        return -1;
    }

    public final boolean isEmpty()
    {
        this.g();
        if (this.i != 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public final java.util.Iterator iterator()
    {
        return this.listIterator(0);
    }

    public final void j()
    {
        if (this.k.i) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.v();
            return;
        } else {
            return;
        }
    }

    public final Object k(int p2)
    {
        Object v2_1;
        this.modCount = (this.modCount + 1);
        int v0_4 = this.j;
        if (v0_4 == 0) {
            v2_1 = this.k.k(p2);
        } else {
            v2_1 = v0_4.k(p2);
        }
        this.i = (this.i - 1);
        return v2_1;
    }

    public final void l(int p2, int p3)
    {
        if (p3 > 0) {
            this.modCount = (this.modCount + 1);
        }
        kotlin.collections.builders.ListBuilder v0_2 = this.j;
        if (v0_2 == null) {
            this.k.l(p2, p3);
        } else {
            v0_2.l(p2, p3);
        }
        this.i = (this.i - p3);
        return;
    }

    public final int lastIndexOf(Object p4)
    {
        this.g();
        int v0_1 = (this.i - 1);
        while (v0_1 >= 0) {
            if (!kotlin.jvm.internal.f.a(this.g[(this.h + v0_1)], p4)) {
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
        this.g();
        kotlin.collections.builders.a v0_0 = this.i;
        if ((p4 < 0) || (p4 > v0_0)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.l("index: ", ", size: ", p4, v0_0));
            return 0;
        } else {
            return new kotlin.collections.builders.a(this, p4);
        }
    }

    public final int m(int p2, int p3, java.util.Collection p4, boolean p5)
    {
        int v2_1;
        kotlin.collections.builders.ListBuilder v0_0 = this.j;
        if (v0_0 == null) {
            v2_1 = this.k.m(p2, p3, p4, p5);
        } else {
            v2_1 = v0_0.m(p2, p3, p4, p5);
        }
        if (v2_1 > 0) {
            this.modCount = (this.modCount + 1);
        }
        this.i = (this.i - v2_1);
        return v2_1;
    }

    public final boolean remove(Object p1)
    {
        this.j();
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

    public final boolean removeAll(java.util.Collection p4)
    {
        p4.getClass();
        this.j();
        this.g();
        if (this.m(this.h, this.i, p4, 0) <= 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public final boolean retainAll(java.util.Collection p4)
    {
        p4.getClass();
        this.j();
        this.g();
        if (this.m(this.h, this.i, p4, 1) <= 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public final Object set(int p4, Object p5)
    {
        this.j();
        this.g();
        Object[] v0_1 = this.i;
        if ((p4 < 0) || (p4 >= v0_1)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.l("index: ", ", size: ", p4, v0_1));
            return 0;
        } else {
            Object[] v0_0 = this.g;
            int v1_0 = this.h;
            Object v2_1 = v0_0[(v1_0 + p4)];
            v0_0[(v1_0 + p4)] = p5;
            return v2_1;
        }
    }

    public final java.util.List subList(int p8, int p9)
    {
        a.a.d(p8, p9, this.i);
        return new kotlin.collections.builders.ListBuilder$BuilderSubList(this.g, (this.h + p8), (p9 - p8), this, this.k);
    }

    public final Object[] toArray()
    {
        this.g();
        int v2 = this.h;
        return ha.i.M(this.g, v2, (this.i + v2));
    }

    public final Object[] toArray(Object[] p5)
    {
        p5.getClass();
        this.g();
        int v1_3 = this.i;
        Object[] v2 = this.g;
        int v3 = this.h;
        if (p5.length >= v1_3) {
            ha.i.I(0, v3, (v1_3 + v3), v2, p5);
            int v0_0 = this.i;
            if (v0_0 < p5.length) {
                p5[v0_0] = 0;
            }
            return p5;
        } else {
            Object[] v5_2 = java.util.Arrays.copyOfRange(v2, v3, (v1_3 + v3), p5.getClass());
            v5_2.getClass();
            return v5_2;
        }
    }

    public final String toString()
    {
        this.g();
        return g6.f0.a(this.g, this.h, this.i, this);
    }
}
