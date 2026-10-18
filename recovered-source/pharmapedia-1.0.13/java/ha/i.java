// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package ha;
public abstract class i extends com.bumptech.glide.d {

    public static cb.h G(Object[] p2)
    {
        p2.getClass();
        if (p2.length != 0) {
            return new cb.j(p2, 2);
        } else {
            return cb.e.a;
        }
    }

    public static void H(int p0, int p1, int p2, int[] p3, int[] p4)
    {
        p3.getClass();
        p4.getClass();
        System.arraycopy(p3, p1, p4, p0, (p2 - p1));
        return;
    }

    public static void I(int p0, int p1, int p2, Object[] p3, Object[] p4)
    {
        p3.getClass();
        p4.getClass();
        System.arraycopy(p3, p1, p4, p0, (p2 - p1));
        return;
    }

    public static void J(byte[] p0, int p1, byte[] p2, int p3, int p4)
    {
        p0.getClass();
        p2.getClass();
        System.arraycopy(p0, p3, p2, p1, (p4 - p3));
        return;
    }

    public static synthetic void K(int p2, int p3, int p4, Object[] p5, Object[] p6)
    {
        if ((p4 & 4) != 0) {
            p2 = 0;
        }
        if ((p4 & 8) != 0) {
            p3 = p5.length;
        }
        ha.i.I(0, p2, p3, p5, p6);
        return;
    }

    public static byte[] L(byte[] p1, int p2, int p3)
    {
        p1.getClass();
        com.bumptech.glide.d.g(p3, p1.length);
        byte[] v1_1 = java.util.Arrays.copyOfRange(p1, p2, p3);
        v1_1.getClass();
        return v1_1;
    }

    public static Object[] M(Object[] p1, int p2, int p3)
    {
        p1.getClass();
        com.bumptech.glide.d.g(p3, p1.length);
        Object[] v1_1 = java.util.Arrays.copyOfRange(p1, p2, p3);
        v1_1.getClass();
        return v1_1;
    }

    public static void N(Object[] p1, int p2, int p3)
    {
        p1.getClass();
        java.util.Arrays.fill(p1, p2, p3, 0);
        return;
    }

    public static java.util.ArrayList O(Object[] p4)
    {
        java.util.ArrayList v0_1 = new java.util.ArrayList();
        int v1 = p4.length;
        int v2 = 0;
        while (v2 < v1) {
            Object v3 = p4[v2];
            if (v3 != null) {
                v0_1.add(v3);
            }
            v2++;
        }
        return v0_1;
    }

    public static Object P(int p1, Object[] p2)
    {
        p2.getClass();
        if ((p1 < null) || (p1 >= p2.length)) {
            return 0;
        } else {
            return p2[p1];
        }
    }

    public static String Q(byte[] p6, String p7, ua.l p8, int p9)
    {
        int v0_2;
        String v1 = "";
        if ((p9 & 2) == 0) {
            v0_2 = "[";
        } else {
            v0_2 = "";
        }
        if ((p9 & 4) == 0) {
            v1 = "]";
        }
        if ((p9 & 32) != 0) {
            p8 = 0;
        }
        StringBuilder v9_2 = new StringBuilder();
        v9_2.append(v0_2);
        int v0_1 = p6.length;
        int v2_0 = 0;
        int v3 = 0;
        while (v2_0 < v0_1) {
            String v4_0 = p6[v2_0];
            v3++;
            if (v3 > 1) {
                v9_2.append(p7);
            }
            if (p8 == 0) {
                v9_2.append(String.valueOf(v4_0));
            } else {
                v9_2.append(((CharSequence) p8.invoke(Byte.valueOf(v4_0))));
            }
            v2_0++;
        }
        v9_2.append(v1);
        return v9_2.toString();
    }

    public static String R(Object[] p7, ua.l p8, int p9)
    {
        String v0_1;
        if ((p9 & 1) == 0) {
            v0_1 = ",";
        } else {
            v0_1 = ", ";
        }
        if ((p9 & 32) != 0) {
            p8 = 0;
        }
        p7.getClass();
        StringBuilder v9_3 = new StringBuilder();
        v9_3.append("");
        int v2 = p7.length;
        int v3 = 0;
        int v4 = 0;
        while (v3 < v2) {
            Object v5 = p7[v3];
            v4++;
            if (v4 > 1) {
                v9_3.append(v0_1);
            }
            com.bumptech.glide.d.a(v9_3, v5, p8);
            v3++;
        }
        v9_3.append("");
        return v9_3.toString();
    }

    public static java.util.List S(Object[] p2)
    {
        p2.getClass();
        int v0_0 = p2.length;
        if (v0_0 == 0) {
            return kotlin.collections.EmptyList.g;
        } else {
            if (v0_0 == 1) {
                return com.bumptech.glide.e.l(p2[0]);
            } else {
                java.util.List v2_3 = java.util.Arrays.asList(java.util.Arrays.copyOf(p2, p2.length));
                v2_3.getClass();
                return v2_3;
            }
        }
    }
}
