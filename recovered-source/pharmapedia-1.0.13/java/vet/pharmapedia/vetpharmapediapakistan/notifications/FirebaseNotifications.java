// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package vet.pharmapedia.vetpharmapediapakistan.notifications;
public final class FirebaseNotifications extends com.google.firebase.messaging.FirebaseMessagingService {

    public FirebaseNotifications()
    {
        return;
    }

    public final void c(String p6, String p7, String p8, String p9, String p10)
    {
        try {
            androidx.core.graphics.drawable.IconCompat v0_2;
            androidx.core.graphics.drawable.IconCompat v0_3 = android.graphics.BitmapFactory.decodeResource(this.getApplicationContext().getResources(), 2131755009);
            e0.r v1_2 = new e0.r(this, "CHANNEL_ID");
            v1_2.q = this.getApplicationContext().getColor(2131099648);
            androidx.core.graphics.drawable.IconCompat v2_3 = new android.content.Intent(this.getApplicationContext(), vet.pharmapedia.vetpharmapediapakistan.ui.activities.NotificationsActivity);
            v2_3.setFlags(67141632);
            v2_3.putExtra("image_url", p8);
            v2_3.putExtra("message", p7);
            v2_3.putExtra("title", p6);
            v2_3.putExtra("actionUrl", p9);
            v2_3.putExtra("actionText", p10);
            android.app.Notification v8_7 = android.app.PendingIntent.getActivity(this, ((int) System.currentTimeMillis()), v2_3, 67108864);
            v1_2.e(v0_3);
            v1_2.v.icon = 2131230848;
            int v9_4 = new e0.o();
        } catch (android.app.NotificationManager v6_1) {
            r1.a.A("onMessageReceived:display error: ", v6_1.getMessage(), "notifications");
            return;
        }
        if (v0_3 != null) {
            androidx.core.graphics.drawable.IconCompat v2_5 = new androidx.core.graphics.drawable.IconCompat(1);
            v2_5.b = v0_3;
            v0_2 = v2_5;
        } else {
            v0_2 = 0;
        }
        v9_4.e = v0_2;
        v1_2.g(v9_4);
        v1_2.e = e0.r.b(p6);
        v1_2.f = e0.r.b(p7);
        android.app.NotificationManager v6_6 = new e0.p(0);
        v6_6.f = e0.r.b(p7);
        v1_2.g(v6_6);
        v1_2.d(16, 0);
        v1_2.j = 1;
        v1_2.g = v8_7;
        android.app.NotificationManager v6_9 = this.getApplicationContext().getSystemService("notification");
        v6_9.getClass();
        android.app.NotificationManager v6_10 = ((android.app.NotificationManager) v6_9);
        v1_2.s = "ALARM_SERVICE_CHANNEL";
        v6_10.notify(((int) System.currentTimeMillis()), v1_2.a());
        return;
    }

    public final void onMessageReceived(com.google.firebase.messaging.RemoteMessage p10)
    {
        p10.getClass();
        super.onMessageReceived(p10);
        try {
            String v4_0 = ((String) p10.getData().get("titl"));
            String v5_1 = ((String) p10.getData().get("bod"));
            String v6_1 = ((String) p10.getData().get("pic"));
            String v7_1 = ((String) p10.getData().get("action_link"));
            String v8_1 = ((String) p10.getData().get("action_title"));
            String v10_1 = p10.getData();
            StringBuilder v2_9 = new StringBuilder("onMessageReceived: title is : ");
            v2_9.append(v10_1);
            v2_9.append(", body is : ");
            v2_9.append(v5_1);
            v2_9.append(" and link is: ");
            v2_9.append(v6_1);
            android.util.Log.d("notifications", v2_9.toString());
            this.c(v4_0, v5_1, v6_1, v7_1, v8_1);
            return;
        } catch (String v0_1) {
            r1.a.A("onMessageReceived: ", v0_1.getMessage(), "notifications");
            return;
        }
    }

    public final void onNewToken(String p2)
    {
        p2.getClass();
        super.onNewToken(p2);
        android.util.Log.d("notifications", "onNewToken: ".concat(p2));
        return;
    }
}
