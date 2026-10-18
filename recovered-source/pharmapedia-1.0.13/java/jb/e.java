// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package jb;
public final class e implements jb.b, q0.s {
    public final synthetic int g;
    public Object h;
    public Object i;

    public e(int p2)
    {
        this.g = p2;
        switch (p2) {
            case 7:
                this.h = new java.util.ArrayList();
                this.i = new java.util.HashMap();
                return;
            case 9:
                this.h = new java.util.concurrent.atomic.AtomicLong();
                this.i = new java.util.concurrent.atomic.AtomicLong();
                return;
            case 16:
                this.h = new android.util.SparseIntArray();
                this.i = new android.util.SparseIntArray();
                return;
            case 19:
                this.h = new t.l(0);
                this.i = new t.g();
                return;
            case 22:
                this.h = new z2.c(0);
                this.i = new java.util.HashMap();
                return;
            default:
                this.h = new java.util.concurrent.atomic.AtomicReference();
                this.i = new t.e(0);
                return;
        }
    }

    public synthetic e(int p1, Object p2, Object p3)
    {
        this.g = p1;
        this.h = p2;
        this.i = p3;
        return;
    }

    public synthetic e(int p1, boolean p2)
    {
        this.g = p1;
        return;
    }

    public e(android.view.WindowInsetsAnimation$Bounds p2)
    {
        this.g = 11;
        this.h = i0.c.d(androidx.work.impl.utils.a.g(p2));
        this.i = i0.c.d(q0.v0.e(p2));
        return;
    }

    public e(androidx.viewpager.widget.ViewPager p2)
    {
        this.g = 10;
        this.i = p2;
        this.h = new android.graphics.Rect();
        return;
    }

    public e(com.bumptech.glide.load.engine.a p2, com.bumptech.glide.load.DataSource p3)
    {
        this.g = 21;
        this.i = p2;
        this.h = p3;
        return;
    }

    public synthetic e(Object p1, int p2)
    {
        this.g = p2;
        this.i = p1;
        return;
    }

    public e(String p2)
    {
        this.g = 20;
        this.h = p2.concat(".lck");
        return;
    }

    public e(jb.e p2)
    {
        this.g = 2;
        this.h = ((k7.a) p2.h);
        g7.c1 v2_2 = ((g7.c1) p2.i);
        v2_2.getClass();
        this.i = new a3.f(v2_2);
        return;
    }

    public e(n5.f p2)
    {
        this.g = 3;
        this.h = new java.util.HashMap();
        this.i = p2;
        return;
    }

    public e(w1.r0 p2)
    {
        this.g = 18;
        this.h = p2;
        w1.q1 v2_2 = new w1.q1();
        v2_2.a = 0;
        this.i = v2_2;
        return;
    }

    public e(z8.a p2)
    {
        this.g = 23;
        this.h = p2;
        return;
    }

    public static int h(int p5, int p6)
    {
        int v1 = 0;
        int v2_0 = 0;
        int v3 = 0;
        while (v1 < p5) {
            v2_0++;
            if (v2_0 != p6) {
                if (v2_0 > p6) {
                    v3++;
                    v2_0 = 1;
                }
            } else {
                v3++;
                v2_0 = 0;
            }
            v1++;
        }
        if ((v2_0 + 1) > p6) {
            v3++;
        }
        return v3;
    }

    public void a(w1.h1 p3, m6.b p4)
    {
        t.l v0_1 = ((t.l) this.h);
        w1.r1 v1_1 = ((w1.r1) v0_1.get(p3));
        if (v1_1 == null) {
            v1_1 = w1.r1.a();
            v0_1.put(p3, v1_1);
        }
        v1_1.c = p4;
        v1_1.a = (v1_1.a | 8);
        return;
    }

    public void b()
    {
        int v0_1 = ((int[]) this.h);
        if (v0_1 != 0) {
            java.util.Arrays.fill(v0_1, -1);
        }
        this.i = 0;
        return;
    }

