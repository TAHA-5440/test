// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.database.models;
public final class ThemesModel {
    private final int selectedTheme;

    public ThemesModel(int p1)
    {
        this.selectedTheme = p1;
        return;
    }

    public static synthetic vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel copy$default(vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel p0, int p1, int p2, Object p3)
    {
        if ((p2 & 1) != 0) {
            p1 = p0.selectedTheme;
        }
        return p0.copy(p1);
    }

    public final int component1()
    {
        return this.selectedTheme;
    }

    public final vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel copy(int p2)
    {
        return new vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel(p2);
    }

    public boolean equals(Object p4)
    {
        if (this != p4) {
            if ((p4 instanceof vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel)) {
                if (this.selectedTheme == ((vet.pharmapedia.vetpharmapediapakistan.database.models.ThemesModel) p4).selectedTheme) {
                    return 1;
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

    public final int getSelectedTheme()
    {
        return this.selectedTheme;
    }

    public int hashCode()
    {
        return Integer.hashCode(this.selectedTheme);
    }

    public String toString()
    {
        return r1.a.h(this.selectedTheme, "ThemesModel(selectedTheme=", ")");
    }
}
