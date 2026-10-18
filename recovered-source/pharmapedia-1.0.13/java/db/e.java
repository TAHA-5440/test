// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package db;
public final class e implements java.util.Iterator, va.a {
    public final String g;
    public int h;
    public int i;
    public int j;
    public int k;

    public e(String p1)
    {
        this.g = p1;
        return;
    }

    public final boolean hasNext()
    {
        char v0_0 = this.h;
        if (v0_0 == 0) {
            int v3 = 2;
            if (this.k >= 0) {
                char v0_3 = this.g;
                int v1_2 = v0_3.length();
                int v4 = this.i;
                int v5_0 = v0_3.length();
                while (v4 < v5_0) {
                    char v6 = v0_3.charAt(v4);
                    if ((v6 == 10) || (v6 == 13)) {
                        if (v6 != 13) {
                            v3 = 1;
                        } else {
                            int v1_1 = (v4 + 1);
                            if ((v1_1 >= v0_3.length()) || (v0_3.charAt(v1_1) != 10)) {
                            }
                        }
                        v1_2 = v4;
                    } else {
                        v4++;
                    }
                    this.h = 1;
                    this.k = v3;
                    this.j = v1_2;
                    return 1;
                }
                v3 = -1;
                this.h = 1;
                this.k = v3;
                this.j = v1_2;
                return 1;
            } else {
                this.h = 2;
                return 0;
            }
        } else {
            if (v0_0 != 1) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public final Object next()
    {
        if (!this.hasNext()) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.c();
            return 0;
        } else {
            this.h = 0;
            int v0_5 = this.j;
            int v1 = this.i;
            this.i = (this.k + v0_5);
            return this.g.subSequence(v1, v0_5).toString();
        }
    }

    public final void remove()
    {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
