package com.fimi.soul.service;

import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.AsyncTask;
import android.os.IBinder;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.droneconnection.connection.p196a.C2778a;
import com.fimi.soul.drone.p202h.C2854c;
import com.fimi.soul.utils.C3658ar;
import com.hoho.android.usbserial.driver.UsbSerialProber;
/* loaded from: classes.dex */
public class DroneConnectService extends Service {

    /* renamed from: c */
    public static final String f14672c = "android.hardware.usb.action.USB_DEVICE_DETACHED";

    /* renamed from: d */
    public static final String f14673d = "android.hardware.usb.action.USB_DEVICE_ATTACHED";

    /* renamed from: e */
    public static final String f14674e = "USBHAVECONNECT";

    /* renamed from: f */
    public static final String f14675f = "TCPSONNECTSUCESS";

    /* renamed from: g */
    public static final String f14676g = "android.hardware.usb.action.USB_STATE";

    /* renamed from: h */
    public static final String f14677h = "android.net.conn.TETHER_STATE_CHANGED";

    /* renamed from: l */
    private static final String f14678l = "com.android.example.USB_PERMISSION";

    /* renamed from: a */
    public C2657a f14679a;

    /* renamed from: b */
    public DroidPlannerApp f14680b;

    /* renamed from: i */
    BroadcastReceiver f14681i = new BroadcastReceiver() { // from class: com.fimi.soul.service.DroneConnectService.2
        /* JADX WARN: Type inference failed for: r0v8, types: [com.fimi.soul.service.DroneConnectService$2$1] */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (DroneConnectService.f14678l.equals(intent.getAction())) {
                synchronized (this) {
                    UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
                    if (intent.getBooleanExtra("permission", false) && usbDevice != null) {
                        DroneConnectService.this.m7837a(usbDevice);
                    }
                }
            }
            if (DroneConnectService.f14673d.equals(intent.getAction()) && !DroneConnectService.this.f14679a.mo11217ab().mo10898a()) {
                C2778a.m11026a(C2854c.f10615c);
                DroneConnectService.this.f14679a.mo11217ab().mo10891b();
            } else if (DroneConnectService.f14672c.equals(intent.getAction()) && DroneConnectService.this.f14679a.mo11217ab().mo10898a()) {
                DroneConnectService.this.f14679a.mo11217ab().mo10886d();
            } else if (DroneConnectService.f14677h.equals(intent.getAction()) && C2854c.f10615c.equals(DroneConnectService.this.f14679a.mo11217ab().mo10884e())) {
            } else {
                new AsyncTask<Void, Void, Boolean>() { // from class: com.fimi.soul.service.DroneConnectService.2.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    /* renamed from: a */
                    public Boolean doInBackground(Void... voidArr) {
                        return Boolean.valueOf(C3658ar.m7587d(C2854c.m10763b()));
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    /* renamed from: a */
                    public void onPostExecute(Boolean bool) {
                        super.onPostExecute(bool);
                        C2423d c2423d = (C2423d) C2379b.m12410a().m12394d();
                        if (!DroneConnectService.this.f14679a.mo11217ab().mo10898a() && bool.booleanValue()) {
                            C2778a.m11026a(C2854c.f10616d);
                            DroneConnectService.this.f14679a.mo11217ab().mo10891b();
                            c2423d.m12231w().m12240b();
                        } else if (!DroneConnectService.this.f14679a.mo11217ab().mo10898a() || bool.booleanValue() || !DroneConnectService.this.f14679a.mo11217ab().mo10884e().equals(C2854c.f10616d)) {
                        } else {
                            DroneConnectService.this.f14679a.mo11217ab().mo10886d();
                            c2423d.a(-1);
                            c2423d.n();
                        }
                    }
                }.execute(new Void[0]);
            }
        }
    };

    /* renamed from: j */
    private UsbManager f14682j;

    /* renamed from: k */
    private PendingIntent f14683k;

    /* JADX WARN: Type inference failed for: r0v16, types: [com.fimi.soul.service.DroneConnectService$1] */
    /* renamed from: a */
    public void m7838a() {
        if (UsbSerialProber.findFirstDevice(this.f14682j) != null) {
            C2778a.m11026a(C2854c.f10615c);
            if (this.f14679a.mo11217ab().mo10898a()) {
                return;
            }
            this.f14679a.mo11217ab().mo10891b();
        } else if (this.f14682j != null) {
            for (UsbDevice usbDevice : this.f14682j.getDeviceList().values()) {
                m7837a(usbDevice);
            }
            if (this.f14679a.mo11217ab().mo10898a()) {
                return;
            }
            new AsyncTask<Void, Void, Boolean>() { // from class: com.fimi.soul.service.DroneConnectService.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                /* renamed from: a */
                public Boolean doInBackground(Void... voidArr) {
                    return Boolean.valueOf(C3658ar.m7587d(C2854c.m10763b()));
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                /* renamed from: a */
                public void onPostExecute(Boolean bool) {
                    super.onPostExecute(bool);
                    if (bool.booleanValue()) {
                        C2778a.m11026a(C2854c.f10616d);
                        DroneConnectService.this.f14679a.mo11217ab().mo10891b();
                    }
                }
            }.execute(new Void[0]);
        }
    }

    /* renamed from: a */
    public void m7837a(UsbDevice usbDevice) {
        if (usbDevice.getVendorId() == 1155 && usbDevice.getProductId() == 22336) {
            if (!this.f14682j.hasPermission(usbDevice)) {
                this.f14683k = PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent(f14678l), 0);
                this.f14682j.requestPermission(usbDevice, this.f14683k);
            }
            C2778a.m11026a(C2854c.f10615c);
            if (this.f14679a.mo11217ab().mo10898a()) {
                return;
            }
            this.f14679a.mo11217ab().mo10891b();
        }
    }

    /* renamed from: b */
    public void m7836b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(f14673d);
        intentFilter.addAction(f14672c);
        intentFilter.addAction(f14674e);
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.hardware.usb.action.USB_STATE");
        intentFilter.addAction(f14675f);
        intentFilter.addAction(f14677h);
        intentFilter.addAction(f14678l);
        registerReceiver(this.f14681i, intentFilter);
    }

    /* renamed from: c */
    public void m7835c() {
        unregisterReceiver(this.f14681i);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f14680b = (DroidPlannerApp) getApplication();
        this.f14679a = this.f14680b.f7895a;
        this.f14682j = (UsbManager) getSystemService("usb");
        m7836b();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        m7835c();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        m7838a();
        return super.onStartCommand(intent, i, i2);
    }
}
