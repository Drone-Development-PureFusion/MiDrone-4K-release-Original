package com.facebook.imagepipeline.animated.impl;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.support.p001v4.util.SparseArrayCompat;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.time.MonotonicClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions;
import com.facebook.imagepipeline.animated.base.DelegatingAnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
import p000a.AbstractC0016j;
import p000a.C0018l;
/* loaded from: classes.dex */
public class AnimatedDrawableCachingBackendImpl extends DelegatingAnimatedDrawableBackend implements AnimatedDrawableCachingBackend {
    private static final int PREFETCH_FRAMES = 3;
    private static final Class<?> TAG = AnimatedDrawableCachingBackendImpl.class;
    private static final AtomicInteger sTotalBitmaps = new AtomicInteger();
    private final ActivityManager mActivityManager;
    private final AnimatedDrawableBackend mAnimatedDrawableBackend;
    private final AnimatedDrawableOptions mAnimatedDrawableOptions;
    private final AnimatedDrawableUtil mAnimatedDrawableUtil;
    private final AnimatedImageCompositor mAnimatedImageCompositor;
    private final double mApproxKiloBytesToHoldAllFrames;
    @GuardedBy("this")
    private final WhatToKeepCachedArray mBitmapsToKeepCached;
    @GuardedBy("this")
    private final SparseArrayCompat<CloseableReference<Bitmap>> mCachedBitmaps;
    @GuardedBy("ui-thread")
    private int mCurrentFrameIndex;
    @GuardedBy("this")
    private final SparseArrayCompat<C0018l<Object>> mDecodesInFlight;
    private final SerialExecutorService mExecutorService;
    @GuardedBy("this")
    private final List<Bitmap> mFreeBitmaps;
    private final double mMaximumKiloBytes;
    private final MonotonicClock mMonotonicClock;
    private final ResourceReleaser<Bitmap> mResourceReleaserForBitmaps;

