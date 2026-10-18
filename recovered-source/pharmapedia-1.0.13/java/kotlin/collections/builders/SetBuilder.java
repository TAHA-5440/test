// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package kotlin.collections.builders;
public final class SetBuilder extends ha.f implements java.util.Set, java.io.Serializable {
    public static final kotlin.collections.builders.SetBuilder h;
    public final kotlin.collections.builders.MapBuilder g;

    static SetBuilder()
    {
        kotlin.collections.builders.SetBuilder.h = new kotlin.collections.builders.SetBuilder(kotlin.collections.builders.MapBuilder.t);
        return;
    }

    public SetBuilder()
    {
        kotlin.collections.builders.MapBuilder v0_1 = new kotlin.collections.builders.MapBuilder();
        this.g = v0_1;
        return;
    }

    public SetBuilder(int p2)
    {
        kotlin.collections.builders.MapBuilder v0_1 = new kotlin.collections.builders.MapBuilder(p2);
        this.g = v0_1;
        return;
    }

    public SetBuilder(kotlin.collections.builders.MapBuilder p1)
    {
        p1.getClass();
        this.g = p1;
        return;
    }

    private final void readObject(java.io.ObjectInputStream p2)
    {
        throw new java.io.InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace()
    {
        if (!this.g.s) {
            throw new java.io.NotSerializableException("The set cannot be serialized while it is being built.");
        } else {
            return new kotlin.collections.builders.SerializedCollection(this, 1);
        }
    }

    public final int a()
    {
        return this.g.o;
    }

    public final boolean add(Object p2)
    {
        if (this.g.a(p2) < 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public final boolean addAll(java.util.Collection p2)
    {
        p2.getClass();
        this.g.c();
        return super.addAll(p2);
    }

    public final void clear()
    {
        this.g.clear();
        return;
    }

    public final boolean contains(Object p2)
    {
        return this.g.containsKey(p2);
    }

    public final boolean isEmpty()
    {
        return this.g.isEmpty();
    }

    public final java.util.Iterator iterator()
    {
        kotlin.collections.builders.MapBuilder v0 = this.g;
        v0.getClass();
        return new ia.b(v0, 1);
    }

    public final boolean remove(Object p2)
    {
        kotlin.collections.builders.MapBuilder v0 = this.g;
        v0.c();
        int v2_1 = v0.g(p2);
        if (v2_1 >= 0) {
            v0.k(v2_1);
            return 1;
        } else {
            return 0;
        }
    }

    public final boolean removeAll(java.util.Collection p2)
    {
        p2.getClass();
        this.g.c();
        return super.removeAll(p2);
    }

    public final boolean retainAll(java.util.Collection p2)
    {
        p2.getClass();
        this.g.c();
        return super.retainAll(p2);
    }
}
