package com.autonavi.amap.mapcore.interfaces;
/* loaded from: classes.dex */
public interface IOverlay {
    void destroy();

    boolean equalsRemote(IOverlay iOverlay);

    String getId();

    float getZIndex();

    int hashCodeRemote();

    boolean isAboveMaskLayer();

    boolean isVisible();

    void remove();

    void setAboveMaskLayer(boolean z);

    void setVisible(boolean z);

    void setZIndex(float f);
}
