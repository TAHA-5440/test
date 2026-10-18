// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ja;
public final class a implements java.util.Comparator {
    public static final ja.a h;
    public static final ja.a i;
    public final synthetic int g;

    static synthetic a()
    {
        ja.a.h = new ja.a(0);
        ja.a.i = new ja.a(1);
        return;
    }

    public synthetic a(int p1)
    {
        this.g = p1;
        return;
    }

    public final int compare(Object p2, Object p3)
    {
        switch (this.g) {
            case 0:
                ((Comparable) p2).getClass();
                ((Comparable) p3).getClass();
                return ((Comparable) p2).compareTo(((Comparable) p3));
            default:
                ((Comparable) p2).getClass();
                ((Comparable) p3).getClass();
                return ((Comparable) p3).compareTo(((Comparable) p2));
        }
    }

    public final java.util.Comparator reversed()
    {
        switch (this.g) {
            case 0:
                return ja.a.i;
            default:
                return ja.a.h;
        }
    }
}
