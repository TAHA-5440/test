// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package lb;
public final class n {
    private volatile java.util.concurrent.atomic.AtomicReferenceArray array;

    public n(int p2)
    {
        this.array = new java.util.concurrent.atomic.AtomicReferenceArray(p2);
        return;
    }

    public final int a()
    {
        return this.array.length();
    }

    public final Object b(int p3)
    {
        java.util.concurrent.atomic.AtomicReferenceArray v0 = this.array;
        if (p3 >= v0.length()) {
            return 0;
        } else {
            return v0.get(p3);
        }
    }

    public final void c(int p6, nb.a p7)
    {
        java.util.concurrent.atomic.AtomicReferenceArray v0 = this.array;
        int v1 = v0.length();
        if (p6 >= v1) {
            int v3_1 = (p6 + 1);
            Object v4_1 = (v1 * 2);
            if (v3_1 < v4_1) {
                v3_1 = v4_1;
            }
            java.util.concurrent.atomic.AtomicReferenceArray v2_1 = new java.util.concurrent.atomic.AtomicReferenceArray(v3_1);
            int v3_0 = 0;
            while (v3_0 < v1) {
                v2_1.set(v3_0, v0.get(v3_0));
                v3_0++;
            }
            v2_1.set(p6, p7);
            this.array = v2_1;
            return;
        } else {
            v0.set(p6, p7);
            return;
        }
    }
}
