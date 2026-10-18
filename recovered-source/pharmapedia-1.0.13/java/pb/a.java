// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package pb;
public final class a implements java.util.concurrent.Executor {
    public static final pb.a g;

    static a()
    {
        pb.a.g = new pb.a();
        return;
    }

    public final void execute(Runnable p1)
    {
        p1.run();
        return;
    }
}
