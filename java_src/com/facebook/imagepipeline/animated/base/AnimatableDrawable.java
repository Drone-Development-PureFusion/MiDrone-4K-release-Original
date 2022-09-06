package com.facebook.imagepipeline.animated.base;

import android.graphics.drawable.Animatable;
import com.p113c.p114a.C1819q;
/* loaded from: classes.dex */
public interface AnimatableDrawable extends Animatable {
    C1819q.AbstractC1826b createAnimatorUpdateListener();

    C1819q createValueAnimator();

    C1819q createValueAnimator(int i);
}
