// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gc;
public final class a {
    public static gc.a e;
    public final synthetic int a;
    public long b;
    public long c;
    public int d;

    public synthetic a()
    {
        this.a = 1;
        return;
    }

    public a(int p2)
    {
        this.a = 0;
        this.d = p2;
        return;
    }

    public static void c(gc.a p3, long p4, long p6, int p8)
    {
        if ((p8 & 1) != 0) {
            p4 = 0;
        }
        if ((p8 & 2) != 0) {
            p6 = 0;
        }
        if (p4 < 0) {
            throw new IllegalStateException("Check failed.");
        } else {
            if (p6 < 0) {
                throw new IllegalStateException("Check failed.");
            } else {
                long v0_2 = (p3.b + p4);
                p3.b = v0_2;
                IllegalStateException v4_5 = (p3.c + p6);
                p3.c = v4_5;
                if (v4_5 > v0_2) {
                    throw new IllegalStateException("Check failed.");
                } else {
                    return;
                }
            }
        }
    }

    public void a(double p15, double p17, long p19)
    {
        long v2_6 = (((float) (p19 - 946728000000)) / 1285868416);
        int v3_5 = ((1015868197 * v2_6) + 1086828178);
        float v4_10 = ((double) v3_5);
        long v8_13 = ((((Math.sin(((double) (v3_5 * 1077936128))) * 4527795603731644416) + ((Math.sin(((double) (1073741824 * v3_5))) * 4555074754578481152) + ((Math.sin(v4_10) * 4584977093208571904) + v4_10))) + 4610769955021710130) + 4614256656552045848);
        double v6_12 = ((- p17) / 4645040803167600640);
        long v2_16 = ((Math.sin((4611686018427387904 * v8_13)) * -4648766856319305620) + ((Math.sin(v4_10) * 4572760506128099233) + (((double) (((float) Math.round((((double) (v2_6 - 980151802)) - v6_12))) + 980151802)) + v6_12)));
        float v4_4 = Math.asin((Math.sin(4601044547609296896) * Math.sin(v8_13)));
        double v6_19 = (4580687790437564416 * p15);
        long v8_17 = ((Math.sin(-4631161762379464704) - (Math.sin(v4_4) * Math.sin(v6_19))) / (Math.cos(v4_4) * Math.cos(v6_19)));
        if (v8_17 < 4607182418800017408) {
            if (v8_17 > -4616189618054758400) {
                double v6_1 = ((double) ((float) (Math.acos(v8_17) / 4618760256179416344)));
                this.b = (Math.round(((v2_16 + v6_1) * 4725570615333879808)) + 946728000000);
                long v2_4 = (Math.round(((v2_16 - v6_1) * 4725570615333879808)) + 946728000000);
                this.c = v2_4;
                if ((v2_4 >= p19) || (this.b <= p19)) {
                    this.d = 1;
                    return;
                } else {
                    this.d = 0;
                    return;
                }
            } else {
                this.d = 0;
                this.b = -1;
                this.c = -1;
                return;
            }
        } else {
            this.d = 1;
            this.b = -1;
            this.c = -1;
            return;
        }
    }

    public declared_synchronized long b()
    {
        return (this.b - this.c);
    }

    public String toString()
    {
        switch (this.a) {
            case 0:
                String v0_4 = new StringBuilder("WindowCounter(streamId=");
                v0_4.append(this.d);
                v0_4.append(", total=");
                v0_4.append(this.b);
                v0_4.append(", acknowledged=");
                v0_4.append(this.c);
                v0_4.append(", unacknowledged=");
                v0_4.append(this.b());
                v0_4.append(41);
                return v0_4.toString();
            default:
                return super.toString();
        }
    }
}
