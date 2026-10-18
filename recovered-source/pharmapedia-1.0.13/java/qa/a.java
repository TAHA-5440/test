// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package qa;
public abstract class a {
    public static final Integer a;

    static a()
    {
        Integer v0 = 0;
        try {
            Integer v1_4 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(0);
        } catch (Throwable) {
            Integer v1_1 = 0;
        }
        if (!(v1_4 instanceof Integer)) {
        } else {
            v1_1 = ((Integer) v1_4);
            if ((v1_1 != null) && (v1_1.intValue() > 0)) {
                v0 = v1_1;
            }
            qa.a.a = v0;
            return;
        }
    }
}
