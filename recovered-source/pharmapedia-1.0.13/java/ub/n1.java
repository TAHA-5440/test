// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ub;
public final class n1 implements qb.a {
    public static final ub.n1 a;
    public static final ub.s0 b;

    static n1()
    {
        ub.n1.a = new ub.n1();
        ub.n1.b = new ub.s0("kotlin.uuid.Uuid", sb.c.m);
        return;
    }

    public final Object deserialize(tb.c p25)
    {
        p25.getClass();
        long v0_4 = p25.j();
        v0_4.getClass();
        int v1_12 = v0_4.length();
        int v3_5 = 16;
        long v8_0 = 0;
        if (v1_12 == 32) {
            long v10_0 = 0;
            while (v8_0 < 16) {
                long v10_1 = (v10_0 << 4);
                int v1_10 = v0_4.charAt(v8_0);
                if ((v1_10 >> 8) == 0) {
                    long v13_4 = db.d.b[v1_10];
                    if (v13_4 >= 0) {
                        v10_0 = (v10_1 | v13_4);
                        v8_0++;
                    }
                }
                com.bumptech.glide.e.s(v8_0, v0_4, "a hexadecimal digit");
                throw 0;
            }
            long v12_0 = 0;
            while (v3_5 < 32) {
                long v12_1 = (v12_0 << 4);
                int v1_8 = v0_4.charAt(v3_5);
                if ((v1_8 >> 8) == 0) {
                    long v14_1 = db.d.b[v1_8];
                    if (v14_1 >= 0) {
                        v12_0 = (v12_1 | v14_1);
                        v3_5++;
                    }
                }
                com.bumptech.glide.e.s(v3_5, v0_4, "a hexadecimal digit");
                throw 0;
            }
            if ((v10_0 != 0) || (v12_0 != 0)) {
                return new kotlin.uuid.Uuid(v10_0, v12_0);
            }
        } else {
            if (v1_12 == 36) {
                long v11_1 = 0;
                while (v8_0 < 8) {
                    long v11_0 = (v11_1 << 4);
                    int v1_4 = v0_4.charAt(v8_0);
                    if ((v1_4 >> 8) == 0) {
                        long v14_0 = db.d.b[v1_4];
                        if (v14_0 >= 0) {
                            v11_1 = (v11_0 | v14_0);
                            v8_0++;
                        }
                    }
                    com.bumptech.glide.e.s(v8_0, v0_4, "a hexadecimal digit");
                    throw 0;
                }
                if (v0_4.charAt(8) != 45) {
                    com.bumptech.glide.e.s(8, v0_4, "\'-\' (hyphen)");
                    throw 0;
                } else {
                    int v1_3 = 9;
                    long v15_1 = 0;
                    while (v1_3 < 13) {
                        long v15_0 = (v15_1 << 4);
                        long v8_7 = v0_4.charAt(v1_3);
                        if ((v8_7 >> 8) == 0) {
                            long v18 = db.d.b[v8_7];
                            if (v18 >= 0) {
                                v15_1 = (v15_0 | v18);
                                v1_3++;
                            }
                        }
                        com.bumptech.glide.e.s(v1_3, v0_4, "a hexadecimal digit");
                        throw 0;
                    }
                    if (v0_4.charAt(13) != 45) {
                        com.bumptech.glide.e.s(13, v0_4, "\'-\' (hyphen)");
                        throw 0;
                    } else {
                        int v1_2 = 14;
                        long v17_1 = 0;
                        while (v1_2 < 18) {
                            long v17_0 = (v17_1 << 4);
                            long v8_5 = v0_4.charAt(v1_2);
                            if ((v8_5 >> 8) == 0) {
                                long v20 = db.d.b[v8_5];
                                if (v20 >= 0) {
                                    v17_1 = (v17_0 | v20);
                                    v1_2++;
                                }
                            }
                            com.bumptech.glide.e.s(v1_2, v0_4, "a hexadecimal digit");
                            throw 0;
                        }
                        if (v0_4.charAt(18) != 45) {
                            com.bumptech.glide.e.s(18, v0_4, "\'-\' (hyphen)");
                            throw 0;
                        } else {
                            int v1_1 = 19;
                            long v19_1 = 0;
                            while (v1_1 < 23) {
                                long v19_0 = (v19_1 << 4);
                                long v8_3 = v0_4.charAt(v1_1);
                                if ((v8_3 >> 8) == 0) {
                                    long v22_1 = db.d.b[v8_3];
                                    if (v22_1 >= 0) {
                                        v19_1 = (v19_0 | v22_1);
                                        v1_1++;
                                    }
                                }
                                com.bumptech.glide.e.s(v1_1, v0_4, "a hexadecimal digit");
                                throw 0;
                            }
                            if (v0_4.charAt(23) != 45) {
                                com.bumptech.glide.e.s(23, v0_4, "\'-\' (hyphen)");
                                throw 0;
                            } else {
                                int v1_0 = 24;
                                long v13_1 = 0;
                                while (v1_0 < 36) {
                                    long v13_0 = (v13_1 << 4);
                                    long v8_1 = v0_4.charAt(v1_0);
                                    if ((v8_1 >> 8) == 0) {
                                        long v22_0 = db.d.b[v8_1];
                                        if (v22_0 >= 0) {
                                            v13_1 = (v13_0 | v22_0);
                                            v1_0++;
                                        }
                                    }
                                    com.bumptech.glide.e.s(v1_0, v0_4, "a hexadecimal digit");
                                    throw 0;
                                }
                                long v0_10 = (((v11_1 << 32) | (v15_1 << 16)) | v17_1);
                                long v2_6 = ((v19_1 << 48) | v13_1);
                                if ((v0_10 != 0) || (v2_6 != 0)) {
                                    return new kotlin.uuid.Uuid(v0_10, v2_6);
                                }
                            }
                        }
                    }
                }
            } else {
                int v3_3;
                long v2_1 = new StringBuilder("Expected either a 36-char string in the standard hex-and-dash UUID format or a 32-char hexadecimal string, but was \"");
                if (v0_4.length() > 64) {
                    v3_3 = v0_4.substring(0, 64).concat("...");
                } else {
                    v3_3 = v0_4;
                }
                v2_1.append(v3_3);
                v2_1.append("\" of length ");
                v2_1.append(v0_4.length());
                throw new IllegalArgumentException(v2_1.toString());
            }
        }
        return kotlin.uuid.Uuid.i;
    }

    public final sb.d getDescriptor()
    {
        return ub.n1.b;
    }

    public final void serialize(tb.d p1, Object p2)
    {
        ((kotlin.uuid.Uuid) p2).getClass();
        p1.p(((kotlin.uuid.Uuid) p2).toString());
        return;
    }
}
