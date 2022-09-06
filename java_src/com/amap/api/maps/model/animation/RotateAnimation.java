package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.amap.api.mapcore.util.C0905dl;
/* loaded from: classes.dex */
public class RotateAnimation extends Animation {
    public RotateAnimation(float f, float f2) {
        this.glAnimation = new C0905dl(f, f2, 0.0f, 0.0f, 0.0f);
    }

    public RotateAnimation(float f, float f2, float f3, float f4, float f5) {
        this.glAnimation = new C0905dl(f, f2, f3, f4, f5);
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
