// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package wc;
public final synthetic class h implements android.animation.ValueAnimator$AnimatorUpdateListener {
    public final synthetic wc.l a;
    public final synthetic lc.a b;

    public synthetic h(wc.l p1, lc.a p2)
    {
        this.a = p1;
        this.b = p2;
        return;
    }

    public final void onAnimationUpdate(android.animation.ValueAnimator p3)
    {
        p3.getClass();
        if (this.a.y != null) {
            String v3_4 = p3.getAnimatedValue();
            v3_4.getClass();
            androidx.appcompat.widget.AppCompatTextView v0_1 = this.b;
            String v3_1 = ((int) ((Float) v3_4).floatValue());
            ((android.widget.ProgressBar) v0_1.c).setProgress(v3_1);
            androidx.appcompat.widget.AppCompatTextView v0_3 = ((androidx.appcompat.widget.AppCompatTextView) v0_1.e);
            StringBuilder v1_3 = new StringBuilder();
            v1_3.append(v3_1);
            v1_3.append("%");
            v0_3.setText(v1_3.toString());
            return;
        } else {
            return;
        }
    }
}
