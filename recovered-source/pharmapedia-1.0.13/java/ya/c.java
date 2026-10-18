// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ya;
public abstract class c {
    public static final kotlin.random.Random$Default g;
    public static final ya.a h;

    static c()
    {
        ya.b v0_2;
        ya.c.g = new kotlin.random.Random$Default();
        ya.b v0_4 = qa.a.a;
        if ((v0_4 != null) && (v0_4.intValue() < 34)) {
            v0_2 = new ya.b();
        } else {
            v0_2 = new za.a();
        }
        ya.c.h = v0_2;
        return;
    }

    public c()
    {
        return;
    }

    public abstract int a(int p0);
}
