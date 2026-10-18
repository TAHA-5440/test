// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package db;
public final class c implements cb.h {
    public final CharSequence a;
    public final int b;
    public final ua.p c;

    public c(CharSequence p1, int p2, ua.p p3)
    {
        p1.getClass();
        this.a = p1;
        this.b = p2;
        this.c = p3;
        return;
    }

    public final java.util.Iterator iterator()
    {
        return new db.b(this);
    }
}
