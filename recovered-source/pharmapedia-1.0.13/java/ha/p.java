// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ha;
public final class p {
    public final int a;
    public final Object b;

    public p(int p1, Object p2)
    {
        this.a = p1;
        this.b = p2;
        return;
    }

    public final boolean equals(Object p5)
    {
        if (this != p5) {
            if ((p5 instanceof ha.p)) {
                if (this.a == ((ha.p) p5).a) {
                    if (kotlin.jvm.internal.f.a(this.b, ((ha.p) p5).b)) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }

    public final int hashCode()
    {
        int v1_1;
        int v0_2 = (Integer.hashCode(this.a) * 31);
        int v1_0 = this.b;
        if (v1_0 != 0) {
            v1_1 = v1_0.hashCode();
        } else {
            v1_1 = 0;
        }
        return (v0_2 + v1_1);
    }

    public final String toString()
    {
        String v0_2 = new StringBuilder("IndexedValue(index=");
        v0_2.append(this.a);
        v0_2.append(", value=");
        v0_2.append(this.b);
        v0_2.append(41);
        return v0_2.toString();
    }
}
