package com.fimi.soul.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.biz.p177f.C2441a;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class UsbStatus extends Service {

    /* renamed from: a */
    public static final String f14718a = "android.hardware.usb.action.USB_STATE";

    /* renamed from: b */
    public static final String f14719b = "android.net.conn.CONNECTIVITY_CHANGE";

    /* renamed from: d */
    private DroidPlannerApp f14721d;

    /* renamed from: e */
    private C2657a f14722e;

    /* renamed from: f */
    private int f14723f = 0;

    /* renamed from: c */
    BroadcastReceiver f14720c = new BroadcastReceiver() { // from class: com.fimi.soul.service.UsbStatus.1
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m7799a() {
            UsbStatus.this.f14722e.mo11217ab().mo10886d();
            C2367d.m12459a().m12455a(false);
            UsbStatus.this.f14722e.m11327ad();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.hardware.usb.action.USB_STATE".equals(intent.getAction())) {
                if (intent.getExtras().getBoolean("connected")) {
                    return;
                }
                if ((!UsbStatus.this.f14722e.mo11216ac() && !UsbStatus.this.f14722e.mo11217ab().mo10898a()) || C2441a.m12168a().m12166b() != 1) {
                    return;
                }
                m7799a();
            } else if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            } else {
                UsbStatus.this.f14723f = 0;
                if (C2441a.m12168a().m12166b() != 2) {
                    return;
                }
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager.getWifiState() == 3) {
                    C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.service.UsbStatus.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z = false;
                            while (UsbStatus.this.f14723f < 2) {
                                z = C3658ar.m7587d("192.168.100.1");
                                UsbStatus.m7800c(UsbStatus.this);
                            }
                            if (!z) {
                                m7799a();
                            }
                        }
                    });
                } else if (wifiManager.getWifiState() != 1 && wifiManager.getWifiState() != 0) {
                } else {
                    m7799a();
                }
            }
        }
    };

    /* renamed from: c */
    static /* synthetic */ int m7800c(UsbStatus usbStatus) {
        int i = usbStatus.f14723f;
        usbStatus.f14723f = i + 1;
        return i;
    }

    /* renamed from: a */
    public void m7804a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.hardware.usb.action.USB_STATE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.f14720c, intentFilter);
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f14721d = (DroidPlannerApp) getApplication();
        this.f14722e = this.f14721d.f7895a;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        m7804a();
        return super.onStartCommand(intent, i, i2);
    }
}
