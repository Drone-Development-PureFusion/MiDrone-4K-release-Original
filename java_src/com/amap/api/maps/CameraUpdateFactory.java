package com.amap.api.maps;

import android.graphics.Point;
import android.util.Log;
import com.amap.api.mapcore.util.C0768ag;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
/* loaded from: classes.dex */
public final class CameraUpdateFactory {
    public static CameraUpdate changeBearing(float f) {
        return new CameraUpdate(C0768ag.m19090d(f % 360.0f));
    }

    public static CameraUpdate changeBearingGeoCenter(float f, IPoint iPoint) {
        if (iPoint == null) {
            Log.w("CameraUpdateFactory", "geoPoint is null");
            return new CameraUpdate(C0768ag.m19092c());
        }
        return new CameraUpdate(C0768ag.m19102a(f % 360.0f, iPoint));
    }

    public static CameraUpdate changeLatLng(LatLng latLng) {
        if (latLng == null) {
            Log.w("CameraUpdateFactory", "target is null");
            return new CameraUpdate(C0768ag.m19092c());
        }
        IPoint iPoint = new IPoint();
        MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
        return new CameraUpdate(C0768ag.m19095a(iPoint));
    }

    public static CameraUpdate changeTilt(float f) {
        return new CameraUpdate(C0768ag.m19091c(f));
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        if (cameraPosition == null) {
            Log.w("CameraUpdateFactory", "cameraPosition is null");
            return new CameraUpdate(C0768ag.m19092c());
        }
        return new CameraUpdate(C0768ag.m19101a(cameraPosition));
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        if (latLng == null) {
            Log.w("CameraUpdateFactory", "latLng is null");
            return new CameraUpdate(C0768ag.m19092c());
        }
        return new CameraUpdate(C0768ag.m19100a(latLng));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i) {
        if (latLngBounds == null) {
            Log.w("CameraUpdateFactory", "bounds is null");
            return new CameraUpdate(C0768ag.m19092c());
        }
        return new CameraUpdate(C0768ag.m19098a(latLngBounds, i));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3) {
        if (latLngBounds == null) {
            Log.w("CameraUpdateFactory", "bounds is null");
            return new CameraUpdate(C0768ag.m19092c());
        }
        return new CameraUpdate(C0768ag.m19097a(latLngBounds, i, i2, i3));
    }

    public static CameraUpdate newLatLngBoundsRect(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        if (latLngBounds == null) {
            Log.w("CameraUpdateFactory", "bounds is null");
            return new CameraUpdate(C0768ag.m19092c());
        }
        return new CameraUpdate(C0768ag.m19096a(latLngBounds, i, i2, i3, i4));
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f) {
        if (latLng == null) {
            Log.w("CameraUpdateFactory", "target is null");
            return new CameraUpdate(C0768ag.m19092c());
        }
        return new CameraUpdate(C0768ag.m19099a(latLng, f));
    }

    public static CameraUpdate scrollBy(float f, float f2) {
        return new CameraUpdate(C0768ag.m19104a(f, f2));
    }

    public static CameraUpdate zoomBy(float f) {
        return new CameraUpdate(C0768ag.m19093b(f));
    }

    public static CameraUpdate zoomBy(float f, Point point) {
        return new CameraUpdate(C0768ag.m19103a(f, point));
    }

    public static CameraUpdate zoomIn() {
        return new CameraUpdate(C0768ag.m19106a());
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(C0768ag.m19094b());
    }

    public static CameraUpdate zoomTo(float f) {
        return new CameraUpdate(C0768ag.m19105a(f));
    }
}
