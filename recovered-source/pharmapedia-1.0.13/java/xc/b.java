// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package xc;
public final synthetic class b implements java.lang.Runnable {
    public final synthetic int g;
    public final synthetic ua.a h;
    public final synthetic android.app.Activity i;
    public final synthetic String j;

    public synthetic b(ua.a p1, android.app.Activity p2, String p3, int p4)
    {
        this.g = p4;
        this.h = p1;
        this.i = p2;
        this.j = p3;
        return;
    }

    public final void run()
    {
        yc.c v2_2 = this.j;
        android.app.Activity v3 = this.i;
        ua.a v4 = this.h;
        switch (this.g) {
            case 0:
                v4.invoke();
                v3.getClass();
                android.widget.Toast v0_1 = android.widget.Toast.makeText(v3, v2_2, 0);
                yc.d.a(v0_1.getView(), new yc.c(v3));
                new yc.d(v3, v0_1).show();
                return;
            default:
                v4.invoke();
                v3.getClass();
                android.widget.Toast v0_2 = android.widget.Toast.makeText(v3, v2_2, 0);
                yc.d.a(v0_2.getView(), new yc.c(v3));
                new yc.d(v3, v0_2).show();
                return;
        }
    }
}
