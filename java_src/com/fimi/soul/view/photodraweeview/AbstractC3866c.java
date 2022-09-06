package com.fimi.soul.view.photodraweeview;

import android.view.GestureDetector;
import android.view.View;
/* renamed from: com.fimi.soul.view.photodraweeview.c */
/* loaded from: classes.dex */
public interface AbstractC3866c {

    /* renamed from: a */
    public static final float f16417a = 3.0f;

    /* renamed from: b */
    public static final float f16418b = 1.75f;

    /* renamed from: c */
    public static final float f16419c = 1.0f;

    /* renamed from: d */
    public static final long f16420d = 200;

    /* renamed from: a */
    void mo6744a(float f, float f2, float f3, boolean z);

    /* renamed from: a */
    void mo6743a(float f, boolean z);

    /* renamed from: a */
    void mo6742a(int i, int i2);

    float getMaximumScale();

    float getMediumScale();

    float getMinimumScale();

    AbstractC3867d getOnPhotoTapListener();

    AbstractC3870g getOnViewTapListener();

    float getScale();

    void setAllowParentInterceptOnEdge(boolean z);

    void setMaximumScale(float f);

    void setMediumScale(float f);

    void setMinimumScale(float f);

    void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener);

    void setOnLongClickListener(View.OnLongClickListener onLongClickListener);

    void setOnPhotoTapListener(AbstractC3867d abstractC3867d);

    void setOnScaleChangeListener(AbstractC3868e abstractC3868e);

    void setOnViewTapListener(AbstractC3870g abstractC3870g);

    void setScale(float f);

    void setZoomTransitionDuration(long j);
}
