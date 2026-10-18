// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public final class g implements java.io.Closeable {
    public final synthetic int g;
    public boolean h;
    public int i;
    public Object j;
    public Object k;

    public g()
    {
        this.g = 0;
        this.i = -1;
        return;
    }

    public g(java.io.RandomAccessFile p2)
    {
        this.g = 1;
        this.j = new java.util.concurrent.locks.ReentrantLock();
        this.k = p2;
        return;
    }

    public final void close()
    {
        switch (this.g) {
            case 0:
                if (((oc.i) this.j) == null) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("not attached to a buffer");
                } else {
                    this.j = 0;
                    this.k = 0;
                    this.i = -1;
                }
                return;
            default:
                Throwable v0_3 = ((java.util.concurrent.locks.ReentrantLock) this.j);
                v0_3.lock();
                try {
                    if (!this.h) {
                        this.h = 1;
                        if (this.i == 0) {
                            v0_3.unlock();
                            ((java.io.RandomAccessFile) this.k).close();
                        } else {
                            v0_3.unlock();
                        }
                    }
                } catch (int v1_3) {
                    v0_3.unlock();
                    throw v1_3;
                }
                return;
        }
    }

    public oc.m d(long p3)
    {
        oc.m v0_1 = ((java.util.concurrent.locks.ReentrantLock) this.j);
        v0_1.lock();
        try {
            if (this.h) {
                throw new IllegalStateException("closed");
            } else {
                this.i = (this.i + 1);
                v0_1.unlock();
                return new oc.m(this, p3);
            }
        } catch (String v3_2) {
            v0_1.unlock();
            throw v3_2;
        }
    }

    public long size()
    {
        Throwable v0_1 = ((java.util.concurrent.locks.ReentrantLock) this.j);
        v0_1.lock();
        try {
            if (this.h) {
                throw new IllegalStateException("closed");
            } else {
                v0_1.unlock();
                return ((java.io.RandomAccessFile) this.k).length();
            }
        } catch (String v1_2) {
            v0_1.unlock();
            throw v1_2;
        }
    }
}
