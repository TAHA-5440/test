// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package wb;
public abstract class g {
    public static final wb.h a;

    static g()
    {
        wb.g.a = new wb.h();
        return;
    }

    public static final kotlinx.serialization.json.internal.JsonEncodingException a(String p3, Number p4)
    {
        StringBuilder v1_1 = new StringBuilder("Unexpected special floating-point value ");
        v1_1.append(p4);
        v1_1.append(". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using \'JsonBuilder.allowSpecialFloatingPointValues = true\'\nCurrent output: ");
        v1_1.append(wb.g.f(p3, -1));
        return new kotlinx.serialization.json.internal.JsonEncodingException(v1_1.toString());
    }

    public static final kotlinx.serialization.json.internal.JsonDecodingException b(int p2, CharSequence p3, String p4)
    {
        p3.getClass();
        StringBuilder v0_3 = new StringBuilder();
        v0_3.append(p4);
        v0_3.append("\nJSON input: ");
        v0_3.append(wb.g.f(p3, p2));
        String v3_1 = v0_3.toString();
        if (p2 >= null) {
            StringBuilder v0_2 = new StringBuilder("Unexpected JSON token at offset ");
            v0_2.append(p2);
            v0_2.append(": ");
            v0_2.append(v3_1);
            v3_1 = v0_2.toString();
        }
        return new kotlinx.serialization.json.internal.JsonDecodingException(v3_1);
    }

    public static final sb.d c(sb.d p2, c0.g p3)
    {
        p2.getClass();
        p3.getClass();
        if (!kotlin.jvm.internal.f.a(p2.e(), sb.f.e)) {
            if (p2.isInline()) {
                p2 = wb.g.c(p2.i(0), p3);
            }
        } else {
            int v0_1 = com.bumptech.glide.k.e(p2);
            if ((v0_1 != 0) && (((java.util.Map) p3.h).get(v0_1) != null)) {
                com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.o();
                return 0;
            }
        }
        return p2;
    }

    public static final byte d(char p1)
    {
        if (p1 >= 126) {
            return 0;
        } else {
            return wb.c.b[p1];
        }
    }

    public static final void e(e0.x p2, String p3)
    {
        p2.k((p2.b - 1), "Trailing comma before the end of JSON ".concat(p3), "Trailing commas are non-complaint JSON and not allowed by default. Use \'allowTrailingCommas = true\' in \'Json {}\' builder to support them.");
        throw 0;
    }

    public static final CharSequence f(CharSequence p5, int p6)
    {
        p5.getClass();
        if (p5.length() >= 200) {
            String v1_0 = ".....";
            if (p6 != -1) {
                int v3_0;
                int v0_1 = (p6 - 30);
                int v6_1 = (p6 + 30);
                if (v0_1 > 0) {
                    v3_0 = ".....";
                } else {
                    v3_0 = "";
                }
                if (v6_1 >= p5.length()) {
                    v1_0 = "";
                }
                StringBuilder v2_1 = f0.a.f(v3_0);
                if (v0_1 < 0) {
                    v0_1 = 0;
                }
                int v3_1 = p5.length();
                if (v6_1 > v3_1) {
                    v6_1 = v3_1;
                }
                v2_1.append(p5.subSequence(v0_1, v6_1).toString());
                v2_1.append(v1_0);
                return v2_1.toString();
            } else {
                int v6_3 = (p5.length() - 60);
                if (v6_3 > 0) {
                    int v0_3 = new StringBuilder(".....");
                    v0_3.append(p5.subSequence(v6_3, p5.length()).toString());
                    return v0_3.toString();
                }
            }
        }
        return p5;
    }

    public static final void g(sb.d p0, vb.b p1)
    {
        p0.getClass();
        p1.getClass();
        kotlin.jvm.internal.f.a(p0.e(), sb.h.e);
        return;
    }

    public static final kotlinx.serialization.json.internal.WriteMode h(sb.d p2, vb.b p3)
    {
        p2.getClass();
        StringBuilder v0_2 = p2.e();
        if (!(v0_2 instanceof sb.b)) {
            if (!kotlin.jvm.internal.f.a(v0_2, sb.h.f)) {
                if (!kotlin.jvm.internal.f.a(v0_2, sb.h.g)) {
                    return kotlinx.serialization.json.internal.WriteMode.i;
                } else {
                    String v2_3 = wb.g.c(p2.i(0), p3.b);
                    kotlinx.serialization.json.internal.JsonEncodingException v3_2 = v2_3.e();
                    if ((!(v3_2 instanceof sb.c)) && (!kotlin.jvm.internal.f.a(v3_2, sb.g.e))) {
                        StringBuilder v0_6 = new StringBuilder("Value of type \'");
                        v0_6.append(v2_3.a());
                        v0_6.append("\' can\'t be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is \'");
                        v0_6.append(v2_3.e());
                        v0_6.append("\'.\nUse \'allowStructuredMapKeys = true\' in \'Json {}\' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
                        throw new kotlinx.serialization.json.internal.JsonEncodingException(v0_6.toString());
                    } else {
                        return kotlinx.serialization.json.internal.WriteMode.k;
                    }
                }
            } else {
                return kotlinx.serialization.json.internal.WriteMode.j;
            }
        } else {
            return kotlinx.serialization.json.internal.WriteMode.l;
        }
    }

    public static final void i(e0.x p2, Number p3)
    {
        int v0_1 = new StringBuilder("Unexpected special floating-point value ");
        v0_1.append(p3);
        v0_1.append(". By default, non-finite floating point values are prohibited because they do not conform JSON specification");
        e0.x.l(p2, v0_1.toString(), 0, 2);
        throw 0;
    }

    public static final String j(byte p1)
    {
        if (p1 != 1) {
            if (p1 != 2) {
                if (p1 != 4) {
                    if (p1 != 5) {
                        if (p1 != 6) {
                            if (p1 != 7) {
                                if (p1 != 8) {
                                    if (p1 != 9) {
                                        if (p1 != 10) {
                                            if (p1 != 127) {
                                                return "valid token";
                                            } else {
                                                return "invalid token";
                                            }
                                        } else {
                                            return "end of the input";
                                        }
                                    } else {
                                        return "end of the array \']\'";
                                    }
                                } else {
                                    return "start of the array \'[\'";
                                }
                            } else {
                                return "end of the object \'}\'";
                            }
                        } else {
                            return "start of the object \'{\'";
                        }
                    } else {
                        return "colon \':\'";
                    }
                } else {
                    return "comma \',\'";
                }
            } else {
                return "string escape sequence \'\\\'";
            }
        } else {
            return "quotation mark \'\"\'";
        }
    }
}
