package com.autonavi.amap.mapcore.interfaces;
/* loaded from: classes.dex */
public interface IUiSettings {
    float getLogoMarginRate(int i);

    int getLogoPosition();

    int getZoomPosition();

    boolean isCompassEnabled();

    boolean isIndoorSwitchEnabled();

    boolean isMyLocationButtonEnabled();

    boolean isRotateGesturesEnabled();

    boolean isScaleControlsEnabled();

    boolean isScrollGesturesEnabled();

    boolean isTiltGesturesEnabled();

    boolean isZoomControlsEnabled();

    boolean isZoomGesturesEnabled();

    boolean isZoomInByScreenCenter();

    void setAllGesturesEnabled(boolean z);

    void setCompassEnabled(boolean z);

    void setIndoorSwitchEnabled(boolean z);

    void setLogoBottomMargin(int i);

    void setLogoLeftMargin(int i);

    void setLogoMarginRate(int i, float f);

    void setLogoPosition(int i);

    void setMyLocationButtonEnabled(boolean z);

    void setRotateGesturesEnabled(boolean z);

    void setScaleControlsEnabled(boolean z);

    void setScrollGesturesEnabled(boolean z);

    void setTiltGesturesEnabled(boolean z);

    void setZoomControlsEnabled(boolean z);

    void setZoomGesturesEnabled(boolean z);

    void setZoomInByScreenCenter(boolean z);

    void setZoomPosition(int i);
}
