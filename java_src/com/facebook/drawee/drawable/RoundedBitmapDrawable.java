package com.facebook.drawee.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class RoundedBitmapDrawable extends BitmapDrawable implements Rounded, TransformAwareDrawable {
    private WeakReference<Bitmap> mLastBitmap;
    @Nullable
    private TransformCallback mTransformCallback;
    @VisibleForTesting
    boolean mIsCircle = false;
    @VisibleForTesting
    float[] mCornerRadii = new float[8];
    @VisibleForTesting
    RectF mRootBounds = new RectF();
    @VisibleForTesting
    final RectF mLastRootBounds = new RectF();
    @VisibleForTesting
    final Matrix mTransform = new Matrix();
    @VisibleForTesting
    final Matrix mInverseTransform = new Matrix();
    @VisibleForTesting
    final Matrix mLastTransform = new Matrix();
    @VisibleForTesting
    float mBorderWidth = 0.0f;
    @VisibleForTesting
    int mBorderColor = 0;
    @VisibleForTesting
    boolean mIsNonzero = true;
    private final Path mPath = new Path();
    private boolean mIsPathDirty = true;
    private final Paint mPaint = new Paint(1);
    private final Paint mBorderPaint = new Paint(1);
    private boolean mIsShaderTransformDirty = true;

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    public static RoundedBitmapDrawable fromBitmapDrawable(Resources resources, BitmapDrawable bitmapDrawable) {
        return new RoundedBitmapDrawable(resources, bitmapDrawable.getBitmap());
    }

    private void updateNonzero() {
        if (this.mIsPathDirty) {
            this.mIsNonzero = false;
            if (this.mIsCircle || this.mBorderWidth > 0.0f) {
                this.mIsNonzero = true;
            }
            for (int i = 0; i < this.mCornerRadii.length; i++) {
                if (this.mCornerRadii[i] > 0.0f) {
                    this.mIsNonzero = true;
                }
            }
        }
    }

    private void updatePaint() {
        Bitmap bitmap = getBitmap();
        if (this.mLastBitmap == null || this.mLastBitmap.get() != bitmap) {
            this.mLastBitmap = new WeakReference<>(bitmap);
            this.mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            this.mIsShaderTransformDirty = true;
        }
        if (this.mIsShaderTransformDirty) {
            this.mPaint.getShader().setLocalMatrix(this.mTransform);
            this.mIsShaderTransformDirty = false;
        }
    }

    private void updatePath() {
        if (this.mIsPathDirty) {
            this.mPath.reset();
            this.mRootBounds.inset(this.mBorderWidth / 2.0f, this.mBorderWidth / 2.0f);
            if (this.mIsCircle) {
                this.mPath.addCircle(this.mRootBounds.centerX(), this.mRootBounds.centerY(), Math.min(this.mRootBounds.width(), this.mRootBounds.height()) / 2.0f, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.mRootBounds, this.mCornerRadii, Path.Direction.CW);
            }
            this.mRootBounds.inset(-(this.mBorderWidth / 2.0f), -(this.mBorderWidth / 2.0f));
            this.mPath.setFillType(Path.FillType.WINDING);
            this.mIsPathDirty = false;
        }
    }

    private void updateTransform() {
        if (this.mTransformCallback != null) {
            this.mTransformCallback.getTransform(this.mTransform);
            this.mTransformCallback.getRootBounds(this.mRootBounds);
        } else {
            this.mTransform.reset();
            this.mRootBounds.set(getBounds());
        }
        if (!this.mTransform.equals(this.mLastTransform)) {
            this.mIsShaderTransformDirty = true;
            if (!this.mTransform.invert(this.mInverseTransform)) {
                this.mInverseTransform.reset();
                this.mTransform.reset();
            }
            this.mLastTransform.set(this.mTransform);
        }
        if (!this.mRootBounds.equals(this.mLastRootBounds)) {
            this.mIsPathDirty = true;
            this.mLastRootBounds.set(this.mRootBounds);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        updateTransform();
        updateNonzero();
        if (!this.mIsNonzero) {
            super.draw(canvas);
            return;
        }
        updatePath();
        updatePaint();
        int save = canvas.save();
        canvas.concat(this.mInverseTransform);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(DrawableUtils.multiplyColorAlpha(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.mPath, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setBorder(int i, float f) {
        if (this.mBorderColor == i && this.mBorderWidth == f) {
            return;
        }
        this.mBorderColor = i;
        this.mBorderWidth = f;
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setCircle(boolean z) {
        this.mIsCircle = z;
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        super.setColorFilter(colorFilter);
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadii(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.mCornerRadii, 0.0f);
        } else {
            Preconditions.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.mCornerRadii, 0, 8);
        }
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadius(float f) {
        Preconditions.checkState(f >= 0.0f);
        Arrays.fill(this.mCornerRadii, f);
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public void setTransformCallback(@Nullable TransformCallback transformCallback) {
        this.mTransformCallback = transformCallback;
    }
}
