// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package xc;
public final class h extends androidx.lifecycle.g0 {
    public final f7.a l;
    public final android.net.ConnectivityManager m;

    public h(android.content.Context p3)
    {
        this.l = new f7.a(this, 2);
        android.net.ConnectivityManager v3_1 = p3.getSystemService("connectivity");
        v3_1.getClass();
        this.m = ((android.net.ConnectivityManager) v3_1);
        return;
    }

    public final void f()
    {
        this.m.registerNetworkCallback(new android.net.NetworkRequest$Builder().build(), this.l);
        return;
    }

    public final void g()
    {
        this.m.unregisterNetworkCallback(this.l);
        return;
    }
}
