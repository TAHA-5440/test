// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yc;
public final class b implements android.view.WindowManager {
    public final android.view.WindowManager g;

    public b(yc.c p1, android.view.WindowManager p2)
    {
        this.g = p2;
        return;
    }

    public final void addView(android.view.View p2, android.view.ViewGroup$LayoutParams p3)
    {
        p2.getClass();
        p3.getClass();
        try {
            this.g.addView(p2, p3);
            return;
        } catch (Throwable) {
            return;
        }
    }

    public final android.view.Display getDefaultDisplay()
    {
        android.view.Display v0_1 = this.g.getDefaultDisplay();
        v0_1.getClass();
        return v0_1;
    }

    public final void removeView(android.view.View p2)
    {
        p2.getClass();
        this.g.removeView(p2);
        return;
    }

    public final void removeViewImmediate(android.view.View p2)
    {
        p2.getClass();
        this.g.removeViewImmediate(p2);
        return;
    }

    public final void updateViewLayout(android.view.View p2, android.view.ViewGroup$LayoutParams p3)
    {
        p2.getClass();
        p3.getClass();
        this.g.updateViewLayout(p2, p3);
        return;
    }
}
