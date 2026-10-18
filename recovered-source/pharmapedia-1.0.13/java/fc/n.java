// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public final synthetic class n implements ua.a {
    public final synthetic int g;
    public final synthetic Object h;
    public final synthetic Object i;

    public synthetic n(int p1, Object p2, Object p3)
    {
        this.g = p1;
        this.h = p2;
        this.i = p3;
        return;
    }

    public final Object invoke()
    {
        int v1_0 = 0;
        String v3_2 = 0;
        switch (this.g) {
            case 0:
                Throwable v0_3 = ((fc.p) this.h);
                int v1_5 = ((fc.x) this.i);
                try {
                    v0_3.g.c(v1_5);
                } catch (String v2_1) {
                    String v4_1 = new StringBuilder("Http2Connection.Listener failure for ");
                    v4_1.append(v0_3.i);
                    ic.e.a.i(4, v4_1.toString(), v2_1);
                    v1_5.c(okhttp3.internal.http2.ErrorCode.j, v2_1);
                } catch (java.io.IOException) {
                }
                return ga.p.a;
            case 1:
                Throwable v0_13 = ((fc.o) this.h);
                String v4_7 = ((fc.c0) this.i);
                long v5_7 = new kotlin.jvm.internal.Ref$ObjectRef();
                Throwable v0_14 = v0_13.h;
                try {
                } catch (Throwable v0_1) {
                    throw v0_1;
                }
                StringBuilder v7_8 = v0_14.x;
                int v8_4 = new fc.c0();
                v7_8.getClass();
                int v9_0 = 0;
                while (v9_0 < 10) {
                    if (((1 << v9_0) & v7_8.a) != 0) {
                        v8_4.b(v9_0, v7_8.b[v9_0]);
                    }
                    v9_0++;
                }
                int v9_4 = 0;
                while (v9_4 < 10) {
                    if (((1 << v9_4) & v4_7.a) != 0) {
                        v8_4.b(v9_4, v4_7.b[v9_4]);
                    }
                    v9_4++;
                }
                v5_7.g = v8_4;
                int v8_6 = (((long) v8_4.a()) - ((long) v7_8.a()));
                String v2_8 = v8_6 cmp 0;
                if (v2_8 != null) {
                    if (!v0_14.h.isEmpty()) {
                        String v4_11 = new fc.x[0];
                        v3_2 = ((fc.x[]) v0_14.h.values().toArray(v4_11));
                    } else {
                    }
                }
                String v4_13 = ((fc.c0) v5_7.g);
                v4_13.getClass();
                v0_14.x = v4_13;
                String v4_14 = v0_14.p;
                StringBuilder v7_10 = new StringBuilder();
                v7_10.append(v0_14.i);
                v7_10.append(" onSettings");
                bc.b.c(v4_14, v7_10.toString(), new fc.n(2, v0_14, v5_7));
                try {
                    v0_14.C.d(((fc.c0) v5_7.g));
                } catch (String v4_16) {
                    v0_14.d(okhttp3.internal.http2.ErrorCode.j, okhttp3.internal.http2.ErrorCode.j, v4_16);
                }
                if (v3_2 != null) {
                    Throwable v0_18 = v3_2.length;
                    while (v1_0 < v0_18) {
                        String v4_17 = v3_2[v1_0];
                        try {
                            v4_17.k = (v4_17.k + v8_6);
                        } catch (Throwable v0_20) {
                            throw v0_20;
                        }
                        if (v2_8 > null) {
                            v4_17.notifyAll();
                        }
                        v1_0++;
                    }
                }
                return ga.p.a;
            case 2:
                Throwable v0_17 = ((fc.p) this.h);
                v0_17.g.b(v0_17, ((fc.c0) ((kotlin.jvm.internal.Ref$ObjectRef) this.i).g));
                return ga.p.a;
            default:
                Throwable v0_10 = ((sb.d) this.h);
                String v4_4 = ((vb.b) this.i);
                long v5_2 = new java.util.LinkedHashMap();
                wb.g.g(v0_10, v4_4);
                String v4_5 = v0_10.f();
                String v6_0 = 0;
                while (v6_0 < v4_5) {
                    StringBuilder v7_0 = v0_10.h(v6_0);
                    int v8_1 = new java.util.ArrayList();
                    StringBuilder v7_1 = v7_0.iterator();
                    while (v7_1.hasNext()) {
                        int v9_3 = v7_1.next();
                        if ((v9_3 instanceof vb.q)) {
                            v8_1.add(v9_3);
                        }
                    }
                    StringBuilder v7_3;
                    if (v8_1.size() != 1) {
                        v7_3 = 0;
                    } else {
                        v7_3 = v8_1.get(0);
                    }
                    StringBuilder v7_4 = ((vb.q) v7_3);
                    if (v7_4 != null) {
                        StringBuilder v7_5 = v7_4.names();
                        if (v7_5 != null) {
                            int v8_2 = v7_5.length;
                            int v9_2 = 0;
                            while (v9_2 < v8_2) {
                                Integer v11_3;
                                String v10_4 = v7_5[v9_2];
                                if (!kotlin.jvm.internal.f.a(v0_10.e(), sb.g.e)) {
                                    v11_3 = "property";
                                } else {
                                    v11_3 = "enum value";
                                }
                                if (v5_2.containsKey(v10_4)) {
                                    String v4_8 = v0_10.g(v6_0);
                                    long v5_8 = v0_10.g(((Number) kotlin.collections.a.H(v5_2, v10_4)).intValue());
                                    StringBuilder v7_7 = new StringBuilder("The suggested name \'");
                                    v7_7.append(v10_4);
                                    v7_7.append("\' for ");
                                    v7_7.append(v11_3);
                                    v7_7.append(32);
                                    v7_7.append(v4_8);
                                    v7_7.append(" is already one of the names for ");
                                    v7_7.append(v11_3);
                                    v7_7.append(32);
                                    v7_7.append(v5_8);
                                    v7_7.append(" in ");
                                    v7_7.append(v0_10);
                                    throw new kotlinx.serialization.json.internal.JsonException(v7_7.toString());
                                } else {
                                    v5_2.put(v10_4, Integer.valueOf(v6_0));
                                    v9_2++;
                                }
                            }
                        }
                    }
                    v6_0++;
                }
                if (v5_2.isEmpty()) {
                    v5_2 = kotlin.collections.a.G();
                }
                return v5_2;
        }
    }
}
