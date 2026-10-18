// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kc;
public final class a extends java.net.ProxySelector {
    public static final kc.a a;

    static a()
    {
        kc.a.a = new kc.a();
        return;
    }

    public final void connectFailed(java.net.URI p1, java.net.SocketAddress p2, java.io.IOException p3)
    {
        return;
    }

    public final java.util.List select(java.net.URI p1)
    {
        if (p1 == 0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("uri must not be null");
            return 0;
        } else {
            return com.bumptech.glide.e.l(java.net.Proxy.NO_PROXY);
        }
    }
}
