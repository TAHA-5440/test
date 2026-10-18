// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.database.models;
public final class DisplayDosageModel implements java.io.Serializable {
    private final String animalName;
    private final String dosageDetail;
    private boolean isVisible;

    public DisplayDosageModel(String p1, String p2, boolean p3)
    {
        p1.getClass();
        p2.getClass();
        this.animalName = p1;
        this.dosageDetail = p2;
        this.isVisible = p3;
        return;
    }

    public synthetic DisplayDosageModel(String p1, String p2, boolean p3, int p4, kotlin.jvm.internal.c p5)
    {
        if ((p4 & 4) != 0) {
            p3 = 0;
        }
        this(p1, p2, p3);
        return;
    }

    public static synthetic vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel copy$default(vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel p0, String p1, String p2, boolean p3, int p4, Object p5)
    {
        if ((p4 & 1) != 0) {
            p1 = p0.animalName;
        }
        if ((p4 & 2) != 0) {
            p2 = p0.dosageDetail;
        }
        if ((p4 & 4) != 0) {
            p3 = p0.isVisible;
        }
        return p0.copy(p1, p2, p3);
    }

    public final String component1()
    {
        return this.animalName;
    }

    public final String component2()
    {
        return this.dosageDetail;
    }

    public final boolean component3()
    {
        return this.isVisible;
    }

    public final vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel copy(String p2, String p3, boolean p4)
    {
        p2.getClass();
        p3.getClass();
        return new vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel(p2, p3, p4);
    }

    public boolean equals(Object p5)
    {
        if (this != p5) {
            if ((p5 instanceof vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel)) {
                if (kotlin.jvm.internal.f.a(this.animalName, ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel) p5).animalName)) {
                    if (kotlin.jvm.internal.f.a(this.dosageDetail, ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel) p5).dosageDetail)) {
                        if (this.isVisible == ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayDosageModel) p5).isVisible) {
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

    public final String getAnimalName()
    {
        return this.animalName;
    }

    public final String getDosageDetail()
    {
        return this.dosageDetail;
    }

    public int hashCode()
    {
        return (Boolean.hashCode(this.isVisible) + r1.a.c((this.animalName.hashCode() * 31), 31, this.dosageDetail));
    }

    public final boolean isVisible()
    {
        return this.isVisible;
    }

    public final void setVisible(boolean p1)
    {
        this.isVisible = p1;
        return;
    }

    public String toString()
    {
        String v0_0 = this.animalName;
        String v1 = this.dosageDetail;
        boolean v2 = this.isVisible;
        StringBuilder v3_1 = new StringBuilder("DisplayDosageModel(animalName=");
        v3_1.append(v0_0);
        v3_1.append(", dosageDetail=");
        v3_1.append(v1);
        v3_1.append(", isVisible=");
        v3_1.append(v2);
        v3_1.append(")");
        return v3_1.toString();
    }
}
