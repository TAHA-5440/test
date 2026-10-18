// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.database.models;
public final class DisplayFormsModel implements java.io.Serializable {
    private final String formName;
    private boolean isVisible;
    private java.util.ArrayList list;

    public DisplayFormsModel(String p1, boolean p2, java.util.ArrayList p3)
    {
        p3.getClass();
        this.formName = p1;
        this.isVisible = p2;
        this.list = p3;
        return;
    }

    public synthetic DisplayFormsModel(String p1, boolean p2, java.util.ArrayList p3, int p4, kotlin.jvm.internal.c p5)
    {
        if ((p4 & 1) != 0) {
            p1 = 0;
        }
        if ((p4 & 2) != 0) {
            p2 = 0;
        }
        this(p1, p2, p3);
        return;
    }

    public static synthetic vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsModel copy$default(vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsModel p0, String p1, boolean p2, java.util.ArrayList p3, int p4, Object p5)
    {
        if ((p4 & 1) != 0) {
            p1 = p0.formName;
        }
        if ((p4 & 2) != 0) {
            p2 = p0.isVisible;
        }
        if ((p4 & 4) != 0) {
            p3 = p0.list;
        }
        return p0.copy(p1, p2, p3);
    }

    public final String component1()
    {
        return this.formName;
    }

    public final boolean component2()
    {
        return this.isVisible;
    }

    public final java.util.ArrayList component3()
    {
        return this.list;
    }

    public final vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsModel copy(String p2, boolean p3, java.util.ArrayList p4)
    {
        p4.getClass();
        return new vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsModel(p2, p3, p4);
    }

    public boolean equals(Object p5)
    {
        if (this != p5) {
            if ((p5 instanceof vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsModel)) {
                if (kotlin.jvm.internal.f.a(this.formName, ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsModel) p5).formName)) {
                    if (this.isVisible == ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsModel) p5).isVisible) {
                        if (kotlin.jvm.internal.f.a(this.list, ((vet.pharmapedia.vetpharmapediapakistan.database.models.DisplayFormsModel) p5).list)) {
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

    public final String getFormName()
    {
        return this.formName;
    }

    public final java.util.ArrayList getList()
    {
        return this.list;
    }

    public int hashCode()
    {
        int v0_4;
        int v0_0 = this.formName;
        if (v0_0 != 0) {
            v0_4 = v0_0.hashCode();
        } else {
            v0_4 = 0;
        }
        return (this.list.hashCode() + ((Boolean.hashCode(this.isVisible) + (v0_4 * 31)) * 31));
    }

    public final boolean isVisible()
    {
        return this.isVisible;
    }

    public final void setList(java.util.ArrayList p1)
    {
        p1.getClass();
        this.list = p1;
        return;
    }

    public final void setVisible(boolean p1)
    {
        this.isVisible = p1;
        return;
    }

    public String toString()
    {
        String v0_0 = this.formName;
        boolean v1 = this.isVisible;
        java.util.ArrayList v2 = this.list;
        StringBuilder v3_1 = new StringBuilder("DisplayFormsModel(formName=");
        v3_1.append(v0_0);
        v3_1.append(", isVisible=");
        v3_1.append(v1);
        v3_1.append(", list=");
        v3_1.append(v2);
        v3_1.append(")");
        return v3_1.toString();
    }
}
