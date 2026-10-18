// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public abstract class s extends ka.a implements ka.e {
    public static final gb.r h;

    static s()
    {
        gb.s.h = new gb.r(ka.d.g, new androidx.room.w0(27));
        return;
    }

    public s()
    {
        super(ka.d.g);
        return;
    }

    public final ka.e Z(ka.f p4)
    {
        p4.getClass();
        if (!(p4 instanceof gb.r)) {
            if (ka.d.g == p4) {
                return this;
            }
        } else {
            ka.d v0_2 = this.g;
            if ((v0_2 != ((gb.r) p4)) && (((gb.r) p4).h != v0_2)) {
                return 0;
            } else {
                ka.e v4_3 = ((ka.e) ((gb.r) p4).g.invoke(this));
                if (v4_3 != null) {
                    return v4_3;
                }
            }
        }
        return 0;
    }

    public abstract void d0(ka.g p0, Runnable p1);

    public void e0(ka.g p1, Runnable p2)
    {
        this.d0(p1, p2);
        return;
    }

    public boolean f0(ka.g p1)
    {
        return ((this instanceof gb.k1) ^ 1);
    }

    public gb.s g0(int p2, String p3)
    {
        lb.a.a(p2);
        return new lb.f(this, p2, p3);
    }

    public final ka.g i(ka.f p3)
    {
        p3.getClass();
        if (!(p3 instanceof gb.r)) {
            if (ka.d.g != p3) {
                return this;
            }
        } else {
            ka.d v0_2 = this.g;
            if ((v0_2 != ((gb.r) p3)) && (((gb.r) p3).h != v0_2)) {
                return this;
            } else {
                if (((ka.e) ((gb.r) p3).g.invoke(this)) == null) {
                    return this;
                }
            }
        }
        return kotlin.coroutines.EmptyCoroutineContext.g;
    }

    public String toString()
    {
        String v0_1 = new StringBuilder();
        v0_1.append(this.getClass().getSimpleName());
        v0_1.append(64);
        v0_1.append(gb.w.l(this));
        return v0_1.toString();
    }
}
