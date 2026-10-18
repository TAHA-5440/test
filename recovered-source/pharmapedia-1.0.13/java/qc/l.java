// Decompiled approximation from supplied bytecode; not original source or a tested rebuild.
package qc;
public final class l implements com.onesignal.notifications.INotificationClickListener {
    public final synthetic vet.pharmapedia.vetpharmapediapakistan.MyAppClass a;

    public l(vet.pharmapedia.vetpharmapediapakistan.MyAppClass p1)
    {
        this.a = p1;
        return;
    }

    public final void onClick(com.onesignal.notifications.INotificationClickEvent p10)
    {
        String v0_0 = this.a;
        p10.getClass();
        android.util.Log.d("oneSignalNotification", "remoteNotificationReceived: Notification clicked");
        String v5_1;
        android.content.Intent v10_7 = p10.getNotification();
        int v1_2 = v10_7.getTitle();
        String v3_0 = v10_7.getBody();
        android.content.Intent v10_1 = v10_7.getAdditionalData();
        android.content.Intent v4 = "";
        if (v10_1 == null) {
            v5_1 = "";
        } else {
            v5_1 = v10_1.optString("pic");
            if (v5_1 == null) {
            }
        }
        String v6_1;
        if (v10_1 == null) {
            v6_1 = "";
        } else {
            v6_1 = v10_1.optString("action_link");
            if (v6_1 == null) {
            }
        }
        if (v10_1 != null) {
            android.content.Intent v10_2 = v10_1.optString("action_title");
            if (v10_2 != null) {
                v4 = v10_2;
            } else {
            }
        }
        android.content.Intent v10_6 = new android.content.Intent(v0_0.getApplicationContext(), vet.pharmapedia.vetpharmapediapakistan.ui.activities.NotificationsActivity);
        v10_6.putExtra("image_url", v5_1);
        v10_6.putExtra("message", v3_0);
        v10_6.putExtra("actionUrl", v6_1);
        v10_6.putExtra("actionText", v4);
        v10_6.putExtra("title", v1_2);
        v10_6.setFlags(268468224);
        v0_0.startActivity(v10_6);
        return;
    }
}
