package com.amap.api.mapcore.util;

import android.graphics.Point;
import android.graphics.PointF;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
/* renamed from: com.amap.api.mapcore.util.t */
/* loaded from: classes.dex */
class C1126t implements AbstractC1117n {

    /* renamed from: a */
    private AbstractC1115l f3524a;

    public C1126t(AbstractC1115l abstractC1115l) {
        this.f3524a = abstractC1115l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public TileProjection fromBoundsToTile(LatLngBounds latLngBounds, int i, int i2) {
        if (latLngBounds == null || i < 0 || i > 20 || i2 <= 0) {
            return null;
        }
        IPoint iPoint = new IPoint();
        IPoint iPoint2 = new IPoint();
        this.f3524a.mo17555a(latLngBounds.southwest.latitude, latLngBounds.southwest.longitude, iPoint);
        this.f3524a.mo17555a(latLngBounds.northeast.latitude, latLngBounds.northeast.longitude, iPoint2);
        int i3 = (iPoint.f4730x >> (20 - i)) / i2;
        int i4 = (iPoint.f4731y >> (20 - i)) / i2;
        int i5 = (iPoint2.f4730x >> (20 - i)) / i2;
        int i6 = (iPoint2.f4731y >> (20 - i)) / i2;
        int i7 = (i6 << (20 - i)) * i2;
        return new TileProjection((iPoint.f4730x - ((i3 << (20 - i)) * i2)) >> (20 - i), (iPoint2.f4731y - i7) >> (20 - i), i3, i5, i6, i4);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public LatLng fromScreenLocation(Point point) {
        if (point == null) {
            return null;
        }
        DPoint dPoint = new DPoint();
        this.f3524a.mo17551a(point.x, point.y, dPoint);
        return new LatLng(dPoint.f4727y, dPoint.f4726x);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public LatLngBounds getMapBounds(LatLng latLng, float f) {
        if (this.f3524a == null || latLng == null) {
            return null;
        }
        return this.f3524a.mo17543a(latLng, f, 0.0f, 0.0f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public VisibleRegion getVisibleRegion() {
        int mapWidth = this.f3524a.getMapWidth();
        int mapHeight = this.f3524a.getMapHeight();
        LatLng fromScreenLocation = fromScreenLocation(new Point(0, 0));
        LatLng fromScreenLocation2 = fromScreenLocation(new Point(mapWidth, 0));
        LatLng fromScreenLocation3 = fromScreenLocation(new Point(0, mapHeight));
        LatLng fromScreenLocation4 = fromScreenLocation(new Point(mapWidth, mapHeight));
        return new VisibleRegion(fromScreenLocation3, fromScreenLocation4, fromScreenLocation, fromScreenLocation2, LatLngBounds.builder().include(fromScreenLocation3).include(fromScreenLocation4).include(fromScreenLocation).include(fromScreenLocation2).build());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public float toMapLenWithWin(int i) {
        if (i <= 0) {
            return 0.0f;
        }
        return this.f3524a.mo17553a(i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public PointF toMapLocation(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        FPoint fPoint = new FPoint();
        this.f3524a.mo17556a(latLng.latitude, latLng.longitude, fPoint);
        return new PointF(fPoint.f4728x, fPoint.f4729y);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public Point toScreenLocation(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        IPoint iPoint = new IPoint();
        this.f3524a.mo17537b(latLng.latitude, latLng.longitude, iPoint);
        return new Point(iPoint.f4730x, iPoint.f4731y);
    }
}
