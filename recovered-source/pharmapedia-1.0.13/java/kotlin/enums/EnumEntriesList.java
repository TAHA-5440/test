// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.enums;
final class EnumEntriesList extends ha.d implements na.a, java.util.RandomAccess, java.io.Serializable {
    public final Enum[] g;

    public EnumEntriesList(Enum[] p1)
    {
        p1.getClass();
        this.g = p1;
        return;
    }

    private final void readObject(java.io.ObjectInputStream p2)
    {
        throw new java.io.InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace()
    {
        return new kotlin.enums.EnumEntriesSerializationProxy(this.g);
    }

    public final int a()
    {
        return this.g.length;
    }

    public final boolean contains(Object p4)
    {
        if ((p4 instanceof Enum)) {
            if (((Enum) ha.i.P(((Enum) p4).ordinal(), this.g)) != ((Enum) p4)) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    }

    public final Object get(int p4)
    {
        String v0_0 = this.g;
        int v1 = v0_0.length;
        if ((p4 < null) || (p4 >= v1)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.l("index: ", ", size: ", p4, v1));
            return 0;
        } else {
            return v0_0[p4];
        }
    }

    public final int indexOf(Object p4)
    {
        if ((p4 instanceof Enum)) {
            int v0_1 = ((Enum) p4).ordinal();
            if (((Enum) ha.i.P(v0_1, this.g)) != ((Enum) p4)) {
                return -1;
            } else {
                return v0_1;
            }
        } else {
            return -1;
        }
    }

    public final int lastIndexOf(Object p4)
    {
        if ((p4 instanceof Enum)) {
            int v0_1 = ((Enum) p4).ordinal();
            if (((Enum) ha.i.P(v0_1, this.g)) != ((Enum) p4)) {
                return -1;
            } else {
                return v0_1;
            }
        } else {
            return -1;
        }
    }
}
