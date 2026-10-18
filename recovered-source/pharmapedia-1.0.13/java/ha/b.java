// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ha;
public final class b extends ga.g implements java.util.ListIterator {
    public final synthetic ha.d j;

    public b(ha.d p3, int p4)
    {
        this.j = p3;
        super(p3, 4);
        int v3_3 = p3.a();
        if ((p4 < 0) || (p4 > v3_3)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.l("index: ", ", size: ", p4, v3_3));
            throw 0;
        } else {
            super.h = p4;
            return;
        }
    }

    public final void add(Object p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean hasPrevious()
    {
        if (this.h <= 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public final int nextIndex()
    {
        return this.h;
    }

    public final Object previous()
    {
        if (!this.hasPrevious()) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.c();
            return 0;
        } else {
            int v0_4 = (this.h - 1);
            this.h = v0_4;
            return this.j.get(v0_4);
        }
    }

    public final int previousIndex()
    {
        return (this.h - 1);
    }

    public final void set(Object p2)
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
