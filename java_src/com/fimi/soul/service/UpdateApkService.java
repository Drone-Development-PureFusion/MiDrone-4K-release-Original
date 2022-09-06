package com.fimi.soul.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p185n.C2593r;
import com.fimi.soul.utils.C3681j;
import com.fimi.soul.utils.RunnableC3683l;
import java.io.File;
/* loaded from: classes.dex */
public class UpdateApkService extends Service {

    /* renamed from: e */
    private static final int f14709e = 8888;

    /* renamed from: h */
    private static boolean f14710h = false;

    /* renamed from: b */
    private C2593r f14712b;

    /* renamed from: c */
    private NotificationManager f14713c;

    /* renamed from: d */
    private Notification f14714d;

    /* renamed from: f */
    private final int f14715f = 1;

    /* renamed from: g */
    private final int f14716g = 2;

    /* renamed from: a */
    Handler f14711a = new Handler() { // from class: com.fimi.soul.service.UpdateApkService.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                Toast.makeText(UpdateApkService.this, (int) C2300R.C2303string.down_success, 0).show();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setFlags(268435456);
                intent.setDataAndType(Uri.fromFile(new File(C3681j.m7470i(), C2353b.f7912C)), "application/vnd.android.package-archive");
                UpdateApkService.this.startActivity(intent);
            } else if (message.what == 2) {
                UpdateApkService.this.f14714d.contentView.setProgressBar(C2300R.C2302id.download_bar, 100, Integer.parseInt(message.obj.toString()), false);
                UpdateApkService.this.f14714d.contentView.setTextViewText(C2300R.C2302id.text_download_process, message.obj.toString() + "%");
                UpdateApkService.this.m7808a();
                return;
            } else {
                Toast.makeText(UpdateApkService.this, (int) C2300R.C2303string.down_fail, 0).show();
            }
            UpdateApkService.this.f14713c.cancel(UpdateApkService.f14709e);
            boolean unused = UpdateApkService.f14710h = false;
            UpdateApkService.this.stopSelf();
        }
    };

    /* renamed from: a */
    public void m7808a() {
        this.f14713c.notify(f14709e, this.f14714d);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f14712b = C2593r.m11590a(this);
        this.f14713c = (NotificationManager) getSystemService("notification");
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(), 0);
        this.f14714d = new Notification();
        this.f14714d.icon = C2300R.C2301drawable.ic_launcher;
        this.f14714d.tickerText = getString(C2300R.C2303string.down_ing) + getString(C2300R.C2303string.app_name);
        this.f14714d.contentIntent = activity;
        this.f14714d.contentView = new RemoteViews(getPackageName(), (int) C2300R.layout.up_notification);
        this.f14714d.contentView.setProgressBar(C2300R.C2302id.download_bar, 100, 0, false);
        this.f14714d.contentView.setTextViewText(C2300R.C2302id.text_download_title, getString(C2300R.C2303string.down_ing) + " " + getString(C2300R.C2303string.app_name));
        this.f14714d.contentView.setTextViewText(C2300R.C2302id.text_download_process, "0%");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null && intent.getStringExtra("down_url") != null) {
            m7808a();
            if (!f14710h) {
                new Thread(new RunnableC3683l(intent.getStringExtra("down_url"), this.f14711a)).start();
            } else {
                Toast.makeText(this, (int) C2300R.C2303string.apk_downing, 0).show();
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
