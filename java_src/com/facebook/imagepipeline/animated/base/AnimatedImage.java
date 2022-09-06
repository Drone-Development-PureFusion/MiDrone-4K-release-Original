package com.facebook.imagepipeline.animated.base;
/* loaded from: classes.dex */
public interface AnimatedImage {
    void dispose();

    boolean doesRenderSupportScaling();

    int getDuration();

    /* renamed from: getFrame */
    AnimatedImageFrame mo21806getFrame(int i);

    int getFrameCount();

    int[] getFrameDurations();

    AnimatedDrawableFrameInfo getFrameInfo(int i);

    int getHeight();

    int getLoopCount();

    int getSizeInBytes();

    int getWidth();
}
