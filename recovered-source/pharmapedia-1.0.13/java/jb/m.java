// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package jb;
public abstract class m {
    public static final com.google.gson.internal.b a;
    public static final com.google.gson.internal.b b;
    public static final com.google.gson.internal.b c;

    static synthetic m()
    {
        jb.m.a = new com.google.gson.internal.b("NO_VALUE", 3);
        jb.m.b = new com.google.gson.internal.b("NONE", 3);
        jb.m.c = new com.google.gson.internal.b("PENDING", 3);
        return;
    }

    public static final void a(Object[] p0, long p1, Object p3)
    {
        p0[(((int) p1) & (p0.length - 1))] = p3;
        return;
    }
}
