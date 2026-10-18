// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.database.models;
public final class SlidersModel {
    private String anyNote;
    private String buttonText;
    private boolean canShow;
    private String picLink;
    private String redirectLink;

    public SlidersModel()
    {
        this(0, 0, 0, 0, 0, 31, 0);
        return;
    }

    public SlidersModel(String p1, String p2, String p3, String p4, boolean p5)
    {
        p1.getClass();
        p2.getClass();
        p3.getClass();
        p4.getClass();
        this.picLink = p1;
        this.buttonText = p2;
        this.anyNote = p3;
        this.redirectLink = p4;
        this.canShow = p5;
        return;
    }

    public synthetic SlidersModel(String p2, String p3, String p4, String p5, boolean p6, int p7, kotlin.jvm.internal.c p8)
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
        if ((p7 & 16) != 0) {
            p6 = 1;
        }
        this(p2, p3, p4, p5, p6);
        return;
    }

    public static synthetic vet.pharmapedia.vetpharmapediapakistan.database.models.SlidersModel copy$default(vet.pharmapedia.vetpharmapediapakistan.database.models.SlidersModel p0, String p1, String p2, String p3, String p4, boolean p5, int p6, Object p7)
    {
        if ((p6 & 1) != 0) {
            p1 = p0.picLink;
        }
        if ((p6 & 2) != 0) {
            p2 = p0.buttonText;
        }
        if ((p6 & 4) != 0) {
            p3 = p0.anyNote;
        }
        if ((p6 & 8) != 0) {
            p4 = p0.redirectLink;
        }
        if ((p6 & 16) != 0) {
            p5 = p0.canShow;
        }
        return p0.copy(p1, p2, p3, p4, p5);
    }

    public final String component1()
    {
        return this.picLink;
    }

    public final String component2()
    {
        return this.buttonText;
    }

    public final String component3()
    {
        return this.anyNote;
    }

    public final String component4()
    {
        return this.redirectLink;
    }

    public final boolean component5()
    {
        return this.canShow;
    }

    public final vet.pharmapedia.vetpharmapediapakistan.database.models.SlidersModel copy(String p7, String p8, String p9, String p10, boolean p11)
    {
        p7.getClass();
        p8.getClass();
        p9.getClass();
        p10.getClass();
        return new vet.pharmapedia.vetpharmapediapakistan.database.models.SlidersModel(p7, p8, p9, p10, p11);
    }

    public boolean equals(Object p5)
    {
        if (this != p5) {
            if ((p5 instanceof vet.pharmapedia.vetpharmapediapakistan.database.models.SlidersModel)) {
                if (kotlin.jvm.internal.f.a(this.picLink, ((vet.pharmapedia.vetpharmapediapakistan.database.models.SlidersModel) p5).picLink)) {
                    if (kotlin.jvm.internal.f.a(this.buttonText, ((vet.pharmapedia.vetpharmapediapakistan.database.models.SlidersModel) p5).buttonText)) {
                        if (kotlin.jvm.internal.f.a(this.anyNote, ((vet.pharmapedia.vetpharmapediapakistan.database.models.SlidersModel) p5).anyNote)) {
                            if (kotlin.jvm.internal.f.a(this.redirectLink, ((vet.pharmapedia.vetpharmapediapakistan.database.models.SlidersModel) p5).redirectLink)) {
                                if (this.canShow == ((vet.pharmapedia.vetpharmapediapakistan.database.models.SlidersModel) p5).canShow) {
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

    public final String getAnyNote()
    {
        return this.anyNote;
    }

    public final String getButtonText()
    {
        return this.buttonText;
    }

    public final boolean getCanShow()
    {
        return this.canShow;
    }

    public final String getPicLink()
    {
        return this.picLink;
    }

    public final String getRedirectLink()
    {
        return this.redirectLink;
    }

    public int hashCode()
    {
        return (Boolean.hashCode(this.canShow) + r1.a.c(r1.a.c(r1.a.c((this.picLink.hashCode() * 31), 31, this.buttonText), 31, this.anyNote), 31, this.redirectLink));
    }

    public final void setAnyNote(String p1)
    {
        p1.getClass();
        this.anyNote = p1;
        return;
    }

    public final void setButtonText(String p1)
    {
        p1.getClass();
        this.buttonText = p1;
        return;
    }

    public final void setCanShow(boolean p1)
    {
        this.canShow = p1;
        return;
    }

    public final void setPicLink(String p1)
    {
        p1.getClass();
        this.picLink = p1;
        return;
    }

    public final void setRedirectLink(String p1)
    {
        p1.getClass();
        this.redirectLink = p1;
        return;
    }

    public String toString()
    {
        String v0_0 = this.picLink;
        String v1_0 = this.buttonText;
        String v2 = this.anyNote;
        String v3 = this.redirectLink;
        boolean v4 = this.canShow;
        StringBuilder v5_1 = new StringBuilder("SlidersModel(picLink=");
        v5_1.append(v0_0);
        v5_1.append(", buttonText=");
        v5_1.append(v1_0);
        v5_1.append(", anyNote=");
        f0.a.j(v5_1, v2, ", redirectLink=", v3, ", canShow=");
        v5_1.append(v4);
        v5_1.append(")");
        return v5_1.toString();
    }
}
