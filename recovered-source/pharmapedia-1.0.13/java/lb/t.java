// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package lb;
public final class t implements ka.f {
    public final ThreadLocal g;

    public t(ThreadLocal p1)
    {
        this.g = p1;
        return;
    }

    public final boolean equals(Object p4)
    {
        if (this != p4) {
            if ((p4 instanceof lb.t)) {
                if (kotlin.jvm.internal.f.a(this.g, ((lb.t) p4).g)) {
                    return 1;
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
        return this.g.hashCode();
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder("ThreadLocalKey(threadLocal=");
        v0_1.append(this.g);
        v0_1.append(41);
        return v0_1.toString();
    }
}
