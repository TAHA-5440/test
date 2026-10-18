// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public final class q {
    public final int a;
    public int b;
    public Object c;
    public final Object d;
    public final Object e;
    public final Object f;

    public q()
    {
        this.a = 64;
        this.b = 5;
        this.d = new java.util.ArrayDeque();
        this.e = new java.util.ArrayDeque();
        this.f = new java.util.ArrayDeque();
        return;
    }

    public q(int p3)
    {
        this.c = new jb.e(22);
        this.d = new z2.e(0);
        this.e = new java.util.HashMap();
        this.f = new java.util.HashMap();
        this.a = p3;
        return;
    }

    public static void i(yb.q p10, cc.o p11, cc.r p12, cc.o p13, int p14)
    {
        if ((p14 & 1) != 0) {
            p11 = 0;
        }
        if ((p14 & 2) != 0) {
            p12 = 0;
        }
        if ((p14 & 4) != 0) {
            p13 = 0;
        }
        p10.getClass();
        boolean v14_2 = p10.c().isShutdown();
        if (p12 != 0) {
            if (!((java.util.ArrayDeque) p10.f).remove(p12)) {
                throw new IllegalStateException("Call wasn\'t in-flight!");
            } else {
            }
        }
        if (p13 != null) {
            p13.h.decrementAndGet();
            if (!((java.util.ArrayDeque) p10.e).remove(p13)) {
                throw new IllegalStateException("Call wasn\'t in-flight!");
            } else {
            }
        }
        if (p11 != null) {
            ((java.util.ArrayDeque) p10.d).add(p11);
            p11.i.getClass();
            int v0_18 = p10.d(((yb.u) p11.i.h.b).d);
            if (v0_18 != 0) {
                p11.h = v0_18.h;
            }
        }
        if (((p12 != 0) || (p13 != null)) && ((v14_2) || (((java.util.ArrayDeque) p10.e).isEmpty()))) {
            ((java.util.ArrayDeque) p10.f).isEmpty();
        }
        v9.a v13_4;
        if (!v14_2) {
            int v12_16 = new java.util.ArrayList();
            v9.a v13_7 = ((java.util.ArrayDeque) p10.d).iterator();
            v13_7.getClass();
            while (v13_7.hasNext()) {
                int v0_22 = ((cc.o) v13_7.next());
                if (((java.util.ArrayDeque) p10.e).size() >= p10.a) {
                    break;
                }
                if (v0_22.h.get() < p10.b) {
                    v13_7.remove();
                    v0_22.h.incrementAndGet();
                    v12_16.add(v0_22);
                    ((java.util.ArrayDeque) p10.e).add(v0_22);
                }
            }
            v13_4 = new v9.a(v12_16);
        } else {
            int v12_3 = ha.j.U(((java.util.ArrayDeque) p10.d));
            ((java.util.ArrayDeque) p10.d).clear();
            v13_4 = new v9.a(v12_3);
        }
        int v12_5 = v13_4.a.size();
        int v0_1 = 1;
        int v3_0 = 0;
        while (v3_0 < v12_5) {
            com.google.firebase.perf.network.InstrumentOkHttpEnqueueCallback v4_2 = ((cc.o) v13_4.a.get(v3_0));
            if (v4_2 != p11) {
                v4_2.i.getClass();
            } else {
                v0_1 = 0;
            }
            if (!v14_2) {
                yb.q v5_1 = p10.c();
                v4_2.getClass();
                cc.r v6_0 = v4_2.i;
                v6_0.g.a.getClass();
                try {
                    v5_1.execute(v4_2);
                } catch (yb.q v5_2) {
                    java.io.InterruptedIOException v8_1 = new java.io.InterruptedIOException("executor rejected");
                    v8_1.initCause(v5_2);
                    yb.q v5_3 = v4_2.i;
                    v5_3.h(v8_1);
                    v4_2.g.onFailure(v5_3, v8_1);
                    yb.q v5_5 = v6_0.g.a;
                    v5_5.getClass();
                    yb.q.i(v5_5, 0, 0, v4_2, 3);
                } catch (Throwable v10_2) {
                    yb.q v11_3 = v6_0.g.a;
                    v11_3.getClass();
                    yb.q.i(v11_3, 0, 0, v4_2, 3);
                    throw v10_2;
                }
            } else {
                v4_2.getClass();
                yb.q v5_7 = new java.io.InterruptedIOException("executor rejected");
                v5_7.initCause(0);
                cc.r v6_2 = v4_2.i;
                v6_2.h(v5_7);
                v4_2.g.onFailure(v6_2, v5_7);
            }
            v3_0++;
        }
        if ((v0_1 != 0) && (p11 != null)) {
            p11.i.getClass();
        }
        return;
    }

    public void a(Class p4, int p5)
    {
        NullPointerException v4_1 = this.h(p4);
        Integer v0_6 = ((Integer) v4_1.get(Integer.valueOf(p5)));
        if (v0_6 == null) {
            Integer v0_0 = new StringBuilder("Tried to decrement empty size, size: ");
            v0_0.append(p5);
            v0_0.append(", this: ");
            v0_0.append(this);
            throw new NullPointerException(v0_0.toString());
        } else {
            if (v0_6.intValue() != 1) {
                v4_1.put(Integer.valueOf(p5), Integer.valueOf((v0_6.intValue() - 1)));
                return;
            } else {
                v4_1.remove(Integer.valueOf(p5));
                return;
            }
        }
    }

    public void b(int p6)
    {
        while (this.b > p6) {
            String v0_5 = ((jb.e) this.c).u();
            s3.f.b(v0_5);
            z2.b v1_0 = this.f(v0_5.getClass());
            this.b = (this.b - (v1_0.b() * v1_0.a(v0_5)));
            this.a(v0_5.getClass(), v1_0.a(v0_5));
            if (android.util.Log.isLoggable(v1_0.c(), 2)) {
                String v2_5 = v1_0.c();
                StringBuilder v3_4 = new StringBuilder("evicted: ");
                v3_4.append(v1_0.a(v0_5));
                android.util.Log.v(v2_5, v3_4.toString());
            }
        }
        return;
    }

    public declared_synchronized java.util.concurrent.ExecutorService c()
    {
        if (((java.util.concurrent.ExecutorService) this.c) == null) {
            java.util.concurrent.SynchronousQueue v7_1 = new java.util.concurrent.SynchronousQueue();
            java.util.concurrent.ExecutorService v0_7 = new StringBuilder();
            v0_7.append(zb.e.b);
            v0_7.append(" Dispatcher");
            this.c = new java.util.concurrent.ThreadPoolExecutor(0, 2147483647, 60, java.util.concurrent.TimeUnit.SECONDS, v7_1, new zb.d(v0_7.toString(), 0));
        }
        java.util.concurrent.ExecutorService v0_5 = ((java.util.concurrent.ExecutorService) this.c);
        v0_5.getClass();
        return v0_5;
    }

    public cc.o d(String p4)
    {
        java.util.Iterator v0_3 = ((java.util.ArrayDeque) this.e).iterator();
        v0_3.getClass();
        while (v0_3.hasNext()) {
            cc.o v1_4 = ((cc.o) v0_3.next());
            if (kotlin.jvm.internal.f.a(((yb.u) v1_4.i.h.b).d, p4)) {
                return v1_4;
            }
        }
        java.util.Iterator v0_2 = ((java.util.ArrayDeque) this.d).iterator();
        v0_2.getClass();
        while (v0_2.hasNext()) {
            cc.o v1_2 = ((cc.o) v0_2.next());
            if (kotlin.jvm.internal.f.a(((yb.u) v1_2.i.h.b).d, p4)) {
                return v1_2;
            }
        }
        return 0;
    }

    public declared_synchronized Object e(Class p4, int p5)
    {
        int v1_2;
        z2.d v0_11 = ((Integer) this.h(p4).ceilingKey(Integer.valueOf(p5)));
        if (v0_11 == null) {
            v1_2 = 0;
        } else {
            int v1_4 = this.b;
            if (v1_4 != 0) {
                if ((this.a / v1_4) < 2) {
                    if (v0_11.intValue() > (p5 * 8)) {
                    }
                } else {
                }
            }
            v1_2 = 1;
        }
        z2.d v0_5;
        int v2_4 = ((z2.e) this.d);
        if (v1_2 == 0) {
            z2.d v0_4 = ((z2.g) ((java.util.ArrayDeque) v2_4.g).poll());
            if (v0_4 == null) {
                v0_4 = v2_4.j();
            }
            v0_5 = ((z2.d) v0_4);
            v0_5.b = p5;
            v0_5.c = p4;
        } else {
            int v5_1 = v0_11.intValue();
            z2.d v0_9 = ((z2.g) ((java.util.ArrayDeque) v2_4.g).poll());
            if (v0_9 == null) {
                v0_9 = v2_4.j();
            }
            v0_5 = ((z2.d) v0_9);
            v0_5.b = v5_1;
            v0_5.c = p4;
        }
        return this.g(v0_5, p4);
    }

    public z2.b f(Class p4)
    {
        String v0_1 = ((java.util.HashMap) this.f);
        z2.b v1_6 = ((z2.b) v0_1.get(p4));
        if (v1_6 != null) {
            return v1_6;
        } else {
            z2.b v1_3;
            if (!p4.equals(int[])) {
                if (!p4.equals(byte[])) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("No array pool found for: ".concat(p4.getSimpleName()));
                    return 0;
                } else {
                    v1_3 = new z2.b(0);
                }
            } else {
                v1_3 = new z2.b(1);
            }
            v0_1.put(p4, v1_3);
            return v1_3;
        }
    }

    public Object g(z2.d p6, Class p7)
    {
        z2.b v0 = this.f(p7);
        String v1_6 = ((jb.e) this.c).e(p6);
        if (v1_6 != null) {
            this.b = (this.b - (v0.b() * v0.a(v1_6)));
            this.a(p7, v0.a(v1_6));
        }
        if (v1_6 != null) {
            return v1_6;
        } else {
            if (android.util.Log.isLoggable(v0.c(), 2)) {
                int v7_3 = v0.c();
                String v1_4 = new StringBuilder("Allocated ");
                v1_4.append(p6.b);
                v1_4.append(" bytes");
                android.util.Log.v(v7_3, v1_4.toString());
            }
            byte[] v6_2;
            byte[] v6_1 = p6.b;
            switch (v0.a) {
                case 0:
                    v6_2 = new byte[v6_1];
                default:
                    v6_2 = new int[v6_1];
            }
            return v6_2;
        }
    }

    public java.util.NavigableMap h(Class p3)
    {
        java.util.HashMap v0_1 = ((java.util.HashMap) this.e);
        java.util.TreeMap v1_1 = ((java.util.NavigableMap) v0_1.get(p3));
        if (v1_1 == null) {
            v1_1 = new java.util.TreeMap();
            v0_1.put(p3, v1_1);
        }
        return v1_1;
    }

    public declared_synchronized void j(Object p6)
    {
        Integer v0_0 = p6.getClass();
        int v1_0 = this.f(v0_0);
        Integer v2_4 = v1_0.a(p6);
        int v1_2 = (v1_0.b() * v2_4);
        if (v1_2 > (this.a / 2)) {
            return;
        } else {
            int v3_2 = ((z2.e) this.d);
            z2.d v4_3 = ((z2.g) ((java.util.ArrayDeque) v3_2.g).poll());
            if (v4_3 == null) {
                v4_3 = v3_2.j();
            }
            z2.d v4_4 = ((z2.d) v4_3);
            v4_4.b = v2_4;
            v4_4.c = v0_0;
            ((jb.e) this.c).s(v4_4, p6);
            int v6_1 = this.h(v0_0);
            Integer v0_4 = ((Integer) v6_1.get(Integer.valueOf(v4_4.b)));
            Integer v2_3 = Integer.valueOf(v4_4.b);
            int v3_3 = 1;
            if (v0_4 != null) {
                v3_3 = (1 + v0_4.intValue());
            } else {
            }
            v6_1.put(v2_3, Integer.valueOf(v3_3));
            this.b = (this.b + v1_2);
            this.b(this.a);
            return;
        }
    }
}
