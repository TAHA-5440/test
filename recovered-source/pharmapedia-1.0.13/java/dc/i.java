// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package dc;
public final class i {
    public final synthetic int a;
    public int b;
    public Object c;
    public Object d;

    public synthetic i(int p1)
    {
        this.a = p1;
        return;
    }

    public i(android.graphics.Shader p2, android.content.res.ColorStateList p3, int p4)
    {
        this.a = 1;
        this.c = p2;
        this.d = p3;
        this.b = p4;
        return;
    }

    public i(android.widget.ImageView p2)
    {
        this.a = 4;
        this.b = 0;
        this.c = p2;
        return;
    }

    public i(g7.z p3)
    {
        this.a = 7;
        this.d = t3.c.a(150, new y2.k(this, 0));
        this.c = p3;
        return;
    }

    public synthetic i(Enum p1, int p2, String p3, int p4)
    {
        this.a = p4;
        this.c = p1;
        this.b = p2;
        this.d = p3;
        return;
    }

    public static dc.i b(android.content.res.Resources p30, int p31, android.content.res.Resources$Theme p32)
    {
        Float v2_9 = p30.getXml(p31);
        android.util.AttributeSet v3 = android.util.Xml.asAttributeSet(v2_9);
        do {
            int v4_6 = v2_9.next();
        } while((v4_6 == 2) || (v4_6 == 1));
        if (v4_6 != 2) {
            throw new org.xmlpull.v1.XmlPullParserException("No start tag found");
        } else {
            int v4_2 = v2_9.getName();
            v4_2.getClass();
            if (v4_2.equals("gradient")) {
                int v4_3 = v2_9.getName();
                if (!v4_3.equals("gradient")) {
                    int v1_17 = v2_9.getPositionDescription();
                    Float v2_15 = new StringBuilder();
                    v2_15.append(v1_17);
                    v2_15.append(": invalid gradient color tag ");
                    v2_15.append(v4_3);
                    throw new org.xmlpull.v1.XmlPullParserException(v2_15.toString());
                } else {
                    float[] v12_3;
                    int v4_5 = h0.b.f(p30, p32, v3, d0.a.d);
                    if (v2_9.getAttributeValue("http://schemas.android.com/apk/res/android", "startX") == null) {
                        v12_3 = 0;
                    } else {
                        v12_3 = v4_5.getFloat(8, 0);
                    }
                    int v13_8;
                    if (v2_9.getAttributeValue("http://schemas.android.com/apk/res/android", "startY") == null) {
                        v13_8 = 0;
                    } else {
                        v13_8 = v4_5.getFloat(9, 0);
                    }
                    int v14_8;
                    if (v2_9.getAttributeValue("http://schemas.android.com/apk/res/android", "endX") == null) {
                        v14_8 = 0;
                    } else {
                        v14_8 = v4_5.getFloat(10, 0);
                    }
                    int v15_8;
                    if (v2_9.getAttributeValue("http://schemas.android.com/apk/res/android", "endY") == null) {
                        v15_8 = 0;
                    } else {
                        v15_8 = v4_5.getFloat(11, 0);
                    }
                    int v8_19;
                    if (v2_9.getAttributeValue("http://schemas.android.com/apk/res/android", "centerX") == null) {
                        v8_19 = 0;
                    } else {
                        v8_19 = v4_5.getFloat(3, 0);
                    }
                    int v9_0;
                    if (v2_9.getAttributeValue("http://schemas.android.com/apk/res/android", "centerY") == null) {
                        v9_0 = 0;
                    } else {
                        v9_0 = v4_5.getFloat(4, 0);
                    }
                    android.graphics.RadialGradient v11_2;
                    if (v2_9.getAttributeValue("http://schemas.android.com/apk/res/android", "type") == null) {
                        v11_2 = 0;
                    } else {
                        v11_2 = v4_5.getInt(2, 0);
                    }
                    int v6_2;
                    if (v2_9.getAttributeValue("http://schemas.android.com/apk/res/android", "startColor") == null) {
                        v6_2 = 0;
                    } else {
                        v6_2 = v4_5.getColor(0, 0);
                    }
                    int[] v20_1;
                    if (v2_9.getAttributeValue("http://schemas.android.com/apk/res/android", "centerColor") == null) {
                        v20_1 = 0;
                    } else {
                        v20_1 = 1;
                    }
                    int v5_2;
                    if (v2_9.getAttributeValue("http://schemas.android.com/apk/res/android", "centerColor") == null) {
                        v5_2 = 0;
                    } else {
                        v5_2 = v4_5.getColor(7, 0);
                    }
                    float[] v12_0;
                    float[] v21_0;
                    if (v2_9.getAttributeValue("http://schemas.android.com/apk/res/android", "endColor") == null) {
                        v21_0 = v12_3;
                        v12_0 = 0;
                    } else {
                        v21_0 = v12_3;
                        v12_0 = v4_5.getColor(1, 0);
                    }
                    int v10_7;
                    android.graphics.Shader$TileMode v22_0;
                    if (v2_9.getAttributeValue("http://schemas.android.com/apk/res/android", "tileMode") == null) {
                        v22_0 = v13_8;
                        v10_7 = 0;
                    } else {
                        v22_0 = v13_8;
                        v10_7 = v4_5.getInt(6, 0);
                    }
                    int v13_2;
                    if (v2_9.getAttributeValue("http://schemas.android.com/apk/res/android", "gradientRadius") == null) {
                        v13_2 = 0;
                    } else {
                        v13_2 = v4_5.getFloat(5, 0);
                    }
                    v4_5.recycle();
                    int v4_1 = (v2_9.getDepth() + 1);
                    StringBuilder v24_0 = v2_9;
                    java.util.ArrayList v7_5 = new java.util.ArrayList(20);
                    int v25 = v13_2;
                    int v13_5 = new java.util.ArrayList(20);
                    while(true) {
                        int v27;
                        Float v2_1 = v24_0.next();
                        int v26 = v14_8;
                        if (v2_1 == 1) {
                            v27 = v15_8;
                        } else {
                            int v14_1 = v24_0.getDepth();
                            v27 = v15_8;
                            if ((v14_1 >= v4_1) || (v2_1 != 3)) {
                                if ((v2_1 == 2) && ((v14_1 <= v4_1) && (v24_0.getName().equals("item")))) {
                                    Float v2_5 = h0.b.f(p30, p32, v3, d0.a.e);
                                    int v15_5 = v2_5.hasValue(0);
                                    int v19_1 = v2_5.hasValue(1);
                                    if ((v15_5 == 0) || (v19_1 == 0)) {
                                        break;
                                    }
                                    int v28 = v2_5.getColor(0, 0);
                                    float v29 = v2_5.getFloat(1, 0);
                                    v2_5.recycle();
                                    v13_5.add(Integer.valueOf(v28));
                                    v7_5.add(Float.valueOf(v29));
                                }
                                v14_8 = v26;
                                v15_8 = v27;
                            }
                        }
                        android.graphics.Shader$TileMode v0_4;
                        if (v13_5.size() <= 0) {
                            v0_4 = 0;
                        } else {
                            v0_4 = new a0.i(v13_5, v7_5);
                        }
                        if (v0_4 == null) {
                            if (v20_1 == null) {
                                v0_4 = new a0.i(v6_2, v12_0);
                            } else {
                                v0_4 = new a0.i(v6_2, v5_2, v12_0);
                            }
                        }
                        android.graphics.RadialGradient v11_3;
                        if (v11_2 == 1) {
                            if (v25 <= 0) {
                                throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires \'gradientRadius\' attribute with radial type");
                            } else {
                                android.graphics.Shader$TileMode v0_11;
                                if (v10_7 == 1) {
                                    v0_11 = android.graphics.Shader$TileMode.REPEAT;
                                } else {
                                    if (v10_7 == 2) {
                                        v0_11 = android.graphics.Shader$TileMode.MIRROR;
                                    } else {
                                        v0_11 = android.graphics.Shader$TileMode.CLAMP;
                                    }
                                }
                                v11_3 = new android.graphics.RadialGradient(v8_19, v9_0, v25, ((int[]) v0_4.h), ((float[]) v0_4.i), v0_11);
                            }
                        } else {
                            if (v11_2 == 2) {
                                v11_3 = new android.graphics.SweepGradient(v8_19, v9_0, ((int[]) v0_4.h), ((float[]) v0_4.i));
                            } else {
                                android.graphics.Shader$TileMode v0_15;
                                if (v10_7 == 1) {
                                    v0_15 = android.graphics.Shader$TileMode.REPEAT;
                                } else {
                                    if (v10_7 == 2) {
                                        v0_15 = android.graphics.Shader$TileMode.MIRROR;
                                    } else {
                                        v0_15 = android.graphics.Shader$TileMode.CLAMP;
                                    }
                                }
                                v11_3 = new android.graphics.LinearGradient(v21_0, v22_0, v26, v27, ((int[]) v0_4.h), ((float[]) v0_4.i), v0_15);
                            }
                        }
                        return new dc.i(v11_3, 0, 0);
                    }
                    int v1_9 = v24_0.getPositionDescription();
                    Float v2_7 = new StringBuilder();
                    v2_7.append(v1_9);
                    v2_7.append(": <item> tag requires a \'color\' attribute and a \'offset\' attribute!");
                    throw new org.xmlpull.v1.XmlPullParserException(v2_7.toString());
                }
            } else {
                if (!v4_2.equals("selector")) {
                    int v1_12 = v2_9.getPositionDescription();
                    Float v2_12 = new StringBuilder();
                    v2_12.append(v1_12);
                    v2_12.append(": unsupported complex color tag ");
                    v2_12.append(v4_2);
                    throw new org.xmlpull.v1.XmlPullParserException(v2_12.toString());
                } else {
                    android.graphics.Shader$TileMode v0_23 = h0.c.b(p30, v2_9, v3, p32);
                    return new dc.i(0, v0_23, v0_23.getDefaultColor());
                }
            }
        }
    }

