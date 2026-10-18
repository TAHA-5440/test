// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public final class t implements oc.d0 {
    public final oc.y g;
    public final java.util.zip.Inflater h;
    public int i;
    public boolean j;

    public t(oc.y p1, java.util.zip.Inflater p2)
    {
        this.g = p1;
        this.h = p2;
        return;
    }

    public final long N(long p11, oc.i p13)
    {
        p13.getClass();
        do {
            oc.z v2_2 = p11 cmp 0;
            if (v2_2 < null) {
                oc.l.d(f0.a.b("byteCount < 0: ", p11));
            } else {
                if (this.j) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
                } else {
                    long v8_1;
                    oc.y v3_0 = this.g;
                    java.util.zip.Inflater v4 = this.h;
                    if (v2_2 != null) {
                        oc.z v2_1 = p13.l0(1);
                        oc.z v5_4 = ((int) Math.min(p11, ((long) (8192 - v2_1.c))));
                        if (v4.needsInput()) {
                            if (!v3_0.d()) {
                                int v6_3 = v3_0.h.g;
                                v6_3.getClass();
                                long v8_0 = v6_3.b;
                                int v7_1 = (v6_3.c - v8_0);
                                this.i = v7_1;
                                v4.setInput(v6_3.a, v8_0, v7_1);
                            } else {
                            }
                        } else {
                        }
                        oc.z v5_5 = v4.inflate(v2_1.a, v2_1.c, v5_4);
                        int v6_6 = this.i;
                        if (v6_6 != 0) {
                            int v6_7 = (v6_6 - v4.getRemaining());
                            this.i = (this.i - v6_7);
                            v3_0.skip(((long) v6_7));
                        } else {
                        }
                        if (v5_5 <= null) {
                            if (v2_1.b != v2_1.c) {
                                v8_1 = 0;
                            } else {
                                p13.g = v2_1.a();
                                oc.a0.a(v2_1);
                            }
                        } else {
                            v2_1.c = (v2_1.c + v5_5);
                            v8_1 = ((long) v5_5);
                            p13.h = (p13.h + v8_1);
                        }
                    }
                    if (v8_1 <= 0) {
                        if ((!v4.finished()) && (!v4.needsDictionary())) {
                        } else {
                            return -1;
                        }
                    } else {
                        return v8_1;
                    }
                }
            }
            return 0;
        } while(v3_0.d());
        throw new java.io.EOFException("source exhausted prematurely");
    }

    public final oc.f0 a()
    {
        return this.g.g.a();
    }

    public final void close()
    {
        if (!this.j) {
            this.h.end();
            this.j = 1;
            this.g.close();
            return;
        } else {
            return;
        }
    }
}
