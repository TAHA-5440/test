// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package pc;
public final class h implements u1.d, g5.h, p2.h, ka.f, y0.b {
    public final synthetic int g;

    public synthetic h(int p1)
    {
        this.g = p1;
        return;
    }

    public static final boolean c(oc.w p5)
    {
        okio.ByteString v0_0 = p5.g;
        int v1_0 = okio.ByteString.l(v0_0, pc.c.a);
        if (v1_0 == -1) {
            v1_0 = okio.ByteString.l(p5.g, pc.c.b);
        }
        if (v1_0 == -1) {
            if ((p5.e() != null) && (v0_0.e() == 2)) {
                v0_0 = okio.ByteString.j;
            }
        } else {
            v0_0 = okio.ByteString.q(v0_0, (v1_0 + 1), 0, 2);
        }
        return (db.p.K(v0_0.t(), ".class", 1) ^ 1);
    }

    public static java.util.Map d(String p2)
    {
        p2.getClass();
        java.util.Map v2_1 = new com.google.gson.c().a(p2, new sc.a().b);
        v2_1.getClass();
        return ((java.util.Map) v2_1);
    }

    private final void e(Object p1)
    {
        return;
    }

    public Object a(androidx.datastore.core.CorruptionException p1)
    {
        throw p1;
    }

    public q0.o1 b(android.view.View p6, q0.o1 p7, g5.i p8)
    {
        p8.d = (p7.a() + p8.d);
        int v1_2 = 1;
        if (p6.getLayoutDirection() != 1) {
            v1_2 = 0;
        }
        int v4_0;
        int v0_1 = p7.b();
        int v2 = p7.c();
        if (v1_2 == 0) {
            v4_0 = v0_1;
        } else {
            v4_0 = v2;
        }
        int v3_1 = (p8.a + v4_0);
        p8.a = v3_1;
        if (v1_2 == 0) {
            v0_1 = v2;
        }
        int v4_2 = (p8.c + v0_1);
        p8.c = v4_2;
        p6.setPaddingRelative(v3_1, p8.b, v4_2, p8.d);
        return p7;
    }

    public void f(android.view.View p8, float p9)
    {
        switch (this.g) {
            case 9:
                float v4_1;
                float v0_27 = ((float) p8.getHeight());
                float v1_14 = ((float) p8.getWidth());
                float v2_19 = p9 cmp ((float) 0);
                if (v2_19 >= 0) {
                    v4_1 = Math.abs((1065353216 - p9));
                } else {
                    v4_1 = 1065353216;
                }
                float v1_16;
                int v3_2 = Math.min(v4_1, 1065353216);
                p8.setScaleX(v3_2);
                p8.setScaleY(v3_2);
                p8.setPivotX((v1_14 * 1056964608));
                p8.setPivotY((v0_27 * 1056964608));
                if (v2_19 >= 0) {
                    v1_16 = (((- v1_14) * p9) * 1048576000);
                } else {
                    v1_16 = (v1_14 * p9);
                }
                p8.setTranslationX(v1_16);
                return;
            case 10:
                float v0_20 = 0;
                if (p9 < 0) {
                    v0_20 = ((float) p8.getWidth());
                }
                p8.setPivotX(v0_20);
                p8.setPivotY((((float) p8.getHeight()) * 1056964608));
                p8.setRotationY((p9 * 1119092736));
                return;
            case 11:
                p8.setTranslationX(((- p9) * ((float) p8.getWidth())));
                if (((double) Math.abs(p9)) >= 4602678819172646912) {
                    if (((double) Math.abs(p9)) > 4602678819172646912) {
                        p8.setVisibility(8);
                    }
                } else {
                    p8.setVisibility(0);
                    p8.setScaleX((((float) 1) - Math.abs(p9)));
                    p8.setScaleY((((float) 1) - Math.abs(p9)));
                }
                if (p9 >= ((float) -1)) {
                    if (p9 > ((float) 0)) {
                        if (p9 > ((float) 1)) {
                            p8.setAlpha(0);
                        } else {
                            p8.setAlpha(1065353216);
                            p8.setRotation(((Math.abs(p9) * (Math.abs(p9) * (Math.abs(p9) * (Math.abs(p9) * (Math.abs(p9) * (Math.abs(p9) * Math.abs(p9))))))) * ((float) -36000)));
                        }
                    } else {
                        p8.setAlpha(1065353216);
                        p8.setRotation(((Math.abs(p9) * (Math.abs(p9) * (Math.abs(p9) * (Math.abs(p9) * (Math.abs(p9) * (Math.abs(p9) * Math.abs(p9))))))) * ((float) 36000)));
                    }
                } else {
                    p8.setAlpha(0);
                }
                return;
            case 12:
                float v0_59;
                float v9_14 = (p9 * -1020002304);
                if ((v9_14 <= 1119092736) && (v9_14 >= -1028390912)) {
                    v0_59 = 1065353216;
                } else {
                    v0_59 = 0;
                }
                p8.setAlpha(v0_59);
                p8.setPivotX((((float) p8.getWidth()) * 1056964608));
                p8.setPivotY((((float) p8.getHeight()) * 1056964608));
                p8.setRotationX(v9_14);
                return;
            case 13:
                p8.setTranslationX(((- p9) * ((float) p8.getWidth())));
                if (p9 >= ((float) -1)) {
                    if (p9 > ((float) 0)) {
                        if (p9 > ((float) 1)) {
                            p8.setAlpha(0);
                        } else {
                            p8.setAlpha(1065353216);
                            p8.setPivotX(((float) p8.getWidth()));
                            p8.setRotationY((Math.abs(p9) * ((float) -90)));
                        }
                    } else {
                        p8.setAlpha(1065353216);
                        p8.setPivotX(0);
                        p8.setRotationY((Math.abs(p9) * ((float) 90)));
                    }
                } else {
                    p8.setAlpha(0);
                }
                return;
            case 14:
                float v0_42 = p8.getWidth();
                float v1_20 = p8.getHeight();
                float v9_16 = ((p9 * -1049624576) * -1080033280);
                p8.setPivotX((((float) v0_42) * 1056964608));
                p8.setPivotY(((float) v1_20));
                p8.setRotation(v9_16);
                return;
            default:
                float v0_36;
                if (p9 >= ((float) 0)) {
                    v0_36 = Math.abs((1065353216 - p9));
                } else {
                    v0_36 = (p9 + 1065353216);
                }
                float v1_18;
                p8.setScaleX(v0_36);
                p8.setScaleY(v0_36);
                p8.setPivotX((((float) p8.getWidth()) * 1056964608));
                p8.setPivotY((((float) p8.getHeight()) * 1056964608));
                if ((p9 >= -1082130432) && (p9 <= 1065353216)) {
                    v1_18 = (1065353216 - (v0_36 - 1065353216));
                } else {
                    v1_18 = 0;
                }
                p8.setAlpha(v1_18);
                return;
        }
    }

    public void g()
    {
        return;
    }

    public void h(int p1, Object p2)
    {
        return;
    }
}
