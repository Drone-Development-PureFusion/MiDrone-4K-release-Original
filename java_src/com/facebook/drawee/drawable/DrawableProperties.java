package com.facebook.drawee.drawable;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class DrawableProperties {
    private static final int UNSET = -1;
    private int mAlpha = -1;
    private boolean mIsSetColorFilter = false;
    private ColorFilter mColorFilter = null;
    private int mDither = -1;
    private int mFilterBitmap = -1;

    public void applyTo(Drawable drawable) {
        boolean z = true;
        if (drawable == null) {
            return;
        }
        if (this.mAlpha != -1) {
            drawable.setAlpha(this.mAlpha);
        }
        if (this.mIsSetColorFilter) {
            drawable.setColorFilter(this.mColorFilter);
        }
        if (this.mDither != -1) {
            drawable.setDither(this.mDither != 0);
        }
        if (this.mFilterBitmap == -1) {
            return;
        }
        if (this.mFilterBitmap == 0) {
            z = false;
        }
        drawable.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.mIsSetColorFilter = true;
    }

    public void setDither(boolean z) {
        this.mDither = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.mFilterBitmap = z ? 1 : 0;
    }
}