    public AnimatedDrawableCachingBackendImpl(SerialExecutorService serialExecutorService, ActivityManager activityManager, AnimatedDrawableUtil animatedDrawableUtil, MonotonicClock monotonicClock, AnimatedDrawableBackend animatedDrawableBackend, AnimatedDrawableOptions animatedDrawableOptions) {
        super(animatedDrawableBackend);
        this.mExecutorService = serialExecutorService;
        this.mActivityManager = activityManager;
        this.mAnimatedDrawableUtil = animatedDrawableUtil;
        this.mMonotonicClock = monotonicClock;
        this.mAnimatedDrawableBackend = animatedDrawableBackend;
        this.mAnimatedDrawableOptions = animatedDrawableOptions;
        this.mMaximumKiloBytes = animatedDrawableOptions.maximumBytes >= 0 ? animatedDrawableOptions.maximumBytes / 1024 : getDefaultMaxBytes(activityManager) / 1024;
        this.mAnimatedImageCompositor = new AnimatedImageCompositor(animatedDrawableBackend, new AnimatedImageCompositor.Callback() { // from class: com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImpl.1
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public CloseableReference<Bitmap> getCachedBitmap(int i) {
                return AnimatedDrawableCachingBackendImpl.this.getCachedOrPredecodedFrame(i);
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public void onIntermediateResult(int i, Bitmap bitmap) {
                AnimatedDrawableCachingBackendImpl.this.maybeCacheBitmapDuringRender(i, bitmap);
            }
        });
        this.mResourceReleaserForBitmaps = new ResourceReleaser<Bitmap>() { // from class: com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImpl.2
            @Override // com.facebook.common.references.ResourceReleaser
            public void release(Bitmap bitmap) {
                AnimatedDrawableCachingBackendImpl.this.releaseBitmapInternal(bitmap);
            }
        };
        this.mFreeBitmaps = new ArrayList();
        this.mDecodesInFlight = new SparseArrayCompat<>(10);
        this.mCachedBitmaps = new SparseArrayCompat<>(10);
        this.mBitmapsToKeepCached = new WhatToKeepCachedArray(this.mAnimatedDrawableBackend.getFrameCount());
        this.mApproxKiloBytesToHoldAllFrames = ((this.mAnimatedDrawableBackend.getRenderedWidth() * this.mAnimatedDrawableBackend.getRenderedHeight()) / 1024) * this.mAnimatedDrawableBackend.getFrameCount() * 4;
    }

    private synchronized void cancelFuturesOutsideOfRange(int i, int i2) {
        int i3;
        int i4 = 0;
        while (i4 < this.mDecodesInFlight.size()) {
            if (AnimatedDrawableUtil.isOutsideRange(i, i2, this.mDecodesInFlight.keyAt(i4))) {
                this.mDecodesInFlight.valueAt(i4);
                this.mDecodesInFlight.removeAt(i4);
                i3 = i4;
            } else {
                i3 = i4 + 1;
            }
            i4 = i3;
        }
    }

    private void copyAndCacheBitmapDuringRendering(int i, Bitmap bitmap) {
        CloseableReference<Bitmap> obtainBitmapInternal = obtainBitmapInternal();
        try {
            Canvas canvas = new Canvas(obtainBitmapInternal.get());
            canvas.drawColor(0, PorterDuff.Mode.SRC);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            maybeCacheRenderedBitmap(i, obtainBitmapInternal);
        } finally {
            obtainBitmapInternal.close();
        }
    }

    private Bitmap createNewBitmap() {
        FLog.m13783v(TAG, "Creating new bitmap");
        sTotalBitmaps.incrementAndGet();
        FLog.m13782v(TAG, "Total bitmaps: %d", Integer.valueOf(sTotalBitmaps.get()));
        return Bitmap.createBitmap(this.mAnimatedDrawableBackend.getRenderedWidth(), this.mAnimatedDrawableBackend.getRenderedHeight(), Bitmap.Config.ARGB_8888);
    }

    private synchronized void doPrefetch(int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            final int frameCount = (i + i3) % this.mAnimatedDrawableBackend.getFrameCount();
            boolean hasCachedOrPredecodedFrame = hasCachedOrPredecodedFrame(frameCount);
            C0018l<Object> c0018l = this.mDecodesInFlight.get(frameCount);
            if (!hasCachedOrPredecodedFrame && c0018l == null) {
                final C0018l<Object> m21607a = C0018l.m21607a(new Callable<Object>() { // from class: com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImpl.3
                    @Override // java.util.concurrent.Callable
                    public Object call() {
                        AnimatedDrawableCachingBackendImpl.this.runPrefetch(frameCount);
                        return null;
                    }
                }, this.mExecutorService);
                this.mDecodesInFlight.put(frameCount, m21607a);
                m21607a.m21620a((AbstractC0016j<Object, TContinuationResult>) new AbstractC0016j<Object, Object>() { // from class: com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImpl.4
                    @Override // p000a.AbstractC0016j
                    /* renamed from: then */
                    public Object mo21799then(C0018l<Object> c0018l2) {
                        AnimatedDrawableCachingBackendImpl.this.onFutureFinished(m21607a, frameCount);
                        return null;
                    }
                });
            }
        }
    }

    private synchronized void dropBitmapsThatShouldNotBeCached() {
        int i;
        int i2 = 0;
        while (i2 < this.mCachedBitmaps.size()) {
            if (!this.mBitmapsToKeepCached.get(this.mCachedBitmaps.keyAt(i2))) {
                this.mCachedBitmaps.removeAt(i2);
                this.mCachedBitmaps.valueAt(i2).close();
                i = i2;
            } else {
                i = i2 + 1;
            }
            i2 = i;
        }
    }

