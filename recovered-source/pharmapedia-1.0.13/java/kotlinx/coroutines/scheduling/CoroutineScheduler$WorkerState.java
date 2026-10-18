// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.scheduling;
public final enum class CoroutineScheduler$WorkerState extends java.lang.Enum {
    public static final enum kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState g;
    public static final enum kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState h;
    public static final enum kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState i;
    public static final enum kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState j;
    public static final enum kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState k;
    public static final synthetic kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState[] l;

    static CoroutineScheduler$WorkerState()
    {
        kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState[] v0_2 = new kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState("CPU_ACQUIRED", 0);
        kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.g = v0_2;
        kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState v1_2 = new kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState("BLOCKING", 1);
        kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.h = v1_2;
        kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState v2_1 = new kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState("PARKING", 2);
        kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.i = v2_1;
        kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState v3_2 = new kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState("DORMANT", 3);
        kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.j = v3_2;
        kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState v4_3 = new kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState("TERMINATED", 4);
        kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.k = v4_3;
        kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState[] v0_1 = new kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState[] {v0_2, v1_2, v2_1, v3_2, v4_3});
        kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.l = v0_1;
        kotlin.enums.a.a(v0_1);
        return;
    }

    public static kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState valueOf(String p1)
    {
        return ((kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState) Enum.valueOf(kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState, p1));
    }

    public static kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState[] values()
    {
        return ((kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState[]) kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState.l.clone());
    }
}
