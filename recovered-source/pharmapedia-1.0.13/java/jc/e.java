// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package jc;
public class e implements jc.n {
    public static final ea.c e;
    public final Class a;
    public final reflect.Method b;
    public final reflect.Method c;
    public final reflect.Method d;

    static e()
    {
        jc.e.e = new ea.c(20);
        return;
    }

    public e(Class p3)
    {
        this.a = p3;
        Class[] v0_8 = p3.getDeclaredMethod("setUseSessionTickets", new Class[] {Boolean.TYPE}));
        v0_8.getClass();
        this.b = v0_8;
        p3.getMethod("setHostname", new Class[] {String}));
        this.c = p3.getMethod("getAlpnSelectedProtocol", 0);
        this.d = p3.getMethod("setAlpnProtocols", new Class[] {byte[]}));
        return;
    }

    public final boolean a()
    {
        return ic.c.e;
    }

    public final boolean b(javax.net.ssl.SSLSocket p2)
    {
        return this.a.isInstance(p2);
    }

    public final String c(javax.net.ssl.SSLSocket p4)
    {
        if (this.a.isInstance(p4)) {
            try {
                int v4_5 = ((byte[]) this.c.invoke(p4, 0));
            } catch (int v4_2) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.g(v4_2);
                return 0;
            } catch (int v4_1) {
                boolean v0_1 = v4_1.getCause();
                if ((v0_1 instanceof NullPointerException)) {
                    if (kotlin.jvm.internal.f.a(((NullPointerException) v0_1).getMessage(), "ssl == null")) {
                        return 0;
                    }
                }
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.g(v4_1);
                return 0;
            }
            if (v4_5 != 0) {
                return new String(v4_5, db.a.a);
            }
        }
        return 0;
    }

    public final void d(javax.net.ssl.SSLSocket p2, String p3, java.util.List p4)
    {
        p4.getClass();
        if (this.a.isInstance(p2)) {
            try {
                this.b.invoke(p2, new Object[] {Boolean.TRUE}));
                this.d.invoke(p2, new Object[] {n5.f.k(p4)}));
                return;
            } catch (reflect.InvocationTargetException v2_2) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.g(v2_2);
            } catch (reflect.InvocationTargetException v2_1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.g(v2_1);
                return;
            }
        }
        return;
    }
}
