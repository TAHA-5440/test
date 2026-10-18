// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package okhttp3.internal.http2;
public final class StreamResetException extends java.io.IOException {
    public final okhttp3.internal.http2.ErrorCode g;

    public StreamResetException(okhttp3.internal.http2.ErrorCode p3)
    {
        String v0_1 = new StringBuilder("stream was reset: ");
        v0_1.append(p3);
        super(v0_1.toString());
        super.g = p3;
        return;
    }
}
