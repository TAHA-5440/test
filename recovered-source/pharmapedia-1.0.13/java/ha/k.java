// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ha;
public abstract class k extends com.bumptech.glide.e {

    public static int t(java.util.List p0)
    {
        p0.getClass();
        return (p0.size() - 1);
    }

    public static varargs java.util.List u(Object[] p1)
    {
        if (p1.length <= 0) {
            return kotlin.collections.EmptyList.g;
        } else {
            kotlin.collections.EmptyList v1_2 = java.util.Arrays.asList(p1);
            v1_2.getClass();
            return v1_2;
        }
    }

    public static varargs java.util.ArrayList v(Object[] p3)
    {
        if (p3.length != 0) {
            return new java.util.ArrayList(new ha.g(p3, 1));
        } else {
            return new java.util.ArrayList();
        }
    }

    public static final java.util.List w(java.util.List p2)
    {
        int v0_0 = p2.size();
        if (v0_0 == 0) {
            return kotlin.collections.EmptyList.g;
        } else {
            if (v0_0 == 1) {
                return com.bumptech.glide.e.l(p2.get(0));
            } else {
                return p2;
            }
        }
    }

    public static void x()
    {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
