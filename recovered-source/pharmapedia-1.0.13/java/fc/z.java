// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package fc;
public final class z {
    public int a;
    public int b;
    public final Object c;

    public z(int p1)
    {
        switch (p1) {
            case 1:
                int v1_5 = new fc.z[256];
                this.c = v1_5;
                this.a = 0;
                this.b = 0;
                return;
            default:
                int v1_2 = new fc.z[256];
                this.c = v1_2;
                this.a = 0;
                this.b = 0;
                return;
        }
    }

    public z(int p1, int p2, int p3)
    {
        switch (p3) {
            case 1:
                this.c = 0;
                this.a = p1;
                int v1_2 = (p2 & 7);
                if (v1_2 == 0) {
                    v1_2 = 8;
                }
                this.b = v1_2;
                return;
            default:
                this.c = 0;
                this.a = p1;
                int v1_1 = (p2 & 7);
                if (v1_1 == 0) {
                    v1_1 = 8;
                }
                this.b = v1_1;
                return;
        }
    }

    public z(android.view.View p1)
    {
        this.c = p1;
        return;
    }

    public z(byte[] p1, int p2, int p3)
    {
        this.c = p1;
        this.a = p2;
        this.b = p3;
        return;
    }
}
