// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.uuid;
final class UuidSerialized implements java.io.Externalizable {
    private static final long serialVersionUID;
    public long g;
    public long h;

    private final Object readResolve()
    {
        kotlin.uuid.Uuid v0_1;
        kotlin.uuid.Uuid v0_0 = this.g;
        long v2 = this.h;
        if ((v0_0 != 0) || (v2 != 0)) {
            v0_1 = new kotlin.uuid.Uuid(v0_0, v2);
        } else {
            v0_1 = kotlin.uuid.Uuid.i;
        }
        return v0_1;
    }

    public final void readExternal(java.io.ObjectInput p3)
    {
        p3.getClass();
        this.g = p3.readLong();
        this.h = p3.readLong();
        return;
    }

    public final void writeExternal(java.io.ObjectOutput p3)
    {
        p3.getClass();
        p3.writeLong(this.g);
        p3.writeLong(this.h);
        return;
    }
}
