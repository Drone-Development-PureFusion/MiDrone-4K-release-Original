package com.tencent.map.p226b;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.util.Iterator;
/* renamed from: com.tencent.map.b.e */
/* loaded from: classes.dex */
public final class C4242e {

    /* renamed from: b */
    private static LocationManager f17614b = null;

    /* renamed from: d */
    private static float f17615d = 0.0f;

    /* renamed from: a */
    private Context f17616a = null;

    /* renamed from: c */
    private C4243a f17617c = null;

    /* renamed from: e */
    private AbstractC4245c f17618e = null;

    /* renamed from: f */
    private C4244b f17619f = null;

    /* renamed from: g */
    private boolean f17620g = false;

    /* renamed from: h */
    private byte[] f17621h = new byte[0];

    /* renamed from: i */
    private int f17622i = 1024;

    /* renamed from: j */
    private long f17623j = 0;

    /* renamed from: k */
    private boolean f17624k = false;

    /* renamed from: l */
    private int f17625l = 0;

    /* renamed from: m */
    private int f17626m = 0;

    /* renamed from: com.tencent.map.b.e$a */
    /* loaded from: classes.dex */
    class C4243a implements GpsStatus.Listener, LocationListener {
        private C4243a() {
        }

        /* synthetic */ C4243a(C4242e c4242e, byte b) {
            this();
        }

        @Override // android.location.GpsStatus.Listener
        public final void onGpsStatusChanged(int i) {
            switch (i) {
                case 1:
                    C4242e.m5782a(C4242e.this, 1);
                    break;
                case 2:
                    C4242e.m5782a(C4242e.this, 0);
                    break;
                case 3:
                    C4242e.m5782a(C4242e.this, 2);
                    break;
            }
            C4242e.this.m5779b();
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            boolean z = false;
            if (location != null) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                if (latitude != 29.999998211860657d && longitude != 103.99999916553497d && Math.abs(latitude) >= 1.0E-8d && Math.abs(longitude) >= 1.0E-8d && latitude >= -90.0d && latitude <= 90.0d && longitude >= -180.0d && longitude <= 180.0d) {
                    z = true;
                }
                if (!z) {
                    return;
                }
                C4242e.this.f17623j = System.currentTimeMillis();
                C4242e.this.m5779b();
                C4242e.m5782a(C4242e.this, 2);
                C4242e.this.f17619f = new C4244b(C4242e.this, location, C4242e.this.f17625l, C4242e.this.f17626m, C4242e.this.f17622i, C4242e.this.f17623j);
                if (C4242e.this.f17618e == null) {
                    return;
                }
                C4242e.this.f17618e.mo5762a(C4242e.this.f17619f);
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            if (str != null) {
                try {
                    if (!str.equals(GeocodeSearch.GPS)) {
                        return;
                    }
                    C4242e.this.f17625l = C4242e.this.f17626m = 0;
                    C4242e.this.f17622i = 0;
                    if (C4242e.this.f17618e == null) {
                        return;
                    }
                    C4242e.this.f17618e.mo5765a(C4242e.this.f17622i);
                } catch (Exception e) {
                }
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
            if (str != null) {
                try {
                    if (!str.equals(GeocodeSearch.GPS)) {
                        return;
                    }
                    C4242e.this.f17622i = 4;
                    if (C4242e.this.f17618e == null) {
                        return;
                    }
                    C4242e.this.f17618e.mo5765a(C4242e.this.f17622i);
                } catch (Exception e) {
                }
            }
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    /* renamed from: com.tencent.map.b.e$b */
    /* loaded from: classes.dex */
    public class C4244b implements Cloneable {

        /* renamed from: a */
        private Location f17628a;

        /* renamed from: b */
        private long f17629b;

        /* renamed from: c */
        private int f17630c;

        public C4244b(C4242e c4242e, Location location, int i, int i2, int i3, long j) {
            this.f17628a = null;
            this.f17629b = 0L;
            this.f17630c = 0;
            if (location != null) {
                this.f17628a = new Location(location);
                this.f17630c = i2;
                this.f17629b = j;
            }
        }

        /* renamed from: a */
        public final boolean m5769a() {
            if (this.f17628a == null) {
                return false;
            }
            return (this.f17630c <= 0 || this.f17630c >= 3) && System.currentTimeMillis() - this.f17629b <= 30000;
        }

        /* renamed from: b */
        public final Location m5768b() {
            return this.f17628a;
        }

        public final Object clone() {
            C4244b c4244b;
            try {
                c4244b = (C4244b) super.clone();
            } catch (Exception e) {
                c4244b = null;
            }
            if (this.f17628a != null) {
                c4244b.f17628a = new Location(this.f17628a);
            }
            return c4244b;
        }
    }

    /* renamed from: com.tencent.map.b.e$c */
    /* loaded from: classes.dex */
    public interface AbstractC4245c {
        /* renamed from: a */
        void mo5765a(int i);

        /* renamed from: a */
        void mo5762a(C4244b c4244b);
    }

    /* renamed from: a */
    static /* synthetic */ int m5782a(C4242e c4242e, int i) {
        int i2 = c4242e.f17622i | i;
        c4242e.f17622i = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m5779b() {
        this.f17626m = 0;
        this.f17625l = 0;
        GpsStatus gpsStatus = f17614b.getGpsStatus(null);
        if (gpsStatus == null) {
            return;
        }
        int maxSatellites = gpsStatus.getMaxSatellites();
        Iterator<GpsSatellite> it2 = gpsStatus.getSatellites().iterator();
        if (it2 == null) {
            return;
        }
        while (it2.hasNext() && this.f17625l <= maxSatellites) {
            this.f17625l++;
            if (it2.next().usedInFix()) {
                this.f17626m++;
            }
        }
    }

    /* renamed from: a */
    public final void m5785a() {
        synchronized (this.f17621h) {
            if (!this.f17620g) {
                return;
            }
            if (f17614b != null && this.f17617c != null) {
                f17614b.removeGpsStatusListener(this.f17617c);
                f17614b.removeUpdates(this.f17617c);
            }
            this.f17620g = false;
        }
    }

    /* renamed from: a */
    public final boolean m5784a(AbstractC4245c abstractC4245c, Context context) {
        synchronized (this.f17621h) {
            if (this.f17620g) {
                return true;
            }
            if (context == null || abstractC4245c == null) {
                return false;
            }
            this.f17616a = context;
            this.f17618e = abstractC4245c;
            try {
                f17614b = (LocationManager) this.f17616a.getSystemService("location");
                this.f17617c = new C4243a(this, (byte) 0);
                if (f17614b != null) {
                    if (this.f17617c != null) {
                        try {
                            f17614b.requestLocationUpdates(GeocodeSearch.GPS, 1000L, 0.0f, this.f17617c);
                            f17614b.addGpsStatusListener(this.f17617c);
                            if (f17614b.isProviderEnabled(GeocodeSearch.GPS)) {
                                this.f17622i = 4;
                            } else {
                                this.f17622i = 0;
                            }
                            this.f17620g = true;
                            return this.f17620g;
                        } catch (Exception e) {
                            return false;
                        }
                    }
                }
                return false;
            } catch (Exception e2) {
                return false;
            }
        }
    }
}
