// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class k1 extends gb.s {
    public static final gb.k1 i;

    static k1()
    {
        gb.k1.i = new gb.k1();
        return;
    }

    public final void d0(ka.g p1, Runnable p2)
    {
        String v1_2 = ((gb.o1) p1.Z(gb.o1.i));
        if (v1_2 == null) {
            androidx.fragment.app.a.i("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
            return;
        } else {
            v1_2.h = 1;
            return;
        }
    }

    public final gb.s g0(int p1, String p2)
    {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    public final String toString()
    {
        return "Dispatchers.Unconfined";
    }
}
