// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package jb;
public final class p extends kb.c {
    public final java.util.concurrent.atomic.AtomicReference a;

    public p()
    {
        this.a = new java.util.concurrent.atomic.AtomicReference(0);
        return;
    }

    public final boolean a(kb.a p2)
    {
        int v2_1 = this.a;
        if (v2_1.get() == null) {
            v2_1.set(jb.m.b);
            return 1;
        } else {
            return 0;
        }
    }

    public final ka.c[] b(kb.a p2)
    {
        this.a.set(0);
        return kb.b.a;
    }
}
