package com.fimi.soul.module.dronemanage;

import android.content.Context;
import android.graphics.Point;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.support.p001v4.internal.view.SupportMenu;
import android.util.DisplayMetrics;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.fimi.kernel.p164d.C2244b;
import com.fimi.kernel.utils.C2275t;
import com.fimi.kernel.utils.C2277v;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.p178g.C2459j;
import com.fimi.soul.biz.p184m.C2545a;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p202h.C2854c;
import com.fimi.soul.drone.p203i.C2877ah;
import com.fimi.soul.drone.p203i.C2886aq;
import com.fimi.soul.drone.p203i.C2907bk;
import com.fimi.soul.module.droneFragment.C3163c;
import com.fimi.soul.module.droneFragment.C3183e;
import com.fimi.soul.utils.C3632ab;
import com.fimi.soul.utils.C3633ac;
import com.fimi.soul.utils.C3639ai;
import com.fimi.soul.utils.C3678g;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.module.dronemanage.e */
/* loaded from: classes.dex */
public class C3239e implements C2678d.AbstractC2680b {

    /* renamed from: a */
    PolylineOptions f12462a;

    /* renamed from: b */
    List<C2907bk> f12463b;

    /* renamed from: f */
    private AMap f12467f;

    /* renamed from: g */
    private Context f12468g;

    /* renamed from: h */
    private C2657a f12469h;

    /* renamed from: i */
    private LatLng f12470i;

    /* renamed from: m */
    private Marker f12474m;

    /* renamed from: n */
    private float f12475n;

    /* renamed from: o */
    private C3249j f12476o;

    /* renamed from: p */
    private C3234b f12477p;

    /* renamed from: q */
    private int f12478q;

    /* renamed from: r */
    private boolean f12479r;

    /* renamed from: s */
    private int f12480s;

    /* renamed from: t */
    private C2277v f12481t;

    /* renamed from: y */
    private Polyline f12486y;

    /* renamed from: z */
    private Polyline f12487z;

    /* renamed from: j */
    private LatLng f12471j = null;

    /* renamed from: k */
    private int f12472k = 20;

    /* renamed from: l */
    private boolean f12473l = true;

    /* renamed from: u */
    private String f12482u = C2854c.f10581bG;

    /* renamed from: v */
    private String f12483v = C2854c.f10582bH;

    /* renamed from: w */
    private final int f12484w = 100;

