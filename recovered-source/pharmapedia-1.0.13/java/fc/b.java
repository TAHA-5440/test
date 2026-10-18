// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public final class b {
    public static final okio.ByteString d;
    public static final okio.ByteString e;
    public static final okio.ByteString f;
    public static final okio.ByteString g;
    public static final okio.ByteString h;
    public static final okio.ByteString i;
    public final okio.ByteString a;
    public final okio.ByteString b;
    public final int c;

    static b()
    {
        fc.b.d = n5.f.o(":");
        fc.b.e = n5.f.o(":status");
        fc.b.f = n5.f.o(":method");
        fc.b.g = n5.f.o(":path");
        fc.b.h = n5.f.o(":scheme");
        fc.b.i = n5.f.o(":authority");
        return;
    }

    public b(String p2, String p3)
    {
        this(n5.f.o(p2), n5.f.o(p3));
        return;
    }

    public b(okio.ByteString p2, String p3)
    {
        p2.getClass();
        p3.getClass();
        this(p2, n5.f.o(p3));
        return;
    }

    public b(okio.ByteString p1, okio.ByteString p2)
    {
        p1.getClass();
        p2.getClass();
        this.a = p1;
        this.b = p2;
        this.c = (p2.e() + (p1.e() + 32));
        return;
    }

    public final boolean equals(Object p5)
    {
        if (this != p5) {
            if ((p5 instanceof fc.b)) {
                if (kotlin.jvm.internal.f.a(this.a, ((fc.b) p5).a)) {
                    if (kotlin.jvm.internal.f.a(this.b, ((fc.b) p5).b)) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
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
        return (this.b.hashCode() + (this.a.hashCode() * 31));
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder();
        v0_1.append(this.a.t());
        v0_1.append(": ");
        v0_1.append(this.b.t());
        return v0_1.toString();
    }
}
