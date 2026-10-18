// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.jvm.internal;
public final class b implements bb.c, kotlin.jvm.internal.a {
    public static final java.util.Map h;
    public final Class g;

    static b()
    {
        Class v3 = ua.p;
        kotlin.Pair v5 = ua.r;
        Class v7 = ua.t;
        Class v9 = ua.v;
        Class v11 = ua.b;
        Class v13 = ua.d;
        Class v15 = ua.f;
        Class v17 = ua.h;
        Class v19 = ua.j;
        Class v21 = ua.m;
        int v0_1 = ha.k.u(new Class[] {ua.a, ua.o}));
        java.util.ArrayList v1_2 = new java.util.ArrayList(ha.l.y(v0_1, 10));
        int v0_2 = v0_1.iterator();
        int v2_2 = 0;
        while (v0_2.hasNext()) {
            Class v3_1 = v0_2.next();
            int v4 = (v2_2 + 1);
            if (v2_2 < 0) {
                ha.k.x();
                throw 0;
            } else {
                v1_2.add(new kotlin.Pair(((Class) v3_1), Integer.valueOf(v2_2)));
                v2_2 = v4;
            }
        }
        kotlin.jvm.internal.b.h = kotlin.collections.a.M(v1_2);
        return;
    }

    public b(Class p1)
    {
        p1.getClass();
        this.g = p1;
        return;
    }

    public final Class a()
    {
        return this.g;
    }

    public final String b()
    {
        String v0_0 = this.g;
        v0_0.getClass();
        String v2 = 0;
        if ((!v0_0.isAnonymousClass()) && (!v0_0.isLocalClass())) {
            if (!v0_0.isArray()) {
                String v1_2 = kotlin.jvm.internal.f.b(v0_0.getName());
                if (v1_2 != null) {
                    return v1_2;
                } else {
                    return v0_0.getCanonicalName();
                }
            } else {
                String v0_2 = v0_0.getComponentType();
                if (v0_2.isPrimitive()) {
                    String v0_4 = kotlin.jvm.internal.f.b(v0_2.getName());
                    if (v0_4 != null) {
                        v2 = v0_4.concat("Array");
                    }
                }
                if (v2 != null) {
                    return v2;
                } else {
                    return "kotlin.Array";
                }
            }
        } else {
            return 0;
        }
    }

    public final String c()
    {
        String v0_0 = this.g;
        v0_0.getClass();
        String v2_0 = 0;
        if (!v0_0.isAnonymousClass()) {
            if (!v0_0.isLocalClass()) {
                if (!v0_0.isArray()) {
                    String v1_2 = kotlin.jvm.internal.f.f(v0_0.getName());
                    if (v1_2 != null) {
                        return v1_2;
                    } else {
                        return v0_0.getSimpleName();
                    }
                } else {
                    String v0_2 = v0_0.getComponentType();
                    if (v0_2.isPrimitive()) {
                        String v0_4 = kotlin.jvm.internal.f.f(v0_2.getName());
                        if (v0_4 != null) {
                            v2_0 = v0_4.concat("Array");
                        }
                    }
                    if (v2_0 != null) {
                        return v2_0;
                    } else {
                        return "Array";
                    }
                }
            } else {
                String v1_5 = v0_0.getSimpleName();
                String v2_1 = v0_0.getEnclosingMethod();
                if (v2_1 == null) {
                    String v0_5 = v0_0.getEnclosingConstructor();
                    if (v0_5 == null) {
                        String v0_7 = db.i.X(v1_5, 36, 0, 6);
                        if (v0_7 != -1) {
                            return v1_5.substring((v0_7 + 1), v1_5.length());
                        } else {
                            return v1_5;
                        }
                    } else {
                        String v2_6 = new StringBuilder();
                        v2_6.append(v0_5.getName());
                        v2_6.append(36);
                        return db.i.l0(v1_5, v2_6.toString(), v1_5);
                    }
                } else {
                    String v0_14 = new StringBuilder();
                    v0_14.append(v2_1.getName());
                    v0_14.append(36);
                    return db.i.l0(v1_5, v0_14.toString(), v1_5);
                }
            }
        } else {
            return 0;
        }
    }

    public final boolean d(Object p3)
    {
        Class v0_0 = this.g;
        v0_0.getClass();
        boolean v1_0 = kotlin.jvm.internal.b.h;
        v1_0.getClass();
        boolean v1_2 = ((Integer) v1_0.get(v0_0));
        if (!v1_2) {
            if (v0_0.isPrimitive()) {
                v0_0 = com.bumptech.glide.i.m(kotlin.jvm.internal.h.a(v0_0));
            }
            return v0_0.isInstance(p3);
        } else {
            return kotlin.jvm.internal.j.d(v1_2.intValue(), p3);
        }
    }

    public final boolean equals(Object p2)
    {
        if ((!(p2 instanceof kotlin.jvm.internal.b)) || (!com.bumptech.glide.i.m(this).equals(com.bumptech.glide.i.m(((bb.c) p2))))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final int hashCode()
    {
        return com.bumptech.glide.i.m(this).hashCode();
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder();
        v0_1.append(this.g.toString());
        v0_1.append(" (Kotlin reflection is not available)");
        return v0_1.toString();
    }
}
