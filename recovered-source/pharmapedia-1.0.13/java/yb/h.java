// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public final class h {
    public static final yb.h n;
    public final boolean a;
    public final boolean b;
    public final int c;
    public final int d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final int h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public String m;

    static h()
    {
        String v0_0 = kotlin.time.DurationUnit.j;
        int v1 = 2147483647;
        yb.h v2_3 = eb.a.g(jc.g.v(2147483647, v0_0), v0_0);
        if (v2_3 < 0) {
            oc.l.d(f0.a.b("maxStale < 0: ", v2_3));
            return;
        } else {
            if (v2_3 <= 2147483647) {
                v1 = ((int) v2_3);
            }
            yb.h.n = new yb.h(0, 0, -1, -1, 0, 0, 0, v1, -1, 1, 0, 0, 0);
            return;
        }
    }

    public h(boolean p1, boolean p2, int p3, int p4, boolean p5, boolean p6, boolean p7, int p8, int p9, boolean p10, boolean p11, boolean p12, String p13)
    {
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.d = p4;
        this.e = p5;
        this.f = p6;
        this.g = p7;
        this.h = p8;
        this.i = p9;
        this.j = p10;
        this.k = p11;
        this.l = p12;
        this.m = p13;
        return;
    }

    public final String toString()
    {
        String v0_0 = this.m;
        if (v0_0 == null) {
            String v0_2 = new StringBuilder();
            if (this.a) {
                v0_2.append("no-cache, ");
            }
            if (this.b) {
                v0_2.append("no-store, ");
            }
            int v3_0 = this.c;
            if (v3_0 != -1) {
                v0_2.append("max-age=");
                v0_2.append(v3_0);
                v0_2.append(", ");
            }
            int v3_1 = this.d;
            if (v3_1 != -1) {
                v0_2.append("s-maxage=");
                v0_2.append(v3_1);
                v0_2.append(", ");
            }
            if (this.e) {
                v0_2.append("private, ");
            }
            if (this.f) {
                v0_2.append("public, ");
            }
            if (this.g) {
                v0_2.append("must-revalidate, ");
            }
            int v3_8 = this.h;
            if (v3_8 != -1) {
                v0_2.append("max-stale=");
                v0_2.append(v3_8);
                v0_2.append(", ");
            }
            int v3_9 = this.i;
            if (v3_9 != -1) {
                v0_2.append("min-fresh=");
                v0_2.append(v3_9);
                v0_2.append(", ");
            }
            if (this.j) {
                v0_2.append("only-if-cached, ");
            }
            if (this.k) {
                v0_2.append("no-transform, ");
            }
            if (this.l) {
                v0_2.append("immutable, ");
            }
            if (v0_2.length() != 0) {
                v0_2.delete((v0_2.length() - 2), v0_2.length()).getClass();
                v0_0 = v0_2.toString();
                this.m = v0_0;
            } else {
                return "";
            }
        }
        return v0_0;
    }
}
