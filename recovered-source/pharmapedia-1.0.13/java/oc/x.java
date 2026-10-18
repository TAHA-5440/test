// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public final class x implements oc.j {
    public final oc.b0 g;
    public final oc.i h;
    public boolean i;

    public x(oc.b0 p1)
    {
        p1.getClass();
        this.g = p1;
        this.h = new oc.i();
        return;
    }

    public final void D(long p2, oc.i p4)
    {
        p4.getClass();
        if (this.i) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
            return;
        } else {
            this.h.D(p2, p4);
            this.d();
            return;
        }
    }

    public final oc.j G(String p2)
    {
        p2.getClass();
        if (this.i) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
            return 0;
        } else {
            this.h.w0(p2);
            this.d();
            return this;
        }
    }

    public final oc.j R(okio.ByteString p2)
    {
        p2.getClass();
        if (this.i) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
            return 0;
        } else {
            this.h.m0(p2);
            this.d();
            return this;
        }
    }

    public final oc.j Y(long p2)
    {
        if (this.i) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
            return 0;
        } else {
            this.h.p0(p2);
            this.d();
            return this;
        }
    }

    public final oc.f0 a()
    {
        return this.g.a();
    }

    public final void close()
    {
        int v0_0 = this.g;
        if (!this.i) {
            try {
                int v1_2 = this.h;
                long v2 = v1_2.h;
            } catch (int v1_1) {
                try {
                    v0_0.close();
                } catch (int v0_1) {
                    if (v1_1 != 0) {
                    } else {
                        v1_1 = v0_1;
                    }
                }
                this.i = 1;
                if (v1_1 != 0) {
                    throw v1_1;
                }
            }
            if (v2 > 0) {
                v0_0.D(v2, v1_2);
            }
            v1_1 = 0;
        }
        return;
    }

    public final oc.j d()
    {
        if (this.i) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
            return 0;
        } else {
            int v0_3 = this.h;
            long v1 = v0_3.h();
            if (v1 > 0) {
                this.g.D(v1, v0_3);
            }
            return this;
        }
    }

    public final void flush()
    {
        if (this.i) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
            return;
        } else {
            String v0_2 = this.h;
            long v1 = v0_2.h;
            oc.b0 v4 = this.g;
            if (v1 > 0) {
                v4.D(v1, v0_2);
            }
            v4.flush();
            return;
        }
    }

    public final boolean isOpen()
    {
        return (this.i ^ 1);
    }

    public final oc.j r(long p2)
    {
        if (this.i) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
            return 0;
        } else {
            this.h.s0(p2);
            this.d();
            return this;
        }
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder("buffer(");
        v0_1.append(this.g);
        v0_1.append(41);
        return v0_1.toString();
    }

    public final oc.j v(int p2)
    {
        if (this.i) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
            return 0;
        } else {
            this.h.r0(oc.b.d(p2));
            this.d();
            return this;
        }
    }

    public final int write(java.nio.ByteBuffer p2)
    {
        p2.getClass();
        if (this.i) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
            return 0;
        } else {
            int v2_3 = this.h.write(p2);
            this.d();
            return v2_3;
        }
    }

    public final oc.j write(byte[] p4)
    {
        p4.getClass();
        if (this.i) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
            return 0;
        } else {
            this.h.write(p4, 0, p4.length);
            this.d();
            return this;
        }
    }

    public final oc.j writeByte(int p2)
    {
        if (this.i) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
            return 0;
        } else {
            this.h.o0(p2);
            this.d();
            return this;
        }
    }

    public final oc.j writeInt(int p2)
    {
        if (this.i) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
            return 0;
        } else {
            this.h.r0(p2);
            this.d();
            return this;
        }
    }

    public final oc.j writeShort(int p2)
    {
        if (this.i) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
            return 0;
        } else {
            this.h.t0(p2);
            this.d();
            return this;
        }
    }
}
