// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.database.models;
public final class LanguagesModel implements java.io.Serializable {
    private int flag;
    private int name;
    private String speakAvailable;
    private String speechAvailable;
    private String translationAbbr;

    public LanguagesModel(int p1, int p2, String p3, String p4, String p5)
    {
        p3.getClass();
        p4.getClass();
        p5.getClass();
        this.name = p1;
        this.flag = p2;
        this.speakAvailable = p3;
        this.speechAvailable = p4;
        this.translationAbbr = p5;
        return;
    }

    public synthetic LanguagesModel(int p2, int p3, String p4, String p5, String p6, int p7, kotlin.jvm.internal.c p8)
    {
        if ((p7 & 1) != 0) {
            p2 = 0;
        }
        int v5_1;
        String v6_1;
        String v7_1;
        int v4_1;
        if ((p7 & 2) == 0) {
            v7_1 = p6;
            v6_1 = p5;
            v5_1 = p4;
            v4_1 = p3;
        } else {
            v7_1 = p6;
            v6_1 = p5;
            v5_1 = p4;
            v4_1 = 0;
        }
        this(p2, v4_1, v5_1, v6_1, v7_1);
        return;
    }

    public static synthetic vet.pharmapedia.vetpharmapediapakistan.database.models.LanguagesModel copy$default(vet.pharmapedia.vetpharmapediapakistan.database.models.LanguagesModel p0, int p1, int p2, String p3, String p4, String p5, int p6, Object p7)
    {
        if ((p6 & 1) != 0) {
            p1 = p0.name;
        }
        if ((p6 & 2) != 0) {
            p2 = p0.flag;
        }
        if ((p6 & 4) != 0) {
            p3 = p0.speakAvailable;
        }
        if ((p6 & 8) != 0) {
            p4 = p0.speechAvailable;
        }
        if ((p6 & 16) != 0) {
            p5 = p0.translationAbbr;
        }
        return p0.copy(p1, p2, p3, p4, p5);
    }

    public final int component1()
    {
        return this.name;
    }

    public final int component2()
    {
        return this.flag;
    }

    public final String component3()
    {
        return this.speakAvailable;
    }

    public final String component4()
    {
        return this.speechAvailable;
    }

    public final String component5()
    {
        return this.translationAbbr;
    }

    public final vet.pharmapedia.vetpharmapediapakistan.database.models.LanguagesModel copy(int p7, int p8, String p9, String p10, String p11)
    {
        p9.getClass();
        p10.getClass();
        p11.getClass();
        return new vet.pharmapedia.vetpharmapediapakistan.database.models.LanguagesModel(p7, p8, p9, p10, p11);
    }

    public boolean equals(Object p5)
    {
        if (this != p5) {
            if ((p5 instanceof vet.pharmapedia.vetpharmapediapakistan.database.models.LanguagesModel)) {
                if (this.name == ((vet.pharmapedia.vetpharmapediapakistan.database.models.LanguagesModel) p5).name) {
                    if (this.flag == ((vet.pharmapedia.vetpharmapediapakistan.database.models.LanguagesModel) p5).flag) {
                        if (kotlin.jvm.internal.f.a(this.speakAvailable, ((vet.pharmapedia.vetpharmapediapakistan.database.models.LanguagesModel) p5).speakAvailable)) {
                            if (kotlin.jvm.internal.f.a(this.speechAvailable, ((vet.pharmapedia.vetpharmapediapakistan.database.models.LanguagesModel) p5).speechAvailable)) {
                                if (kotlin.jvm.internal.f.a(this.translationAbbr, ((vet.pharmapedia.vetpharmapediapakistan.database.models.LanguagesModel) p5).translationAbbr)) {
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

    public final int getFlag()
    {
        return this.flag;
    }

    public final int getName()
    {
        return this.name;
    }

    public final String getName(android.app.Activity p2)
    {
        if ((p2 == null) || (p2.isFinishing())) {
            return "";
        } else {
            String v2_2 = p2.getString(this.name);
            v2_2.getClass();
            return v2_2;
        }
    }

    public final String getName(android.content.Context p2)
    {
        if (p2 != null) {
            String v2_1 = p2.getString(this.name);
            if (v2_1 != null) {
                return v2_1;
            }
        }
        return "";
    }

    public final String getSpeakAvailable()
    {
        return this.speakAvailable;
    }

    public final String getSpeechAvailable()
    {
        return this.speechAvailable;
    }

    public final String getTranslationAbbr()
    {
        return this.translationAbbr;
    }

    public int hashCode()
    {
        int v1_3 = 31;
        return (this.translationAbbr.hashCode() + r1.a.c(r1.a.c(((Integer.hashCode(this.flag) + (Integer.hashCode(this.name) * 31)) * v1_3), v1_3, this.speakAvailable), 31, this.speechAvailable));
    }

    public final void setFlag(int p1)
    {
        this.flag = p1;
        return;
    }

    public final void setName(int p1)
    {
        this.name = p1;
        return;
    }

    public final void setSpeakAvailable(String p1)
    {
        p1.getClass();
        this.speakAvailable = p1;
        return;
    }

    public final void setSpeechAvailable(String p1)
    {
        p1.getClass();
        this.speechAvailable = p1;
        return;
    }

    public final void setTranslationAbbr(String p1)
    {
        p1.getClass();
        this.translationAbbr = p1;
        return;
    }

    public String toString()
    {
        String v2 = this.speakAvailable;
        String v3 = this.speechAvailable;
        String v4 = this.translationAbbr;
        String v0_2 = f0.a.e(this.name, this.flag, "LanguagesModel(name=", ", flag=", ", speakAvailable=");
        f0.a.j(v0_2, v2, ", speechAvailable=", v3, ", translationAbbr=");
        return r1.a.n(v4, ")", v0_2);
    }
}
