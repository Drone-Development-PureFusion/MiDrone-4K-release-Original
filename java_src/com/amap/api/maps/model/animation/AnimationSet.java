package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.amap.api.mapcore.util.C0903dj;
/* loaded from: classes.dex */
public class AnimationSet extends Animation {
    public AnimationSet(boolean z) {
        this.glAnimation = new C0903dj(z);
    }

    public void addAnimation(Animation animation) {
        ((C0903dj) this.glAnimation).m18518a(animation);
    }

    public void cleanAnimation() {
        ((C0903dj) this.glAnimation).m18511o();
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
