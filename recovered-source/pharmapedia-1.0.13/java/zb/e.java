// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package zb;
public abstract class e {
    public static final java.util.TimeZone a;
    public static final String b;

    static e()
    {
        String v0_2 = java.util.TimeZone.getTimeZone("GMT");
        v0_2.getClass();
        zb.e.a = v0_2;
        String v0_1 = db.i.g0(yb.y.getName(), "okhttp3.");
        if (db.p.K(v0_1, "Client", 0)) {
            v0_1 = v0_1.substring(0, (v0_1.length() - 6));
        }
        zb.e.b = v0_1;
        return;
    }

    public static final boolean a(yb.u p2, yb.u p3)
    {
        p2.getClass();
        p3.getClass();
        if ((!kotlin.jvm.internal.f.a(p2.d, p3.d)) || ((p2.e != p3.e) || (!kotlin.jvm.internal.f.a(p2.a, p3.a)))) {
            return 0;
        } else {
            return 1;
        }
    }

    public static final int b(long p6)
    {
        java.util.concurrent.TimeUnit.MILLISECONDS.getClass();
        long v2 = p6 cmp 0;
        if (v2 < 0) {
            throw new IllegalStateException("timeout".concat(" < 0").toString());
        } else {
            if (p6 > 2147483647) {
                oc.l.d("timeout".concat(" too large"));
            } else {
                if ((p6 == 0) && (v2 > 0)) {
                    oc.l.d("timeout".concat(" too small"));
                } else {
                    return ((int) p6);
                }
            }
            return 0;
        }
    }

    public static final void c(java.net.Socket p2)
    {
        p2.getClass();
        try {
            p2.close();
        } catch (RuntimeException v2_1) {
            throw v2_1;
        } catch (Exception) {
        } catch (RuntimeException v2_2) {
            if (!kotlin.jvm.internal.f.a(v2_2.getMessage(), "bio == null")) {
                throw v2_2;
            } else {
                return;
            }
        }
        return;
    }

    public static final varargs String d(String p2, Object[] p3)
    {
        Object[] v3_1 = java.util.Arrays.copyOf(p3, p3.length);
        return String.format(java.util.Locale.US, p2, java.util.Arrays.copyOf(v3_1, v3_1.length));
    }

    public static final long e(yb.b0 p3)
    {
        String v3_2 = p3.l.a("Content-Length");
        long v0_1 = -1;
        try {
            if (v3_2 != null) {
                v0_1 = Long.parseLong(v3_2);
            }
        } catch (NumberFormatException) {
        }
        return v0_1;
    }

    public static final boolean f(oc.d0 p12, int p13)
    {
        long v6_0;
        int v0_0 = java.util.concurrent.TimeUnit.MILLISECONDS;
        v0_0.getClass();
        long v1_0 = System.nanoTime();
        if (!p12.a().e()) {
            v6_0 = 9223372036854775807;
        } else {
            v6_0 = (p12.a().c() - v1_0);
        }
        p12.a().d((Math.min(v6_0, v0_0.toNanos(((long) p13))) + v1_0));
        try {
            long v13_2 = new oc.i();
        } catch (java.io.InterruptedIOException) {
            if (v6_0 != 9223372036854775807) {
                p12.a().d((v1_0 + v6_0));
            } else {
                p12.a().a();
            }
            return 0;
        } catch (long v13_3) {
            if (v6_0 != 9223372036854775807) {
                p12.a().d((v1_0 + v6_0));
            } else {
                p12.a().a();
            }
            throw v13_3;
        }
        while (p12.N(8192, v13_2) != -1) {
            v13_2.d();
        }
        if (v6_0 != 9223372036854775807) {
            p12.a().d((v1_0 + v6_0));
            return 1;
        } else {
            p12.a().a();
            return 1;
        }
    }

    public static final yb.s g(java.util.List p3)
    {
        String[] v0_3 = new java.util.ArrayList(20);
        yb.s v3_2 = p3.iterator();
        while (v3_2.hasNext()) {
            String[] v1_3 = ((fc.b) v3_2.next());
            String[] v1_4 = v1_3.b;
            String v2_1 = v1_3.a.t();
            String[] v1_5 = v1_4.t();
            v0_3.add(v2_1);
            v0_3.add(db.i.o0(v1_5).toString());
        }
        String[] v1_1 = new String[0];
        return new yb.s(((String[]) v0_3.toArray(v1_1)));
    }

    public static final String h(yb.u p4, boolean p5)
    {
        p4.getClass();
        int v0 = p4.e;
        String v1 = p4.d;
        if (db.i.T(v1, ":", 0)) {
            v1 = r1.a.k("[", v1, 93);
        }
        if (p5 == null) {
            int v4_3;
            int v4_1 = p4.a;
            v4_1.getClass();
            if (!v4_1.equals("http")) {
                if (!v4_1.equals("https")) {
                    v4_3 = -1;
                } else {
                    v4_3 = 443;
                }
            } else {
                v4_3 = 80;
            }
            if (v0 == v4_3) {
                return v1;
            }
        }
        int v4_5 = new StringBuilder();
        v4_5.append(v1);
        v4_5.append(58);
        v4_5.append(v0);
        return v4_5.toString();
    }

    public static final java.util.List i(java.util.List p2)
    {
        p2.getClass();
        if (!p2.isEmpty()) {
            if (p2.size() != 1) {
                java.util.List v2_6 = p2.toArray();
                v2_6.getClass();
                java.util.List v2_1 = java.util.Arrays.asList(v2_6);
                v2_1.getClass();
                java.util.List v2_2 = java.util.Collections.unmodifiableList(v2_1);
                v2_2.getClass();
                return v2_2;
            } else {
                java.util.List v2_4 = java.util.Collections.singletonList(p2.get(0));
                v2_4.getClass();
                return v2_4;
            }
        } else {
            return kotlin.collections.EmptyList.g;
        }
    }

    public static final java.util.List j(Object[] p2)
    {
        if ((p2 != null) && (p2.length != 0)) {
            if (p2.length != 1) {
                java.util.List v2_7 = ((Object[]) p2.clone());
                v2_7.getClass();
                java.util.List v2_1 = java.util.Arrays.asList(v2_7);
                v2_1.getClass();
                java.util.List v2_2 = java.util.Collections.unmodifiableList(v2_1);
                v2_2.getClass();
                return v2_2;
            } else {
                java.util.List v2_4 = java.util.Collections.singletonList(p2[0]);
                v2_4.getClass();
                return v2_4;
            }
        } else {
            return kotlin.collections.EmptyList.g;
        }
    }
}
