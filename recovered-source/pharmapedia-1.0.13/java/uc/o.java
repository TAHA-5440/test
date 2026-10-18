// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package uc;
public final class o {
    public final androidx.constraintlayout.widget.ConstraintLayout a;
    public final androidx.appcompat.widget.AppCompatImageView b;
    public final androidx.appcompat.widget.AppCompatTextView c;

    public synthetic o(androidx.constraintlayout.widget.ConstraintLayout p1, androidx.appcompat.widget.AppCompatImageView p2, androidx.appcompat.widget.AppCompatTextView p3)
    {
        this.a = p1;
        this.b = p2;
        this.c = p3;
        return;
    }

    public static uc.o a(android.view.LayoutInflater p2, android.view.ViewGroup p3)
    {
        androidx.constraintlayout.widget.ConstraintLayout v2_5 = p2.inflate(2131558444, p3, 0);
        uc.o v3_1 = 2131361871;
        androidx.appcompat.widget.AppCompatImageView v0_2 = ((androidx.appcompat.widget.AppCompatImageView) a.a.h(v2_5, 2131361871));
        if (v0_2 != null) {
            v3_1 = 2131362273;
            if (((android.widget.ProgressBar) a.a.h(v2_5, 2131362273)) != null) {
                v3_1 = 2131362312;
                androidx.appcompat.widget.AppCompatTextView v1_4 = ((androidx.appcompat.widget.AppCompatTextView) a.a.h(v2_5, 2131362312));
                if (v1_4 != null) {
                    return new uc.o(((androidx.constraintlayout.widget.ConstraintLayout) v2_5), v0_2, v1_4);
                }
            }
        }
        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.j("Missing required view with ID: ".concat(v2_5.getResources().getResourceName(v3_1)));
        return 0;
    }
}
