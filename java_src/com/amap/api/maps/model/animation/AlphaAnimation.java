package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.amap.api.mapcore.util.C0901dh;
/* loaded from: classes.dex */
public class AlphaAnimation extends Animation {
    public AlphaAnimation(float f, float f2) {
        this.glAnimation = new C0901dh(f, f2);
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public void setDuration(long j) {
        this.glAnimation.mo18520a(j);
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public void setInterpolator(Interpolator interpolator) {
        this.glAnimation.m18535a(interpolator);
    }
}
