// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.serialization.json.internal;
public final class b {
    public final e0.x a;
    public int b;

    public b(m.t p1, e0.x p2)
    {
        this.a = p2;
        return;
    }

    public static final Object a(kotlinx.serialization.json.internal.b p10, ga.b p11, kotlin.coroutines.jvm.internal.BaseContinuationImpl p12)
    {
        kotlinx.serialization.json.internal.JsonTreeReader$readObject$2 v1_1;
        e0.x v0_0 = p10.a;
        if (!(p12 instanceof kotlinx.serialization.json.internal.JsonTreeReader$readObject$2)) {
            v1_1 = new kotlinx.serialization.json.internal.JsonTreeReader$readObject$2(p10, p12);
        } else {
            v1_1 = ((kotlinx.serialization.json.internal.JsonTreeReader$readObject$2) p12);
            kotlin.coroutines.intrinsics.CoroutineSingletons v2_2 = ((kotlinx.serialization.json.internal.JsonTreeReader$readObject$2) p12).m;
            if ((v2_2 & -2147483648) == 0) {
            } else {
                ((kotlinx.serialization.json.internal.JsonTreeReader$readObject$2) p12).m = (v2_2 - -2147483648);
            }
        }
        e0.x v0_2;
        java.util.LinkedHashMap v11_1;
        e0.x v12_2;
        e0.x v0_3;
        String v10_6;
        e0.x v12_1 = v1_1.k;
        e0.x v3_0 = v1_1.m;
        if (v3_0 == null) {
            kotlin.b.b(v12_1);
            v12_2 = v0_0.f(6);
            if (v0_0.o() == 4) {
                e0.x.l(v0_0, "Unexpected leading comma", 0, 6);
                throw 0;
            } else {
                v0_2 = new java.util.LinkedHashMap();
                e0.x v3_3 = p10.a;
                if (!v3_3.b()) {
                    v11_1 = v0_2;
                    v0_3 = p10;
                    v10_6 = v12_2;
                } else {
                    e0.x v12_4 = v3_3.i();
                    v3_3.f(5);
                    v1_1.g = p11;
                    v1_1.h = p10;
                    v1_1.i = v0_2;
                    v1_1.j = v12_4;
                    v1_1.m = 1;
                    p11.getClass();
                    p11.h = v1_1;
                    return kotlin.coroutines.intrinsics.CoroutineSingletons.g;
                }
            }
        } else {
            if (v3_0 != 1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                return 0;
            } else {
                String v10_4 = v1_1.j;
                v11_1 = v1_1.i;
                v0_3 = v1_1.h;
                e0.x v3_2 = v1_1.g;
                kotlin.b.b(v12_1);
                v11_1.put(v10_4, ((vb.j) v12_1));
                v10_6 = v0_3.a.e();
                if (v10_6 == 4) {
                    v12_2 = v10_6;
                    p10 = v0_3;
                    v0_2 = v11_1;
                    p11 = v3_2;
                } else {
                    if (v10_6 != 7) {
                        e0.x.l(v0_3.a, "Expected end of the object or comma", 0, 6);
                        throw 0;
                    }
                }
            }
        }
        e0.x v12_5 = v0_3.a;
        if (v10_6 != 6) {
            if (v10_6 == 4) {
                wb.g.e(v12_5, "object");
                throw 0;
            }
        } else {
            v12_5.f(7);
        }
        return new vb.v(v11_1);
    }

