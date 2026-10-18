// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package xc;
public abstract class f {

    public static final void a()
    {
        try {
            com.google.firebase.remoteconfig.FirebaseRemoteConfig v0_1 = com.google.firebase.remoteconfig.RemoteConfigKt.getRemoteConfig(com.google.firebase.Firebase.INSTANCE);
            v0_1.setConfigSettingsAsync(new com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings$Builder().setFetchTimeoutInSeconds(5).build());
            v0_1.setDefaultsAsync(2132148232);
            v0_1.fetchAndActivate().addOnCompleteListener(new xc.c(v0_1)).addOnFailureListener(new com.google.firebase.crashlytics.b(1));
            v0_1.addOnConfigUpdateListener(new xc.e(v0_1));
        } catch (Exception) {
        }
        return;
    }
}
