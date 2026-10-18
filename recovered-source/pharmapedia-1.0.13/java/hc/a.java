// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package hc;
public abstract class a {
    public static final ea.c a;

    static a()
    {
        hc.a.a = new ea.c(17);
        return;
    }

    public static final int a(int p1, String p2)
    {
        return ((p2.charAt(p1) << 7) + p2.charAt((p1 + 1)));
    }
}
