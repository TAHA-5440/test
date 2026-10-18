// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ga;
public class g implements java.util.Iterator, va.a {
    public final synthetic int g;
    public int h;
    public final Object i;

    public synthetic g(Object p1, int p2)
    {
        this.g = p2;
        this.i = p1;
        return;
    }

    public g(Object[] p2)
    {
        this.g = 5;
        p2.getClass();
        this.i = p2;
        return;
    }

    public final boolean hasNext()
    {
        switch (this.g) {
            case 0:
                int v0_9;
                if (this.h >= ((byte[]) this.i).length) {
                    v0_9 = 0;
                } else {
                    v0_9 = 1;
                }
                return v0_9;
            case 1:
                int v0_7;
                if (this.h >= ((int[]) this.i).length) {
                    v0_7 = 0;
                } else {
                    v0_7 = 1;
                }
                return v0_7;
            case 2:
                int v0_5;
                if (this.h >= ((long[]) this.i).length) {
                    v0_5 = 0;
                } else {
                    v0_5 = 1;
                }
                return v0_5;
            case 3:
                int v0_2;
                if (this.h >= ((short[]) this.i).length) {
                    v0_2 = 0;
                } else {
                    v0_2 = 1;
                }
                return v0_2;
            case 4:
                int v0_12;
                if (this.h >= ((ha.d) this.i).a()) {
                    v0_12 = 0;
                } else {
                    v0_12 = 1;
                }
                return v0_12;
            default:
                int v0_11;
                if (this.h >= ((Object[]) this.i).length) {
                    v0_11 = 0;
                } else {
                    v0_11 = 1;
                }
                return v0_11;
        }
    }

    public final Object next()
    {
        switch (this.g) {
            case 0:
                int v0_12 = this.h;
                int v1_17 = ((byte[]) this.i);
                if (v0_12 >= v1_17.length) {
                    throw new java.util.NoSuchElementException(String.valueOf(v0_12));
                } else {
                    this.h = (v0_12 + 1);
                    return new ga.f(v1_17[v0_12]);
                }
            case 1:
                int v0_9 = this.h;
                int v1_11 = ((int[]) this.i);
                if (v0_9 >= v1_11.length) {
                    throw new java.util.NoSuchElementException(String.valueOf(v0_9));
                } else {
                    this.h = (v0_9 + 1);
                    return new ga.i(v1_11[v0_9]);
                }
            case 2:
                int v0_6 = this.h;
                int v1_7 = ((long[]) this.i);
                if (v0_6 >= v1_7.length) {
                    throw new java.util.NoSuchElementException(String.valueOf(v0_6));
                } else {
                    this.h = (v0_6 + 1);
                    return new ga.k(v1_7[v0_6]);
                }
            case 3:
                int v0_2 = this.h;
                int v1_1 = ((short[]) this.i);
                if (v0_2 >= v1_1.length) {
                    throw new java.util.NoSuchElementException(String.valueOf(v0_2));
                } else {
                    this.h = (v0_2 + 1);
                    return new ga.n(v1_1[v0_2]);
                }
            case 4:
                int v0_1;
                if (!this.hasNext()) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.c();
                    v0_1 = 0;
                } else {
                    int v0_17 = ((ha.d) this.i);
                    int v1_25 = this.h;
                    this.h = (v1_25 + 1);
                    v0_1 = v0_17.get(v1_25);
                }
                return v0_1;
            default:
                int v0_18 = ((Object[]) this.i);
                int v1_22 = this.h;
                this.h = (v1_22 + 1);
                return v0_18[v1_22];
        }
    }

    public final void remove()
    {
        switch (this.g) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                break;
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                break;
            case 2:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                break;
            case 3:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                break;
            case 4:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                break;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }
}
