package com.github.moduth.blockcanary.p216ui;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.github.moduth.blockcanary.AbstractC3969l;
import com.github.moduth.blockcanary.C3939R;
/* renamed from: com.github.moduth.blockcanary.ui.c */
/* loaded from: classes.dex */
public class C3989c implements AbstractC3969l {
    @TargetApi(11)
    /* renamed from: a */
    private void m6310a(Context context, String str, String str2, PendingIntent pendingIntent) {
        Notification notification;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (Build.VERSION.SDK_INT < 11) {
            notification = new Notification();
            notification.icon = C3939R.C3940drawable.block_canary_notification;
            notification.when = System.currentTimeMillis();
            notification.flags |= 16;
            notification.defaults = 1;
            notification.setLatestEventInfo(context, str, str2, pendingIntent);
        } else {
            Notification.Builder defaults = new Notification.Builder(context).setSmallIcon(C3939R.C3940drawable.block_canary_notification).setWhen(System.currentTimeMillis()).setContentTitle(str).setContentText(str2).setAutoCancel(true).setContentIntent(pendingIntent).setDefaults(1);
            notification = Build.VERSION.SDK_INT < 16 ? defaults.getNotification() : defaults.build();
        }
        notificationManager.notify(-558907665, notification);
    }

    @Override // com.github.moduth.blockcanary.AbstractC3969l
    /* renamed from: a */
    public void mo6311a(Context context, String str) {
        Intent intent = new Intent(context, DisplayBlockActivity.class);
        intent.putExtra("show_latest", str);
        intent.setFlags(335544320);
        m6310a(context, context.getString(C3939R.C3942string.block_canary_class_has_blocked, str), context.getString(C3939R.C3942string.block_canary_notification_message), PendingIntent.getActivity(context, 1, intent, 134217728));
    }
}
