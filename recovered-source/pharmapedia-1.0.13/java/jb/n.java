// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package jb;
public final class n extends kb.c {
    public long a;
    public gb.h b;

    public final boolean a(kb.a p5)
    {
        if (this.a < 0) {
            long v0_2 = ((kotlinx.coroutines.flow.e) p5).l;
            if (v0_2 < ((kotlinx.coroutines.flow.e) p5).m) {
                ((kotlinx.coroutines.flow.e) p5).m = v0_2;
            }
            this.a = v0_2;
            return 1;
        } else {
            return 0;
        }
    }

    public final ka.c[] b(kb.a p5)
    {
        long v0 = this.a;
        this.a = -1;
        this.b = 0;
        return ((kotlinx.coroutines.flow.e) p5).q(v0);
    }
}
