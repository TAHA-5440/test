// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vb;
public final class o extends vb.z {
    public final boolean g;
    public final String h;

    public o(String p1, boolean p2)
    {
        p1.getClass();
        this.g = p2;
        this.h = p1.toString();
        return;
    }

    public final String a()
    {
        return this.h;
    }

    public final boolean b()
    {
        return this.g;
    }

    public final boolean equals(Object p3)
    {
        if ((this == p3) || ((p3) && ((vb.o == p3.getClass()) && ((this.g == ((vb.o) p3).g) && (kotlin.jvm.internal.f.a(this.h, ((vb.o) p3).h)))))) {
            return 1;
        } else {
            return 0;
        }
    }

    public final int hashCode()
    {
        return (this.h.hashCode() + (Boolean.hashCode(this.g) * 31));
    }

    public final String toString()
    {
        String v1 = this.h;
        if (!this.g) {
            return v1;
        } else {
            String v0_2 = new StringBuilder();
            wb.k.a(v1, v0_2);
            return v0_2.toString();
        }
    }
}