    public void c(int p5)
    {
        int v0_1 = ((int[]) this.h);
        if (v0_1 != 0) {
            if (p5 >= v0_1.length) {
                int v2_2 = v0_1.length;
                while (v2_2 <= p5) {
                    v2_2 *= 2;
                }
                int[] v5_6 = new int[v2_2];
                this.h = v5_6;
                System.arraycopy(v0_1, 0, v5_6, 0, v0_1.length);
                int[] v5_2 = ((int[]) this.h);
                java.util.Arrays.fill(v5_2, v0_1.length, v5_2.length, -1);
            }
            return;
        } else {
            int[] v5_5 = new int[(Math.max(p5, 10) + 1)];
            this.h = v5_5;
            java.util.Arrays.fill(v5_5, -1);
            return;
        }
    }

    public Object collect(jb.c p6, ka.c p7)
    {
        Object v0_2;
        if (!(p7 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1)) {
            v0_2 = new kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1(this, p7);
        } else {
            v0_2 = ((kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1) p7);
            kotlin.coroutines.intrinsics.CoroutineSingletons v1_2 = ((kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1) p7).h;
            if ((v1_2 & -2147483648) == 0) {
            } else {
                ((kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$1) p7).h = (v1_2 - -2147483648);
            }
        }
        kotlinx.coroutines.flow.internal.AbortFlowException v7_1 = v0_2.g;
        kotlin.coroutines.intrinsics.CoroutineSingletons v1_1 = kotlin.coroutines.intrinsics.CoroutineSingletons.g;
        jb.f v2_0 = v0_2.h;
        if (v2_0 == null) {
            kotlin.b.b(v7_1);
            kotlinx.coroutines.flow.internal.AbortFlowException v7_3 = ((a0.i) this.h);
            jb.f v2_2 = new jb.f(((ua.p) this.i), p6);
            try {
                v0_2.j = v2_2;
                v0_2.h = 1;
            } catch (kotlinx.coroutines.flow.internal.AbortFlowException v7_4) {
                ga.p v6_2 = v2_2;
                if (v7_4.g != v6_2) {
                    throw v7_4;
                }
            }
            if (v7_3.collect(v2_2, v0_2) == v1_1) {
                return v1_1;
            }
        } else {
            if (v2_0 != 1) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("call to \'resume\' before \'invoke\' with coroutine");
                return 0;
            } else {
                v6_2 = v0_2.j;
                try {
                    kotlin.b.b(v7_1);
                } catch (kotlinx.coroutines.flow.internal.AbortFlowException v7_4) {
                }
            }
        }
        return ga.p.a;
    }

    public android.view.View d(int p10, int p11, int p12, int p13)
    {
        int v4;
        w1.q1 v0_1 = ((w1.q1) this.i);
        w1.r0 v1_1 = ((w1.r0) this.h);
        int v2 = v1_1.d();
        int v3 = v1_1.c();
        if (p11 <= p10) {
            v4 = -1;
        } else {
            v4 = 1;
        }
        android.view.View v5 = 0;
        while (p10 != p11) {
            android.view.View v6_2;
            switch (v1_1.a) {
                case 0:
                    v6_2 = v1_1.b.u(p10);
                    break;
                default:
                    v6_2 = v1_1.b.u(p10);
            }
            boolean v7_0 = v1_1.b(v6_2);
            int v8 = v1_1.a(v6_2);
            v0_1.b = v2;
            v0_1.c = v3;
            v0_1.d = v7_0;
            v0_1.e = v8;
            if (p12 != 0) {
                v0_1.a = p12;
                if (v0_1.a()) {
                    return v6_2;
                }
            }
            if (p13 != 0) {
                v0_1.a = p13;
                if (v0_1.a()) {
                    v5 = v6_2;
                }
            }
            p10 += v4;
        }
        return v5;
    }

    public Object e(z2.g p3)
    {
        java.util.ArrayList v0_1 = ((java.util.HashMap) this.i);
        z2.c v1_1 = ((z2.c) v0_1.get(p3));
        if (v1_1 != null) {
            p3.a();
        } else {
            v1_1 = new z2.c(p3);
            v0_1.put(p3, v1_1);
        }
        int v3_7;
        int v3_1 = v1_1.d;
        v3_1.c = v1_1.c;
        v1_1.c.d = v3_1;
        int v3_3 = ((z2.c) this.h);
        v1_1.d = v3_3;
        int v3_4 = v3_3.c;
        v1_1.c = v3_4;
        v3_4.d = v1_1;
        v1_1.d.c = v1_1;
        int v3_6 = v1_1.b;
        if (v3_6 == 0) {
            v3_7 = 0;
        } else {
            v3_7 = v3_6.size();
        }
        if (v3_7 <= 0) {
            return 0;
        } else {
            return v1_1.b.remove((v3_7 - 1));
        }
    }

    public declared_synchronized java.util.List f(String p3)
    {
        if (!((java.util.ArrayList) this.h).contains(p3)) {
            ((java.util.ArrayList) this.h).add(p3);
        }
        java.util.ArrayList v0_3 = ((java.util.List) ((java.util.HashMap) this.i).get(p3));
        if (v0_3 == null) {
            v0_3 = new java.util.ArrayList();
            ((java.util.HashMap) this.i).put(p3, v0_3);
        }
        return v0_3;
    }

    public declared_synchronized java.util.ArrayList g(Class p9, Class p10)
    {
        java.util.ArrayList v0_1 = new java.util.ArrayList();
        java.util.ArrayList v1_1 = ((java.util.ArrayList) this.h);
        int v2 = v1_1.size();
        int v4 = 0;
        while (v4 < v2) {
            java.util.Iterator v5_0 = v1_1.get(v4);
            v4++;
            java.util.Iterator v5_3 = ((java.util.List) ((java.util.HashMap) this.i).get(((String) v5_0)));
            if (v5_3 != null) {
                java.util.Iterator v5_4 = v5_3.iterator();
                while (v5_4.hasNext()) {
                    boolean v7_4;
                    Class v6_4 = ((n3.c) v5_4.next());
                    if ((!v6_4.a.isAssignableFrom(p9)) || (!p10.isAssignableFrom(v6_4.b))) {
                        v7_4 = 0;
                    } else {
                        v7_4 = 1;
                    }
                    if ((v7_4) && (!v0_1.contains(v6_4.b))) {
                        v0_1.add(v6_4.b);
                    }
                }
            } else {
            }
        }
        return v0_1;
    }

    public void i(String p8, String p9)
    {
        String v0_2 = ((g7.c1) this.i).b;
        if (p8.isEmpty()) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("name is empty");
            return;
        } else {
            boolean v1_0 = p8.length();
            int v2 = 0;
            int v3_0 = 0;
            while (v3_0 < v1_0) {
                char v6_1 = p8.charAt(v3_0);
                if ((v6_1 <= 31) || (v6_1 >= 127)) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u(String.format(java.util.Locale.US, "Unexpected char %#04x at %d in header name: %s", new Object[] {Integer.valueOf(v6_1), Integer.valueOf(v3_0), p8})));
                    return;
                } else {
                    v3_0++;
                }
            }
            if (p9 == null) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("value == null");
                return;
            } else {
                boolean v1_1 = p9.length();
                int v3_1 = 0;
                while (v3_1 < v1_1) {
                    char v6_0 = p9.charAt(v3_1);
                    if ((v6_0 <= 31) || (v6_0 >= 127)) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u(String.format(java.util.Locale.US, "Unexpected char %#04x at %d in header value: %s", new Object[] {Integer.valueOf(v6_0), Integer.valueOf(v3_1), p9})));
                        return;
                    } else {
                        v3_1++;
                    }
                }
                while (v2 < v0_2.size()) {
                    if (p8.equalsIgnoreCase(((String) v0_2.get(v2)))) {
                        v0_2.remove(v2);
                        v0_2.remove(v2);
                        v2 -= 2;
                    }
                    v2 += 2;
                }
                v0_2.add(p8);
                v0_2.add(p9.trim());
                return;
            }
        }
    }

    public void j()
    {
        ((android.util.SparseIntArray) this.h).clear();
        return;
    }

    public q0.o1 k(android.view.View p7, q0.o1 p8)
    {
        int v0_1 = ((androidx.viewpager.widget.ViewPager) this.i);
        q0.o1 v7_1 = q0.n0.i(p7, p8);
        if (!v7_1.a.n()) {
            int v8_5 = ((android.graphics.Rect) this.h);
            v8_5.left = v7_1.b();
            v8_5.top = v7_1.d();
            v8_5.right = v7_1.c();
            v8_5.bottom = v7_1.a();
            int v1_4 = v0_1.getChildCount();
            int v2_0 = 0;
            while (v2_0 < v1_4) {
                int v3_1 = q0.n0.b(v0_1.getChildAt(v2_0), v7_1);
                v8_5.left = Math.min(v3_1.b(), v8_5.left);
                v8_5.top = Math.min(v3_1.d(), v8_5.top);
                v8_5.right = Math.min(v3_1.c(), v8_5.right);
                v8_5.bottom = Math.min(v3_1.a(), v8_5.bottom);
                v2_0++;
            }
            return v7_1.f(v8_5.left, v8_5.top, v8_5.right, v8_5.bottom);
        } else {
            return v7_1;
        }
    }

    public boolean l(android.view.View p6)
    {
        w1.q1 v0_1 = ((w1.q1) this.i);
        w1.r0 v1_1 = ((w1.r0) this.h);
        int v2 = v1_1.d();
        int v3 = v1_1.c();
        int v4 = v1_1.b(p6);
        boolean v6_1 = v1_1.a(p6);
        v0_1.b = v2;
        v0_1.c = v3;
        v0_1.d = v4;
        v0_1.e = v6_1;
        v0_1.a = 24579;
        return v0_1.a();
    }

    public void m()
    {
        String v0_1 = ((String) this.h);
        if (((java.nio.channels.FileChannel) this.i) == null) {
            java.nio.channels.FileChannel v1_5 = new java.io.File(v0_1);
            IllegalStateException v2_7 = v1_5.getParentFile();
            if (v2_7 != null) {
                v2_7.mkdirs();
            }
            java.nio.channels.FileChannel v1_0 = new java.io.FileOutputStream(v1_5).getChannel();
            this.i = v1_0;
            if (v1_0 != null) {
                v1_0.lock();
            }
        }
        return;
    }

    public void n(int p4, int p5)
    {
        int v0_1 = ((int[]) this.h);
        if ((v0_1 != 0) && (p4 < v0_1.length)) {
            int v0_7 = (p4 + p5);
            this.c(v0_7);
            w1.n1 v1_7 = ((int[]) this.h);
            System.arraycopy(v1_7, p4, v1_7, v0_7, ((v1_7.length - p4) - p5));
            java.util.Arrays.fill(((int[]) this.h), p4, v0_7, -1);
            int v0_3 = ((java.util.ArrayList) this.i);
            if (v0_3 != 0) {
                int v0_5 = (v0_3.size() - 1);
                while (v0_5 >= 0) {
                    w1.n1 v1_5 = ((w1.n1) ((java.util.ArrayList) this.i).get(v0_5));
                    int v2_3 = v1_5.g;
                    if (v2_3 >= p4) {
                        v1_5.g = (v2_3 + p5);
                    }
                    v0_5--;
                }
            }
        }
        return;
    }

    public void o(int p6, int p7)
    {
        int v0_1 = ((int[]) this.h);
        if ((v0_1 != 0) && (p6 < v0_1.length)) {
            int v0_3 = (p6 + p7);
            this.c(v0_3);
            int v1_7 = ((int[]) this.h);
            System.arraycopy(v1_7, v0_3, v1_7, p6, ((v1_7.length - p6) - p7));
            int v1_1 = ((int[]) this.h);
            java.util.Arrays.fill(v1_1, (v1_1.length - p7), v1_1.length, -1);
            int v1_3 = ((java.util.ArrayList) this.i);
            if (v1_3 != 0) {
                int v1_5 = (v1_3.size() - 1);
                while (v1_5 >= 0) {
                    java.util.ArrayList v2_7 = ((w1.n1) ((java.util.ArrayList) this.i).get(v1_5));
                    int v3_1 = v2_7.g;
                    if (v3_1 >= p6) {
                        if (v3_1 >= v0_3) {
                            v2_7.g = (v3_1 - p7);
                        } else {
                            ((java.util.ArrayList) this.i).remove(v1_5);
                        }
                    }
                    v1_5--;
                }
            }
        }
        return;
    }

    public void q(n0.f p6)
    {
        n0.k v0_1 = ((n0.k) this.i);
        a3.f v1_1 = ((a3.f) this.h);
        b3.c v2_2 = p6.b;
        if (v2_2 != null) {
            v0_1.execute(new e1.i(v1_1, v2_2, 4));
            return;
        } else {
            v0_1.execute(new b3.c(10, v1_1, p6.a, 0));
            return;
        }
    }

    public m6.b r(w1.h1 p6, int p7)
    {
        t.l v0_1 = ((t.l) this.h);
        p0.d v6_4 = v0_1.d(p6);
        if (v6_4 >= null) {
            w1.r1 v2_1 = ((w1.r1) v0_1.j(v6_4));
            if (v2_1 != null) {
                int v3_0 = v2_1.a;
                if ((v3_0 & p7) != 0) {
                    m6.b v7_1;
                    int v3_1 = (v3_0 & (~ p7));
                    v2_1.a = v3_1;
                    if (p7 != 4) {
                        if (p7 != 8) {
                            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("Must provide flag PRE or POST");
                            return 0;
                        } else {
                            v7_1 = v2_1.c;
                        }
                    } else {
                        v7_1 = v2_1.b;
                    }
                    if ((v3_1 & 12) == 0) {
                        v0_1.h(v6_4);
                        v2_1.a = 0;
                        v2_1.b = 0;
                        v2_1.c = 0;
                        w1.r1.d.b(v2_1);
                    }
                    return v7_1;
                }
            }
        }
        return 0;
    }

    public void s(z2.g p5, Object p6)
    {
        java.util.HashMap v0_1 = ((java.util.HashMap) this.i);
        z2.c v1_1 = ((z2.c) v0_1.get(p5));
        if (v1_1 != null) {
            p5.a();
        } else {
            v1_1 = new z2.c(p5);
            v1_1.d = v1_1;
            z2.c v2_1 = ((z2.c) this.h);
            v1_1.d = v2_1.d;
            v1_1.c = v2_1;
            v2_1.d = v1_1;
            v1_1.d.c = v1_1;
            v0_1.put(p5, v1_1);
        }
        if (v1_1.b == null) {
            v1_1.b = new java.util.ArrayList();
        }
        v1_1.b.add(p6);
        return;
    }

    public void t(w1.h1 p2)
    {
        w1.r1 v2_2 = ((w1.r1) ((t.l) this.h).get(p2));
        if (v2_2 != null) {
            v2_2.a = (v2_2.a & -2);
            return;
        } else {
            return;
        }
    }

    public String toString()
    {
        switch (this.g) {
            case 2:
                String v0_14 = new StringBuilder("Request{url=");
                v0_14.append(((k7.a) this.h));
                v0_14.append(125);
                return v0_14.toString();
            case 11:
                String v0_11 = new StringBuilder("Bounds{lower=");
                v0_11.append(((i0.c) this.h));
                v0_11.append(" upper=");
                v0_11.append(((i0.c) this.i));
                v0_11.append("}");
                return v0_11.toString();
            case 14:
                String v1_4 = "[ ";
                if (((v.e) this.h) != null) {
                    String v0_6 = 0;
                    while (v0_6 < 9) {
                        String v1_8 = f0.a.f(v1_4);
                        v1_8.append(((v.e) this.h).n[v0_6]);
                        v1_8.append(" ");
                        v1_4 = v1_8.toString();
                        v0_6++;
                    }
                }
                String v0_8 = f0.a.g(v1_4, "] ");
                v0_8.append(((v.e) this.h));
                return v0_8.toString();
            case 22:
                String v0_3 = new StringBuilder("GroupedLinkedMap( ");
                String v1_9 = ((z2.c) this.h);
                z2.c v2_1 = v1_9.c;
                int v4_6 = 0;
                while (!v2_1.equals(v1_9)) {
                    int v4_4;
                    v0_3.append(123);
                    v0_3.append(v2_1.a);
                    v0_3.append(58);
                    int v4_3 = v2_1.b;
                    if (v4_3 == 0) {
                        v4_4 = 0;
                    } else {
                        v4_4 = v4_3.size();
                    }
                    v0_3.append(v4_4);
                    v0_3.append("}, ");
                    v2_1 = v2_1.c;
                    v4_6 = 1;
                }
                if (v4_6 != 0) {
                    v0_3.delete((v0_3.length() - 2), v0_3.length());
                }
                v0_3.append(" )");
                return v0_3.toString();
            default:
                return super.toString();
        }
    }

    public Object u()
    {
        z2.c v0_1 = ((z2.c) this.h);
        z2.c v1 = v0_1.d;
        while(true) {
            z2.g v3_1 = v1.a;
            z2.c v4_1 = 0;
            if (v1.equals(v0_1)) {
                return 0;
            } else {
                java.util.HashMap v2_0;
                java.util.HashMap v2_6 = v1.b;
                if (v2_6 == null) {
                    v2_0 = 0;
                } else {
                    v2_0 = v2_6.size();
                }
                if (v2_0 > null) {
                    v4_1 = v1.b.remove((v2_0 - 1));
                }
                if (v4_1 != null) {
                    break;
                }
                java.util.HashMap v2_2 = v1.d;
                v2_2.c = v1.c;
                v1.c.d = v2_2;
                ((java.util.HashMap) this.i).remove(v3_1);
                ((z2.g) v3_1).a();
                v1 = v1.d;
            }
        }
        return v4_1;
    }

    public void v(w1.h1 p7)
    {
        p0.d v0_1 = ((t.g) this.i);
        int v1_0 = (v0_1.g() - 1);
        while (v1_0 >= 0) {
            if (p7 != v0_1.h(v1_0)) {
                v1_0--;
            } else {
                Object[] v3_0 = v0_1.i;
                Object v5 = t.h.a;
                if (v3_0[v1_0] == v5) {
                    break;
                }
                v3_0[v1_0] = v5;
                v0_1.g = 1;
                break;
            }
        }
        w1.r1 v7_2 = ((w1.r1) ((t.l) this.h).remove(p7));
        if (v7_2 != null) {
            v7_2.a = 0;
            v7_2.b = 0;
            v7_2.c = 0;
            w1.r1.d.b(v7_2);
        }
        return;
    }

    public void w(int p4, int p5, int p6, int p7)
    {
        s.a v0_1 = ((s.a) this.i);
        v0_1.j.set(p4, p5, p6, p7);
        int v1_2 = v0_1.i;
        s.a.a(v0_1, (p4 + v1_2.left), (p5 + v1_2.top), (p6 + v1_2.right), (p7 + v1_2.bottom));
        return;
    }
}
