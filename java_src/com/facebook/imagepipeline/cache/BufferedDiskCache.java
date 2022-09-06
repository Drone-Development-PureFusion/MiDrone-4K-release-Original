package com.facebook.imagepipeline.cache;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import p000a.C0018l;
/* loaded from: classes.dex */
public class BufferedDiskCache {
    private static final Class<?> TAG = BufferedDiskCache.class;
    private final FileCache mFileCache;
    private final ImageCacheStatsTracker mImageCacheStatsTracker;
    private final PooledByteBufferFactory mPooledByteBufferFactory;
    private final PooledByteStreams mPooledByteStreams;
    private final Executor mReadExecutor;
    private final StagingArea mStagingArea = StagingArea.getInstance();
    private final Executor mWriteExecutor;

    public BufferedDiskCache(FileCache fileCache, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, Executor executor, Executor executor2, ImageCacheStatsTracker imageCacheStatsTracker) {
        this.mFileCache = fileCache;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mPooledByteStreams = pooledByteStreams;
        this.mReadExecutor = executor;
        this.mWriteExecutor = executor2;
        this.mImageCacheStatsTracker = imageCacheStatsTracker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer readFromDiskCache(CacheKey cacheKey) {
        try {
            FLog.m13782v(TAG, "Disk cache read for %s", cacheKey.toString());
            BinaryResource resource = this.mFileCache.getResource(cacheKey);
            if (resource == null) {
                FLog.m13782v(TAG, "Disk cache miss for %s", cacheKey.toString());
                this.mImageCacheStatsTracker.onDiskCacheMiss();
                return null;
            }
            FLog.m13782v(TAG, "Found entry in disk cache for %s", cacheKey.toString());
            this.mImageCacheStatsTracker.onDiskCacheHit();
            InputStream openStream = resource.openStream();
            PooledByteBuffer mo21793newByteBuffer = this.mPooledByteBufferFactory.mo21793newByteBuffer(openStream, (int) resource.size());
            openStream.close();
            FLog.m13782v(TAG, "Successful read from disk cache for %s", cacheKey.toString());
            return mo21793newByteBuffer;
        } catch (IOException e) {
            FLog.m13764w(TAG, e, "Exception reading from cache for %s", cacheKey.toString());
            this.mImageCacheStatsTracker.onDiskCacheGetFail();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeToDiskCache(CacheKey cacheKey, final EncodedImage encodedImage) {
        FLog.m13782v(TAG, "About to write to disk-cache for key %s", cacheKey.toString());
        try {
            this.mFileCache.insert(cacheKey, new WriterCallback() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.6
                @Override // com.facebook.cache.common.WriterCallback
                public void write(OutputStream outputStream) {
                    BufferedDiskCache.this.mPooledByteStreams.copy(encodedImage.getInputStream(), outputStream);
                }
            });
            FLog.m13782v(TAG, "Successful disk-cache write for key %s", cacheKey.toString());
        } catch (IOException e) {
            FLog.m13764w(TAG, e, "Failed to write to disk-cache for key %s", cacheKey.toString());
        }
    }

    public C0018l<Void> clearAll() {
        this.mStagingArea.clearAll();
        try {
            return C0018l.m21607a(new Callable<Void>() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.5
                @Override // java.util.concurrent.Callable
                public Void call() {
                    BufferedDiskCache.this.mStagingArea.clearAll();
                    BufferedDiskCache.this.mFileCache.clearAll();
                    return null;
                }
            }, this.mWriteExecutor);
        } catch (Exception e) {
            FLog.m13764w(TAG, e, "Failed to schedule disk-cache clear", new Object[0]);
            return C0018l.m21613a(e);
        }
    }

    public C0018l<Boolean> contains(final CacheKey cacheKey) {
        Preconditions.checkNotNull(cacheKey);
        EncodedImage encodedImage = this.mStagingArea.get(cacheKey);
        if (encodedImage != null) {
            encodedImage.close();
            FLog.m13782v(TAG, "Found image for %s in staging area", cacheKey.toString());
            this.mImageCacheStatsTracker.onStagingAreaHit();
            return C0018l.m21612a(true);
        }
        try {
            return C0018l.m21607a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                /* renamed from: call */
                public Boolean mo21775call() {
                    EncodedImage encodedImage2 = BufferedDiskCache.this.mStagingArea.get(cacheKey);
                    if (encodedImage2 != null) {
                        encodedImage2.close();
                        FLog.m13782v(BufferedDiskCache.TAG, "Found image for %s in staging area", cacheKey.toString());
                        BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaHit();
                        return true;
                    }
                    FLog.m13782v(BufferedDiskCache.TAG, "Did not find image for %s in staging area", cacheKey.toString());
                    BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaMiss();
                    try {
                        return Boolean.valueOf(BufferedDiskCache.this.mFileCache.hasKey(cacheKey));
                    } catch (Exception e) {
                        return false;
                    }
                }
            }, this.mReadExecutor);
        } catch (Exception e) {
            FLog.m13764w(TAG, e, "Failed to schedule disk-cache read for %s", cacheKey.toString());
            return C0018l.m21613a(e);
        }
    }

    public C0018l<EncodedImage> get(final CacheKey cacheKey, final AtomicBoolean atomicBoolean) {
        Preconditions.checkNotNull(cacheKey);
        Preconditions.checkNotNull(atomicBoolean);
        EncodedImage encodedImage = this.mStagingArea.get(cacheKey);
        if (encodedImage != null) {
            FLog.m13782v(TAG, "Found image for %s in staging area", cacheKey.toString());
            this.mImageCacheStatsTracker.onStagingAreaHit();
            return C0018l.m21612a(encodedImage);
        }
        try {
            return C0018l.m21607a(new Callable<EncodedImage>() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                /* renamed from: call */
                public EncodedImage mo21776call() {
                    if (atomicBoolean.get()) {
                        throw new CancellationException();
                    }
                    EncodedImage encodedImage2 = BufferedDiskCache.this.mStagingArea.get(cacheKey);
                    if (encodedImage2 != null) {
                        FLog.m13782v(BufferedDiskCache.TAG, "Found image for %s in staging area", cacheKey.toString());
                        BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaHit();
                    } else {
                        FLog.m13782v(BufferedDiskCache.TAG, "Did not find image for %s in staging area", cacheKey.toString());
                        BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaMiss();
                        try {
                            CloseableReference m13749of = CloseableReference.m13749of(BufferedDiskCache.this.readFromDiskCache(cacheKey));
                            encodedImage2 = new EncodedImage(m13749of);
                            CloseableReference.closeSafely(m13749of);
                        } catch (Exception e) {
                            return null;
                        }
                    }
                    if (!Thread.interrupted()) {
                        return encodedImage2;
                    }
                    FLog.m13783v(BufferedDiskCache.TAG, "Host thread was interrupted, decreasing reference count");
                    if (encodedImage2 != null) {
                        encodedImage2.close();
                    }
                    throw new InterruptedException();
                }
            }, this.mReadExecutor);
        } catch (Exception e) {
            FLog.m13764w(TAG, e, "Failed to schedule disk-cache read for %s", cacheKey.toString());
            return C0018l.m21613a(e);
        }
    }

    public void put(final CacheKey cacheKey, EncodedImage encodedImage) {
        Preconditions.checkNotNull(cacheKey);
        Preconditions.checkArgument(EncodedImage.isValid(encodedImage));
        this.mStagingArea.put(cacheKey, encodedImage);
        final EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
        try {
            this.mWriteExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        BufferedDiskCache.this.writeToDiskCache(cacheKey, cloneOrNull);
                    } finally {
                        BufferedDiskCache.this.mStagingArea.remove(cacheKey, cloneOrNull);
                        EncodedImage.closeSafely(cloneOrNull);
                    }
                }
            });
        } catch (Exception e) {
            FLog.m13764w(TAG, e, "Failed to schedule disk-cache write for %s", cacheKey.toString());
            this.mStagingArea.remove(cacheKey, encodedImage);
            EncodedImage.closeSafely(cloneOrNull);
        }
    }

    public C0018l<Void> remove(final CacheKey cacheKey) {
        Preconditions.checkNotNull(cacheKey);
        this.mStagingArea.remove(cacheKey);
        try {
            return C0018l.m21607a(new Callable<Void>() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache.4
                @Override // java.util.concurrent.Callable
                public Void call() {
                    BufferedDiskCache.this.mStagingArea.remove(cacheKey);
                    BufferedDiskCache.this.mFileCache.remove(cacheKey);
                    return null;
                }
            }, this.mWriteExecutor);
        } catch (Exception e) {
            FLog.m13764w(TAG, e, "Failed to schedule disk-cache remove for %s", cacheKey.toString());
            return C0018l.m21613a(e);
        }
    }
}
