// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package lb;
public abstract class d {
    public static final java.util.List a;

    static d()
    {
        try {
            Throwable v0_8 = java.util.Arrays.asList(new hb.b[] {new hb.b()})).iterator();
            v0_8.getClass();
            lb.d.a = cb.i.q(new cb.a(new cb.j(v0_8, 0)));
            return;
        } catch (Throwable v0_5) {
            throw new java.util.ServiceConfigurationError(v0_5.getMessage(), v0_5);
        }
    }
}
