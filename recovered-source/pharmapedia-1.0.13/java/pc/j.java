// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package pc;
public final class j extends oc.e {
    public final java.net.Socket n;

    public j(java.net.Socket p1)
    {
        this.n = p1;
        return;
    }

    public final void j()
    {
        java.net.Socket v1 = this.n;
        try {
            v1.close();
            return;
        } catch (AssertionError v2_0) {
            StringBuilder v5_3 = new StringBuilder("Failed to close timed out socket ");
            v5_3.append(v1);
            pc.n.a.log(java.util.logging.Level.WARNING, v5_3.toString(), v2_0);
            return;
        } catch (AssertionError v2_1) {
            if (!pc.n.a(v2_1)) {
                throw v2_1;
            } else {
                StringBuilder v5_1 = new StringBuilder("Failed to close timed out socket ");
                v5_1.append(v1);
                pc.n.a.log(java.util.logging.Level.WARNING, v5_1.toString(), v2_1);
                return;
            }
        }
    }

    public final java.io.IOException k(java.io.IOException p3)
    {
        java.net.SocketTimeoutException v0_1 = new java.net.SocketTimeoutException("timeout");
        if (p3 != null) {
            v0_1.initCause(p3);
        }
        return v0_1;
    }
}
