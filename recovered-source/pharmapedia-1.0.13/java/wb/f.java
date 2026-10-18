// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package wb;
public final class f extends com.bumptech.glide.j {
    public final e0.x a;

    public f(e0.x p1, vb.b p2)
    {
        p2.getClass();
        this.a = p1;
        return;
    }

    public final int h()
    {
        int v0 = this.a;
        String v1_1 = v0.j();
        try {
            v1_1.getClass();
            int v3_2 = com.bumptech.glide.e.q(v1_1);
        } catch (IllegalArgumentException) {
            e0.x.l(v0, r1.a.k("Failed to parse type \'UInt\' for input \'", v1_1, 39), 0, 6);
            throw 0;
        }
        if (v3_2 == 0) {
            db.p.M(v1_1);
            throw 0;
        } else {
            v0 = v3_2.g;
            return v0;
        }
    }

    public final long m()
    {
        long v0 = this.a;
        String v1_1 = v0.j();
        try {
            v1_1.getClass();
            int v3_2 = com.bumptech.glide.e.r(v1_1);
        } catch (IllegalArgumentException) {
            e0.x.l(v0, r1.a.k("Failed to parse type \'ULong\' for input \'", v1_1, 39), 0, 6);
            throw 0;
        }
        if (v3_2 == 0) {
            db.p.M(v1_1);
            throw 0;
        } else {
            v0 = v3_2.g;
            return v0;
        }
    }

    public final int q(sb.d p2)
    {
        p2.getClass();
        throw new IllegalStateException("unsupported");
    }

    public final byte w()
    {
        byte v0 = this.a;
        String v1_0 = v0.j();
        try {
            ga.f v4_3;
            v1_0.getClass();
            byte v3_3 = com.bumptech.glide.e.q(v1_0);
        } catch (IllegalArgumentException) {
            e0.x.l(v0, r1.a.k("Failed to parse type \'UByte\' for input \'", v1_0, 39), 0, 6);
            throw 0;
        }
        if (v3_3 == 0) {
            v4_3 = 0;
        } else {
            byte v3_4 = v3_3.g;
            if (Integer.compare((-2147483648 ^ v3_4), -2147483393) <= 0) {
                v4_3 = new ga.f(((byte) v3_4));
            } else {
            }
        }
        if (v4_3 == null) {
            db.p.M(v1_0);
            throw 0;
        } else {
            v0 = v4_3.g;
            return v0;
        }
    }

    public final short y()
    {
        short v0 = this.a;
        String v1_0 = v0.j();
        try {
            ga.n v4_3;
            v1_0.getClass();
            short v3_3 = com.bumptech.glide.e.q(v1_0);
        } catch (IllegalArgumentException) {
            e0.x.l(v0, r1.a.k("Failed to parse type \'UShort\' for input \'", v1_0, 39), 0, 6);
            throw 0;
        }
        if (v3_3 == 0) {
            v4_3 = 0;
        } else {
            short v3_4 = v3_3.g;
            if (Integer.compare((-2147483648 ^ v3_4), -2147418113) <= 0) {
                v4_3 = new ga.n(((short) v3_4));
            } else {
            }
        }
        if (v4_3 == null) {
            db.p.M(v1_0);
            throw 0;
        } else {
            v0 = v4_3.g;
            return v0;
        }
    }
}
