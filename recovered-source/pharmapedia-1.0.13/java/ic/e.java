// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ic;
public abstract class e {
    public static volatile ic.e a;
    public static final java.util.logging.Logger b;

    static e()
    {
        try {
            IllegalStateException v0_3 = jc.c.b.entrySet().iterator();
        } catch (IllegalStateException v0_2) {
            System.err.println("Possibly running android unit test without robolectric");
            v0_2.printStackTrace();
            IllegalStateException v0_5;
            String v1_6 = 0;
            if (!ic.a.e) {
                v0_5 = 0;
            } else {
                v0_5 = new ic.a();
            }
            if (v0_5 == null) {
                if (ic.c.e) {
                    v1_6 = new ic.c();
                }
                v0_5 = v1_6;
            }
            if (v0_5 == null) {
                StringBuilder v2_5 = new StringBuilder("Expected Android API level 21+ but was ");
                v2_5.append(android.os.Build$VERSION.SDK_INT);
                throw new IllegalStateException(v2_5.toString());
            } else {
                ic.e.a = v0_5;
                ic.e.b = java.util.logging.Logger.getLogger(yb.y.getName());
                return;
            }
        }
        while (v0_3.hasNext()) {
            String v1_0 = ((java.util.Map$Entry) v0_3.next());
            String v1_2 = ((String) v1_0.getValue());
            StringBuilder v2_2 = java.util.logging.Logger.getLogger(((String) v1_0.getKey()));
            if (jc.c.a.add(v2_2)) {
                String v1_4;
                v2_2.setUseParentHandlers(0);
                if (!android.util.Log.isLoggable(v1_2, 3)) {
                    if (!android.util.Log.isLoggable(v1_2, 4)) {
                        v1_4 = java.util.logging.Level.WARNING;
                    } else {
                        v1_4 = java.util.logging.Level.INFO;
                    }
                } else {
                    v1_4 = java.util.logging.Level.FINE;
                }
                v2_2.setLevel(v1_4);
                v2_2.addHandler(jc.d.a);
            }
        }
    }

    public abstract com.bumptech.glide.j c(javax.net.ssl.X509TrustManager p0);

    public abstract void d(javax.net.ssl.SSLSocket p0, String p1, java.util.List p2);

    public void e(java.net.Socket p1, java.net.InetSocketAddress p2, int p3)
    {
        p2.getClass();
        p1.connect(p2, p3);
        return;
    }

    public abstract String f(javax.net.ssl.SSLSocket p0);

    public Object g()
    {
        if (!ic.e.b.isLoggable(java.util.logging.Level.FINE)) {
            return 0;
        } else {
            return new Throwable("response.body().close()");
        }
    }

    public abstract boolean h(String p0);

    public abstract void i(int p0, String p1, Throwable p2);

    public void j(Object p2, String p3)
    {
        if (p2 == null) {
            p3 = p3.concat(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        this.i(5, p3, ((Throwable) p2));
        return;
    }

    public abstract javax.net.ssl.SSLContext k();

    public final String toString()
    {
        return this.getClass().getSimpleName();
    }
}
