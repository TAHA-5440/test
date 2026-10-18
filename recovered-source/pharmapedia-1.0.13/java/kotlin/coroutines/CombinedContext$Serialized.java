// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.coroutines;
final class CombinedContext$Serialized implements java.io.Serializable {
    private static final long serialVersionUID;
    public final ka.g[] g;

    public CombinedContext$Serialized(ka.g[] p1)
    {
        this.g = p1;
        return;
    }

    private final Object readResolve()
    {
        ka.g[] v0 = this.g;
        int v1 = v0.length;
        ka.g v2 = kotlin.coroutines.EmptyCoroutineContext.g;
        int v3 = 0;
        while (v3 < v1) {
            v2 = v2.L(v0[v3]);
            v3++;
        }
        return v2;
    }
}