    public final vb.j b()
    {
        vb.v v0_0 = this.a;
        String v1_4 = v0_0.o();
        if (v1_4 != 1) {
            if (v1_4 != null) {
                if (v1_4 != 6) {
                    if (v1_4 != 8) {
                        e0.x.l(v0_0, "Cannot read Json element because of unexpected ".concat(wb.g.j(v1_4)), 0, 6);
                        throw 0;
                    } else {
                        return this.c();
                    }
                } else {
                    vb.v v0_1;
                    String v1_6 = (this.b + 1);
                    this.b = v1_6;
                    if (v1_6 != 200) {
                        String v1_7 = v0_0.f(6);
                        if (v0_0.o() == 4) {
                            e0.x.l(v0_0, "Unexpected leading comma", 0, 6);
                            throw 0;
                        } else {
                            java.util.LinkedHashMap v2_6 = new java.util.LinkedHashMap();
                            while (v0_0.b()) {
                                String v1_9 = v0_0.i();
                                v0_0.f(5);
                                v2_6.put(v1_9, this.b());
                                v1_7 = v0_0.e();
                                if (v1_7 != 4) {
                                    if (v1_7 == 7) {
                                        break;
                                    }
                                    e0.x.l(v0_0, "Expected end of the object or comma", 0, 6);
                                    throw 0;
                                }
                            }
                            if (v1_7 != 6) {
                                if (v1_7 == 4) {
                                    wb.g.e(v0_0, "object");
                                    throw 0;
                                }
                            } else {
                                v0_0.f(7);
                            }
                            v0_1 = new vb.v(v2_6);
                        }
                    } else {
                        vb.v v0_7 = new kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1(this, 0);
                        String v1_13 = new ga.b();
                        v1_13.g = v0_7;
                        v1_13.h = v1_13;
                        java.util.LinkedHashMap v2_7 = ga.a.a;
                        v1_13.i = v2_7;
                        do {
                            vb.v v0_8 = v1_13.i;
                            ka.c v3_1 = v1_13.h;
                            if (v3_1 != null) {
                                if (!kotlin.jvm.internal.f.a(v2_7, v0_8)) {
                                    v1_13.i = v2_7;
                                    v3_1.resumeWith(v0_8);
                                } else {
                                    try {
                                        vb.v v0_9 = v1_13.g;
                                        kotlin.jvm.internal.j.c(3, v0_9);
                                        kotlin.Result$Failure v4_4 = new kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1(((kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1) v0_9).j, v3_1);
                                        v4_4.i = v1_13;
                                        vb.v v0_13 = v4_4.invokeSuspend(ga.p.a);
                                    } catch (vb.v v0_14) {
                                        v3_1.resumeWith(new kotlin.Result$Failure(v0_14));
                                    }
                                }
                            } else {
                                kotlin.b.b(v0_8);
                                v0_1 = ((vb.j) v0_8);
                            }
                        } while(v0_13 == kotlin.coroutines.intrinsics.CoroutineSingletons.g);
                        v3_1.resumeWith(v0_13);
                    }
                    this.b = (this.b - 1);
                    return v0_1;
                }
            } else {
                return this.d(0);
            }
        } else {
            return this.d(1);
        }
    }

    public final vb.d c()
    {
        vb.d v0_0 = this.a;
        String v1_0 = v0_0.e();
        if (v0_0.o() == 4) {
            e0.x.l(v0_0, "Unexpected leading comma", 0, 6);
            throw 0;
        } else {
            int v2_2 = new java.util.ArrayList();
            while (v0_0.b()) {
                v2_2.add(this.b());
                v1_0 = v0_0.e();
                if (v1_0 != 4) {
                    int v6_1;
                    if (v1_0 != 9) {
                        v6_1 = 0;
                    } else {
                        v6_1 = 1;
                    }
                    if (v6_1 == 0) {
                        e0.x.l(v0_0, "Expected end of the array or comma", v0_0.b, 4);
                        throw 0;
                    }
                }
            }
            if (v1_0 != 8) {
                if (v1_0 == 4) {
                    wb.g.e(v0_0, "array");
                    throw 0;
                }
            } else {
                v0_0.f(9);
            }
            return new vb.d(v2_2);
        }
    }

    public final vb.z d(boolean p3)
    {
        String v0_1;
        String v0_0 = this.a;
        if (p3 != null) {
            v0_1 = v0_0.i();
        } else {
            v0_1 = v0_0.j();
        }
        if ((p3 != null) || (!kotlin.jvm.internal.f.a(v0_1, "null"))) {
            return new vb.o(v0_1, p3);
        } else {
            return vb.r.INSTANCE;
        }
    }
}
