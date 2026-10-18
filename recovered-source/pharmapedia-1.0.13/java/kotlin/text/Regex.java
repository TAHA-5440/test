// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.text;
public final class Regex implements java.io.Serializable {
    public final java.util.regex.Pattern g;

    public Regex(String p1)
    {
        java.util.regex.Pattern v1_1 = java.util.regex.Pattern.compile(p1);
        v1_1.getClass();
        this.g = v1_1;
        return;
    }

    public Regex(java.util.regex.Pattern p1)
    {
        this.g = p1;
        return;
    }

    private final void readObject(java.io.ObjectInputStream p2)
    {
        throw new java.io.InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace()
    {
        int v1_0 = this.g;
        String v2 = v1_0.pattern();
        v2.getClass();
        return new kotlin.text.Regex$Serialized(v2, v1_0.flags());
    }

    public final androidx.lifecycle.j a(int p3, String p4)
    {
        p4.getClass();
        int v3_1 = this.g.matcher(p4).useAnchoringBounds(0).useTransparentBounds(1).region(p3, p4.length());
        if (!v3_1.lookingAt()) {
            return 0;
        } else {
            return new androidx.lifecycle.j(v3_1, p4);
        }
    }

    public final boolean b(CharSequence p2)
    {
        p2.getClass();
        return this.g.matcher(p2).matches();
    }

    public final String c(String p2)
    {
        p2.getClass();
        String v2_2 = this.g.matcher(p2).replaceAll("");
        v2_2.getClass();
        return v2_2;
    }

    public final java.util.List d(String p5)
    {
        p5.getClass();
        int v0_0 = 0;
        db.i.h0(0);
        int v1_2 = this.g.matcher(p5);
        if (v1_2.find()) {
            java.util.ArrayList v2_0 = new java.util.ArrayList(10);
            do {
                v2_0.add(p5.subSequence(v0_0, v1_2.start()).toString());
                v0_0 = v1_2.end();
            } while(v1_2.find());
            v2_0.add(p5.subSequence(v0_0, p5.length()).toString());
            return v2_0;
        } else {
            return com.bumptech.glide.e.l(p5.toString());
        }
    }

    public final String toString()
    {
        String v0_1 = this.g.toString();
        v0_1.getClass();
        return v0_1;
    }
}
