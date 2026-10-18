// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cb;
public final class f implements java.util.Iterator, va.a {
    public final java.util.Iterator g;
    public int h;
    public Object i;
    public final synthetic cb.g j;

    public f(cb.g p1)
    {
        this.j = p1;
        this.g = ((Iterable) ((cb.j) p1.c).b).iterator();
        this.h = -1;
        return;
    }

    public final void a()
    {
        do {
            int v0_0 = this.g;
            if (!v0_0.hasNext()) {
                this.h = 0;
                return;
            } else {
                int v0_2 = v0_0.next();
            }
        } while(((Boolean) this.j.b.invoke(v0_2)).booleanValue() != 1);
        this.i = v0_2;
        this.h = 1;
        return;
    }

    public final boolean hasNext()
    {
        if (this.h == -1) {
            this.a();
        }
        if (this.h != 1) {
            return 0;
        } else {
            return 1;
        }
    }

    public final Object next()
    {
        if (this.h == -1) {
            this.a();
        }
        if (this.h == 0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.c();
            return 0;
        } else {
            int v0_3 = this.i;
            this.i = 0;
            this.h = -1;
            return v0_3;
        }
    }

    public final void remove()
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
