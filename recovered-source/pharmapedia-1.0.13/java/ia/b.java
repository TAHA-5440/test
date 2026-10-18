// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ia;
public final class b extends f1.c implements java.util.Iterator, va.a {
    public final synthetic int k;

    public b(kotlin.collections.builders.MapBuilder p1, int p2)
    {
        this.k = p2;
        p1.getClass();
        this.j = p1;
        this.h = -1;
        this.i = p1.n;
        this.e();
        return;
    }

    public final Object next()
    {
        switch (this.k) {
            case 0:
                int v2_2;
                this.b();
                int v0_2 = this.g;
                Object[] v1_2 = ((kotlin.collections.builders.MapBuilder) this.j);
                if (v0_2 >= v1_2.l) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.c();
                    v2_2 = 0;
                } else {
                    this.g = (v0_2 + 1);
                    this.h = v0_2;
                    v2_2 = new ia.c(v1_2, v0_2);
                    this.e();
                }
                return v2_2;
            case 1:
                int v0_1;
                this.b();
                int v0_3 = this.g;
                Object[] v1_7 = ((kotlin.collections.builders.MapBuilder) this.j);
                if (v0_3 >= v1_7.l) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.c();
                    v0_1 = 0;
                } else {
                    this.g = (v0_3 + 1);
                    this.h = v0_3;
                    v0_1 = v1_7.g[v0_3];
                    this.e();
                }
                return v0_1;
            default:
                int v0_5;
                this.b();
                int v0_4 = this.g;
                Object[] v1_4 = ((kotlin.collections.builders.MapBuilder) this.j);
                if (v0_4 >= v1_4.l) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.c();
                    v0_5 = 0;
                } else {
                    this.g = (v0_4 + 1);
                    this.h = v0_4;
                    int v0_6 = v1_4.h;
                    v0_6.getClass();
                    v0_5 = v0_6[this.h];
                    this.e();
                }
                return v0_5;
        }
    }
}
