// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public final class e0 {
    public final yb.a a;
    public final java.net.Proxy b;
    public final java.net.InetSocketAddress c;

    public e0(yb.a p1, java.net.Proxy p2, java.net.InetSocketAddress p3)
    {
        p1.getClass();
        p3.getClass();
        this.a = p1;
        this.b = p2;
        this.c = p3;
        return;
    }

    public final boolean equals(Object p3)
    {
        if ((!(p3 instanceof yb.e0)) || ((!kotlin.jvm.internal.f.a(((yb.e0) p3).a, this.a)) || ((!((yb.e0) p3).b.equals(this.b)) || (!kotlin.jvm.internal.f.a(((yb.e0) p3).c, this.c))))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final int hashCode()
    {
        return (this.c.hashCode() + ((this.b.hashCode() + ((this.a.hashCode() + 527) * 31)) * 31));
    }

    public final String toString()
    {
        String v4_1;
        String v0_1 = new StringBuilder();
        int v1_0 = this.a;
        int v1_3 = v1_0.h;
        java.net.Proxy v2_2 = v1_0.h.d;
        java.net.InetSocketAddress v3 = this.c;
        String v4_2 = v3.getAddress();
        if (v4_2 == null) {
            v4_1 = 0;
        } else {
            String v4_0 = v4_2.getHostAddress();
            if (v4_0 == null) {
            } else {
                v4_1 = zb.b.b(v4_0);
            }
        }
        if (!db.i.U(v2_2, 58)) {
            v0_1.append(v2_2);
        } else {
            v0_1.append("[");
            v0_1.append(v2_2);
            v0_1.append("]");
        }
        if ((v1_3.e != v3.getPort()) || (v2_2.equals(v4_1))) {
            v0_1.append(":");
            v0_1.append(v1_3.e);
        }
        if (!v2_2.equals(v4_1)) {
            if (!this.b.equals(java.net.Proxy.NO_PROXY)) {
                v0_1.append(" via proxy ");
            } else {
                v0_1.append(" at ");
            }
            if (v4_1 != null) {
                if (!db.i.U(v4_1, 58)) {
                    v0_1.append(v4_1);
                } else {
                    v0_1.append("[");
                    v0_1.append(v4_1);
                    v0_1.append("]");
                }
            } else {
                v0_1.append("<unresolved>");
            }
            v0_1.append(":");
            v0_1.append(v3.getPort());
        }
        return v0_1.toString();
    }
}
