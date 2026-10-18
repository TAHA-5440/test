// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.enums;
public final class EnumEntriesSerializationProxy implements java.io.Serializable {
    private static final long serialVersionUID;
    public final Class g;

    public EnumEntriesSerializationProxy(Enum[] p1)
    {
        p1.getClass();
        Class v1_2 = p1.getClass().getComponentType();
        v1_2.getClass();
        this.g = v1_2;
        return;
    }

    private final Object readResolve()
    {
        Enum[] v0_1 = this.g.getEnumConstants();
        v0_1.getClass();
        return new kotlin.enums.EnumEntriesList(((Enum[]) v0_1));
    }
}
