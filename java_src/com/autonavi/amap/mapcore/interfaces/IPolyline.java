package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.PolylineOptions;
import java.util.List;
/* loaded from: classes.dex */
public interface IPolyline extends IOverlay {
    int getColor();

    LatLng getNearestLatLng(LatLng latLng);

    PolylineOptions getOptions();

    List<LatLng> getPoints();

    float getWidth();

    boolean isDottedLine();

    boolean isGeodesic();

    void setColor(int i);

    void setCustomTexture(BitmapDescriptor bitmapDescriptor);

    void setDottedLine(boolean z);

    void setGeodesic(boolean z);

    void setOptions(PolylineOptions polylineOptions);

    void setPoints(List<LatLng> list);

    void setTransparency(float f);

    void setWidth(float f);
}
