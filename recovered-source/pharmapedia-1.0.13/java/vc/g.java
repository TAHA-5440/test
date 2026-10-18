// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vc;
public final synthetic class g implements android.view.View$OnClickListener {
    public final synthetic int g;
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.ui.activities.ContraindicationsActivity h;
    public final synthetic uc.d i;

    public synthetic g(int p1, uc.d p2, vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel p3, vet.pharmapedia.vetpharmapediapakistan.ui.activities.ContraindicationsActivity p4)
    {
        this.g = p1;
        this.h = p4;
        this.i = p2;
        return;
    }

    public final void onClick(android.view.View p8)
    {
        switch (this.g) {
            case 0:
                android.view.ViewPropertyAnimator v8_22 = this.i;
                android.view.animation.LinearInterpolator v0_8 = v8_22.p;
                android.widget.ProgressBar v1_2 = v8_22.t;
                boolean v2_13 = v8_22.o;
                android.view.ViewPropertyAnimator v8_24 = v8_22.q;
                String v3_6 = this.h;
                android.view.animation.LinearInterpolator v4_7 = v3_6.y;
                v3_6.y = (v4_7 ^ 1);
                if (v4_7 != null) {
                    v2_13.setVisibility(8);
                    v0_8.setVisibility(8);
                    v1_2.setVisibility(8);
                    v8_24.animate().rotationBy(-1028390912).setDuration(300).setInterpolator(new android.view.animation.LinearInterpolator()).start();
                } else {
                    v8_24.animate().rotationBy(1119092736).setDuration(300).setInterpolator(new android.view.animation.LinearInterpolator()).start();
                    v2_13.setVisibility(0);
                    if ((!v3_6.C) && (!kotlin.jvm.internal.f.a(v3_6.l().A(), "en"))) {
                        v1_2.setVisibility(0);
                    }
                    v0_8.setVisibility(0);
                }
                return;
            case 1:
                android.view.ViewPropertyAnimator v8_13 = this.i;
                android.view.animation.LinearInterpolator v0_7 = v8_13.j;
                android.widget.ProgressBar v1_1 = v8_13.s;
                boolean v2_11 = v8_13.k;
                android.view.ViewPropertyAnimator v8_23 = v8_13.l;
                String v3_8 = this.h;
                android.view.animation.LinearInterpolator v4_8 = v3_8.z;
                v3_8.z = (v4_8 ^ 1);
                if (v4_8 != null) {
                    v2_11.setVisibility(8);
                    v1_1.setVisibility(8);
                    v0_7.setVisibility(8);
                    v8_23.animate().rotationBy(-1028390912).setDuration(300).setInterpolator(new android.view.animation.LinearInterpolator()).start();
                } else {
                    v8_23.animate().rotationBy(1119092736).setDuration(300).setInterpolator(new android.view.animation.LinearInterpolator()).start();
                    v2_11.setVisibility(0);
                    if ((!v3_8.D) && (!kotlin.jvm.internal.f.a(v3_8.l().A(), "en"))) {
                        v1_1.setVisibility(0);
                    }
                    v0_7.setVisibility(0);
                }
                return;
            default:
                android.view.ViewPropertyAnimator v8_1 = this.i;
                android.view.animation.LinearInterpolator v0_0 = v8_1.c;
                android.widget.ProgressBar v1_0 = v8_1.r;
                boolean v2_3 = v8_1.d;
                android.view.ViewPropertyAnimator v8_2 = v8_1.e;
                String v3_1 = this.h;
                android.view.animation.LinearInterpolator v4_0 = v3_1.A;
                v3_1.A = (v4_0 ^ 1);
                if (v4_0 != null) {
                    v2_3.setVisibility(8);
                    v0_0.setVisibility(8);
                    v1_0.setVisibility(8);
                    v8_2.animate().rotationBy(-1028390912).setDuration(300).setInterpolator(new android.view.animation.LinearInterpolator()).start();
                } else {
                    v8_2.animate().rotationBy(1119092736).setDuration(300).setInterpolator(new android.view.animation.LinearInterpolator()).start();
                    v2_3.setVisibility(0);
                    if ((!v3_1.E) && (!kotlin.jvm.internal.f.a(v3_1.l().A(), "en"))) {
                        v1_0.setVisibility(0);
                    }
                    v0_0.setVisibility(0);
                }
                return;
        }
    }
}
