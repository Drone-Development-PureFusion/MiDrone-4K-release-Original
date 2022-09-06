package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.amap.api.mapcore.util.C0906dm;
/* loaded from: classes.dex */
public class ScaleAnimation extends Animation {
    public ScaleAnimation(float f, float f2, float f3, float f4) {
        this.glAnimation = new C0906dm(f, f2, f3, f4);
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
