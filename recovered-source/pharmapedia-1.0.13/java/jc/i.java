// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package jc;
public final class i implements jc.l {

    public final boolean b(javax.net.ssl.SSLSocket p2)
    {
        if ((!jc.k.b) || (!org.conscrypt.Conscrypt.isConscrypt(p2))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final jc.n k(javax.net.ssl.SSLSocket p1)
    {
        return new jc.k();
    }
}
