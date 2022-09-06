package com.p080b;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.LocationManager;
import android.os.Handler;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import p004b.p005a.p006a.p028b.p054o.AbstractC0517a;
/* renamed from: com.b.ct */
/* loaded from: classes.dex */
public final class C1510ct implements GpsStatus.Listener, GpsStatus.NmeaListener {

    /* renamed from: a */
    private long f5380a = 0;

    /* renamed from: b */
    private long f5381b = 0;

    /* renamed from: c */
    private boolean f5382c = false;

    /* renamed from: d */
    private List f5383d = new ArrayList();

    /* renamed from: e */
    private String f5384e = null;

    /* renamed from: f */
    private String f5385f = null;

    /* renamed from: g */
    private String f5386g = null;

    /* renamed from: h */
    private /* synthetic */ C1486by f5387h;

    /* JADX INFO: Access modifiers changed from: protected */
    public C1510ct(C1486by c1486by) {
        this.f5387h = c1486by;
    }

    /* renamed from: a */
    public final void m15757a(String str) {
        int i;
        int i2;
        int i3;
        if (System.currentTimeMillis() - this.f5381b > 400) {
            if (this.f5382c && this.f5383d.size() > 0) {
                try {
                    C1523df c1523df = new C1523df(this.f5383d, this.f5384e, null, this.f5386g);
                    if (c1523df.m15708a()) {
                        C1486by c1486by = this.f5387h;
                        C1486by c1486by2 = this.f5387h;
                        i = this.f5387h.f5269I;
                        c1486by.f5272L = C1486by.m15921a(c1486by2, c1523df, i);
                        i2 = this.f5387h.f5272L;
                        if (i2 > 0) {
                            C1486by c1486by3 = this.f5387h;
                            Locale locale = Locale.CHINA;
                            i3 = this.f5387h.f5272L;
                            C1486by.m15920a(c1486by3, String.format(locale, "&nmea=%.1f|%.1f&g_tp=%d", Double.valueOf(c1523df.m15706c()), Double.valueOf(c1523df.m15707b()), Integer.valueOf(i3)));
                        }
                    } else {
                        this.f5387h.f5272L = 0;
                    }
                } catch (Exception e) {
                    this.f5387h.f5272L = 0;
                }
                this.f5383d.clear();
                this.f5386g = null;
                this.f5385f = null;
                this.f5384e = null;
                this.f5382c = false;
            }
            if (this.f5383d != null && this.f5383d.size() > 100) {
                this.f5383d.clear();
            }
        }
        if (str.startsWith("$GPGGA")) {
            this.f5382c = true;
            this.f5384e = str.trim();
        } else if (str.startsWith("$GPGSV")) {
            this.f5383d.add(str.trim());
        } else if (str.startsWith("$GPGSA")) {
            this.f5386g = str.trim();
        }
        this.f5381b = System.currentTimeMillis();
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bc, code lost:
        if (r0 >= 4) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c6, code lost:
        if (r0 >= 4) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    @Override // android.location.GpsStatus.Listener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onGpsStatusChanged(int i) {
        LocationManager locationManager;
        GpsStatus gpsStatus;
        LocationManager locationManager2;
        GpsStatus gpsStatus2;
        GpsStatus gpsStatus3;
        int i2;
        C1499ci c1499ci;
        C1499ci c1499ci2;
        C1499ci c1499ci3;
        C1499ci c1499ci4;
        HashMap hashMap;
        LocationManager locationManager3;
        int i3;
        int i4;
        int i5;
        LocationManager locationManager4;
        int i6 = 0;
        try {
            locationManager = this.f5387h.f5279q;
            if (locationManager != null) {
                switch (i) {
                    case 2:
                        this.f5387h.f5271K = 0;
                        return;
                    case 3:
                    default:
                        return;
                    case 4:
                        if (!C1486by.f5251a && System.currentTimeMillis() - this.f5380a < AbstractC0517a.f1169e) {
                            return;
                        }
                        gpsStatus = this.f5387h.f5267G;
                        if (gpsStatus == null) {
                            C1486by c1486by = this.f5387h;
                            locationManager4 = this.f5387h.f5279q;
                            c1486by.f5267G = locationManager4.getGpsStatus(null);
                        } else {
                            locationManager2 = this.f5387h.f5279q;
                            gpsStatus2 = this.f5387h.f5267G;
                            locationManager2.getGpsStatus(gpsStatus2);
                        }
                        gpsStatus3 = this.f5387h.f5267G;
                        this.f5387h.f5268H = 0;
                        this.f5387h.f5269I = 0;
                        this.f5387h.f5270J = new HashMap();
                        int i7 = 0;
                        int i8 = 0;
                        for (GpsSatellite gpsSatellite : gpsStatus3.getSatellites()) {
                            i7++;
                            if (gpsSatellite.usedInFix()) {
                                i8++;
                            }
                            if (gpsSatellite.getSnr() > 0.0f) {
                                i6++;
                            }
                            float snr = gpsSatellite.getSnr();
                            i5 = C1486by.f5248U;
                            if (snr >= i5) {
                                C1486by.m15895h(this.f5387h);
                            }
                        }
                        i2 = this.f5387h.f5275m;
                        if (i2 != -1) {
                            if (i8 >= 4) {
                                i4 = this.f5387h.f5275m;
                                break;
                            }
                            if (i8 < 4) {
                                i3 = this.f5387h.f5275m;
                                break;
                            }
                            this.f5387h.f5271K = i6;
                            C1486by c1486by2 = this.f5387h;
                            hashMap = this.f5387h.f5270J;
                            c1486by2.m15916a(hashMap);
                            if (!C1486by.f5251a) {
                                return;
                            }
                            if (i8 <= 3 && i7 <= 15) {
                                return;
                            }
                            locationManager3 = this.f5387h.f5279q;
                            if (locationManager3.getLastKnownLocation(GeocodeSearch.GPS) == null) {
                                return;
                            }
                            this.f5380a = System.currentTimeMillis();
                            return;
                        }
                        this.f5387h.f5275m = i8;
                        if (i8 < 4) {
                            c1499ci3 = this.f5387h.f5280r;
                            if (c1499ci3 != null) {
                                c1499ci4 = this.f5387h.f5280r;
                                c1499ci4.m15763v();
                            }
                        } else {
                            c1499ci = this.f5387h.f5280r;
                            if (c1499ci != null) {
                                c1499ci2 = this.f5387h.f5280r;
                                c1499ci2.m15764u();
                            }
                        }
                        this.f5387h.f5271K = i6;
                        C1486by c1486by22 = this.f5387h;
                        hashMap = this.f5387h.f5270J;
                        c1486by22.m15916a(hashMap);
                        if (!C1486by.f5251a) {
                        }
                        break;
                }
            }
        } catch (Exception e) {
        }
    }

    @Override // android.location.GpsStatus.NmeaListener
    public final void onNmeaReceived(long j, String str) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        try {
            if (!C1486by.f5251a || str == null || str.equals("") || str.length() < 9 || str.length() > 150) {
                return;
            }
            handler = this.f5387h.f5262B;
            if (handler == null) {
                return;
            }
            handler2 = this.f5387h.f5262B;
            handler3 = this.f5387h.f5262B;
            handler2.sendMessage(handler3.obtainMessage(1, str));
        } catch (Exception e) {
        }
    }
}
