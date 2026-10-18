// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package tc;
public final synthetic class c implements ua.l {
    public final synthetic int g;
    public final synthetic int h;
    public final synthetic String i;

    public synthetic c(int p1, String p2, int p3)
    {
        this.g = p3;
        this.h = p1;
        this.i = p2;
        return;
    }

    public final Object invoke(Object p6)
    {
        switch (this.g) {
            case 0:
                Throwable v0_4 = this.h;
                String v1_1 = this.i;
                ((e2.a) p6).getClass();
                ga.p v6_5 = ((e2.a) p6).b0("UPDATE medicines_table SET isSaltFavourite = ? WHERE saltName = ?");
                try {
                    v6_5.c(1, ((long) v0_4));
                    v6_5.x(2, v1_1);
                    v6_5.V();
                    v6_5.close();
                } catch (Throwable v0_2) {
                    v6_5.close();
                    throw v0_2;
                }
                break;
            default:
                Throwable v0_3 = this.h;
                String v1_0 = this.i;
                ((e2.a) p6).getClass();
                ga.p v6_2 = ((e2.a) p6).b0("UPDATE medicines_table SET isBrandFavourite = ? WHERE brandName = ?");
                try {
                    v6_2.c(1, ((long) v0_3));
                    v6_2.x(2, v1_0);
                    v6_2.V();
                    v6_2.close();
                } catch (Throwable v0_6) {
                    v6_2.close();
                    throw v0_6;
                }
        }
        return ga.p.a;
    }
}
