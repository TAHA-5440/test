// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ac;
public final synthetic class c implements ua.l {
    public final synthetic int g;
    public final synthetic Object h;

    public synthetic c(Object p1, int p2)
    {
        this.g = p2;
        this.h = p1;
        return;
    }

    public synthetic c(kotlinx.coroutines.sync.a p1, ob.b p2)
    {
        this.g = 5;
        this.h = p1;
        return;
    }

    public final Object invoke(Object p7)
    {
        ga.p v3 = ga.p.a;
        boolean v4_7 = this.h;
        switch (this.g) {
            case 0:
                boolean v4_5 = ((ac.k) v4_7);
                ((java.io.IOException) p7).getClass();
                v4_5.q = 1;
                return v3;
            case 1:
                return com.google.firebase.firestore.pipeline.Expression$Constant.a(((com.google.firebase.firestore.pipeline.Expression$Constant) v4_7), ((com.google.firebase.firestore.model.MutableDocument) p7));
            case 2:
                return ((db.h) v4_7).b(((Integer) p7).intValue());
            case 3:
                boolean v4_2 = ((String) v4_7);
                ((String) p7).getClass();
                if (!db.i.a0(((String) p7))) {
                    v4_2 = v4_2.concat(((String) p7));
                } else {
                    if (((String) p7).length() >= v4_2.length()) {
                        v4_2 = ((String) p7);
                    }
                }
                return v4_2;
            case 4:
                android.widget.ProgressBar v7_3;
                if (p7 != ((ha.a) v4_7)) {
                    v7_3 = String.valueOf(p7);
                } else {
                    v7_3 = "(this Collection)";
                }
                return v7_3;
            case 5:
                ((kotlinx.coroutines.sync.a) v4_7).h(0);
                return v3;
            case 6:
                try {
                    if (((Boolean) p7).booleanValue()) {
                        android.widget.ProgressBar v7_1 = ((rc.i) v4_7).i;
                        if (v7_1 != null) {
                            android.widget.ProgressBar v7_2 = v7_1.i;
                            if (v7_2 != null) {
                                v7_2.h(0);
                            }
                        }
                    }
                } catch (Exception) {
                }
                return v3;
            case 7:
                try {
                    if (((Boolean) p7).booleanValue()) {
                        android.widget.ProgressBar v7_34 = ((rc.p) v4_7).j;
                        if (v7_34 != null) {
                            android.widget.ProgressBar v7_35 = v7_34.i;
                            if (v7_35 != null) {
                                v7_35.h(0);
                            }
                        }
                    }
                } catch (Exception) {
                }
                return v3;
            case 8:
                boolean v4_10 = ((sb.e) v4_7);
                android.widget.ProgressBar v7_28 = ((Integer) p7).intValue();
                java.util.List v0_13 = new StringBuilder();
                v0_13.append(v4_10.e[v7_28]);
                v0_13.append(": ");
                v0_13.append(v4_10.f[v7_28].a());
                return v0_13.toString();
            case 9:
                boolean v4_8 = ((ub.o0) v4_7);
                android.widget.ProgressBar v7_22 = ((Integer) p7).intValue();
                java.util.List v0_11 = new StringBuilder();
                v0_11.append(v4_8.e[v7_22]);
                v0_11.append(": ");
                v0_11.append(v4_8.i(v7_22).a());
                return v0_11.toString();
            case 10:
                boolean v4_9 = ((vet.pharmapedia.vetpharmapediapakistan.ui.activities.AlternativeBrandsActivity) v4_7);
                Class vtmp21 = ((java.util.List) p7).getClass();
                if (!((java.util.List) p7).isEmpty()) {
                    v4_9.z = ((java.util.List) p7);
                    java.util.List v0_4 = v4_9.p();
                    b2.b v1_2 = v4_9.w;
                    if (v1_2 == null) {
                        kotlin.jvm.internal.f.i("saltsAndBrandsAdapter");
                        throw 0;
                    } else {
                        v0_4.f.setAdapter(v1_2);
                        if (xc.a.d) {
                            android.widget.ProgressBar v7_15 = v4_9.w;
                            if (v7_15 == null) {
                                kotlin.jvm.internal.f.i("saltsAndBrandsAdapter");
                                throw 0;
                            } else {
                                v7_15.l(ha.j.R(v4_9.z, new b2.b(11)));
                            }
                        }
                        v4_9.p().f.Z(xc.a.e);
                        xc.a.e = 0;
                        v4_9.p().e.setVisibility(8);
                    }
                }
                return v3;
            default:
                if (((Boolean) p7).booleanValue()) {
                    ((vet.pharmapedia.vetpharmapediapakistan.ui.activities.PrivacyActivity) v4_7).q();
                }
                return v3;
        }
    }
}
