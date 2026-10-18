// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package nb;
public abstract class i {
    public static final String a;
    public static final long b;
    public static final int c;
    public static final int d;
    public static final long e;
    public static final nb.f f;

    static i()
    {
        try {
            nb.f v0_6 = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException) {
            v0_6 = 0;
        }
        if (v0_6 == null) {
            v0_6 = "DefaultDispatcher";
        }
        nb.i.a = v0_6;
        nb.i.b = lb.a.i(100000, 1, 9223372036854775807, "kotlinx.coroutines.scheduler.resolution.ns");
        nb.f v0_2 = lb.r.a;
        if (v0_2 < 2) {
            v0_2 = 2;
        }
        nb.i.c = lb.a.j(v0_2, 8, "kotlinx.coroutines.scheduler.core.pool.size");
        nb.i.d = lb.a.j(2097150, 4, "kotlinx.coroutines.scheduler.max.pool.size");
        nb.i.e = java.util.concurrent.TimeUnit.SECONDS.toNanos(lb.a.i(60, 1, 9223372036854775807, "kotlinx.coroutines.scheduler.keep.alive.sec"));
        nb.i.f = nb.f.a;
        return;
    }
}
