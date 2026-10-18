// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.ui.activities;
public final class ContactActivity extends qc.b {
    public static final synthetic int y;
    public boolean u;
    public uc.c v;
    public rc.d w;
    public final java.util.ArrayList x;

    public ContactActivity()
    {
        this.u = 0;
        this.addOnContextAvailableListener(new vc.p(this, 2));
        this.x = new java.util.ArrayList();
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
            uc.c v0_7 = ((qc.f) ((vc.e) this.a()));
            com.bumptech.glide.q v1_3 = v0_7.b;
            this.p = ((xc.g) v1_3.e.get());
            this.q = ((xc.h) v1_3.f.get());
            this.r = v1_3.a();
            this.s = ((tc.b) v1_3.i.get());
            this.t = ((com.bumptech.glide.q) v1_3.j.get());
            this.v = ((uc.c) v0_7.g.get());
        }
        return;
    }

    public final void onCreate(android.os.Bundle p8)
    {
        super.onCreate(p8);
        androidx.appcompat.widget.AppCompatImageView v8_1 = this.v;
        if (v8_1 == null) {
            kotlin.jvm.internal.f.i("binding");
            throw 0;
        } else {
            this.setContentView(v8_1.a);
            androidx.appcompat.widget.AppCompatImageView v8_6 = this.v;
            if (v8_6 == null) {
                kotlin.jvm.internal.f.i("binding");
                throw 0;
            } else {
                androidx.appcompat.widget.AppCompatImageView v8_2 = v8_6.c;
                java.util.ArrayList v2 = this.x;
                if (v2.isEmpty()) {
                    String v4_1 = this.getString(2131951689);
                    v4_1.getClass();
                    v2.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ContactsModel(v4_1, 2131230860, 1));
                    String v4_3 = this.getString(2131952091);
                    v4_3.getClass();
                    v2.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ContactsModel(v4_3, 2131231291, 1));
                    String v4_5 = this.getString(2131951755);
                    v4_5.getClass();
                    v2.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ContactsModel(v4_5, 2131231164, 1));
                    String v4_7 = this.getString(2131951817);
                    v4_7.getClass();
                    v2.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ContactsModel(v4_7, 2131231125, 1));
                    String v4_9 = this.getString(2131951769);
                    v4_9.getClass();
                    v2.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ContactsModel(v4_9, 2131230899, 1));
                    String v4_11 = this.getString(2131952077);
                    v4_11.getClass();
                    v2.add(new vet.pharmapedia.vetpharmapediapakistan.database.models.ContactsModel(v4_11, 2131231289, 1));
                }
                this.w = new rc.d(this.j());
                v8_2.setLayoutManager(new androidx.recyclerview.widget.GridLayoutManager(this.j(), 3));
                rc.d v3_17 = this.w;
                if (v3_17 == null) {
                    kotlin.jvm.internal.f.i("contactsAdapterSajid");
                    throw 0;
                } else {
                    v8_2.setAdapter(v3_17);
                    androidx.appcompat.widget.AppCompatImageView v8_4 = this.w;
                    if (v8_4 == null) {
                        kotlin.jvm.internal.f.i("contactsAdapterSajid");
                        throw 0;
                    } else {
                        v8_4.l(v2);
                        androidx.appcompat.widget.AppCompatImageView v8_5 = this.v;
                        if (v8_5 == null) {
                            kotlin.jvm.internal.f.i("binding");
                            throw 0;
                        } else {
                            v8_5.b.setOnClickListener(new vc.a(this, 2));
                            return;
                        }
                    }
                }
            }
        }
    }
}
