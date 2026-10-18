// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package lb;
public final class s implements ka.e {
    public final Object g;
    public final ThreadLocal h;
    public final lb.t i;

    public s(Object p1, ThreadLocal p2)
    {
        this.g = p1;
        this.h = p2;
        this.i = new lb.t(p2);
        return;
    }

    public final Object B(Object p1, ua.p p2)
    {
        return p2.invoke(p1, this);
    }

    public final ka.g L(ka.g p1)
    {
        return com.bumptech.glide.i.r(this, p1);
    }

    public final ka.e Z(ka.f p2)
    {
        if (!this.i.equals(p2)) {
            return 0;
        } else {
            return this;
        }
    }

    public final ka.f getKey()
    {
        return this.i;
    }

    public final ka.g i(ka.f p2)
    {
        if (!this.i.equals(p2)) {
            return this;
        } else {
            return kotlin.coroutines.EmptyCoroutineContext.g;
        }
    }

    public final String toString()
    {
        String v0_2 = new StringBuilder("ThreadLocal(value=");
        v0_2.append(this.g);
        v0_2.append(", threadLocal = ");
        v0_2.append(this.h);
        v0_2.append(41);
        return v0_2.toString();
    }
}
