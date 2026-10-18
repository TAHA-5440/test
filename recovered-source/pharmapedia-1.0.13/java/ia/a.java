// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ia;
public final class a implements java.util.ListIterator, va.a {
    public final kotlin.collections.builders.ListBuilder g;
    public int h;
    public int i;
    public int j;

    public a(kotlin.collections.builders.ListBuilder p1, int p2)
    {
        this.g = p1;
        this.h = p2;
        this.i = -1;
        this.j = kotlin.collections.builders.ListBuilder.c(p1);
        return;
    }

    public final void a()
    {
        if (kotlin.collections.builders.ListBuilder.c(this.g) != this.j) {
            throw new java.util.ConcurrentModificationException();
        } else {
            return;
        }
    }

    public final void add(Object p3)
    {
        this.a();
        int v0 = this.h;
        this.h = (v0 + 1);
        kotlin.collections.builders.ListBuilder v1_1 = this.g;
        v1_1.add(v0, p3);
        this.i = -1;
        this.j = kotlin.collections.builders.ListBuilder.c(v1_1);
        return;
    }

    public final boolean hasNext()
    {
        if (this.h >= this.g.h) {
            return 0;
        } else {
            return 1;
        }
    }

    public final boolean hasPrevious()
    {
        if (this.h <= 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public final Object next()
    {
        this.a();
        int v0_0 = this.h;
        Object[] v1_1 = this.g;
        if (v0_0 >= v1_1.h) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.c();
            return 0;
        } else {
            this.h = (v0_0 + 1);
            this.i = v0_0;
            return v1_1.g[v0_0];
        }
    }

    public final int nextIndex()
    {
        return this.h;
    }

    public final Object previous()
    {
        this.a();
        int v0_0 = this.h;
        if (v0_0 <= 0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.c();
            return 0;
        } else {
            int v0_3 = (v0_0 - 1);
            this.h = v0_3;
            this.i = v0_3;
            return this.g.g[v0_3];
        }
    }

    public final int previousIndex()
    {
        return (this.h - 1);
    }

    public final void remove()
    {
        this.a();
        String v0_0 = this.i;
        if (v0_0 == -1) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Call next() or previous() before removing element from the iterator.");
            return;
        } else {
            kotlin.collections.builders.ListBuilder v2 = this.g;
            v2.b(v0_0);
            this.h = this.i;
            this.i = -1;
            this.j = kotlin.collections.builders.ListBuilder.c(v2);
            return;
        }
    }

    public final void set(Object p3)
    {
        this.a();
        int v0 = this.i;
        if (v0 == -1) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Call next() or previous() before replacing element from the iterator.");
            return;
        } else {
            this.g.set(v0, p3);
            return;
        }
    }
}
