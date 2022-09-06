package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.LatLng;
import java.util.List;
/* loaded from: classes.dex */
public interface INavigateArrow extends IOverlay {
    List<LatLng> getPoints();

    int getSideColor();

    int getTopColor();

    float getWidth();

    void setPoints(List<LatLng> list);

    void setSideColor(int i);

    void setTopColor(int i);

    void setWidth(float f);
}
