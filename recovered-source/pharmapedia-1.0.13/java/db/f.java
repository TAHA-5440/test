// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package db;
public final class f {
    public final String a;
    public final ab.c b;

    public f(String p1, ab.c p2)
    {
        this.a = p1;
        this.b = p2;
        return;
    }

    public final boolean equals(Object p3)
    {
        if ((this == p3) || (((p3 instanceof db.f)) && ((this.a.equals(((db.f) p3).a)) && (this.b.equals(((db.f) p3).b))))) {
            return 1;
        } else {
            return 0;
        }
    }

    public final int hashCode()
    {
        return (this.b.hashCode() + (this.a.hashCode() * 31));
    }

    public final String toString()
    {
        String v0_2 = new StringBuilder("MatchGroup(value=");
        v0_2.append(this.a);
        v0_2.append(", range=");
        v0_2.append(this.b);
        v0_2.append(41);
        return v0_2.toString();
    }
}
