// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kb;
public abstract class b {
    public static final ka.c[] a;
    public static final com.google.gson.internal.b b;

    static synthetic b()
    {
        com.google.gson.internal.b v0_1 = new ka.c[0];
        kb.b.a = v0_1;
        kb.b.b = new com.google.gson.internal.b("NULL", 3);
        return;
    }

    public static final Object a(ka.g p2, Object p3, Object p4, ua.p p5, ka.c p6)
    {
        Object v4_1 = lb.a.l(p2, p4);
        Object v3_1;
        kb.j v0_1 = new kb.j(p6, p2);
        if (p5 != null) {
            kotlin.jvm.internal.j.c(2, p5);
            v3_1 = p5.invoke(p3, v0_1);
        } else {
            v3_1 = a.a.w(p5, p3, v0_1);
        }
        lb.a.g(p2, v4_1);
        if (v3_1 == kotlin.coroutines.intrinsics.CoroutineSingletons.g) {
            p6.getClass();
        }
        return v3_1;
    }
}
