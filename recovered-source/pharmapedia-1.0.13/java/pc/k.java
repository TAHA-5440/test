// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package pc;
public final class k {
    public final oc.w a;
    public final boolean b;
    public final String c;
    public final long d;
    public final long e;
    public final long f;
    public final int g;
    public final long h;
    public final int i;
    public final int j;
    public final Long k;
    public final Long l;
    public final Long m;
    public final Integer n;
    public final Integer o;
    public final Integer p;
    public final java.util.ArrayList q;

    public synthetic k(oc.w p24, boolean p25, String p26, long p27, long p29, long p31, int p33, long p34, int p36, int p37, Long p38, Long p39, Long p40, int p41)
    {
        String v5;
        if ((p41 & 4) == 0) {
            v5 = p26;
        } else {
            v5 = "";
        }
        long v6;
        if ((p41 & 8) == 0) {
            v6 = p27;
        } else {
            v6 = -1;
        }
        long v8;
        if ((p41 & 16) == 0) {
            v8 = p29;
        } else {
            v8 = -1;
        }
        long v10;
        if ((p41 & 32) == 0) {
            v10 = p31;
        } else {
            v10 = -1;
        }
        int v12;
        if ((p41 & 64) == 0) {
            v12 = p33;
        } else {
            v12 = -1;
        }
        long v13;
        if ((p41 & 128) == 0) {
            v13 = p34;
        } else {
            v13 = -1;
        }
        int v15;
        if ((p41 & 256) == 0) {
            v15 = p36;
        } else {
            v15 = -1;
        }
        int v16;
        if ((p41 & 512) == 0) {
            v16 = p37;
        } else {
            v16 = -1;
        }
        Long v17;
        if ((p41 & 1024) == 0) {
            v17 = p38;
        } else {
            v17 = 0;
        }
        Long v18;
        if ((p41 & 2048) == 0) {
            v18 = p39;
        } else {
            v18 = 0;
        }
        Long v19;
        if ((p41 & 4096) == 0) {
            v19 = p40;
        } else {
            v19 = 0;
        }
        this(p24, p25, v5, v6, v8, v10, v12, v13, v15, v16, v17, v18, v19, 0, 0, 0);
        return;
    }

    public k(oc.w p1, boolean p2, String p3, long p4, long p6, long p8, int p10, long p11, int p13, int p14, Long p15, Long p16, Long p17, Integer p18, Integer p19, Integer p20)
    {
        p1.getClass();
        p3.getClass();
        this.a = p1;
        this.b = p2;
        this.c = p3;
        this.d = p4;
        this.e = p6;
        this.f = p8;
        this.g = p10;
        this.h = p11;
        this.i = p13;
        this.j = p14;
        this.k = p15;
        this.l = p16;
        this.m = p17;
        this.n = p18;
        this.o = p19;
        this.p = p20;
        this.q = new java.util.ArrayList();
        return;
    }
}
