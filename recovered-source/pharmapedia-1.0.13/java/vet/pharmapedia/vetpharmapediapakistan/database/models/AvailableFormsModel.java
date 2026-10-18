// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.database.models;
public final class AvailableFormsModel implements java.io.Serializable {
    private String packing;
    private String price;
    private String weight;

    public AvailableFormsModel()
    {
        this(0, 0, 0, 7, 0);
        return;
    }

    public AvailableFormsModel(String p1, String p2, String p3)
    {
        p1.getClass();
        p2.getClass();
        p3.getClass();
        this.packing = p1;
        this.price = p2;
        this.weight = p3;
        return;
    }

    public synthetic AvailableFormsModel(String p2, String p3, String p4, int p5, kotlin.jvm.internal.c p6)
    {
        if ((p5 & 1) != 0) {
            p2 = "";
        }
        if ((p5 & 2) != 0) {
            p3 = "";
        }
        if ((p5 & 4) != 0) {
            p4 = "";
        }
        this(p2, p3, p4);
        return;
    }

    public static synthetic vet.pharmapedia.vetpharmapediapakistan.database.models.AvailableFormsModel copy$default(vet.pharmapedia.vetpharmapediapakistan.database.models.AvailableFormsModel p0, String p1, String p2, String p3, int p4, Object p5)
    {
        if ((p4 & 1) != 0) {
            p1 = p0.packing;
        }
        if ((p4 & 2) != 0) {
            p2 = p0.price;
        }
        if ((p4 & 4) != 0) {
            p3 = p0.weight;
        }
        return p0.copy(p1, p2, p3);
    }

    public final String component1()
    {
        return this.packing;
    }

    public final String component2()
    {
        return this.price;
    }

    public final String component3()
    {
        return this.weight;
    }

    public final vet.pharmapedia.vetpharmapediapakistan.database.models.AvailableFormsModel copy(String p2, String p3, String p4)
    {
        p2.getClass();
        p3.getClass();
        p4.getClass();
        return new vet.pharmapedia.vetpharmapediapakistan.database.models.AvailableFormsModel(p2, p3, p4);
    }

    public boolean equals(Object p5)
    {
        if (this != p5) {
            if ((p5 instanceof vet.pharmapedia.vetpharmapediapakistan.database.models.AvailableFormsModel)) {
                if (kotlin.jvm.internal.f.a(this.packing, ((vet.pharmapedia.vetpharmapediapakistan.database.models.AvailableFormsModel) p5).packing)) {
                    if (kotlin.jvm.internal.f.a(this.price, ((vet.pharmapedia.vetpharmapediapakistan.database.models.AvailableFormsModel) p5).price)) {
                        if (kotlin.jvm.internal.f.a(this.weight, ((vet.pharmapedia.vetpharmapediapakistan.database.models.AvailableFormsModel) p5).weight)) {
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

    public final String getPacking()
    {
        return this.packing;
    }

    public final String getPrice()
    {
        return this.price;
    }

    public final String getWeight()
    {
        return this.weight;
    }

    public int hashCode()
    {
        return (this.weight.hashCode() + r1.a.c((this.packing.hashCode() * 31), 31, this.price));
    }

    public final void setPacking(String p1)
    {
        p1.getClass();
        this.packing = p1;
        return;
    }

    public final void setPrice(String p1)
    {
        p1.getClass();
        this.price = p1;
        return;
    }

    public final void setWeight(String p1)
    {
        p1.getClass();
        this.weight = p1;
        return;
    }

    public String toString()
    {
        String v0_0 = this.packing;
        String v1 = this.price;
        String v2 = this.weight;
        StringBuilder v3_1 = new StringBuilder("AvailableFormsModel(packing=");
        v3_1.append(v0_0);
        v3_1.append(", price=");
        v3_1.append(v1);
        v3_1.append(", weight=");
        return r1.a.n(v2, ")", v3_1);
    }
}
