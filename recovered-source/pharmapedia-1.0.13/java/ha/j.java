// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ha;
public abstract class j extends ha.n {

    public static void A(Iterable p1, java.util.AbstractCollection p2)
    {
        p1.getClass();
        if (!(p1 instanceof java.util.Collection)) {
            java.util.Iterator v1_2 = p1.iterator();
            while (v1_2.hasNext()) {
                p2.add(v1_2.next());
            }
            return;
        } else {
            p2.addAll(((java.util.Collection) p1));
            return;
        }
    }

    public static boolean B(Iterable p3, Object p4)
    {
        p3.getClass();
        if (!(p3 instanceof java.util.Collection)) {
            int v3_1;
            if (!(p3 instanceof java.util.List)) {
                int v3_7 = p3.iterator();
                int v0_1 = 0;
                while (v3_7.hasNext()) {
                    boolean v2_1 = v3_7.next();
                    if (v0_1 < 0) {
                        ha.k.x();
                        throw 0;
                    } else {
                        if (!kotlin.jvm.internal.f.a(p4, v2_1)) {
                            v0_1++;
                        } else {
                            v3_1 = v0_1;
                        }
                    }
                }
                v3_1 = -1;
            } else {
                v3_1 = ((java.util.List) p3).indexOf(p4);
            }
            if (v3_1 < 0) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return ((java.util.Collection) p3).contains(p4);
        }
    }

    public static java.util.List C(java.util.List p4)
    {
        p4.getClass();
        int v1 = 1;
        Object v0_4 = (p4.size() - 1);
        if (v0_4 > null) {
            if (v0_4 != 1) {
                java.util.ArrayList v2_1 = new java.util.ArrayList(v0_4);
                if (!(p4 instanceof java.util.RandomAccess)) {
                    java.util.ListIterator v4_1 = p4.listIterator(1);
                    while (v4_1.hasNext()) {
                        v2_1.add(v4_1.next());
                    }
                } else {
                    Object v0_3 = p4.size();
                    while (v1 < v0_3) {
                        v2_1.add(p4.get(v1));
                        v1++;
                    }
                }
                return v2_1;
            } else {
                return com.bumptech.glide.e.l(ha.j.J(p4));
            }
        } else {
            return kotlin.collections.EmptyList.g;
        }
    }

    public static final boolean D(java.util.Collection p2, ua.l p3, boolean p4)
    {
        java.util.Iterator v2_1 = p2.iterator();
        int v0 = 0;
        while (v2_1.hasNext()) {
            if (((Boolean) p3.invoke(v2_1.next())).booleanValue() == p4) {
                v2_1.remove();
                v0 = 1;
            }
        }
        return v0;
    }

    public static Object E(java.util.List p1)
    {
        p1.getClass();
        if (p1.isEmpty()) {
            throw new java.util.NoSuchElementException("List is empty.");
        } else {
            return p1.get(0);
        }
    }

    public static Object F(int p1, java.util.List p2)
    {
        if ((p1 < null) || (p1 >= p2.size())) {
            return 0;
        } else {
            return p2.get(p1);
        }
    }

    public static final void G(Iterable p1, StringBuilder p2, CharSequence p3, CharSequence p4, CharSequence p5, CharSequence p6, ua.l p7)
    {
        p1.getClass();
        p2.append(p4);
        java.util.Iterator v1_1 = p1.iterator();
        int v4_1 = 0;
        while (v1_1.hasNext()) {
            Object v6_0 = v1_1.next();
            v4_1++;
            if (v4_1 > 1) {
                p2.append(p3);
            }
            com.bumptech.glide.d.a(p2, v6_0, p7);
        }
        p2.append(p5);
        return;
    }

    public static synthetic void H(java.util.ArrayList p7, StringBuilder p8)
    {
        ha.j.G(p7, p8, "\n", "", "", "...", 0);
        return;
    }

    public static String I(Iterable p7, String p8, String p9, String p10, ua.l p11, int p12)
    {
        if ((p12 & 1) != 0) {
            p8 = ", ";
        }
        String v3;
        if ((p12 & 2) == 0) {
            v3 = p9;
        } else {
            v3 = "";
        }
        String v4;
        if ((p12 & 4) == 0) {
            v4 = p10;
        } else {
            v4 = "";
        }
        if ((p12 & 32) != 0) {
            p11 = 0;
        }
        p7.getClass();
        StringBuilder v1_1 = new StringBuilder();
        ha.j.G(p7, v1_1, p8, v3, v4, "...", p11);
        return v1_1.toString();
    }

