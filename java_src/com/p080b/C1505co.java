package com.p080b;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.text.SimpleDateFormat;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.b.co */
/* loaded from: classes.dex */
public final class C1505co implements LocationListener {

    /* renamed from: a */
    private /* synthetic */ C1486by f5377a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1505co(C1486by c1486by) {
        this.f5377a = c1486by;
    }

    /* renamed from: a */
    private static boolean m15758a(Location location) {
        return location != null && GeocodeSearch.GPS.equalsIgnoreCase(location.getProvider()) && location.getLatitude() > -90.0d && location.getLatitude() < 90.0d && location.getLongitude() > -180.0d && location.getLongitude() < 180.0d;
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        C1512cv c1512cv;
        C1512cv c1512cv2;
        int i7;
        int i8;
        try {
            long time = location.getTime();
            long currentTimeMillis = System.currentTimeMillis();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormat.format(Long.valueOf(time));
            simpleDateFormat.format(Long.valueOf(currentTimeMillis));
            if (time > 0) {
                currentTimeMillis = time;
            }
            if (location == null || !m15758a(location)) {
                return;
            }
            float speed = location.getSpeed();
            i = C1486by.f5255f;
            if (speed > i) {
                i7 = C1486by.f5258i;
                C1513cw.m15737a(i7);
                i8 = C1486by.f5258i;
                C1513cw.m15735b(i8 * 10);
            } else {
                float speed2 = location.getSpeed();
                i2 = C1486by.f5254e;
                if (speed2 > i2) {
                    i5 = C1486by.f5257h;
                    C1513cw.m15737a(i5);
                    i6 = C1486by.f5257h;
                    C1513cw.m15735b(i6 * 10);
                } else {
                    i3 = C1486by.f5256g;
                    C1513cw.m15737a(i3);
                    i4 = C1486by.f5256g;
                    C1513cw.m15735b(i4 * 10);
                }
            }
            c1512cv = this.f5377a.f5285w;
            c1512cv.m15755a();
            m15758a(location);
            c1512cv2 = this.f5377a.f5285w;
            if (!c1512cv2.m15755a() || !m15758a(location)) {
                return;
            }
            location.setTime(System.currentTimeMillis());
            C1486by.m15925a(this.f5377a, location, 0, currentTimeMillis);
        } catch (Exception e) {
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
