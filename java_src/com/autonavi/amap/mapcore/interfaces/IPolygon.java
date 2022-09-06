package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.LatLng;
import java.util.List;
/* loaded from: classes.dex */
public interface IPolygon extends IOverlay {
    boolean contains(LatLng latLng);

    int getFillColor();

    List<LatLng> getPoints();

    int getStrokeColor();

    float getStrokeWidth();

    void setFillColor(int i);

    void setPoints(List<LatLng> list);

    void setStrokeColor(int i);

    void setStrokeWidth(float f);
}
