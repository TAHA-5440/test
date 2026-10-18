// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package xc;
public final class g {
    public final android.net.ConnectivityManager a;

    public g(android.net.ConnectivityManager p1)
    {
        p1.getClass();
        this.a = p1;
        return;
    }

    public final boolean a()
    {
        boolean v0_0 = this.a;
        try {
            boolean v0_1 = v0_0.getNetworkCapabilities(v0_0.getActiveNetwork());
        } catch (Exception) {
            return 0;
        }
        if ((!v0_1) || (v0_1.hasCapability(12) != 1)) {
            return 0;
        } else {
            return 1;
        }
    }
}
