package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.amap.api.mapcore.util.C0902di;
/* loaded from: classes.dex */
public abstract class Animation {
    public C0902di glAnimation;

    /* loaded from: classes.dex */
    public interface AnimationListener {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public Animation() {
        this.glAnimation = null;
        this.glAnimation = new C0902di();
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.glAnimation.m18534a(animationListener);
    }

    public abstract void setDuration(long j);

    public abstract void setInterpolator(Interpolator interpolator);
}
