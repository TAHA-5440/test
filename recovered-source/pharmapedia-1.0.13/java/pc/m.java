// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package pc;
public final synthetic class m implements ua.p {
    public final synthetic kotlin.jvm.internal.Ref$BooleanRef g;
    public final synthetic long h;
    public final synthetic kotlin.jvm.internal.Ref$LongRef i;
    public final synthetic oc.y j;
    public final synthetic kotlin.jvm.internal.Ref$LongRef k;
    public final synthetic kotlin.jvm.internal.Ref$LongRef l;
    public final synthetic kotlin.jvm.internal.Ref$ObjectRef m;
    public final synthetic kotlin.jvm.internal.Ref$ObjectRef n;
    public final synthetic kotlin.jvm.internal.Ref$ObjectRef o;

    public synthetic m(kotlin.jvm.internal.Ref$BooleanRef p1, long p2, kotlin.jvm.internal.Ref$LongRef p4, oc.y p5, kotlin.jvm.internal.Ref$LongRef p6, kotlin.jvm.internal.Ref$LongRef p7, kotlin.jvm.internal.Ref$ObjectRef p8, kotlin.jvm.internal.Ref$ObjectRef p9, kotlin.jvm.internal.Ref$ObjectRef p10)
    {
        this.g = p1;
        this.h = p2;
        this.i = p4;
        this.j = p5;
        this.k = p6;
        this.l = p7;
        this.m = p8;
        this.n = p9;
        this.o = p10;
        return;
    }

    public final Object invoke(Object p7, Object p8)
    {
        kotlin.jvm.internal.Ref$LongRef v7_5 = ((Integer) p7).intValue();
        long v0_6 = ((Long) p8).longValue();
        oc.y v8_2 = this.j;
        if (v7_5 == 1) {
            kotlin.jvm.internal.Ref$LongRef v7_14 = this.g;
            if (v7_14.g) {
                oc.l.g("bad zip: zip64 extra repeated");
                return 0;
            } else {
                v7_14.g = 1;
                if (v0_6 < this.h) {
                    oc.l.g("bad zip: zip64 extra too short");
                    return 0;
                } else {
                    kotlin.jvm.internal.Ref$LongRef v7_6 = this.i;
                    long v0_0 = v7_6.g;
                    if (v0_0 == 4294967295) {
                        v0_0 = v8_2.L();
                    }
                    long v0_3;
                    v7_6.g = v0_0;
                    kotlin.jvm.internal.Ref$LongRef v7_7 = this.k;
                    long v4_1 = 0;
                    if (v7_7.g != 4294967295) {
                        v0_3 = 0;
                    } else {
                        v0_3 = v8_2.L();
                    }
                    v7_7.g = v0_3;
                    kotlin.jvm.internal.Ref$LongRef v7_8 = this.l;
                    if (v7_8.g == 4294967295) {
                        v4_1 = v8_2.L();
                    }
                    v7_8.g = v4_1;
                }
            }
        } else {
            if (v7_5 == 10) {
                if (v0_6 < 4) {
                    oc.l.g("bad zip: NTFS extra too short");
                    return 0;
                } else {
                    v8_2.skip(4);
                    pc.b.e(v8_2, ((int) (v0_6 - 4)), new pc.l(this.m, v8_2, this.n, this.o));
                }
            }
        }
        return ga.p.a;
    }
}
