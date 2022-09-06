package com.amap.api.location;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import com.p080b.C1481bw;
import com.p080b.C1514cx;
import com.p080b.C1533dm;
import com.p080b.C1534dn;
import com.p080b.C1580z;
import com.tencent.p227mm.sdk.plugin.MMPluginProviderConstants;
/* loaded from: classes.dex */
public class APSService extends Service {

    /* renamed from: a */
    Messenger f2001a;

    /* renamed from: b */
    APSServiceBase f2002b;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(MMPluginProviderConstants.OAuth.API_KEY);
            if (!TextUtils.isEmpty(stringExtra)) {
                C1534dn.m15656a(stringExtra);
            }
            String stringExtra2 = intent.getStringExtra("packageName");
            String stringExtra3 = intent.getStringExtra("sha1AndPackage");
            C1533dm.m15669a(stringExtra2);
            C1533dm.m15667b(stringExtra3);
            this.f2001a = new Messenger(this.f2002b.getHandler());
            return this.f2001a.getBinder();
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APSService", "onBind");
            return null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        onCreate(this);
    }

    public void onCreate(Context context) {
        try {
            this.f2002b = (APSServiceBase) C1580z.m15422a(context, C1514cx.m15729a("2.4.1"), "com.amap.api.location.APSServiceWrapper", C1481bw.class, new Class[]{Context.class}, new Object[]{context});
        } catch (Throwable th) {
            this.f2002b = new C1481bw(this);
            C1514cx.m15728a(th, "APSService", "onCreate");
        }
        this.f2002b.onCreate();
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            this.f2002b.onDestroy();
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APSService", "onDestroy");
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            return this.f2002b.onStartCommand(intent, i, i2);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "APSService", "onStartCommand");
            return super.onStartCommand(intent, i, i2);
        }
    }
}
