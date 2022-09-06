package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.IPoint;
import java.util.ArrayList;
/* loaded from: classes.dex */
public interface IMarker extends IOverlayImage {
    IPoint getGeoPoint();

    IMarkerAction getIMarkerAction();

    ArrayList<BitmapDescriptor> getIcons();

    int getPeriod();

    String getSnippet();

    String getTitle();

    void hideInfoWindow();

    boolean isDraggable();

    boolean isFlat();

    boolean isInfoWindowShown();

    boolean isPerspective();

    void set2Top();

    void setAnimation(Animation animation);

    void setAnimationListener(Animation.AnimationListener animationListener);

    void setBelowMaskLayer(boolean z);

    void setDraggable(boolean z);

    void setFlat(boolean z);

    void setGeoPoint(IPoint iPoint);

    void setIcon(BitmapDescriptor bitmapDescriptor);

    void setIcons(ArrayList<BitmapDescriptor> arrayList);

    void setPeriod(int i);

    void setPerspective(boolean z);

    void setPositionByPixels(int i, int i2);

    void setSnippet(String str);

    void setTitle(String str);

    void showInfoWindow();

    boolean startAnimation();
}
