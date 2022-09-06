package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public abstract class BasePostprocessor implements Postprocessor {
    @Override // com.facebook.imagepipeline.request.Postprocessor
    public String getName() {
        return "Unknown postprocessor";
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    @Nullable
    public CacheKey getPostprocessorCacheKey() {
        return null;
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        CloseableReference<Bitmap> createBitmap = platformBitmapFactory.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        try {
            process(createBitmap.get(), bitmap);
            return CloseableReference.cloneOrNull(createBitmap);
        } finally {
            CloseableReference.closeSafely(createBitmap);
        }
    }

    public void process(Bitmap bitmap) {
    }

    public void process(Bitmap bitmap, Bitmap bitmap2) {
        Bitmaps.copyBitmap(bitmap, bitmap2);
        process(bitmap);
    }
}
