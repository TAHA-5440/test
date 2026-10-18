// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cb;
public final class b implements java.util.Iterator, va.a {
    public final synthetic int g;
    public final java.util.Iterator h;
    public int i;

    public b(cb.c p2)
    {
        this.g = 0;
        this.h = p2.a.iterator();
        this.i = p2.b;
        return;
    }

    public b(java.util.Iterator p2)
    {
        this.g = 1;
        p2.getClass();
        this.h = p2;
        return;
    }

    public final boolean hasNext()
    {
        switch (this.g) {
            case 0:
                break;
            default:
                return this.h.hasNext();
        }
        while(true) {
            java.util.Iterator v1 = this.h;
            if ((this.i <= 0) || (!v1.hasNext())) {
                break;
            }
            v1.next();
            this.i = (this.i - 1);
        }
        return v1.hasNext();
    }

    public final Object next()
    {
        switch (this.g) {
            case 0:
                break;
            default:
                java.util.Iterator v1_0 = this.i;
                this.i = (v1_0 + 1);
                if (v1_0 < null) {
                    ha.k.x();
                    throw 0;
                } else {
                    return new ha.p(v1_0, this.h.next());
                }
        }
        while(true) {
            java.util.Iterator v1_1 = this.h;
            if ((this.i <= 0) || (!v1_1.hasNext())) {
                break;
            }
            v1_1.next();
            this.i = (this.i - 1);
        }
        return v1_1.next();
    }

    public final void remove()
    {
        switch (this.g) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                break;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }
}
