package com.amap.api.mapcore.util;

import android.graphics.Point;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapMessage;
import com.autonavi.amap.mapcore.MapProjection;
/* renamed from: com.amap.api.mapcore.util.af */
/* loaded from: classes.dex */
public abstract class AbstractC0766af extends MapMessage {

    /* renamed from: b */
    public float f2024b;

    /* renamed from: c */
    public float f2025c;

    /* renamed from: d */
    public float f2026d;

    /* renamed from: e */
    public CameraPosition f2027e;

    /* renamed from: f */
    public LatLngBounds f2028f;

    /* renamed from: h */
    public int f2030h;

    /* renamed from: i */
    public int f2031i;

    /* renamed from: j */
    public int f2032j;

    /* renamed from: k */
    public int f2033k;

    /* renamed from: a */
    public EnumC0767a f2023a = EnumC0767a.none;

    /* renamed from: g */
    public Point f2029g = null;

    /* renamed from: com.amap.api.mapcore.util.af$a */
    /* loaded from: classes.dex */
    public enum EnumC0767a {
        none,
        zoomIn,
        changeCenter,
        changeTilt,
        changeBearing,
        changeBearingGeoCenter,
        changeGeoCenterZoom,
        zoomOut,
        zoomTo,
        zoomBy,
        scrollBy,
        newCameraPosition,
        newLatLngBounds,
        newLatLngBoundsWithSize,
        changeGeoCenterZoomTiltBearing
    }

    /* renamed from: a */
    protected IPoint m19109a(MapProjection mapProjection, int i, int i2) {
        FPoint fPoint = new FPoint();
        mapProjection.win2Map(i, i2, fPoint);
        IPoint iPoint = new IPoint();
        mapProjection.map2Geo(fPoint.f4728x, fPoint.f4729y, iPoint);
        return iPoint;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m19110a(MapProjection mapProjection) {
        this.zoom = Float.isNaN(this.zoom) ? mapProjection.getMapZoomer() : this.zoom;
        this.bearing = Float.isNaN(this.bearing) ? mapProjection.getMapAngle() : this.bearing;
        this.tilt = Float.isNaN(this.tilt) ? mapProjection.getCameraHeaderAngle() : this.tilt;
        this.zoom = C0945eh.m18340a(this.mapConfig, this.zoom);
        this.tilt = C0945eh.m18361a(this.tilt, this.zoom);
        this.bearing = (float) (((this.bearing % 360.0d) + 360.0d) % 360.0d);
        if (this.isUseAnchor) {
            if (this.geoPoint == null) {
                this.geoPoint = m19109a(mapProjection, this.anchorX, this.anchorY);
            }
        } else if (this.f2029g != null && this.geoPoint == null) {
            this.geoPoint = m19109a(mapProjection, this.f2029g.x, this.f2029g.y);
        }
        if (!Float.isNaN(this.zoom)) {
            mapProjection.setMapZoomer(this.zoom);
        }
        if (!Float.isNaN(this.bearing)) {
            mapProjection.setMapAngle(this.bearing);
        }
        if (!Float.isNaN(this.tilt)) {
            mapProjection.setCameraHeaderAngle(this.tilt);
        }
        if (this.isUseAnchor) {
            m19108a(mapProjection, this.geoPoint);
        } else if (this.f2029g != null) {
            m19107a(mapProjection, this.geoPoint, this.f2029g.x, this.f2029g.y);
        } else if (this.geoPoint == null) {
        } else {
            if (this.geoPoint.f4730x == 0 && this.geoPoint.f4731y == 0) {
                return;
            }
            mapProjection.setGeoCenter(this.geoPoint.f4730x, this.geoPoint.f4731y);
        }
    }

    /* renamed from: a */
    protected void m19108a(MapProjection mapProjection, IPoint iPoint) {
        m19107a(mapProjection, iPoint, this.anchorX, this.anchorY);
    }

    /* renamed from: a */
    protected void m19107a(MapProjection mapProjection, IPoint iPoint, int i, int i2) {
        mapProjection.recalculate();
        IPoint m19109a = m19109a(mapProjection, i, i2);
        IPoint iPoint2 = new IPoint();
        mapProjection.getGeoCenter(iPoint2);
        mapProjection.setGeoCenter((iPoint2.f4730x + iPoint.f4730x) - m19109a.f4730x, (iPoint2.f4731y + iPoint.f4731y) - m19109a.f4731y);
    }
}
