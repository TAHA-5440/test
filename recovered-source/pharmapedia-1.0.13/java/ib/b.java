// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ib;
public abstract class b {
    public static final ib.h a;
    public static final int b;
    public static final int c;
    public static final com.google.gson.internal.b d;
    public static final com.google.gson.internal.b e;
    public static final com.google.gson.internal.b f;
    public static final com.google.gson.internal.b g;
    public static final com.google.gson.internal.b h;
    public static final com.google.gson.internal.b i;
    public static final com.google.gson.internal.b j;
    public static final com.google.gson.internal.b k;
    public static final com.google.gson.internal.b l;
    public static final com.google.gson.internal.b m;
    public static final com.google.gson.internal.b n;
    public static final com.google.gson.internal.b o;
    public static final com.google.gson.internal.b p;
    public static final com.google.gson.internal.b q;
    public static final com.google.gson.internal.b r;
    public static final com.google.gson.internal.b s;

    static b()
    {
        ib.b.a = new ib.h(-1, 0, 0, 0);
        ib.b.b = lb.a.j(32, 12, "kotlinx.coroutines.bufferedChannel.segmentSize");
        ib.b.c = lb.a.j(10000, 12, "kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations");
        ib.b.d = new com.google.gson.internal.b("BUFFERED", 3);
        ib.b.e = new com.google.gson.internal.b("SHOULD_BUFFER", 3);
        ib.b.f = new com.google.gson.internal.b("S_RESUMING_BY_RCV", 3);
        ib.b.g = new com.google.gson.internal.b("RESUMING_BY_EB", 3);
        ib.b.h = new com.google.gson.internal.b("POISONED", 3);
        ib.b.i = new com.google.gson.internal.b("DONE_RCV", 3);
        ib.b.j = new com.google.gson.internal.b("INTERRUPTED_SEND", 3);
        ib.b.k = new com.google.gson.internal.b("INTERRUPTED_RCV", 3);
        ib.b.l = new com.google.gson.internal.b("CHANNEL_CLOSED", 3);
        ib.b.m = new com.google.gson.internal.b("SUSPEND", 3);
        ib.b.n = new com.google.gson.internal.b("SUSPEND_NO_WAITER", 3);
        ib.b.o = new com.google.gson.internal.b("FAILED", 3);
        ib.b.p = new com.google.gson.internal.b("NO_RECEIVE_RESULT", 3);
        ib.b.q = new com.google.gson.internal.b("CLOSE_HANDLER_CLOSED", 3);
        ib.b.r = new com.google.gson.internal.b("CLOSE_HANDLER_INVOKED", 3);
        ib.b.s = new com.google.gson.internal.b("NO_CLOSE_CAUSE", 3);
        return;
    }
}
