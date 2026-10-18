// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.jvm.internal;
public abstract class FunctionReference extends kotlin.jvm.internal.CallableReference implements kotlin.jvm.internal.e, bb.e {
    private final int arity;

    public FunctionReference(int p8, Object p9, Class p10, String p11, String p12, int p13)
    {
        int v0 = 1;
        if ((p13 & 1) != 1) {
            v0 = 0;
        }
        super(p9, p10, p11, p12, v0).arity = p8;
        return;
    }

    public bb.b computeReflected()
    {
        kotlin.jvm.internal.h.a.getClass();
        return this;
    }

    public boolean equals(Object p5)
    {
        if (p5 != this) {
            if (!(p5 instanceof kotlin.jvm.internal.FunctionReference)) {
                if (!(p5 instanceof bb.e)) {
                    return 0;
                } else {
                    return p5.equals(this.compute());
                }
            } else {
                if ((!this.getName().equals(((kotlin.jvm.internal.FunctionReference) p5).getName())) || ((!this.getSignature().equals(((kotlin.jvm.internal.FunctionReference) p5).getSignature())) || ((!kotlin.jvm.internal.f.a(this.getBoundReceiver(), ((kotlin.jvm.internal.FunctionReference) p5).getBoundReceiver())) || (!kotlin.jvm.internal.f.a(this.getOwner(), ((kotlin.jvm.internal.FunctionReference) p5).getOwner()))))) {
                    return 0;
                } else {
                    return 1;
                }
            }
        } else {
            return 1;
        }
    }

    public int getArity()
    {
        return this.arity;
    }

    public bridge synthetic bb.b getReflected()
    {
        return this.getReflected();
    }

    public bb.e getReflected()
    {
        kotlin.jvm.KotlinReflectionNotSupportedError v0_0 = this.compute();
        if (v0_0 == this) {
            throw new kotlin.jvm.KotlinReflectionNotSupportedError("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
        } else {
            return ((bb.e) v0_0);
        }
    }

    public int hashCode()
    {
        int v0_6;
        if (this.getOwner() != null) {
            v0_6 = (this.getOwner().hashCode() * 31);
        } else {
            v0_6 = 0;
        }
        return (this.getSignature().hashCode() + ((this.getName().hashCode() + v0_6) * 31));
    }

    public boolean isExternal()
    {
        return this.getReflected().isExternal();
    }

    public boolean isInfix()
    {
        return this.getReflected().isInfix();
    }

    public boolean isInline()
    {
        return this.getReflected().isInline();
    }

    public boolean isOperator()
    {
        return this.getReflected().isOperator();
    }

    public boolean isSuspend()
    {
        return this.getReflected().isSuspend();
    }

    public String toString()
    {
        String v0_0 = this.compute();
        if (v0_0 == this) {
            if (!"<init>".equals(this.getName())) {
                String v0_1 = new StringBuilder("function ");
                v0_1.append(this.getName());
                v0_1.append(" (Kotlin reflection is not available)");
                return v0_1.toString();
            } else {
                return "constructor (Kotlin reflection is not available)";
            }
        } else {
            return v0_0.toString();
        }
    }
}
