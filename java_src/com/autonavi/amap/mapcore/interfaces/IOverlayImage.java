package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.LatLng;
/* loaded from: classes.dex */
public interface IOverlayImage {
    void destroy();

    boolean equalsRemote(IOverlayImage iOverlayImage);

    float getAnchorU();

    float getAnchorV();

    String getId();

    Object getObject();

    LatLng getPosition();

    float getRotateAngle();

    float getZIndex();

    int hashCodeRemote();

    boolean isVisible();

    boolean remove();

    void setAnchor(float f, float f2);

    void setObject(Object obj);

    void setPosition(LatLng latLng);

    void setRotateAngle(float f);

    void setVisible(boolean z);

    void setZIndex(float f);
}
