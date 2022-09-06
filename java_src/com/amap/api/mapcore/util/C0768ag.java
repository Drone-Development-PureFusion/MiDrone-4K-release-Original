package com.amap.api.mapcore.util;

import android.graphics.Point;
import com.amap.api.mapcore.util.AbstractC0766af;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
/* renamed from: com.amap.api.mapcore.util.ag */
/* loaded from: classes.dex */
public class C0768ag {
    /* renamed from: a */
    public static AbstractC0766af m19106a() {
        C0769ah c0769ah = new C0769ah();
        c0769ah.f2023a = AbstractC0766af.EnumC0767a.zoomBy;
        c0769ah.f2026d = 1.0f;
        return c0769ah;
    }

    /* renamed from: a */
    public static AbstractC0766af m19105a(float f) {
        C0764ad c0764ad = new C0764ad();
        c0764ad.f2023a = AbstractC0766af.EnumC0767a.newCameraPosition;
        c0764ad.zoom = f;
        return c0764ad;
    }

    /* renamed from: a */
    public static AbstractC0766af m19104a(float f, float f2) {
        C0765ae c0765ae = new C0765ae();
        c0765ae.f2023a = AbstractC0766af.EnumC0767a.scrollBy;
        c0765ae.f2024b = f;
        c0765ae.f2025c = f2;
        return c0765ae;
    }

    /* renamed from: a */
    public static AbstractC0766af m19103a(float f, Point point) {
        C0769ah c0769ah = new C0769ah();
        c0769ah.f2023a = AbstractC0766af.EnumC0767a.zoomBy;
        c0769ah.f2026d = f;
        c0769ah.f2029g = point;
        return c0769ah;
    }

    /* renamed from: a */
    public static AbstractC0766af m19102a(float f, IPoint iPoint) {
        C0764ad c0764ad = new C0764ad();
        c0764ad.f2023a = AbstractC0766af.EnumC0767a.newCameraPosition;
        c0764ad.geoPoint = iPoint;
        c0764ad.bearing = f;
        return c0764ad;
    }

    /* renamed from: a */
    public static AbstractC0766af m19101a(CameraPosition cameraPosition) {
        C0764ad c0764ad = new C0764ad();
        c0764ad.f2023a = AbstractC0766af.EnumC0767a.newCameraPosition;
        if (cameraPosition != null && cameraPosition.target != null) {
            IPoint iPoint = new IPoint();
            MapProjection.lonlat2Geo(cameraPosition.target.longitude, cameraPosition.target.latitude, iPoint);
            c0764ad.geoPoint = iPoint;
            c0764ad.zoom = cameraPosition.zoom;
            c0764ad.bearing = cameraPosition.bearing;
            c0764ad.tilt = cameraPosition.tilt;
            c0764ad.f2027e = cameraPosition;
        }
        return c0764ad;
    }

    /* renamed from: a */
    public static AbstractC0766af m19100a(LatLng latLng) {
        return m19101a(CameraPosition.builder().target(latLng).build());
    }

    /* renamed from: a */
    public static AbstractC0766af m19099a(LatLng latLng, float f) {
        return m19101a(CameraPosition.builder().target(latLng).zoom(f).build());
    }

    /* renamed from: a */
    public static AbstractC0766af m19098a(LatLngBounds latLngBounds, int i) {
        C0763ac c0763ac = new C0763ac();
        c0763ac.f2023a = AbstractC0766af.EnumC0767a.newLatLngBounds;
        c0763ac.f2028f = latLngBounds;
        c0763ac.f2030h = i;
        c0763ac.f2031i = i;
        c0763ac.f2032j = i;
        c0763ac.f2033k = i;
        return c0763ac;
    }

    /* renamed from: a */
    public static AbstractC0766af m19097a(LatLngBounds latLngBounds, int i, int i2, int i3) {
        C0763ac c0763ac = new C0763ac();
        c0763ac.f2023a = AbstractC0766af.EnumC0767a.newLatLngBoundsWithSize;
        c0763ac.f2028f = latLngBounds;
        c0763ac.f2030h = i3;
        c0763ac.f2031i = i3;
        c0763ac.f2032j = i3;
        c0763ac.f2033k = i3;
        c0763ac.width = i;
        c0763ac.height = i2;
        return c0763ac;
    }

    /* renamed from: a */
    public static AbstractC0766af m19096a(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        C0763ac c0763ac = new C0763ac();
        c0763ac.f2023a = AbstractC0766af.EnumC0767a.newLatLngBounds;
        c0763ac.f2028f = latLngBounds;
        c0763ac.f2030h = i;
        c0763ac.f2031i = i2;
        c0763ac.f2032j = i3;
        c0763ac.f2033k = i4;
        return c0763ac;
    }

    /* renamed from: a */
    public static AbstractC0766af m19095a(IPoint iPoint) {
        C0764ad c0764ad = new C0764ad();
        c0764ad.f2023a = AbstractC0766af.EnumC0767a.newCameraPosition;
        c0764ad.geoPoint = iPoint;
        return c0764ad;
    }

    /* renamed from: b */
    public static AbstractC0766af m19094b() {
        C0769ah c0769ah = new C0769ah();
        c0769ah.f2023a = AbstractC0766af.EnumC0767a.zoomBy;
        c0769ah.f2026d = -1.0f;
        return c0769ah;
    }

    /* renamed from: b */
    public static AbstractC0766af m19093b(float f) {
        return m19103a(f, (Point) null);
    }

    /* renamed from: c */
    public static AbstractC0766af m19092c() {
        return new C0764ad();
    }

    /* renamed from: c */
    public static AbstractC0766af m19091c(float f) {
        C0764ad c0764ad = new C0764ad();
        c0764ad.f2023a = AbstractC0766af.EnumC0767a.newCameraPosition;
        c0764ad.tilt = f;
        return c0764ad;
    }

    /* renamed from: d */
    public static AbstractC0766af m19090d(float f) {
        C0764ad c0764ad = new C0764ad();
        c0764ad.f2023a = AbstractC0766af.EnumC0767a.newCameraPosition;
        c0764ad.bearing = f;
        return c0764ad;
    }
}
