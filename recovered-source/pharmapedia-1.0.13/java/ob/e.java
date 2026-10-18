// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ob;
public abstract class e {
    public static final int a;
    public static final com.google.gson.internal.b b;
    public static final com.google.gson.internal.b c;
    public static final com.google.gson.internal.b d;
    public static final com.google.gson.internal.b e;
    public static final int f;

    static e()
    {
        ob.e.a = lb.a.j(100, 12, "kotlinx.coroutines.semaphore.maxSpinCycles");
        ob.e.b = new com.google.gson.internal.b("PERMIT", 3);
        ob.e.c = new com.google.gson.internal.b("TAKEN", 3);
        ob.e.d = new com.google.gson.internal.b("BROKEN", 3);
        ob.e.e = new com.google.gson.internal.b("CANCELLED", 3);
        ob.e.f = lb.a.j(16, 12, "kotlinx.coroutines.semaphore.segmentSize");
        return;
    }
}
