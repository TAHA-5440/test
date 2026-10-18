// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package pb;
public final class b implements com.google.android.gms.tasks.OnCompleteListener {
    public final synthetic gb.h a;

    public b(gb.h p1)
    {
        this.a = p1;
        return;
    }

    public final void onComplete(com.google.android.gms.tasks.Task p3)
    {
        boolean v0_0 = p3.getException();
        gb.h v1 = this.a;
        if (v0_0) {
            v1.resumeWith(new kotlin.Result$Failure(v0_0));
            return;
        } else {
            if (!p3.isCanceled()) {
                v1.resumeWith(p3.getResult());
                return;
            } else {
                v1.e(0);
                return;
            }
        }
    }
}
