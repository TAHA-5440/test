// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yc;
public final class a extends android.content.ContextWrapper {
    public final synthetic yc.c a;

    public a(yc.c p1, android.content.Context p2)
    {
        this.a = p1;
        super(p2);
        return;
    }

    public final Object getSystemService(String p3)
    {
        Object v0_1;
        p3.getClass();
        if (!"window".equals(p3)) {
            v0_1 = super.getSystemService(p3);
        } else {
            android.view.WindowManager v3_1 = this.getBaseContext().getSystemService(p3);
            v3_1.getClass();
            v0_1 = new yc.b(this.a, ((android.view.WindowManager) v3_1));
        }
        v0_1.getClass();
        return v0_1;
    }
}
