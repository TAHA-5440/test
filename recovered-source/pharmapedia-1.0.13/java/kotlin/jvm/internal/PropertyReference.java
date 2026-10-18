// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.jvm.internal;
public abstract class PropertyReference extends kotlin.jvm.internal.CallableReference implements bb.k {
    private final boolean syntheticJavaProperty;

    public PropertyReference(Object p9, Class p10, String p11, String p12, int p13)
    {
        int v7;
        if ((p13 & 1) != 1) {
            v7 = 0;
        } else {
            v7 = 1;
        }
        super(p9, p10, p11, p12, v7).syntheticJavaProperty = 0;
        return;
    }

    public bb.b compute()
    {
        if (!this.syntheticJavaProperty) {
            return super.compute();
        } else {
            return this;
        }
    }

    public boolean equals(Object p5)
    {
        if (p5 != this) {
            if (!(p5 instanceof kotlin.jvm.internal.PropertyReference)) {
                if (!(p5 instanceof bb.k)) {
                    return 0;
                } else {
                    return p5.equals(this.compute());
                }
            } else {
                if ((!this.getOwner().equals(((kotlin.jvm.internal.PropertyReference) p5).getOwner())) || ((!this.getName().equals(((kotlin.jvm.internal.PropertyReference) p5).getName())) || ((!this.getSignature().equals(((kotlin.jvm.internal.PropertyReference) p5).getSignature())) || (!kotlin.jvm.internal.f.a(this.getBoundReceiver(), ((kotlin.jvm.internal.PropertyReference) p5).getBoundReceiver()))))) {
                    return 0;
                } else {
                    return 1;
                }
            }
        } else {
            return 1;
        }
    }

    public bridge synthetic bb.b getReflected()
    {
        return this.getReflected();
    }

    public bb.k getReflected()
    {
        if (this.syntheticJavaProperty) {
            androidx.fragment.app.a.i("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
            return 0;
        } else {
            kotlin.jvm.KotlinReflectionNotSupportedError v0_5 = this.compute();
            if (v0_5 == this) {
                throw new kotlin.jvm.KotlinReflectionNotSupportedError("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
            } else {
                return ((bb.k) v0_5);
            }
        }
    }

    public int hashCode()
    {
        return (this.getSignature().hashCode() + ((this.getName().hashCode() + (this.getOwner().hashCode() * 31)) * 31));
    }

    public boolean isConst()
    {
        return this.getReflected().isConst();
    }

    public boolean isLateinit()
    {
        return this.getReflected().isLateinit();
    }

    public String toString()
    {
        String v0_0 = this.compute();
        if (v0_0 == this) {
            String v0_4 = new StringBuilder("property ");
            v0_4.append(this.getName());
            v0_4.append(" (Kotlin reflection is not available)");
            return v0_4.toString();
        } else {
            return v0_0.toString();
        }
    }
}
