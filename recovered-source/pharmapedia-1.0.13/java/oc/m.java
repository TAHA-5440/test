// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package oc;
public final class m implements oc.d0 {
    public final oc.g g;
    public long h;
    public boolean i;

    public m(oc.g p1, long p2)
    {
        this.g = p1;
        this.h = p2;
        return;
    }

    public final long N(long p17, oc.i p19)
    {
        p19.getClass();
        if (this.i) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("closed");
        } else {
            oc.g v4_1 = this.g;
            long v5 = this.h;
            if (p17 < 0) {
                oc.l.d(f0.a.b("byteCount < 0: ", p17));
            } else {
                oc.z v2_2 = (p17 + v5);
                long v7_2 = v5;
                while (v7_2 < v2_2) {
                    long v9_2 = p19.l0(1);
                    byte[] v12 = v9_2.a;
                    int v13 = v9_2.c;
                    long v17_1 = -1;
                    int v10_3 = ((int) Math.min((v2_2 - v7_2), ((long) (8192 - v13))));
                    v12.getClass();
                    ((java.io.RandomAccessFile) v4_1.k).seek(v7_2);
                    long v11_2 = 0;
                    while (v11_2 < v10_3) {
                        int v14_2 = ((java.io.RandomAccessFile) v4_1.k).read(v12, v13, (v10_3 - v11_2));
                        if (v14_2 != -1) {
                            v11_2 += v14_2;
                        } else {
                            if (v11_2 != 0) {
                                break;
                            }
                            v11_2 = -1;
                            break;
                        }
                    }
                    if (v11_2 != -1) {
                        v9_2.c = (v9_2.c + v11_2);
                        long v9_3 = ((long) v11_2);
                        v7_2 += v9_3;
                        p19.h = (p19.h + v9_3);
                    } else {
                        if (v9_2.b == v9_2.c) {
                            p19.g = v9_2.a();
                            oc.a0.a(v9_2);
                        }
                        if (v5 != v7_2) {
                            long v7_3 = (v7_2 - v5);
                        } else {
                            v7_3 = -1;
                        }
                    }
                    if (v7_3 != v17_1) {
                        this.h = (this.h + v7_3);
                    }
                    return v7_3;
                }
                v17_1 = -1;
            }
        }
        return 0;
    }

    public final oc.f0 a()
    {
        return oc.f0.d;
    }

    public final void close()
    {
        Throwable v0_0 = this.g;
        if (!this.i) {
            this.i = 1;
            Throwable v1_6 = ((java.util.concurrent.locks.ReentrantLock) v0_0.j);
            v1_6.lock();
            try {
                boolean v2_2 = (v0_0.i - 1);
                v0_0.i = v2_2;
            } catch (Throwable v0_1) {
                v1_6.unlock();
                throw v0_1;
            }
            if ((!v2_2) && (v0_0.h)) {
                v1_6.unlock();
                ((java.io.RandomAccessFile) v0_0.k).close();
                return;
            } else {
                v1_6.unlock();
                return;
            }
        } else {
            return;
        }
    }
}
