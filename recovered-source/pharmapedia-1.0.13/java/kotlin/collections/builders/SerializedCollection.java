// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.collections.builders;
public final class SerializedCollection implements java.io.Externalizable {
    private static final long serialVersionUID;
    public java.util.AbstractCollection g;
    public final int h;

    public SerializedCollection(java.util.AbstractCollection p1, int p2)
    {
        this.g = p1;
        this.h = p2;
        return;
    }

    private final Object readResolve()
    {
        return this.g;
    }

    public final void readExternal(java.io.ObjectInput p5)
    {
        p5.getClass();
        int v0_1 = p5.readByte();
        kotlin.collections.builders.SetBuilder v1_2 = (v0_1 & 1);
        if ((v0_1 & -2) != 0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.p(v0_1, "Unsupported flags value: ");
            return;
        } else {
            int v0_0 = p5.readInt();
            if (v0_0 < 0) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.p(v0_0, "Illegal size value: ");
                return;
            } else {
                kotlin.collections.builders.SetBuilder v5_2;
                int v2_0 = 0;
                if (v1_2 == null) {
                    kotlin.collections.builders.SetBuilder v1_1 = new kotlin.collections.builders.ListBuilder(v0_0);
                    while (v2_0 < v0_0) {
                        v1_1.add(p5.readObject());
                        v2_0++;
                    }
                    v5_2 = com.bumptech.glide.e.b(v1_1);
                } else {
                    if (v1_2 != 1) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.p(v1_2, "Unsupported collection type tag: ");
                        return;
                    } else {
                        kotlin.collections.builders.SetBuilder v1_4 = new kotlin.collections.builders.SetBuilder(v0_0);
                        while (v2_0 < v0_0) {
                            v1_4.add(p5.readObject());
                            v2_0++;
                        }
                        v5_2 = com.bumptech.glide.g.c(v1_4);
                    }
                }
                this.g = v5_2;
                return;
            }
        }
    }

    public final void writeExternal(java.io.ObjectOutput p3)
    {
        p3.getClass();
        p3.writeByte(this.h);
        p3.writeInt(this.g.size());
        java.util.Iterator v0_4 = this.g.iterator();
        while (v0_4.hasNext()) {
            p3.writeObject(v0_4.next());
        }
        return;
    }
}
