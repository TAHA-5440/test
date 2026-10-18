// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package nb;
public final class h extends nb.g {
    public final Runnable i;

    public h(Runnable p1, long p2, boolean p4)
    {
        super(p2, p4);
        super.i = p1;
        return;
    }

    public final void run()
    {
        this.i.run();
        return;
    }

    public final String toString()
    {
        String v1_4;
        String v0_1 = new StringBuilder("Task[");
        String v1_5 = this.i;
        v0_1.append(v1_5.getClass().getSimpleName());
        v0_1.append(64);
        v0_1.append(gb.w.l(v1_5));
        v0_1.append(", ");
        v0_1.append(this.g);
        v0_1.append(", ");
        if (!this.h) {
            v1_4 = "Non-blocking";
        } else {
            v1_4 = "Blocking";
        }
        return r1.a.r(v0_1, v1_4, 93);
    }
}
