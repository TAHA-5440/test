// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ha;
public abstract class l extends ha.k {

    public static int y(Iterable p1, int p2)
    {
        p1.getClass();
        if (!(p1 instanceof java.util.Collection)) {
            return p2;
        } else {
            return ((java.util.Collection) p1).size();
        }
    }
}
