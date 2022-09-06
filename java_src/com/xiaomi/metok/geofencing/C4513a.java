package com.xiaomi.metok.geofencing;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.util.Log;
/* renamed from: com.xiaomi.metok.geofencing.a */
/* loaded from: classes2.dex */
public class C4513a {

    /* renamed from: a */
    private Context f18600a;

    /* renamed from: b */
    private AbstractC4515c f18601b;

    /* renamed from: c */
    private boolean f18602c;

    /* renamed from: d */
    private final ServiceConnection f18603d = new ServiceConnectionC4514b(this);

    public C4513a(Context context) {
        this.f18602c = false;
        this.f18600a = context;
        this.f18602c = false;
        m4938a(context);
    }

    /* renamed from: a */
    public void m4938a(Context context) {
        if (!this.f18602c && context != null) {
            if (this.f18601b != null) {
                Log.d("GeoFencingServiceWrapper", "GeoFencingService already started");
                return;
            }
            Intent intent = new Intent("com.xiaomi.metok.GeoFencingService");
            intent.setPackage("com.xiaomi.metok");
            try {
                if (!context.bindService(intent, this.f18603d, 1)) {
                    Log.d("GeoFencingServiceWrapper", "Can't bind GeoFencingService");
                    this.f18602c = false;
                } else {
                    Log.d("GeoFencingServiceWrapper", "GeoFencingService started");
                    this.f18602c = true;
                }
            } catch (SecurityException e) {
                Log.e("GeoFencingServiceWrapper", "SecurityException:" + e);
            }
        }
    }

    /* renamed from: a */
    public void m4937a(Context context, double d, double d2, float f, long j, String str, String str2, String str3) {
        m4938a(context);
        if (this.f18601b != null) {
            try {
                this.f18601b.mo4931a(d, d2, f, j, str, str2, str3);
                Log.d("GeoFencingServiceWrapper", "calling registerFenceListener success");
            } catch (RemoteException e) {
                throw new RuntimeException("GeoFencingService has died", e);
            }
        }
    }

    /* renamed from: a */
    public void m4936a(Context context, String str, String str2) {
        m4938a(context);
        if (this.f18601b != null) {
            try {
                this.f18601b.mo4928a(str, str2);
                Log.d("GeoFencingServiceWrapper", "calling unregisterFenceListener success");
            } catch (RemoteException e) {
                throw new RuntimeException("GeoFencingService has died", e);
            }
        }
    }
}
