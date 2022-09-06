package com.facebook.imagepipeline.animated.impl;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics;
/* loaded from: classes.dex */
public class AnimatedDrawableDiagnosticsNoop implements AnimatedDrawableDiagnostics {
    private static AnimatedDrawableDiagnosticsNoop sInstance = new AnimatedDrawableDiagnosticsNoop();

    public static AnimatedDrawableDiagnosticsNoop getInstance() {
        return sInstance;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics
    public void drawDebugOverlay(Canvas canvas, Rect rect) {
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics
    public void incrementDrawnFrames(int i) {
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics
    public void incrementDroppedFrames(int i) {
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics
    public void onDrawMethodBegin() {
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics
    public void onDrawMethodEnd() {
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics
    public void onNextFrameMethodBegin() {
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics
    public void onNextFrameMethodEnd() {
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics
    public void onStartMethodBegin() {
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics
    public void onStartMethodEnd() {
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics
    public void setBackend(AnimatedDrawableCachingBackend animatedDrawableCachingBackend) {
    }
}
