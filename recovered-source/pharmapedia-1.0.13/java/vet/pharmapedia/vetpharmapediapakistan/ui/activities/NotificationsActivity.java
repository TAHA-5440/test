// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.ui.activities;
public final class NotificationsActivity extends qc.b {
    public String A;
    public boolean u;
    public uc.k v;
    public String w;
    public String x;
    public String y;
    public String z;

    public NotificationsActivity()
    {
        this.u = 0;
        this.addOnContextAvailableListener(new vc.p(this, 10));
        return;
    }

    public final void m()
    {
        this.finish();
        return;
    }

    public final void n()
    {
        if (!this.u) {
            this.u = 1;
            uc.k v0_7 = ((qc.f) ((vc.z) this.a()));
            com.bumptech.glide.q v1_3 = v0_7.b;
            this.p = ((xc.g) v1_3.e.get());
            this.q = ((xc.h) v1_3.f.get());
            this.r = v1_3.a();
            this.s = ((tc.b) v1_3.i.get());
            this.t = ((com.bumptech.glide.q) v1_3.j.get());
            this.v = ((uc.k) v0_7.o.get());
        }
        return;
    }

    public final void onCreate(android.os.Bundle p8)
    {
        super.onCreate(p8);
        vc.a v8_1 = this.v;
        if (v8_1 == null) {
            kotlin.jvm.internal.f.i("binding");
            throw 0;
        } else {
            this.setContentView(v8_1.a);
            try {
                vc.a v8_2 = this.getIntent();
            } catch (Exception) {
                this.startActivity(new android.content.Intent(this.j(), vet.pharmapedia.vetpharmapediapakistan.ui.activities.MainActivity));
                this.finish();
                return;
            }
            if (v8_2 != null) {
                vc.a v8_3 = v8_2.getExtras();
                if (v8_3 != null) {
                    this.w = v8_3.getString("image_url");
                    this.x = v8_3.getString("message");
                    this.y = v8_3.getString("title");
                    this.z = v8_3.getString("actionUrl");
                    this.A = v8_3.getString("actionText");
                }
            }
            vc.a v8_5 = this.v;
            if (v8_5 == null) {
                kotlin.jvm.internal.f.i("binding");
                throw 0;
            } else {
                com.google.android.material.button.MaterialButton v0_1 = v8_5.b;
                if (this.w != null) {
                    v8_5.d.setVisibility(0);
                    androidx.appcompat.widget.AppCompatTextView v2_11 = this.t;
                    if (v2_11 == null) {
                        kotlin.jvm.internal.f.i("glide");
                        throw 0;
                    } else {
                        int v1_3 = new com.bumptech.glide.o(v2_11.g, v2_11, android.graphics.drawable.Drawable, v2_11.h).B(this.w).A(new vc.y(v8_5, 0));
                        v1_3.getClass();
                        ((com.bumptech.glide.o) v1_3.k(f3.m.b, new f3.t(), 1)).y(v8_5.c);
                    }
                }
                int v1_6 = this.x;
                if (v1_6 != 0) {
                    v8_5.e.setText(v1_6);
                }
                int v1_7 = this.y;
                if (v1_7 != 0) {
                    v8_5.f.setText(v1_7);
                }
                vc.a v8_9 = this.A;
                if (v8_9 != null) {
                    v0_1.setText(v8_9);
                }
                v0_1.setOnClickListener(new vc.a(this, 8));
                return;
            }
        }
    }
}
