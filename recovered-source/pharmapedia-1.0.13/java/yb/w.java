// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package yb;
public final class w {
    public static final kotlin.text.Regex b;
    public static final kotlin.text.Regex c;
    public final String a;

    static w()
    {
        yb.w.b = new kotlin.text.Regex("([a-zA-Z0-9-!#$%&\'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&\'*+.^_`{|}~]+)");
        yb.w.c = new kotlin.text.Regex(";\\s*(?:([a-zA-Z0-9-!#$%&\'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&\'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
        return;
    }

    public w(String p1, String p2, String p3, String[] p4)
    {
        p1.getClass();
        p4.getClass();
        this.a = p1;
        return;
    }

    public final boolean equals(Object p2)
    {
        if ((!(p2 instanceof yb.w)) || (!kotlin.jvm.internal.f.a(((yb.w) p2).a, this.a))) {
            return 0;
        } else {
            return 1;
        }
    }

    public final int hashCode()
    {
        return this.a.hashCode();
    }

    public final String toString()
    {
        return this.a;
    }
}
