// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public final class u {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final java.util.List f;
    public final String g;
    public final String h;

    static u()
    {
        return;
    }

    public u(String p1, String p2, String p3, String p4, int p5, java.util.ArrayList p6, java.util.ArrayList p7, String p8, String p9)
    {
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.d = p4;
        this.e = p5;
        this.f = p7;
        this.g = p8;
        this.h = p9;
        return;
    }

    public final String a()
    {
        if (this.c.length() != 0) {
            String v2 = this.h;
            return v2.substring((db.i.X(v2, 58, (this.a.length() + 3), 4) + 1), db.i.X(v2, 64, 0, 6));
        } else {
            return "";
        }
    }

    public final String b()
    {
        String v2 = this.h;
        String v0_4 = db.i.X(v2, 47, (this.a.length() + 3), 4);
        return v2.substring(v0_4, zb.c.e(v2, "?#", v0_4, v2.length()));
    }

    public final java.util.ArrayList c()
    {
        String v2 = this.h;
        int v0_4 = db.i.X(v2, 47, (this.a.length() + 3), 4);
        int v1_0 = zb.c.e(v2, "?#", v0_4, v2.length());
        java.util.ArrayList v4_2 = new java.util.ArrayList();
        while (v0_4 < v1_0) {
            int v0_1 = (v0_4 + 1);
            int v5 = zb.c.d(v2, 47, v0_1, v1_0);
            v4_2.add(v2.substring(v0_1, v5));
            v0_4 = v5;
        }
        return v4_2;
    }

    public final String d()
    {
        if (this.f != null) {
            String v2 = this.h;
            String v0_5 = (db.i.X(v2, 63, 0, 6) + 1);
            return v2.substring(v0_5, zb.c.d(v2, 35, v0_5, v2.length()));
        } else {
            return 0;
        }
    }

    public final String e()
    {
        if (this.b.length() != 0) {
            String v0_6 = (this.a.length() + 3);
            String v2 = this.h;
            return v2.substring(v0_6, zb.c.e(v2, ":@", v0_6, v2.length()));
        } else {
            return "";
        }
    }

    public final boolean equals(Object p2)
    {
        if ((!(p2 instanceof yb.u)) || (!((yb.u) p2).h.equals(this.h))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final boolean f()
    {
        return kotlin.jvm.internal.f.a(this.a, "https");
    }

    public final yb.t g()
    {
        int v1_2;
        yb.t v0_1 = new yb.t();
        int v1_0 = this.a;
        v0_1.a = v1_0;
        v0_1.b = this.e();
        v0_1.c = this.a();
        v0_1.d = this.d;
        v1_0.getClass();
        int v3_0 = -1;
        if (!v1_0.equals("http")) {
            if (!v1_0.equals("https")) {
                v1_2 = -1;
            } else {
                v1_2 = 443;
            }
        } else {
            v1_2 = 80;
        }
        String v2_4 = this.e;
        if (v2_4 != v1_2) {
            v3_0 = v2_4;
        }
        int v1_5;
        v0_1.e = v3_0;
        int v1_3 = v0_1.f;
        v1_3.clear();
        v1_3.addAll(this.c());
        int v1_4 = this.d();
        String v2_6 = 0;
        if (v1_4 == 0) {
            v1_5 = 0;
        } else {
            v1_5 = yb.t.d(nc.a.a(v1_4, 0, 0, " \"\'<>#", 83));
        }
        v0_1.g = v1_5;
        if (this.g != null) {
            String v4_1 = this.h;
            v2_6 = v4_1.substring((db.i.X(v4_1, 35, 0, 6) + 1));
        }
        v0_1.h = v2_6;
        return v0_1;
    }

    public final String h()
    {
        try {
            int v1_1 = new yb.t();
            v1_1.c(this, "/...");
        } catch (IllegalArgumentException) {
            v1_1 = 0;
        }
        v1_1.getClass();
        v1_1.b = nc.a.a("", 0, 0, " \"\':;<=>@[]^`{}|/\\?#", 123);
        v1_1.c = nc.a.a("", 0, 0, " \"\':;<=>@[]^`{}|/\\?#", 123);
        return v1_1.a().h;
    }

    public final int hashCode()
    {
        return this.h.hashCode();
    }

    public final java.net.URI i()
    {
        kotlin.text.Regex v2_0;
        int v0_0 = this.g();
        java.net.URISyntaxException v1_1 = v0_0.f;
        kotlin.text.Regex v2_4 = v0_0.d;
        String v3_1 = 0;
        if (v2_4 == null) {
            v2_0 = 0;
        } else {
            v2_0 = new kotlin.text.Regex("[\"<>^`{|}]").c(v2_4);
        }
        v0_0.d = v2_0;
        kotlin.text.Regex v2_1 = v1_1.size();
        int v5_0 = 0;
        while (v5_0 < v2_1) {
            v1_1.set(v5_0, nc.a.a(((String) v1_1.get(v5_0)), 0, 0, "[]", 99));
            v5_0++;
        }
        java.net.URISyntaxException v1_0 = v0_0.g;
        if (v1_0 != null) {
            kotlin.text.Regex v2_2 = v1_0.size();
            int v5_1 = 0;
            while (v5_1 < v2_2) {
                String v6_2;
                String v6_1 = ((String) v1_0.get(v5_1));
                if (v6_1 == null) {
                    v6_2 = 0;
                } else {
                    v6_2 = nc.a.a(v6_1, 0, 0, "\\^`{|}", 67);
                }
                v1_0.set(v5_1, v6_2);
                v5_1++;
            }
        }
        java.net.URISyntaxException v1_2 = v0_0.h;
        if (v1_2 != null) {
            v3_1 = nc.a.a(v1_2, 0, 0, " \"#<>\\^`{|}", 35);
        }
        v0_0.h = v3_1;
        int v0_1 = v0_0.toString();
        try {
            return new java.net.URI(v0_1);
        } catch (java.net.URISyntaxException v1_5) {
            try {
                int v0_3 = java.net.URI.create(new kotlin.text.Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").c(v0_1));
                v0_3.getClass();
                return v0_3;
            } catch (Exception) {
                oc.l.j(v1_5);
                return 0;
            }
        }
    }

    public final java.net.URL j()
    {
        try {
            return new java.net.URL(this.h);
        } catch (int v0_2) {
            oc.l.j(v0_2);
            return 0;
        }
    }

    public final String toString()
    {
        return this.h;
    }
}
