// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public abstract class g1 {
    public static final ThreadLocal a;

    static g1()
    {
        gb.g1.a = new ThreadLocal();
        return;
    }

    public static gb.j0 a()
    {
        ThreadLocal v0 = gb.g1.a;
        gb.d v1_1 = ((gb.j0) v0.get());
        if (v1_1 == null) {
            v1_1 = new gb.d(Thread.currentThread());
            v0.set(v1_1);
        }
        return v1_1;
    }
}
