// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package db;
public final class h extends ha.a {
    public final synthetic androidx.lifecycle.j g;

    public h(androidx.lifecycle.j p1)
    {
        this.g = p1;
        return;
    }

    public final int a()
    {
        return (((java.util.regex.Matcher) this.g.h).groupCount() + 1);
    }

    public final db.f b(int p4)
    {
        java.util.regex.Matcher v0_2 = ((java.util.regex.Matcher) this.g.h);
        ab.c v1_1 = com.bumptech.glide.d.C(v0_2.start(p4), v0_2.end(p4));
        if (v1_1.g < 0) {
            return 0;
        } else {
            int v4_2 = v0_2.group(p4);
            v4_2.getClass();
            return new db.f(v4_2, v1_1);
        }
    }

    public final bridge boolean contains(Object p2)
    {
        boolean v0;
        if (p2) {
            v0 = (p2 instanceof db.f);
        } else {
            v0 = 1;
        }
        if (v0) {
            return super.contains(((db.f) p2));
        } else {
            return 0;
        }
    }

    public final boolean isEmpty()
    {
        return 0;
    }

    public final java.util.Iterator iterator()
    {
        return new cb.l(new cb.g(new cb.j(new ab.c(0, (this.a() - 1), 1), 3), new ac.c(this, 2)));
    }
}
