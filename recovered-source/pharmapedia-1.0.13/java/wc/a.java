// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package wc;
public final synthetic class a implements android.view.View$OnClickListener {
    public final synthetic int g;
    public final synthetic wc.c h;

    public synthetic a(wc.c p1, int p2)
    {
        this.g = p2;
        this.h = p1;
        return;
    }

    public final void onClick(android.view.View p7)
    {
        String v0_0 = this.h;
        switch (this.g) {
            case 0:
                v0_0.n();
                return;
            default:
                String v7_5 = v0_0.o();
                String v1_4 = v7_5.b;
                String v7_6 = v7_5.c;
                try {
                    v0_0.y = 1;
                    int v3_0 = v0_0.h();
                    int v4_1 = new android.util.TypedValue();
                    v3_0.getTheme().resolveAttribute(2130969682, v4_1, 1);
                    v7_6.setBackgroundTintList(android.content.res.ColorStateList.valueOf(v4_1.data));
                    v1_4.setBackgroundTintList(android.content.res.ColorStateList.valueOf(v0_0.h().getColor(2131100670)));
                    v1_4.setTextColor(v0_0.h().getColor(2131099683));
                    v7_6.setTextColor(v0_0.h().getColor(2131100670));
                    v0_0.v = new rc.l(v0_0.h(), 0, v0_0.i());
                    v0_0.q(0);
                } catch (String v7_3) {
                    r1.a.A("saltsButtonSelected: ", v7_3.getMessage(), "favoriteFragment");
                }
                return;
        }
    }
}
