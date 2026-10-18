// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ia;
public final class d extends ha.f {
    public final synthetic int g;
    public final kotlin.collections.builders.MapBuilder h;

    public synthetic d(kotlin.collections.builders.MapBuilder p1, int p2)
    {
        this.g = p2;
        this.h = p1;
        return;
    }

    public final int a()
    {
        switch (this.g) {
            case 0:
                return this.h.o;
            default:
                return this.h.o;
        }
    }

    public final boolean add(Object p2)
    {
        switch (this.g) {
            case 0:
                ((java.util.Map$Entry) p2).getClass();
                throw new UnsupportedOperationException();
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final boolean addAll(java.util.Collection p2)
    {
        int v0 = this.g;
        p2.getClass();
        switch (v0) {
            case 0:
                throw new UnsupportedOperationException();
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final void clear()
    {
        switch (this.g) {
            case 0:
                this.h.clear();
                return;
            default:
                this.h.clear();
                return;
        }
    }

    public final boolean contains(Object p4)
    {
        switch (this.g) {
            case 0:
                boolean v1 = 0;
                if ((p4 instanceof java.util.Map$Entry)) {
                    Object v0_5 = this.h;
                    v0_5.getClass();
                    int v2_0 = v0_5.g(((java.util.Map$Entry) p4).getKey());
                    if (v2_0 >= 0) {
                        Object v0_1 = v0_5.h;
                        v0_1.getClass();
                        v1 = kotlin.jvm.internal.f.a(v0_1[v2_0], ((java.util.Map$Entry) p4).getValue());
                    }
                }
                return v1;
            default:
                return this.h.containsKey(p4);
        }
    }

    public boolean containsAll(java.util.Collection p2)
    {
        switch (this.g) {
            case 0:
                p2.getClass();
                return this.h.e(p2);
            default:
                return super.containsAll(p2);
        }
    }

    public final boolean isEmpty()
    {
        switch (this.g) {
            case 0:
                return this.h.isEmpty();
            default:
                return this.h.isEmpty();
        }
    }

    public final java.util.Iterator iterator()
    {
        switch (this.g) {
            case 0:
                kotlin.collections.builders.MapBuilder v0_1 = this.h;
                v0_1.getClass();
                return new ia.b(v0_1, 0);
            default:
                kotlin.collections.builders.MapBuilder v0_2 = this.h;
                v0_2.getClass();
                return new ia.b(v0_2, 1);
        }
    }

    public final boolean remove(Object p5)
    {
        switch (this.g) {
            case 0:
                int v1 = 0;
                if ((p5 instanceof java.util.Map$Entry)) {
                    kotlin.collections.builders.MapBuilder v0_3 = this.h;
                    v0_3.getClass();
                    v0_3.c();
                    int v2_1 = v0_3.g(((java.util.Map$Entry) p5).getKey());
                    if (v2_1 >= 0) {
                        Object v3_0 = v0_3.h;
                        v3_0.getClass();
                        if (kotlin.jvm.internal.f.a(v3_0[v2_1], ((java.util.Map$Entry) p5).getValue())) {
                            v0_3.k(v2_1);
                            v1 = 1;
                        }
                    }
                }
                return v1;
            default:
                boolean v5_4;
                kotlin.collections.builders.MapBuilder v0_2 = this.h;
                v0_2.c();
                boolean v5_3 = v0_2.g(p5);
                if (v5_3) {
                    v0_2.k(v5_3);
                    v5_4 = 1;
                } else {
                    v5_4 = 0;
                }
                return v5_4;
        }
    }

    public final boolean removeAll(java.util.Collection p2)
    {
        kotlin.collections.builders.MapBuilder v0_0 = this.g;
        p2.getClass();
        switch (v0_0) {
            case 0:
                this.h.c();
                return super.removeAll(p2);
            default:
                this.h.c();
                return super.removeAll(p2);
        }
    }

    public final boolean retainAll(java.util.Collection p2)
    {
        kotlin.collections.builders.MapBuilder v0_0 = this.g;
        p2.getClass();
        switch (v0_0) {
            case 0:
                this.h.c();
                return super.retainAll(p2);
            default:
                this.h.c();
                return super.retainAll(p2);
        }
    }
}
