// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.channels;
final synthetic class BufferedChannelKt$createSegmentFunction$1 extends kotlin.jvm.internal.FunctionReferenceImpl implements ua.p {
    public static final kotlinx.coroutines.channels.BufferedChannelKt$createSegmentFunction$1 g;

    static BufferedChannelKt$createSegmentFunction$1()
    {
        kotlinx.coroutines.channels.BufferedChannelKt$createSegmentFunction$1.g = new kotlinx.coroutines.channels.BufferedChannelKt$createSegmentFunction$1(2, ib.b, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        return;
    }

    public final Object invoke(Object p7, Object p8)
    {
        long v1 = ((Number) p7).longValue();
        kotlinx.coroutines.channels.a v4 = ((ib.h) p8).e;
        v4.getClass();
        return new ib.h(v1, ((ib.h) p8), v4, 0);
    }
}
