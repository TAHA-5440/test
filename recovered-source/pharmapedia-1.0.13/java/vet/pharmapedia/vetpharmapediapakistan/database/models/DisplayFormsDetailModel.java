// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.database.models;
public final class DisplayFormsDetailModel implements java.io.Serializable {
    private String formName;
    private String packing;
    private String price;
    private String saltName;
    private String weight;

    public DisplayFormsDetailModel()
    {
        this(0, 0, 0, 0, 0, 31, 0);
        return;
    }

    public DisplayFormsDetailModel(String p1, String p2, String p3, String p4, String p5)
    {
        p1.getClass();
        p2.getClass();
        p3.getClass();
        p4.getClass();
        p5.getClass();
        this.packing = p1;
        this.price = p2;
        this.weight = p3;
        this.saltName = p4;
        this.formName = p5;
        return;
    }

    public synthetic DisplayFormsDetailModel(String p2, String p3, String p4, String p5, String p6, int p7, kotlin.jvm.internal.c p8)
    {
        if ((p7 & 1) != 0) {
            p2 = "";
        }
        if ((p7 & 2) != 0) {
            p3 = "";
        }
        if ((p7 & 4) != 0) {
            p4 = "";
        }
        if ((p7 & 8) != 0) {
            p5 = "";
        }
        String v7_2;
        if ((p7 & 16) == 0) {
            v7_2 = p6;
        } else {
            v7_2 = "";
        }
        this(p2, p3, p4, p5, v7_2);
        return;
    }

    public static synthetic vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsDetailModel copy$default(vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsDetailModel p0, String p1, String p2, String p3, String p4, String p5, int p6, Object p7)
    {
        if ((p6 & 1) != 0) {
            p1 = p0.packing;
        }
        if ((p6 & 2) != 0) {
            p2 = p0.price;
        }
        if ((p6 & 4) != 0) {
            p3 = p0.weight;
        }
        if ((p6 & 8) != 0) {
            p4 = p0.saltName;
        }
        if ((p6 & 16) != 0) {
            p5 = p0.formName;
        }
        return p0.copy(p1, p2, p3, p4, p5);
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

    public final String component4()
    {
        return this.saltName;
    }

    public final String component5()
    {
        return this.formName;
    }

    public final vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsDetailModel copy(String p7, String p8, String p9, String p10, String p11)
    {
        p7.getClass();
        p8.getClass();
        p9.getClass();
        p10.getClass();
        p11.getClass();
        return new vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsDetailModel(p7, p8, p9, p10, p11);
    }

    public boolean equals(Object p5)
    {
        if (this != p5) {
            if ((p5 instanceof vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsDetailModel)) {
                if (kotlin.jvm.internal.f.a(this.packing, ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsDetailModel) p5).packing)) {
                    if (kotlin.jvm.internal.f.a(this.price, ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsDetailModel) p5).price)) {
                        if (kotlin.jvm.internal.f.a(this.weight, ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsDetailModel) p5).weight)) {
                            if (kotlin.jvm.internal.f.a(this.saltName, ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsDetailModel) p5).saltName)) {
                                if (kotlin.jvm.internal.f.a(this.formName, ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsDetailModel) p5).formName)) {
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
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }

    public final String getFormName()
    {
        return this.formName;
    }

    public final String getPacking()
    {
        return this.packing;
    }

    public final String getPrice()
    {
        return this.price;
    }

    public final String getSaltName()
    {
        return this.saltName;
    }

    public final String getWeight()
    {
        return this.weight;
    }

    public int hashCode()
    {
        return (this.formName.hashCode() + r1.a.c(r1.a.c(r1.a.c((this.packing.hashCode() * 31), 31, this.price), 31, this.weight), 31, this.saltName));
    }

    public final void setFormName(String p1)
    {
        p1.getClass();
        this.formName = p1;
        return;
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

    public final void setSaltName(String p1)
    {
        p1.getClass();
        this.saltName = p1;
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
        String v1_0 = this.price;
        String v2 = this.weight;
        String v3 = this.saltName;
        String v4 = this.formName;
        StringBuilder v5_1 = new StringBuilder("DisplayFormsDetailModel(packing=");
        v5_1.append(v0_0);
        v5_1.append(", price=");
        v5_1.append(v1_0);
        v5_1.append(", weight=");
        f0.a.j(v5_1, v2, ", saltName=", v3, ", formName=");
        return r1.a.n(v4, ")", v5_1);
    }
}
