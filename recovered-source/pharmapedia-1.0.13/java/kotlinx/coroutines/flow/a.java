// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.coroutines.flow;
public abstract class a implements jb.b {

    public static final Object a(jb.q p4, ua.q p5, Throwable p6, kotlin.coroutines.jvm.internal.ContinuationImpl p7)
    {
        kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1 v0_2;
        if (!(p7 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1)) {
            v0_2 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1(p7);
        } else {
            v0_2 = ((kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1) p7);
            kotlin.coroutines.intrinsics.CoroutineSingletons v1_2 = ((kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1) p7).i;
            if ((v1_2 & -2147483648) == 0) {
            } else {
                ((kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1) p7).i = (v1_2 - -2147483648);
            }
        }
        Object v7_1 = v0_2.h;
        kotlin.coroutines.intrinsics.CoroutineSingletons v1_1 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        int v2_0 = v0_2.i;
        try {
            if (v2_0 == 0) {
                kotlin.b.b(v7_1);
                v0_2.g = p6;
                v0_2.i = 1;
                if (p5.invoke(p4, p6, v0_2) == v1_1) {
                    return v1_1;
                }
            } else {
                if (v2_0 != 1) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                    return 0;
                } else {
                    p6 = v0_2.g;
                    kotlin.b.b(v7_1);
                }
            }
        } catch (ga.p v4_4) {
            if (p6 != null) {
                if (p6 != v4_4) {
                    com.bumptech.glide.i.d(v4_4, p6);
                }
            }
            throw v4_4;
        }
        return ga.p.a;
    }

    public static jb.b b(jb.b p3, int p4)
    {
        kotlinx.coroutines.channels.BufferOverflow v0 = kotlinx.coroutines.channels.BufferOverflow.g;
        if ((p4 < 0) && ((p4 != -2) && (p4 != -1))) {
            oc.l.d(r1.a.g(p4, "Buffer size should be non-negative, BUFFERED, or CONFLATED, but was "));
            return 0;
        } else {
            if (p4 == -1) {
                v0 = kotlinx.coroutines.channels.BufferOverflow.h;
                p4 = 0;
            }
            kotlin.coroutines.EmptyCoroutineContext v2_0 = kotlin.coroutines.EmptyCoroutineContext.g;
            if (!(p3 instanceof kb.f)) {
                return new kb.d(p3, v2_0, p4, v0);
            } else {
                return ((kb.f) p3).p(v2_0, p4, v0);
            }
        }
    }

    public static final kotlinx.coroutines.flow.b c(ua.p p4)
    {
        return new kotlinx.coroutines.flow.b(p4, kotlin.coroutines.EmptyCoroutineContext.g, -2, kotlinx.coroutines.channels.BufferOverflow.g);
    }

    public static final java.io.Serializable d(jb.b p4, jb.c p5, kotlin.coroutines.jvm.internal.ContinuationImpl p6)
    {
        boolean v0_2;
        if (!(p6 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1)) {
            v0_2 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1(p6);
        } else {
            v0_2 = ((kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1) p6);
            boolean v1_2 = ((kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1) p6).i;
            if ((v1_2 & -2147483648) == 0) {
            } else {
                ((kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1) p6).i = (v1_2 - -2147483648);
            }
        }
        boolean v6_1 = v0_2.h;
        boolean v1_1 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        kotlinx.coroutines.flow.c v2_0 = v0_2.i;
        if (v2_0 == null) {
            kotlin.b.b(v6_1);
            boolean v6_3 = new kotlin.jvm.internal.Ref$ObjectRef();
            try {
                kotlinx.coroutines.flow.c v2_2 = new kotlinx.coroutines.flow.c(p5, v6_3);
                v0_2.g = v6_3;
                v0_2.i = 1;
            } catch (Throwable v5_1) {
                Throwable v4_2 = v6_3;
                Throwable v4_6 = ((Throwable) v4_2.g);
                if (v4_6 == null) {
                    boolean v6_7 = ((gb.u0) v0_2.getContext().Z(gb.t.h));
                    if (v6_7) {
                        boolean v6_8 = ((gb.a1) v6_7);
                        boolean v0_5 = gb.a1.g.get(v6_8);
                        if (!(v0_5 instanceof gb.q)) {
                            if (!(v0_5 instanceof gb.z0)) {
                                if (v4_6 != null) {
                                    if (!(v5_1 instanceof java.util.concurrent.CancellationException)) {
                                        com.bumptech.glide.i.d(v5_1, v4_6);
                                        throw v5_1;
                                    } else {
                                        com.bumptech.glide.i.d(v4_6, v5_1);
                                        throw v4_6;
                                    }
                                } else {
                                    return v5_1;
                                }
                                throw v5_1;
                            } else {
                                if (!((gb.z0) v0_5).c()) {
                                }
                            }
                        }
                        if (v6_8.u().equals(v5_1)) {
                        }
                    }
                } else {
                    if (!v4_6.equals(v5_1)) {
                    }
                }
            }
            if (p4.collect(v2_2, v0_2) == v1_1) {
                return v1_1;
            }
        } else {
            if (v2_0 != 1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                return 0;
            } else {
                v4_2 = v0_2.g;
                try {
                    kotlin.b.b(v6_1);
                } catch (Throwable v5_1) {
                }
            }
        }
        return 0;
    }

    public static final Object e(jb.o p7, ua.p p8, ka.c p9)
    {
        ga.p v7_3 = kotlinx.coroutines.flow.a.b(new kotlinx.coroutines.flow.internal.d(new kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1(p8, 0), p7, kotlin.coroutines.EmptyCoroutineContext.g, -2, kotlinx.coroutines.channels.BufferOverflow.g), 0).collect(kb.h.g, p9);
        kotlin.coroutines.intrinsics.CoroutineSingletons v8_2 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        ga.p v9_1 = ga.p.a;
        if (v7_3 != v8_2) {
            v7_3 = v9_1;
        }
        if (v7_3 != v8_2) {
            return v9_1;
        } else {
            return v7_3;
        }
    }

    public static final Object f(jb.c p8, ib.k p9, boolean p10, kotlin.coroutines.jvm.internal.ContinuationImpl p11)
    {
        kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 v0_2;
        if (!(p11 instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1)) {
            v0_2 = new kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1(p11);
        } else {
            v0_2 = ((kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) p11);
            kotlin.coroutines.intrinsics.CoroutineSingletons v1_2 = ((kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) p11).l;
            if ((v1_2 & -2147483648) == 0) {
            } else {
                ((kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) p11).l = (v1_2 - -2147483648);
            }
        }
        Throwable v8_3;
        jb.c v2_2;
        jb.c v2_3;
        int v11_1 = v0_2.k;
        kotlin.coroutines.intrinsics.CoroutineSingletons v1_1 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        jb.c v2_0 = v0_2.l;
        java.util.concurrent.CancellationException v3_0 = 0;
        try {
            if (v2_0 == null) {
                kotlin.b.b(v11_1);
                if ((p8 instanceof jb.q)) {
                    throw ((jb.q) p8).g;
                } else {
                    int v11_3 = p9.j;
                    v11_3.getClass();
                    v2_2 = new ib.a(v11_3);
                    v0_2.g = p8;
                    v0_2.h = p9;
                    v0_2.i = v2_2;
                    v0_2.j = p10;
                    v0_2.l = 1;
                    v11_1 = v2_2.a(v0_2);
                    if (v11_1 != v1_1) {
                        v2_3 = p8;
                        v8_3 = v2_2;
                        if (!((Boolean) v11_1).booleanValue()) {
                            if (p10 != null) {
                                p9.h(0);
                            }
                            return ga.p.a;
                        } else {
                            int v11_6 = v8_3.g;
                            com.google.gson.internal.b v6_0 = ib.b.p;
                            if (v11_6 == v6_0) {
                                throw new IllegalStateException("`hasNext()` has not been invoked");
                            } else {
                                v8_3.g = v6_0;
                                if (v11_6 == ib.b.l) {
                                    throw v8_3.i.o();
                                } else {
                                    v0_2.g = v2_3;
                                    v0_2.h = p9;
                                    v0_2.i = v8_3;
                                    v0_2.j = p10;
                                    v0_2.l = 2;
                                    if (v2_3.emit(v11_6, v0_2) == v1_1) {
                                    }
                                }
                            }
                        }
                    } else {
                    }
                }
            } else {
                if (v2_0 == 1) {
                    p10 = v0_2.j;
                    v8_3 = v0_2.i;
                    p9 = v0_2.h;
                    v2_3 = v0_2.g;
                    kotlin.b.b(v11_1);
                } else {
                    if (v2_0 != 2) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                        return 0;
                    } else {
                        p10 = v0_2.j;
                        v8_3 = v0_2.i;
                        p9 = v0_2.h;
                        v2_3 = v0_2.g;
                        kotlin.b.b(v11_1);
                        v2_2 = v8_3;
                        p8 = v2_3;
                    }
                }
            }
        } catch (Throwable v8_9) {
            try {
                throw v8_9;
            } catch (int v11_10) {
                if (p10 != null) {
                    if ((v8_9 instanceof java.util.concurrent.CancellationException)) {
                        v3_0 = ((java.util.concurrent.CancellationException) v8_9);
                    }
                    if (v3_0 == null) {
                        v3_0 = new java.util.concurrent.CancellationException("Channel was consumed, consumer had failed");
                        v3_0.initCause(v8_9);
                    }
                    p9.h(v3_0);
                }
                throw v11_10;
            }
        }
        return v1_1;
    }

    public static final Object g(jb.b p6, kotlin.coroutines.jvm.internal.ContinuationImpl p7)
    {
        kotlinx.coroutines.flow.internal.AbortFlowException v1_1;
        com.google.gson.internal.b v0 = kb.b.b;
        if (!(p7 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1)) {
            v1_1 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1(p7);
        } else {
            v1_1 = ((kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1) p7);
            Object v2_3 = ((kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1) p7).j;
            if ((v2_3 & -2147483648) == 0) {
            } else {
                ((kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1) p7).j = (v2_3 - -2147483648);
            }
        }
        kotlinx.coroutines.flow.internal.AbortFlowException v1_3;
        String v7_1 = v1_1.i;
        Object v2_1 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        jb.h v3_0 = v1_1.j;
        if (v3_0 == null) {
            kotlin.b.b(v7_1);
            String v7_3 = new kotlin.jvm.internal.Ref$ObjectRef();
            v7_3.g = v0;
            jb.h v3_2 = new jb.h(v7_3, 0);
            try {
                v1_1.g = v7_3;
                v1_1.h = v3_2;
                v1_1.j = 1;
            } catch (java.util.NoSuchElementException v6_2) {
                v1_3 = v7_3;
                String v7_4 = v6_2;
                java.util.NoSuchElementException v6_3 = v3_2;
                if (v7_4.g != v6_3) {
                    throw v7_4;
                }
            }
            if (p6.collect(v3_2, v1_1) != v2_1) {
                v1_3 = v7_3;
            } else {
                return v2_1;
            }
        } else {
            if (v3_0 != 1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                return 0;
            } else {
                v6_3 = v1_1.h;
                v1_3 = v1_1.g;
                try {
                    kotlin.b.b(v7_1);
                } catch (String v7_4) {
                }
            }
        }
        java.util.NoSuchElementException v6_6 = v1_3.g;
        if (v6_6 == v0) {
            throw new java.util.NoSuchElementException("Expected at least one element");
        } else {
            return v6_6;
        }
    }

    public static final Object h(jb.b p5, kotlin.coroutines.jvm.internal.ContinuationImpl p6)
    {
        kotlinx.coroutines.flow.internal.AbortFlowException v0_2;
        if (!(p6 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1)) {
            v0_2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1(p6);
        } else {
            v0_2 = ((kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1) p6);
            Object v1_2 = ((kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1) p6).j;
            if ((v1_2 & -2147483648) == 0) {
            } else {
                ((kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1) p6).j = (v1_2 - -2147483648);
            }
        }
        kotlinx.coroutines.flow.internal.AbortFlowException v0_3;
        kotlinx.coroutines.flow.internal.AbortFlowException v6_1 = v0_2.i;
        Object v1_1 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        jb.h v2_0 = v0_2.j;
        if (v2_0 == null) {
            kotlin.b.b(v6_1);
            kotlinx.coroutines.flow.internal.AbortFlowException v6_3 = new kotlin.jvm.internal.Ref$ObjectRef();
            jb.h v2_2 = new jb.h(v6_3, 1);
            try {
                v0_2.g = v6_3;
                v0_2.h = v2_2;
                v0_2.j = 1;
            } catch (Object v5_2) {
                v0_3 = v6_3;
                kotlinx.coroutines.flow.internal.AbortFlowException v6_4 = v5_2;
                Object v5_3 = v2_2;
                if (v6_4.g != v5_3) {
                    throw v6_4;
                }
            }
            if (p5.collect(v2_2, v0_2) != v1_1) {
                v0_3 = v6_3;
            } else {
                return v1_1;
            }
        } else {
            if (v2_0 != 1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                return 0;
            } else {
                v5_3 = v0_2.h;
                v0_3 = v0_2.g;
                try {
                    kotlin.b.b(v6_1);
                } catch (kotlinx.coroutines.flow.internal.AbortFlowException v6_4) {
                }
            }
        }
        return v0_3.g;
    }

    public Object collect(jb.c p7, ka.c p8)
    {
        kotlinx.coroutines.flow.AbstractFlow$collect$1 v0_2;
        if (!(p8 instanceof kotlinx.coroutines.flow.AbstractFlow$collect$1)) {
            v0_2 = new kotlinx.coroutines.flow.AbstractFlow$collect$1(this, p8);
        } else {
            v0_2 = ((kotlinx.coroutines.flow.AbstractFlow$collect$1) p8);
            kotlin.coroutines.intrinsics.CoroutineSingletons v1_2 = ((kotlinx.coroutines.flow.AbstractFlow$collect$1) p8).j;
            if ((v1_2 & -2147483648) == 0) {
            } else {
                ((kotlinx.coroutines.flow.AbstractFlow$collect$1) p8).j = (v1_2 - -2147483648);
            }
        }
        ga.p v7_6;
        ga.p v8_1 = v0_2.h;
        kotlin.coroutines.intrinsics.CoroutineSingletons v1_1 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        ka.g v2_0 = v0_2.j;
        ga.p v3_0 = ga.p.a;
        if (v2_0 == null) {
            kotlin.b.b(v8_1);
            ga.p v8_3 = new kotlinx.coroutines.flow.internal.SafeCollector(p7, v0_2.getContext());
            try {
                v0_2.g = v8_3;
                v0_2.j = 1;
                ga.p v7_4 = ((jb.k) this).g.invoke(v8_3, v0_2);
            } catch (ga.p v7_5) {
                ga.p v8_4 = v7_5;
                v7_6 = v8_3;
                v7_6.releaseIntercepted();
                throw v8_4;
            }
            if (v7_4 != v1_1) {
                v7_4 = v3_0;
            }
            if (v7_4 != v1_1) {
                v7_6 = v8_3;
            } else {
                return v1_1;
            }
        } else {
            if (v2_0 != 1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                return 0;
            } else {
                v7_6 = v0_2.g;
                try {
                    kotlin.b.b(v8_1);
                } catch (ga.p v8_4) {
                }
            }
        }
        v7_6.releaseIntercepted();
        return v3_0;
    }
}