    public static dc.i f(String p8)
    {
        int v5_0;
        io.grpc.okhttp.internal.Protocol v2_1 = io.grpc.okhttp.internal.Protocol.h;
        if (!p8.startsWith("HTTP/1.")) {
            if (!p8.startsWith("ICY ")) {
                throw new java.net.ProtocolException("Unexpected status line: ".concat(p8));
            } else {
                v5_0 = 4;
            }
        } else {
            v5_0 = 9;
            if ((p8.length() < 9) || (p8.charAt(8) != 32)) {
                throw new java.net.ProtocolException("Unexpected status line: ".concat(p8));
            } else {
                java.net.ProtocolException v0_12 = (p8.charAt(7) - 48);
                if (v0_12 != null) {
                    if (v0_12 != 1) {
                        throw new java.net.ProtocolException("Unexpected status line: ".concat(p8));
                    } else {
                        v2_1 = io.grpc.okhttp.internal.Protocol.i;
                    }
                }
            }
        }
        char v6_0 = (v5_0 + 3);
        if (p8.length() < v6_0) {
            throw new java.net.ProtocolException("Unexpected status line: ".concat(p8));
        } else {
            try {
                String v8_6;
                java.net.ProtocolException v0_19 = Integer.parseInt(p8.substring(v5_0, v6_0));
            } catch (NumberFormatException) {
                throw new java.net.ProtocolException("Unexpected status line: ".concat(p8));
            }
            if (p8.length() <= v6_0) {
                v8_6 = "";
            } else {
                if (p8.charAt(v6_0) != 32) {
                    throw new java.net.ProtocolException("Unexpected status line: ".concat(p8));
                } else {
                    v8_6 = p8.substring((v5_0 + 4));
                }
            }
            return new dc.i(v2_1, v0_19, v8_6, 2);
        }
    }

