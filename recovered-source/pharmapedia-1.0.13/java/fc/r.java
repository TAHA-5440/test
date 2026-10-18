// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public abstract class r {

    public static int a(int p1, int p2, int p3)
    {
        if ((p2 & 8) != 0) {
            p1--;
        }
        if (p3 > p1) {
            oc.l.g(r1.a.l("PROTOCOL_ERROR padding ", " > remaining length ", p3, p1));
            return 0;
        } else {
            return (p1 - p3);
        }
    }
}
