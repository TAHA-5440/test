// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package rc;
public final synthetic class h implements androidx.lifecycle.k0, kotlin.jvm.internal.d {
    public final synthetic int g;
    public final synthetic ua.l h;

    public synthetic h(ua.l p1, int p2)
    {
        this.g = p2;
        this.h = p1;
        return;
    }

    public final boolean equals(Object p2)
    {
        switch (this.g) {
            case 0:
                if ((!(p2 instanceof androidx.lifecycle.k0)) || (!(p2 instanceof kotlin.jvm.internal.d))) {
                    boolean v2_15 = 0;
                } else {
                    v2_15 = ((ac.c) this.h).equals(((kotlin.jvm.internal.d) p2).getFunctionDelegate());
                }
                return v2_15;
            case 1:
                if ((!(p2 instanceof androidx.lifecycle.k0)) || (!(p2 instanceof kotlin.jvm.internal.d))) {
                    boolean v2_11 = 0;
                } else {
                    v2_11 = ((ac.c) this.h).equals(((kotlin.jvm.internal.d) p2).getFunctionDelegate());
                }
                return v2_11;
            case 2:
                if ((!(p2 instanceof androidx.lifecycle.k0)) || (!(p2 instanceof kotlin.jvm.internal.d))) {
                    boolean v2_8 = 0;
                } else {
                    v2_8 = ((androidx.room.w0) this.h).equals(((kotlin.jvm.internal.d) p2).getFunctionDelegate());
                }
                return v2_8;
            case 3:
                if ((!(p2 instanceof androidx.lifecycle.k0)) || (!(p2 instanceof kotlin.jvm.internal.d))) {
                    boolean v2_5 = 0;
                } else {
                    v2_5 = ((ac.c) this.h).equals(((kotlin.jvm.internal.d) p2).getFunctionDelegate());
                }
                return v2_5;
            case 4:
                if ((!(p2 instanceof androidx.lifecycle.k0)) || (!(p2 instanceof kotlin.jvm.internal.d))) {
                    boolean v2_2 = 0;
                } else {
                    v2_2 = ((ac.c) this.h).equals(((kotlin.jvm.internal.d) p2).getFunctionDelegate());
                }
                return v2_2;
            case 5:
                if ((!(p2 instanceof androidx.lifecycle.k0)) || (!(p2 instanceof kotlin.jvm.internal.d))) {
                    boolean v2_1 = 0;
                } else {
                    v2_1 = this.h.equals(((kotlin.jvm.internal.d) p2).getFunctionDelegate());
                }
                return v2_1;
            default:
                boolean v2_18;
                if (!(p2 instanceof androidx.lifecycle.k0)) {
                    v2_18 = 0;
                    return v2_18;
                } else {
                    if (!(p2 instanceof kotlin.jvm.internal.d)) {
                    } else {
                        v2_18 = ((wc.i) this.h).equals(((kotlin.jvm.internal.d) p2).getFunctionDelegate());
                        return v2_18;
                    }
                }
        }
    }

    public final ga.c getFunctionDelegate()
    {
        switch (this.g) {
            case 0:
                return ((ac.c) this.h);
            case 1:
                return ((ac.c) this.h);
            case 2:
                return ((androidx.room.w0) this.h);
            case 3:
                return ((ac.c) this.h);
            case 4:
                return ((ac.c) this.h);
            case 5:
                return this.h;
            default:
                return ((wc.i) this.h);
        }
    }

    public final int hashCode()
    {
        switch (this.g) {
            case 0:
                return ((ac.c) this.h).hashCode();
            case 1:
                return ((ac.c) this.h).hashCode();
            case 2:
                return ((androidx.room.w0) this.h).hashCode();
            case 3:
                return ((ac.c) this.h).hashCode();
            case 4:
                return ((ac.c) this.h).hashCode();
            case 5:
                return this.h.hashCode();
            default:
                return ((wc.i) this.h).hashCode();
        }
    }

    public final synthetic void onChanged(Object p2)
    {
        switch (this.g) {
            case 0:
                ((ac.c) this.h).invoke(p2);
                return;
            case 1:
                ((ac.c) this.h).invoke(p2);
                return;
            case 2:
                ((androidx.room.w0) this.h).invoke(p2);
                return;
            case 3:
                ((ac.c) this.h).invoke(p2);
                return;
            case 4:
                ((ac.c) this.h).invoke(p2);
                return;
            case 5:
                this.h.invoke(p2);
                return;
            default:
                ((wc.i) this.h).invoke(p2);
                return;
        }
    }
}
