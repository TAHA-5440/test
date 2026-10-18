// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ha;
public final class c extends ha.d implements java.util.RandomAccess {
    public final ha.d g;
    public final int h;
    public final int i;

    public c(ha.d p1, int p2, int p3)
    {
        this.g = p1;
        this.h = p2;
        a.a.d(p2, p3, p1.a());
        this.i = (p3 - p2);
        return;
    }

    public final int a()
    {
        return this.i;
    }

    public final Object get(int p4)
    {
        int v0_0 = this.i;
        if ((p4 < null) || (p4 >= v0_0)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.l("index: ", ", size: ", p4, v0_0));
            return 0;
        } else {
            return this.g.get((this.h + p4));
        }
    }

    public final java.util.List subList(int p3, int p4)
    {
        a.a.d(p3, p4, this.i);
        int v1_0 = this.h;
        return new ha.c(this.g, (p3 + v1_0), (v1_0 + p4));
    }
}
