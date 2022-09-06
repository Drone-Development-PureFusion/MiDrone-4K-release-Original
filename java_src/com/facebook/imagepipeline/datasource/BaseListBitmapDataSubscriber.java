package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseListBitmapDataSubscriber extends BaseDataSubscriber<List<CloseableReference<CloseableImage>>> {
    @Override // com.facebook.datasource.BaseDataSubscriber
    public void onNewResultImpl(DataSource<List<CloseableReference<CloseableImage>>> dataSource) {
        if (!dataSource.isFinished()) {
            return;
        }
        List<CloseableReference<CloseableImage>> mo21786getResult = dataSource.mo21786getResult();
        if (mo21786getResult == null) {
            onNewResultListImpl(null);
            return;
        }
        try {
            ArrayList arrayList = new ArrayList(mo21786getResult.size());
            for (CloseableReference<CloseableImage> closeableReference : mo21786getResult) {
                if (closeableReference == null || !(closeableReference.get() instanceof CloseableBitmap)) {
                    arrayList.add(null);
                } else {
                    arrayList.add(((CloseableBitmap) closeableReference.get()).getUnderlyingBitmap());
                }
            }
            onNewResultListImpl(arrayList);
        } finally {
            for (CloseableReference<CloseableImage> next : mo21786getResult) {
                CloseableReference.closeSafely(next);
            }
        }
    }

    protected abstract void onNewResultListImpl(List<Bitmap> list);
}
