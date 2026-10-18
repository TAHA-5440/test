// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin;
public abstract class a {

    public static ga.e a(kotlin.LazyThreadSafetyMode p2, ua.a p3)
    {
        ga.m v0 = ga.m.a;
        int v2_4 = p2.ordinal();
        if (v2_4 == 0) {
            return new kotlin.SynchronizedLazyImpl(p3);
        } else {
            if (v2_4 == 1) {
                int v2_1 = new kotlin.SafePublicationLazyImpl();
                v2_1.g = p3;
                v2_1.h = v0;
                return v2_1;
            } else {
                if (v2_4 != 2) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.s();
                    return 0;
                } else {
                    int v2_5 = new kotlin.UnsafeLazyImpl();
                    v2_5.g = p3;
                    v2_5.h = v0;
                    return v2_5;
                }
            }
        }
    }

    public static ga.e b(ua.a p1)
    {
        p1.getClass();
        return new kotlin.SynchronizedLazyImpl(p1);
    }
}
