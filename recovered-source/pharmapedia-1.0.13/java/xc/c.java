// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package xc;
public final synthetic class c implements com.google.android.gms.tasks.OnCompleteListener {
    public final synthetic com.google.firebase.remoteconfig.FirebaseRemoteConfig a;

    public synthetic c(com.google.firebase.remoteconfig.FirebaseRemoteConfig p1)
    {
        this.a = p1;
        return;
    }

    public final void onComplete(com.google.android.gms.tasks.Task p2)
    {
        com.google.firebase.remoteconfig.FirebaseRemoteConfig v0 = this.a;
        p2.getClass();
        try {
            if (p2.isSuccessful()) {
                xc.a.f = v0.getBoolean("IS_SLIDER_ENABLE");
            }
        } catch (Exception) {
        }
        return;
    }
}
