// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package db;
public final synthetic class q implements ua.p {
    public final synthetic int g;
    public final synthetic Object h;

    public synthetic q(Object p1, int p2)
    {
        this.g = p2;
        this.h = p1;
        return;
    }

    public final Object invoke(Object p11, Object p12)
    {
        switch (this.g) {
            case 0:
                kotlin.Pair v0_2;
                kotlin.Pair v0_14 = ((java.util.List) this.h);
                Integer v11_1 = ((Integer) p12).intValue();
                ((CharSequence) p11).getClass();
                kotlin.Pair v7_0 = 0;
                if (v0_14.size() != 1) {
                    if (v11_1 < null) {
                        v11_1 = 0;
                    }
                    Integer v12_23 = new ab.c(v11_1, ((CharSequence) p11).length(), 1);
                    int v8 = v12_23.i;
                    Integer v12_24 = v12_23.h;
                    if (!(((CharSequence) p11) instanceof String)) {
                        if (((v8 <= 0) || (v11_1 > v12_24)) && ((v8 >= 0) || (v12_24 > v11_1))) {
                            v0_2 = 0;
                            if (v0_2 != null) {
                                v7_0 = new kotlin.Pair(v0_2.g, Integer.valueOf(((String) v0_2.h).length()));
                            }
                        } else {
                            int v4_1 = v11_1;
                            do {
                                Integer v11_19 = v0_14.iterator();
                                String v9_0;
                                if (!v11_19.hasNext()) {
                                    v9_0 = 0;
                                } else {
                                    v9_0 = v11_19.next();
                                    boolean v1_6 = ((String) v9_0);
                                    if (db.i.f0(v1_6, 0, ((CharSequence) p11), v4_1, v1_6.length(), 0)) {
                                    }
                                }
                                String v9_1 = ((String) v9_0);
                                if (v9_1 == null) {
                                } else {
                                    v0_2 = new kotlin.Pair(Integer.valueOf(v4_1), v9_1);
                                }
                            } while(v4_1 == v12_24);
                        }
                    } else {
                        if (((v8 <= 0) || (v11_1 > v12_24)) && ((v8 >= 0) || (v12_24 > v11_1))) {
                        }
                        while(true) {
                            int v2_7 = v0_14.iterator();
                            int v4_3;
                            if (!v2_7.hasNext()) {
                                v4_3 = 0;
                            } else {
                                v4_3 = v2_7.next();
                                int v5_2 = ((String) v4_3);
                                if (v5_2.regionMatches(0, ((String) ((CharSequence) p11)), v11_1, v5_2.length())) {
                                }
                            }
                            int v4_4 = ((String) v4_3);
                            if (v4_4 == 0) {
                                break;
                            }
                            v0_2 = new kotlin.Pair(Integer.valueOf(v11_1), v4_4);
                        }
                        if (v11_1 == v12_24) {
                        } else {
                            v11_1 += v8;
                        }
                    }
                } else {
                    Integer v12_1 = v0_14.size();
                    if (v12_1 == null) {
                        throw new java.util.NoSuchElementException("List is empty.");
                    } else {
                        if (v12_1 != 1) {
                            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("List has more than one element.");
                            v7_0 = 0;
                        } else {
                            Integer v12_4 = ((String) v0_14.get(0));
                            Integer v11_7 = db.i.Y(((CharSequence) p11), v12_4, v11_1, 0, 4);
                            if (v11_7 >= null) {
                                v0_2 = new kotlin.Pair(Integer.valueOf(v11_7), v12_4);
                            }
                        }
                    }
                }
                return v7_0;
            case 1:
                Integer v11_17;
                kotlin.Pair v0_15 = ((char[]) this.h);
                Integer v12_26 = ((Integer) p12).intValue();
                ((CharSequence) p11).getClass();
                Integer v11_4 = db.i.Z(((CharSequence) p11), v0_15, v12_26, 0);
                if (v11_4 >= null) {
                    v11_17 = new kotlin.Pair(Integer.valueOf(v11_4), Integer.valueOf(1));
                } else {
                    v11_17 = 0;
                }
                return v11_17;
            default:
                kotlin.Pair v0_6 = ((kotlinx.coroutines.flow.internal.SafeCollector) this.h);
                boolean v1_0 = ((Integer) p11).intValue();
                Integer v11_12 = ((ka.e) p12).getKey();
                kotlin.Pair v0_8 = v0_6.h.Z(v11_12);
                if (v11_12 == gb.t.h) {
                    kotlin.Pair v0_9 = ((gb.u0) v0_8);
                    Integer v12_11 = ((gb.u0) ((ka.e) p12));
                    while(true) {
                        Integer v11_13 = 0;
                        if (v12_11 == null) {
                            break;
                        }
                        if ((v12_11 != v0_9) && ((v12_11 instanceof lb.o))) {
                            Integer v12_14 = ((gb.k) gb.a1.h.get(((lb.o) v12_11)));
                            if (v12_14 != null) {
                                v11_13 = v12_14.getParent();
                            }
                            v12_11 = v11_13;
                        }
                        if (v12_11 != v0_9) {
                            boolean v1_2 = new StringBuilder("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of ");
                            v1_2.append(v12_11);
                            v1_2.append(", expected child of ");
                            v1_2.append(v0_9);
                            v1_2.append(".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use \'channelFlow\' builder instead of \'flow\'");
                            throw new IllegalStateException(v1_2.toString().toString());
                        } else {
                            if (v0_9 != null) {
                                v1_0++;
                            }
                        }
                    }
                    v12_11 = 0;
                } else {
                    if (((ka.e) p12) == v0_8) {
                    } else {
                        v1_0 = -2147483648;
                    }
                }
                return Integer.valueOf(v1_0);
        }
    }
}