    public static Object J(java.util.List p1)
    {
        p1.getClass();
        if (p1.isEmpty()) {
            throw new java.util.NoSuchElementException("List is empty.");
        } else {
            return p1.get((p1.size() - 1));
        }
    }

    public static java.util.ArrayList K(Iterable p3, java.util.Collection p4)
    {
        java.util.ArrayList v0_1 = new java.util.ArrayList((((java.util.Collection) p3).size() + p4.size()));
        v0_1.addAll(p4);
        v0_1.addAll(((java.util.Collection) p3));
        return v0_1;
    }

    public static java.util.ArrayList L(java.util.Collection p2, Object p3)
    {
        p2.getClass();
        java.util.ArrayList v0_1 = new java.util.ArrayList((p2.size() + 1));
        v0_1.addAll(p2);
        v0_1.add(p3);
        return v0_1;
    }

    public static void M(java.util.List p6, ua.l p7)
    {
        p6.getClass();
        if ((p6 instanceof java.util.RandomAccess)) {
            boolean v0_4 = (p6.size() - 1);
            int v2 = 0;
            if (v0_4) {
                int v3 = 0;
                while(true) {
                    Object v4 = p6.get(v2);
                    if (((Boolean) p7.invoke(v4)).booleanValue() != 1) {
                        if (v3 != v2) {
                            p6.set(v3, v4);
                        }
                        v3++;
                    }
                    if (v2 == v0_4) {
                        break;
                    }
                    v2++;
                }
                v2 = v3;
            }
            if (v2 < p6.size()) {
                int v7_3 = (p6.size() - 1);
                if (v2 > v7_3) {
                    return;
                }
                while(true) {
                    p6.remove(v7_3);
                    if (v7_3 == v2) {
                        break;
                    }
                    v7_3--;
                }
            }
            return;
        } else {
            if (((p6 instanceof va.a)) && (!(p6 instanceof va.b))) {
                kotlin.jvm.internal.j.e(p6, "kotlin.collections.MutableIterable");
                throw 0;
            } else {
                ha.j.D(p6, p7, 1);
                return;
            }
        }
    }

    public static Object N(java.util.List p1)
    {
        p1.getClass();
        if (p1.isEmpty()) {
            throw new java.util.NoSuchElementException("List is empty.");
        } else {
            return p1.remove((p1.size() - 1));
        }
    }

    public static void O(java.util.ArrayList p1)
    {
        p1.getClass();
        if (!p1.isEmpty()) {
            p1.remove((p1.size() - 1));
            return;
        } else {
            return;
        }
    }

    public static java.util.List P(java.util.Collection p2)
    {
        p2.getClass();
        if (p2.size() > 1) {
            java.util.List v2_2 = ha.j.W(p2);
            java.util.Collections.reverse(v2_2);
            return v2_2;
        } else {
            return ha.j.U(p2);
        }
    }

    public static java.util.List Q(Iterable p3)
    {
        p3.getClass();
        if (!(p3 instanceof java.util.Collection)) {
            java.util.List v3_6 = ha.j.W(p3);
            ha.n.z(v3_6);
            return v3_6;
        } else {
            if (((java.util.Collection) p3).size() > 1) {
                java.util.List v3_2 = new Comparable[0];
                java.util.List v3_3 = ((java.util.Collection) p3).toArray(v3_2);
                Comparable[] v0_2 = ((Comparable[]) v3_3);
                v0_2.getClass();
                if (v0_2.length > 1) {
                    java.util.Arrays.sort(v0_2);
                }
                v3_3.getClass();
                java.util.List v3_4 = java.util.Arrays.asList(v3_3);
                v3_4.getClass();
                return v3_4;
            } else {
                return ha.j.U(p3);
            }
        }
    }

    public static java.util.List R(Iterable p3, java.util.Comparator p4)
    {
        p3.getClass();
        p4.getClass();
        if (!(p3 instanceof java.util.Collection)) {
            java.util.List v3_6 = ha.j.W(p3);
            if (((java.util.ArrayList) v3_6).size() > 1) {
                java.util.Collections.sort(v3_6, p4);
            }
            return v3_6;
        } else {
            if (((java.util.Collection) p3).size() > 1) {
                java.util.List v3_2 = new Object[0];
                java.util.List v3_3 = ((java.util.Collection) p3).toArray(v3_2);
                v3_3.getClass();
                if (v3_3.length > 1) {
                    java.util.Arrays.sort(v3_3, p4);
                }
                java.util.List v3_4 = java.util.Arrays.asList(v3_3);
                v3_4.getClass();
                return v3_4;
            } else {
                return ha.j.U(p3);
            }
        }
    }

