package com.fimi.soul.biz.p180i;

import android.content.Context;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polyline;
import com.fimi.soul.C2300R;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.utils.C3633ac;
import com.fimi.soul.utils.C3639ai;
import java.util.List;
/* renamed from: com.fimi.soul.biz.i.b */
/* loaded from: classes.dex */
public class C2468b {

    /* renamed from: a */
    public volatile boolean f8489a;

    /* renamed from: b */
    private AMap f8490b;

    /* renamed from: c */
    private Context f8491c;

    /* renamed from: d */
    private C2657a f8492d;

    /* renamed from: e */
    private Marker f8493e;

    /* renamed from: f */
    private Polyline f8494f;

    public C2468b(AMap aMap, Context context, C2657a c2657a) {
        this.f8492d = c2657a;
        this.f8490b = aMap;
        this.f8491c = context;
    }

    /* renamed from: a */
    public void m12087a() {
        C3639ai m7726a = C3633ac.m7726a(this.f8492d.mo11202w().m10499f(), this.f8492d.mo11202w().m10500e());
        m12086a(new LatLng(m7726a.m7702a(), m7726a.m7700b()));
    }

    /* renamed from: a */
    public void m12086a(LatLng latLng) {
        if (this.f8493e == null) {
            this.f8493e = this.f8490b.addMarker(new MarkerOptions().icon(C2479j.m12014a(C2300R.C2301drawable.img_fly_origin_blue)).position(latLng));
            this.f8493e.setAnchor(0.5f, 0.88f);
            this.f8493e.setObject(this);
        }
    }

    /* renamed from: b */
    public void m12085b() {
        if (this.f8493e != null) {
            this.f8493e.setIcon(C2479j.m12014a(C2300R.C2301drawable.img_fly_origin_red));
        }
    }

    /* renamed from: b */
    public void m12084b(LatLng latLng) {
        List<LatLng> m12054c = C2472d.m12036p().m12054c();
        if (m12054c == null || m12054c.contains(latLng)) {
            return;
        }
        m12054c.add(latLng);
        if (m12054c.size() < 2) {
            return;
        }
        if (this.f8494f == null) {
            this.f8494f = this.f8490b.addPolyline(C2478i.m12016a(m12054c, 4, this.f8491c.getResources().getColor(C2300R.color.drone_inface_line)).zIndex(50.0f));
        } else {
            this.f8494f.setPoints(m12054c);
        }
    }

    /* renamed from: c */
    public void m12083c() {
        if (this.f8493e != null) {
            this.f8493e.destroy();
            this.f8493e = null;
        }
        if (this.f8494f != null) {
            this.f8494f.remove();
            this.f8494f = null;
        }
    }

    /* renamed from: d */
    public void m12082d() {
        this.f8489a = false;
        if (this.f8493e != null) {
            this.f8493e.setTitle(this.f8492d.f9270d.getString(C2300R.C2303string.delete_marker));
            this.f8493e.showInfoWindow();
        }
    }

    /* renamed from: e */
    public void m12081e() {
        this.f8489a = false;
        if (this.f8493e != null) {
            this.f8493e.hideInfoWindow();
        }
    }

    /* renamed from: f */
    public void m12080f() {
        this.f8489a = true;
        if (this.f8493e != null) {
            this.f8493e.hideInfoWindow();
        }
    }

    /* renamed from: g */
    public boolean m12079g() {
        return this.f8493e == null;
    }
}
