// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package cc;
public final class w {
    public final cc.x a;
    public final cc.x b;
    public final Throwable c;

    public w(cc.x p1, cc.e p2, Throwable p3)
    {
        this.a = p1;
        this.b = p2;
        this.c = p3;
        return;
    }

    public synthetic w(cc.x p2, Throwable p3, int p4)
    {
        if ((p4 & 4) != 0) {
            p3 = 0;
        }
        this(p2, 0, p3);
        return;
    }

    public final boolean equals(Object p5)
    {
        if (this != p5) {
            if ((p5 instanceof cc.w)) {
                if (kotlin.jvm.internal.f.a(this.a, ((cc.w) p5).a)) {
                    if (kotlin.jvm.internal.f.a(this.b, ((cc.w) p5).b)) {
                        if (kotlin.jvm.internal.f.a(this.c, ((cc.w) p5).c)) {
                            return 1;
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }

    public final int hashCode()
    {
        Throwable v2_2;
        int v0_5 = (this.a.hashCode() * 31);
        int v1 = 0;
        Throwable v2_1 = this.b;
        if (v2_1 != null) {
            v2_2 = v2_1.hashCode();
        } else {
            v2_2 = 0;
        }
        int v0_2 = ((v0_5 + v2_2) * 31);
        Throwable v2_0 = this.c;
        if (v2_0 != null) {
            v1 = v2_0.hashCode();
        }
        return (v0_2 + v1);
    }

    public final String toString()
    {
        String v0_2 = new StringBuilder("ConnectResult(plan=");
        v0_2.append(this.a);
        v0_2.append(", nextPlan=");
        v0_2.append(this.b);
        v0_2.append(", throwable=");
        v0_2.append(this.c);
        v0_2.append(41);
        return v0_2.toString();
    }
}
