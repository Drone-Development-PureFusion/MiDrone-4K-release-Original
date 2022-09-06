package com.p080b;

import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.b.cr */
/* loaded from: classes.dex */
public final class C1508cr extends Thread {

    /* renamed from: a */
    final /* synthetic */ C1486by f5378a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1508cr(C1486by c1486by, String str) {
        super(str);
        this.f5378a = c1486by;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        C1510ct c1510ct;
        Looper looper;
        Looper looper2;
        C1486by c1486by;
        LocationManager locationManager;
        LocationManager locationManager2;
        C1510ct c1510ct2;
        LocationManager locationManager3;
        C1510ct c1510ct3;
        LocationManager locationManager4;
        LocationListener locationListener;
        C1510ct c1510ct4;
        Looper looper3;
        Looper looper4;
        LocationManager locationManager5;
        LocationManager locationManager6;
        C1510ct c1510ct5;
        LocationManager locationManager7;
        C1510ct c1510ct6;
        LocationManager locationManager8;
        LocationListener locationListener2;
        LocationManager locationManager9;
        int i;
        LocationListener locationListener3;
        LocationManager locationManager10;
        C1510ct c1510ct7;
        LocationManager locationManager11;
        C1510ct c1510ct8;
        try {
            synchronized (this.f5378a.f5273c) {
                if (C1486by.f5251a) {
                    Looper.prepare();
                    this.f5378a.f5288z = Looper.myLooper();
                    try {
                        this.f5378a.f5261A = new C1510ct(this.f5378a);
                        locationManager10 = this.f5378a.f5279q;
                        c1510ct7 = this.f5378a.f5261A;
                        locationManager10.addGpsStatusListener(c1510ct7);
                        locationManager11 = this.f5378a.f5279q;
                        c1510ct8 = this.f5378a.f5261A;
                        locationManager11.addNmeaListener(c1510ct8);
                    } catch (Throwable th) {
                    }
                    this.f5378a.f5262B = new HandlerC1509cs(this);
                    try {
                        locationManager9 = this.f5378a.f5279q;
                        i = C1486by.f5253d;
                        locationListener3 = this.f5378a.f5264D;
                        locationManager9.requestLocationUpdates("passive", 1000L, i, locationListener3);
                    } catch (Throwable th2) {
                    }
                }
            }
            if (C1486by.f5251a) {
                Looper.loop();
            }
            c1510ct4 = this.f5378a.f5261A;
            if (c1510ct4 != null) {
                locationManager5 = this.f5378a.f5279q;
                if (locationManager5 != null) {
                    locationManager6 = this.f5378a.f5279q;
                    c1510ct5 = this.f5378a.f5261A;
                    locationManager6.removeGpsStatusListener(c1510ct5);
                    locationManager7 = this.f5378a.f5279q;
                    c1510ct6 = this.f5378a.f5261A;
                    locationManager7.removeNmeaListener(c1510ct6);
                    locationManager8 = this.f5378a.f5279q;
                    locationListener2 = this.f5378a.f5264D;
                    locationManager8.removeUpdates(locationListener2);
                    this.f5378a.f5261A = null;
                }
            }
            looper3 = this.f5378a.f5288z;
        } catch (Throwable th3) {
            c1510ct = this.f5378a.f5261A;
            if (c1510ct != null) {
                locationManager = this.f5378a.f5279q;
                if (locationManager != null) {
                    locationManager2 = this.f5378a.f5279q;
                    c1510ct2 = this.f5378a.f5261A;
                    locationManager2.removeGpsStatusListener(c1510ct2);
                    locationManager3 = this.f5378a.f5279q;
                    c1510ct3 = this.f5378a.f5261A;
                    locationManager3.removeNmeaListener(c1510ct3);
                    locationManager4 = this.f5378a.f5279q;
                    locationListener = this.f5378a.f5264D;
                    locationManager4.removeUpdates(locationListener);
                    this.f5378a.f5261A = null;
                }
            }
            looper = this.f5378a.f5288z;
            if (looper == null) {
                return;
            }
            looper2 = this.f5378a.f5288z;
            looper2.quit();
            c1486by = this.f5378a;
        }
        if (looper3 != null) {
            looper4 = this.f5378a.f5288z;
            looper4.quit();
            c1486by = this.f5378a;
            c1486by.f5288z = null;
        }
    }
}
