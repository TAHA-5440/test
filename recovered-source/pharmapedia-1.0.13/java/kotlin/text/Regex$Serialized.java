// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.text;
final class Regex$Serialized implements java.io.Serializable {
    private static final long serialVersionUID;
    public final String g;
    public final int h;

    public Regex$Serialized(String p1, int p2)
    {
        this.g = p1;
        this.h = p2;
        return;
    }

    private final Object readResolve()
    {
        java.util.regex.Pattern v1_1 = java.util.regex.Pattern.compile(this.g, this.h);
        v1_1.getClass();
        return new kotlin.text.Regex(v1_1);
    }
}
