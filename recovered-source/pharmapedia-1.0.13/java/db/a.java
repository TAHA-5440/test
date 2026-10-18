// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package db;
public abstract class a {
    public static final java.nio.charset.Charset a;

    static a()
    {
        java.nio.charset.Charset v0_6 = java.nio.charset.Charset.forName("UTF-8");
        v0_6.getClass();
        db.a.a = v0_6;
        java.nio.charset.Charset.forName("UTF-16").getClass();
        java.nio.charset.Charset.forName("UTF-16BE").getClass();
        java.nio.charset.Charset.forName("UTF-16LE").getClass();
        java.nio.charset.Charset.forName("US-ASCII").getClass();
        java.nio.charset.Charset.forName("ISO-8859-1").getClass();
        return;
    }
}