    public void a()
    {
        int[] v0_1 = ((android.widget.ImageView) this.c);
        android.graphics.drawable.Drawable v1 = v0_1.getDrawable();
        if (v1 != null) {
            m.c1.a(v1);
        }
        if (v1 != null) {
            i7.a v2_1 = ((i7.a) this.d);
            if (v2_1 != null) {
                m.u.d(v1, v2_1, v0_1.getDrawableState());
            }
        }
        return;
    }

    public String c()
    {
        String v0_1 = new StringBuilder("$");
        int v1_2 = (this.b + 1);
        int v2 = 0;
        while (v2 < v1_2) {
            String v3_2 = ((Object[]) this.c)[v2];
            if (!(v3_2 instanceof sb.d)) {
                if (v3_2 != wb.h.a) {
                    v0_1.append("[\'");
                    v0_1.append(v3_2);
                    v0_1.append("\']");
                }
            } else {
                String v3_4 = ((sb.d) v3_2);
                String v5_2 = ((int[]) this.d);
                if (!kotlin.jvm.internal.f.a(v3_4.e(), sb.h.f)) {
                    String v4_5 = v5_2[v2];
                    if (v4_5 >= null) {
                        v0_1.append(".");
                        v0_1.append(v3_4.g(v4_5));
                    }
                } else {
                    if (v5_2[v2] != -1) {
                        v0_1.append("[");
                        v0_1.append(((int[]) this.d)[v2]);
                        v0_1.append("]");
                    }
                }
            }
            v2++;
        }
        return v0_1.toString();
    }

