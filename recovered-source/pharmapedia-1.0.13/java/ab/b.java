// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ab;
public final class b implements java.util.Iterator, va.a {
    public final int g;
    public final int h;
    public boolean i;
    public int j;

    public b(int p3, int p4, int p5)
    {
        this.g = p5;
        this.h = p4;
        int v0 = 0;
        if (p5 <= 0) {
            if (p3 >= p4) {
                v0 = 1;
            }
        } else {
            if (p3 <= p4) {
            }
        }
        this.i = v0;
        if (v0 == 0) {
            p3 = p4;
        }
        this.j = p3;
        return;
    }

    public final boolean hasNext()
    {
        return this.i;
    }

    public final bridge synthetic Object next()
    {
        return Integer.valueOf(this.nextInt());
    }

    public final int nextInt()
    {
        int v0_0 = this.j;
        if (v0_0 != this.h) {
            this.j = (this.g + v0_0);
            return v0_0;
        } else {
            if (!this.i) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.c();
                return 0;
            } else {
                this.i = 0;
                return v0_0;
            }
        }
    }

    public final void remove()
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
