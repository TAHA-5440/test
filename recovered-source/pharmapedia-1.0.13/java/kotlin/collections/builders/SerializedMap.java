// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.collections.builders;
final class SerializedMap implements java.io.Externalizable {
    private static final long serialVersionUID;
    public kotlin.collections.builders.MapBuilder g;

    private final Object readResolve()
    {
        return this.g;
    }

    public final void readExternal(java.io.ObjectInput p6)
    {
        p6.getClass();
        String v0_1 = p6.readByte();
        if (v0_1 != null) {
            throw new java.io.InvalidObjectException(r1.a.g(v0_1, "Unsupported flags value: "));
        } else {
            String v0_0 = p6.readInt();
            if (v0_0 < null) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.p(v0_0, "Illegal size value: ");
                return;
            } else {
                kotlin.collections.builders.MapBuilder v1_1 = new kotlin.collections.builders.MapBuilder(v0_0);
                int v2 = 0;
                while (v2 < v0_0) {
                    v1_1.put(p6.readObject(), p6.readObject());
                    v2++;
                }
                this.g = v1_1.b();
                return;
            }
        }
    }

    public final void writeExternal(java.io.ObjectOutput p4)
    {
        p4.getClass();
        p4.writeByte(0);
        p4.writeInt(this.g.o);
        java.util.Iterator v0_1 = ((ia.d) this.g.entrySet()).iterator();
        while (v0_1.hasNext()) {
            Object v1_2 = ((java.util.Map$Entry) v0_1.next());
            p4.writeObject(v1_2.getKey());
            p4.writeObject(v1_2.getValue());
        }
        return;
    }
}
