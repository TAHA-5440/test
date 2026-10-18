// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.random;
final class Random$Default$Serialized implements java.io.Serializable {
    public static final kotlin.random.Random$Default$Serialized g;
    private static final long serialVersionUID;

    static Random$Default$Serialized()
    {
        kotlin.random.Random$Default$Serialized.g = new kotlin.random.Random$Default$Serialized();
        return;
    }

    private final Object readResolve()
    {
        return ya.c.g;
    }
}
