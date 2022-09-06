package com.autonavi.amap.mapcore.interfaces;

import android.graphics.Point;
import android.graphics.PointF;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;
/* loaded from: classes.dex */
public interface IProjection {
    TileProjection fromBoundsToTile(LatLngBounds latLngBounds, int i, int i2);

    LatLng fromScreenLocation(Point point);

    LatLngBounds getMapBounds(LatLng latLng, float f);

    VisibleRegion getVisibleRegion();

    float toMapLenWithWin(int i);

    PointF toMapLocation(LatLng latLng);

    Point toScreenLocation(LatLng latLng);
}
