package com.fimi.soul.module.droneFragment;

import android.annotation.TargetApi;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.services.core.PoiItem;
import com.fimi.soul.C2300R;
import com.fimi.soul.drone.p202h.C2854c;
import java.util.HashMap;
@TargetApi(19)
/* renamed from: com.fimi.soul.module.droneFragment.e */
/* loaded from: classes.dex */
public class C3183e {

    /* renamed from: e */
    private static C3183e f12108e;

    /* renamed from: a */
    Marker f12109a;

    /* renamed from: b */
    private PoiItem f12110b;

    /* renamed from: c */
    private AMap f12111c;

    /* renamed from: d */
    private HashMap<String, Marker> f12112d = new HashMap<>();

    /* renamed from: f */
    private Marker f12113f;

    /* renamed from: g */
    private BitmapDescriptor f12114g;

    /* renamed from: h */
    private BitmapDescriptor f12115h;

    private C3183e() {
    }

    /* renamed from: a */
    public static C3183e m9322a() {
        if (f12108e == null) {
            f12108e = new C3183e();
        }
        return f12108e;
    }

    /* renamed from: d */
    private MarkerOptions m9314d(String str) {
        return new MarkerOptions().position(new LatLng(this.f12110b.getLatLonPoint().getLatitude(), this.f12110b.getLatLonPoint().getLongitude())).icon(m9316c(str));
    }

    /* renamed from: a */
    public void m9321a(AMap aMap, PoiItem poiItem) {
        this.f12111c = aMap;
        this.f12110b = poiItem;
    }

    /* renamed from: a */
    public void m9320a(String str) {
        if (this.f12112d.containsKey(str)) {
            this.f12112d.get(str).setPosition(new LatLng(this.f12110b.getLatLonPoint().getLatitude(), this.f12110b.getLatLonPoint().getLongitude()));
            return;
        }
        this.f12109a = this.f12111c.addMarker(m9314d(str));
        this.f12109a.setObject(str);
        if (C2854c.f10519Y.equals(str)) {
            this.f12109a.setAnchor(0.15f, 1.0f);
            this.f12109a.setZIndex(80.0f);
        } else {
            this.f12109a.setAnchor(0.5f, 0.5f);
            this.f12109a.setZIndex(100.0f);
        }
        this.f12112d.put(str, this.f12109a);
    }

    /* renamed from: b */
    public void m9319b() {
        for (String str : this.f12112d.keySet()) {
            this.f12112d.get(str).remove();
        }
        this.f12112d.clear();
    }

    /* renamed from: b */
    public void m9318b(String str) {
        if (this.f12112d.containsKey(str)) {
            this.f12113f = this.f12112d.get(str);
            this.f12112d.remove(str);
            this.f12113f.remove();
        }
    }

    /* renamed from: c */
    protected BitmapDescriptor m9316c(String str) {
        if (C2854c.f10518X.equals(str)) {
            if (this.f12115h == null) {
                this.f12115h = BitmapDescriptorFactory.fromResource(C2300R.C2301drawable.fuselage);
            }
            return this.f12115h;
        }
        if (this.f12114g == null) {
            this.f12114g = BitmapDescriptorFactory.fromResource(C2300R.C2301drawable.home_point);
        }
        return this.f12114g;
    }

    /* renamed from: c */
    public PoiItem m9317c() {
        return this.f12110b;
    }

    /* renamed from: d */
    public void m9315d() {
        if (this.f12114g != null) {
            this.f12114g.recycle();
        }
        if (this.f12115h != null) {
            this.f12115h.recycle();
        }
    }
}
