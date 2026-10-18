// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.collections.builders;
public final class MapBuilder implements java.util.Map, java.io.Serializable, va.a {
    public static final kotlin.collections.builders.MapBuilder t;
    public Object[] g;
    public Object[] h;
    public int[] i;
    public int[] j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public ia.d p;
    public ia.e q;
    public ia.d r;
    public boolean s;

    static MapBuilder()
    {
        kotlin.collections.builders.MapBuilder v0_1 = new kotlin.collections.builders.MapBuilder(0);
        v0_1.s = 1;
        kotlin.collections.builders.MapBuilder.t = v0_1;
        return;
    }

    public MapBuilder()
    {
        this(8);
        return;
    }

    public MapBuilder(int p5)
    {
        if (p5 < 0) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("capacity must be non-negative.");
            throw 0;
        } else {
            int v0_3 = new Object[p5];
            int[] v1 = new int[p5];
            if (p5 < 1) {
                p5 = 1;
            }
            int v5_3 = Integer.highestOneBit((p5 * 3));
            int[] v3 = new int[v5_3];
            this.g = v0_3;
            this.h = 0;
            this.i = v1;
            this.j = v3;
            this.k = 2;
            this.l = 0;
            this.m = (Integer.numberOfLeadingZeros(v5_3) + 1);
            return;
        }
    }

    private final void readObject(java.io.ObjectInputStream p2)
    {
        throw new java.io.InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace()
    {
        if (!this.s) {
            throw new java.io.NotSerializableException("The map cannot be serialized while it is being built.");
        } else {
            java.io.NotSerializableException v0_4 = new kotlin.collections.builders.SerializedMap();
            v0_4.g = this;
            return v0_4;
        }
    }

    public final int a(Object p8)
    {
        this.c();
        while(true) {
            int v0_0 = this.i(p8);
            int v1_2 = (this.k * 2);
            int v2_3 = (this.j.length / 2);
            if (v1_2 > v2_3) {
                v1_2 = v2_3;
            }
            int v2_0 = 0;
            while(true) {
                int v3_0 = this.j;
                Object[] v4_0 = v3_0[v0_0];
                if (v4_0 == null) {
                    break;
                }
                if (!kotlin.jvm.internal.f.a(this.g[(v4_0 - 1)], p8)) {
                    v2_0++;
                    if (v2_0 <= v1_2) {
                        if (v0_0 != 0) {
                            v0_0--;
                        } else {
                            v0_0 = (this.j.length - 1);
                        }
                    } else {
                        this.j((this.j.length * 2));
                    }
                } else {
                    return (- v4_0);
                }
            }
        }
        int v1_1 = this.l;
        Object[] v4_1 = this.g;
        if (v1_1 < v4_1.length) {
            int v6_2 = (v1_1 + 1);
            this.l = v6_2;
            v4_1[v1_1] = p8;
            this.i[v1_1] = v0_0;
            v3_0[v0_0] = v6_2;
            this.o = (this.o + 1);
            this.n = (this.n + 1);
            if (v2_0 > this.k) {
                this.k = v2_0;
            }
            return v1_1;
        } else {
            this.f(1);
        }
    }

    public final kotlin.collections.builders.MapBuilder b()
    {
        this.c();
        this.s = 1;
        if (this.o <= 0) {
            kotlin.collections.builders.MapBuilder v0_2 = kotlin.collections.builders.MapBuilder.t;
            v0_2.getClass();
            return v0_2;
        } else {
            return this;
        }
    }

    public final void c()
    {
        if (this.s) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.v();
            return;
        } else {
            return;
        }
    }

    public final void clear()
    {
        this.c();
        int v0_3 = (this.l - 1);
        if (v0_3 >= 0) {
            int v2_2 = 0;
            while(true) {
                int[] v3 = this.i;
                int v4_1 = v3[v2_2];
                if (v4_1 >= 0) {
                    this.j[v4_1] = 0;
                    v3[v2_2] = -1;
                }
                if (v2_2 == v0_3) {
                    break;
                }
                v2_2++;
            }
        }
        g6.f0.p(this.g, 0, this.l);
        int v0_2 = this.h;
        if (v0_2 != 0) {
            g6.f0.p(v0_2, 0, this.l);
        }
        this.o = 0;
        this.l = 0;
        this.n = (this.n + 1);
        return;
    }

    public final boolean containsKey(Object p1)
    {
        if (this.g(p1) < 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public final boolean containsValue(Object p1)
    {
        if (this.h(p1) < 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public final void d(boolean p8)
    {
        Object[] v0 = this.h;
        int v1 = 0;
        int v2 = 0;
        while(true) {
            int[] v3_2 = this.l;
            if (v1 >= v3_2) {
                break;
            }
            int[] v3_0 = this.i;
            int v4 = v3_0[v1];
            if (v4 >= 0) {
                int v5_0 = this.g;
                v5_0[v2] = v5_0[v1];
                if (v0 != null) {
                    v0[v2] = v0[v1];
                }
                if (p8 != 0) {
                    v3_0[v2] = v4;
                    this.j[v4] = (v2 + 1);
                }
                v2++;
            }
            v1++;
        }
        g6.f0.p(this.g, v2, v3_2);
        if (v0 != null) {
            g6.f0.p(v0, v2, this.l);
        }
        this.l = v2;
        return;
    }

    public final boolean e(java.util.Collection p5)
    {
        p5.getClass();
        int v5_1 = p5.iterator();
        while (v5_1.hasNext()) {
            boolean v0_4 = v5_1.next();
            try {
                if (v0_4) {
                    boolean v0_2;
                    boolean v0_0 = ((java.util.Map$Entry) v0_4);
                    Object v2_1 = this.g(v0_0.getKey());
                    if (v2_1 >= null) {
                        Object[] v3 = this.h;
                        v3.getClass();
                        v0_2 = kotlin.jvm.internal.f.a(v3[v2_1], v0_0.getValue());
                    } else {
                        v0_2 = 0;
                    }
                    if (!v0_2) {
                    }
                }
                return 0;
            } catch (ClassCastException) {
                return 0;
            }
        }
        return 1;
    }

    public final java.util.Set entrySet()
    {
        ia.d v0_0 = this.r;
        if (v0_0 == null) {
            v0_0 = new ia.d(this, 0);
            this.r = v0_0;
        }
        return v0_0;
    }

    public final boolean equals(Object p3)
    {
        if ((p3 != this) && ((!(p3 instanceof java.util.Map)) || ((this.o != ((java.util.Map) p3).size()) || (!this.e(((java.util.Map) p3).entrySet()))))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final void f(int p6)
    {
        int v0_0 = this.g;
        int v2_1 = this.l;
        int v1_6 = (v0_0.length - v2_1);
        int v3_2 = (v2_1 - this.o);
        int v4_0 = 1;
        if ((v1_6 >= p6) || (((v1_6 + v3_2) < p6) || (v3_2 < (v0_0.length / 4)))) {
            int v2_0 = (v2_1 + p6);
            if (v2_0 < 0) {
                throw new OutOfMemoryError();
            } else {
                if (v2_0 > v0_0.length) {
                    int v6_4 = v0_0.length;
                    int v6_5 = (v6_4 + (v6_4 >> 1));
                    if ((v6_5 - v2_0) < 0) {
                        v6_5 = v2_0;
                    }
                    if ((v6_5 - 2147483639) > 0) {
                        if (v2_0 <= 2147483639) {
                            v6_5 = 2147483639;
                        } else {
                            v6_5 = 2147483647;
                        }
                    }
                    int v0_3;
                    this.g = java.util.Arrays.copyOf(v0_0, v6_5);
                    int v0_2 = this.h;
                    if (v0_2 == 0) {
                        v0_3 = 0;
                    } else {
                        v0_3 = java.util.Arrays.copyOf(v0_2, v6_5);
                    }
                    this.h = v0_3;
                    this.i = java.util.Arrays.copyOf(this.i, v6_5);
                    if (v6_5 >= 1) {
                        v4_0 = v6_5;
                    }
                    int v6_6 = Integer.highestOneBit((v4_0 * 3));
                    if (v6_6 > this.j.length) {
                        this.j(v6_6);
                    }
                }
                return;
            }
        } else {
            this.d(1);
            return;
        }
    }

    public final int g(Object p6)
    {
        int v0_0 = this.i(p6);
        int v1 = this.k;
        while(true) {
            int v2_2 = this.j[v0_0];
            if (v2_2 != 0) {
                int v2_3 = (v2_2 - 1);
                if (!kotlin.jvm.internal.f.a(this.g[v2_3], p6)) {
                    v1 += -1;
                    if (v1 < 0) {
                        break;
                    }
                    if (v0_0 != 0) {
                        v0_0--;
                    } else {
                        v0_0 = (this.j.length - 1);
                    }
                } else {
                    return v2_3;
                }
            } else {
                return -1;
            }
        }
        return -1;
    }

    public final Object get(Object p2)
    {
        Object v2_1 = this.g(p2);
        if (v2_1 >= null) {
            Object[] v0 = this.h;
            v0.getClass();
            return v0[v2_1];
        } else {
            return 0;
        }
    }

    public final int h(Object p3)
    {
        int v0 = this.l;
        do {
            v0 += -1;
            if (v0 < 0) {
                return -1;
            } else {
                if (this.i[v0] >= 0) {
                    boolean v1_5 = this.h;
                    v1_5.getClass();
                }
            }
        } while(!kotlin.jvm.internal.f.a(v1_5[v0], p3));
        return v0;
    }

    public final int hashCode()
    {
        int v0_2 = new ia.b(this, 0);
        int v2 = 0;
        while (v0_2.hasNext()) {
            int v3_4 = v0_2.g;
            int v4_0 = ((kotlin.collections.builders.MapBuilder) v0_2.j);
            if (v3_4 >= v4_0.l) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.c();
                return 0;
            } else {
                int v3_1;
                v0_2.g = (v3_4 + 1);
                v0_2.h = v3_4;
                int v3_0 = v4_0.g[v3_4];
                if (v3_0 == 0) {
                    v3_1 = 0;
                } else {
                    v3_1 = v3_0.hashCode();
                }
                int v4_3;
                int v4_1 = v4_0.h;
                v4_1.getClass();
                int v4_2 = v4_1[v0_2.h];
                if (v4_2 == 0) {
                    v4_3 = 0;
                } else {
                    v4_3 = v4_2.hashCode();
                }
                int v3_2 = (v3_1 ^ v4_3);
                v0_2.e();
                v2 += v3_2;
            }
        }
        return v2;
    }

    public final int i(Object p2)
    {
        int v2_1;
        if (p2 == 0) {
            v2_1 = 0;
        } else {
            v2_1 = p2.hashCode();
        }
        return ((v2_1 * -1640531527) >> this.m);
    }

    public final boolean isEmpty()
    {
        if (this.o != 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public final void j(int p6)
    {
        this.n = (this.n + 1);
        int v2 = 0;
        if (this.l > this.o) {
            this.d(0);
        }
        int v0_7 = new int[p6];
        this.j = v0_7;
        this.m = (Integer.numberOfLeadingZeros(p6) + 1);
        while (v2 < this.l) {
            String v6_4 = (v2 + 1);
            int v0_4 = this.i(this.g[v2]);
            int v1_0 = this.k;
            while(true) {
                int[] v3 = this.j;
                if (v3[v0_4] != 0) {
                    v1_0--;
                    if (v1_0 < 0) {
                        break;
                    }
                    if (v0_4 != 0) {
                        v0_4--;
                    } else {
                        v0_4 = (v3.length - 1);
                    }
                } else {
                    v3[v0_4] = v6_4;
                    this.i[v2] = v0_4;
                    v2 = v6_4;
                }
                return;
            }
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.w("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            break;
        }
        return;
    }

    public final void k(int p10)
    {
        int[] v0_0 = this.g;
        v0_0.getClass();
        v0_0[p10] = 0;
        int[] v0_4 = this.h;
        if (v0_4 != null) {
            v0_4[p10] = 0;
        }
        int[] v0_1 = this.i[p10];
        while(true) {
            int v2 = v0_1;
            int[] v3_0 = 0;
            if (v0_1 != null) {
                v0_1--;
            } else {
                v0_1 = (this.j.length - 1);
            }
            int v4_1 = this.j;
            int v5 = v4_1[v0_1];
            v3_0++;
            if (v3_0 <= this.k) {
                if (v5 == 0) {
                    break;
                }
                int v6_1 = (v5 - 1);
                int[] v7 = this.j;
                if (((this.i(this.g[v6_1]) - v0_1) & (v7.length - 1)) >= v3_0) {
                    v7[v2] = v5;
                    this.i[v6_1] = v2;
                } else {
                    do {
                    } while(((this.i(this.g[v6_1]) - v0_1) & (v7.length - 1)) >= v3_0);
                }
            } else {
                v4_1[v2] = 0;
            }
            this.i[p10] = -1;
            this.o = (this.o + -1);
            this.n = (this.n + 1);
            return;
        }
        v4_1[v2] = 0;
        this.i[p10] = -1;
        this.o = (this.o + -1);
        this.n = (this.n + 1);
        return;
    }

    public final java.util.Set keySet()
    {
        ia.d v0_0 = this.p;
        if (v0_0 == null) {
            v0_0 = new ia.d(this, 1);
            this.p = v0_0;
        }
        return v0_0;
    }

    public final Object put(Object p3, Object p4)
    {
        this.c();
        int v3_4 = this.a(p3);
        Object[] v0_0 = this.h;
        if (v0_0 == null) {
            Object[] v0_2 = this.g.length;
            if (v0_2 < null) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("capacity must be non-negative.");
            } else {
                v0_0 = new Object[v0_2];
                this.h = v0_0;
                if (v3_4 >= 0) {
                    v0_0[v3_4] = p4;
                } else {
                    int v3_3 = ((- v3_4) - 1);
                    Object v1 = v0_0[v3_3];
                    v0_0[v3_3] = p4;
                    return v1;
                }
            }
        }
        return 0;
    }

    public final void putAll(java.util.Map p6)
    {
        p6.getClass();
        this.c();
        String v6_3 = p6.entrySet();
        if (!v6_3.isEmpty()) {
            this.f(v6_3.size());
            String v6_1 = v6_3.iterator();
            while (v6_1.hasNext()) {
                Object v0_2 = ((java.util.Map$Entry) v6_1.next());
                int v1_1 = this.a(v0_2.getKey());
                Object[] v2_0 = this.h;
                if (v2_0 == null) {
                    Object[] v2_2 = this.g.length;
                    if (v2_2 < null) {
                        com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("capacity must be non-negative.");
                        break;
                    } else {
                        v2_0 = new Object[v2_2];
                        this.h = v2_0;
                    }
                }
                if (v1_1 < 0) {
                    int v1_3 = ((- v1_1) - 1);
                    if (!kotlin.jvm.internal.f.a(v0_2.getValue(), v2_0[v1_3])) {
                        v2_0[v1_3] = v0_2.getValue();
                    }
                } else {
                    v2_0[v1_1] = v0_2.getValue();
                }
            }
        }
        return;
    }

    public final Object remove(Object p2)
    {
        this.c();
        int v2_1 = this.g(p2);
        if (v2_1 >= 0) {
            Object v0_0 = this.h;
            v0_0.getClass();
            Object v0_1 = v0_0[v2_1];
            this.k(v2_1);
            return v0_1;
        } else {
            return 0;
        }
    }

    public final int size()
    {
        return this.o;
    }

    public final String toString()
    {
        int v0_3 = new StringBuilder(((this.o * 3) + 2));
        v0_3.append("{");
        int v2 = 0;
        String v1_6 = new ia.b(this, 0);
        while (v1_6.hasNext()) {
            if (v2 > 0) {
                v0_3.append(", ");
            }
            Object v3_2 = v1_6.g;
            kotlin.collections.builders.MapBuilder v4_1 = ((kotlin.collections.builders.MapBuilder) v1_6.j);
            if (v3_2 >= v4_1.l) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.c();
                return 0;
            } else {
                v1_6.g = (v3_2 + 1);
                v1_6.h = v3_2;
                Object v3_3 = v4_1.g[v3_2];
                if (v3_3 != v4_1) {
                    v0_3.append(v3_3);
                } else {
                    v0_3.append("(this Map)");
                }
                v0_3.append(61);
                Object v3_5 = v4_1.h;
                v3_5.getClass();
                Object v3_6 = v3_5[v1_6.h];
                if (v3_6 != v4_1) {
                    v0_3.append(v3_6);
                } else {
                    v0_3.append("(this Map)");
                }
                v1_6.e();
                v2++;
            }
        }
        v0_3.append("}");
        return v0_3.toString();
    }

    public final java.util.Collection values()
    {
        ia.e v0_0 = this.q;
        if (v0_0 == null) {
            v0_0 = new ia.e(this);
            this.q = v0_0;
        }
        return v0_0;
    }
}
