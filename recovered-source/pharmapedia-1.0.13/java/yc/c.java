// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yc;
public final class c extends android.content.ContextWrapper {
    public static final synthetic int a;

    public final android.content.Context getApplicationContext()
    {
        android.content.Context v1_1 = this.getBaseContext().getApplicationContext();
        v1_1.getClass();
        return new yc.a(this, v1_1);
    }
}
