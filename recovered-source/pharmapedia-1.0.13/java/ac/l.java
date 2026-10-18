// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ac;
public final class l extends oc.p {
    public final ua.l h;
    public boolean i;

    public l(oc.b0 p1, ua.l p2)
    {
        p1.getClass();
        super(p1);
        super.h = p2;
        return;
    }

    public final void D(long p2, oc.i p4)
    {
        if (!this.i) {
            try {
                this.g.D(p2, p4);
                return;
            } catch (java.io.IOException v2_1) {
                this.i = 1;
                this.h.invoke(v2_1);
                return;
            }
        } else {
            p4.skip(p2);
            return;
        }
    }

    public final void close()
    {
        try {
            super.close();
            return;
        } catch (java.io.IOException v0) {
            this.i = 1;
            this.h.invoke(v0);
            return;
        }
    }

    public final void flush()
    {
        if (!this.i) {
            try {
                super.flush();
                return;
            } catch (java.io.IOException v0_1) {
                this.i = 1;
                this.h.invoke(v0_1);
                return;
            }
        } else {
            return;
        }
    }
}
