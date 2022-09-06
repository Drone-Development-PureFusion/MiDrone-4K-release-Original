package com.xiaomi.metok.geofencing;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.xiaomi.metok.geofencing.AbstractC4515c;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.metok.geofencing.b */
/* loaded from: classes2.dex */
public class ServiceConnectionC4514b implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ C4513a f18604a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceConnectionC4514b(C4513a c4513a) {
        this.f18604a = c4513a;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.v("GeoFencingServiceWrapper", "*** GeoFencingService connected (yay!)");
        this.f18604a.f18601b = AbstractC4515c.AbstractBinderC4516a.m4934a(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.v("GeoFencingServiceWrapper", "*** GeoFencingService disconnected (boo!)");
        this.f18604a.f18601b = null;
    }
}
