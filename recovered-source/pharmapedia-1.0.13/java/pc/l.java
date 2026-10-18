// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package pc;
public final synthetic class l implements ua.p {
    public final synthetic int g;
    public final synthetic kotlin.jvm.internal.Ref$ObjectRef h;
    public final synthetic oc.y i;
    public final synthetic kotlin.jvm.internal.Ref$ObjectRef j;
    public final synthetic kotlin.jvm.internal.Ref$ObjectRef k;

    public synthetic l(kotlin.jvm.internal.Ref$ObjectRef p2, oc.y p3, kotlin.jvm.internal.Ref$ObjectRef p4, kotlin.jvm.internal.Ref$ObjectRef p5)
    {
        this.g = 1;
        this.h = p2;
        this.i = p3;
        this.j = p4;
        this.k = p5;
        return;
    }

    public synthetic l(oc.y p2, kotlin.jvm.internal.Ref$ObjectRef p3, kotlin.jvm.internal.Ref$ObjectRef p4, kotlin.jvm.internal.Ref$ObjectRef p5)
    {
        this.g = 0;
        this.i = p2;
        this.h = p3;
        this.j = p4;
        this.k = p5;
        return;
    }

    public final Object invoke(Object p12, Object p13)
    {
        kotlin.jvm.internal.Ref$ObjectRef v0_0 = this.g;
        Integer v12_4 = ((Integer) p12).intValue();
        switch (v0_0) {
            case 0:
                Integer v12_6;
                kotlin.jvm.internal.Ref$ObjectRef v0_2 = ((Long) p13).longValue();
                if (v12_4 != 21589) {
                    v12_6 = ga.p.a;
                } else {
                    Integer v12_2 = 1;
                    if (v0_2 < 1) {
                        oc.l.g("bad zip: extended timestamp extra too short");
                    } else {
                        int v5_1;
                        oc.y v2_1 = this.i;
                        int v4_0 = v2_1.readByte();
                        int v6 = 0;
                        if ((v4_0 & 1) != 1) {
                            v5_1 = 0;
                        } else {
                            v5_1 = 1;
                        }
                        int v8_1;
                        if ((v4_0 & 2) != 2) {
                            v8_1 = 0;
                        } else {
                            v8_1 = 1;
                        }
                        if ((v4_0 & 4) == 4) {
                            v6 = 1;
                        }
                        if (v5_1 != 0) {
                            v12_2 = 5;
                        }
                        if (v8_1 != 0) {
                            v12_2 += 4;
                        }
                        if (v6 != 0) {
                            v12_2 += 4;
                        }
                        if (v0_2 < v12_2) {
                            oc.l.g("bad zip: extended timestamp extra too short");
                        } else {
                            if (v5_1 != 0) {
                                this.h.g = Integer.valueOf(v2_1.B());
                            }
                            if (v8_1 != 0) {
                                this.j.g = Integer.valueOf(v2_1.B());
                            }
                            if (v6 == 0) {
                            } else {
                                this.k.g = Integer.valueOf(v2_1.B());
                            }
                        }
                    }
                    v12_6 = 0;
                }
                return v12_6;
            default:
                Integer v12_3;
                kotlin.jvm.internal.Ref$ObjectRef v0_1 = ((Long) p13).longValue();
                if (v12_4 != 1) {
                    v12_3 = ga.p.a;
                } else {
                    Integer v12_13 = this.h;
                    if (v12_13.g != null) {
                        oc.l.g("bad zip: NTFS extra attribute tag 0x0001 repeated");
                    } else {
                        if (v0_1 != 24) {
                            oc.l.g("bad zip: NTFS extra attribute tag 0x0001 size != 24");
                        } else {
                            kotlin.jvm.internal.Ref$ObjectRef v13_9 = this.i;
                            v12_13.g = Long.valueOf(v13_9.L());
                            this.j.g = Long.valueOf(v13_9.L());
                            this.k.g = Long.valueOf(v13_9.L());
                        }
                    }
                    v12_3 = 0;
                }
                return v12_3;
        }
    }
}
