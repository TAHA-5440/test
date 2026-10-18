// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final class l0 extends gb.m0 {
    public final gb.j1 i;

    public l0(long p1, gb.j1 p3)
    {
        super(p1);
        super.i = p3;
        return;
    }

    public final void run()
    {
        this.i.run();
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
