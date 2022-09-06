package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.MonotonicClock;
import com.facebook.drawable.base.DrawableWithCaches;
import com.p113c.p114a.C1819q;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class AnimatedDrawable extends Drawable implements DrawableWithCaches, AnimatableDrawable {
    private static final int NO_FRAME = -1;
    private static final int POLL_FOR_RENDERED_FRAME_MS = 5;
    private static final Class<?> TAG = AnimatedDrawable.class;
    private static final long WATCH_DOG_TIMER_MIN_TIMEOUT_MS = 1000;
    private static final long WATCH_DOG_TIMER_POLL_INTERVAL_MS = 2000;
    private AnimatedDrawableCachingBackend mAnimatedDrawableBackend;
    private final AnimatedDrawableDiagnostics mAnimatedDrawableDiagnostics;
    private boolean mApplyTransformation;
    private final int mDurationMs;
    private final int mFrameCount;
    private boolean mHaveWatchdogScheduled;
    private boolean mInvalidateTaskScheduled;
    private boolean mIsRunning;
    private CloseableReference<Bitmap> mLastDrawnFrame;
    private volatile String mLogId;
    private final MonotonicClock mMonotonicClock;
    private int mPendingRenderedFrameMonotonicNumber;
    private int mPendingRenderedFrameNumber;
    private final ScheduledExecutorService mScheduledExecutorServiceForUiThread;
    private int mScheduledFrameMonotonicNumber;
    private int mScheduledFrameNumber;
    private long mStartTimeMs;
    private final int mTotalLoops;
    private boolean mWaitingForDraw;
    private final Paint mPaint = new Paint(6);
    private final Rect mDstRect = new Rect();
    private int mLastDrawnFrameNumber = -1;
    private int mLastDrawnFrameMonotonicNumber = -1;
    private long mLastInvalidateTimeMs = -1;
    private float mSx = 1.0f;
    private float mSy = 1.0f;
    private long mNextFrameTaskMs = -1;
    private final Runnable mStartTask = new Runnable() { // from class: com.facebook.imagepipeline.animated.base.AnimatedDrawable.1
        @Override // java.lang.Runnable
        public void run() {
            AnimatedDrawable.this.onStart();
        }
    };
    private final Runnable mNextFrameTask = new Runnable() { // from class: com.facebook.imagepipeline.animated.base.AnimatedDrawable.2
        @Override // java.lang.Runnable
        public void run() {
            FLog.m13782v(AnimatedDrawable.TAG, "(%s) Next Frame Task", AnimatedDrawable.this.mLogId);
            AnimatedDrawable.this.onNextFrame();
        }
    };
    private final Runnable mInvalidateTask = new Runnable() { // from class: com.facebook.imagepipeline.animated.base.AnimatedDrawable.3
        @Override // java.lang.Runnable
        public void run() {
            FLog.m13782v(AnimatedDrawable.TAG, "(%s) Invalidate Task", AnimatedDrawable.this.mLogId);
            AnimatedDrawable.this.mInvalidateTaskScheduled = false;
            AnimatedDrawable.this.doInvalidateSelf();
        }
    };
    private final Runnable mWatchdogTask = new Runnable() { // from class: com.facebook.imagepipeline.animated.base.AnimatedDrawable.4
        @Override // java.lang.Runnable
        public void run() {
            FLog.m13782v(AnimatedDrawable.TAG, "(%s) Watchdog Task", AnimatedDrawable.this.mLogId);
            AnimatedDrawable.this.doWatchdogCheck();
        }
    };
    private final Paint mTransparentPaint = new Paint();

    public AnimatedDrawable(ScheduledExecutorService scheduledExecutorService, AnimatedDrawableCachingBackend animatedDrawableCachingBackend, AnimatedDrawableDiagnostics animatedDrawableDiagnostics, MonotonicClock monotonicClock) {
        this.mScheduledExecutorServiceForUiThread = scheduledExecutorService;
        this.mAnimatedDrawableBackend = animatedDrawableCachingBackend;
        this.mAnimatedDrawableDiagnostics = animatedDrawableDiagnostics;
        this.mMonotonicClock = monotonicClock;
        this.mDurationMs = this.mAnimatedDrawableBackend.getDurationMs();
        this.mFrameCount = this.mAnimatedDrawableBackend.getFrameCount();
        this.mAnimatedDrawableDiagnostics.setBackend(this.mAnimatedDrawableBackend);
        this.mTotalLoops = this.mAnimatedDrawableBackend.getLoopCount();
        this.mTransparentPaint.setColor(0);
        this.mTransparentPaint.setStyle(Paint.Style.FILL);
        resetToPreviewFrame();
    }

    private void computeAndScheduleNextFrame(boolean z) {
        if (this.mDurationMs == 0) {
            return;
        }
        long now = this.mMonotonicClock.now();
        int i = (int) ((now - this.mStartTimeMs) / this.mDurationMs);
        if (this.mTotalLoops > 0 && i >= this.mTotalLoops) {
            return;
        }
        int i2 = (int) ((now - this.mStartTimeMs) % this.mDurationMs);
        int frameForTimestampMs = this.mAnimatedDrawableBackend.getFrameForTimestampMs(i2);
        boolean z2 = this.mScheduledFrameNumber != frameForTimestampMs;
        this.mScheduledFrameNumber = frameForTimestampMs;
        this.mScheduledFrameMonotonicNumber = (i * this.mFrameCount) + frameForTimestampMs;
        if (!z) {
            return;
        }
        if (z2) {
            doInvalidateSelf();
            return;
        }
        int timestampMsForFrame = (this.mAnimatedDrawableBackend.getTimestampMsForFrame(this.mScheduledFrameNumber) + this.mAnimatedDrawableBackend.getDurationMsForFrame(this.mScheduledFrameNumber)) - i2;
        int i3 = (this.mScheduledFrameNumber + 1) % this.mFrameCount;
        long j = now + timestampMsForFrame;
        if (this.mNextFrameTaskMs != -1 && this.mNextFrameTaskMs <= j) {
            return;
        }
        FLog.m13780v(TAG, "(%s) Next frame (%d) in %d ms", this.mLogId, Integer.valueOf(i3), Integer.valueOf(timestampMsForFrame));
        unscheduleSelf(this.mNextFrameTask);
        scheduleSelf(this.mNextFrameTask, j);
        this.mNextFrameTaskMs = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doInvalidateSelf() {
        this.mWaitingForDraw = true;
        this.mLastInvalidateTimeMs = this.mMonotonicClock.now();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doWatchdogCheck() {
        boolean z = false;
        this.mHaveWatchdogScheduled = false;
        if (!this.mIsRunning) {
            return;
        }
        long now = this.mMonotonicClock.now();
        boolean z2 = this.mWaitingForDraw && now - this.mLastInvalidateTimeMs > 1000;
        if (this.mNextFrameTaskMs != -1 && now - this.mNextFrameTaskMs > 1000) {
            z = true;
        }
        if (z2 || z) {
            dropCaches();
            doInvalidateSelf();
            return;
        }
        this.mScheduledExecutorServiceForUiThread.schedule(this.mWatchdogTask, WATCH_DOG_TIMER_POLL_INTERVAL_MS, TimeUnit.MILLISECONDS);
        this.mHaveWatchdogScheduled = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNextFrame() {
        this.mNextFrameTaskMs = -1L;
        if (this.mIsRunning && this.mDurationMs != 0) {
            this.mAnimatedDrawableDiagnostics.onNextFrameMethodBegin();
            try {
                computeAndScheduleNextFrame(true);
            } finally {
                this.mAnimatedDrawableDiagnostics.onNextFrameMethodEnd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStart() {
        if (!this.mIsRunning) {
            return;
        }
        this.mAnimatedDrawableDiagnostics.onStartMethodBegin();
        try {
            this.mStartTimeMs = this.mMonotonicClock.now();
            this.mScheduledFrameNumber = 0;
            this.mScheduledFrameMonotonicNumber = 0;
            long durationMsForFrame = this.mStartTimeMs + this.mAnimatedDrawableBackend.getDurationMsForFrame(0);
            scheduleSelf(this.mNextFrameTask, durationMsForFrame);
            this.mNextFrameTaskMs = durationMsForFrame;
            doInvalidateSelf();
        } finally {
            this.mAnimatedDrawableDiagnostics.onStartMethodEnd();
        }
    }

    private boolean renderFrame(Canvas canvas, int i, int i2) {
        CloseableReference<Bitmap> bitmapForFrame = this.mAnimatedDrawableBackend.getBitmapForFrame(i);
        if (bitmapForFrame != null) {
            canvas.drawBitmap(bitmapForFrame.get(), 0.0f, 0.0f, this.mPaint);
            if (this.mLastDrawnFrame != null) {
                this.mLastDrawnFrame.close();
            }
            if (this.mIsRunning && i2 > this.mLastDrawnFrameMonotonicNumber) {
                int i3 = (i2 - this.mLastDrawnFrameMonotonicNumber) - 1;
                this.mAnimatedDrawableDiagnostics.incrementDrawnFrames(1);
                this.mAnimatedDrawableDiagnostics.incrementDroppedFrames(i3);
                if (i3 > 0) {
                    FLog.m13781v(TAG, "(%s) Dropped %d frames", this.mLogId, Integer.valueOf(i3));
                }
            }
            this.mLastDrawnFrame = bitmapForFrame;
            this.mLastDrawnFrameNumber = i;
            this.mLastDrawnFrameMonotonicNumber = i2;
            FLog.m13781v(TAG, "(%s) Drew frame %d", this.mLogId, Integer.valueOf(i));
            return true;
        }
        return false;
    }

    private void resetToPreviewFrame() {
        this.mScheduledFrameNumber = this.mAnimatedDrawableBackend.getFrameForPreview();
        this.mScheduledFrameMonotonicNumber = this.mScheduledFrameNumber;
        this.mPendingRenderedFrameNumber = -1;
        this.mPendingRenderedFrameMonotonicNumber = -1;
    }

    private void scheduleInvalidatePoll() {
        if (this.mInvalidateTaskScheduled) {
            return;
        }
        this.mInvalidateTaskScheduled = true;
        scheduleSelf(this.mInvalidateTask, 5L);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatableDrawable
    public C1819q.AbstractC1826b createAnimatorUpdateListener() {
        return new C1819q.AbstractC1826b() { // from class: com.facebook.imagepipeline.animated.base.AnimatedDrawable.5
            @Override // com.p113c.p114a.C1819q.AbstractC1826b
            public void onAnimationUpdate(C1819q c1819q) {
                AnimatedDrawable.this.setLevel(((Integer) c1819q.m14477u()).intValue());
            }
        };
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatableDrawable
    public C1819q createValueAnimator() {
        int loopCount = this.mAnimatedDrawableBackend.getLoopCount();
        C1819q c1819q = new C1819q();
        c1819q.mo14508a(0, this.mDurationMs);
        c1819q.mo14503b(this.mDurationMs);
        if (loopCount == 0) {
            loopCount = -1;
        }
        c1819q.m14519a(loopCount);
        c1819q.m14504b(1);
        c1819q.mo14517a((Interpolator) new LinearInterpolator());
        c1819q.m14514a(createAnimatorUpdateListener());
        return c1819q;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatableDrawable
    public C1819q createValueAnimator(int i) {
        C1819q createValueAnimator = createValueAnimator();
        createValueAnimator.m14519a(Math.max(i / this.mAnimatedDrawableBackend.getDurationMs(), 1));
        return createValueAnimator;
    }

    public boolean didLastDrawRender() {
        return this.mLastDrawnFrame != null;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        CloseableReference<Bitmap> previewBitmap;
        boolean z = false;
        this.mAnimatedDrawableDiagnostics.onDrawMethodBegin();
        try {
            this.mWaitingForDraw = false;
            if (this.mIsRunning && !this.mHaveWatchdogScheduled) {
                this.mScheduledExecutorServiceForUiThread.schedule(this.mWatchdogTask, WATCH_DOG_TIMER_POLL_INTERVAL_MS, TimeUnit.MILLISECONDS);
                this.mHaveWatchdogScheduled = true;
            }
            if (this.mApplyTransformation) {
                this.mDstRect.set(getBounds());
                if (!this.mDstRect.isEmpty()) {
                    AnimatedDrawableCachingBackend mo21774forNewBounds = this.mAnimatedDrawableBackend.mo21774forNewBounds(this.mDstRect);
                    if (mo21774forNewBounds != this.mAnimatedDrawableBackend) {
                        this.mAnimatedDrawableBackend.dropCaches();
                        this.mAnimatedDrawableBackend = mo21774forNewBounds;
                        this.mAnimatedDrawableDiagnostics.setBackend(mo21774forNewBounds);
                    }
                    this.mSx = this.mDstRect.width() / this.mAnimatedDrawableBackend.getRenderedWidth();
                    this.mSy = this.mDstRect.height() / this.mAnimatedDrawableBackend.getRenderedHeight();
                    this.mApplyTransformation = false;
                }
            }
            if (this.mDstRect.isEmpty()) {
                return;
            }
            canvas.save();
            canvas.scale(this.mSx, this.mSy);
            if (this.mPendingRenderedFrameNumber != -1) {
                boolean renderFrame = renderFrame(canvas, this.mPendingRenderedFrameNumber, this.mPendingRenderedFrameMonotonicNumber);
                z = false | renderFrame;
                if (renderFrame) {
                    FLog.m13781v(TAG, "(%s) Rendered pending frame %d", this.mLogId, Integer.valueOf(this.mPendingRenderedFrameNumber));
                    this.mPendingRenderedFrameNumber = -1;
                    this.mPendingRenderedFrameMonotonicNumber = -1;
                } else {
                    FLog.m13781v(TAG, "(%s) Trying again later for pending %d", this.mLogId, Integer.valueOf(this.mPendingRenderedFrameNumber));
                    scheduleInvalidatePoll();
                }
            }
            if (this.mPendingRenderedFrameNumber == -1) {
                if (this.mIsRunning) {
                    computeAndScheduleNextFrame(false);
                }
                boolean renderFrame2 = renderFrame(canvas, this.mScheduledFrameNumber, this.mScheduledFrameMonotonicNumber);
                z |= renderFrame2;
                if (renderFrame2) {
                    FLog.m13781v(TAG, "(%s) Rendered current frame %d", this.mLogId, Integer.valueOf(this.mScheduledFrameNumber));
                    if (this.mIsRunning) {
                        computeAndScheduleNextFrame(true);
                    }
                } else {
                    FLog.m13781v(TAG, "(%s) Trying again later for current %d", this.mLogId, Integer.valueOf(this.mScheduledFrameNumber));
                    this.mPendingRenderedFrameNumber = this.mScheduledFrameNumber;
                    this.mPendingRenderedFrameMonotonicNumber = this.mScheduledFrameMonotonicNumber;
                    scheduleInvalidatePoll();
                }
            }
            if (!z && this.mLastDrawnFrame != null) {
                canvas.drawBitmap(this.mLastDrawnFrame.get(), 0.0f, 0.0f, this.mPaint);
                FLog.m13781v(TAG, "(%s) Rendered last known frame %d", this.mLogId, Integer.valueOf(this.mLastDrawnFrameNumber));
                z = true;
            }
            if (!z && (previewBitmap = this.mAnimatedDrawableBackend.getPreviewBitmap()) != null) {
                canvas.drawBitmap(previewBitmap.get(), 0.0f, 0.0f, this.mPaint);
                previewBitmap.close();
                FLog.m13782v(TAG, "(%s) Rendered preview frame", this.mLogId);
                z = true;
            }
            if (!z) {
                canvas.drawRect(0.0f, 0.0f, this.mDstRect.width(), this.mDstRect.height(), this.mTransparentPaint);
                FLog.m13782v(TAG, "(%s) Failed to draw a frame", this.mLogId);
            }
            canvas.restore();
            this.mAnimatedDrawableDiagnostics.drawDebugOverlay(canvas, this.mDstRect);
        } finally {
            this.mAnimatedDrawableDiagnostics.onDrawMethodEnd();
        }
    }

    @Override // com.facebook.drawable.base.DrawableWithCaches
    public void dropCaches() {
        FLog.m13782v(TAG, "(%s) Dropping caches", this.mLogId);
        if (this.mLastDrawnFrame != null) {
            this.mLastDrawnFrame.close();
            this.mLastDrawnFrame = null;
            this.mLastDrawnFrameNumber = -1;
            this.mLastDrawnFrameMonotonicNumber = -1;
        }
        this.mAnimatedDrawableBackend.dropCaches();
    }

    protected void finalize() {
        super.finalize();
        if (this.mLastDrawnFrame != null) {
            this.mLastDrawnFrame.close();
            this.mLastDrawnFrame = null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mAnimatedDrawableBackend.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mAnimatedDrawableBackend.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @VisibleForTesting
    int getScheduledFrameNumber() {
        return this.mScheduledFrameNumber;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @VisibleForTesting
    boolean isWaitingForDraw() {
        return this.mWaitingForDraw;
    }

    @VisibleForTesting
    boolean isWaitingForNextFrame() {
        return this.mNextFrameTaskMs != -1;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mApplyTransformation = true;
        if (this.mLastDrawnFrame != null) {
            this.mLastDrawnFrame.close();
            this.mLastDrawnFrame = null;
        }
        this.mLastDrawnFrameNumber = -1;
        this.mLastDrawnFrameMonotonicNumber = -1;
        this.mAnimatedDrawableBackend.dropCaches();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        int frameForTimestampMs;
        if (!this.mIsRunning && (frameForTimestampMs = this.mAnimatedDrawableBackend.getFrameForTimestampMs(i)) != this.mScheduledFrameNumber) {
            try {
                this.mScheduledFrameNumber = frameForTimestampMs;
                this.mScheduledFrameMonotonicNumber = frameForTimestampMs;
                doInvalidateSelf();
                return true;
            } catch (IllegalStateException e) {
                return false;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
        doInvalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        doInvalidateSelf();
    }

    public void setLogId(String str) {
        this.mLogId = str;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.mDurationMs == 0 || this.mFrameCount <= 1) {
            return;
        }
        this.mIsRunning = true;
        scheduleSelf(this.mStartTask, this.mMonotonicClock.now());
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.mIsRunning = false;
    }
}
