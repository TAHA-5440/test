// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.jvm.internal;
 class CallableReference$NoReceiver implements java.io.Serializable {
    public static final kotlin.jvm.internal.CallableReference$NoReceiver g;

    static CallableReference$NoReceiver()
    {
        kotlin.jvm.internal.CallableReference$NoReceiver.g = new kotlin.jvm.internal.CallableReference$NoReceiver();
        return;
    }

    private Object readResolve()
    {
        return kotlin.jvm.internal.CallableReference$NoReceiver.g;
    }
}
