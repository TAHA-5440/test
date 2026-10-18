// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public final class h extends java.io.InputStream {
    public final synthetic int g;
    public final synthetic oc.k h;

    public synthetic h(oc.k p1, int p2)
    {
        this.g = p2;
        this.h = p1;
        return;
    }

    private final void d()
    {
        return;
    }

    public final int available()
    {
        switch (this.g) {
            case 0:
                return ((int) Math.min(((oc.i) this.h).h, ((long) 2147483647)));
            default:
                int v0_4;
                int v0_2 = ((oc.y) this.h);
                if (v0_2.i) {
                    oc.l.g("closed");
                    v0_4 = 0;
                } else {
                    v0_4 = ((int) Math.min(v0_2.h.h, ((long) 2147483647)));
                }
                return v0_4;
        }
    }

    public final void close()
    {
        switch (this.g) {
            case 0:
                break;
            default:
                ((oc.y) this.h).close();
        }
        return;
    }

    public final int read()
    {
        switch (this.g) {
            case 0:
                int v0_2;
                int v0_9 = ((oc.i) this.h);
                if (v0_9.h <= 0) {
                    v0_2 = -1;
                } else {
                    v0_2 = (v0_9.readByte() & 255);
                }
                return v0_2;
            default:
                int v0_7;
                int v0_4 = ((oc.y) this.h);
                long v1_0 = v0_4.h;
                if (v0_4.i) {
                    oc.l.g("closed");
                    v0_7 = 0;
                } else {
                    if ((v1_0.h != 0) || (v0_4.g.N(8192, v1_0) != -1)) {
                        v0_7 = (v1_0.readByte() & 255);
                    } else {
                        v0_7 = -1;
                    }
                }
                return v0_7;
        }
    }

    public final int read(byte[] p10, int p11, int p12)
    {
        long v0_0 = this.g;
        p10.getClass();
        switch (v0_0) {
            case 0:
                return ((oc.i) this.h).read(p10, p11, p12);
            default:
                int v10_2;
                long v0_6 = ((oc.y) this.h);
                oc.i v1 = v0_6.h;
                if (v0_6.i) {
                    oc.l.g("closed");
                    v10_2 = 0;
                } else {
                    oc.b.c(((long) p10.length), ((long) p11), ((long) p12));
                    if ((v1.h != 0) || (v0_6.g.N(8192, v1) != -1)) {
                        v10_2 = v1.read(p10, p11, p12);
                    } else {
                        v10_2 = -1;
                    }
                }
                return v10_2;
        }
    }

    public final String toString()
    {
        switch (this.g) {
            case 0:
                String v0_6 = new StringBuilder();
                v0_6.append(((oc.i) this.h));
                v0_6.append(".inputStream()");
                return v0_6.toString();
            default:
                String v0_3 = new StringBuilder();
                v0_3.append(((oc.y) this.h));
                v0_3.append(".inputStream()");
                return v0_3.toString();
        }
    }

    public long transferTo(java.io.OutputStream p11)
    {
        switch (this.g) {
            case 1:
                long v4;
                p11.getClass();
                oc.y v0_3 = ((oc.y) this.h);
                oc.i v1 = v0_3.h;
                if (v0_3.i) {
                    oc.l.g("closed");
                    v4 = 0;
                } else {
                    v4 = 0;
                    while ((v1.h != 0) || (v0_3.g.N(8192, v1) != -1)) {
                        long v6_5 = v1.h;
                        v4 += v6_5;
                        v1.u0(p11, v6_5);
                    }
                }
                return v4;
            default:
                return super.transferTo(p11);
        }
    }
}
