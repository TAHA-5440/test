// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package qc;
public final class e implements d7.b {
    public final synthetic int a;
    public final c7.a b;
    public final int c;

    public synthetic e(c7.a p1, int p2, int p3)
    {
        this.a = p3;
        this.b = p1;
        this.c = p2;
        return;
    }

    public final Object get()
    {
        android.view.View v2_0 = 2131362323;
        androidx.constraintlayout.widget.ConstraintLayout v3_10 = 2131362296;
        android.view.View v6_3 = this.c;
        int v7_3 = this.b;
        uc.k v8_0 = 0;
        switch (this.a) {
            case 0:
                uc.d v13_1;
                androidx.constraintlayout.widget.ConstraintLayout v12_4;
                int v7_1 = ((qc.f) v7_3);
                android.view.View v1_14 = 2131361915;
                int v9_2 = 2131361870;
                int v10_2 = 2131362157;
                switch (v6_3) {
                    case 0:
                        android.view.View v2_83 = v7_1.a.getLayoutInflater().inflate(2131558428, 0, 0);
                        if (a.a.h(v2_83, 2131361846) == null) {
                            v3_10 = 2131361846;
                        } else {
                            androidx.constraintlayout.widget.ConstraintLayout v14_15 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v2_83, 2131361900));
                            if (v14_15 == null) {
                                v3_10 = 2131361900;
                            } else {
                                android.widget.ProgressBar v15_12 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v2_83, 2131361915));
                                if (v15_12 != null) {
                                    androidx.appcompat.widget.AppCompatTextView v16_15 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v2_83, 2131362157));
                                    if (v16_15 == null) {
                                        v3_10 = 2131362157;
                                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v2_83.getResources().getResourceName(v3_10)));
                                    } else {
                                        v1_14 = 2131362282;
                                        androidx.appcompat.widget.AppCompatTextView v17_12 = ((android.widget.ProgressBar) a.a.h(v2_83, 2131362282));
                                        if (v17_12 != null) {
                                            androidx.appcompat.widget.AppCompatTextView v18_7 = ((androidx.recyclerview.widget.RecyclerView) a.a.h(v2_83, 2131362296));
                                            if (v18_7 == null) {
                                            } else {
                                                v12_4 = new uc.a(((androidx.constraintlayout.widget.ConstraintLayout) v2_83), v14_15, v15_12, v16_15, v17_12, v18_7);
                                                v8_0 = v12_4;
                                            }
                                        }
                                    }
                                }
                                v3_10 = v1_14;
                            }
                        }
                        break;
                    case 1:
                        android.view.View v1_100 = v7_1.a.getLayoutInflater().inflate(2131558429, 0, 0);
                        if (a.a.h(v1_100, 2131361846) == null) {
                            v10_2 = 2131361846;
                        } else {
                            android.view.View v2_80 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v1_100, 2131361900));
                            if (v2_80 == null) {
                                v10_2 = 2131361900;
                            } else {
                                if (((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_100, 2131362157)) != null) {
                                    v10_2 = 2131362158;
                                    androidx.constraintlayout.widget.ConstraintLayout v3_51 = ((androidx.recyclerview.widget.RecyclerView) a.a.h(v1_100, 2131362158));
                                    if (v3_51 != null) {
                                        v8_0 = new uc.b(((androidx.constraintlayout.widget.ConstraintLayout) v1_100), v2_80, v3_51);
                                    }
                                }
                            }
                        }
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v1_100.getResources().getResourceName(v10_2)));
                        break;
                    case 2:
                        android.view.View v1_93 = v7_1.a.getLayoutInflater().inflate(2131558430, 0, 0);
                        if (a.a.h(v1_93, 2131361846) == null) {
                            v10_2 = 2131361846;
                        } else {
                            android.view.View v2_76 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v1_93, 2131361900));
                            if (v2_76 == null) {
                                v10_2 = 2131361900;
                            } else {
                                if (((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_93, 2131362157)) != null) {
                                    v10_2 = 2131362307;
                                    androidx.constraintlayout.widget.ConstraintLayout v3_47 = ((androidx.recyclerview.widget.RecyclerView) a.a.h(v1_93, 2131362307));
                                    if (v3_47 != null) {
                                        v10_2 = 2131362310;
                                        if (((com.google.android.material.card.MaterialCardView) a.a.h(v1_93, 2131362310)) != null) {
                                            v10_2 = 2131362311;
                                            if (((com.google.android.material.card.MaterialCardView) a.a.h(v1_93, 2131362311)) != null) {
                                                v8_0 = new uc.c(((androidx.constraintlayout.widget.ConstraintLayout) v1_93), v2_76, v3_47);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v1_93.getResources().getResourceName(v10_2)));
                        break;
                    case 3:
                        android.view.View v1_87 = v7_1.a.getLayoutInflater().inflate(2131558431, 0, 0);
                        android.view.View v2_56 = 2131361796;
                        if (((androidx.appcompat.widget.AppCompatImageView) a.a.h(v1_87, 2131361796)) == null) {
                            v9_2 = v2_56;
                        } else {
                            v2_56 = 2131361797;
                            android.widget.ProgressBar v15_10 = ((androidx.constraintlayout.widget.ConstraintLayout) a.a.h(v1_87, 2131361797));
                            if (v15_10 == null) {
                            } else {
                                v2_56 = 2131361798;
                                androidx.appcompat.widget.AppCompatTextView v16_13 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_87, 2131361798));
                                if (v16_13 == null) {
                                } else {
                                    v2_56 = 2131361799;
                                    androidx.appcompat.widget.AppCompatTextView v17_10 = a.a.h(v1_87, 2131361799);
                                    if (v17_10 == null) {
                                    } else {
                                        v2_56 = 2131361800;
                                        androidx.appcompat.widget.AppCompatTextView v18_5 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v1_87, 2131361800));
                                        if (v18_5 == null) {
                                        } else {
                                            androidx.appcompat.widget.AppCompatTextView v19_4 = a.a.h(v1_87, 2131361846);
                                            if (v19_4 == null) {
                                                v9_2 = 2131361846;
                                            } else {
                                                androidx.appcompat.widget.AppCompatTextView v20_3 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v1_87, 2131361870));
                                                if (v20_3 != null) {
                                                    androidx.appcompat.widget.AppCompatTextView v21_3 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v1_87, 2131361900));
                                                    if (v21_3 == null) {
                                                        v9_2 = 2131361900;
                                                    } else {
                                                        v9_2 = 2131362094;
                                                        if (((androidx.appcompat.widget.AppCompatImageView) a.a.h(v1_87, 2131362094)) != null) {
                                                            v9_2 = 2131362095;
                                                            androidx.recyclerview.widget.RecyclerView v22_3 = ((androidx.constraintlayout.widget.ConstraintLayout) a.a.h(v1_87, 2131362095));
                                                            if (v22_3 != null) {
                                                                v9_2 = 2131362096;
                                                                androidx.appcompat.widget.AppCompatTextView v23_1 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_87, 2131362096));
                                                                if (v23_1 != null) {
                                                                    v9_2 = 2131362097;
                                                                    android.view.View v24 = a.a.h(v1_87, 2131362097);
                                                                    if (v24 != null) {
                                                                        v9_2 = 2131362098;
                                                                        androidx.appcompat.widget.AppCompatImageView v25_1 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v1_87, 2131362098));
                                                                        if (v25_1 != null) {
                                                                            androidx.appcompat.widget.AppCompatTextView v26_1 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_87, 2131362157));
                                                                            if (v26_1 == null) {
                                                                                v9_2 = 2131362157;
                                                                            } else {
                                                                                v9_2 = 2131362250;
                                                                                if (((androidx.appcompat.widget.AppCompatImageView) a.a.h(v1_87, 2131362250)) != null) {
                                                                                    v9_2 = 2131362251;
                                                                                    androidx.constraintlayout.widget.ConstraintLayout v27_1 = ((androidx.constraintlayout.widget.ConstraintLayout) a.a.h(v1_87, 2131362251));
                                                                                    if (v27_1 != null) {
                                                                                        v9_2 = 2131362252;
                                                                                        android.view.View v28 = a.a.h(v1_87, 2131362252);
                                                                                        if (v28 != null) {
                                                                                            v9_2 = 2131362255;
                                                                                            androidx.appcompat.widget.AppCompatTextView v29_1 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_87, 2131362255));
                                                                                            if (v29_1 != null) {
                                                                                                v9_2 = 2131362256;
                                                                                                androidx.appcompat.widget.AppCompatImageView v30_1 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v1_87, 2131362256));
                                                                                                if (v30_1 != null) {
                                                                                                    v9_2 = 2131362267;
                                                                                                    android.widget.ProgressBar v31_1 = ((android.widget.ProgressBar) a.a.h(v1_87, 2131362267));
                                                                                                    if (v31_1 != null) {
                                                                                                        v9_2 = 2131362270;
                                                                                                        android.widget.ProgressBar v32_1 = ((android.widget.ProgressBar) a.a.h(v1_87, 2131362270));
                                                                                                        if (v32_1 != null) {
                                                                                                            v9_2 = 2131362272;
                                                                                                            android.widget.ProgressBar v33_1 = ((android.widget.ProgressBar) a.a.h(v1_87, 2131362272));
                                                                                                            if (v33_1 != null) {
                                                                                                                v13_1 = new uc.d(((androidx.constraintlayout.widget.ConstraintLayout) v1_87), v15_10, v16_13, v17_10, v18_5, v19_4, v20_3, v21_3, v22_3, v23_1, v24, v25_1, v26_1, v27_1, v28, v29_1, v30_1, v31_1, v32_1, v33_1);
                                                                                                                v8_0 = v13_1;
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v1_87.getResources().getResourceName(v9_2)));
                        break;
                    case 4:
                        android.view.View v1_78 = v7_1.a.getLayoutInflater().inflate(2131558432, 0, 0);
                        if (a.a.h(v1_78, 2131361846) == null) {
                            v10_2 = 2131361846;
                        } else {
                            android.view.View v2_54 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v1_78, 2131361900));
                            if (v2_54 == null) {
                                v10_2 = 2131361900;
                            } else {
                                if (((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_78, 2131362157)) != null) {
                                    v10_2 = 2131362438;
                                    if (((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_78, 2131362438)) != null) {
                                        v10_2 = 2131362439;
                                        if (((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_78, 2131362439)) != null) {
                                            v10_2 = 2131362452;
                                            if (((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_78, 2131362452)) != null) {
                                                v10_2 = 2131362454;
                                                androidx.constraintlayout.widget.ConstraintLayout v3_38 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_78, 2131362454));
                                                if (v3_38 != null) {
                                                    v8_0 = new uc.e(((androidx.constraintlayout.widget.ConstraintLayout) v1_78), v2_54, v3_38);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v1_78.getResources().getResourceName(v10_2)));
                        break;
                    case 5:
                        android.view.View v1_71 = v7_1.a.getLayoutInflater().inflate(2131558433, 0, 0);
                        if (a.a.h(v1_71, 2131361846) == null) {
                            v3_10 = 2131361846;
                        } else {
                            android.view.View v2_50 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v1_71, 2131361900));
                            if (v2_50 == null) {
                                v3_10 = 2131361900;
                            } else {
                                if (((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_71, 2131362157)) == null) {
                                    v3_10 = 2131362157;
                                } else {
                                    android.view.View v5_23 = ((androidx.recyclerview.widget.RecyclerView) a.a.h(v1_71, 2131362296));
                                    if (v5_23 != null) {
                                        v8_0 = new uc.f(((androidx.constraintlayout.widget.ConstraintLayout) v1_71), v2_50, v5_23);
                                    }
                                }
                            }
                        }
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v1_71.getResources().getResourceName(v3_10)));
                        break;
                    case 6:
                        android.view.View v1_63 = v7_1.a.getLayoutInflater().inflate(2131558434, 0, 0);
                        if (a.a.h(v1_63, 2131361846) == null) {
                            v10_2 = 2131361846;
                        } else {
                            androidx.constraintlayout.widget.ConstraintLayout v14_11 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v1_63, 2131361900));
                            if (v14_11 == null) {
                                v10_2 = 2131361900;
                            } else {
                                android.view.View v2_40 = 2131361926;
                                android.widget.ProgressBar v15_8 = ((com.google.android.material.button.MaterialButton) a.a.h(v1_63, 2131361926));
                                if (v15_8 != null) {
                                    v2_40 = 2131361929;
                                    androidx.appcompat.widget.AppCompatTextView v16_11 = ((com.google.android.material.button.MaterialButton) a.a.h(v1_63, 2131361929));
                                    if (v16_11 != null) {
                                        v2_40 = 2131362030;
                                        androidx.appcompat.widget.AppCompatTextView v17_9 = ((androidx.appcompat.widget.AppCompatEditText) a.a.h(v1_63, 2131362030));
                                        if (v17_9 != null) {
                                            if (((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_63, 2131362157)) == null) {
                                                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v1_63.getResources().getResourceName(v10_2)));
                                            } else {
                                                v10_2 = 2131362446;
                                                if (((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_63, 2131362446)) == null) {
                                                } else {
                                                    v10_2 = 2131362450;
                                                    if (((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_63, 2131362450)) == null) {
                                                    } else {
                                                        v12_4 = new uc.g(((androidx.constraintlayout.widget.ConstraintLayout) v1_63), v14_11, v15_8, v16_11, v17_9);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                v10_2 = v2_40;
                            }
                        }
                        break;
                    case 7:
                        android.view.View v1_55 = v7_1.a.getLayoutInflater().inflate(2131558435, 0, 0);
                        if (a.a.h(v1_55, 2131361846) == null) {
                            v2_0 = 2131361846;
                        } else {
                            androidx.constraintlayout.widget.ConstraintLayout v3_25 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v1_55, 2131361900));
                            if (v3_25 == null) {
                                v2_0 = 2131361900;
                            } else {
                                if (((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_55, 2131362157)) == null) {
                                    v2_0 = 2131362157;
                                } else {
                                    android.view.View v6_2 = ((androidx.recyclerview.widget.RecyclerView) a.a.h(v1_55, 2131362306));
                                    if (v6_2 == null) {
                                        v2_0 = 2131362306;
                                    } else {
                                        android.view.View v5_18 = ((androidx.appcompat.widget.AppCompatEditText) a.a.h(v1_55, 2131362323));
                                        if (v5_18 != null) {
                                            v8_0 = new uc.h(((androidx.constraintlayout.widget.ConstraintLayout) v1_55), v3_25, v6_2, v5_18);
                                        }
                                    }
                                }
                            }
                        }
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v1_55.getResources().getResourceName(v2_0)));
                        break;
                    case 8:
                        android.view.View v1_48 = v7_1.a.getLayoutInflater().inflate(2131558436, 0, 0);
                        android.view.View v2_36 = 2131361910;
                        androidx.constraintlayout.widget.ConstraintLayout v3_21 = ((com.google.android.material.bottomnavigation.BottomNavigationView) a.a.h(v1_48, 2131361910));
                        if (v3_21 != null) {
                            v2_36 = 2131362159;
                            android.view.View v5_13 = ((androidx.viewpager2.widget.ViewPager2) a.a.h(v1_48, 2131362159));
                            if (v5_13 != null) {
                                v8_0 = new uc.i(((androidx.constraintlayout.widget.ConstraintLayout) v1_48), v3_21, v5_13);
                            }
                        }
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v1_48.getResources().getResourceName(v2_36)));
                        break;
                    case 9:
                        android.view.View v2_34 = v7_1.a.getLayoutInflater().inflate(2131558437, 0, 0);
                        if (a.a.h(v2_34, 2131361846) == null) {
                            v3_10 = 2131361846;
                        } else {
                            androidx.constraintlayout.widget.ConstraintLayout v14_7 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v2_34, 2131361870));
                            if (v14_7 == null) {
                                v3_10 = 2131361870;
                            } else {
                                android.widget.ProgressBar v15_6 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v2_34, 2131361900));
                                if (v15_6 == null) {
                                    v3_10 = 2131361900;
                                } else {
                                    androidx.appcompat.widget.AppCompatTextView v16_9 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v2_34, 2131361915));
                                    if (v16_9 != null) {
                                        v1_14 = 2131361955;
                                        androidx.appcompat.widget.AppCompatTextView v17_7 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v2_34, 2131361955));
                                        if (v17_7 != null) {
                                            v1_14 = 2131361956;
                                            androidx.appcompat.widget.AppCompatTextView v18_3 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v2_34, 2131361956));
                                            if (v18_3 != null) {
                                                v1_14 = 2131361968;
                                                androidx.appcompat.widget.AppCompatTextView v19_3 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v2_34, 2131361968));
                                                if (v19_3 != null) {
                                                    v1_14 = 2131361969;
                                                    androidx.appcompat.widget.AppCompatTextView v20_1 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v2_34, 2131361969));
                                                    if (v20_1 != null) {
                                                        androidx.appcompat.widget.AppCompatTextView v21_1 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v2_34, 2131362157));
                                                        if (v21_1 == null) {
                                                            v3_10 = 2131362157;
                                                            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v2_34.getResources().getResourceName(v3_10)));
                                                        } else {
                                                            androidx.recyclerview.widget.RecyclerView v22_1 = ((androidx.recyclerview.widget.RecyclerView) a.a.h(v2_34, 2131362296));
                                                            if (v22_1 == null) {
                                                            } else {
                                                                v12_4 = new uc.j(((androidx.constraintlayout.widget.ConstraintLayout) v2_34), v14_7, v15_6, v16_9, v17_7, v18_3, v19_3, v20_1, v21_1, v22_1);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    v3_10 = v1_14;
                                }
                            }
                        }
                        break;
                    case 10:
                        android.view.View v1_37 = v7_1.a.getLayoutInflater().inflate(2131558438, 0, 0);
                        if (a.a.h(v1_37, 2131361846) == null) {
                            v10_2 = 2131361846;
                        } else {
                            if (((androidx.appcompat.widget.AppCompatImageView) a.a.h(v1_37, 2131361900)) == null) {
                                v10_2 = 2131361900;
                            } else {
                                android.view.View v2_26 = 2131361923;
                                uc.d v13_5 = ((com.google.android.material.button.MaterialButton) a.a.h(v1_37, 2131361923));
                                if (v13_5 != null) {
                                    v2_26 = 2131361975;
                                    if (((com.google.android.material.card.MaterialCardView) a.a.h(v1_37, 2131361975)) != null) {
                                        v2_26 = 2131361977;
                                        if (((com.google.android.material.card.MaterialCardView) a.a.h(v1_37, 2131361977)) != null) {
                                            v2_26 = 2131362110;
                                            androidx.constraintlayout.widget.ConstraintLayout v14_5 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v1_37, 2131362110));
                                            if (v14_5 != null) {
                                                if (((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_37, 2131362157)) == null) {
                                                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v1_37.getResources().getResourceName(v10_2)));
                                                } else {
                                                    v10_2 = 2131362271;
                                                    android.widget.ProgressBar v15_4 = ((android.widget.ProgressBar) a.a.h(v1_37, 2131362271));
                                                    if (v15_4 == null) {
                                                    } else {
                                                        v10_2 = 2131362447;
                                                        androidx.appcompat.widget.AppCompatTextView v16_7 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_37, 2131362447));
                                                        if (v16_7 == null) {
                                                        } else {
                                                            v10_2 = 2131362453;
                                                            androidx.appcompat.widget.AppCompatTextView v17_5 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_37, 2131362453));
                                                            if (v17_5 == null) {
                                                            } else {
                                                                v8_0 = new uc.k(((androidx.constraintlayout.widget.ConstraintLayout) v1_37), v13_5, v14_5, v15_4, v16_7, v17_5);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                v10_2 = v2_26;
                            }
                        }
                        break;
                    case 11:
                        android.view.View v1_31 = v7_1.a.getLayoutInflater().inflate(2131558439, 0, 0);
                        if (a.a.h(v1_31, 2131361846) == null) {
                            v10_2 = 2131361846;
                        } else {
                            androidx.constraintlayout.widget.ConstraintLayout v14_3 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v1_31, 2131361900));
                            if (v14_3 == null) {
                                v10_2 = 2131361900;
                            } else {
                                if (((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_31, 2131362157)) != null) {
                                    v10_2 = 2131362281;
                                    android.widget.ProgressBar v15_2 = ((android.widget.ProgressBar) a.a.h(v1_31, 2131362281));
                                    if (v15_2 != null) {
                                        v10_2 = 2131362448;
                                        androidx.appcompat.widget.AppCompatTextView v16_5 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_31, 2131362448));
                                        if (v16_5 != null) {
                                            v10_2 = 2131362472;
                                            androidx.appcompat.widget.AppCompatTextView v17_3 = ((android.webkit.WebView) a.a.h(v1_31, 2131362472));
                                            if (v17_3 != null) {
                                                v12_4 = new uc.l(((androidx.constraintlayout.widget.ConstraintLayout) v1_31), v14_3, v15_2, v16_5, v17_3);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v1_31.getResources().getResourceName(v10_2)));
                        break;
                    case 12:
                        android.view.View v1_24 = v7_1.a.getLayoutInflater().inflate(2131558440, 0, 0);
                        android.view.View v2_13 = 2131362113;
                        androidx.constraintlayout.widget.ConstraintLayout v3_7 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v1_24, 2131362113));
                        if (v3_7 != null) {
                            v2_13 = 2131362361;
                            if (((android.widget.ProgressBar) a.a.h(v1_24, 2131362361)) != null) {
                                v2_13 = 2131362442;
                                if (((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_24, 2131362442)) != null) {
                                    v8_0 = new uc.m(((androidx.constraintlayout.widget.ConstraintLayout) v1_24), v3_7);
                                }
                            }
                        }
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v1_24.getResources().getResourceName(v2_13)));
                        break;
                    case 13:
                        android.view.View v1_17 = v7_1.a.getLayoutInflater().inflate(2131558441, 0, 0);
                        android.widget.ProgressBar v15_0 = a.a.h(v1_17, 2131361846);
                        if (v15_0 == null) {
                            v10_2 = 2131361846;
                        } else {
                            androidx.appcompat.widget.AppCompatTextView v16_3 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v1_17, 2131361900));
                            if (v16_3 == null) {
                                v10_2 = 2131361900;
                            } else {
                                android.view.View v2_7 = 2131361924;
                                androidx.appcompat.widget.AppCompatTextView v17_1 = ((com.google.android.material.button.MaterialButton) a.a.h(v1_17, 2131361924));
                                if (v17_1 != null) {
                                    v2_7 = 2131361925;
                                    androidx.appcompat.widget.AppCompatTextView v18_1 = ((com.google.android.material.button.MaterialButton) a.a.h(v1_17, 2131361925));
                                    if (v18_1 != null) {
                                        if (((androidx.appcompat.widget.AppCompatTextView) a.a.h(v1_17, 2131362157)) == null) {
                                            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v1_17.getResources().getResourceName(v10_2)));
                                        } else {
                                            v10_2 = 2131362309;
                                            androidx.appcompat.widget.AppCompatTextView v19_1 = ((androidx.recyclerview.widget.RecyclerView) a.a.h(v1_17, 2131362309));
                                            if (v19_1 == null) {
                                            } else {
                                                v13_1 = new uc.n(((androidx.constraintlayout.widget.ConstraintLayout) v1_17), v15_0, v16_3, v17_1, v18_1, v19_1);
                                            }
                                        }
                                    }
                                }
                                v10_2 = v2_7;
                            }
                        }
                        break;
                    default:
                        throw new AssertionError(v6_3);
                }
                return v8_0;
            case 1:
                int v9_1;
                android.view.View v1_3 = ((qc.f) v7_3).a;
                if (v6_3 == null) {
                    android.view.View v1_18 = v1_3.getLayoutInflater().inflate(2131558467, 0, 0);
                    android.view.View v2_8 = 2131362035;
                    uc.k v11_2 = ((com.google.android.material.button.MaterialButton) a.a.h(v1_18, 2131362035));
                    if (v11_2 != null) {
                        v2_8 = 2131362036;
                        androidx.constraintlayout.widget.ConstraintLayout v12_3 = ((com.google.android.material.button.MaterialButton) a.a.h(v1_18, 2131362036));
                        if (v12_3 != null) {
                            v2_8 = 2131362037;
                            if (((com.google.android.material.card.MaterialCardView) a.a.h(v1_18, 2131362037)) != null) {
                                v2_8 = 2131362283;
                                uc.d v13_7 = ((android.widget.ProgressBar) a.a.h(v1_18, 2131362283));
                                if (v13_7 != null) {
                                    v2_8 = 2131362295;
                                    androidx.constraintlayout.widget.ConstraintLayout v14_9 = ((androidx.recyclerview.widget.RecyclerView) a.a.h(v1_18, 2131362295));
                                    if (v14_9 != null) {
                                        v9_1 = new uc.p(((androidx.constraintlayout.widget.ConstraintLayout) v1_18), v11_2, v12_3, v13_7, v14_9);
                                        v8_0 = v9_1;
                                        return v8_0;
                                    }
                                }
                            }
                        }
                    }
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v1_18.getResources().getResourceName(v2_8)));
                } else {
                    if (v6_3 == 1) {
                        android.view.View v1_86 = v1_3.getLayoutInflater().inflate(2131558468, 0, 0);
                        android.view.View v5_24 = 2131361948;
                        if (((androidx.constraintlayout.widget.ConstraintLayout) a.a.h(v1_86, 2131361948)) == null) {
                            v2_0 = v5_24;
                        } else {
                            v5_24 = 2131362107;
                            uc.k v11_6 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v1_86, 2131362107));
                            if (v11_6 == null) {
                            } else {
                                v5_24 = 2131362284;
                                androidx.constraintlayout.widget.ConstraintLayout v12_10 = ((android.widget.ProgressBar) a.a.h(v1_86, 2131362284));
                                if (v12_10 == null) {
                                } else {
                                    uc.d v13_14 = ((androidx.recyclerview.widget.RecyclerView) a.a.h(v1_86, 2131362296));
                                    if (v13_14 == null) {
                                        v2_0 = 2131362296;
                                    } else {
                                        androidx.constraintlayout.widget.ConstraintLayout v14_17 = ((com.google.android.material.textfield.TextInputEditText) a.a.h(v1_86, 2131362323));
                                        if (v14_17 != null) {
                                            v2_0 = 2131362353;
                                            android.widget.ProgressBar v15_14 = ((android.widget.LinearLayout) a.a.h(v1_86, 2131362353));
                                            if (v15_14 != null) {
                                                v2_0 = 2131362449;
                                                androidx.appcompat.widget.AppCompatTextView v16_1 = ((com.google.android.material.textview.MaterialTextView) a.a.h(v1_86, 2131362449));
                                                if (v16_1 != null) {
                                                    v9_1 = new uc.q(((androidx.constraintlayout.widget.ConstraintLayout) v1_86), v11_6, v12_10, v13_14, v14_17, v15_14, v16_1);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v1_86.getResources().getResourceName(v2_0)));
                    } else {
                        if (v6_3 != 2) {
                            throw new AssertionError(v6_3);
                        } else {
                            android.view.View v1_8 = v1_3.getLayoutInflater().inflate(2131558469, 0, 0);
                            androidx.constraintlayout.widget.ConstraintLayout v3_2 = ((androidx.recyclerview.widget.RecyclerView) a.a.h(v1_8, 2131362308));
                            if (v3_2 == null) {
                                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v1_8.getResources().getResourceName(2131362308)));
                            } else {
                                v8_0 = new uc.r(((androidx.constraintlayout.widget.ConstraintLayout) v1_8), v3_2);
                            }
                        }
                    }
                }
                return v8_0;
            default:
                android.view.View v1_114;
                int v7_4 = ((qc.j) v7_3);
                android.view.View v1_112 = v7_4.a;
                switch (v6_3) {
                    case 0:
                        android.view.View v1_126 = v1_112.h;
                        v1_114 = v1_126.getSharedPreferences(v1_126.getString(2131951658), 0);
                        v1_114.getClass();
                        break;
                    case 1:
                        v1_114 = new xc.g(((android.net.ConnectivityManager) v7_4.d.get()));
                        break;
                    case 2:
                        android.view.View v1_124 = v1_112.h.getSystemService("connectivity");
                        v1_124.getClass();
                        v1_114 = ((android.net.ConnectivityManager) v1_124);
                        break;
                    case 3:
                        v1_114 = new xc.h(v1_112.h);
                        break;
                    case 4:
                        v1_114 = new tc.b(((tc.e) v7_4.h.get()));
                        break;
                    case 5:
                        android.view.View v1_120 = ((vet.pharmapedia.vetpharmapediapakistan.database.roomDB.MedicinesDBClass) v7_4.g.get());
                        v1_120.getClass();
                        v1_114 = v1_120.b();
                        t6.a.c(v1_114);
                        break;
                    case 6:
                        v1_114 = ((vet.pharmapedia.vetpharmapediapakistan.database.roomDB.MedicinesDBClass) androidx.room.g0.b(v1_112.h, vet.pharmapedia.vetpharmapediapakistan.database.roomDB.MedicinesDBClass, "medicines_DB").b());
                        break;
                    case 7:
                        android.view.View v1_113 = v1_112.h;
                        v1_114 = com.bumptech.glide.c.a(v1_113).k.b(v1_113);
                        v1_114.getClass();
                        break;
                    default:
                        throw new AssertionError(v6_3);
                }
                return v1_114;
        }
    }
}
