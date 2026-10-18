// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.utils;
public abstract class a {

    public static void a(android.app.Activity p9, tc.b p10, String p11, int p12, String p13, ua.a p14)
    {
        p9.getClass();
        p10.getClass();
        p11.getClass();
        gb.w.p(gb.w.b(nb.c.i), 0, new vet.pharmapedia.vetpharmapediapakistan.utils.Constants$Companion$addOrRemoveBrandsFavourite$1(p10, p11, p12, p9, p14, p13, 0), 3);
        return;
    }

    public static void b(android.app.Activity p9, tc.b p10, String p11, int p12, String p13, ua.a p14)
    {
        p9.getClass();
        p10.getClass();
        p11.getClass();
        gb.w.p(gb.w.b(nb.c.i), 0, new vet.pharmapedia.vetpharmapediapakistan.utils.Constants$Companion$addOrRemoveSaltFavourite$1(p10, p11, p12, p9, p14, p13, 0), 3);
        return;
    }

    public static k.c c(android.app.Activity p2)
    {
        switch (xc.a.a) {
            case 0:
                return new k.c(p2, 2132017556);
            case 1:
                return new k.c(p2, 2132017537);
            case 2:
                return new k.c(p2, 2132017548);
            case 3:
                return new k.c(p2, 2132017550);
            case 4:
                return new k.c(p2, 2132017551);
            case 5:
                return new k.c(p2, 2132017552);
            case 6:
                return new k.c(p2, 2132017553);
            case 7:
                return new k.c(p2, 2132017554);
            case 8:
                return new k.c(p2, 2132017555);
            case 9:
                return new k.c(p2, 2132017527);
            case 10:
                return new k.c(p2, 2132017528);
            case 11:
                return new k.c(p2, 2132017529);
            case 12:
                return new k.c(p2, 2132017530);
            case 13:
                return new k.c(p2, 2132017531);
            case 14:
                return new k.c(p2, 2132017532);
            case 15:
                return new k.c(p2, 2132017533);
            case 16:
                return new k.c(p2, 2132017534);
            case 17:
                return new k.c(p2, 2132017535);
            case 18:
                return new k.c(p2, 2132017536);
            case 19:
                return new k.c(p2, 2132017538);
            case 20:
                return new k.c(p2, 2132017539);
            case 21:
                return new k.c(p2, 2132017540);
            case 22:
                return new k.c(p2, 2132017541);
            case 23:
                return new k.c(p2, 2132017542);
            case 24:
                return new k.c(p2, 2132017543);
            case 25:
                return new k.c(p2, 2132017544);
            case 26:
                return new k.c(p2, 2132017545);
            case 27:
                return new k.c(p2, 2132017546);
            case 28:
                return new k.c(p2, 2132017547);
            case 29:
                return new k.c(p2, 2132017549);
            default:
                return new k.c(p2, 2132017552);
        }
    }

    public static void d(android.app.Activity p8, String p9, String p10)
    {
        p9.getClass();
        try {
            android.content.Intent v2_1 = new android.content.Intent("android.intent.action.SENDTO");
            String v3_2 = p8.getString(2131951658);
            StringBuilder v7_1 = new StringBuilder("\n                ");
            v7_1.append(p10);
            v7_1.append(": ");
            v7_1.append(v3_2);
            v7_1.append("- App Version13\n                OS Version-");
            v7_1.append(android.os.Build$VERSION.SDK_INT);
            v7_1.append("\n                Device Model-");
            v7_1.append(android.os.Build.MANUFACTURER);
            v7_1.append(android.os.Build.MODEL);
            v7_1.append("\n                ");
            String v10_6 = android.net.Uri.encode(db.j.H(v7_1.toString()));
            String v9_1 = android.net.Uri.encode(p9);
            StringBuilder v1_2 = new StringBuilder("mailto:vetpharmapediapakistan@gmail.com?subject=");
            v1_2.append(v10_6);
            v1_2.append("&body=");
            v1_2.append(v9_1);
            String v9_3 = android.net.Uri.parse(v1_2.toString());
            v9_3.getClass();
            v2_1.setData(v9_3);
            p8.startActivity(android.content.Intent.createChooser(v2_1, "Send email"));
            return;
        } catch (String v8_1) {
            String v8_2 = v8_1.getMessage();
            String v9_7 = new StringBuilder("sendEmail:");
            v9_7.append(v8_2);
            v9_7.append(" ");
            android.util.Log.d("emailError", v9_7.toString());
            return;
        }
    }
}
