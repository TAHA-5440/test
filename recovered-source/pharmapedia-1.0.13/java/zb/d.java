// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package zb;
public final synthetic class d implements java.util.concurrent.ThreadFactory {
    public final synthetic String g;
    public final synthetic boolean h;

    public synthetic d(String p1, boolean p2)
    {
        this.g = p1;
        this.h = p2;
        return;
    }

    public final Thread newThread(Runnable p3)
    {
        Thread v0_1 = new Thread(p3, this.g);
        v0_1.setDaemon(this.h);
        return v0_1;
    }
}
