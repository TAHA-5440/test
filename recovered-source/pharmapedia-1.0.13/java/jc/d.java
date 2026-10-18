// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package jc;
public final class d extends java.util.logging.Handler {
    public static final jc.d a;

    static d()
    {
        jc.d.a = new jc.d();
        return;
    }

    public final void close()
    {
        return;
    }

    public final void flush()
    {
        return;
    }

    public final void publish(java.util.logging.LogRecord p5)
    {
        int v1_2;
        p5.getClass();
        String v0 = p5.getLoggerName();
        v0.getClass();
        String v2_2 = java.util.logging.Level.INFO;
        if (p5.getLevel().intValue() <= v2_2.intValue()) {
            if (p5.getLevel().intValue() != v2_2.intValue()) {
                v1_2 = 3;
            } else {
                v1_2 = 4;
            }
        } else {
            v1_2 = 5;
        }
        String v2_1 = p5.getMessage();
        v2_1.getClass();
        jc.c.a(v0, v1_2, v2_1, p5.getThrown());
        return;
    }
}