    public boolean d()
    {
        if (((android.graphics.Shader) this.c) == null) {
            int v0_4 = ((android.content.res.ColorStateList) this.d);
            if ((v0_4 != 0) && (v0_4.isStateful())) {
                return 1;
            }
        }
        return 0;
    }

    public void e(android.util.AttributeSet p9, int p10)
    {
        android.widget.ImageView v1_1 = ((android.widget.ImageView) this.c);
        int[] v3 = h.a.f;
        androidx.lifecycle.j v7 = androidx.lifecycle.j.N(p10, 0, v1_1.getContext(), p9, v3);
        Throwable v0_1 = ((android.content.res.TypedArray) v7.i);
        q0.n0.m(v1_1, v1_1.getContext(), v3, p9, ((android.content.res.TypedArray) v7.i), p10);
        android.graphics.PorterDuff$Mode v9_1 = v1_1.getDrawable();
        if (v9_1 == null) {
            boolean v2_2 = v0_1.getResourceId(1, -1);
            if (v2_2 != -1) {
                v9_1 = t6.a.h(v1_1.getContext(), v2_2);
                if (v9_1 != null) {
                    v1_1.setImageDrawable(v9_1);
                }
            }
        }
        if (v9_1 != null) {
            m.c1.a(v9_1);
        }
        if (v0_1.hasValue(2)) {
            v1_1.setImageTintList(v7.w(2));
        }
        if (v0_1.hasValue(3)) {
            v1_1.setImageTintMode(m.c1.b(v0_1.getInt(3, -1), 0));
        }
        v7.P();
        return;
    }

    public String toString()
    {
        switch (this.a) {
            case 0:
                String v0_11 = new StringBuilder();
                if (((okhttp3.Protocol) this.c) != okhttp3.Protocol.i) {
                    v0_11.append("HTTP/1.1");
                } else {
                    v0_11.append("HTTP/1.0");
                }
                v0_11.append(32);
                v0_11.append(this.b);
                v0_11.append(32);
                v0_11.append(((String) this.d));
                return v0_11.toString();
            case 1:
            case 4:
            case 5:
            default:
                return super.toString();
            case 2:
                int v2_3;
                String v0_8 = ((String) this.d);
                int v1_15 = new StringBuilder();
                if (((io.grpc.okhttp.internal.Protocol) this.c) != io.grpc.okhttp.internal.Protocol.h) {
                    v2_3 = "HTTP/1.1";
                } else {
                    v2_3 = "HTTP/1.0";
                }
                v1_15.append(v2_3);
                v1_15.append(32);
                v1_15.append(this.b);
                v1_15.append(32);
                v1_15.append(v0_8);
                return v1_15.toString();
            case 3:
                String v0_5 = new StringBuilder();
                v0_5.append(((String) this.d));
                v0_5.append("://");
                int v3_0 = -1;
                if (((String) this.c).indexOf(58) == -1) {
                    v0_5.append(((String) this.c));
                } else {
                    v0_5.append(91);
                    v0_5.append(((String) this.c));
                    v0_5.append(93);
                }
                int v1_10 = this.b;
                if (v1_10 == -1) {
                    int v1_12 = ((String) this.d);
                    if (!v1_12.equals("http")) {
                        if (!v1_12.equals("https")) {
                            v1_10 = -1;
                        } else {
                            v1_10 = 443;
                        }
                    } else {
                        v1_10 = 80;
                    }
                }
                String v8_2 = ((String) this.d);
                if (!v8_2.equals("http")) {
                    if (v8_2.equals("https")) {
                        v3_0 = 443;
                    }
                } else {
                    v3_0 = 80;
                }
                if (v1_10 != v3_0) {
                    v0_5.append(58);
                    v0_5.append(v1_10);
                }
                return v0_5.toString();
            case 6:
                return this.c();
        }
    }
}
