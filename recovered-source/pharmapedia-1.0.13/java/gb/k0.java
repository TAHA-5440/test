// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class k0 extends gb.m0 {
    public final gb.h i;
    public final synthetic gb.o0 j;

    public k0(gb.o0 p1, long p2, gb.h p4)
    {
        this.j = p1;
        super(p2);
        super.i = p4;
        return;
    }

    public final void run()
    {
        this.i.B(this.j);
        return;
    }

    public final String toString()
    {
        String v0_1 = new StringBuilder();
        v0_1.append(super.toString());
        v0_1.append(this.i);
        return v0_1.toString();
    }
}
