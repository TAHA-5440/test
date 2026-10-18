// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vc;
public final synthetic class n implements android.view.View$OnClickListener {
    public final synthetic int g;
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.ui.activities.FeedbackActivity h;
    public final synthetic uc.g i;

    public synthetic n(vet.pharmapedia.vetpharmapediapakistan.ui.activities.FeedbackActivity p1, uc.g p2, int p3)
    {
        this.g = p3;
        this.h = p1;
        this.i = p2;
        return;
    }

    public final void onClick(android.view.View p7)
    {
        boolean v3_2 = this.i;
        vet.pharmapedia.vetpharmapediapakistan.ui.activities.FeedbackActivity v4 = this.h;
        switch (this.g) {
            case 0:
                android.net.Uri v7_15 = v3_2.e;
                if (!v4.i().a()) {
                    android.net.Uri v7_9 = v4.j();
                    String v0_6 = v4.getString(2131951989);
                    v0_6.getClass();
                    String v0_7 = android.widget.Toast.makeText(v7_9, v0_6, 0);
                    yc.d.a(v0_7.getView(), new yc.c(v7_9));
                    new yc.d(v7_9, v0_7).show();
                } else {
                    if (db.i.o0(String.valueOf(v7_15.getText())).toString().length() != 0) {
                        vet.pharmapedia.vetpharmapediapakistan.utils.a.d(v4.j(), db.i.o0(String.valueOf(v7_15.getText())).toString(), "Feedback");
                    } else {
                        android.net.Uri v7_14 = v4.j();
                        String v0_14 = v4.getString(2131952094);
                        v0_14.getClass();
                        String v0_15 = android.widget.Toast.makeText(v7_14, v0_14, 0);
                        yc.d.a(v0_15.getView(), new yc.c(v7_14));
                        new yc.d(v7_14, v0_15).show();
                    }
                }
                return;
            default:
                android.net.Uri v7_16 = v3_2.e;
                try {
                    if (!v4.i().a()) {
                        android.net.Uri v7_17 = v4.j();
                        String v0_16 = v4.getString(2131951989);
                        v0_16.getClass();
                        String v0_17 = android.widget.Toast.makeText(v7_17, v0_16, 0);
                        yc.d.a(v0_17.getView(), new yc.c(v7_17));
                        new yc.d(v7_17, v0_17).show();
                    } else {
                        if (db.i.o0(String.valueOf(v7_16.getText())).toString().length() != 0) {
                            android.net.Uri v7_4 = db.i.o0(String.valueOf(v7_16.getText())).toString();
                            String v0_3 = v4.j();
                            v7_4.getClass();
                            android.content.Intent v1_1 = new StringBuilder("https://api.whatsapp.com/send?phone=923006936557&text=From Vet App\n \n");
                            v1_1.append(v7_4);
                            v1_1.append("\n");
                            android.net.Uri v7_6 = v1_1.toString();
                            android.content.Intent v1_3 = new android.content.Intent("android.intent.action.VIEW");
                            v1_3.setData(android.net.Uri.parse(v7_6));
                            v0_3.startActivity(v1_3);
                        } else {
                            android.net.Uri v7_8 = v4.j();
                            String v0_4 = v4.getString(2131952094);
                            v0_4.getClass();
                            String v0_5 = android.widget.Toast.makeText(v7_8, v0_4, 0);
                            yc.d.a(v0_5.getView(), new yc.c(v7_8));
                            new yc.d(v7_8, v0_5).show();
                        }
                    }
                } catch (Exception) {
                }
                return;
        }
    }
}
