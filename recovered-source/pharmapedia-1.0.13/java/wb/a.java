// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package wb;
public abstract class a {
    public static final int a;

    static a()
    {
        try {
            int v0_4 = System.getProperty("kotlinx.serialization.json.pool.size");
            v0_4.getClass();
            int v0_1 = db.p.R(v0_4);
        } catch (int v0_5) {
            v0_1 = new kotlin.Result$Failure(v0_5);
        }
        if ((v0_1 instanceof kotlin.Result$Failure)) {
            v0_1 = 0;
        }
        int v0_3;
        int v0_2 = ((Integer) v0_1);
        if (v0_2 == 0) {
            v0_3 = 2097152;
        } else {
            v0_3 = v0_2.intValue();
        }
        wb.a.a = v0_3;
        return;
    }
}
