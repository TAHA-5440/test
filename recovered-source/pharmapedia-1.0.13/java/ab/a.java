// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ab;
public class a implements java.lang.Iterable, va.a {
    public final int g;
    public final int h;
    public final int i;

    public a(int p2, int p3, int p4)
    {
        if (p4 == 0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Step must be non-zero.");
            throw 0;
        } else {
            if (p4 == -2147483648) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
                throw 0;
            } else {
                this.g = p2;
                this.h = com.bumptech.glide.e.i(p2, p3, p4);
                this.i = p4;
                return;
            }
        }
    }

    public boolean equals(Object p3)
    {
        if ((!(p3 instanceof ab.a)) || (((!this.isEmpty()) || (!((ab.a) p3).isEmpty())) && ((this.g != ((ab.a) p3).g) || ((this.h != ((ab.a) p3).h) || (this.i != ((ab.a) p3).i))))) {
            return 0;
        } else {
            return 1;
        }
    }

    public int hashCode()
    {
        if (!this.isEmpty()) {
            return ((((this.g * 31) + this.h) * 31) + this.i);
        } else {
            return -1;
        }
    }

    public boolean isEmpty()
    {
        int v2 = this.h;
        int v4 = this.g;
        if (this.i <= 0) {
            if (v4 >= v2) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (v4 <= v2) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public final java.util.Iterator iterator()
    {
        return new ab.b(this.g, this.h, this.i);
    }

    public String toString()
    {
        StringBuilder v4_0;
        int v1 = this.h;
        int v2 = this.i;
        String v3_1 = this.g;
        StringBuilder v4_1 = new StringBuilder;
        if (v2 <= 0) {
            v4_0 = v4_1();
            v4_0.append(v3_1);
            v4_0.append(" downTo ");
            v4_0.append(v1);
            v4_0.append(" step ");
            v4_0.append((- v2));
        } else {
            v4_0 = v4_1();
            v4_0.append(v3_1);
            v4_0.append("..");
            v4_0.append(v1);
            v4_0.append(" step ");
            v4_0.append(v2);
        }
        return v4_0.toString();
    }
}
