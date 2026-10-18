// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ia;
public final class c implements java.util.Map$Entry, va.a {
    public final kotlin.collections.builders.MapBuilder g;
    public final int h;
    public final int i;

    public c(kotlin.collections.builders.MapBuilder p1, int p2)
    {
        p1.getClass();
        this.g = p1;
        this.h = p2;
        this.i = p1.n;
        return;
    }

    public final void a()
    {
        if (this.g.n != this.i) {
            throw new java.util.ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
        } else {
            return;
        }
    }

    public final boolean equals(Object p3)
    {
        if ((!(p3 instanceof java.util.Map$Entry)) || ((!kotlin.jvm.internal.f.a(((java.util.Map$Entry) p3).getKey(), this.getKey())) || (!kotlin.jvm.internal.f.a(((java.util.Map$Entry) p3).getValue(), this.getValue())))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final Object getKey()
    {
        this.a();
        return this.g.g[this.h];
    }

    public final Object getValue()
    {
        this.a();
        Object v0_1 = this.g.h;
        v0_1.getClass();
        return v0_1[this.h];
    }

    public final int hashCode()
    {
        int v0_2;
        int v0_0 = this.getKey();
        int v1 = 0;
        if (v0_0 == 0) {
            v0_2 = 0;
        } else {
            v0_2 = v0_0.hashCode();
        }
        Object v2 = this.getValue();
        if (v2 != null) {
            v1 = v2.hashCode();
        }
        return (v0_2 ^ v1);
    }

    public final Object setValue(Object p4)
    {
        this.a();
        int v0_0 = this.g;
        v0_0.c();
        Object[] v1_0 = v0_0.h;
        if (v1_0 == null) {
            Object[] v1_2 = v0_0.g.length;
            if (v1_2 < null) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("capacity must be non-negative.");
                return 0;
            } else {
                v1_0 = new Object[v1_2];
                v0_0.h = v1_0;
            }
        }
        int v0_1 = this.h;
        int v2 = v1_0[v0_1];
        v1_0[v0_1] = p4;
        return v2;
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder();
        v0_1.append(this.getKey());
        v0_1.append(61);
        v0_1.append(this.getValue());
        return v0_1.toString();
    }
}
