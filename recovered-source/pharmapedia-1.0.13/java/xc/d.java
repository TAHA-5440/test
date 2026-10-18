// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package xc;
public final synthetic class d implements com.google.android.gms.tasks.OnCompleteListener {

    public final void onComplete(com.google.android.gms.tasks.Task p2)
    {
        p2.getClass();
        try {
            if (p2.isSuccessful()) {
                boolean v2_4 = com.google.firebase.remoteconfig.RemoteConfigKt.getRemoteConfig(com.google.firebase.Firebase.INSTANCE);
                v2_4.getClass();
                xc.a.f = v2_4.getBoolean("IS_SLIDER_ENABLE");
            }
        } catch (Exception) {
        }
        return;
    }
}
