package com.fimi.soul.module.dronemanage;

import android.graphics.Point;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.module.dronemanage.f */
/* loaded from: classes.dex */
public class C3243f {

    /* renamed from: a */
    private AMap f12491a;

    /* renamed from: b */
    private List<Polyline> f12492b = new ArrayList();

    /* renamed from: c */
    private Polyline f12493c;

    public C3243f(AMap aMap) {
        this.f12491a = aMap;
    }

    /* renamed from: a */
    public void m8993a() {
        for (Polyline polyline : this.f12492b) {
            polyline.remove();
        }
    }

    /* renamed from: a */
    public void m8991a(LatLng latLng, LatLng latLng2) {
        m8993a();
        int i = this.f12491a.getProjection().toScreenLocation(latLng).x;
        int i2 = this.f12491a.getProjection().toScreenLocation(latLng).y;
        int i3 = this.f12491a.getProjection().toScreenLocation(latLng2).x;
        int i4 = this.f12491a.getProjection().toScreenLocation(latLng2).y;
        double atan = Math.atan(10.0d / 20.0d);
        double sqrt = Math.sqrt((20.0d * 20.0d) + (10.0d * 10.0d));
        double[] m8992a = m8992a(i3 - i, i4 - i2, atan, sqrt);
        double[] m8992a2 = m8992a(i3 - i, i4 - i2, -atan, sqrt);
        double d = i3 - m8992a[0];
        double d2 = i4 - m8992a[1];
        double d3 = i3 - m8992a2[0];
        double d4 = i4 - m8992a2[1];
        Point point = new Point((int) d, (int) d2);
        Point point2 = new Point((int) d3, (int) d4);
        LatLng fromScreenLocation = this.f12491a.getProjection().fromScreenLocation(point);
        LatLng fromScreenLocation2 = this.f12491a.getProjection().fromScreenLocation(point2);
        this.f12493c = this.f12491a.addPolyline(new PolylineOptions().add(latLng2, fromScreenLocation).color(-256).width(5.0f));
        if (!this.f12492b.contains(this.f12493c)) {
            this.f12492b.add(this.f12493c);
        }
        this.f12493c = this.f12491a.addPolyline(new PolylineOptions().add(latLng2, fromScreenLocation2).color(-256).width(5.0f));
        if (!this.f12492b.contains(this.f12493c)) {
            this.f12492b.add(this.f12493c);
        }
    }

    /* renamed from: a */
    public double[] m8992a(int i, int i2, double d, double d2) {
        double cos = (i * Math.cos(d)) - (i2 * Math.sin(d));
        double sin = (i * Math.sin(d)) + (i2 * Math.cos(d));
        double sqrt = Math.sqrt((cos * cos) + (sin * sin));
        return new double[]{(cos / sqrt) * d2, (sin / sqrt) * d2};
    }
}
