// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cc;
public abstract synthetic class d {
    public static final synthetic int[] a;

    static d()
    {
        int[] v0_2 = new int[java.net.Proxy$Type.values().length];
        java.net.Proxy$Type.DIRECT.ordinal()[int v1_2] = 1;
        try {
            java.net.Proxy$Type.HTTP.ordinal()[int v1_0] = 2;
        } catch (NoSuchFieldError) {
        }
        cc.d.a = v0_2;
        return;
    }
}
