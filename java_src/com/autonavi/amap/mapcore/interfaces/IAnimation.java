package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.mapcore.util.C0902di;
import com.amap.api.maps.model.animation.Animation;
/* loaded from: classes.dex */
public interface IAnimation {
    void setAnimation(C0902di c0902di);

    void setAnimationListener(Animation.AnimationListener animationListener);

    boolean startAnimation();
}
