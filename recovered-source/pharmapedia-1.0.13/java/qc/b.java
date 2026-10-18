// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package qc;
public abstract class b extends i.i implements c7.c {
    public volatile a7.b m;
    public final Object n;
    public qc.b o;
    public xc.g p;
    public xc.h q;
    public l.o r;
    public tc.b s;
    public com.bumptech.glide.q t;

    public b()
    {
        this.getSavedStateRegistry().c("androidx:appcompat", new c2.a(this));
        this.addOnContextAvailableListener(new i.h(this, 0));
        this.n = new Object();
        this.addOnContextAvailableListener(new i.h(this, 1));
        return;
    }

    public static void g(qc.b p3, int p4)
    {
        java.util.WeakHashMap v0_1;
        int v1_0 = 1;
        if ((p4 & 1) == 0) {
            v0_1 = 1;
        } else {
            v0_1 = 0;
        }
        if ((p4 & 4) == 0) {
            v1_0 = 0;
        }
        android.view.View v4_3 = ((android.view.ViewGroup) p3.findViewById(16908290)).getChildAt(0);
        if (v4_3 != null) {
            if (v1_0 == 0) {
                v4_3.setBackground(0);
            } else {
                v4_3.setBackground(p3.j().getDrawable(2131231287));
            }
            q0.f0.j(v4_3, new qc.a(v0_1));
            q0.d0.c(v4_3);
            return;
        } else {
            return;
        }
    }

    public final Object a()
    {
        return this.h().a();
    }

    public final void attachBaseContext(android.content.Context p1)
    {
        if (p1 != null) {
            super.attachBaseContext(jc.g.r(p1));
            return;
        } else {
            super.attachBaseContext(p1);
            return;
        }
    }

    public final androidx.lifecycle.f1 getDefaultViewModelProviderFactory()
    {
        androidx.lifecycle.f1 v0 = super.getDefaultViewModelProviderFactory();
        ((qc.f) ((z6.a) com.bumptech.glide.h.i(this, z6.a))).getClass();
        com.google.common.collect.ImmutableMap v1_4 = com.google.common.collect.ImmutableMap.c();
        pc.h v2_1 = new pc.h(1);
        v0.getClass();
        return new z6.e(v1_4, v0, v2_1);
    }

    public final a7.b h()
    {
        if (this.m == null) {
            if (this.m == null) {
                this.m = new a7.b(this);
            }
        }
        return this.m;
    }

    public final xc.g i()
    {
        int v0_0 = this.p;
        if (v0_0 == 0) {
            kotlin.jvm.internal.f.i("internetController");
            throw 0;
        } else {
            return v0_0;
        }
    }

    public final android.app.Activity j()
    {
        int v0_0 = this.o;
        if (v0_0 == 0) {
            kotlin.jvm.internal.f.i("mContext");
            throw 0;
        } else {
            return v0_0;
        }
    }

    public final tc.b k()
    {
        int v0_0 = this.s;
        if (v0_0 == 0) {
            kotlin.jvm.internal.f.i("medicinesDBRepository");
            throw 0;
        } else {
            return v0_0;
        }
    }

    public final l.o l()
    {
        int v0_0 = this.r;
        if (v0_0 == 0) {
            kotlin.jvm.internal.f.i("mySharedPreference");
            throw 0;
        } else {
            return v0_0;
        }
    }

    public abstract void m();

    public abstract void n();

    public final void o(android.os.Bundle p5)
    {
        super.onCreate(p5);
        n1.b v5_1 = this.h();
        a7.j v0_3 = v5_1.j;
        boolean v1_5 = v0_3.g;
        Object[] v2_4 = new a7.c(v0_3.h, 0);
        a7.j v0_0 = v1_5.getViewModelStore();
        boolean v1_0 = v1_5.getDefaultViewModelCreationExtras();
        v0_0.getClass();
        v1_0.getClass();
        String v3_1 = new c0.g(v0_0, v2_4, v1_0);
        a7.j v0_2 = kotlin.jvm.internal.h.a(a7.e);
        boolean v1_1 = v0_2.b();
        if (!v1_1) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Local and anonymous classes can not be ViewModels");
            return;
        } else {
            a7.j v0_6 = ((a7.e) v3_1.h(v0_2, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(v1_1))).b;
            v5_1.k = v0_6;
            if (((n1.b) v0_6.h) == null) {
                n1.b v5_4 = v5_1.i.getDefaultViewModelCreationExtras();
                Object[] v2_2 = new Object[0];
                com.bumptech.glide.j.C(v0_6.g, "setExtras should only be called for an Activity that extends ComponentActivity", v2_2);
                v0_6.h = v5_4;
            }
            return;
        }
    }

    public void onCreate(android.os.Bundle p3)
    {
        q0.p1 v0_5;
        this.setTheme(vet.pharmapedia.vetpharmapediapakistan.utils.a.c(this).a);
        this.getWindow().getDecorView();
        androidx.activity.s.a(this, androidx.activity.h0.a());
        this.o(p3);
        this.o = this;
        androidx.activity.f0 v3_1 = this.getWindow();
        this.getWindow().getDecorView();
        q0.p1 v0_2 = android.os.Build$VERSION.SDK_INT;
        if (v0_2 < 35) {
            if (v0_2 < 30) {
                if (v0_2 < 26) {
                    v0_5 = new q0.p1(v3_1);
                } else {
                    v0_5 = new q0.q1(v3_1);
                }
            } else {
                v0_5 = new q0.r1(v3_1);
            }
        } else {
            v0_5 = new q0.s1(v3_1);
        }
        v0_5.r(1);
        this.getOnBackPressedDispatcher().a(this, new androidx.fragment.app.y0(this));
        return;
    }

    public void onDestroy()
    {
        super.onDestroy();
        a7.j v0_1 = this.h().k;
        if (v0_1 != null) {
            v0_1.h = 0;
        }
        return;
    }

    public void setContentView(android.view.View p1)
    {
        super.setContentView(p1);
        qc.b.g(this, 7);
        return;
    }
}
