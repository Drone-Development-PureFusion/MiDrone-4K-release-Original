package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes.dex */
public class CloseableAnimatedBitmap extends CloseableBitmap {
    @GuardedBy("this")
    private List<CloseableReference<Bitmap>> mBitmapReferences;
    private volatile List<Bitmap> mBitmaps;
    private volatile List<Integer> mDurations;

    public CloseableAnimatedBitmap(List<CloseableReference<Bitmap>> list, List<Integer> list2) {
        boolean z = true;
        Preconditions.checkNotNull(list);
        Preconditions.checkState(list.size() >= 1, "Need at least 1 frame!");
        this.mBitmapReferences = new ArrayList();
        this.mBitmaps = new ArrayList();
        for (CloseableReference<Bitmap> closeableReference : list) {
            this.mBitmapReferences.add(closeableReference.m21761clone());
            this.mBitmaps.add(closeableReference.get());
        }
        this.mDurations = (List) Preconditions.checkNotNull(list2);
        Preconditions.checkState(this.mDurations.size() != this.mBitmaps.size() ? false : z, "Arrays length mismatch!");
    }

    public CloseableAnimatedBitmap(List<Bitmap> list, List<Integer> list2, ResourceReleaser<Bitmap> resourceReleaser) {
        boolean z = true;
        Preconditions.checkNotNull(list);
        Preconditions.checkState(list.size() >= 1, "Need at least 1 frame!");
        this.mBitmaps = new ArrayList();
        this.mBitmapReferences = new ArrayList();
        for (Bitmap bitmap : list) {
            this.mBitmapReferences.add(CloseableReference.m13748of(bitmap, resourceReleaser));
            this.mBitmaps.add(bitmap);
        }
        this.mDurations = (List) Preconditions.checkNotNull(list2);
        Preconditions.checkState(this.mDurations.size() != this.mBitmaps.size() ? false : z, "Arrays length mismatch!");
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.mBitmapReferences == null) {
                return;
            }
            List<CloseableReference<Bitmap>> list = this.mBitmapReferences;
            this.mBitmapReferences = null;
            this.mBitmaps = null;
            this.mDurations = null;
            CloseableReference.closeSafely(list);
        }
    }

    public List<Bitmap> getBitmaps() {
        return this.mBitmaps;
    }

    public List<Integer> getDurations() {
        return this.mDurations;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getHeight() {
        List<Bitmap> list = this.mBitmaps;
        if (list == null) {
            return 0;
        }
        return list.get(0).getHeight();
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public int getSizeInBytes() {
        List<Bitmap> list = this.mBitmaps;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return BitmapUtil.getSizeInBytes(list.get(0)) * list.size();
    }

    @Override // com.facebook.imagepipeline.image.CloseableBitmap
    public Bitmap getUnderlyingBitmap() {
        List<Bitmap> list = this.mBitmaps;
        if (list != null) {
            return list.get(0);
        }
        return null;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public int getWidth() {
        List<Bitmap> list = this.mBitmaps;
        if (list == null) {
            return 0;
        }
        return list.get(0).getWidth();
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public synchronized boolean isClosed() {
        return this.mBitmaps == null;
    }
}
