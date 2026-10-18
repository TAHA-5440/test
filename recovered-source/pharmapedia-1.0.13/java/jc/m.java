// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package jc;
public final class m implements jc.n {
    public final jc.l a;
    public jc.n b;

    public m(jc.l p1)
    {
        this.a = p1;
        return;
    }

    public final boolean a()
    {
        return 1;
    }

    public final boolean b(javax.net.ssl.SSLSocket p2)
    {
        return this.a.b(p2);
    }

    public final String c(javax.net.ssl.SSLSocket p2)
    {
        jc.n v0 = this.e(p2);
        if (v0 == null) {
            return 0;
        } else {
            return v0.c(p2);
        }
    }

    public final void d(javax.net.ssl.SSLSocket p2, String p3, java.util.List p4)
    {
        p4.getClass();
        jc.n v0 = this.e(p2);
        if (v0 != null) {
            v0.d(p2, p3, p4);
        }
        return;
    }

    public final declared_synchronized jc.n e(javax.net.ssl.SSLSocket p2)
    {
        if ((this.b == null) && (this.a.b(p2))) {
            this.b = this.a.k(p2);
        }
        return this.b;
    }
}
