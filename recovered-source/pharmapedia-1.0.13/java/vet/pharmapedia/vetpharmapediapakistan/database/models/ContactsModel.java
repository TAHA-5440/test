// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.database.models;
public final class ContactsModel {
    private final int icon;
    private final boolean isSajid;
    private final String name;

    public ContactsModel(String p1, int p2, boolean p3)
    {
        p1.getClass();
        this.name = p1;
        this.icon = p2;
        this.isSajid = p3;
        return;
    }

    public static synthetic vet.pharmapedia.vetpharmapediapakistan.database.models.ContactsModel copy$default(vet.pharmapedia.vetpharmapediapakistan.database.models.ContactsModel p0, String p1, int p2, boolean p3, int p4, Object p5)
    {
        if ((p4 & 1) != 0) {
            p1 = p0.name;
        }
        if ((p4 & 2) != 0) {
            p2 = p0.icon;
        }
        if ((p4 & 4) != 0) {
            p3 = p0.isSajid;
        }
        return p0.copy(p1, p2, p3);
    }

    public final String component1()
    {
        return this.name;
    }

    public final int component2()
    {
        return this.icon;
    }

    public final boolean component3()
    {
        return this.isSajid;
    }

    public final vet.pharmapedia.vetpharmapediapakistan.database.models.ContactsModel copy(String p2, int p3, boolean p4)
    {
        p2.getClass();
        return new vet.pharmapedia.vetpharmapediapakistan.database.models.ContactsModel(p2, p3, p4);
    }

    public boolean equals(Object p5)
    {
        if (this != p5) {
            if ((p5 instanceof vet.pharmapedia.vetpharmapediapakistan.database.models.ContactsModel)) {
                if (kotlin.jvm.internal.f.a(this.name, ((vet.pharmapedia.vetpharmapediapakistan.database.models.ContactsModel) p5).name)) {
                    if (this.icon == ((vet.pharmapedia.vetpharmapediapakistan.database.models.ContactsModel) p5).icon) {
                        if (this.isSajid == ((vet.pharmapedia.vetpharmapediapakistan.database.models.ContactsModel) p5).isSajid) {
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

    public final int getIcon()
    {
        return this.icon;
    }

    public final String getName()
    {
        return this.name;
    }

    public int hashCode()
    {
        return (Boolean.hashCode(this.isSajid) + ((Integer.hashCode(this.icon) + (this.name.hashCode() * 31)) * 31));
    }

    public final boolean isSajid()
    {
        return this.isSajid;
    }

    public String toString()
    {
        String v0_0 = this.name;
        int v1 = this.icon;
        boolean v2 = this.isSajid;
        StringBuilder v3_1 = new StringBuilder("ContactsModel(name=");
        v3_1.append(v0_0);
        v3_1.append(", icon=");
        v3_1.append(v1);
        v3_1.append(", isSajid=");
        v3_1.append(v2);
        v3_1.append(")");
        return v3_1.toString();
    }
}
