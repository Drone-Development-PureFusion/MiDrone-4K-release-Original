package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class ArrayDrawable extends Drawable implements Drawable.Callback, TransformAwareDrawable, TransformCallback {
    private boolean mIsVisible;
    private final Drawable[] mLayers;
    private int mLevel;
    private int[] mState;
    private TransformCallback mTransformCallback;
    private final DrawableProperties mDrawableProperties = new DrawableProperties();
    private final Rect mTmpRect = new Rect();
    private boolean mIsStateful = false;
    private boolean mIsStatefulCalculated = false;
    private boolean mIsMutated = false;
    private final Rect mBounds = new Rect();

    public ArrayDrawable(Drawable[] drawableArr) {
        Preconditions.checkNotNull(drawableArr);
        this.mLayers = drawableArr;
        for (int i = 0; i < this.mLayers.length; i++) {
            DrawableUtils.setCallbacks(this.mLayers[i], this, this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        for (int i = 0; i < this.mLayers.length; i++) {
            Drawable drawable = this.mLayers[i];
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }
    }

    @Nullable
    public Drawable getDrawable(int i) {
        return this.mLayers[i];
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i = -1;
        for (int i2 = 0; i2 < this.mLayers.length; i2++) {
            Drawable drawable = this.mLayers[i2];
            if (drawable != null) {
                i = Math.max(i, drawable.getIntrinsicHeight());
            }
        }
        if (i > 0) {
            return i;
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = -1;
        for (int i2 = 0; i2 < this.mLayers.length; i2++) {
            Drawable drawable = this.mLayers[i2];
            if (drawable != null) {
                i = Math.max(i, drawable.getIntrinsicWidth());
            }
        }
        if (i > 0) {
            return i;
        }
        return -1;
    }

    public int getNumberOfLayers() {
        return this.mLayers.length;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.mLayers.length == 0) {
            return -2;
        }
        int i = -1;
        for (int i2 = 1; i2 < this.mLayers.length; i2++) {
            Drawable drawable = this.mLayers[i2];
            if (drawable != null) {
                i = Drawable.resolveOpacity(i, drawable.getOpacity());
            }
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        Rect rect2 = this.mTmpRect;
        for (int i = 0; i < this.mLayers.length; i++) {
            Drawable drawable = this.mLayers[i];
            if (drawable != null) {
                drawable.getPadding(rect2);
                rect.left = Math.max(rect.left, rect2.left);
                rect.top = Math.max(rect.top, rect2.top);
                rect.right = Math.max(rect.right, rect2.right);
                rect.bottom = Math.max(rect.bottom, rect2.bottom);
            }
        }
        return true;
    }

    @Override // com.facebook.drawee.drawable.TransformCallback
    public void getRootBounds(RectF rectF) {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getRootBounds(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // com.facebook.drawee.drawable.TransformCallback
    public void getTransform(Matrix matrix) {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!this.mIsStatefulCalculated) {
            this.mIsStateful = false;
            for (int i = 0; i < this.mLayers.length; i++) {
                Drawable drawable = this.mLayers[i];
                this.mIsStateful = (drawable != null && drawable.isStateful()) | this.mIsStateful;
            }
            this.mIsStatefulCalculated = true;
        }
        return this.mIsStateful;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        for (int i = 0; i < this.mLayers.length; i++) {
            Drawable drawable = this.mLayers[i];
            if (drawable != null) {
                drawable.mutate();
            }
        }
        this.mIsMutated = true;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.mBounds.set(rect);
        for (int i = 0; i < this.mLayers.length; i++) {
            Drawable drawable = this.mLayers[i];
            if (drawable != null) {
                drawable.setBounds(rect);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        this.mLevel = i;
        boolean z = false;
        for (int i2 = 0; i2 < this.mLayers.length; i2++) {
            Drawable drawable = this.mLayers[i2];
            if (drawable != null && drawable.setLevel(i)) {
                z = true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        this.mState = iArr;
        boolean z = false;
        for (int i = 0; i < this.mLayers.length; i++) {
            Drawable drawable = this.mLayers[i];
            if (drawable != null && drawable.setState(iArr)) {
                z = true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mDrawableProperties.setAlpha(i);
        for (int i2 = 0; i2 < this.mLayers.length; i2++) {
            Drawable drawable = this.mLayers[i2];
            if (drawable != null) {
                drawable.setAlpha(i);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawableProperties.setColorFilter(colorFilter);
        for (int i = 0; i < this.mLayers.length; i++) {
            Drawable drawable = this.mLayers[i];
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.mDrawableProperties.setDither(z);
        for (int i = 0; i < this.mLayers.length; i++) {
            Drawable drawable = this.mLayers[i];
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    public void setDrawable(int i, @Nullable Drawable drawable) {
        boolean z = true;
        Preconditions.checkArgument(i >= 0);
        if (i >= this.mLayers.length) {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (drawable != this.mLayers[i]) {
            if (drawable != null && this.mIsMutated) {
                drawable = drawable.mutate();
            }
            DrawableUtils.setCallbacks(this.mLayers[i], null, null);
            DrawableUtils.setCallbacks(drawable, null, null);
            DrawableUtils.setDrawableProperties(drawable, this.mDrawableProperties);
            if (drawable != null) {
                drawable.setBounds(this.mBounds);
                drawable.setLevel(this.mLevel);
                drawable.setState(this.mState);
                drawable.setVisible(this.mIsVisible, false);
            }
            DrawableUtils.setCallbacks(drawable, this, this);
            this.mIsStatefulCalculated = false;
            this.mLayers[i] = drawable;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.mDrawableProperties.setFilterBitmap(z);
        for (int i = 0; i < this.mLayers.length; i++) {
            Drawable drawable = this.mLayers[i];
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
        }
    }

    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public void setTransformCallback(TransformCallback transformCallback) {
        this.mTransformCallback = transformCallback;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        this.mIsVisible = z;
        boolean visible = super.setVisible(z, z2);
        for (int i = 0; i < this.mLayers.length; i++) {
            Drawable drawable = this.mLayers[i];
            if (drawable != null) {
                drawable.setVisible(z, z2);
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
