// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package rc;
public final synthetic class e implements android.view.View$OnClickListener {
    public final synthetic int g;
    public final synthetic p5.k h;
    public final synthetic w1.e0 i;
    public final synthetic Object j;
    public final synthetic java.io.Serializable k;

    public synthetic e(p5.k p1, w1.e0 p2, Object p3, java.io.Serializable p4, int p5)
    {
        this.g = p5;
        this.h = p1;
        this.i = p2;
        this.j = p3;
        this.k = p4;
        return;
    }

    public final void onClick(android.view.View p5)
    {
        switch (this.g) {
            case 0:
                w1.l0 v5_6 = ((rc.i) this.i);
                lc.a v0_3 = ((lc.a) this.j);
                vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel v1_3 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel) this.k);
                this.h.a(3);
                v5_6.m(v0_3, v1_3);
                v5_6.a.b();
                return;
            default:
                w1.l0 v5_3 = ((rc.p) this.i);
                lc.a v0_1 = ((lc.a) this.j);
                vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel v1_1 = ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsModel) this.k);
                this.h.a(3);
                v5_3.m(v0_1, v1_1);
                v5_3.a.b();
                return;
        }
    }
}
