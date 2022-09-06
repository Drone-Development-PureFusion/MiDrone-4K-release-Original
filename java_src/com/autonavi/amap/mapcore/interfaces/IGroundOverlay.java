package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
/* loaded from: classes.dex */
public interface IGroundOverlay extends IOverlay {
    float getBearing();

    LatLngBounds getBounds();

    float getHeight();

    LatLng getPosition();

    float getTransparency();

    float getWidth();

    void setBearing(float f);

    void setDimensions(float f);

    void setDimensions(float f, float f2);

    void setImage(BitmapDescriptor bitmapDescriptor);

    void setPosition(LatLng latLng);

    void setPositionFromBounds(LatLngBounds latLngBounds);

    void setTransparency(float f);
}
