// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public final class s implements oc.d0 {
    public final oc.k g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;

    public s(oc.k p1)
    {
        p1.getClass();
        this.g = p1;
        return;
    }

    public final long N(long p9, oc.i p11)
    {
        p11.getClass();
        do {
            int v0_0 = this.k;
            int v1_0 = this.g;
            if (v0_0 != 0) {
                long v9_6 = v1_0.N(Math.min(p9, ((long) v0_0)), p11);
                if (v9_6 != -1) {
                    this.k = (this.k - ((int) v9_6));
                    return v9_6;
                }
            } else {
                v1_0.skip(((long) this.l));
                this.l = 0;
                if ((this.i & 4) == 0) {
                    int v0_6 = this.j;
                    int v2_0 = zb.c.m(v1_0);
                    this.k = v2_0;
                    this.h = v2_0;
                    int v2_3 = (v1_0.readByte() & 255);
                    this.i = (v1_0.readByte() & 255);
                    int v3_2 = fc.t.j;
                    if (v3_2.isLoggable(java.util.logging.Level.FINE)) {
                        v3_2.fine(fc.f.b(1, this.j, this.h, v2_3, this.i));
                    }
                    int v1_2 = (v1_0.readInt() & 2147483647);
                    this.j = v1_2;
                    if (v2_3 != 9) {
                        String v10_1 = new StringBuilder();
                        v10_1.append(v2_3);
                        v10_1.append(" != TYPE_CONTINUATION");
                        throw new java.io.IOException(v10_1.toString());
                    } else {
                    }
                }
            }
            return -1;
        } while(v1_2 != v0_6);
        oc.l.g("TYPE_CONTINUATION streamId changed");
        return 0;
    }

    public final oc.f0 a()
    {
        return this.g.a();
    }

    public final void close()
    {
        return;
    }
}
