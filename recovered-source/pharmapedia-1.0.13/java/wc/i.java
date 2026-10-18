// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package wc;
public final synthetic class i implements ua.l {
    public final synthetic int g;
    public final synthetic wc.l h;

    public synthetic i(wc.l p1, int p2)
    {
        this.g = p2;
        this.h = p1;
        return;
    }

    public final Object invoke(Object p12)
    {
        ga.p v1 = ga.p.a;
        String v2_0 = this.h;
        switch (this.g) {
            case 0:
                ((com.google.firebase.firestore.QuerySnapshot) p12).getClass();
                if (((com.google.firebase.firestore.QuerySnapshot) p12).size() <= 0) {
                    v2_0.n().f.setVisibility(8);
                } else {
                    int v0_2 = v2_0.A;
                    java.util.ArrayList v3 = v2_0.B;
                    v0_2.clear();
                    l.o v12_3 = ((com.google.firebase.firestore.QuerySnapshot) p12).iterator();
                    v12_3.getClass();
                    while (v12_3.hasNext()) {
                        com.denzcoskun.imageslider.ImageSlider v4_8 = ((com.google.firebase.firestore.QueryDocumentSnapshot) v12_3.next()).toObject(vet.pharmapedia.vetpharmapediapakistan.database.models.SlidersModel);
                        v4_8.getClass();
                        v0_2.add(((vet.pharmapedia.vetpharmapediapakistan.database.models.SlidersModel) v4_8));
                    }
                    l.o v12_5 = v2_0.n().f;
                    com.denzcoskun.imageslider.ImageSlider v4_1 = v0_2.size();
                    int v6 = 0;
                    while (v6 < v4_1) {
                        String v7_0 = v0_2.get(v6);
                        v6++;
                        String v7_1 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.SlidersModel) v7_0);
                        if ((v7_1.getCanShow()) && (!db.i.a0(v7_1.getPicLink()))) {
                            String v9 = v7_1.getPicLink();
                            String v7_2 = v7_1.getAnyNote();
                            y3.a v8_4 = new y3.a();
                            v8_4.b = Integer.valueOf(0);
                            v8_4.a = v9;
                            v8_4.c = v7_2;
                            v3.add(v8_4);
                        }
                    }
                    int v0_5 = android.view.LayoutInflater.from(v2_0.h()).inflate(2131558548, v12_5, 0);
                    v0_5.getClass();
                    com.denzcoskun.imageslider.ImageSlider v4_5 = ((com.denzcoskun.imageslider.ImageSlider) v0_5.findViewById(2131362352));
                    v12_5.addView(v0_5);
                    v4_5.a(v3);
                    v4_5.setItemClickListener(new l.o(v2_0, 26));
                }
                return v1;
            default:
                ((java.util.List) p12).getClass();
                if (!((java.util.List) p12).isEmpty()) {
                    v2_0.w = ((java.util.List) p12);
                    v2_0.o(xc.a.d);
                }
                return v1;
        }
    }
}
