// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cb;
public final class a implements cb.h {
    public final java.util.concurrent.atomic.AtomicReference a;

    public a(cb.j p2)
    {
        this.a = new java.util.concurrent.atomic.AtomicReference(p2);
        return;
    }

    public final java.util.Iterator iterator()
    {
        int v0_3 = ((cb.h) this.a.getAndSet(0));
        if (v0_3 == 0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("This sequence can be consumed only once.");
            return 0;
        } else {
            return v0_3.iterator();
        }
    }
}
