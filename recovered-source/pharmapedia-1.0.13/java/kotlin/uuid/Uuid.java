// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.uuid;
public final class Uuid implements java.lang.Comparable, java.io.Serializable {
    public static final kotlin.uuid.Uuid i;
    public final long g;
    public final long h;

    static Uuid()
    {
        kotlin.uuid.Uuid.i = new kotlin.uuid.Uuid(0, 0);
        return;
    }

    public Uuid(long p1, long p3)
    {
        this.g = p1;
        this.h = p3;
        return;
    }

    private final void readObject(java.io.ObjectInputStream p2)
    {
        throw new java.io.InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace()
    {
        kotlin.uuid.UuidSerialized v0_1 = new kotlin.uuid.UuidSerialized();
        v0_1.g = this.g;
        v0_1.h = this.h;
        return v0_1;
    }

    public final int compareTo(Object p8)
    {
        ((kotlin.uuid.Uuid) p8).getClass();
        long v0_2 = ((kotlin.uuid.Uuid) p8).g;
        long v2_1 = this.g;
        if (v2_1 == v0_2) {
            return Long.compare((this.h ^ -9223372036854775808), (((kotlin.uuid.Uuid) p8).h ^ -9223372036854775808));
        } else {
            return Long.compare((v2_1 ^ -9223372036854775808), (v0_2 ^ -9223372036854775808));
        }
    }

    public final boolean equals(Object p8)
    {
        if (this != p8) {
            if ((p8 instanceof kotlin.uuid.Uuid)) {
                if ((this.g != ((kotlin.uuid.Uuid) p8).g) || (this.h != ((kotlin.uuid.Uuid) p8).h)) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }

    public final int hashCode()
    {
        return Long.hashCode((this.g ^ this.h));
    }

    public final String toString()
    {
        byte[] v3 = new byte[36];
        com.bumptech.glide.e.g(this.g, v3, 0, 0, 4);
        v3[8] = 45;
        com.bumptech.glide.e.g(this.g, v3, 9, 4, 6);
        v3[13] = 45;
        com.bumptech.glide.e.g(this.g, v3, 14, 6, 8);
        v3[18] = 45;
        com.bumptech.glide.e.g(this.h, v3, 19, 0, 2);
        v3[23] = 45;
        com.bumptech.glide.e.g(this.h, v3, 24, 2, 8);
        return new String(v3, db.a.a);
    }
}
