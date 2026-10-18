// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package gb;
public final synthetic class h1 implements java.util.concurrent.ThreadFactory {

    public final Thread newThread(Runnable p3)
    {
        Thread v0_1 = new Thread(p3, "OSOperationRepoScope");
        v0_1.setDaemon(1);
        return v0_1;
    }
}
