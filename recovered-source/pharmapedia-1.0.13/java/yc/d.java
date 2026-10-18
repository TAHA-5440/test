// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yc;
public final class d extends android.widget.Toast {
    public static final synthetic int b;
    public final android.widget.Toast a;

    public d(android.content.Context p1, android.widget.Toast p2)
    {
        super(p1);
        super.a = p2;
        return;
    }

    public static void a(android.view.View p2, yc.c p3)
    {
        try {
            if (android.os.Build$VERSION.SDK_INT == 25) {
                reflect.Field v0_2 = android.view.View.getDeclaredField("mContext");
                v0_2.setAccessible(1);
                v0_2.set(p2, p3);
            }
        } catch (Throwable) {
        }
        return;
    }

    public final int getDuration()
    {
        return this.a.getDuration();
    }

    public final int getGravity()
    {
        return this.a.getGravity();
    }

    public final float getHorizontalMargin()
    {
        return this.a.getHorizontalMargin();
    }

    public final float getVerticalMargin()
    {
        return this.a.getVerticalMargin();
    }

    public final android.view.View getView()
    {
        return this.a.getView();
    }

    public final int getXOffset()
    {
        return this.a.getXOffset();
    }

    public final int getYOffset()
    {
        return this.a.getYOffset();
    }

    public final void setDuration(int p2)
    {
        this.a.setDuration(p2);
        return;
    }

    public final void setGravity(int p2, int p3, int p4)
    {
        this.a.setGravity(p2, p3, p4);
        return;
    }

    public final void setMargin(float p2, float p3)
    {
        this.a.setMargin(p2, p3);
        return;
    }

    public final void setText(int p2)
    {
        this.a.setText(p2);
        return;
    }

    public final void setText(CharSequence p2)
    {
        this.a.setText(p2);
        return;
    }

    public final void setView(android.view.View p3)
    {
        this.a.setView(p3);
        android.content.Context v1 = p3.getContext();
        v1.getClass();
        yc.d.a(p3, new yc.c(v1));
        return;
    }

    public final void show()
    {
        this.a.show();
        return;
    }
}
