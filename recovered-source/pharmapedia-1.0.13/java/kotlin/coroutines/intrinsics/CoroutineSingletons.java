// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.coroutines.intrinsics;
public final enum class CoroutineSingletons extends java.lang.Enum {
    public static final enum kotlin.coroutines.intrinsics.CoroutineSingletons g;
    public static final enum kotlin.coroutines.intrinsics.CoroutineSingletons h;
    public static final enum kotlin.coroutines.intrinsics.CoroutineSingletons i;
    public static final synthetic kotlin.coroutines.intrinsics.CoroutineSingletons[] j;

    static CoroutineSingletons()
    {
        kotlin.coroutines.intrinsics.CoroutineSingletons[] v0_2 = new kotlin.coroutines.intrinsics.CoroutineSingletons("COROUTINE_SUSPENDED", 0);
        kotlin.coroutines.intrinsics.CoroutineSingletons.g = v0_2;
        kotlin.coroutines.intrinsics.CoroutineSingletons v1_2 = new kotlin.coroutines.intrinsics.CoroutineSingletons("UNDECIDED", 1);
        kotlin.coroutines.intrinsics.CoroutineSingletons.h = v1_2;
        kotlin.coroutines.intrinsics.CoroutineSingletons v2_1 = new kotlin.coroutines.intrinsics.CoroutineSingletons("RESUMED", 2);
        kotlin.coroutines.intrinsics.CoroutineSingletons.i = v2_1;
        kotlin.coroutines.intrinsics.CoroutineSingletons[] v0_1 = new kotlin.coroutines.intrinsics.CoroutineSingletons[] {v0_2, v1_2, v2_1});
        kotlin.coroutines.intrinsics.CoroutineSingletons.j = v0_1;
        kotlin.enums.a.a(v0_1);
        return;
    }

    public static kotlin.coroutines.intrinsics.CoroutineSingletons valueOf(String p1)
    {
        return ((kotlin.coroutines.intrinsics.CoroutineSingletons) Enum.valueOf(kotlin.coroutines.intrinsics.CoroutineSingletons, p1));
    }

    public static kotlin.coroutines.intrinsics.CoroutineSingletons[] values()
    {
        return ((kotlin.coroutines.intrinsics.CoroutineSingletons[]) kotlin.coroutines.intrinsics.CoroutineSingletons.j.clone());
    }
}
