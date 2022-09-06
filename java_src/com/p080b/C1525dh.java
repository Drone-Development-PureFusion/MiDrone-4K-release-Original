package com.p080b;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.p080b.C1390a;
/* renamed from: com.b.dh */
/* loaded from: classes.dex */
public class C1525dh {

    /* renamed from: a */
    Handler f5462a;

    /* renamed from: b */
    Context f5463b;

    /* renamed from: c */
    LocationManager f5464c;

    /* renamed from: d */
    AMapLocationClientOption f5465d;

    /* renamed from: e */
    long f5466e = 1000;

    /* renamed from: f */
    long f5467f = 0;

    /* renamed from: g */
    LocationListener f5468g = new C1526a();

    /* renamed from: com.b.dh$a */
    /* loaded from: classes.dex */
    class C1526a implements LocationListener {
        C1526a() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            AMapLocation aMapLocation;
            if (location == null) {
                return;
            }
            try {
                Bundle extras = location.getExtras();
                int i = extras != null ? extras.getInt("satellites") : 0;
                if (i <= 0 && !C1525dh.this.f5465d.isMockEnable()) {
                    return;
                }
                if (C1525dh.this.f5462a != null) {
                    C1525dh.this.f5462a.sendEmptyMessage(5);
                }
                if (C1477bs.m15997b() - C1525dh.this.f5467f <= C1525dh.this.f5466e) {
                    return;
                }
                if (!C1514cx.m15732a(location.getLatitude(), location.getLongitude()) || !C1525dh.this.f5465d.isOffset()) {
                    aMapLocation = new AMapLocation(location);
                    aMapLocation.setLatitude(location.getLatitude());
                    aMapLocation.setLongitude(location.getLongitude());
                    aMapLocation.setLocationType(1);
                } else {
                    aMapLocation = new AMapLocation(location);
                    aMapLocation.setLocationType(1);
                    DPoint m15684a = C1528dj.m15684a(C1525dh.this.f5463b, location.getLongitude(), location.getLatitude());
                    aMapLocation.setLatitude(m15684a.getLatitude());
                    aMapLocation.setLongitude(m15684a.getLongitude());
                }
                aMapLocation.setSatellites(i);
                Message message = new Message();
                message.obj = aMapLocation;
                message.what = 2;
                if (C1525dh.this.f5462a != null) {
                    C1525dh.this.f5462a.sendMessage(message);
                }
                C1525dh.this.f5467f = C1477bs.m15997b();
            } catch (Throwable th) {
                C1514cx.m15728a(th, "GPSLocation", "onLocationChanged");
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            try {
                if (!GeocodeSearch.GPS.equals(str) || C1525dh.this.f5462a == null) {
                    return;
                }
                C1525dh.this.f5462a.sendEmptyMessage(3);
            } catch (Throwable th) {
                C1514cx.m15728a(th, "GPSLocation", "onProviderDisabled");
            }
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            if (i == 0 || i == 1) {
                try {
                    if (C1525dh.this.f5462a == null) {
                        return;
                    }
                    C1525dh.this.f5462a.sendEmptyMessage(3);
                } catch (Throwable th) {
                    C1514cx.m15728a(th, "GPSLocation", "onStatusChanged");
                }
            }
        }
    }

    public C1525dh(Context context, C1390a.HandlerC1395c handlerC1395c) {
        this.f5463b = context;
        this.f5462a = handlerC1395c;
        this.f5464c = (LocationManager) this.f5463b.getSystemService("location");
    }

    /* renamed from: a */
    public void m15694a() {
        if (this.f5464c == null || this.f5468g == null) {
            return;
        }
        try {
            this.f5464c.removeUpdates(this.f5468g);
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    void m15693a(long j, float f) {
        try {
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = this.f5463b.getMainLooper();
            }
            this.f5466e = j;
            this.f5464c.requestLocationUpdates(GeocodeSearch.GPS, 1000L, f, this.f5468g, myLooper);
        } catch (SecurityException e) {
            C1514cx.m15728a(e, "GPSLocation", "requestLocationUpdates part1");
            if (!this.f5465d.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors)) {
                return;
            }
            Message obtain = Message.obtain();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setProvider(GeocodeSearch.GPS);
            aMapLocation.setErrorCode(12);
            aMapLocation.setLocationType(1);
            obtain.what = 2;
            obtain.obj = aMapLocation;
            if (this.f5462a == null) {
                return;
            }
            this.f5462a.sendMessage(obtain);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "GPSLocation", "requestLocationUpdates part2");
        }
    }

    /* renamed from: a */
    public void m15692a(AMapLocationClientOption aMapLocationClientOption) {
        this.f5465d = aMapLocationClientOption;
        m15693a(this.f5465d.getInterval(), 0.0f);
    }
}
