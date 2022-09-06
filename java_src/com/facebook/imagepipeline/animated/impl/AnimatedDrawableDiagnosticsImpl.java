package com.facebook.imagepipeline.animated.impl;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
/* loaded from: classes.dex */
public class AnimatedDrawableDiagnosticsImpl implements AnimatedDrawableDiagnostics {
    private static final Class<?> TAG = AnimatedDrawableDiagnostics.class;
    private AnimatedDrawableCachingBackend mAnimatedDrawableBackend;
    private final AnimatedDrawableUtil mAnimatedDrawableUtil;
    private final DisplayMetrics mDisplayMetrics;
    private long mLastTimeStamp;
    private final RollingStat mDroppedFramesStat = new RollingStat();
    private final RollingStat mDrawnFrames = new RollingStat();
    private final StringBuilder sbTemp = new StringBuilder();
    private final TextPaint mDebugTextPaint = new TextPaint();

    public AnimatedDrawableDiagnosticsImpl(AnimatedDrawableUtil animatedDrawableUtil, DisplayMetrics displayMetrics) {
        this.mAnimatedDrawableUtil = animatedDrawableUtil;
        this.mDisplayMetrics = displayMetrics;
        this.mDebugTextPaint.setColor(-16776961);
        this.mDebugTextPaint.setTextSize(convertDpToPx(14));
    }

    private int convertDpToPx(int i) {
        return (int) TypedValue.applyDimension(1, i, this.mDisplayMetrics);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics
    public void drawDebugOverlay(Canvas canvas, Rect rect) {
        int i;
        int i2;
        int sum = this.mDroppedFramesStat.getSum(10);
        int sum2 = this.mDrawnFrames.getSum(10);
        int i3 = sum + sum2;
        int convertDpToPx = convertDpToPx(10);
        int convertDpToPx2 = convertDpToPx(20);
        int convertDpToPx3 = convertDpToPx(5);
        if (i3 > 0) {
            this.sbTemp.setLength(0);
            this.sbTemp.append((sum2 * 100) / i3);
            this.sbTemp.append("%");
            canvas.drawText(this.sbTemp, 0, this.sbTemp.length(), convertDpToPx, convertDpToPx2, this.mDebugTextPaint);
            i = ((int) (convertDpToPx + this.mDebugTextPaint.measureText(this.sbTemp, 0, this.sbTemp.length()))) + convertDpToPx3;
        } else {
            i = convertDpToPx;
        }
        int memoryUsage = this.mAnimatedDrawableBackend.getMemoryUsage();
        this.sbTemp.setLength(0);
        this.mAnimatedDrawableUtil.appendMemoryString(this.sbTemp, memoryUsage);
        float measureText = this.mDebugTextPaint.measureText(this.sbTemp, 0, this.sbTemp.length());
        if (i + measureText > rect.width()) {
            convertDpToPx2 = (int) (convertDpToPx2 + this.mDebugTextPaint.getTextSize() + convertDpToPx3);
            i2 = convertDpToPx;
        } else {
            i2 = i;
        }
        canvas.drawText(this.sbTemp, 0, this.sbTemp.length(), i2, convertDpToPx2, this.mDebugTextPaint);
        int i4 = ((int) (i2 + measureText)) + convertDpToPx3;
        this.sbTemp.setLength(0);
        this.mAnimatedDrawableBackend.appendDebugOptionString(this.sbTemp);
        if (this.mDebugTextPaint.measureText(this.sbTemp, 0, this.sbTemp.length()) + i4 > rect.width()) {
            convertDpToPx2 = (int) (convertDpToPx2 + this.mDebugTextPaint.getTextSize() + convertDpToPx3);
        } else {
            convertDpToPx = i4;
        }
        canvas.drawText(this.sbTemp, 0, this.sbTemp.length(), convertDpToPx, convertDpToPx2, this.mDebugTextPaint);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics
    public void incrementDrawnFrames(int i) {
        this.mDrawnFrames.incrementStats(i);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics
    public void incrementDroppedFrames(int i) {
        this.mDroppedFramesStat.incrementStats(i);
        if (i > 0) {
            FLog.m13782v(TAG, "Dropped %d frames", Integer.valueOf(i));
        }
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics
    public void onDrawMethodBegin() {
        this.mLastTimeStamp = SystemClock.elapsedRealtime();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics
    public void onDrawMethodEnd() {
        FLog.m13782v(TAG, "draw took %d", Long.valueOf(SystemClock.elapsedRealtime() - this.mLastTimeStamp));
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics
    public void onNextFrameMethodBegin() {
        this.mLastTimeStamp = SystemClock.elapsedRealtime();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics
    public void onNextFrameMethodEnd() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.mLastTimeStamp;
        if (elapsedRealtime > 3) {
            FLog.m13782v(TAG, "onNextFrame took %d", Long.valueOf(elapsedRealtime));
        }
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics
    public void onStartMethodBegin() {
        this.mLastTimeStamp = SystemClock.elapsedRealtime();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics
    public void onStartMethodEnd() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.mLastTimeStamp;
        if (elapsedRealtime > 3) {
            FLog.m13782v(TAG, "onStart took %d", Long.valueOf(elapsedRealtime));
        }
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics
    public void setBackend(AnimatedDrawableCachingBackend animatedDrawableCachingBackend) {
        this.mAnimatedDrawableBackend = animatedDrawableCachingBackend;
    }
}
