// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public final class p {
    public static final java.util.regex.Pattern k;
    public static final java.util.regex.Pattern l;
    public static final java.util.regex.Pattern m;
    public static final java.util.regex.Pattern n;
    public final String a;
    public final String b;
    public final long c;
    public final String d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final String j;

    static p()
    {
        yb.p.k = java.util.regex.Pattern.compile("(\\d{2,4})[^\\d]*");
        yb.p.l = java.util.regex.Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        yb.p.m = java.util.regex.Pattern.compile("(\\d{1,2})[^\\d]*");
        yb.p.n = java.util.regex.Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
        return;
    }

    public p(String p1, String p2, long p3, String p5, String p6, boolean p7, boolean p8, boolean p9, boolean p10, String p11)
    {
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.d = p5;
        this.e = p6;
        this.f = p7;
        this.g = p8;
        this.h = p9;
        this.i = p10;
        this.j = p11;
        return;
    }

    public final boolean equals(Object p5)
    {
        if ((!(p5 instanceof yb.p)) || ((!((yb.p) p5).a.equals(this.a)) || ((!((yb.p) p5).b.equals(this.b)) || ((((yb.p) p5).c != this.c) || ((!((yb.p) p5).d.equals(this.d)) || ((!((yb.p) p5).e.equals(this.e)) || ((((yb.p) p5).f != this.f) || ((((yb.p) p5).g != this.g) || ((((yb.p) p5).h != this.h) || ((((yb.p) p5).i != this.i) || (!kotlin.jvm.internal.f.a(((yb.p) p5).j, this.j)))))))))))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final int hashCode()
    {
        int v1_2;
        int v1_0 = 31;
        int v0_11 = ((Boolean.hashCode(this.i) + ((Boolean.hashCode(this.h) + ((Boolean.hashCode(this.g) + ((Boolean.hashCode(this.f) + r1.a.c(r1.a.c(((Long.hashCode(this.c) + r1.a.c(r1.a.c(527, 31, this.a), 31, this.b)) * v1_0), v1_0, this.d), 31, this.e)) * 31)) * 31)) * v1_0)) * 31);
        int v1_1 = this.j;
        if (v1_1 == 0) {
            v1_2 = 0;
        } else {
            v1_2 = v1_1.hashCode();
        }
        return (v0_11 + v1_2);
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder();
        v0_1.append(this.a);
        v0_1.append(61);
        v0_1.append(this.b);
        if (this.h) {
            long v3 = this.c;
            if (v3 != -9223372036854775808) {
                v0_1.append("; expires=");
                String v1_6 = ((java.text.DateFormat) dc.c.a.get()).format(new java.util.Date(v3));
                v1_6.getClass();
                v0_1.append(v1_6);
            } else {
                v0_1.append("; max-age=0");
            }
        }
        if (!this.i) {
            v0_1.append("; domain=");
            v0_1.append(this.d);
        }
        v0_1.append("; path=");
        v0_1.append(this.e);
        if (this.f) {
            v0_1.append("; secure");
        }
        if (this.g) {
            v0_1.append("; httponly");
        }
        String v1_18 = this.j;
        if (v1_18 != null) {
            v0_1.append("; samesite=");
            v0_1.append(v1_18);
        }
        return v0_1.toString();
    }
}
