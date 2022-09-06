package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.amap.api.mapcore.util.C0908do;
import com.amap.api.maps.model.LatLng;
/* loaded from: classes.dex */
public class TranslateAnimation extends Animation {
    public TranslateAnimation(LatLng latLng) {
        this.glAnimation = new C0908do(latLng);
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
