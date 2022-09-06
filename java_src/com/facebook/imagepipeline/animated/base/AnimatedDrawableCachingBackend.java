package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;
/* loaded from: classes.dex */
public interface AnimatedDrawableCachingBackend extends AnimatedDrawableBackend {
    void appendDebugOptionString(StringBuilder sb);

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    /* renamed from: forNewBounds */
    AnimatedDrawableCachingBackend mo21774forNewBounds(Rect rect);

    CloseableReference<Bitmap> getBitmapForFrame(int i);

    CloseableReference<Bitmap> getPreviewBitmap();
}
