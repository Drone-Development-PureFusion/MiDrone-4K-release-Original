package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.MatrixDrawable;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.RoundedBitmapDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.drawable.SettableDrawable;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class GenericDraweeHierarchy implements SettableDraweeHierarchy {
    private final int mActualImageIndex;
    private final SettableDrawable mActualImageSettableDrawable;
    private final int mControllerOverlayIndex;
    private final Drawable mEmptyActualImageDrawable = new ColorDrawable(0);
    private final Drawable mEmptyControllerOverlayDrawable = new ColorDrawable(0);
    private Drawable mEmptyPlaceholderDrawable;
    private final FadeDrawable mFadeDrawable;
    private final int mFailureImageIndex;
    private final int mPlaceholderImageIndex;
    private final int mProgressBarImageIndex;
    private final Resources mResources;
    private final int mRetryImageIndex;
    private RoundingParams mRoundingParams;
    private final RootDrawable mTopLevelDrawable;

    /* loaded from: classes.dex */
    public static class RootDrawable extends ForwardingDrawable implements VisibilityAwareDrawable {
        @Nullable
        private VisibilityCallback mVisibilityCallback;

        public RootDrawable(Drawable drawable) {
            super(drawable);
        }

        @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
        @SuppressLint({"WrongCall"})
        public void draw(Canvas canvas) {
            if (!isVisible()) {
                return;
            }
            if (this.mVisibilityCallback != null) {
                this.mVisibilityCallback.onDraw();
            }
            super.draw(canvas);
        }

        @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return -1;
        }

        @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return -1;
        }

        @Override // com.facebook.drawee.drawable.VisibilityAwareDrawable
        public void setVisibilityCallback(@Nullable VisibilityCallback visibilityCallback) {
            this.mVisibilityCallback = visibilityCallback;
        }

        @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            if (this.mVisibilityCallback != null) {
                this.mVisibilityCallback.onVisibilityChange(z);
            }
            return super.setVisible(z, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GenericDraweeHierarchy(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        int i;
        this.mResources = genericDraweeHierarchyBuilder.getResources();
        this.mRoundingParams = genericDraweeHierarchyBuilder.getRoundingParams();
        int size = genericDraweeHierarchyBuilder.getBackgrounds() != null ? genericDraweeHierarchyBuilder.getBackgrounds().size() : 0;
        int i2 = 0 + size;
        Drawable placeholderImage = genericDraweeHierarchyBuilder.getPlaceholderImage();
        Drawable maybeWrapWithScaleType = maybeWrapWithScaleType(maybeApplyRoundingBitmapOnly(this.mRoundingParams, this.mResources, placeholderImage == null ? getEmptyPlaceholderDrawable() : placeholderImage), genericDraweeHierarchyBuilder.getPlaceholderImageScaleType());
        int i3 = i2 + 1;
        this.mPlaceholderImageIndex = i2;
        this.mActualImageSettableDrawable = new SettableDrawable(this.mEmptyActualImageDrawable);
        Drawable maybeWrapWithMatrix = maybeWrapWithMatrix(maybeWrapWithScaleType(this.mActualImageSettableDrawable, genericDraweeHierarchyBuilder.getActualImageScaleType(), genericDraweeHierarchyBuilder.getActualImageFocusPoint()), genericDraweeHierarchyBuilder.getActualImageMatrix());
        maybeWrapWithMatrix.setColorFilter(genericDraweeHierarchyBuilder.getActualImageColorFilter());
        int i4 = i3 + 1;
        this.mActualImageIndex = i3;
        Drawable progressBarImage = genericDraweeHierarchyBuilder.getProgressBarImage();
        int i5 = i4 + 1;
        this.mProgressBarImageIndex = i4;
        progressBarImage = progressBarImage != null ? maybeWrapWithScaleType(progressBarImage, genericDraweeHierarchyBuilder.getProgressBarImageScaleType()) : progressBarImage;
        Drawable retryImage = genericDraweeHierarchyBuilder.getRetryImage();
        int i6 = i5 + 1;
        this.mRetryImageIndex = i5;
        retryImage = retryImage != null ? maybeWrapWithScaleType(retryImage, genericDraweeHierarchyBuilder.getRetryImageScaleType()) : retryImage;
        Drawable failureImage = genericDraweeHierarchyBuilder.getFailureImage();
        int i7 = i6 + 1;
        this.mFailureImageIndex = i6;
        failureImage = failureImage != null ? maybeWrapWithScaleType(failureImage, genericDraweeHierarchyBuilder.getFailureImageScaleType()) : failureImage;
        int size2 = (genericDraweeHierarchyBuilder.getOverlays() != null ? genericDraweeHierarchyBuilder.getOverlays().size() : 0) + (genericDraweeHierarchyBuilder.getPressedStateOverlay() != null ? 1 : 0);
        int i8 = i7 + size2;
        this.mControllerOverlayIndex = i8;
        Drawable[] drawableArr = new Drawable[i8 + 1];
        if (size > 0) {
            int i9 = 0;
            for (Drawable drawable : genericDraweeHierarchyBuilder.getBackgrounds()) {
                drawableArr[i9 + 0] = maybeApplyRoundingBitmapOnly(this.mRoundingParams, this.mResources, drawable);
                i9++;
            }
        }
        drawableArr[this.mPlaceholderImageIndex] = maybeWrapWithScaleType;
        drawableArr[this.mActualImageIndex] = maybeWrapWithMatrix;
        drawableArr[this.mProgressBarImageIndex] = progressBarImage;
        drawableArr[this.mRetryImageIndex] = retryImage;
        drawableArr[this.mFailureImageIndex] = failureImage;
        if (size2 > 0) {
            if (genericDraweeHierarchyBuilder.getOverlays() != null) {
                i = 0;
                for (Drawable drawable2 : genericDraweeHierarchyBuilder.getOverlays()) {
                    drawableArr[i + i7] = drawable2;
                    i++;
                }
            } else {
                i = 0;
            }
            if (genericDraweeHierarchyBuilder.getPressedStateOverlay() != null) {
                int i10 = i + 1;
                drawableArr[i7 + i] = genericDraweeHierarchyBuilder.getPressedStateOverlay();
            }
        }
        if (this.mControllerOverlayIndex >= 0) {
            drawableArr[this.mControllerOverlayIndex] = this.mEmptyControllerOverlayDrawable;
        }
        this.mFadeDrawable = new FadeDrawable(drawableArr);
        this.mFadeDrawable.setTransitionDuration(genericDraweeHierarchyBuilder.getFadeDuration());
        this.mTopLevelDrawable = new RootDrawable(maybeWrapWithRoundedOverlayColor(this.mRoundingParams, this.mFadeDrawable));
        this.mTopLevelDrawable.mutate();
        resetFade();
    }

    private static Drawable applyRounding(@Nullable RoundingParams roundingParams, Resources resources, Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            RoundedBitmapDrawable fromBitmapDrawable = RoundedBitmapDrawable.fromBitmapDrawable(resources, (BitmapDrawable) drawable);
            applyRoundingParams(fromBitmapDrawable, roundingParams);
            return fromBitmapDrawable;
        } else if (!(drawable instanceof ColorDrawable) || Build.VERSION.SDK_INT < 11) {
            return drawable;
        } else {
            RoundedColorDrawable fromColorDrawable = RoundedColorDrawable.fromColorDrawable((ColorDrawable) drawable);
            applyRoundingParams(fromColorDrawable, roundingParams);
            return fromColorDrawable;
        }
    }

    private static void applyRoundingParams(Rounded rounded, RoundingParams roundingParams) {
        rounded.setCircle(roundingParams.getRoundAsCircle());
        rounded.setRadii(roundingParams.getCornersRadii());
        rounded.setBorder(roundingParams.getBorderColor(), roundingParams.getBorderWidth());
    }

    private void fadeInLayer(int i) {
        if (i >= 0) {
            this.mFadeDrawable.fadeInLayer(i);
        }
    }

    private void fadeOutBranches() {
        fadeOutLayer(this.mPlaceholderImageIndex);
        fadeOutLayer(this.mActualImageIndex);
        fadeOutLayer(this.mProgressBarImageIndex);
        fadeOutLayer(this.mRetryImageIndex);
        fadeOutLayer(this.mFailureImageIndex);
    }

    private void fadeOutLayer(int i) {
        if (i >= 0) {
            this.mFadeDrawable.fadeOutLayer(i);
        }
    }

    @Nullable
    private ScaleTypeDrawable findLayerScaleTypeDrawable(int i) {
        Drawable drawable = this.mFadeDrawable.getDrawable(i);
        if (drawable instanceof MatrixDrawable) {
            drawable = drawable.getCurrent();
        }
        if (drawable instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) drawable;
        }
        return null;
    }

    private Drawable getEmptyPlaceholderDrawable() {
        if (this.mEmptyPlaceholderDrawable == null) {
            this.mEmptyPlaceholderDrawable = new ColorDrawable(0);
        }
        return this.mEmptyPlaceholderDrawable;
    }

    private Drawable getLayerChildDrawable(int i) {
        return getLayerDrawable(i, false);
    }

    private Drawable getLayerDrawable(int i, boolean z) {
        Drawable drawable;
        Drawable drawable2;
        FadeDrawable fadeDrawable = this.mFadeDrawable;
        Drawable drawable3 = this.mFadeDrawable.getDrawable(i);
        if (drawable3 instanceof MatrixDrawable) {
            drawable = drawable3.getCurrent();
        } else {
            drawable3 = fadeDrawable;
            drawable = drawable3;
        }
        if (drawable instanceof ScaleTypeDrawable) {
            drawable2 = drawable.getCurrent();
        } else {
            Drawable drawable4 = drawable;
            drawable = drawable3;
            drawable2 = drawable4;
        }
        return z ? drawable : drawable2;
    }

    private static Drawable maybeApplyRoundingBitmapOnly(@Nullable RoundingParams roundingParams, Resources resources, Drawable drawable) {
        if (roundingParams == null || roundingParams.getRoundingMethod() != RoundingParams.RoundingMethod.BITMAP_ONLY) {
            return drawable;
        }
        if ((drawable instanceof BitmapDrawable) || (drawable instanceof ColorDrawable)) {
            return applyRounding(roundingParams, resources, drawable);
        }
        Drawable drawable2 = drawable;
        for (Drawable current = drawable.getCurrent(); current != null && drawable2 != current; current = current.getCurrent()) {
            if ((drawable2 instanceof ForwardingDrawable) && ((current instanceof BitmapDrawable) || (current instanceof ColorDrawable))) {
                ((ForwardingDrawable) drawable2).setCurrent(applyRounding(roundingParams, resources, current));
            }
            drawable2 = current;
        }
        return drawable;
    }

    private static Drawable maybeWrapWithMatrix(Drawable drawable, @Nullable Matrix matrix) {
        Preconditions.checkNotNull(drawable);
        return matrix == null ? drawable : new MatrixDrawable(drawable, matrix);
    }

    private static Drawable maybeWrapWithRoundedOverlayColor(@Nullable RoundingParams roundingParams, Drawable drawable) {
        if (roundingParams == null || roundingParams.getRoundingMethod() != RoundingParams.RoundingMethod.OVERLAY_COLOR) {
            return drawable;
        }
        RoundedCornersDrawable roundedCornersDrawable = new RoundedCornersDrawable(drawable);
        applyRoundingParams(roundedCornersDrawable, roundingParams);
        roundedCornersDrawable.setOverlayColor(roundingParams.getOverlayColor());
        return roundedCornersDrawable;
    }

    private static Drawable maybeWrapWithScaleType(Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        return maybeWrapWithScaleType(drawable, scaleType, null);
    }

    private static Drawable maybeWrapWithScaleType(Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType, @Nullable PointF pointF) {
        Preconditions.checkNotNull(drawable);
        if (scaleType == null) {
            return drawable;
        }
        ScaleTypeDrawable scaleTypeDrawable = new ScaleTypeDrawable(drawable, scaleType);
        if (pointF != null) {
            scaleTypeDrawable.setFocusPoint(pointF);
        }
        return scaleTypeDrawable;
    }

    private void resetActualImages() {
        if (this.mActualImageSettableDrawable != null) {
            this.mActualImageSettableDrawable.setDrawable(this.mEmptyActualImageDrawable);
        }
    }

    private void resetFade() {
        if (this.mFadeDrawable != null) {
            this.mFadeDrawable.beginBatchMode();
            this.mFadeDrawable.fadeInAllLayers();
            fadeOutBranches();
            fadeInLayer(this.mPlaceholderImageIndex);
            this.mFadeDrawable.finishTransitionImmediately();
            this.mFadeDrawable.endBatchMode();
        }
    }

    private static void resetRoundedDrawable(Rounded rounded) {
        rounded.setCircle(false);
        rounded.setRadius(0.0f);
        rounded.setBorder(0, 0.0f);
    }

    private void setDrawableAndScaleType(@Nullable Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType, int i) {
        if (drawable == null) {
            this.mFadeDrawable.setDrawable(i, null);
            return;
        }
        Drawable maybeApplyRoundingBitmapOnly = maybeApplyRoundingBitmapOnly(this.mRoundingParams, this.mResources, drawable);
        if (scaleType != null) {
            ScaleTypeDrawable findLayerScaleTypeDrawable = findLayerScaleTypeDrawable(i);
            if (findLayerScaleTypeDrawable != null) {
                findLayerScaleTypeDrawable.setScaleType(scaleType);
            } else {
                maybeApplyRoundingBitmapOnly = maybeWrapWithScaleType(maybeApplyRoundingBitmapOnly, scaleType);
            }
        }
        setLayerChildDrawable(i, maybeApplyRoundingBitmapOnly);
    }

    private void setLayerChildDrawable(int i, Drawable drawable) {
        Drawable layerDrawable = getLayerDrawable(i, true);
        if (layerDrawable == this.mFadeDrawable) {
            this.mFadeDrawable.setDrawable(i, drawable);
        } else {
            ((ForwardingDrawable) layerDrawable).setCurrent(drawable);
        }
    }

    private void setProgress(float f) {
        Drawable layerChildDrawable = getLayerChildDrawable(this.mProgressBarImageIndex);
        if (layerChildDrawable == null) {
            return;
        }
        if (f >= 0.999f) {
            if (layerChildDrawable instanceof Animatable) {
                ((Animatable) layerChildDrawable).stop();
            }
            fadeOutLayer(this.mProgressBarImageIndex);
        } else {
            if (layerChildDrawable instanceof Animatable) {
                ((Animatable) layerChildDrawable).start();
            }
            fadeInLayer(this.mProgressBarImageIndex);
        }
        layerChildDrawable.setLevel(Math.round(10000.0f * f));
    }

    private void updateBitmapOnlyRounding() {
        int i = 0;
        if (this.mRoundingParams == null || this.mRoundingParams.getRoundingMethod() != RoundingParams.RoundingMethod.BITMAP_ONLY) {
            while (true) {
                int i2 = i;
                if (i2 >= this.mFadeDrawable.getNumberOfLayers()) {
                    return;
                }
                Drawable layerChildDrawable = getLayerChildDrawable(i2);
                if (layerChildDrawable instanceof Rounded) {
                    resetRoundedDrawable((Rounded) layerChildDrawable);
                }
                i = i2 + 1;
            }
        } else {
            while (true) {
                int i3 = i;
                if (i3 >= this.mFadeDrawable.getNumberOfLayers()) {
                    return;
                }
                Drawable layerChildDrawable2 = getLayerChildDrawable(i3);
                if (layerChildDrawable2 instanceof Rounded) {
                    applyRoundingParams((Rounded) layerChildDrawable2, this.mRoundingParams);
                } else if (layerChildDrawable2 != null) {
                    setLayerChildDrawable(i3, this.mEmptyActualImageDrawable);
                    setLayerChildDrawable(i3, maybeApplyRoundingBitmapOnly(this.mRoundingParams, this.mResources, layerChildDrawable2));
                }
                i = i3 + 1;
            }
        }
    }

    private void updateOverlayColorRounding() {
        Drawable current = this.mTopLevelDrawable.getCurrent();
        if (this.mRoundingParams == null || this.mRoundingParams.getRoundingMethod() != RoundingParams.RoundingMethod.OVERLAY_COLOR) {
            if (!(current instanceof RoundedCornersDrawable)) {
                return;
            }
            this.mTopLevelDrawable.setCurrent(((RoundedCornersDrawable) current).setCurrent(this.mEmptyActualImageDrawable));
        } else if (current instanceof RoundedCornersDrawable) {
            RoundedCornersDrawable roundedCornersDrawable = (RoundedCornersDrawable) current;
            applyRoundingParams(roundedCornersDrawable, this.mRoundingParams);
            roundedCornersDrawable.setOverlayColor(this.mRoundingParams.getOverlayColor());
        } else {
            this.mTopLevelDrawable.setCurrent(maybeWrapWithRoundedOverlayColor(this.mRoundingParams, this.mTopLevelDrawable.setCurrent(this.mEmptyActualImageDrawable)));
        }
    }

    public void getActualImageBounds(RectF rectF) {
        this.mActualImageSettableDrawable.getTransformedBounds(rectF);
    }

    public RoundingParams getRoundingParams() {
        return this.mRoundingParams;
    }

    @Override // com.facebook.drawee.interfaces.DraweeHierarchy
    public Drawable getTopLevelDrawable() {
        return this.mTopLevelDrawable;
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void reset() {
        resetActualImages();
        resetFade();
    }

    public void setActualImageColorFilter(ColorFilter colorFilter) {
        this.mFadeDrawable.getDrawable(this.mActualImageIndex).setColorFilter(colorFilter);
    }

    public void setActualImageFocusPoint(PointF pointF) {
        Preconditions.checkNotNull(pointF);
        ScaleTypeDrawable findLayerScaleTypeDrawable = findLayerScaleTypeDrawable(this.mActualImageIndex);
        if (findLayerScaleTypeDrawable == null) {
            throw new UnsupportedOperationException("ScaleTypeDrawable not found!");
        }
        findLayerScaleTypeDrawable.setFocusPoint(pointF);
    }

    public void setActualImageScaleType(ScalingUtils.ScaleType scaleType) {
        Preconditions.checkNotNull(scaleType);
        ScaleTypeDrawable findLayerScaleTypeDrawable = findLayerScaleTypeDrawable(this.mActualImageIndex);
        if (findLayerScaleTypeDrawable == null) {
            throw new UnsupportedOperationException("ScaleTypeDrawable not found!");
        }
        findLayerScaleTypeDrawable.setScaleType(scaleType);
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setControllerOverlay(@Nullable Drawable drawable) {
        if (drawable == null) {
            drawable = this.mEmptyControllerOverlayDrawable;
        }
        this.mFadeDrawable.setDrawable(this.mControllerOverlayIndex, drawable);
    }

    public void setFadeDuration(int i) {
        this.mFadeDrawable.setTransitionDuration(i);
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setFailure(Throwable th) {
        this.mFadeDrawable.beginBatchMode();
        fadeOutBranches();
        if (this.mFadeDrawable.getDrawable(this.mFailureImageIndex) != null) {
            fadeInLayer(this.mFailureImageIndex);
        } else {
            fadeInLayer(this.mPlaceholderImageIndex);
        }
        this.mFadeDrawable.endBatchMode();
    }

    public void setFailureImage(Drawable drawable) {
        setFailureImage(drawable, null);
    }

    public void setFailureImage(@Nullable Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        setDrawableAndScaleType(drawable, scaleType, this.mFailureImageIndex);
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setImage(Drawable drawable, float f, boolean z) {
        Drawable maybeApplyRoundingBitmapOnly = maybeApplyRoundingBitmapOnly(this.mRoundingParams, this.mResources, drawable);
        maybeApplyRoundingBitmapOnly.mutate();
        this.mActualImageSettableDrawable.setDrawable(maybeApplyRoundingBitmapOnly);
        this.mFadeDrawable.beginBatchMode();
        fadeOutBranches();
        fadeInLayer(this.mActualImageIndex);
        setProgress(f);
        if (z) {
            this.mFadeDrawable.finishTransitionImmediately();
        }
        this.mFadeDrawable.endBatchMode();
    }

    public void setPlaceholderImage(int i) {
        setPlaceholderImage(this.mResources.getDrawable(i));
    }

    public void setPlaceholderImage(Drawable drawable) {
        setPlaceholderImage(drawable, null);
    }

    public void setPlaceholderImage(@Nullable Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        if (drawable == null) {
            drawable = getEmptyPlaceholderDrawable();
        }
        setDrawableAndScaleType(drawable, scaleType, this.mPlaceholderImageIndex);
    }

    public void setPlaceholderImageFocusPoint(PointF pointF) {
        Preconditions.checkNotNull(pointF);
        ScaleTypeDrawable findLayerScaleTypeDrawable = findLayerScaleTypeDrawable(this.mPlaceholderImageIndex);
        if (findLayerScaleTypeDrawable == null) {
            throw new UnsupportedOperationException("ScaleTypeDrawable not found!");
        }
        findLayerScaleTypeDrawable.setFocusPoint(pointF);
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setProgress(float f, boolean z) {
        this.mFadeDrawable.beginBatchMode();
        setProgress(f);
        if (z) {
            this.mFadeDrawable.finishTransitionImmediately();
        }
        this.mFadeDrawable.endBatchMode();
    }

    public void setProgressBarImage(Drawable drawable) {
        setProgressBarImage(drawable, null);
    }

    public void setProgressBarImage(@Nullable Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        setDrawableAndScaleType(drawable, scaleType, this.mProgressBarImageIndex);
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setRetry(Throwable th) {
        this.mFadeDrawable.beginBatchMode();
        fadeOutBranches();
        if (this.mFadeDrawable.getDrawable(this.mRetryImageIndex) != null) {
            fadeInLayer(this.mRetryImageIndex);
        } else {
            fadeInLayer(this.mPlaceholderImageIndex);
        }
        this.mFadeDrawable.endBatchMode();
    }

    public void setRetryImage(Drawable drawable) {
        setRetryImage(drawable, null);
    }

    public void setRetryImage(@Nullable Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        setDrawableAndScaleType(drawable, scaleType, this.mRetryImageIndex);
    }

    public void setRoundingParams(RoundingParams roundingParams) {
        this.mRoundingParams = roundingParams;
        updateOverlayColorRounding();
        updateBitmapOnlyRounding();
    }
}
