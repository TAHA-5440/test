// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package db;
public abstract class o extends db.n {

    public static final boolean J(String p19)
    {
        int v2_5 = 1;
        int v1_0 = (p19.length() - 1);
        int v4_1 = 0;
        while(true) {
            int v5_5 = 32;
            if ((v4_1 > v1_0) || (p19.charAt(v4_1) > 32)) {
                break;
            }
            v4_1++;
        }
        if (v4_1 > v1_0) {
            return 0;
        }
        while ((v1_0 > v4_1) && (p19.charAt(v1_0) <= 32)) {
            v1_0--;
        }
        if ((p19.charAt(v4_1) == 43) || (p19.charAt(v4_1) == 45)) {
            v4_1++;
        }
        if (v4_1 <= v1_0) {
            int v2_6;
            int v17;
            if (p19.charAt(v4_1) != 48) {
                v17 = 1;
                v2_6 = 0;
            } else {
                int v6_13 = (v4_1 + 1);
                if (v6_13 <= v1_0) {
                    if ((p19.charAt(v6_13) | 32) != 120) {
                    } else {
                        int v4_6 = (v4_1 + 2);
                        int v6_10 = v4_6;
                        while (v6_10 <= v1_0) {
                            char v15_0 = p19.charAt(v6_10);
                            v17 = v2_5;
                            if ((((v15_0 - 48) & 65535) < 10) || ((((v15_0 | 32) - 97) & 65535) < 6)) {
                                v6_10++;
                                v2_5 = v17;
                            }
                            int v2_11;
                            if (v4_6 == v6_10) {
                                v2_11 = 0;
                            } else {
                                v2_11 = v17;
                            }
                            if (v6_10 <= v1_0) {
                                int v5_4;
                                if (p19.charAt(v6_10) != 46) {
                                    v5_4 = 0;
                                } else {
                                    int v6_16 = (v6_10 + 1);
                                    int v4_8 = v6_16;
                                    while (v4_8 <= v1_0) {
                                        char v15_1 = p19.charAt(v4_8);
                                        if ((((v15_1 - 48) & 65535) >= 10) && ((((v15_1 | 32) - 97) & 65535) >= 6)) {
                                            break;
                                        }
                                        v4_8++;
                                    }
                                    if (v6_16 == v4_8) {
                                        v5_4 = 0;
                                    } else {
                                        v5_4 = v17;
                                    }
                                    v6_10 = v4_8;
                                }
                                if ((v2_11 != 0) || (v5_4 != 0)) {
                                    v4_1 = v6_10;
                                } else {
                                    v4_1 = -1;
                                }
                            }
                            if ((v4_1 != -1) && (v4_1 <= v1_0)) {
                                v2_6 = v17;
                            } else {
                                return 0;
                            }
                        }
                        v17 = v2_5;
                    }
                } else {
                    return 1;
                }
            }
            if (v2_6 == 0) {
                int v5_3 = v4_1;
                while ((v5_3 <= v1_0) && (((p19.charAt(v5_3) - 48) & 65535) < 10)) {
                    v5_3++;
                }
                int v4_0;
                if (v4_1 == v5_3) {
                    v4_0 = 0;
                } else {
                    v4_0 = v17;
                }
                if (v5_3 <= v1_0) {
                    int v6_5;
                    int v5_1;
                    if (p19.charAt(v5_3) != 46) {
                        v6_5 = v5_3;
                        v5_1 = 0;
                    } else {
                        int v5_0 = (v5_3 + 1);
                        v6_5 = v5_0;
                        while ((v6_5 <= v1_0) && (((p19.charAt(v6_5) - 48) & 65535) < 10)) {
                            v6_5++;
                        }
                        if (v5_0 == v6_5) {
                        } else {
                            v5_1 = v17;
                        }
                    }
                    if ((v4_0 != 0) || (v5_1 != 0)) {
                        v4_1 = v6_5;
                    } else {
                        int v4_4;
                        if (v1_0 != (v6_5 + 2)) {
                            if (v1_0 != (v6_5 + 7)) {
                                v4_4 = 0;
                            } else {
                                v4_4 = "Infinity";
                            }
                        } else {
                            v4_4 = "NaN";
                        }
                        if ((v4_4 == 0) || (db.i.V(p19, v4_4, v6_5, 0) != v6_5)) {
                            v4_1 = -1;
                        } else {
                            v4_1 = (v1_0 + 1);
                        }
                    }
                } else {
                    v4_1 = v5_3;
                }
                if (v4_1 != -1) {
                    if (v4_1 > v1_0) {
                        return v17;
                    }
                } else {
                    return 0;
                }
            }
            int v9_3;
            int v5_2 = (v4_1 + 1);
            int v6_7 = (p19.charAt(v4_1) | 32);
            if (v2_6 == 0) {
                v9_3 = 101;
            } else {
                v9_3 = 112;
            }
            if (v6_7 == v9_3) {
                if (v5_2 <= v1_0) {
                    if ((p19.charAt(v5_2) == 43) || (p19.charAt(v5_2) == 45)) {
                        v5_2 = (v4_1 + 2);
                        if (v5_2 > v1_0) {
                            return 0;
                        }
                    }
                    while ((v5_2 <= v1_0) && (((p19.charAt(v5_2) - 48) & 65535) < 10)) {
                        v5_2++;
                    }
                    if (v5_2 <= v1_0) {
                        if (v5_2 != v1_0) {
                            return 0;
                        } else {
                            int v0_2 = (p19.charAt(v5_2) | 32);
                            if ((v0_2 != 102) && (v0_2 != 100)) {
                                return 0;
                            } else {
                                return v17;
                            }
                        }
                    } else {
                        return v17;
                    }
                } else {
                    return 0;
                }
            } else {
                if (((v2_6 != 0) || ((v6_7 != 102) && (v6_7 != 100))) || (v5_2 <= v1_0)) {
                    return 0;
                } else {
                    return v17;
                }
            }
        } else {
            return 0;
        }
    }
}
