// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.utils;
final class GetTranslationCoroutineScope$start$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements ua.p {
    public int g;
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.utils.b h;

    public GetTranslationCoroutineScope$start$1(vet.pharmapedia.vetpharmapediapakistan.utils.b p1, ka.c p2)
    {
        this.h = p1;
        super(2, p2);
        return;
    }

    public final ka.c create(Object p2, ka.c p3)
    {
        return new vet.pharmapedia.vetpharmapediapakistan.utils.GetTranslationCoroutineScope$start$1(this.h, p3);
    }

    public final Object invoke(Object p1, Object p2)
    {
        return ((vet.pharmapedia.vetpharmapediapakistan.utils.GetTranslationCoroutineScope$start$1) this.create(((gb.v) p1), ((ka.c) p2))).invokeSuspend(ga.p.a);
    }

    public final Object invokeSuspend(Object p18)
    {
        kotlin.coroutines.intrinsics.CoroutineSingletons v3 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        String v0_13 = this.g;
        if (v0_13 == null) {
            kotlin.b.b(p18);
            vet.pharmapedia.vetpharmapediapakistan.utils.b v6 = this.h;
            String v0_0 = v6.g;
            int v12_0 = 0;
            try {
                String v7_10 = java.net.URLEncoder.encode(v6.h, "UTF-8");
                boolean v8_8 = java.net.URLEncoder.encode("en", "UTF-8");
                String v0_12 = java.net.URLEncoder.encode(v0_0, "UTF-8");
            } catch (String v0_5) {
                v0_5.printStackTrace();
                String v0_3 = "";
                int v4_8 = new kotlin.jvm.internal.Ref$ObjectRef();
                v4_8.g = "";
                if (!v0_3.equals("")) {
                    java.util.ArrayList v2_2 = java.util.Locale.ROOT;
                    int v5_3 = v0_3.toLowerCase(v2_2);
                    v5_3.getClass();
                    if (!db.i.T(v5_3, "javax.net.ssl", 0)) {
                        java.util.ArrayList v2_3 = v0_3.toLowerCase(v2_2);
                        v2_3.getClass();
                        if (!db.i.T(v2_3, "java.net.unknownhostexception", 0)) {
                            v4_8.g = String.valueOf(android.text.Html.fromHtml(v0_3, 0));
                        }
                    }
                }
                java.util.ArrayList v2_6 = new vet.pharmapedia.vetpharmapediapakistan.utils.GetTranslationCoroutineScope$start$1$1(v6, v4_8, 0);
                this.g = 1;
                if (gb.w.z(lb.k.a, v2_6, this) == v3) {
                    return v3;
                }
            }
            StringBuilder v11_2 = new StringBuilder();
            org.json.JSONArray v13_2 = g6.f0.j(String.format("https://translate.google.com/translate_a/single?&client=gtx&sl=%s&tl=%s&q=%s&dt=t", java.util.Arrays.copyOf(new Object[] {v8_8, v7_10, v0_12}), 3)));
            if (!android.text.TextUtils.isEmpty(v13_2)) {
                org.json.JSONArray v13_3 = new org.json.JSONArray(v13_2).getJSONArray(0);
                int v14_5 = v13_3.length();
                int v4_10 = 0;
                while (v4_10 < v14_5) {
                    int v5_8 = v13_3.getJSONArray(v4_10).getString(v12_0);
                    if ((!android.text.TextUtils.isEmpty(v5_8)) && (!kotlin.jvm.internal.f.a(v5_8, "null"))) {
                        v11_2.append(v5_8);
                    }
                    v4_10++;
                    v12_0 = 0;
                }
            }
            if (v11_2.toString().length() == 0) {
                String v0_17 = g6.f0.j(String.format("https://clients4.google.com/translate_a/t?client=dict-chrome-ex&sl=%s&tl=%s&q=%s&dt=t", java.util.Arrays.copyOf(new Object[] {v8_8, v7_10, v0_12}), 3)));
                if (!android.text.TextUtils.isEmpty(v0_17)) {
                    String v0_18 = new org.json.JSONTokener(v0_17).nextValue();
                    if (!(v0_18 instanceof org.json.JSONObject)) {
                        if (!(v0_18 instanceof org.json.JSONArray)) {
                            if ((v0_18 instanceof java.util.ArrayList)) {
                                int v4_23 = ((java.util.Collection) v0_18).size();
                                int v5_0 = 0;
                                while (v5_0 < v4_23) {
                                    String v7_13 = ((java.util.ArrayList) v0_18).get(v5_0);
                                    if (!(v7_13 instanceof java.util.ArrayList)) {
                                        if ((v7_13 instanceof String)) {
                                            v11_2.append(((String) v7_13));
                                        }
                                    } else {
                                        if (((java.util.ArrayList) v7_13).size() > 0) {
                                            String v7_1 = ((java.util.ArrayList) v7_13).get(0);
                                            if ((v7_1 instanceof String)) {
                                                v11_2.append(((String) v7_1));
                                            }
                                        }
                                    }
                                    v5_0++;
                                }
                            }
                        } else {
                            int v4_2 = ((org.json.JSONArray) v0_18).length();
                            int v5_1 = 0;
                            while (v5_1 < v4_2) {
                                v11_2.append(((org.json.JSONArray) v0_18).getString(v5_1));
                                v5_1++;
                            }
                        }
                    } else {
                        if (((org.json.JSONObject) v0_18).has("sentences")) {
                            String v0_2 = ((org.json.JSONObject) v0_18).getJSONArray("sentences");
                            int v4_6 = v0_2.length();
                            int v5_2 = 0;
                            while (v5_2 < v4_6) {
                                String v7_7 = v0_2.getJSONObject(v5_2);
                                if ((v7_7 != null) && (v7_7.has("trans"))) {
                                    v11_2.append(v7_7.getString("trans"));
                                }
                                v5_2++;
                            }
                        }
                    }
                }
            }
            v0_3 = v11_2.toString();
        } else {
            if (v0_13 != 1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                return 0;
            } else {
                kotlin.b.b(p18);
            }
        }
        return ga.p.a;
    }
}
