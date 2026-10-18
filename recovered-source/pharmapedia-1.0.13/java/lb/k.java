// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package lb;
public abstract class k {
    public static final hb.d a;

    static k()
    {
        hb.d v1_0 = 0;
        try {
            String v0_9 = System.getProperty("kotlinx.coroutines.fast.service.loader");
        } catch (SecurityException) {
            v0_9 = 0;
        }
        if (v0_9 != null) {
            Boolean.parseBoolean(v0_9);
        }
        try {
            String v0_3 = java.util.Arrays.asList(new hb.a[] {new hb.a()})).iterator();
            v0_3.getClass();
            String v0_7 = cb.i.q(new cb.a(new cb.j(v0_3, 0))).iterator();
        } catch (String v0_8) {
            throw new java.util.ServiceConfigurationError(v0_8.getMessage(), v0_8);
        }
        if (v0_7.hasNext()) {
            v1_0 = v0_7.next();
            if (v0_7.hasNext()) {
                ((hb.a) v1_0).getClass();
                do {
                    ((hb.a) v0_7.next()).getClass();
                } while(v0_7.hasNext());
            }
        }
        if (((hb.a) v1_0) == null) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. \'kotlinx-coroutines-android\' and ensure it has the same version as \'kotlinx-coroutines-core\'");
            return;
        } else {
            String v0_11 = android.os.Looper.getMainLooper();
            if (v0_11 == null) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("The main looper is not available");
                return;
            } else {
                lb.k.a = new hb.d(hb.e.a(v0_11), 0);
                return;
            }
        }
    }
}
