// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package sb;
public final class a {
    public final String a;
    public final java.util.ArrayList b;
    public final java.util.HashSet c;
    public final java.util.ArrayList d;
    public final java.util.ArrayList e;
    public final java.util.ArrayList f;

    public a(String p1)
    {
        this.a = p1;
        this.b = new java.util.ArrayList();
        this.c = new java.util.HashSet();
        this.d = new java.util.ArrayList();
        this.e = new java.util.ArrayList();
        this.f = new java.util.ArrayList();
        return;
    }

    public static void a(sb.a p1, String p2, vb.m p3)
    {
        p1.getClass();
        if (!p1.c.add(p2)) {
            IllegalArgumentException v2_7 = r1.a.w("Element with name \'", p2, "\' is already registered in ");
            v2_7.append(p1.a);
            throw new IllegalArgumentException(v2_7.toString().toString());
        } else {
            p1.b.add(p2);
            p1.d.add(p3);
            p1.e.add(kotlin.collections.EmptyList.g);
            p1.f.add(Boolean.valueOf(0));
            return;
        }
    }
}
