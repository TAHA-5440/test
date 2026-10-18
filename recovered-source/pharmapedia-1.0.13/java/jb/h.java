// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package jb;
public final class h implements jb.c {
    public final synthetic int g;
    public final synthetic kotlin.jvm.internal.Ref$ObjectRef h;

    public synthetic h(kotlin.jvm.internal.Ref$ObjectRef p1, int p2)
    {
        this.g = p2;
        this.h = p1;
        return;
    }

    public final Object emit(Object p1, ka.c p2)
    {
        switch (this.g) {
            case 0:
                this.h.g = p1;
                throw new kotlinx.coroutines.flow.internal.AbortFlowException(this);
                break;
            default:
                this.h.g = p1;
                throw new kotlinx.coroutines.flow.internal.AbortFlowException(this);
        }
    }
}
