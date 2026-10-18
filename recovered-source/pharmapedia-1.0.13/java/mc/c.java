// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package mc;
public final class c implements javax.net.ssl.HostnameVerifier {
    public static final mc.c a;

    static c()
    {
        mc.c.a = new mc.c();
        return;
    }

    public static java.util.List a(java.security.cert.X509Certificate p4, int p5)
    {
        try {
            java.util.Iterator v4_1 = p4.getSubjectAlternativeNames();
        } catch (java.security.cert.CertificateParsingException) {
            return kotlin.collections.EmptyList.g;
        }
        if (v4_1 != null) {
            java.util.ArrayList v0_1 = new java.util.ArrayList();
            java.util.Iterator v4_3 = v4_1.iterator();
            while (v4_3.hasNext()) {
                String v1_1 = ((java.util.List) v4_3.next());
                if (v1_1 != null) {
                    if (v1_1.size() >= 2) {
                        if (kotlin.jvm.internal.f.a(v1_1.get(0), Integer.valueOf(p5))) {
                            String v1_2 = v1_1.get(1);
                            if (v1_2 != null) {
                                v0_1.add(((String) v1_2));
                            } else {
                            }
                        }
                    } else {
                    }
                }
            }
            return v0_1;
        } else {
            return kotlin.collections.EmptyList.g;
        }
    }

    public static boolean b(String p9, java.security.cert.X509Certificate p10)
    {
        p9.getClass();
        if (!zb.b.a.b(p9)) {
            if (p9.length() == ((int) oc.b.f(p9))) {
                int v0_8 = java.util.Locale.US;
                v0_8.getClass();
                p9 = p9.toLowerCase(v0_8);
                p9.getClass();
            }
            java.util.Iterator v10_3 = mc.c.a(p10, 2);
            if (!v10_3.isEmpty()) {
                java.util.Iterator v10_4 = v10_3.iterator();
                while (v10_4.hasNext()) {
                    int v0_4;
                    int v0_18 = ((String) v10_4.next());
                    if ((p9.length() != 0) && ((!db.p.Q(p9, ".", 0)) && ((!db.p.K(p9, "..", 0)) && ((v0_18 != 0) && ((v0_18.length() != 0) && ((!db.p.Q(v0_18, ".", 0)) && (!db.p.K(v0_18, "..", 0)))))))) {
                        String v4_4;
                        if (db.p.K(p9, ".", 0)) {
                            v4_4 = p9;
                        } else {
                            v4_4 = p9.concat(".");
                        }
                        if (!db.p.K(v0_18, ".", 0)) {
                            v0_18 = v0_18.concat(".");
                        }
                        if (v0_18.length() == ((int) oc.b.f(v0_18))) {
                            int v3_9 = java.util.Locale.US;
                            v3_9.getClass();
                            v0_18 = v0_18.toLowerCase(v3_9);
                            v0_18.getClass();
                        }
                        if (db.i.T(v0_18, "*", 0)) {
                            if ((db.p.Q(v0_18, "*.", 0)) && ((db.i.X(v0_18, 42, 1, 4) == -1) && ((v4_4.length() >= v0_18.length()) && (!"*.".equals(v0_18))))) {
                                int v0_20 = v0_18.substring(1);
                                if (db.p.K(v4_4, v0_20, 0)) {
                                    int v3_3 = (v4_4.length() - v0_20.length());
                                    if ((v3_3 <= 0) || (db.i.c0(v4_4, 46, (v3_3 - 1), 4) == -1)) {
                                        v0_4 = 1;
                                    } else {
                                        v0_4 = 0;
                                    }
                                }
                            }
                        } else {
                            v0_4 = v4_4.equals(v0_18);
                        }
                    }
                    if (v0_4 != 0) {
                        return 1;
                    }
                }
            }
        } else {
            String v9_1 = zb.b.b(p9);
            java.util.Iterator v10_1 = mc.c.a(p10, 7);
            if (!v10_1.isEmpty()) {
                java.util.Iterator v10_2 = v10_1.iterator();
                while (v10_2.hasNext()) {
                    if (kotlin.jvm.internal.f.a(v9_1, zb.b.b(((String) v10_2.next())))) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public final boolean verify(String p4, javax.net.ssl.SSLSession p5)
    {
        p4.getClass();
        p5.getClass();
        try {
            if (p4.length() != ((int) oc.b.f(p4))) {
                return 0;
            } else {
                java.security.cert.X509Certificate v5_2 = p5.getPeerCertificates()[0];
                v5_2.getClass();
                return mc.c.b(p4, ((java.security.cert.X509Certificate) v5_2));
            }
        } catch (javax.net.ssl.SSLException) {
            return 0;
        }
    }
}
