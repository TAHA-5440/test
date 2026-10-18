// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public class f0 {
    public static final oc.e0 d;
    public boolean a;
    public long b;
    public long c;

    static f0()
    {
        oc.f0.d = new oc.e0();
        return;
    }

    public oc.f0 a()
    {
        this.a = 0;
        return this;
    }

    public oc.f0 b()
    {
        this.c = 0;
        return this;
    }

    public long c()
    {
        if (!this.a) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("No deadline");
            return 0;
        } else {
            return this.b;
        }
    }

    public oc.f0 d(long p2)
    {
        this.a = 1;
        this.b = p2;
        return this;
    }

    public boolean e()
    {
        return this.a;
    }

    public void f()
    {
        if (Thread.currentThread().isInterrupted()) {
            throw new java.io.InterruptedIOException("interrupted");
        } else {
            if ((this.a) && ((this.b - System.nanoTime()) <= 0)) {
                throw new java.io.InterruptedIOException("deadline reached");
            } else {
                return;
            }
        }
    }

    public oc.f0 g(long p4)
    {
        String v0_0 = java.util.concurrent.TimeUnit.MILLISECONDS;
        v0_0.getClass();
        if (p4 < 0) {
            oc.l.d(f0.a.b("timeout < 0: ", p4));
            return 0;
        } else {
            this.c = v0_0.toNanos(p4);
            return this;
        }
    }
}
