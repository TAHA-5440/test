// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.database.models;
public final class MedicinesRoomDBModel implements java.io.Serializable {
    private final java.util.Map availableForms;
    private final String block;
    private final String brandName;
    private final String companyName;
    private final String contraIndications;
    private final String countryName;
    private String docId;
    private final java.util.Map dosageDetail;
    private final String indications;
    private boolean isBrandFavourite;
    private boolean isSaltFavourite;
    private final String overview;
    private final String saltName;
    private final long timeStamp;

    public MedicinesRoomDBModel()
    {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16383, 0);
        return;
    }

    public MedicinesRoomDBModel(String p1, long p2, String p4, String p5, String p6, String p7, String p8, String p9, String p10, boolean p11, boolean p12, String p13, java.util.Map p14, java.util.Map p15)
    {
        p1.getClass();
        p4.getClass();
        p5.getClass();
        p6.getClass();
        p7.getClass();
        p8.getClass();
        p9.getClass();
        p10.getClass();
        p13.getClass();
        p14.getClass();
        p15.getClass();
        this.docId = p1;
        this.timeStamp = p2;
        this.saltName = p4;
        this.brandName = p5;
        this.contraIndications = p6;
        this.overview = p7;
        this.indications = p8;
        this.companyName = p9;
        this.countryName = p10;
        this.isBrandFavourite = p11;
        this.isSaltFavourite = p12;
        this.block = p13;
        this.availableForms = p14;
        this.dosageDetail = p15;
        return;
    }

    public synthetic MedicinesRoomDBModel(String p16, long p17, String p19, String p20, String p21, String p22, String p23, String p24, String p25, boolean p26, boolean p27, String p28, java.util.Map p29, java.util.Map p30, int p31, kotlin.jvm.internal.c p32)
    {
        String v1_1;
        String v2 = "";
        if ((p31 & 1) == 0) {
            v1_1 = p16;
        } else {
            v1_1 = "";
        }
        long v3_1;
        if ((p31 & 2) == 0) {
            v3_1 = p17;
        } else {
            v3_1 = 0;
        }
        String v5_1;
        if ((p31 & 4) == 0) {
            v5_1 = p19;
        } else {
            v5_1 = "";
        }
        String v6_1;
        if ((p31 & 8) == 0) {
            v6_1 = p20;
        } else {
            v6_1 = "";
        }
        String v7_1;
        if ((p31 & 16) == 0) {
            v7_1 = p21;
        } else {
            v7_1 = "";
        }
        String v8_1;
        if ((p31 & 32) == 0) {
            v8_1 = p22;
        } else {
            v8_1 = "";
        }
        String v9_1;
        if ((p31 & 64) == 0) {
            v9_1 = p23;
        } else {
            v9_1 = "";
        }
        String v10_1;
        if ((p31 & 128) == 0) {
            v10_1 = p24;
        } else {
            v10_1 = "";
        }
        if ((p31 & 256) == 0) {
            v2 = p25;
        }
        boolean v11_2;
        boolean v12 = 0;
        if ((p31 & 512) == 0) {
            v11_2 = p26;
        } else {
            v11_2 = 0;
        }
        if ((p31 & 1024) == 0) {
            v12 = p27;
        }
        String v13_2;
        if ((p31 & 2048) == 0) {
            v13_2 = p28;
        } else {
            v13_2 = "No";
        }
        java.util.Map v14_1;
        if ((p31 & 4096) == 0) {
            v14_1 = p29;
        } else {
            v14_1 = kotlin.collections.a.G();
        }
        java.util.Map v31_1;
        if ((p31 & 8192) == 0) {
            v31_1 = p30;
        } else {
            v31_1 = kotlin.collections.a.G();
        }
        this(v1_1, v3_1, v5_1, v6_1, v7_1, v8_1, v9_1, v10_1, v2, v11_2, v12, v13_2, v14_1, v31_1);
        return;
    }

    public static synthetic vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel copy$default(vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel p16, String p17, long p18, String p20, String p21, String p22, String p23, String p24, String p25, String p26, boolean p27, boolean p28, String p29, java.util.Map p30, java.util.Map p31, int p32, Object p33)
    {
        String v2_1;
        if ((p32 & 1) == 0) {
            v2_1 = p17;
        } else {
            v2_1 = p16.docId;
        }
        long v3_1;
        if ((p32 & 2) == 0) {
            v3_1 = p18;
        } else {
            v3_1 = p16.timeStamp;
        }
        String v5_1;
        if ((p32 & 4) == 0) {
            v5_1 = p20;
        } else {
            v5_1 = p16.saltName;
        }
        String v6_1;
        if ((p32 & 8) == 0) {
            v6_1 = p21;
        } else {
            v6_1 = p16.brandName;
        }
        String v7_1;
        if ((p32 & 16) == 0) {
            v7_1 = p22;
        } else {
            v7_1 = p16.contraIndications;
        }
        String v8_1;
        if ((p32 & 32) == 0) {
            v8_1 = p23;
        } else {
            v8_1 = p16.overview;
        }
        String v9_1;
        if ((p32 & 64) == 0) {
            v9_1 = p24;
        } else {
            v9_1 = p16.indications;
        }
        String v10_1;
        if ((p32 & 128) == 0) {
            v10_1 = p25;
        } else {
            v10_1 = p16.companyName;
        }
        String v11_1;
        if ((p32 & 256) == 0) {
            v11_1 = p26;
        } else {
            v11_1 = p16.countryName;
        }
        boolean v12_1;
        if ((p32 & 512) == 0) {
            v12_1 = p27;
        } else {
            v12_1 = p16.isBrandFavourite;
        }
        boolean v13_1;
        if ((p32 & 1024) == 0) {
            v13_1 = p28;
        } else {
            v13_1 = p16.isSaltFavourite;
        }
        String v14_1;
        if ((p32 & 2048) == 0) {
            v14_1 = p29;
        } else {
            v14_1 = p16.block;
        }
        java.util.Map v15_1;
        if ((p32 & 4096) == 0) {
            v15_1 = p30;
        } else {
            v15_1 = p16.availableForms;
        }
        java.util.Map v32_1;
        if ((p32 & 8192) == 0) {
            v32_1 = p31;
        } else {
            v32_1 = p16.dosageDetail;
        }
        return p16.copy(v2_1, v3_1, v5_1, v6_1, v7_1, v8_1, v9_1, v10_1, v11_1, v12_1, v13_1, v14_1, v15_1, v32_1);
    }

    public final String component1()
    {
        return this.docId;
    }

    public final boolean component10()
    {
        return this.isBrandFavourite;
    }

    public final boolean component11()
    {
        return this.isSaltFavourite;
    }

    public final String component12()
    {
        return this.block;
    }

    public final java.util.Map component13()
    {
        return this.availableForms;
    }

    public final java.util.Map component14()
    {
        return this.dosageDetail;
    }

    public final long component2()
    {
        return this.timeStamp;
    }

    public final String component3()
    {
        return this.saltName;
    }

    public final String component4()
    {
        return this.brandName;
    }

    public final String component5()
    {
        return this.contraIndications;
    }

    public final String component6()
    {
        return this.overview;
    }

    public final String component7()
    {
        return this.indications;
    }

    public final String component8()
    {
        return this.companyName;
    }

    public final String component9()
    {
        return this.countryName;
    }

    public final vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel copy(String p17, long p18, String p20, String p21, String p22, String p23, String p24, String p25, String p26, boolean p27, boolean p28, String p29, java.util.Map p30, java.util.Map p31)
    {
        p17.getClass();
        p20.getClass();
        p21.getClass();
        p22.getClass();
        p23.getClass();
        p24.getClass();
        p25.getClass();
        p26.getClass();
        p29.getClass();
        p30.getClass();
        p31.getClass();
        return new vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel(p17, p18, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31);
    }

    public boolean equals(Object p8)
    {
        if (this != p8) {
            if ((p8 instanceof vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel)) {
                if (kotlin.jvm.internal.f.a(this.docId, ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p8).docId)) {
                    if (this.timeStamp == ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p8).timeStamp) {
                        if (kotlin.jvm.internal.f.a(this.saltName, ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p8).saltName)) {
                            if (kotlin.jvm.internal.f.a(this.brandName, ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p8).brandName)) {
                                if (kotlin.jvm.internal.f.a(this.contraIndications, ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p8).contraIndications)) {
                                    if (kotlin.jvm.internal.f.a(this.overview, ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p8).overview)) {
                                        if (kotlin.jvm.internal.f.a(this.indications, ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p8).indications)) {
                                            if (kotlin.jvm.internal.f.a(this.companyName, ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p8).companyName)) {
                                                if (kotlin.jvm.internal.f.a(this.countryName, ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p8).countryName)) {
                                                    if (this.isBrandFavourite == ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p8).isBrandFavourite) {
                                                        if (this.isSaltFavourite == ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p8).isSaltFavourite) {
                                                            if (kotlin.jvm.internal.f.a(this.block, ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p8).block)) {
                                                                if (kotlin.jvm.internal.f.a(this.availableForms, ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p8).availableForms)) {
                                                                    if (kotlin.jvm.internal.f.a(this.dosageDetail, ((vet.pharmapedia.vetpharmapediapakistan.database.models.MedicinesRoomDBModel) p8).dosageDetail)) {
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

    public final java.util.Map getAvailableForms()
    {
        return this.availableForms;
    }

    public final String getBlock()
    {
        return this.block;
    }

    public final String getBrandName()
    {
        return this.brandName;
    }

    public final String getCompanyName()
    {
        return this.companyName;
    }

    public final String getContraIndications()
    {
        return this.contraIndications;
    }

    public final String getCountryName()
    {
        return this.countryName;
    }

    public final String getDocId()
    {
        return this.docId;
    }

    public final java.util.Map getDosageDetail()
    {
        return this.dosageDetail;
    }

    public final String getIndications()
    {
        return this.indications;
    }

    public final String getOverview()
    {
        return this.overview;
    }

    public final String getSaltName()
    {
        return this.saltName;
    }

    public final long getTimeStamp()
    {
        return this.timeStamp;
    }

    public int hashCode()
    {
        return (this.dosageDetail.hashCode() + ((this.availableForms.hashCode() + r1.a.c(((Boolean.hashCode(this.isSaltFavourite) + ((Boolean.hashCode(this.isBrandFavourite) + r1.a.c(r1.a.c(r1.a.c(r1.a.c(r1.a.c(r1.a.c(r1.a.c(((Long.hashCode(this.timeStamp) + (this.docId.hashCode() * 31)) * int v1), 31, this.saltName), 31, this.brandName), 31, this.contraIndications), 31, this.overview), 31, this.indications), 31, this.companyName), 31, this.countryName)) * 31)) * v1), 31, this.block)) * 31));
    }

    public final boolean isBrandFavourite()
    {
        return this.isBrandFavourite;
    }

    public final boolean isSaltFavourite()
    {
        return this.isSaltFavourite;
    }

    public final void setBrandFavourite(boolean p1)
    {
        this.isBrandFavourite = p1;
        return;
    }

    public final void setDocId(String p1)
    {
        p1.getClass();
        this.docId = p1;
        return;
    }

    public final void setSaltFavourite(boolean p1)
    {
        this.isSaltFavourite = p1;
        return;
    }

    public String toString()
    {
        String v1_0 = this.docId;
        String v2_0 = this.timeStamp;
        String v4 = this.saltName;
        String v5 = this.brandName;
        String v6 = this.contraIndications;
        String v7 = this.overview;
        String v8 = this.indications;
        String v9 = this.companyName;
        String v10 = this.countryName;
        boolean v11 = this.isBrandFavourite;
        boolean v12 = this.isSaltFavourite;
        String v13 = this.block;
        java.util.Map v14 = this.availableForms;
        java.util.Map v16 = this.dosageDetail;
        String v0_2 = new StringBuilder("MedicinesRoomDBModel(docId=");
        v0_2.append(v1_0);
        v0_2.append(", timeStamp=");
        v0_2.append(v2_0);
        f0.a.j(v0_2, ", saltName=", v4, ", brandName=", v5);
        f0.a.j(v0_2, ", contraIndications=", v6, ", overview=", v7);
        f0.a.j(v0_2, ", indications=", v8, ", companyName=", v9);
        v0_2.append(", countryName=");
        v0_2.append(v10);
        v0_2.append(", isBrandFavourite=");
        v0_2.append(v11);
        v0_2.append(", isSaltFavourite=");
        v0_2.append(v12);
        v0_2.append(", block=");
        v0_2.append(v13);
        v0_2.append(", availableForms=");
        v0_2.append(v14);
        v0_2.append(", dosageDetail=");
        v0_2.append(v16);
        v0_2.append(")");
        return v0_2.toString();
    }
}
