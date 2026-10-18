// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package jb;
public final class j implements jb.o, jb.b, kb.f {
    public final synthetic kotlinx.coroutines.flow.f g;

    public j(kotlinx.coroutines.flow.f p1)
    {
        this.g = p1;
        return;
    }

    public final Object collect(jb.c p2, ka.c p3)
    {
        this.g.collect(p2, p3);
        return kotlin.coroutines.intrinsics.CoroutineSingletons.g;
    }

    public final jb.b p(ka.g p2, int p3, kotlinx.coroutines.channels.BufferOverflow p4)
    {
        if (((((p3 < 0) || (p3 >= 2)) && (p3 != -2)) || (p4 != kotlinx.coroutines.channels.BufferOverflow.h)) && (((p3 != 0) && (p3 != -3)) || (p4 != kotlinx.coroutines.channels.BufferOverflow.g))) {
            return new kb.d(this, p2, p3, p4);
        } else {
            return this;
        }
    }
}
