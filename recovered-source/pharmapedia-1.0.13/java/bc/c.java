// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package bc;
public final class c implements java.lang.Runnable {
    public final synthetic int g;
    public final synthetic Object h;

    public synthetic c(Object p1, int p2)
    {
        this.g = p2;
        this.h = p1;
        return;
    }

    public final void run()
    {
        switch (this.g) {
            case 0:
                float v4_12 = ((bc.d) this.h);
                try {
                    v4_12.g = (v4_12.g + 1);
                    Throwable v0_88 = v4_12.b();
                } catch (Throwable v0_89) {
                    throw v0_89;
                }
                if (v0_88 != null) {
                    v4_12 = Thread.currentThread();
                    float v5_3 = v4_12.getName();
                    do {
                        int v6_3 = v0_88;
                        long v12_1;
                        v4_12.setName(v6_3.a);
                        bc.d v7_1 = ((bc.d) this.h).b;
                        long v10_1 = v6_3.c;
                        v10_1.getClass();
                        String v11_0 = v7_1.isLoggable(java.util.logging.Level.FINE);
                        if (v11_0 == null) {
                            v12_1 = -1;
                        } else {
                            v12_1 = System.nanoTime();
                            com.bumptech.glide.g.a(v7_1, v6_3, v10_1, "starting");
                        }
                        long v14_1 = v6_3.a();
                        if (v11_0 != null) {
                            long v16_2 = (System.nanoTime() - v12_1);
                            Throwable v0_99 = new StringBuilder();
                            v0_99.append("finished run in ");
                            v0_99.append(com.bumptech.glide.g.h(v16_2));
                            com.bumptech.glide.g.a(v7_1, v6_3, v10_1, v0_99.toString());
                        }
                        bc.d v7_3 = ((bc.d) this.h);
                        try {
                            bc.d.a(v7_3, v6_3, v14_1, 1);
                            v0_88 = v7_3.b();
                        } catch (Throwable v0_102) {
                            throw v0_102;
                        }
                    } while(v0_88 != null);
                    v4_12.setName(v5_3);
                }
                return;
            case 1:
                Throwable v0_84 = ((com.bumptech.glide.q) this.h);
                v0_84.i.o(v0_84);
                return;
            case 2:
                ((g7.g0) this.h).a.onReady();
                return;
            case 3:
                ((g7.m0) this.h).g.h();
                return;
            case 4:
                Throwable v0_73 = ((g7.l1) ((g7.b0) this.h).h);
                boolean v2_33 = v0_73.r;
                v0_73.q = 0;
                v0_73.r = 0;
                v2_33.c(e7.g1.n.g("InternalSubchannel closed transport due to address change"));
                return;
            case 5:
                ((io.grpc.internal.g) ((g7.z) this.h).h).R();
                return;
            case 6:
                Throwable v0_64 = ((g7.y1) this.h).e;
                v0_64.n.d();
                if (v0_64.x) {
                    v0_64.w.z();
                }
                return;
            case 7:
                Throwable v0_60 = ((g7.f2) this.h).g;
                v0_60.k.execute(new g7.f1(v0_60, io.grpc.internal.g.i0, 0));
                return;
            case 8:
                Throwable v0_57 = ((g7.z2) this.h);
                v0_57.k = 0;
                if (v0_57.h.b()) {
                    v0_57.e();
                }
                return;
            case 9:
                ((e7.h) ((g7.x2) this.h).c).A();
                return;
            case 10:
                Throwable v0_50 = ((g7.v1) this.h);
                if (!v0_50.z) {
                    v0_50.u.h();
                }
                return;
            case 11:
                Throwable v0_46 = ((g7.a4) this.h);
                ((g7.v1) v0_46.i.i).s(v0_46.h);
                return;
            case 12:
                ((g7.h4) this.h).z();
                return;
            case 13:
                boolean v2_23 = ((h7.c) this.h);
                float v3_6 = v2_23.j;
                try {
                    Throwable v0_36 = v2_23.o;
                } catch (Throwable v0_37) {
                    v3_6.o(v0_37);
                    try {
                        Throwable v0_39 = v2_23.o;
                    } catch (Throwable v0_40) {
                        v3_6.o(v0_40);
                        try {
                            Throwable v0_41 = v2_23.p;
                        } catch (Throwable v0_42) {
                            v3_6.o(v0_42);
                            return;
                        }
                        if (v0_41 == null) {
                            return;
                        } else {
                            v0_41.close();
                            return;
                        }
                    }
                    if (v0_39 == null) {
                    } else {
                        v0_39.close();
                    }
                }
                if (v0_36 == null) {
                } else {
                    int v6_2 = v2_23.h;
                    bc.d v7_0 = v6_2.h;
                    if (v7_0 <= 0) {
                    } else {
                        v0_36.D(v7_0, v6_2);
                    }
                }
            case 14:
                Throwable v0_29 = ((ec.a) this.h);
                boolean v2_19 = v0_29.b;
                float v4_5 = Math.max((2 * v2_19), v2_19);
                Throwable v0_31 = ((g7.d) v0_29.c);
                if (v0_31.b.compareAndSet(v2_19, v4_5)) {
                    g7.d.c.log(java.util.logging.Level.WARNING, "Increased {0} to {1}", new Object[] {v0_31.a, Long.valueOf(v4_5)}));
                }
                return;
            case 15:
                Throwable v0_21 = ((h7.k) this.h);
                v0_21.o.execute(v0_21.t);
                try {
                    Throwable v0_26 = ((h7.k) this.h);
                    v0_26.C = 2147483647;
                    v0_26.s();
                    return;
                } catch (Throwable v0_27) {
                    throw v0_27;
                }
            case 16:
                Throwable v0_19 = ((m.g1) this.h);
                v0_19.r = 0;
                v0_19.drawableStateChanged();
                return;
            case 17:
                Throwable v0_17 = ((androidx.appcompat.widget.SearchView$SearchAutoComplete) this.h);
                if (v0_17.l) {
                    ((android.view.inputmethod.InputMethodManager) v0_17.getContext().getSystemService("input_method")).showSoftInput(v0_17, 0);
                    v0_17.l = 0;
                }
                return;
            case 18:
                Throwable v0_14 = ((androidx.appcompat.widget.Toolbar) this.h).g;
                if (v0_14 != null) {
                    Throwable v0_15 = v0_14.z;
                    if (v0_15 != null) {
                        v0_15.n();
                    }
                }
                return;
            case 19:
                Throwable v0_11 = ((androidx.viewpager.widget.ViewPager) this.h);
                v0_11.setScrollState(0);
                v0_11.q();
                return;
            case 20:
                Throwable v0_9 = ((rc.q) this.h);
                v0_9.j = 0;
                v0_9.m();
                return;
            case 21:
                throw new RuntimeException(((Exception) this.h));
                break;
            case 22:
                Throwable v0_115 = ((u0.d) this.h);
                int v6_5 = v0_115.i;
                bc.d v7_7 = v0_115.g;
                if (v0_115.u) {
                    if (v0_115.s) {
                        v0_115.s = 0;
                        long v10_2 = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
                        v7_7.e = v10_2;
                        v7_7.g = -1;
                        v7_7.f = v10_2;
                        v7_7.h = 1056964608;
                    }
                    if (((v7_7.g <= 0) || (android.view.animation.AnimationUtils.currentAnimationTimeMillis() <= (v7_7.g + ((long) v7_7.i)))) && (v0_115.e())) {
                        if (v0_115.t) {
                            v0_115.t = 0;
                            long v10_0 = android.os.SystemClock.uptimeMillis();
                            boolean v2_2 = android.view.MotionEvent.obtain(v10_0, v10_0, 3, 0, 0, 0);
                            v6_5.onTouchEvent(v2_2);
                            v2_2.recycle();
                        }
                        if (v7_7.f == 0) {
                            com.google.firebase.firestore.v.f("Cannot compute scroll delta before calling start()");
                        } else {
                            boolean v2_5 = android.view.animation.AnimationUtils.currentAnimationTimeMillis();
                            float v4_0 = v7_7.a(v2_5);
                            float v4_2 = ((v4_0 * 1082130432) + ((-1065353216 * v4_0) * v4_0));
                            String v8_2 = (v2_5 - v7_7.f);
                            v7_7.f = v2_5;
                            v0_115.w.scrollListBy(((int) ((((float) v8_2) * v4_2) * v7_7.d)));
                            v6_5.postOnAnimation(this);
                        }
                    } else {
                        v0_115.u = 0;
                    }
                }
                return;
            case 23:
                Throwable v0_113 = ((com.denzcoskun.imageslider.ImageSlider) this.h);
                if (v0_113.k == v0_113.l) {
                    v0_113.k = 0;
                }
                boolean v2_45 = v0_113.g;
                if (!v2_45) {
                    kotlin.jvm.internal.f.g();
                    throw 0;
                } else {
                    float v3_15 = v0_113.k;
                    v0_113.k = (v3_15 + 1);
                    v2_45.A = 0;
                    v2_45.v(v3_15, 0, 1, 0);
                    return;
                }
            case 24:
                Throwable v0_106 = ((o5.e) this.h);
                v0_106.b = 0;
                boolean v2_42 = ((com.google.android.material.bottomsheet.BottomSheetBehavior) v0_106.e);
                float v3_11 = v2_42.Q;
                if ((v3_11 == 0) || (!v3_11.f())) {
                    if (v2_42.P == 2) {
                        v2_42.L(v0_106.c);
                    }
                } else {
                    v0_106.a(v0_106.c);
                }
                return;
            case 25:
                ((w0.c) this.h).m(0);
                return;
            case 26:
                Throwable v0_4 = ((w1.t) this.h);
                boolean v2_12 = v0_4.z;
                float v3_1 = v0_4.A;
                if (v3_1 == 1) {
                    v2_12.cancel();
                    v0_4.A = 3;
                    float v3_7 = new float[2];
                    v3_7[0] = ((Float) v2_12.getAnimatedValue()).floatValue();
                    v3_7[1] = 0;
                    v2_12.setFloatValues(v3_7);
                    v2_12.setDuration(((long) 500));
                    v2_12.start();
                } else {
                    if (v3_1 == 2) {
                    }
                }
                return;
            case 27:
                ((androidx.recyclerview.widget.StaggeredGridLayoutManager) this.h).D0();
                return;
            default:
                Throwable v0_110 = ((c0.g) this.h);
                try {
                    while(true) {
                        v0_110.c(((y2.a) ((ref.ReferenceQueue) v0_110.j).remove()));
                        Thread.currentThread().interrupt();
                    }
                } catch (InterruptedException) {
                }
        }
    }
}
