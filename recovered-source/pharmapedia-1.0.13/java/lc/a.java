// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package lc;
public final class a {
    public final synthetic int a;
    public final Object b;
    public final Object c;
    public Object d;
    public Object e;
    public Object f;
    public final Object g;

    public a(int p4)
    {
        this.a = p4;
        switch (p4) {
            case 1:
                this.b = new int[] {2131230837, 2131230835, 2131230761});
                int v0_0 = new int[7];
                v0_0 = {2131230785, 2131230820, 2131230792, 2131230787, 2131230788, 2131230791, 2131230790};
                this.c = v0_0;
                int[] v4_1 = new int[7];
                v4_1 = {2131230834, 2131230836, 2131230778, 2131230830, 2131230831, 2131230832, 2131230833};
                this.d = v4_1;
                this.e = new int[] {2131230810, 2131230776, 2131230809});
                this.f = new int[] {2131230828, 2131230838});
                this.g = new int[] {2131230764, 2131230770, 2131230765, 2131230771});
                return;
            default:
                this.b = new java.util.concurrent.atomic.AtomicBoolean(0);
                this.c = new java.util.concurrent.CountDownLatch(1);
                this.g = "PublicSuffixDatabase.list";
                return;
        }
    }

    public synthetic a(android.view.ViewGroup p1, android.view.View p2, android.view.View p3, android.view.View p4, android.view.View p5, android.view.View p6, int p7)
    {
        this.a = p7;
        this.b = p1;
        this.c = p2;
        this.d = p3;
        this.e = p4;
        this.f = p5;
        this.g = p6;
        return;
    }

    public a(androidx.lifecycle.d1 p5)
    {
        this.a = 6;
        long v0_9 = ((yb.u) p5.g);
        if (v0_9 == 0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("url == null");
            throw 0;
        } else {
            this.b = v0_9;
            this.g = ((String) p5.h);
            long v0_5 = ((g7.c1) p5.i).h();
            this.c = v0_5;
            yb.z v1_1 = ((yb.z) p5.j);
            this.d = v1_1;
            this.e = kotlin.collections.a.N(p5.k);
            if (("upgrade".equalsIgnoreCase(v0_5.a("Connection"))) && ((v1_1 != null) && (v1_1.a() != 0))) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("expected a null or empty request body with \'Connection: upgrade\'");
                throw 0;
            } else {
                return;
            }
        }
    }

    public static boolean a(int[] p4, int p5)
    {
        int v2 = 0;
        while (v2 < p4.length) {
            if (p4[v2] != p5) {
                v2++;
            } else {
                return 1;
            }
        }
        return 0;
    }

    public static android.content.res.ColorStateList b(android.content.Context p6, int p7)
    {
        int v0_2 = m.b2.c(p6, 2130968839);
        return new android.content.res.ColorStateList(new int[][] {m.b2.b, m.b2.d, m.b2.c, m.b2.f}), new int[] {m.b2.b(p6, 2130968834), i0.a.b(v0_2, p7), i0.a.b(v0_2, p7), p7}));
    }

    public static android.graphics.drawable.LayerDrawable c(m.x1 p4, android.content.Context p5, int p6)
    {
        int v5_6;
        int v0_2;
        android.graphics.drawable.LayerDrawable v6_1 = p5.getResources().getDimensionPixelSize(p6);
        int v0_4 = p4.d(p5, 2131230824);
        android.graphics.drawable.BitmapDrawable v4_4 = p4.d(p5, 2131230825);
        if ((!(v0_4 instanceof android.graphics.drawable.BitmapDrawable)) || ((v0_4.getIntrinsicWidth() != v6_1) || (v0_4.getIntrinsicHeight() != v6_1))) {
            int v5_5 = android.graphics.Bitmap.createBitmap(v6_1, v6_1, android.graphics.Bitmap$Config.ARGB_8888);
            android.graphics.drawable.Drawable[] v2_1 = new android.graphics.Canvas(v5_5);
            v0_4.setBounds(0, 0, v6_1, v6_1);
            v0_4.draw(v2_1);
            v0_2 = new android.graphics.drawable.BitmapDrawable(v5_5);
            v5_6 = new android.graphics.drawable.BitmapDrawable(v5_5);
        } else {
            v0_2 = ((android.graphics.drawable.BitmapDrawable) v0_4);
            v5_6 = new android.graphics.drawable.BitmapDrawable(v0_2.getBitmap());
        }
        android.graphics.drawable.BitmapDrawable v4_2;
        v5_6.setTileModeX(android.graphics.Shader$TileMode.REPEAT);
        if ((!(v4_4 instanceof android.graphics.drawable.BitmapDrawable)) || ((v4_4.getIntrinsicWidth() != v6_1) || (v4_4.getIntrinsicHeight() != v6_1))) {
            android.graphics.drawable.Drawable[] v2_10 = android.graphics.Bitmap.createBitmap(v6_1, v6_1, android.graphics.Bitmap$Config.ARGB_8888);
            android.graphics.Canvas v3_1 = new android.graphics.Canvas(v2_10);
            v4_4.setBounds(0, 0, v6_1, v6_1);
            v4_4.draw(v3_1);
            v4_2 = new android.graphics.drawable.BitmapDrawable(v2_10);
        } else {
            v4_2 = ((android.graphics.drawable.BitmapDrawable) v4_4);
        }
        android.graphics.drawable.Drawable[] v2_12 = new android.graphics.drawable.Drawable[3];
        v2_12[0] = v0_2;
        v2_12[1] = v4_2;
        v2_12[2] = v5_6;
        android.graphics.drawable.LayerDrawable v6_3 = new android.graphics.drawable.LayerDrawable(v2_12);
        v6_3.setId(0, 16908288);
        v6_3.setId(1, 16908303);
        v6_3.setId(2, 16908301);
        return v6_3;
    }

    public static void h(android.graphics.drawable.Drawable p1, int p2, android.graphics.PorterDuff$Mode p3)
    {
        Throwable v1_1 = p1.mutate();
        if (p3 == null) {
            p3 = m.u.b;
        }
        Class v0 = m.u;
        v1_1.setColorFilter(m.x1.f(p2, p3));
        return;
    }

    public android.content.res.ColorStateList d(android.content.Context p9, int p10)
    {
        if (p10 != 2131230781) {
            if (p10 != 2131230827) {
                if (p10 != 2131230826) {
                    if (p10 != 2131230769) {
                        if (p10 != 2131230763) {
                            if (p10 != 2131230768) {
                                if ((p10 != 2131230822) && (p10 != 2131230823)) {
                                    if (!lc.a.a(((int[]) this.c), p10)) {
                                        if (!lc.a.a(((int[]) this.f), p10)) {
                                            if (!lc.a.a(((int[]) this.g), p10)) {
                                                if (p10 != 2131230819) {
                                                    return 0;
                                                } else {
                                                    return t6.a.g(p9, 2131099671);
                                                }
                                            } else {
                                                return t6.a.g(p9, 2131099668);
                                            }
                                        } else {
                                            return t6.a.g(p9, 2131099669);
                                        }
                                    } else {
                                        return m.b2.d(p9, 2130968840);
                                    }
                                } else {
                                    return t6.a.g(p9, 2131099672);
                                }
                            } else {
                                return lc.a.b(p9, m.b2.c(p9, 2130968832));
                            }
                        } else {
                            return lc.a.b(p9, 0);
                        }
                    } else {
                        return lc.a.b(p9, m.b2.c(p9, 2130968834));
                    }
                } else {
                    int v0_17 = new int[][3];
                    int v10_13 = new int[3];
                    int v3_0 = m.b2.d(p9, 2130968891);
                    if ((v3_0 == 0) || (!v3_0.isStateful())) {
                        v0_17[0] = m.b2.b;
                        v10_13[0] = m.b2.b(p9, 2130968891);
                        v0_17[1] = m.b2.e;
                        v10_13[1] = m.b2.c(p9, 2130968838);
                        v0_17[2] = m.b2.f;
                        v10_13[2] = m.b2.c(p9, 2130968891);
                    } else {
                        int v2_2 = m.b2.b;
                        v0_17[0] = v2_2;
                        v10_13[0] = v3_0.getColorForState(v2_2, 0);
                        v0_17[1] = m.b2.e;
                        v10_13[1] = m.b2.c(p9, 2130968838);
                        v0_17[2] = m.b2.f;
                        v10_13[2] = v3_0.getDefaultColor();
                    }
                    return new android.content.res.ColorStateList(v0_17, v10_13);
                }
            } else {
                return t6.a.g(p9, 2131099673);
            }
        } else {
            return t6.a.g(p9, 2131099670);
        }
    }

    public oc.d e()
    {
        String v0_7;
        String v0_0 = ic.e.a;
        if (v0_0 == null) {
            v0_7 = 0;
        } else {
            v0_7 = ((ic.d) v0_0);
        }
        String v0_8;
        if (v0_7 == null) {
            v0_8 = 0;
        } else {
            v0_8 = v0_7.b();
        }
        String v0_1;
        if (v0_8 == null) {
            v0_1 = 0;
        } else {
            v0_1 = v0_8.getAssets();
        }
        if (v0_1 != null) {
            String v0_2 = v0_1.open(((String) this.g));
            v0_2.getClass();
            return oc.b.g(v0_2);
        } else {
            if (android.os.Build.FINGERPRINT != null) {
                oc.l.g("Platform applicationContext not initialized. Startup Initializer possibly disabled, call OkHttp.initialize before test.");
                return 0;
            } else {
                oc.l.g("Platform applicationContext not initialized. Possibly running Android unit test without Robolectric. Android tests should run with Robolectric and call OkHttp.initialize before test");
                return 0;
            }
        }
    }

    public androidx.lifecycle.d1 f()
    {
        g7.c1 v1_4;
        androidx.lifecycle.d1 v0_1 = new androidx.lifecycle.d1();
        v0_1.k = kotlin.collections.a.G();
        v0_1.g = ((yb.u) this.b);
        v0_1.h = ((String) this.g);
        v0_1.j = ((yb.z) this.d);
        g7.c1 v1_3 = ((java.util.Map) this.e);
        if (!v1_3.isEmpty()) {
            v1_4 = new java.util.LinkedHashMap(v1_3);
        } else {
            v1_4 = kotlin.collections.a.G();
        }
        v0_1.k = v1_4;
        v0_1.i = ((yb.s) this.c).c();
        return v0_1;
    }

    public void g()
    {
        try {
            java.util.concurrent.CountDownLatch v1_1 = new oc.y(this.e());
            try {
                java.util.concurrent.CountDownLatch v0_7 = v1_1.j(((long) v1_1.readInt()));
                Throwable v2_2 = v1_1.j(((long) v1_1.readInt()));
            } catch (java.util.concurrent.CountDownLatch v0_1) {
                try {
                    throw v0_1;
                } catch (Throwable v2_3) {
                    a.a.f(v1_1, v0_1);
                    throw v2_3;
                }
            }
            v1_1.close();
            try {
                v0_7.getClass();
                this.d = v0_7;
                v2_2.getClass();
                this.e = v2_2;
            } catch (java.util.concurrent.CountDownLatch v0_2) {
                throw v0_2;
            }
            ((java.util.concurrent.CountDownLatch) this.c).countDown();
            return;
        } catch (java.util.concurrent.CountDownLatch v0_5) {
            ((java.util.concurrent.CountDownLatch) this.c).countDown();
            throw v0_5;
        }
    }

    public String toString()
    {
        switch (this.a) {
            case 6:
                int v0_2 = ((java.util.Map) this.e);
                StringBuilder v1_1 = new StringBuilder(32);
                v1_1.append("Request{method=");
                v1_1.append(((String) this.g));
                v1_1.append(", url=");
                v1_1.append(((yb.u) this.b));
                int v2_5 = ((yb.s) this.c);
                if (v2_5.size() != 0) {
                    v1_1.append(", headers=[");
                    int v2_6 = v2_5.iterator();
                    int v3_2 = 0;
                    while (v2_6.hasNext()) {
                        String v4_1 = v2_6.next();
                        int v5 = (v3_2 + 1);
                        if (v3_2 < 0) {
                            ha.k.x();
                            throw 0;
                        } else {
                            String v4_2 = ((kotlin.Pair) v4_1);
                            String v6_1 = ((String) v4_2.g);
                            String v4_4 = ((String) v4_2.h);
                            if (v3_2 > 0) {
                                v1_1.append(", ");
                            }
                            v1_1.append(v6_1);
                            v1_1.append(58);
                            if (zb.c.k(v6_1)) {
                                v4_4 = "\u2588\u2588";
                            }
                            v1_1.append(v4_4);
                            v3_2 = v5;
                        }
                    }
                    v1_1.append(93);
                }
                if (!v0_2.isEmpty()) {
                    v1_1.append(", tags=");
                    v1_1.append(v0_2);
                }
                v1_1.append(125);
                return v1_1.toString();
            default:
                return super.toString();
        }
    }
}