    private CloseableReference<Bitmap> getBitmapForFrameInternal(int i, boolean z) {
        Throwable th;
        boolean z2;
        long now = this.mMonotonicClock.now();
        try {
            synchronized (this) {
                this.mBitmapsToKeepCached.set(i, true);
                CloseableReference<Bitmap> cachedOrPredecodedFrame = getCachedOrPredecodedFrame(i);
                if (cachedOrPredecodedFrame != null) {
                    long now2 = this.mMonotonicClock.now() - now;
                    if (now2 > 10) {
                        FLog.m13780v(TAG, "obtainBitmap for frame %d took %d ms (%s)", Integer.valueOf(i), Long.valueOf(now2), "ok");
                    }
                    return cachedOrPredecodedFrame;
                } else if (!z) {
                    long now3 = this.mMonotonicClock.now() - now;
                    if (now3 > 10) {
                        FLog.m13780v(TAG, "obtainBitmap for frame %d took %d ms (%s)", Integer.valueOf(i), Long.valueOf(now3), "deferred");
                    }
                    return null;
                } else {
                    try {
                        CloseableReference<Bitmap> obtainBitmapInternal = obtainBitmapInternal();
                        this.mAnimatedImageCompositor.renderFrame(i, obtainBitmapInternal.get());
                        maybeCacheRenderedBitmap(i, obtainBitmapInternal);
                        CloseableReference<Bitmap> m21761clone = obtainBitmapInternal.m21761clone();
                        obtainBitmapInternal.close();
                        long now4 = this.mMonotonicClock.now() - now;
                        if (now4 > 10) {
                            FLog.m13780v(TAG, "obtainBitmap for frame %d took %d ms (%s)", Integer.valueOf(i), Long.valueOf(now4), "renderedOnCallingThread");
                        }
                        return m21761clone;
                    } catch (Throwable th2) {
                        th = th2;
                        z2 = true;
                        long now5 = this.mMonotonicClock.now() - now;
                        if (now5 > 10) {
                            FLog.m13780v(TAG, "obtainBitmap for frame %d took %d ms (%s)", Integer.valueOf(i), Long.valueOf(now5), z2 ? "renderedOnCallingThread" : "ok");
                        }
                        throw th;
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z2 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized CloseableReference<Bitmap> getCachedOrPredecodedFrame(int i) {
        CloseableReference<Bitmap> cloneOrNull;
        cloneOrNull = CloseableReference.cloneOrNull(this.mCachedBitmaps.get(i));
        if (cloneOrNull == null) {
            cloneOrNull = this.mAnimatedDrawableBackend.getPreDecodedFrame(i);
        }
        return cloneOrNull;
    }

    private static int getDefaultMaxBytes(ActivityManager activityManager) {
        return activityManager.getMemoryClass() > 32 ? 5242880 : 3145728;
    }

    private synchronized boolean hasCachedOrPredecodedFrame(int i) {
        boolean z;
        if (this.mCachedBitmaps.get(i) == null) {
            if (!this.mAnimatedDrawableBackend.hasPreDecodedFrame(i)) {
                z = false;
            }
        }
        z = true;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeCacheBitmapDuringRender(int i, Bitmap bitmap) {
        boolean z = false;
        synchronized (this) {
            if (this.mBitmapsToKeepCached.get(i) && this.mCachedBitmaps.get(i) == null) {
                z = true;
            }
        }
        if (z) {
            copyAndCacheBitmapDuringRendering(i, bitmap);
        }
    }

    private synchronized void maybeCacheRenderedBitmap(int i, CloseableReference<Bitmap> closeableReference) {
        if (this.mBitmapsToKeepCached.get(i)) {
            int indexOfKey = this.mCachedBitmaps.indexOfKey(i);
            if (indexOfKey >= 0) {
                this.mCachedBitmaps.valueAt(indexOfKey).close();
                this.mCachedBitmaps.removeAt(indexOfKey);
            }
            this.mCachedBitmaps.put(i, closeableReference.m21761clone());
        }
    }

    private CloseableReference<Bitmap> obtainBitmapInternal() {
        Bitmap createNewBitmap;
        synchronized (this) {
            long nanoTime = System.nanoTime();
            long convert = TimeUnit.NANOSECONDS.convert(20L, TimeUnit.MILLISECONDS) + nanoTime;
            while (this.mFreeBitmaps.isEmpty() && nanoTime < convert) {
                try {
                    TimeUnit.NANOSECONDS.timedWait(this, convert - nanoTime);
                    nanoTime = System.nanoTime();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            createNewBitmap = this.mFreeBitmaps.isEmpty() ? createNewBitmap() : this.mFreeBitmaps.remove(this.mFreeBitmaps.size() - 1);
        }
        return CloseableReference.m13748of(createNewBitmap, this.mResourceReleaserForBitmaps);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onFutureFinished(C0018l<?> c0018l, int i) {
        int indexOfKey = this.mDecodesInFlight.indexOfKey(i);
        if (indexOfKey >= 0 && this.mDecodesInFlight.valueAt(indexOfKey) == c0018l) {
            this.mDecodesInFlight.removeAt(indexOfKey);
            if (c0018l.m21589f() != null) {
                FLog.m13776v(TAG, c0018l.m21589f(), "Failed to render frame %d", Integer.valueOf(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runPrefetch(int i) {
        synchronized (this) {
            if (!this.mBitmapsToKeepCached.get(i)) {
                return;
            }
            if (hasCachedOrPredecodedFrame(i)) {
                return;
            }
            CloseableReference<Bitmap> preDecodedFrame = this.mAnimatedDrawableBackend.getPreDecodedFrame(i);
            try {
                if (preDecodedFrame != null) {
                    maybeCacheRenderedBitmap(i, preDecodedFrame);
                } else {
                    CloseableReference<Bitmap> obtainBitmapInternal = obtainBitmapInternal();
                    this.mAnimatedImageCompositor.renderFrame(i, obtainBitmapInternal.get());
                    maybeCacheRenderedBitmap(i, obtainBitmapInternal);
                    FLog.m13782v(TAG, "Prefetch rendered frame %d", Integer.valueOf(i));
                    obtainBitmapInternal.close();
                }
            } finally {
                CloseableReference.closeSafely(preDecodedFrame);
            }
        }
    }

    private synchronized void schedulePrefetches() {
        int i = 1;
        synchronized (this) {
            boolean z = this.mAnimatedDrawableBackend.getFrameInfo(this.mCurrentFrameIndex).disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS;
            int max = Math.max(0, this.mCurrentFrameIndex - (z ? 1 : 0));
            int i2 = this.mAnimatedDrawableOptions.allowPrefetching ? 3 : 0;
            if (!z) {
                i = 0;
            }
            int max2 = Math.max(i2, i);
            int frameCount = (max + max2) % this.mAnimatedDrawableBackend.getFrameCount();
            cancelFuturesOutsideOfRange(max, frameCount);
            if (!shouldKeepAllFramesInMemory()) {
                this.mBitmapsToKeepCached.setAll(true);
                this.mBitmapsToKeepCached.removeOutsideRange(max, frameCount);
                int i3 = max;
                while (true) {
                    if (i3 < 0) {
                        break;
                    } else if (this.mCachedBitmaps.get(i3) != null) {
                        this.mBitmapsToKeepCached.set(i3, true);
                        break;
                    } else {
                        i3--;
                    }
                }
                dropBitmapsThatShouldNotBeCached();
            }
            if (this.mAnimatedDrawableOptions.allowPrefetching) {
                doPrefetch(max, max2);
            } else {
                cancelFuturesOutsideOfRange(this.mCurrentFrameIndex, this.mCurrentFrameIndex);
            }
        }
    }

    private boolean shouldKeepAllFramesInMemory() {
        return this.mAnimatedDrawableOptions.forceKeepAllFramesInMemory || this.mApproxKiloBytesToHoldAllFrames < this.mMaximumKiloBytes;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend
    public void appendDebugOptionString(StringBuilder sb) {
        if (this.mAnimatedDrawableOptions.forceKeepAllFramesInMemory) {
            sb.append("Pinned To Memory");
        } else {
            if (this.mApproxKiloBytesToHoldAllFrames < this.mMaximumKiloBytes) {
                sb.append("within ");
            } else {
                sb.append("exceeds ");
            }
            this.mAnimatedDrawableUtil.appendMemoryString(sb, (int) this.mMaximumKiloBytes);
        }
        if (!shouldKeepAllFramesInMemory() || !this.mAnimatedDrawableOptions.allowPrefetching) {
            return;
        }
        sb.append(" MT");
    }

    @Override // com.facebook.imagepipeline.animated.base.DelegatingAnimatedDrawableBackend, com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public synchronized void dropCaches() {
        this.mBitmapsToKeepCached.setAll(false);
        dropBitmapsThatShouldNotBeCached();
        for (Bitmap bitmap : this.mFreeBitmaps) {
            bitmap.recycle();
            sTotalBitmaps.decrementAndGet();
        }
        this.mFreeBitmaps.clear();
        this.mAnimatedDrawableBackend.dropCaches();
        FLog.m13782v(TAG, "Total bitmaps: %d", Integer.valueOf(sTotalBitmaps.get()));
    }

    protected synchronized void finalize() {
        super.finalize();
        if (this.mCachedBitmaps.size() > 0) {
            FLog.m13823d(TAG, "Finalizing with rendered bitmaps");
        }
        sTotalBitmaps.addAndGet(-this.mFreeBitmaps.size());
        this.mFreeBitmaps.clear();
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    /* renamed from: forNewBounds  reason: collision with other method in class */
    public AnimatedDrawableCachingBackend mo21774forNewBounds(Rect rect) {
        AnimatedDrawableBackend mo21774forNewBounds = this.mAnimatedDrawableBackend.mo21774forNewBounds(rect);
        return mo21774forNewBounds == this.mAnimatedDrawableBackend ? this : new AnimatedDrawableCachingBackendImpl(this.mExecutorService, this.mActivityManager, this.mAnimatedDrawableUtil, this.mMonotonicClock, mo21774forNewBounds, this.mAnimatedDrawableOptions);
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend
    public CloseableReference<Bitmap> getBitmapForFrame(int i) {
        this.mCurrentFrameIndex = i;
        CloseableReference<Bitmap> bitmapForFrameInternal = getBitmapForFrameInternal(i, false);
        schedulePrefetches();
        return bitmapForFrameInternal;
    }

    @VisibleForTesting
    CloseableReference<Bitmap> getBitmapForFrameBlocking(int i) {
        this.mCurrentFrameIndex = i;
        CloseableReference<Bitmap> bitmapForFrameInternal = getBitmapForFrameInternal(i, true);
        schedulePrefetches();
        return bitmapForFrameInternal;
    }

    @VisibleForTesting
    synchronized Map<Integer, C0018l<?>> getDecodesInFlight() {
        HashMap hashMap;
        hashMap = new HashMap();
        for (int i = 0; i < this.mDecodesInFlight.size(); i++) {
            hashMap.put(Integer.valueOf(this.mDecodesInFlight.keyAt(i)), this.mDecodesInFlight.valueAt(i));
        }
        return hashMap;
    }

    @VisibleForTesting
    synchronized Set<Integer> getFramesCached() {
        HashSet hashSet;
        hashSet = new HashSet();
        for (int i = 0; i < this.mCachedBitmaps.size(); i++) {
            hashSet.add(Integer.valueOf(this.mCachedBitmaps.keyAt(i)));
        }
        return hashSet;
    }

    @Override // com.facebook.imagepipeline.animated.base.DelegatingAnimatedDrawableBackend, com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public int getMemoryUsage() {
        int i;
        synchronized (this) {
            i = 0;
            for (Bitmap bitmap : this.mFreeBitmaps) {
                i += this.mAnimatedDrawableUtil.getSizeOfBitmap(bitmap);
            }
            for (int i2 = 0; i2 < this.mCachedBitmaps.size(); i2++) {
                i += this.mAnimatedDrawableUtil.getSizeOfBitmap(this.mCachedBitmaps.valueAt(i2).get());
            }
        }
        return this.mAnimatedDrawableBackend.getMemoryUsage() + i;
    }

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend
    public CloseableReference<Bitmap> getPreviewBitmap() {
        return getAnimatedImageResult().getPreviewBitmap();
    }

    synchronized void releaseBitmapInternal(Bitmap bitmap) {
        this.mFreeBitmaps.add(bitmap);
    }

    @Override // com.facebook.imagepipeline.animated.base.DelegatingAnimatedDrawableBackend, com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    public void renderFrame(int i, Canvas canvas) {
        throw new IllegalStateException();
    }
}