    /* renamed from: x */
    private Handler f12485x = new Handler() { // from class: com.fimi.soul.module.dronemanage.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 100 || C2244b.m13099b(C3239e.this.f12469h.f9270d) == null) {
                return;
            }
            C2244b.m13099b(C3239e.this.f12469h.f9270d).m13103a(C3239e.this.f12469h.f9270d.getString(C2300R.C2303string.set_home));
        }
    };

    /* renamed from: d */
    PolylineOptions f12465d = null;

    /* renamed from: A */
    private List<LatLng> f12460A = new ArrayList();

    /* renamed from: B */
    private float f12461B = 0.0f;

    /* renamed from: e */
    int f12466e = 0;

    /* renamed from: c */
    C3183e f12464c = C3183e.m9322a();

    public C3239e(AMap aMap, Context context, C2657a c2657a) {
        this.f12467f = aMap;
        this.f12468g = context;
        this.f12469h = c2657a;
        m9016a();
    }

    /* renamed from: a */
    private double m9012a(Marker marker, C2907bk c2907bk, LatLng latLng) {
        double m7698a = C3632ab.m7729c(latLng, c2907bk.m10355b()).m7698a();
        marker.setTitle(this.f12468g.getResources().getString(C2300R.C2303string.distancetag) + C2275t.m12793a(m7698a, 1) + this.f12468g.getResources().getString(C2300R.C2303string.meter));
        return m7698a;
    }

    /* renamed from: a */
    private void m9011a(C2877ah c2877ah) {
        C3639ai m7726a = C3633ac.m7726a(c2877ah.m10612b(), c2877ah.m10611c());
        this.f12470i = new LatLng(m7726a.m7702a(), m7726a.m7700b());
        this.f12464c.m9321a(this.f12467f, new PoiItem("", new LatLonPoint(this.f12470i.latitude, this.f12470i.longitude), "", ""));
        this.f12464c.m9320a(C2854c.f10519Y);
    }

    /* renamed from: b */
    private void m9005b(LatLng latLng) {
        DisplayMetrics displayMetrics = this.f12468g.getResources().getDisplayMetrics();
        Point screenLocation = this.f12467f.getProjection().toScreenLocation(latLng);
        if (screenLocation.y <= displayMetrics.heightPixels && screenLocation.y >= 0 && screenLocation.x >= 0 && screenLocation.x <= displayMetrics.widthPixels) {
            this.f12469h.mo11220a(C2678d.EnumC2679a.CHANGELOCATIONBUTTONIN);
            return;
        }
        this.f12469h.mo11220a(C2678d.EnumC2679a.CHANGELOCATIONBUTTONOUT);
        if (this.f12469h.mo11205t().m10644a() / 100.0d < 1.0d) {
            return;
        }
        this.f12467f.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, this.f12461B));
    }

    /* renamed from: c */
    private void m9003c(LatLng latLng) {
        if (this.f12469h.m11320al()) {
            m8994h(latLng);
            m8995g(latLng);
        } else if (this.f12486y != null) {
            this.f12486y.remove();
        }
        m8997f(latLng);
        m8999e(latLng);
        m9001d(latLng);
    }

    /* renamed from: d */
    private void m9001d(LatLng latLng) {
        if (C3259l.m8924a() == 1) {
            this.f12463b = this.f12476o.m8943g();
        } else if (C3259l.m8924a() == 2) {
            this.f12463b = this.f12477p.m9028d();
        }
        if (this.f12463b != null && this.f12463b.size() > 0 && this.f12472k == 6 && this.f12478q > 0 && this.f12478q <= this.f12463b.size()) {
            m9012a(this.f12474m, this.f12463b.get(this.f12478q - 1), latLng);
            if (this.f12472k != 6) {
                return;
            }
            this.f12474m.showInfoWindow();
        } else if (this.f12472k != 4) {
            if (!this.f12474m.isInfoWindowShown() || C3163c.m9392d().get() == 1) {
                return;
            }
            this.f12474m.hideInfoWindow();
        } else if (this.f12463b == null || this.f12463b.size() <= 0) {
        } else {
            m9012a(this.f12474m, this.f12463b.get(0), latLng);
            this.f12474m.showInfoWindow();
        }
    }

    /* renamed from: e */
    private void m9000e() {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        Location m11305b = this.f12469h.m11305b();
        builder.include(this.f12471j);
        if (m11305b != null) {
            builder.include(new LatLng(m11305b.getLatitude(), m11305b.getLongitude()));
        }
        if (this.f12470i != null) {
            builder.include(this.f12470i);
        }
        m9014a(builder.build());
        C2545a m11735a = C2545a.m11735a();
        m11735a.m11731a(true);
        m11735a.m11732a(C2545a.EnumC2548a.DRONE);
    }

    /* renamed from: e */
    private void m8999e(LatLng latLng) {
        if (this.f12474m != null) {
            C3163c.m9393c().m9397a(this.f12469h);
            this.f12474m.setPosition(latLng);
        } else {
            this.f12474m = this.f12467f.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(C2300R.C2301drawable.icon_fly_handpiece_location)).draggable(false));
        }
        this.f12474m.setAnchor(0.5f, 0.5f);
        if (String.valueOf(this.f12475n) != null) {
            this.f12474m.setRotateAngle((-this.f12475n) + m8996g());
        }
    }

    /* renamed from: f */
    private void m8998f() {
        if (!this.f12469h.mo11216ac()) {
            if (!this.f12469h.mo11217ab().mo10898a()) {
                if (this.f12474m != null) {
                    this.f12474m.destroy();
                    this.f12474m = null;
                    C3183e.m9322a().m9318b(C2854c.f10518X);
                }
                if (this.f12487z != null) {
                    this.f12487z.remove();
                    this.f12487z = null;
                }
                if (this.f12486y != null) {
                    this.f12486y.remove();
                    this.f12486y = null;
                }
                C3183e.m9322a().m9318b(C2854c.f10519Y);
            } else if (this.f12487z != null && !this.f12487z.isDottedLine()) {
                this.f12487z.setDottedLine(true);
            }
            C3163c.m9390f();
        }
    }

    /* renamed from: f */
    private void m8997f(LatLng latLng) {
        if (this.f12467f.getCameraPosition() != null) {
            this.f12461B = this.f12467f.getCameraPosition().zoom;
        }
        if (!this.f12473l || this.f12471j.latitude <= 1.0d || this.f12471j.longitude <= 1.0d || this.f12469h.mo11202w().m10501d() < 6) {
            return;
        }
        this.f12466e++;
        this.f12469h.m11295f(true);
        this.f12461B = 18.0f;
        if (!this.f12469h.m11320al()) {
            this.f12473l = false;
            this.f12467f.animateCamera(CameraUpdateFactory.newLatLngZoom(this.f12471j, this.f12461B));
            return;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        Location m11305b = this.f12469h.m11305b();
        builder.include(this.f12471j);
        if (m11305b != null) {
            builder.include(new LatLng(m11305b.getLatitude(), m11305b.getLongitude()));
        }
        if (this.f12470i != null) {
            builder.include(this.f12470i);
        }
        m9014a(builder.build());
    }

    /* renamed from: g */
    private synchronized float m8996g() {
        float f = 0.0f;
        synchronized (this) {
            try {
                CameraPosition cameraPosition = this.f12467f.getCameraPosition();
                if (cameraPosition != null) {
                    f = cameraPosition.bearing;
                }
            } catch (Exception e) {
            }
        }
        return f;
    }

    /* renamed from: g */
    private void m8995g(LatLng latLng) {
        if (this.f12470i != null) {
            this.f12460A.add(latLng);
            this.f12460A.add(this.f12470i);
            if (this.f12465d == null) {
                this.f12465d = new PolylineOptions();
                this.f12465d.color(this.f12469h.f9270d.getResources().getColor(C2300R.color.drone_home_line)).width(5.0f);
            }
            if (this.f12487z != null && this.f12487z.isDottedLine()) {
                this.f12487z.remove();
                this.f12487z = null;
            }
            if (this.f12487z != null) {
                this.f12487z.setPoints(this.f12460A);
                if (!this.f12487z.isVisible()) {
                    this.f12487z.setVisible(true);
                }
            } else {
                this.f12487z = this.f12467f.addPolyline(this.f12465d.add(latLng, this.f12470i));
            }
            this.f12460A.clear();
        }
    }

    /* renamed from: h */
    private void m8994h(LatLng latLng) {
        if (this.f12486y != null) {
            this.f12486y.remove();
        }
        this.f12486y = this.f12467f.addPolyline(m9015a(latLng));
    }

    /* renamed from: a */
    public PolylineOptions m9015a(LatLng latLng) {
        if (this.f12462a == null) {
            this.f12462a = new PolylineOptions();
            this.f12462a.setDottedLine(true);
            this.f12462a.width(3.0f);
            this.f12462a.color(SupportMenu.CATEGORY_MASK);
        }
        this.f12462a.add(latLng);
        List<LatLng> points = this.f12462a.getPoints();
        if (points != null && points.size() >= 10) {
            points.remove(points.get(0));
        }
        return this.f12462a;
    }

    /* renamed from: a */
    public void m9016a() {
        this.f12469h.mo11219a(this);
        C3163c.m9393c().m9391e();
    }

    /* renamed from: a */
    public void m9014a(LatLngBounds latLngBounds) {
        this.f12467f.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, C3678g.m7487a(this.f12469h.f9270d, 30.0f), C3678g.m7487a(this.f12469h.f9270d, 30.0f), 0), new AMap.CancelableCallback() { // from class: com.fimi.soul.module.dronemanage.e.2
            @Override // com.amap.api.maps.AMap.CancelableCallback
            public void onCancel() {
                C3239e.this.f12473l = true;
            }

            @Override // com.amap.api.maps.AMap.CancelableCallback
            public void onFinish() {
                if (C3239e.this.f12466e >= 2) {
                    C3239e.this.f12473l = false;
                    C3239e.this.f12466e = 0;
                }
            }
        });
    }

    /* renamed from: a */
    public void m9013a(Marker marker) {
        if (this.f12471j == null || this.f12474m == null) {
            return;
        }
        this.f12474m.setTitle(this.f12468g.getResources().getString(C2300R.C2303string.distancetag) + C2275t.m12793a(C3632ab.m7729c(this.f12471j, marker.getPosition()).m7698a(), 1) + this.f12468g.getResources().getString(C2300R.C2303string.meter));
        this.f12474m.showInfoWindow();
    }

    /* renamed from: a */
    public void m9010a(C3234b c3234b) {
        this.f12477p = c3234b;
    }

    /* renamed from: a */
    public void m9007a(C3249j c3249j) {
        this.f12476o = c3249j;
    }

    /* renamed from: b */
    public void m9006b() {
        this.f12473l = true;
    }

    /* renamed from: c */
    public void m9004c() {
        C3163c.m9393c().m9394b(0);
        C3163c.m9393c();
        C3163c.m9390f();
        this.f12464c.m9315d();
    }

    /* renamed from: d */
    public void m9002d() {
        if (this.f12474m != null) {
            this.f12474m.destroy();
            this.f12474m = null;
        }
    }

    @Override // com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case CLEANALLOBJ:
                m8998f();
                return;
            case HEARDDAY:
                if (c2657a.mo11202w().m10501d() <= 3) {
                    return;
                }
                C2886aq mo11202w = c2657a.mo11202w();
                C3639ai m7726a = C3633ac.m7726a(mo11202w.m10499f(), mo11202w.m10500e());
                this.f12471j = new LatLng(m7726a.m7702a(), m7726a.m7700b());
                c2657a.m11339a(this.f12471j);
                if (c2657a.m11312at().m10703d() == 2) {
                    return;
                }
                m9003c(this.f12471j);
                return;
            case Remotecontrol:
                m8998f();
                return;
            case HOMEPOINT:
                if (!c2657a.m11320al()) {
                    this.f12479r = false;
                    C3183e.m9322a().m9318b(C2854c.f10519Y);
                    if (this.f12487z != null) {
                        this.f12487z.remove();
                        this.f12487z = null;
                    }
                } else if (c2657a.mo11201x().m10608f()) {
                    m9011a(c2657a.mo11201x());
                    if (!this.f12479r && c2657a.m11312at().m10705b() == 3) {
                        this.f12479r = true;
                        this.f12481t = C2277v.m12784a(this.f12468g);
                        this.f12482u = C2854c.f10581bG;
                        this.f12483v = C2854c.f10582bH;
                        this.f12481t.m12787a().edit().putFloat(this.f12482u, (float) c2657a.mo11201x().m10612b()).commit();
                        this.f12481t.m12787a().edit().putFloat(this.f12483v, (float) c2657a.mo11201x().m10611c()).commit();
                        if (this.f12485x.hasMessages(100)) {
                            this.f12485x.removeMessages(100);
                        }
                        this.f12485x.sendEmptyMessageDelayed(100, 1500L);
                        m9000e();
                        C2459j m12118a = C2459j.m12118a();
                        m12118a.m12112b(c2657a.mo11201x().m10612b());
                        m12118a.m12117a(c2657a.mo11201x().m10611c());
                    }
                    if (this.f12480s != this.f12472k) {
                        this.f12480s = this.f12472k;
                    }
                }
                this.f12478q = c2657a.mo11201x().m10609e();
                return;
            case HEARDATA:
                this.f12475n = (float) (c2657a.mo11205t().m10620k() / 10.0d);
                return;
            case NEWFRONEMODEL:
                this.f12472k = c2657a.m11312at().m10702e();
                return;
            case CHANGEFLIGHTHEAD:
                if (String.valueOf(this.f12475n) == null || this.f12474m == null) {
                    return;
                }
                this.f12474m.setRotateAngle((-this.f12475n) + c2657a.m11317ao());
                return;
            default:
                return;
        }
    }
}
