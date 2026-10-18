// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.jvm.internal;
public abstract class j {

    public static final void a(StringBuilder p2, Class p3)
    {
        while (p3.isArray()) {
            p2.append("[");
            p3 = p3.getComponentType();
            p3.getClass();
        }
        if (!p3.equals(Void.TYPE)) {
            if (!p3.equals(Integer.TYPE)) {
                if (!p3.equals(Long.TYPE)) {
                    if (!p3.equals(Short.TYPE)) {
                        if (!p3.equals(Byte.TYPE)) {
                            if (!p3.equals(Boolean.TYPE)) {
                                if (!p3.equals(Character.TYPE)) {
                                    if (!p3.equals(Float.TYPE)) {
                                        if (!p3.equals(Double.TYPE)) {
                                            p2.append("L");
                                            String v3_2 = p3.getName().replace(46, 47);
                                            v3_2.getClass();
                                            p2.append(v3_2);
                                            p2.append(";");
                                            return;
                                        } else {
                                            p2.append("D");
                                            return;
                                        }
                                    } else {
                                        p2.append("F");
                                        return;
                                    }
                                } else {
                                    p2.append("C");
                                    return;
                                }
                            } else {
                                p2.append("Z");
                                return;
                            }
                        } else {
                            p2.append("B");
                            return;
                        }
                    } else {
                        p2.append("S");
                        return;
                    }
                } else {
                    p2.append("J");
                    return;
                }
            } else {
                p2.append("I");
                return;
            }
        } else {
            p2.append("V");
            return;
        }
    }

    public static java.util.Collection b(java.util.Collection p1)
    {
        if (((p1 instanceof va.a)) && (!(p1 instanceof va.b))) {
            kotlin.jvm.internal.j.e(p1, "kotlin.collections.MutableCollection");
            throw 0;
        } else {
            return p1;
        }
    }

    public static void c(int p2, Object p3)
    {
        if ((p3 != null) && (!kotlin.jvm.internal.j.d(p2, p3))) {
            StringBuilder v0_2 = new StringBuilder("kotlin.jvm.functions.Function");
            v0_2.append(p2);
            kotlin.jvm.internal.j.e(p3, v0_2.toString());
            throw 0;
        } else {
            return;
        }
    }

    public static boolean d(int p3, Object p4)
    {
        if ((p4 instanceof ga.c)) {
            int v4_2;
            if (!(p4 instanceof kotlin.jvm.internal.e)) {
                if (!(p4 instanceof ua.a)) {
                    if (!(p4 instanceof ua.l)) {
                        if (!(p4 instanceof ua.p)) {
                            if (!(p4 instanceof ua.q)) {
                                if (!(p4 instanceof ua.r)) {
                                    v4_2 = -1;
                                } else {
                                    v4_2 = 4;
                                }
                            } else {
                                v4_2 = 3;
                            }
                        } else {
                            v4_2 = 2;
                        }
                    } else {
                        v4_2 = 1;
                    }
                } else {
                    v4_2 = 0;
                }
            } else {
                v4_2 = ((kotlin.jvm.internal.e) p4).getArity();
            }
            if (v4_2 == p3) {
                return 1;
            }
        }
        return 0;
    }

    public static void e(Object p1, String p2)
    {
        String v1_5;
        if (p1 != null) {
            v1_5 = p1.getClass().getName();
        } else {
            v1_5 = "null";
        }
        StringBuilder v0_1 = new StringBuilder();
        v0_1.append(v1_5);
        v0_1.append(" cannot be cast to ");
        v0_1.append(p2);
        ClassCastException v2_2 = new ClassCastException(v0_1.toString());
        kotlin.jvm.internal.f.e(v2_2, kotlin.jvm.internal.j.getName());
        throw v2_2;
    }
}