    public static java.util.List S(int p4, java.util.List p5)
    {
        p5.getClass();
        if (p4 < null) {
            oc.l.d(r1.a.h(p4, "Requested element count ", " is less than zero."));
            return 0;
        } else {
            if (p4 != null) {
                if (p4 < p5.size()) {
                    if (p4 != 1) {
                        java.util.ArrayList v1_1 = new java.util.ArrayList(p4);
                        java.util.Iterator v5_1 = p5.iterator();
                        int v2 = 0;
                        while (v5_1.hasNext()) {
                            v1_1.add(v5_1.next());
                            v2++;
                            if (v2 == p4) {
                                break;
                            }
                        }
                        return ha.k.w(v1_1);
                    } else {
                        return com.bumptech.glide.e.l(ha.j.E(p5));
                    }
                } else {
                    return ha.j.U(p5);
                }
            } else {
                return kotlin.collections.EmptyList.g;
            }
        }
    }

    public static final void T(Iterable p1, java.util.AbstractCollection p2)
    {
        p1.getClass();
        java.util.Iterator v1_1 = p1.iterator();
        while (v1_1.hasNext()) {
            p2.add(v1_1.next());
        }
        return;
    }

    public static java.util.List U(Iterable p3)
    {
        p3.getClass();
        if (!(p3 instanceof java.util.Collection)) {
            return ha.k.w(ha.j.W(p3));
        } else {
            boolean v1_0 = ((java.util.Collection) p3).size();
            if (!v1_0) {
                return kotlin.collections.EmptyList.g;
            } else {
                if (v1_0 == 1) {
                    java.util.List v3_3;
                    if (!(p3 instanceof java.util.List)) {
                        v3_3 = ((java.util.Collection) p3).iterator().next();
                    } else {
                        v3_3 = ((java.util.List) p3).get(0);
                    }
                    return com.bumptech.glide.e.l(v3_3);
                } else {
                    return new java.util.ArrayList(((java.util.Collection) p3));
                }
            }
        }
    }

    public static java.util.ArrayList V(java.util.List p1)
    {
        p1.getClass();
        return new java.util.ArrayList(p1);
    }

    public static final java.util.List W(Iterable p1)
    {
        p1.getClass();
        if (!(p1 instanceof java.util.Collection)) {
            java.util.ArrayList v0_2 = new java.util.ArrayList();
            ha.j.T(p1, v0_2);
            return v0_2;
        } else {
            return new java.util.ArrayList(((java.util.Collection) p1));
        }
    }

    public static java.util.Set X(java.util.Collection p1)
    {
        p1.getClass();
        return new java.util.LinkedHashSet(p1);
    }

    public static java.util.Set Y(Iterable p3)
    {
        p3.getClass();
        if (!(p3 instanceof java.util.Collection)) {
            int v0_7 = new java.util.LinkedHashSet();
            ha.j.T(p3, v0_7);
            java.util.Set v3_9 = v0_7.size();
            if (v3_9 != null) {
                if (v3_9 == 1) {
                    java.util.Set v3_3 = java.util.Collections.singleton(v0_7.iterator().next());
                    v3_3.getClass();
                    return v3_3;
                } else {
                    return v0_7;
                }
            }
        } else {
            int v2 = ((java.util.Collection) p3).size();
            if (v2 != 0) {
                if (v2 == 1) {
                    java.util.Set v3_6;
                    if (!(p3 instanceof java.util.List)) {
                        v3_6 = ((java.util.Collection) p3).iterator().next();
                    } else {
                        v3_6 = ((java.util.List) p3).get(0);
                    }
                    java.util.Set v3_8 = java.util.Collections.singleton(v3_6);
                    v3_8.getClass();
                    return v3_8;
                } else {
                    boolean v1_3 = new java.util.LinkedHashSet(kotlin.collections.a.I(((java.util.Collection) p3).size()));
                    ha.j.T(p3, v1_3);
                    return v1_3;
                }
            }
        }
        return kotlin.collections.EmptySet.g;
    }
}
