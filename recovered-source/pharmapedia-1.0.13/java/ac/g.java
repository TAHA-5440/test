// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ac;
public final class g {
    public final String a;
    public final long[] b;
    public final java.util.ArrayList c;
    public final java.util.ArrayList d;
    public boolean e;
    public boolean f;
    public ac.e g;
    public int h;
    public long i;
    public final synthetic ac.k j;

    public g(ac.k p6, String p7)
    {
        p7.getClass();
        this.j = p6;
        this.a = p7;
        p6.getClass();
        StringBuilder v0_4 = new long[2];
        this.b = v0_4;
        this.c = new java.util.ArrayList();
        this.d = new java.util.ArrayList();
        StringBuilder v0_3 = new StringBuilder(p7);
        v0_3.append(46);
        int v7_2 = v0_3.length();
        int v1 = 0;
        while (v1 < 2) {
            v0_3.append(v1);
            this.c.add(this.j.g.d(v0_3.toString()));
            v0_3.append(".tmp");
            this.d.add(this.j.g.d(v0_3.toString()));
            v0_3.setLength(v7_2);
            v1++;
        }
        return;
    }

    public final ac.h a()
    {
        try {
            if (this.e) {
                int v0_1 = this.j;
                if ((v0_1.r) || ((this.g == null) && (!this.f))) {
                    java.util.ArrayList v7_1 = new java.util.ArrayList();
                    long[] v8_1 = ((long[]) this.b.clone());
                    int v1_2 = 0;
                    int v2_0 = 0;
                    while (v2_0 < 2) {
                        try {
                            oc.d0 v3_3 = v0_1.h.e0(((oc.w) this.c.get(v2_0)));
                        } catch (java.io.FileNotFoundException) {
                            int v2_3 = v7_1.size();
                        }
                        if (!v0_1.r) {
                            this.h = (this.h + 1);
                            v3_3 = new ac.f(v3_3, v0_1, this);
                        } else {
                        }
                        v7_1.add(v3_3);
                        v2_0++;
                    }
                    return new ac.h(this.j, this.a, this.i, v7_1, v8_1);
                }
            }
        } catch (java.io.IOException) {
        }
        return 0;
    }
}
