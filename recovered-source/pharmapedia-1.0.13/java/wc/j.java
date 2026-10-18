// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package wc;
public final synthetic class j implements android.view.MenuItem$OnMenuItemClickListener {
    public final synthetic int a;
    public final synthetic wc.l b;

    public synthetic j(wc.l p1, int p2)
    {
        this.a = p2;
        this.b = p1;
        return;
    }

    public final boolean onMenuItemClick(android.view.MenuItem p2)
    {
        switch (this.a) {
            case 0:
                p2.getClass();
                this.b.r(0);
                return 1;
            default:
                p2.getClass();
                this.b.r(1);
                return 1;
        }
    }
}
