// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.serialization.json.internal;
final class JsonTreeReader$readObject$2 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
    public ga.b g;
    public kotlinx.serialization.json.internal.b h;
    public java.util.LinkedHashMap i;
    public String j;
    public synthetic Object k;
    public final synthetic kotlinx.serialization.json.internal.b l;
    public int m;

    public JsonTreeReader$readObject$2(kotlinx.serialization.json.internal.b p1, kotlin.coroutines.jvm.internal.BaseContinuationImpl p2)
    {
        this.l = p1;
        super(p2);
        return;
    }

    public final Object invokeSuspend(Object p2)
    {
        this.k = p2;
        this.m = (this.m | -2147483648);
        return kotlinx.serialization.json.internal.b.a(this.l, 0, this);
    }
}
