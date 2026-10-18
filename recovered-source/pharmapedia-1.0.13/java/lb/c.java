// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package lb;
public final class c implements gb.v {
    public final ka.g g;

    public c(ka.g p1)
    {
        this.g = p1;
        return;
    }

    public final ka.g M()
    {
        return this.g;
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder("CoroutineScope(coroutineContext=");
        v0_1.append(this.g);
        v0_1.append(41);
        return v0_1.toString();
    }
}
