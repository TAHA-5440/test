// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package rc;
public final synthetic class a implements android.view.View$OnClickListener {
    public final synthetic int g;
    public final synthetic Object h;
    public final synthetic Object i;
    public final synthetic Object j;

    public synthetic a(Object p1, Object p2, Object p3, int p4)
    {
        this.g = p4;
        this.h = p1;
        this.i = p2;
        this.j = p3;
        return;
    }

    public final void onClick(android.view.View p19)
    {
        v4.e v8_6 = this.j;
        wc.l v9_5 = this.i;
        vet.pharmapedia.vetpharmapediapakistan.database.models.SlidersModel v10_0 = this.h;
        switch (this.g) {
            case 0:
                wc.l v9_0 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.ContactsModel) v9_5);
                String v0_5 = ((android.app.Activity) ((rc.d) v8_6).f);
                v4.e v8_1 = ((rc.b) v10_0).b();
                if (v8_1 == null) {
                    android.net.Uri v2_1;
                    if (!v9_0.isSajid()) {
                        v2_1 = "+923006936557";
                    } else {
                        v2_1 = "+923072044623";
                    }
                    v0_5.startActivity(new android.content.Intent("android.intent.action.DIAL", android.net.Uri.fromParts("tel", v2_1, 0)));
                } else {
                    if (v8_1 == 1) {
                        android.net.Uri v2_4;
                        if (!v9_0.isSajid()) {
                            v2_4 = "https://api.whatsapp.com/send?phone=923006936557&text=From Vet App\n";
                        } else {
                            v2_4 = "https://api.whatsapp.com/send?phone=923072044623&text=From Vet App\n";
                        }
                        android.content.Intent v3_3 = new android.content.Intent("android.intent.action.VIEW");
                        android.net.Uri v2_5 = android.net.Uri.parse(v2_4);
                        v2_5.getClass();
                        v3_3.setData(v2_5);
                        v0_5.startActivity(v3_3);
                    } else {
                        if (v8_1 == 2) {
                            android.net.Uri v2_7;
                            if (!v9_0.isSajid()) {
                                v2_7 = "vetpharmapediapakistan@gmail.com";
                            } else {
                                v2_7 = "mehadi.gill.766@gmail.com";
                            }
                            android.content.Intent v3_5 = android.net.Uri.encode("From Vet Contact");
                            String v4_1 = android.net.Uri.encode("");
                            StringBuilder v5_2 = new StringBuilder("mailto:");
                            v5_2.append(v2_7);
                            v5_2.append("?&subject=");
                            v5_2.append(v3_5);
                            v5_2.append("&body=");
                            v5_2.append(v4_1);
                            android.net.Uri v2_10 = v5_2.toString();
                            android.content.Intent v3_7 = new android.content.Intent("android.intent.action.VIEW");
                            android.net.Uri v2_11 = android.net.Uri.parse(v2_10);
                            v2_11.getClass();
                            v3_7.setData(v2_11);
                            v0_5.startActivity(v3_7);
                        } else {
                            if (v8_1 == 3) {
                                android.net.Uri v2_14;
                                if (!v9_0.isSajid()) {
                                    v2_14 = android.net.Uri.parse("https://www.instagram.com/hussnain_paf/");
                                    v2_14.getClass();
                                } else {
                                    v2_14 = android.net.Uri.parse("https://www.instagram.com/sajidabbas935/");
                                    v2_14.getClass();
                                }
                                android.content.Intent v3_9 = new android.content.Intent("android.intent.action.VIEW", v2_14);
                                v3_9.setPackage("com.instagram.android");
                                v0_5.startActivity(v3_9);
                            } else {
                                if (v8_1 == 4) {
                                    android.net.Uri v2_22;
                                    if (!v9_0.isSajid()) {
                                        v2_22 = android.net.Uri.parse("https://www.facebook.com/hussnain.mehdi.37/");
                                        v2_22.getClass();
                                    } else {
                                        v2_22 = android.net.Uri.parse("https://www.facebook.com/sajidabbas.kanwal.7");
                                        v2_22.getClass();
                                    }
                                    android.content.Intent v3_13 = new android.content.Intent("android.intent.action.VIEW", v2_22);
                                    v3_13.setPackage("com.facebook.android");
                                    v0_5.startActivity(v3_13);
                                } else {
                                    if (v8_1 == 5) {
                                        android.net.Uri v2_26;
                                        if (!v9_0.isSajid()) {
                                            v2_26 = "https://twitter.com/I_Love_Pakista9";
                                        } else {
                                            v2_26 = "https://twitter.com/DoctorSajidAbb1";
                                        }
                                        android.content.Intent v3_17 = new android.content.Intent("android.intent.action.VIEW");
                                        android.net.Uri v2_27 = android.net.Uri.parse(v2_26);
                                        v2_27.getClass();
                                        v3_17.setData(v2_27);
                                        v0_5.startActivity(v3_17);
                                    }
                                }
                            }
                        }
                    }
                }
                return;
            case 1:
                vet.pharmapedia.vetpharmapediapakistan.database.models.SlidersModel v10_6 = ((rc.l) v10_0);
                wc.l v9_4 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) v9_5);
                v4.e v8_5 = ((rc.k) v8_6);
                String v4_10 = v10_6.e;
                if (!v10_6.f) {
                    xc.a.d = 0;
                    androidx.fragment.app.n0 v12_0 = v10_6.e;
                    tc.b v13_0 = v10_6.g;
                    if (!v9_4.isSaltFavourite()) {
                        String v14_1 = v9_4.getSaltName();
                        String v16_1 = v4_10.getString(2131951649);
                        v16_1.getClass();
                        vet.pharmapedia.vetpharmapediapakistan.utils.a.b(v12_0, v13_0, v14_1, 1, v16_1, new rc.j(v10_6, v8_5, 3));
                    } else {
                        String v14_2 = v9_4.getSaltName();
                        String v16_2 = v4_10.getString(2131952025);
                        v16_2.getClass();
                        vet.pharmapedia.vetpharmapediapakistan.utils.a.b(v12_0, v13_0, v14_2, 0, v16_2, new rc.j(v10_6, v8_5, 2));
                    }
                } else {
                    xc.a.d = 1;
                    androidx.fragment.app.n0 v12_1 = v10_6.e;
                    tc.b v13_1 = v10_6.g;
                    if (!v9_4.isBrandFavourite()) {
                        String v14_3 = v9_4.getBrandName();
                        String v16_3 = v4_10.getString(2131951649);
                        v16_3.getClass();
                        vet.pharmapedia.vetpharmapediapakistan.utils.a.a(v12_1, v13_1, v14_3, 1, v16_3, new rc.j(v10_6, v8_5, 1));
                    } else {
                        String v14_0 = v9_4.getBrandName();
                        String v16_0 = v4_10.getString(2131952025);
                        v16_0.getClass();
                        vet.pharmapedia.vetpharmapediapakistan.utils.a.a(v12_1, v13_1, v14_0, 0, v16_0, new rc.j(v10_6, v8_5, 0));
                    }
                }
                return;
            case 2:
                v4.e v8_4 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.LanguagesModel) v8_6);
                if (((rc.r) v10_0).b() != -1) {
                    String v0_33 = ((rc.s) v9_5).h;
                    v0_33.getClass();
                    ((android.content.SharedPreferences) v0_33.l().h).edit().putString("TO_LANGUAGE_KEY", v8_4.getTranslationAbbr()).apply();
                    android.content.Intent v3_36 = v8_4.getTranslationAbbr();
                    v3_36.getClass();
                    xc.a.c = v3_36;
                    v0_33.setResult(-1);
                    v0_33.finish();
                }
                return;
            case 3:
                wc.l v9_1 = ((wc.l) v9_5);
                v4.e v8_2 = ((v4.e) v8_6);
                try {
                    String v0_11 = android.net.Uri.parse(((vet.pharmapedia.vetpharmapediapakistan.database.models.SlidersModel) v10_0).getRedirectLink());
                    v0_11.getClass();
                    v9_1.startActivity(new android.content.Intent("android.intent.action.VIEW", v0_11));
                } catch (Exception) {
                }
                v8_2.dismiss();
                return;
            default:
                vet.pharmapedia.vetpharmapediapakistan.database.models.SlidersModel v10_5 = ((c0.g) v10_0);
                wc.l v9_2 = ((wc.n) v9_5);
                v4.e v8_3 = ((android.app.Dialog) v8_6);
                String v0_16 = ((android.widget.RatingBar) v10_5.j);
                android.net.Uri v2_29 = ((com.google.android.material.card.MaterialCardView) v10_5.h);
                try {
                    if (v0_16.getRating() != 0) {
                        if (v0_16.getRating() <= 1077936128) {
                            ((androidx.appcompat.widget.AppCompatTextView) v10_5.k).setVisibility(0);
                            ((com.google.android.material.button.MaterialButton) v10_5.i).setVisibility(8);
                            if (v9_2.p == null) {
                                v9_2.p = new android.os.Handler(android.os.Looper.getMainLooper());
                            }
                            String v0_26 = v9_2.p;
                            if (v0_26 == null) {
                                kotlin.jvm.internal.f.i("baseHandler");
                                throw 0;
                            } else {
                                v0_26.postDelayed(new androidx.room.t0(25, v8_3, v10_5), 2000);
                            }
                        } else {
                            v8_3.dismiss();
                            android.content.Intent v3_25 = v9_2.h().getPackageName();
                            String v4_5 = new StringBuilder("https://play.google.com/store/apps/details?id=");
                            v4_5.append(v3_25);
                            android.content.Intent v3_27 = android.net.Uri.parse(v4_5.toString());
                            v3_27.getClass();
                            v9_2.startActivity(new android.content.Intent("android.intent.action.VIEW", v3_27));
                            v8_3.dismiss();
                            if (v2_29.getParent() != null) {
                                String v0_32 = v2_29.getParent();
                                v0_32.getClass();
                                ((android.view.ViewGroup) v0_32).removeView(v2_29);
                            }
                        }
                    } else {
                        String v0_35 = v9_2.h();
                        android.net.Uri v2_36 = v9_2.getString(2131951792);
                        v2_36.getClass();
                        android.net.Uri v2_37 = android.widget.Toast.makeText(v0_35, v2_36, 0);
                        yc.d.a(v2_37.getView(), new yc.c(v0_35));
                        new yc.d(v0_35, v2_37).show();
                    }
                } catch (Exception) {
                }
                return;
        }
    }
}
