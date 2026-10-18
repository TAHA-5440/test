// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.jvm.internal;
public class AdaptedFunctionReference implements kotlin.jvm.internal.e, java.io.Serializable {
    private final int arity;
    private final int flags;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private final String signature;

    public AdaptedFunctionReference(Object p1, Class p2, String p3, String p4, int p5)
    {
        this.receiver = p1;
        this.owner = p2;
        this.name = p3;
        this.signature = p4;
        this.isTopLevel = 0;
        this.arity = 2;
        this.flags = (p5 >> 1);
        return;
    }

    public boolean equals(Object p5)
    {
        if (this != p5) {
            if ((p5 instanceof kotlin.jvm.internal.AdaptedFunctionReference)) {
                if ((this.isTopLevel != ((kotlin.jvm.internal.AdaptedFunctionReference) p5).isTopLevel) || ((this.arity != ((kotlin.jvm.internal.AdaptedFunctionReference) p5).arity) || ((this.flags != ((kotlin.jvm.internal.AdaptedFunctionReference) p5).flags) || ((!kotlin.jvm.internal.f.a(this.receiver, ((kotlin.jvm.internal.AdaptedFunctionReference) p5).receiver)) || ((!kotlin.jvm.internal.f.a(this.owner, ((kotlin.jvm.internal.AdaptedFunctionReference) p5).owner)) || ((!this.name.equals(((kotlin.jvm.internal.AdaptedFunctionReference) p5).name)) || (!this.signature.equals(((kotlin.jvm.internal.AdaptedFunctionReference) p5).signature)))))))) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }

    public int getArity()
    {
        return this.arity;
    }

    public bb.d getOwner()
    {
        kotlin.jvm.internal.b v0_0 = this.owner;
        if (v0_0 != null) {
            if (!this.isTopLevel) {
                return kotlin.jvm.internal.h.a(v0_0);
            } else {
                kotlin.jvm.internal.h.a.getClass();
                return new kotlin.jvm.internal.g(v0_0);
            }
        } else {
            return 0;
        }
    }

    public int hashCode()
    {
        int v0_9;
        int v0_0 = this.receiver;
        int v1_0 = 0;
        if (v0_0 == 0) {
            v0_9 = 0;
        } else {
            v0_9 = v0_0.hashCode();
        }
        int v0_11 = (v0_9 * 31);
        Class v3 = this.owner;
        if (v3 != null) {
            v1_0 = v3.hashCode();
        }
        int v1_4;
        int vtmp4 = r1.a.c(r1.a.c(((v0_11 + v1_0) * 31), 31, this.name), 31, this.signature);
        if (!this.isTopLevel) {
            v1_4 = 1237;
        } else {
            v1_4 = 1231;
        }
        return (((((vtmp4 + v1_4) * 31) + this.arity) * 31) + this.flags);
    }

    public String toString()
    {
        kotlin.jvm.internal.h.a.getClass();
        return kotlin.jvm.internal.i.a(this);
    }
}
