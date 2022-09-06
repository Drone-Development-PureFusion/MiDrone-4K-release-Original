package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
/* loaded from: classes.dex */
public abstract class PlatformBitmapFactory {
    public CloseableReference<Bitmap> createBitmap(int i, int i2) {
        return createBitmap(i, i2, Bitmap.Config.ARGB_8888);
    }

    public abstract CloseableReference<Bitmap> createBitmap(int i, int i2, Bitmap.Config config);
}
