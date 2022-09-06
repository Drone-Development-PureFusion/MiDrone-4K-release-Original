package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
/* loaded from: classes.dex */
public class DefaultCacheKeyFactory implements CacheKeyFactory {
    private static DefaultCacheKeyFactory sInstance = null;

    protected DefaultCacheKeyFactory() {
    }

    public static synchronized DefaultCacheKeyFactory getInstance() {
        DefaultCacheKeyFactory defaultCacheKeyFactory;
        synchronized (DefaultCacheKeyFactory.class) {
            if (sInstance == null) {
                sInstance = new DefaultCacheKeyFactory();
            }
            defaultCacheKeyFactory = sInstance;
        }
        return defaultCacheKeyFactory;
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getBitmapCacheKey(ImageRequest imageRequest) {
        return new BitmapMemoryCacheKey(getCacheKeySourceUri(imageRequest.getSourceUri()).toString(), imageRequest.getResizeOptions(), imageRequest.getAutoRotateEnabled(), imageRequest.getImageDecodeOptions(), null, null);
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public Uri getCacheKeySourceUri(Uri uri) {
        return uri;
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getEncodedCacheKey(ImageRequest imageRequest) {
        return new SimpleCacheKey(getCacheKeySourceUri(imageRequest.getSourceUri()).toString());
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getPostprocessedBitmapCacheKey(ImageRequest imageRequest) {
        CacheKey cacheKey;
        String str = null;
        Postprocessor postprocessor = imageRequest.getPostprocessor();
        if (postprocessor != null) {
            cacheKey = postprocessor.getPostprocessorCacheKey();
            str = postprocessor.getClass().getName();
        } else {
            cacheKey = null;
        }
        return new BitmapMemoryCacheKey(getCacheKeySourceUri(imageRequest.getSourceUri()).toString(), imageRequest.getResizeOptions(), imageRequest.getAutoRotateEnabled(), imageRequest.getImageDecodeOptions(), cacheKey, str);
    }
}
