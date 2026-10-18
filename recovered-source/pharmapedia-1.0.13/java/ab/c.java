// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ab;
public final class c extends ab.a {
    public static final ab.c j;

    static c()
    {
        ab.c.j = new ab.c(1, 0, 1);
        return;
    }

    public final boolean equals(Object p3)
    {
        if ((!(p3 instanceof ab.c)) || (((!this.isEmpty()) || (!((ab.c) p3).isEmpty())) && ((this.g != ((ab.c) p3).g) || (this.h != ((ab.c) p3).h)))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final int hashCode()
    {
        if (!this.isEmpty()) {
            return ((this.g * 31) + this.h);
        } else {
            return -1;
        }
    }

    public final boolean isEmpty()
    {
        if (this.g <= this.h) {
            return 0;
        } else {
            return 1;
        }
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder();
        v0_1.append(this.g);
        v0_1.append("..");
        v0_1.append(this.h);
        return v0_1.toString();
    }
}
