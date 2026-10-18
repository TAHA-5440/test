// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.database.roomDB;
public final class MedicinesDBClass_Impl extends vet.pharmapedia.vetpharmapediapakistan.database.roomDB.MedicinesDBClass {
    public final ga.e a;

    public MedicinesDBClass_Impl()
    {
        this.a = kotlin.a.b(new androidx.activity.e(this, 10));
        return;
    }

    public final tc.e b()
    {
        return ((tc.e) this.a.getValue());
    }

    public final void clearAllTables()
    {
        this.performClear(0, new String[] {"medicines_table"}));
        return;
    }

    public final java.util.List createAutoMigrations(java.util.Map p1)
    {
        p1.getClass();
        return new java.util.ArrayList();
    }

    public final androidx.room.l createInvalidationTracker()
    {
        return new androidx.room.l(this, new java.util.LinkedHashMap(), new java.util.LinkedHashMap(), new String[] {"medicines_table"}));
    }

    public final androidx.room.j0 createOpenDelegate()
    {
        return new tc.a(this);
    }

    public final java.util.Set getRequiredAutoMigrationSpecClasses()
    {
        return new java.util.LinkedHashSet();
    }

    public final java.util.Map getRequiredTypeConverterClasses()
    {
        java.util.LinkedHashMap v0_1 = new java.util.LinkedHashMap();
        v0_1.put(kotlin.jvm.internal.h.a(tc.e), kotlin.collections.EmptyList.g);
        return v0_1;
    }
}
