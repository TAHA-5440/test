// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.database.models;
public final class SettingsModel {
    private final String description;
    private final String heading;
    private final int icon;

    public SettingsModel(int p1, String p2, String p3)
    {
        p2.getClass();
        p3.getClass();
        this.icon = p1;
        this.heading = p2;
        this.description = p3;
        return;
    }

    public static synthetic vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel copy$default(vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel p0, int p1, String p2, String p3, int p4, Object p5)
    {
        if ((p4 & 1) != 0) {
            p1 = p0.icon;
        }
        if ((p4 & 2) != 0) {
            p2 = p0.heading;
        }
        if ((p4 & 4) != 0) {
            p3 = p0.description;
        }
        return p0.copy(p1, p2, p3);
    }

    public final int component1()
    {
        return this.icon;
    }

    public final String component2()
    {
        return this.heading;
    }

    public final String component3()
    {
        return this.description;
    }

    public final vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel copy(int p2, String p3, String p4)
    {
        p3.getClass();
        p4.getClass();
        return new vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel(p2, p3, p4);
    }

    public boolean equals(Object p5)
    {
        if (this != p5) {
            if ((p5 instanceof vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel)) {
                if (this.icon == ((vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel) p5).icon) {
                    if (kotlin.jvm.internal.f.a(this.heading, ((vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel) p5).heading)) {
                        if (kotlin.jvm.internal.f.a(this.description, ((vet.pharmapedia.vetpharmapediapakistan.database.models.SettingsModel) p5).description)) {
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
                return 0;
            }
        } else {
            return 1;
        }
    }

    public final String getDescription()
    {
        return this.description;
    }

    public final String getHeading()
    {
        return this.heading;
    }

    public final int getIcon()
    {
        return this.icon;
    }

    public int hashCode()
    {
        return (this.description.hashCode() + r1.a.c((Integer.hashCode(this.icon) * 31), 31, this.heading));
    }

    public String toString()
    {
        String v0_0 = this.icon;
        String v1 = this.heading;
        String v2 = this.description;
        StringBuilder v3_1 = new StringBuilder("SettingsModel(icon=");
        v3_1.append(v0_0);
        v3_1.append(", heading=");
        v3_1.append(v1);
        v3_1.append(", description=");
        return r1.a.n(v2, ")", v3_1);
    }
}
