package com.amap.api.mapcore.util;

import android.content.Context;
import android.location.Location;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
/* renamed from: com.amap.api.mapcore.util.da */
/* loaded from: classes.dex */
public class C0891da {

    /* renamed from: a */
    private AbstractC1115l f2528a;

    /* renamed from: b */
    private Marker f2529b;

    /* renamed from: c */
    private Circle f2530c;

    /* renamed from: d */
    private MyLocationStyle f2531d;

    /* renamed from: e */
    private LatLng f2532e;

    /* renamed from: f */
    private double f2533f;

    /* renamed from: g */
    private Context f2534g;

    /* renamed from: h */
    private C1127u f2535h;

    /* renamed from: i */
    private int f2536i = 1;

    /* renamed from: j */
    private boolean f2537j = false;

    /* renamed from: k */
    private final String f2538k = "location_map_gps_locked.png";

    /* renamed from: l */
    private final String f2539l = "location_map_gps_3d.png";

    /* renamed from: m */
    private boolean f2540m = false;

    public C0891da(AbstractC1115l abstractC1115l, Context context) {
        this.f2534g = context.getApplicationContext();
        this.f2528a = abstractC1115l;
        this.f2535h = new C1127u(this.f2534g, abstractC1115l);
    }

    /* renamed from: b */
    private void m18663b(float f) {
        if (this.f2528a == null) {
            return;
        }
        try {
            this.f2528a.mo17542a(C0768ag.m19091c(f));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m18662b(Location location) {
        float bearing = location.getBearing() % 360.0f;
        if (bearing > 180.0f) {
            bearing -= 360.0f;
        } else if (bearing < -180.0f) {
            bearing += 360.0f;
        }
        if (this.f2529b != null) {
            this.f2529b.setRotateAngle(-bearing);
        }
    }

    /* renamed from: c */
    private void m18660c(float f) {
        if (this.f2528a == null) {
            return;
        }
        try {
            this.f2528a.mo17542a(C0768ag.m19090d(f));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: f */
    private void m18657f() {
        if (this.f2529b != null) {
            m18660c(0.0f);
            this.f2535h.m17469b();
            if (!this.f2540m) {
                this.f2529b.setIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
            }
            this.f2529b.setFlat(false);
            m18663b(0.0f);
        }
    }

    /* renamed from: g */
    private void m18656g() {
        if (this.f2529b != null) {
            m18660c(0.0f);
            this.f2535h.m17469b();
            if (!this.f2540m) {
                this.f2529b.setIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
            }
            this.f2529b.setFlat(false);
            m18663b(0.0f);
        }
    }

    /* renamed from: h */
    private void m18655h() {
        if (this.f2529b != null) {
            this.f2529b.setRotateAngle(0.0f);
            this.f2535h.m17472a();
            if (!this.f2540m) {
                this.f2529b.setIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_3d.png"));
            }
            this.f2529b.setFlat(true);
            try {
                this.f2528a.mo17542a(C0768ag.m19105a(17.0f));
                m18663b(45.0f);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: i */
    private void m18654i() {
        if (this.f2536i != 1 || !this.f2537j) {
            try {
                IPoint iPoint = new IPoint();
                MapProjection.lonlat2Geo(this.f2532e.longitude, this.f2532e.latitude, iPoint);
                this.f2528a.mo17532b(C0768ag.m19095a(iPoint));
            } catch (Throwable th) {
                C1007fo.m18012b(th, "MyLocationOverlay", "locaitonFollow");
                th.printStackTrace();
            }
        }
    }

    /* renamed from: j */
    private void m18653j() {
        if (this.f2531d != null) {
            this.f2540m = true;
            m18651l();
            return;
        }
        this.f2531d = new MyLocationStyle();
        this.f2531d.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        m18651l();
    }

    /* renamed from: k */
    private void m18652k() {
        if (this.f2530c != null) {
            try {
                this.f2528a.mo17540a(this.f2530c.getId());
            } catch (Throwable th) {
                C1007fo.m18012b(th, "MyLocationOverlay", "locationIconRemove");
                th.printStackTrace();
            }
            this.f2530c = null;
        }
        if (this.f2529b != null) {
            this.f2529b.remove();
            this.f2529b.destroy();
            this.f2529b = null;
            this.f2535h.m17470a((Marker) null);
        }
    }

    /* renamed from: l */
    private void m18651l() {
        try {
            this.f2530c = this.f2528a.addCircle(new CircleOptions().strokeWidth(this.f2531d.getStrokeWidth()).fillColor(this.f2531d.getRadiusFillColor()).strokeColor(this.f2531d.getStrokeColor()).center(new LatLng(0.0d, 0.0d)).zIndex(1.0f));
            if (this.f2532e != null) {
                this.f2530c.setCenter(this.f2532e);
            }
            this.f2530c.setRadius(this.f2533f);
            this.f2529b = this.f2528a.addMarker(new MarkerOptions().visible(false).anchor(this.f2531d.getAnchorU(), this.f2531d.getAnchorV()).icon(this.f2531d.getMyLocationIcon()).position(new LatLng(0.0d, 0.0d)));
            m18667a(this.f2536i);
            if (this.f2532e != null) {
                this.f2529b.setPosition(this.f2532e);
                this.f2529b.setVisible(true);
            }
            this.f2535h.m17470a(this.f2529b);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "MyLocationOverlay", "myLocStyle");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m18669a() {
        if (this.f2536i != 3 || this.f2535h == null) {
            return;
        }
        this.f2535h.m17472a();
    }

    /* renamed from: a */
    public void m18668a(float f) {
        if (this.f2529b != null) {
            this.f2529b.setRotateAngle(f);
        }
    }

    /* renamed from: a */
    public void m18667a(int i) {
        this.f2536i = i;
        this.f2537j = false;
        switch (this.f2536i) {
            case 1:
                m18657f();
                return;
            case 2:
                m18656g();
                return;
            case 3:
                m18655h();
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void m18666a(Location location) {
        if (location == null) {
            return;
        }
        this.f2532e = new LatLng(location.getLatitude(), location.getLongitude());
        this.f2533f = location.getAccuracy();
        if (this.f2529b == null && this.f2530c == null) {
            m18653j();
        }
        if (this.f2529b != null) {
            this.f2529b.setPosition(this.f2532e);
        }
        if (this.f2530c == null) {
            return;
        }
        try {
            this.f2530c.setCenter(this.f2532e);
            if (this.f2533f != -1.0d) {
                this.f2530c.setRadius(this.f2533f);
            }
        } catch (Throwable th) {
            C1007fo.m18012b(th, "MyLocationOverlay", "setCentAndRadius");
            th.printStackTrace();
        }
        m18654i();
        if (this.f2536i != 3) {
            m18662b(location);
        }
        this.f2537j = true;
    }

    /* renamed from: a */
    public void m18665a(MyLocationStyle myLocationStyle) {
        try {
            this.f2531d = myLocationStyle;
            if (this.f2529b == null && this.f2530c == null) {
                return;
            }
            m18652k();
            this.f2535h.m17470a(this.f2529b);
            m18653j();
        } catch (Throwable th) {
            C1007fo.m18012b(th, "MyLocationOverlay", "setMyLocationStyle");
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m18664b() {
        m18652k();
        if (this.f2535h != null) {
            this.f2535h.m17469b();
            this.f2535h = null;
        }
    }

    /* renamed from: c */
    public String m18661c() {
        if (this.f2529b != null) {
            return this.f2529b.getId();
        }
        return null;
    }

    /* renamed from: d */
    public String m18659d() {
        if (this.f2530c != null) {
            return this.f2530c.getId();
        }
        return null;
    }

    /* renamed from: e */
    public void m18658e() {
        this.f2530c = null;
        this.f2529b = null;
    }
}
