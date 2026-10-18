// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package xc;
public final class e implements com.google.firebase.remoteconfig.ConfigUpdateListener {
    public final synthetic com.google.firebase.remoteconfig.FirebaseRemoteConfig a;

    public e(com.google.firebase.remoteconfig.FirebaseRemoteConfig p1)
    {
        this.a = p1;
        return;
    }

    public final void onError(com.google.firebase.remoteconfig.FirebaseRemoteConfigException p1)
    {
        p1.getClass();
        return;
    }

    public final void onUpdate(com.google.firebase.remoteconfig.ConfigUpdate p2)
    {
        p2.getClass();
        this.a.activate().addOnCompleteListener(new xc.d());
        return;
    }
}
