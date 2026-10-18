// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.channels;
public final enum class BufferOverflow extends java.lang.Enum {
    public static final enum kotlinx.coroutines.channels.BufferOverflow g;
    public static final enum kotlinx.coroutines.channels.BufferOverflow h;
    public static final enum kotlinx.coroutines.channels.BufferOverflow i;
    public static final synthetic kotlinx.coroutines.channels.BufferOverflow[] j;

    static BufferOverflow()
    {
        kotlinx.coroutines.channels.BufferOverflow[] v0_2 = new kotlinx.coroutines.channels.BufferOverflow("SUSPEND", 0);
        kotlinx.coroutines.channels.BufferOverflow.g = v0_2;
        kotlinx.coroutines.channels.BufferOverflow v1_2 = new kotlinx.coroutines.channels.BufferOverflow("DROP_OLDEST", 1);
        kotlinx.coroutines.channels.BufferOverflow.h = v1_2;
        kotlinx.coroutines.channels.BufferOverflow v2_1 = new kotlinx.coroutines.channels.BufferOverflow("DROP_LATEST", 2);
        kotlinx.coroutines.channels.BufferOverflow.i = v2_1;
        kotlinx.coroutines.channels.BufferOverflow[] v0_1 = new kotlinx.coroutines.channels.BufferOverflow[] {v0_2, v1_2, v2_1});
        kotlinx.coroutines.channels.BufferOverflow.j = v0_1;
        kotlin.enums.a.a(v0_1);
        return;
    }

    public static kotlinx.coroutines.channels.BufferOverflow valueOf(String p1)
    {
        return ((kotlinx.coroutines.channels.BufferOverflow) Enum.valueOf(kotlinx.coroutines.channels.BufferOverflow, p1));
    }

    public static kotlinx.coroutines.channels.BufferOverflow[] values()
    {
        return ((kotlinx.coroutines.channels.BufferOverflow[]) kotlinx.coroutines.channels.BufferOverflow.j.clone());
    }
}
