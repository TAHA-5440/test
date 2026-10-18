// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.database.models;
public final class MedicinesMainItemsModel implements java.io.Serializable {
    private final int itemIcon;
    private final String itemName;

    public MedicinesMainItemsModel(String p1, int p2)
    {
        p1.getClass();
        this.itemName = p1;
        this.itemIcon = p2;
        return;
    }

    public static synthetic vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesMainItemsModel copy$default(vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesMainItemsModel p0, String p1, int p2, int p3, Object p4)
    {
        if ((p3 & 1) != 0) {
            p1 = p0.itemName;
        }
        if ((p3 & 2) != 0) {
            p2 = p0.itemIcon;
        }
        return p0.copy(p1, p2);
    }

    public final String component1()
    {
        return this.itemName;
    }

    public final int component2()
    {
        return this.itemIcon;
    }

    public final vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesMainItemsModel copy(String p2, int p3)
    {
        p2.getClass();
        return new vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesMainItemsModel(p2, p3);
    }

    public boolean equals(Object p5)
    {
        if (this != p5) {
            if ((p5 instanceof vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesMainItemsModel)) {
                if (kotlin.jvm.internal.f.a(this.itemName, ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesMainItemsModel) p5).itemName)) {
                    if (this.itemIcon == ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesMainItemsModel) p5).itemIcon) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }

    public final int getItemIcon()
    {
        return this.itemIcon;
    }

    public final String getItemName()
    {
        return this.itemName;
    }

    public int hashCode()
    {
        return (Integer.hashCode(this.itemIcon) + (this.itemName.hashCode() * 31));
    }

    public String toString()
    {
        String v0_0 = this.itemName;
        int v1 = this.itemIcon;
        StringBuilder v2_1 = new StringBuilder("MedicinesMainItemsModel(itemName=");
        v2_1.append(v0_0);
        v2_1.append(", itemIcon=");
        v2_1.append(v1);
        v2_1.append(")");
        return v2_1.toString();
    }
}
