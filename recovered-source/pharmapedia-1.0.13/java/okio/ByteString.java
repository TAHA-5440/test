// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package okio;
public class ByteString implements java.io.Serializable, java.lang.Comparable {
    public static final okio.ByteString j = None;
    private static final long serialVersionUID = 1;
    public final byte[] g;
    public transient int h;
    public transient String i;

    static ByteString()
    {
        byte[] v1_1 = new byte[0];
        okio.ByteString.j = new okio.ByteString(v1_1);
        return;
    }

    public ByteString(byte[] p1)
    {
        p1.getClass();
        this.g = p1;
        return;
    }

    public static int h(okio.ByteString p1, okio.ByteString p2)
    {
        p1.getClass();
        p2.getClass();
        return p1.g(0, p2.i());
    }

    public static int l(okio.ByteString p0, okio.ByteString p1)
    {
        p0.getClass();
        p1.getClass();
        return p0.k(p1.i());
    }

    public static synthetic okio.ByteString q(okio.ByteString p1, int p2, int p3, int p4)
    {
        if ((p4 & 1) != 0) {
            p2 = 0;
        }
        if ((p4 & 2) != 0) {
            p3 = -1234567890;
        }
        return p1.p(p2, p3);
    }

    private final void readObject(java.io.ObjectInputStream p6)
    {
        reflect.Field v0_0 = p6.readInt();
        if (v0_0 < null) {
            oc.l.d(r1.a.g(v0_0, "byteCount < 0: "));
            return;
        } else {
            int v1_2 = new byte[v0_0];
            int v2 = 0;
            while (v2 < v0_0) {
                int v3_1 = p6.read(v1_2, v2, (v0_0 - v2));
                if (v3_1 == -1) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.x();
                    return;
                } else {
                    v2 += v3_1;
                }
            }
            byte[] v6_2 = new okio.ByteString(v1_2);
            reflect.Field v0_2 = okio.ByteString.getDeclaredField("g");
            v0_2.setAccessible(1);
            v0_2.set(this, v6_2.g);
            return;
        }
    }

    private final void writeObject(java.io.ObjectOutputStream p2)
    {
        p2.writeInt(this.g.length);
        p2.write(this.g);
        return;
    }

    public String a()
    {
        String v0_0 = this.g;
        java.nio.charset.Charset v1_0 = oc.a.a;
        v0_0.getClass();
        v1_0.getClass();
        byte[] v2_4 = new byte[(((v0_0.length + 2) / 3) * 4)];
        int v4_1 = (v0_0.length - (v0_0.length % 3));
        byte v5_2 = 0;
        int v6_0 = 0;
        while (v5_2 < v4_1) {
            int v8_1 = v0_0[v5_2];
            int v9_2 = (v5_2 + 2);
            int v7_7 = v0_0[(v5_2 + 1)];
            v5_2 += 3;
            int v9_3 = v0_0[v9_2];
            int v10_0 = (v6_0 + 1);
            v2_4[v6_0] = v1_0[((v8_1 & 255) >> 2)];
            int v11_3 = (v6_0 + 2);
            v2_4[v10_0] = v1_0[(((v8_1 & 3) << 4) | ((v7_7 & 255) >> 4))];
            int v8_6 = (v6_0 + 3);
            v2_4[v11_3] = v1_0[(((v7_7 & 15) << 2) | ((v9_3 & 255) >> 6))];
            v6_0 += 4;
            v2_4[v8_6] = v1_0[(v9_3 & 63)];
        }
        int v7_1 = (v0_0.length - v4_1);
        if (v7_1 == 1) {
            String v0_1 = v0_0[v5_2];
            int v4_3 = (v6_0 + 1);
            v2_4[v6_0] = v1_0[((v0_1 & 255) >> 2)];
            int v3_2 = (v6_0 + 2);
            v2_4[v4_3] = v1_0[((v0_1 & 3) << 4)];
            int v6_1 = (v6_0 + 3);
            v2_4[v3_2] = 61;
            v2_4[v6_1] = 61;
        } else {
            if (v7_1 == 2) {
                byte v5_4 = v0_0[v5_2];
                String v0_5 = v0_0[(v5_2 + 1)];
                int v4_5 = (v6_0 + 1);
                v2_4[v6_0] = v1_0[((v5_4 & 255) >> 2)];
                int v7_5 = (v6_0 + 2);
                v2_4[v4_5] = v1_0[(((v5_4 & 3) << 4) | ((v0_5 & 255) >> 4))];
                int v6_2 = (v6_0 + 3);
                v2_4[v7_5] = v1_0[((v0_5 & 15) << 2)];
                v2_4[v6_2] = 61;
            }
        }
        return new String(v2_4, db.a.a);
    }

    public final int b(okio.ByteString p10)
    {
        p10.getClass();
        int v0 = this.e();
        int v1 = p10.e();
        int v2 = Math.min(v0, v1);
        int v4 = 0;
        while (v4 < v2) {
            int v7_1 = (this.j(v4) & 255);
            int v8_1 = (p10.j(v4) & 255);
            if (v7_1 != v8_1) {
                if (v7_1 >= v8_1) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                v4++;
            }
        }
        if (v0 != v1) {
            if (v0 >= v1) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }

    public void c(int p2, byte[] p3, int p4, int p5)
    {
        p3.getClass();
        ha.i.J(this.g, p4, p3, p2, (p5 + p2));
        return;
    }

    public final bridge synthetic int compareTo(Object p1)
    {
        return this.b(((okio.ByteString) p1));
    }

    public okio.ByteString d(String p4)
    {
        byte[] v4_1 = java.security.MessageDigest.getInstance(p4);
        v4_1.update(this.g, 0, this.e());
        byte[] v4_2 = v4_1.digest();
        v4_2.getClass();
        return new okio.ByteString(v4_2);
    }

    public int e()
    {
        return this.g.length;
    }

    public boolean equals(Object p5)
    {
        if (p5 != this) {
            if ((p5 instanceof okio.ByteString)) {
                byte[] v2 = this.g;
                if ((((okio.ByteString) p5).e() == v2.length) && (((okio.ByteString) p5).n(0, v2, 0, v2.length))) {
                    return 1;
                }
            }
            return 0;
        }
        return 1;
    }

    public String f()
    {
        String v0_0 = this.g;
        char[] v1_2 = new char[(v0_0.length * 2)];
        int v2 = v0_0.length;
        int v3 = 0;
        int v4 = 0;
        while (v3 < v2) {
            char v5_0 = v0_0[v3];
            int v6 = (v4 + 1);
            char[] v8 = pc.b.a;
            v1_2[v4] = v8[((v5_0 >> 4) & 15)];
            v4 += 2;
            v1_2[v6] = v8[(v5_0 & 15)];
            v3++;
        }
        return new String(v1_2);
    }

    public int g(int p5, byte[] p6)
    {
        p6.getClass();
        int v0_2 = (this.g.length - p6.length);
        int v5_2 = Math.max(p5, 0);
        if (v5_2 <= v0_2) {
            while (!oc.b.a(this.g, v5_2, p6, 0, p6.length)) {
                if (v5_2 != v0_2) {
                    v5_2++;
                }
            }
            return v5_2;
        }
        return -1;
    }

    public int hashCode()
    {
        int v0_0 = this.h;
        if (v0_0 == 0) {
            int v0_2 = java.util.Arrays.hashCode(this.g);
            this.h = v0_2;
            return v0_2;
        } else {
            return v0_0;
        }
    }

    public byte[] i()
    {
        return this.g;
    }

    public byte j(int p2)
    {
        return this.g[p2];
    }

    public int k(byte[] p5)
    {
        p5.getClass();
        int v0_0 = Math.min(this.e(), (this.g.length - p5.length));
        while (-1 < v0_0) {
            if (!oc.b.a(this.g, v0_0, p5, 0, p5.length)) {
                v0_0--;
            } else {
                return v0_0;
            }
        }
        return -1;
    }

    public boolean m(int p3, okio.ByteString p4, int p5)
    {
        p4.getClass();
        return p4.n(0, this.g, p3, p5);
    }

    public boolean n(int p3, byte[] p4, int p5, int p6)
    {
        p4.getClass();
        if (p3 >= 0) {
            byte[] v0 = this.g;
            if ((p3 <= (v0.length - p6)) && ((p5 >= 0) && ((p5 <= (p4.length - p6)) && (oc.b.a(v0, p3, p4, p5, p6))))) {
                return 1;
            }
        }
        return 0;
    }

    public String o(java.nio.charset.Charset p3)
    {
        p3.getClass();
        return new String(this.g, p3);
    }

    public okio.ByteString p(int p3, int p4)
    {
        if (p4 == -1234567890) {
            p4 = this.e();
        }
        if (p3 < null) {
            com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("beginIndex < 0");
        } else {
            String v0_2 = this.g;
            if (p4 > v0_2.length) {
                oc.l.b(this.g.length, 41, "endIndex > length(");
            } else {
                if ((p4 - p3) < 0) {
                    com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.a.u("endIndex < beginIndex");
                } else {
                    if ((p3 != null) || (p4 != v0_2.length)) {
                        return new okio.ByteString(ha.i.L(v0_2, p3, p4));
                    } else {
                        return this;
                    }
                }
            }
        }
        return 0;
    }

    public okio.ByteString r()
    {
        byte v0_0 = 0;
        while(true) {
            byte[] v1_0 = this.g;
            if (v0_0 >= v1_0.length) {
                return this;
            } else {
                byte v2_3 = v1_0[v0_0];
                if ((v2_3 >= 65) && (v2_3 <= 90)) {
                    break;
                }
                v0_0++;
            }
        }
        byte[] v1_1 = java.util.Arrays.copyOf(v1_0, v1_0.length);
        int v5_1 = (v0_0 + 1);
        v1_1[v0_0] = ((byte) (v2_3 + 32));
        while (v5_1 < v1_1.length) {
            byte v0_4 = v1_1[v5_1];
            if ((v0_4 >= 65) && (v0_4 <= 90)) {
                v1_1[v5_1] = ((byte) (v0_4 + 32));
            }
            v5_1++;
        }
        return new okio.ByteString(v1_1);
    }

    public byte[] s()
    {
        byte[] v0_0 = this.g;
        return java.util.Arrays.copyOf(v0_0, v0_0.length);
    }

    public final String t()
    {
        byte[] v0_0 = this.i;
        if (v0_0 != null) {
            return v0_0;
        } else {
            byte[] v0_1 = this.i();
            v0_1.getClass();
            String v1_1 = new String(v0_1, db.a.a);
            this.i = v1_1;
            return v1_1;
        }
    }

    public String toString()
    {
        String v1_0 = this.g;
        if (v1_0.length != 0) {
            String v2_14 = v1_0.length;
            int v4_0 = 0;
            int v5_0 = 0;
            int v6_7 = 0;
            while (v4_0 < v2_14) {
                String v9_0 = v1_0[v4_0];
                int v16 = 2;
                if (v9_0 < null) {
                    int v7_2;
                    if ((v9_0 >> 5) != -2) {
                        if ((v9_0 >> 4) != -2) {
                            if ((v9_0 >> 3) != -2) {
                                if (v6_7 == 64) {
                                    break;
                                }
                                v5_0 = -1;
                                break;
                            } else {
                                int v3_13 = (v4_0 + 3);
                                if (v2_14 > v3_13) {
                                    int v7_12 = v1_0[(v4_0 + 1)];
                                    if ((v7_12 & 192) != 128) {
                                        if (v6_7 == 64) {
                                            break;
                                        }
                                    } else {
                                        String v13_3 = v1_0[(v4_0 + 2)];
                                        if ((v13_3 & 192) != 128) {
                                            if (v6_7 == 64) {
                                                break;
                                            }
                                        } else {
                                            int v3_14 = v1_0[v3_13];
                                            if ((v3_14 & 192) != 128) {
                                                if (v6_7 == 64) {
                                                    break;
                                                }
                                            } else {
                                                int v3_18 = ((((v3_14 ^ 3678080) ^ (v13_3 << 6)) ^ (v7_12 << 12)) ^ (v9_0 << 18));
                                                if (v3_18 <= 1114111) {
                                                    if ((55296 > v3_18) || (v3_18 >= 57344)) {
                                                        if (v3_18 >= 65536) {
                                                            v7_2 = (v6_7 + 1);
                                                            if (v6_7 == 64) {
                                                                break;
                                                            }
                                                            if ((((v3_18 == 10) || (v3_18 == 13)) || (((v3_18 < 0) || (v3_18 >= 32)) && ((127 > v3_18) || (v3_18 >= 160)))) && (v3_18 != 65533)) {
                                                                if (v3_18 < 65536) {
                                                                    v16 = 1;
                                                                }
                                                                v5_0 += v16;
                                                                v4_0 += 4;
                                                            }
                                                        } else {
                                                            if (v6_7 == 64) {
                                                                break;
                                                            }
                                                        }
                                                    } else {
                                                        if (v6_7 == 64) {
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    if (v6_7 == 64) {
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (v6_7 == 64) {
                                        break;
                                    }
                                }
                            }
                        } else {
                            int v3_19 = (v4_0 + 2);
                            if (v2_14 > v3_19) {
                                int v7_18 = v1_0[(v4_0 + 1)];
                                if ((v7_18 & 192) != 128) {
                                    if (v6_7 == 64) {
                                        break;
                                    }
                                } else {
                                    int v3_20 = v1_0[v3_19];
                                    if ((v3_20 & 192) != 128) {
                                        if (v6_7 == 64) {
                                            break;
                                        }
                                    } else {
                                        int v3_0 = (((v3_20 ^ -123008) ^ (v7_18 << 6)) ^ (v9_0 << 12));
                                        if (v3_0 >= 2048) {
                                            if ((55296 > v3_0) || (v3_0 >= 57344)) {
                                                v7_2 = (v6_7 + 1);
                                                if (v6_7 == 64) {
                                                    break;
                                                }
                                                if ((((v3_0 == 10) || (v3_0 == 13)) || (((v3_0 < 0) || (v3_0 >= 32)) && ((127 > v3_0) || (v3_0 >= 160)))) && (v3_0 != 65533)) {
                                                    if (v3_0 < 65536) {
                                                        v16 = 1;
                                                    }
                                                    v5_0 += v16;
                                                    v4_0 += 3;
                                                }
                                            } else {
                                                if (v6_7 == 64) {
                                                    break;
                                                }
                                            }
                                        } else {
                                            if (v6_7 == 64) {
                                                break;
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (v6_7 == 64) {
                                    break;
                                }
                            }
                        }
                    } else {
                        int v3_1 = (v4_0 + 1);
                        if (v2_14 > v3_1) {
                            int v3_2 = v1_0[v3_1];
                            if ((v3_2 & 192) != 128) {
                                if (v6_7 == 64) {
                                    break;
                                }
                            } else {
                                int v3_4 = ((v3_2 ^ 3968) ^ (v9_0 << 6));
                                if (v3_4 >= 128) {
                                    v7_2 = (v6_7 + 1);
                                    if (v6_7 == 64) {
                                        break;
                                    }
                                    if ((((v3_4 == 10) || (v3_4 == 13)) || (((v3_4 < 0) || (v3_4 >= 32)) && ((127 > v3_4) || (v3_4 >= 160)))) && (v3_4 != 65533)) {
                                        if (v3_4 < 65536) {
                                            v16 = 1;
                                        }
                                        v5_0 += v16;
                                        v4_0 += 2;
                                    }
                                } else {
                                    if (v6_7 == 64) {
                                        break;
                                    }
                                }
                            }
                        } else {
                            if (v6_7 == 64) {
                                break;
                            }
                        }
                    }
                    v6_7 = v7_2;
                } else {
                    int v18 = (v6_7 + 1);
                    if (v6_7 == 64) {
                        break;
                    }
                    if ((((v9_0 == 10) || (v9_0 == 13)) || (((v9_0 < null) || (v9_0 >= 32)) && ((127 > v9_0) || (v9_0 >= 160)))) && (v9_0 != 65533)) {
                        int v6_8;
                        if (v9_0 >= 65536) {
                            v6_8 = 2;
                        } else {
                            v6_8 = 1;
                        }
                        v5_0 += v6_8;
                        v4_0++;
                        while(true) {
                            v6_7 = v18;
                            if (v4_0 >= v2_14) {
                                break;
                            }
                            String v9_1 = v1_0[v4_0];
                            if (v9_1 < null) {
                                break;
                            }
                            v4_0++;
                            v18 = (v6_7 + 1);
                            if (v6_7 != 64) {
                                if ((((v9_1 == 10) || (v9_1 == 13)) || (((v9_1 < null) || (v9_1 >= 32)) && ((127 > v9_1) || (v9_1 >= 160)))) && (v9_1 != 65533)) {
                                    int v6_9;
                                    if (v9_1 >= 65536) {
                                        v6_9 = 2;
                                    } else {
                                        v6_9 = 1;
                                    }
                                    v5_0 += v6_9;
                                }
                            } else {
                                if (v5_0 != -1) {
                                    int v4_2 = this.t();
                                    int v6_14 = db.p.O(db.p.O(db.p.O(v4_2.substring(0, v5_0), "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
                                    if (v5_0 >= v4_2.length()) {
                                        return r1.a.k("[text=", v6_14, 93);
                                    } else {
                                        int v3_8 = new StringBuilder("[size=");
                                        v3_8.append(this.g.length);
                                        v3_8.append(" text=");
                                        v3_8.append(v6_14);
                                        v3_8.append("\u2026]");
                                        return v3_8.toString();
                                    }
                                } else {
                                    if (this.g.length > 64) {
                                        int v3_11 = new StringBuilder("[size=");
                                        v3_11.append(this.g.length);
                                        v3_11.append(" hex=");
                                        String v2_8 = this.g;
                                        if (64 > v2_8.length) {
                                            oc.l.b(this.g.length, 41, "endIndex > length(");
                                            return 0;
                                        } else {
                                            int v4_9;
                                            if (64 != v2_8.length) {
                                                v4_9 = new okio.ByteString(ha.i.L(v2_8, 0, 64));
                                            } else {
                                                v4_9 = this;
                                            }
                                            v3_11.append(v4_9.f());
                                            v3_11.append("\u2026]");
                                            return v3_11.toString();
                                        }
                                    } else {
                                        String v1_10 = new StringBuilder("[hex=");
                                        v1_10.append(this.f());
                                        v1_10.append(93);
                                        return v1_10.toString();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            return "[size=0]";
        }
    }

    public void u(oc.i p3, int p4)
    {
        p3.write(this.g, 0, p4);
        return;
    }
}
