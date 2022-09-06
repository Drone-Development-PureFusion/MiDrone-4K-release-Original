package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.LatLng;
/* loaded from: classes.dex */
public interface ICircle extends IOverlay {
    boolean contains(LatLng latLng);

    LatLng getCenter();

    int getFillColor();

    double getRadius();

    int getStrokeColor();

    float getStrokeWidth();

    void setCenter(LatLng latLng);

    void setFillColor(int i);

    void setRadius(double d);

    void setStrokeColor(int i);

    void setStrokeWidth(float f);
}
