// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlinx.serialization;
public final class MissingFieldException extends kotlinx.serialization.SerializationException {
    public final java.util.List g;

    public MissingFieldException(java.util.ArrayList p5, String p6)
    {
        String v6_2;
        p6.getClass();
        if (p5.size() != 1) {
            int v0_5 = new StringBuilder("Fields ");
            v0_5.append(p5);
            v0_5.append(" are required for type with serial name \'");
            v0_5.append(p6);
            v0_5.append("\', but they were missing");
            v6_2 = v0_5.toString();
        } else {
            v6_2 = r1.a.u(new StringBuilder("Field \'"), ((String) p5.get(0)), "\' is required for type with serial name \'", p6, "\', but it was missing");
        }
        super(v6_2, 0);
        super.g = p5;
        return;
    }

    public MissingFieldException(java.util.List p1, String p2, kotlinx.serialization.MissingFieldException p3)
    {
        p1.getClass();
        super(p2, p3);
        super.g = p1;
        return;
    }
}
