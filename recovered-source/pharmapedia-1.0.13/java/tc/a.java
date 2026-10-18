// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package tc;
public final class a extends androidx.room.i0 {
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.database.roomDB.MedicinesDBClass_Impl d;

    public a(vet.pharmapedia.vetpharmapediapakistan.database.roomDB.MedicinesDBClass_Impl p3)
    {
        this.d = p3;
        super(1, "50f823fe6c34df7bee781a4d1795eb7e", "c86149d912818c12ecd0db7ac935fff1");
        return;
    }

    public final void a(e2.a p2)
    {
        p2.getClass();
        g6.f0.e(p2, "CREATE TABLE IF NOT EXISTS `medicines_table` (`docId` TEXT NOT NULL, `timeStamp` INTEGER NOT NULL, `saltName` TEXT NOT NULL, `brandName` TEXT NOT NULL, `contraIndications` TEXT NOT NULL, `overview` TEXT NOT NULL, `indications` TEXT NOT NULL, `companyName` TEXT NOT NULL, `countryName` TEXT NOT NULL, `isBrandFavourite` INTEGER NOT NULL, `isSaltFavourite` INTEGER NOT NULL, `block` TEXT NOT NULL, `availableForms` TEXT NOT NULL, `dosageDetail` TEXT NOT NULL, PRIMARY KEY(`docId`))");
        g6.f0.e(p2, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        g6.f0.e(p2, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \'50f823fe6c34df7bee781a4d1795eb7e\')");
        return;
    }

    public final void b(e2.a p2)
    {
        p2.getClass();
        g6.f0.e(p2, "DROP TABLE IF EXISTS `medicines_table`");
        return;
    }

    public final void c(e2.a p1)
    {
        p1.getClass();
        return;
    }

    public final void d(e2.a p2)
    {
        p2.getClass();
        this.d.internalInitInvalidationTracker(p2);
        return;
    }

    public final void e(e2.a p1)
    {
        p1.getClass();
        return;
    }

    public final void f(e2.a p1)
    {
        p1.getClass();
        androidx.room.util.a.a(p1);
        return;
    }

    public final a7.j g(e2.a p17)
    {
        p17.getClass();
        a7.j v0_6 = new java.util.LinkedHashMap();
        v0_6.put("docId", new b2.c("docId", "TEXT", 1, 1, 0, 1));
        v0_6.put("timeStamp", new b2.c("timeStamp", "INTEGER", 1, 0, 0, 1));
        v0_6.put("saltName", new b2.c("saltName", "TEXT", 1, 0, 0, 1));
        v0_6.put("brandName", new b2.c("brandName", "TEXT", 1, 0, 0, 1));
        v0_6.put("contraIndications", new b2.c("contraIndications", "TEXT", 1, 0, 0, 1));
        v0_6.put("overview", new b2.c("overview", "TEXT", 1, 0, 0, 1));
        v0_6.put("indications", new b2.c("indications", "TEXT", 1, 0, 0, 1));
        v0_6.put("companyName", new b2.c("companyName", "TEXT", 1, 0, 0, 1));
        v0_6.put("countryName", new b2.c("countryName", "TEXT", 1, 0, 0, 1));
        v0_6.put("isBrandFavourite", new b2.c("isBrandFavourite", "INTEGER", 1, 0, 0, 1));
        v0_6.put("isSaltFavourite", new b2.c("isSaltFavourite", "INTEGER", 1, 0, 0, 1));
        v0_6.put("block", new b2.c("block", "TEXT", 1, 0, 0, 1));
        v0_6.put("availableForms", new b2.c("availableForms", "TEXT", 1, 0, 0, 1));
        v0_6.put("dosageDetail", new b2.c("dosageDetail", "TEXT", 1, 0, 0, 1));
        String v3_3 = new b2.f("medicines_table", v0_6, new java.util.LinkedHashSet(), new java.util.LinkedHashSet());
        a7.j v0_2 = com.bumptech.glide.d.x(p17, "medicines_table");
        if (v3_3.equals(v0_2)) {
            return new a7.j(0, 1);
        } else {
            int v2_5 = new StringBuilder("medicines_table(vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel).\n Expected:\n");
            v2_5.append(v3_3);
            v2_5.append("\n Found:\n");
            v2_5.append(v0_2);
            return new a7.j(v2_5.toString(), 0);
        }
    }
}
