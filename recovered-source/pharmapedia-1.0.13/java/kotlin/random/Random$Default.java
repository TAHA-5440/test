// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.random;
public final class Random$Default extends ya.c implements java.io.Serializable {

    private final void readObject(java.io.ObjectInputStream p2)
    {
        throw new java.io.InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace()
    {
        return kotlin.random.Random$Default$Serialized.g;
    }

    public final int a(int p2)
    {
        return ya.c.h.a(p2);
    }
}
