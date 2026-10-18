// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ha;
public final class h extends ha.e {
    public static final Object[] j;
    public int g;
    public Object[] h;
    public int i;

    static h()
    {
        Object[] v0_1 = new Object[0];
        ha.h.j = v0_1;
        return;
    }

    public h()
    {
        this.h = ha.h.j;
        return;
    }

    public h(int p2)
    {
        int v2_1;
        if (p2 != 0) {
            if (p2 <= 0) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u(r1.a.g(p2, "Illegal Capacity: "));
                throw 0;
            } else {
                v2_1 = new Object[p2];
            }
        } else {
            v2_1 = ha.h.j;
        }
        this.h = v2_1;
        return;
    }

    public final int a()
    {
        return this.i;
    }

    public final void add(int p8, Object p9)
    {
        int v0_0 = this.i;
        if ((p8 < 0) || (p8 > v0_0)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.l("index: ", ", size: ", p8, v0_0));
            return;
        } else {
            if (p8 != v0_0) {
                if (p8 != 0) {
                    this.l();
                    this.e((this.i + 1));
                    int v0_5 = this.k((this.g + p8));
                    Object[] v2_0 = this.i;
                    if (p8 >= ((v2_0 + 1) >> 1)) {
                        int v8_2 = this.k((v2_0 + this.g));
                        Object[] v2_2 = this.h;
                        if (v0_5 >= v8_2) {
                            ha.i.I(1, 0, v8_2, v2_2, v2_2);
                            int v8_3 = this.h;
                            v8_3[0] = v8_3[(v8_3.length - 1)];
                            ha.i.I((v0_5 + 1), v0_5, (v8_3.length - 1), v8_3, v8_3);
                        } else {
                            ha.i.I((v0_5 + 1), v0_5, v8_2, v2_2, v2_2);
                        }
                        this.h[v0_5] = p9;
                    } else {
                        int v8_5;
                        if (v0_5 != 0) {
                            v8_5 = (v0_5 - 1);
                        } else {
                            int v8_6 = this.h;
                            v8_6.getClass();
                            v8_5 = (v8_6.length - 1);
                        }
                        int v0_6 = this.g;
                        if (v0_6 == 0) {
                            int v0_7 = this.h;
                            v0_7.getClass();
                            v0_6 = v0_7.length;
                        }
                        int v0_8 = (v0_6 - 1);
                        Object[] v2_7 = this.g;
                        int v3_5 = this.h;
                        if (v8_5 < v2_7) {
                            ha.i.I((v2_7 - 1), v2_7, v3_5.length, v3_5, v3_5);
                            Object[] v2_8 = this.h;
                            v2_8[(v2_8.length - 1)] = v2_8[0];
                            ha.i.I(0, 1, (v8_5 + 1), v2_8, v2_8);
                        } else {
                            v3_5[v0_8] = v3_5[v2_7];
                            ha.i.I(v2_7, (v2_7 + 1), (v8_5 + 1), v3_5, v3_5);
                        }
                        this.h[v8_5] = p9;
                        this.g = v0_8;
                    }
                    this.i = (this.i + 1);
                    return;
                } else {
                    this.addFirst(p9);
                    return;
                }
            } else {
                this.addLast(p9);
                return;
            }
        }
    }

    public final boolean add(Object p1)
    {
        this.addLast(p1);
        return 1;
    }

    public final boolean addAll(int p9, java.util.Collection p10)
    {
        p10.getClass();
        Object[] v0_0 = this.i;
        if ((p9 < 0) || (p9 > v0_0)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.l("index: ", ", size: ", p9, v0_0));
            return 0;
        } else {
            if (!p10.isEmpty()) {
                if (p9 != this.i) {
                    this.l();
                    this.e((p10.size() + this.i));
                    Object[] v0_5 = this.k((this.i + this.g));
                    int v2_7 = this.k((this.g + p9));
                    int v3_0 = p10.size();
                    if (p9 >= ((this.i + 1) >> 1)) {
                        int v9_4 = (v2_7 + v3_0);
                        int v4_5 = this.h;
                        if (v2_7 >= v0_5) {
                            ha.i.I(v3_0, 0, v0_5, v4_5, v4_5);
                            Object[] v0_6 = this.h;
                            if (v9_4 < v0_6.length) {
                                ha.i.I(0, (v0_6.length - v3_0), v0_6.length, v0_6, v0_6);
                                Object[] v0_7 = this.h;
                                ha.i.I(v9_4, v2_7, (v0_7.length - v3_0), v0_7, v0_7);
                            } else {
                                ha.i.I((v9_4 - v0_6.length), v2_7, v0_6.length, v0_6, v0_6);
                            }
                        } else {
                            int v3_1 = (v3_0 + v0_5);
                            if (v3_1 > v4_5.length) {
                                if (v9_4 < v4_5.length) {
                                    int v3_3 = (v0_5 - (v3_1 - v4_5.length));
                                    ha.i.I(0, v3_3, v0_5, v4_5, v4_5);
                                    ha.i.I(v9_4, v2_7, v3_3, this.h, this.h);
                                } else {
                                    ha.i.I((v9_4 - v4_5.length), v2_7, v0_5, v4_5, v4_5);
                                }
                            } else {
                                ha.i.I(v9_4, v2_7, v0_5, v4_5, v4_5);
                            }
                        }
                        this.c(v2_7, p10);
                        return 1;
                    } else {
                        int v9_8 = this.g;
                        Object[] v0_9 = (v9_8 - v3_0);
                        int v4_9 = this.h;
                        if (v2_7 < v9_8) {
                            ha.i.I(v0_9, v9_8, v4_9.length, v4_9, v4_9);
                            int v9_9 = this.h;
                            if (v3_0 < v2_7) {
                                ha.i.I((v9_9.length - v3_0), 0, v3_0, v9_9, v9_9);
                                ha.i.I(0, v3_0, v2_7, this.h, this.h);
                            } else {
                                ha.i.I((v9_9.length - v3_0), 0, v2_7, v9_9, v9_9);
                            }
                        } else {
                            if (v0_9 < null) {
                                v0_9 += v4_9.length;
                                int v7_1 = (v4_9.length - v0_9);
                                if (v7_1 < (v2_7 - v9_8)) {
                                    ha.i.I(v0_9, v9_8, (v9_8 + v7_1), v4_9, v4_9);
                                    ha.i.I(0, (this.g + v7_1), v2_7, this.h, this.h);
                                } else {
                                    ha.i.I(v0_9, v9_8, v2_7, v4_9, v4_9);
                                }
                            } else {
                                ha.i.I(v0_9, v9_8, v2_7, v4_9, v4_9);
                            }
                        }
                        this.g = v0_9;
                        this.c(this.g((v2_7 - v3_0)), p10);
                        return 1;
                    }
                } else {
                    return this.addAll(p10);
                }
            } else {
                return 0;
            }
        }
    }

    public final boolean addAll(java.util.Collection p3)
    {
        p3.getClass();
        if (!p3.isEmpty()) {
            this.l();
            this.e((p3.size() + this.a()));
            this.c(this.k((this.a() + this.g)), p3);
            return 1;
        } else {
            return 0;
        }
    }

    public final void addFirst(Object p3)
    {
        this.l();
        this.e((this.i + 1));
        int v0_2 = this.g;
        if (v0_2 == 0) {
            int v0_3 = this.h;
            v0_3.getClass();
            v0_2 = v0_3.length;
        }
        int v0_4 = (v0_2 - 1);
        this.g = v0_4;
        this.h[v0_4] = p3;
        this.i = (this.i + 1);
        return;
    }

    public final void addLast(Object p4)
    {
        this.l();
        this.e((this.a() + 1));
        Object[] v0_2 = this.h;
        this.k((this.a() + this.g))[int v1_0] = p4;
        this.i = (this.a() + 1);
        return;
    }

    public final Object b(int p9)
    {
        Object[] v0_0 = this.i;
        if ((p9 < 0) || (p9 >= v0_0)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.l("index: ", ", size: ", p9, v0_0));
            return 0;
        } else {
            if (p9 != (this.a() - 1)) {
                if (p9 != 0) {
                    this.l();
                    Object[] v0_5 = this.k((this.g + p9));
                    int v2_0 = this.h;
                    Object v3 = v2_0[v0_5];
                    int v5_0 = this.g;
                    if (p9 >= (this.i >> 1)) {
                        int v9_4 = this.k(((this.a() - 1) + v5_0));
                        int v2_1 = this.h;
                        if (v0_5 > v9_4) {
                            ha.i.I(v0_5, (v0_5 + 1), v2_1.length, v2_1, v2_1);
                            Object[] v0_6 = this.h;
                            v0_6[(v0_6.length - 1)] = v0_6[0];
                            ha.i.I(0, 1, (v9_4 + 1), v0_6, v0_6);
                        } else {
                            ha.i.I(v0_5, (v0_5 + 1), (v9_4 + 1), v2_1, v2_1);
                        }
                        this.h[v9_4] = 0;
                    } else {
                        if (v0_5 < v5_0) {
                            ha.i.I(1, 0, v0_5, v2_0, v2_0);
                            int v9_5 = this.h;
                            v9_5[0] = v9_5[(v9_5.length - 1)];
                            Object[] v0_11 = this.g;
                            ha.i.I((v0_11 + 1), v0_11, (v9_5.length - 1), v9_5, v9_5);
                        } else {
                            ha.i.I((v5_0 + 1), v5_0, v0_5, v2_0, v2_0);
                        }
                        Object[] v0_12 = this.g;
                        this.h[v0_12] = 0;
                        this.g = this.f(v0_12);
                    }
                    this.i = (this.i - 1);
                    return v3;
                } else {
                    return this.removeFirst();
                }
            } else {
                return this.removeLast();
            }
        }
    }

    public final void c(int p5, java.util.Collection p6)
    {
        java.util.Iterator v0 = p6.iterator();
        int v1_2 = this.h.length;
        while ((p5 < v1_2) && (v0.hasNext())) {
            this.h[p5] = v0.next();
            p5++;
        }
        int v5_2 = this.g;
        int v1_1 = 0;
        while ((v1_1 < v5_2) && (v0.hasNext())) {
            this.h[v1_1] = v0.next();
            v1_1++;
        }
        this.i = (p6.size() + this.i);
        return;
    }

    public final void clear()
    {
        if (!this.isEmpty()) {
            this.l();
            this.j(this.g, this.k((this.a() + this.g)));
        }
        this.g = 0;
        this.i = 0;
        return;
    }

    public final boolean contains(Object p2)
    {
        if (this.indexOf(p2) == -1) {
            return 0;
        } else {
            return 1;
        }
    }

    public final void e(int p5)
    {
        if (p5 < null) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("Deque is too big.");
            return;
        } else {
            Object[] v0_2 = this.h;
            if (p5 > v0_2.length) {
                if (v0_2 != ha.h.j) {
                    int v1_6 = v0_2.length;
                    int v1_0 = (v1_6 + (v1_6 >> 1));
                    if ((v1_0 - p5) < 0) {
                        v1_0 = p5;
                    }
                    if ((v1_0 - 2147483639) > 0) {
                        if (p5 <= 2147483639) {
                            v1_0 = 2147483639;
                        } else {
                            v1_0 = 2147483647;
                        }
                    }
                    Object[] v5_2 = new Object[v1_0];
                    ha.i.I(0, this.g, v0_2.length, v0_2, v5_2);
                    Object[] v0_0 = this.h;
                    int v2_4 = this.g;
                    ha.i.I((v0_0.length - v2_4), 0, v2_4, v0_0, v5_2);
                    this.g = 0;
                    this.h = v5_2;
                    return;
                } else {
                    if (p5 < 10) {
                        p5 = 10;
                    }
                    Object[] v5_3 = new Object[p5];
                    this.h = v5_3;
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final int f(int p2)
    {
        int v0_0 = this.h;
        v0_0.getClass();
        if (p2 != (v0_0.length - 1)) {
            return (p2 + 1);
        } else {
            return 0;
        }
    }

    public final int g(int p2)
    {
        if (p2 < 0) {
            p2 += this.h.length;
        }
        return p2;
    }

    public final Object get(int p4)
    {
        Object[] v0_0 = this.a();
        if ((p4 < null) || (p4 >= v0_0)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.l("index: ", ", size: ", p4, v0_0));
            return 0;
        } else {
            return this.h[this.k((this.g + p4))];
        }
    }

    public final int indexOf(Object p5)
    {
        int v5_3;
        int v0_1 = this.k((this.a() + this.g));
        int v1_0 = this.g;
        if (v1_0 >= v0_1) {
            if (this.isEmpty()) {
                return -1;
            } else {
                v1_0 = this.g;
                if (v1_0 < v0_1) {
                    return -1;
                }
                while (v1_0 < this.h.length) {
                    if (!kotlin.jvm.internal.f.a(p5, this.h[v1_0])) {
                        v1_0++;
                    } else {
                        v5_3 = this.g;
                    }
                }
                int v1_1 = 0;
                while (v1_1 < v0_1) {
                    if (!kotlin.jvm.internal.f.a(p5, this.h[v1_1])) {
                        v1_1++;
                    } else {
                        v1_0 = (v1_1 + this.h.length);
                        v5_3 = this.g;
                    }
                }
                return -1;
            }
        } else {
            while (v1_0 < v0_1) {
                if (!kotlin.jvm.internal.f.a(p5, this.h[v1_0])) {
                    v1_0++;
                } else {
                    v5_3 = this.g;
                }
            }
            return -1;
        }
        return (v1_0 - v5_3);
    }

    public final boolean isEmpty()
    {
        if (this.a() != 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public final void j(int p4, int p5)
    {
        int v0_0 = this.h;
        if (p4 >= p5) {
            java.util.Arrays.fill(v0_0, p4, v0_0.length, 0);
            ha.i.N(this.h, 0, p5);
            return;
        } else {
            ha.i.N(v0_0, p4, p5);
            return;
        }
    }

    public final int k(int p3)
    {
        int v0_0 = this.h;
        if (p3 >= v0_0.length) {
            p3 -= v0_0.length;
        }
        return p3;
    }

    public final void l()
    {
        this.modCount = (this.modCount + 1);
        return;
    }

    public final int lastIndexOf(Object p5)
    {
        int v0_3;
        int v5_1;
        int v0_4 = this.k((this.i + this.g));
        int v1_7 = this.g;
        if (v1_7 >= v0_4) {
            if ((this.isEmpty()) || (this.g < v0_4)) {
                return -1;
            } else {
                int v0_1 = (v0_4 - 1);
                while(true) {
                    int v1_2 = this.h;
                    if (-1 >= v0_1) {
                        break;
                    }
                    if (!kotlin.jvm.internal.f.a(p5, v1_2[v0_1])) {
                        v0_1--;
                    } else {
                        v0_3 = (v0_1 + this.h.length);
                        v5_1 = this.g;
                    }
                }
                v1_2.getClass();
                v0_3 = (v1_2.length - 1);
                int v1_3 = this.g;
                if (v1_3 > v0_3) {
                    return -1;
                }
                while (!kotlin.jvm.internal.f.a(p5, this.h[v0_3])) {
                    if (v0_3 == v1_3) {
                        return -1;
                    } else {
                        v0_3--;
                    }
                }
                v5_1 = this.g;
            }
        } else {
            v0_3 = (v0_4 - 1);
            if (v1_7 > v0_3) {
                return -1;
            }
            while (!kotlin.jvm.internal.f.a(p5, this.h[v0_3])) {
                if (v0_3 == v1_7) {
                    return -1;
                } else {
                    v0_3--;
                }
            }
            v5_1 = this.g;
        }
        return (v0_3 - v5_1);
    }

    public final boolean remove(Object p2)
    {
        int v2_1 = this.indexOf(p2);
        if (v2_1 != -1) {
            this.b(v2_1);
            return 1;
        } else {
            return 0;
        }
    }

    public final boolean removeAll(java.util.Collection p11)
    {
        p11.getClass();
        int v1 = 0;
        if ((!this.isEmpty()) && (this.h.length != 0)) {
            int v4_2;
            int v0_0 = this.k((this.i + this.g));
            Object[] v2_1 = this.g;
            if (v2_1 >= v0_0) {
                int v4_1 = this.h.length;
                int v6_0 = 0;
                Object v5_0 = v2_1;
                while (v2_1 < v4_1) {
                    int v8_0 = this.h;
                    Object v9 = v8_0[v2_1];
                    v8_0[v2_1] = 0;
                    if (p11.contains(v9)) {
                        v6_0 = 1;
                    } else {
                        int v8_1 = (v5_0 + 1);
                        this.h[v5_0] = v9;
                        v5_0 = v8_1;
                    }
                    v2_1++;
                }
                v4_2 = this.k(v5_0);
                while (v1 < v0_0) {
                    Object[] v2_3 = this.h;
                    Object v5_1 = v2_3[v1];
                    v2_3[v1] = 0;
                    if (p11.contains(v5_1)) {
                        v6_0 = 1;
                    } else {
                        this.h[v4_2] = v5_1;
                        v4_2 = this.f(v4_2);
                    }
                    v1++;
                }
                v1 = v6_0;
            } else {
                v4_2 = v2_1;
                while(true) {
                    Object v5_2 = this.h;
                    if (v2_1 >= v0_0) {
                        break;
                    }
                    Object v5_3 = v5_2[v2_1];
                    if (p11.contains(v5_3)) {
                        v1 = 1;
                    } else {
                        Object[] v7_3 = (v4_2 + 1);
                        this.h[v4_2] = v5_3;
                        v4_2 = v7_3;
                    }
                    v2_1++;
                }
                ha.i.N(v5_2, v4_2, v0_0);
            }
            if (v1 != 0) {
                this.l();
                this.i = this.g((v4_2 - this.g));
            }
        }
        return v1;
    }

    public final Object removeFirst()
    {
        if (this.isEmpty()) {
            throw new java.util.NoSuchElementException("ArrayDeque is empty.");
        } else {
            this.l();
            java.util.NoSuchElementException v0_6 = this.h;
            String v1_1 = this.g;
            Object v2 = v0_6[v1_1];
            v0_6[v1_1] = 0;
            this.g = this.f(v1_1);
            this.i = (this.a() - 1);
            return v2;
        }
    }

    public final Object removeLast()
    {
        if (this.isEmpty()) {
            throw new java.util.NoSuchElementException("ArrayDeque is empty.");
        } else {
            this.l();
            java.util.NoSuchElementException v0_1 = this.k(((this.size() - 1) + this.g));
            String v1_3 = this.h;
            Object v2 = v1_3[v0_1];
            v1_3[v0_1] = 0;
            this.i = (this.a() - 1);
            return v2;
        }
    }

    public final void removeRange(int p8, int p9)
    {
        a.a.d(p8, p9, this.i);
        int v0_1 = (p9 - p8);
        if (v0_1 != 0) {
            if (v0_1 != this.i) {
                if (v0_1 != 1) {
                    this.l();
                    Object[] v3_0 = this.g;
                    if (p8 >= (this.i - p9)) {
                        int v1_0 = this.k((v3_0 + p9));
                        int v8_1 = this.k((this.g + p8));
                        int v2_3 = this.i;
                        while(true) {
                            v2_3 -= p9;
                            if (v2_3 <= 0) {
                                break;
                            }
                            int v9_5 = this.h;
                            p9 = Math.min(v2_3, Math.min((v9_5.length - v1_0), (v9_5.length - v8_1)));
                            int v4_0 = (v1_0 + p9);
                            ha.i.I(v8_1, v1_0, v4_0, this.h, this.h);
                            v1_0 = this.k(v4_0);
                            v8_1 = this.k((v8_1 + p9));
                        }
                        int v8_3 = this.k((this.i + this.g));
                        this.j(this.g((v8_3 - v0_1)), v8_3);
                    } else {
                        int v2_6 = this.k(((p8 - 1) + v3_0));
                        int v9_10 = this.k((this.g + (p9 - 1)));
                        while (p8 > 0) {
                            int v1_5 = (v2_6 + 1);
                            Object[] v3_7 = Math.min(p8, Math.min(v1_5, (v9_10 + 1)));
                            int v9_12 = (v9_10 - v3_7);
                            int v2_7 = (v2_6 - v3_7);
                            ha.i.I((v9_12 + 1), (v2_7 + 1), v1_5, this.h, this.h);
                            v2_6 = this.g(v2_7);
                            v9_10 = this.g(v9_12);
                            p8 -= v3_7;
                        }
                        int v8_7 = this.k((this.g + v0_1));
                        this.j(this.g, v8_7);
                        this.g = v8_7;
                    }
                    this.i = (this.i - v0_1);
                    return;
                } else {
                    this.b(p8);
                    return;
                }
            } else {
                this.clear();
                return;
            }
        } else {
            return;
        }
    }

    public final boolean retainAll(java.util.Collection p11)
    {
        p11.getClass();
        int v1 = 0;
        if ((!this.isEmpty()) && (this.h.length != 0)) {
            int v4_2;
            int v0_0 = this.k((this.i + this.g));
            Object[] v2_1 = this.g;
            if (v2_1 >= v0_0) {
                int v4_1 = this.h.length;
                int v6_0 = 0;
                Object v5_0 = v2_1;
                while (v2_1 < v4_1) {
                    int v8_0 = this.h;
                    Object v9 = v8_0[v2_1];
                    v8_0[v2_1] = 0;
                    if (!p11.contains(v9)) {
                        v6_0 = 1;
                    } else {
                        int v8_1 = (v5_0 + 1);
                        this.h[v5_0] = v9;
                        v5_0 = v8_1;
                    }
                    v2_1++;
                }
                v4_2 = this.k(v5_0);
                while (v1 < v0_0) {
                    Object[] v2_3 = this.h;
                    Object v5_1 = v2_3[v1];
                    v2_3[v1] = 0;
                    if (!p11.contains(v5_1)) {
                        v6_0 = 1;
                    } else {
                        this.h[v4_2] = v5_1;
                        v4_2 = this.f(v4_2);
                    }
                    v1++;
                }
                v1 = v6_0;
            } else {
                v4_2 = v2_1;
                while(true) {
                    Object v5_2 = this.h;
                    if (v2_1 >= v0_0) {
                        break;
                    }
                    Object v5_3 = v5_2[v2_1];
                    if (!p11.contains(v5_3)) {
                        v1 = 1;
                    } else {
                        Object[] v7_3 = (v4_2 + 1);
                        this.h[v4_2] = v5_3;
                        v4_2 = v7_3;
                    }
                    v2_1++;
                }
                ha.i.N(v5_2, v4_2, v0_0);
            }
            if (v1 != 0) {
                this.l();
                this.i = this.g((v4_2 - this.g));
            }
        }
        return v1;
    }

    public final Object set(int p3, Object p4)
    {
        Object[] v0_0 = this.a();
        if ((p3 < 0) || (p3 >= v0_0)) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.r(r1.a.l("index: ", ", size: ", p3, v0_0));
            return 0;
        } else {
            int v3_1 = this.k((this.g + p3));
            Object[] v0_3 = this.h;
            Object v1_0 = v0_3[v3_1];
            v0_3[v3_1] = p4;
            return v1_0;
        }
    }

    public final Object[] toArray()
    {
        Object[] v0_1 = new Object[this.a()];
        return this.toArray(v0_1);
    }

    public final Object[] toArray(Object[] p6)
    {
        p6.getClass();
        int v1_3 = this.i;
        if (p6.length < v1_3) {
            Object[] v6_3 = reflect.Array.newInstance(p6.getClass().getComponentType(), v1_3);
            v6_3.getClass();
            p6 = ((Object[]) v6_3);
        }
        int v0_2 = this.k((this.i + this.g));
        int v1_2 = this.g;
        if (v1_2 >= v0_2) {
            if (!this.isEmpty()) {
                int v1_5 = this.h;
                ha.i.I(0, this.g, v1_5.length, v1_5, p6);
                int v1_6 = this.h;
                ha.i.I((v1_6.length - this.g), 0, v0_2, v1_6, p6);
            }
        } else {
            ha.i.K(v1_2, v0_2, 2, this.h, p6);
        }
        int v0_3 = this.i;
        if (v0_3 < p6.length) {
            p6[v0_3] = 0;
        }
        return p6;
    }
}
