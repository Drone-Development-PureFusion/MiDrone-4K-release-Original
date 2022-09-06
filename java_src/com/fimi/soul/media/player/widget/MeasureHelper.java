package com.fimi.soul.media.player.widget;

import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class MeasureHelper {
    private int mCurrentAspectRatio = 0;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private int mVideoHeight;
    private int mVideoRotationDegree;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private WeakReference<View> mWeakView;

    public MeasureHelper(View view) {
        this.mWeakView = new WeakReference<>(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0109, code lost:
        if (r12 > r2) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doMeasure(int i, int i2) {
        int i3;
        float f;
        float f2;
        int i4;
        int i5;
        if (this.mVideoRotationDegree == 90 || this.mVideoRotationDegree == 270) {
            i = i2;
            i2 = i;
        }
        int defaultSize = View.getDefaultSize(this.mVideoWidth, i);
        int defaultSize2 = View.getDefaultSize(this.mVideoHeight, i2);
        if (this.mCurrentAspectRatio == 3) {
            defaultSize2 = i2;
            defaultSize = i;
        } else if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
            int mode = View.MeasureSpec.getMode(i);
            defaultSize = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            defaultSize2 = View.MeasureSpec.getSize(i2);
            if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
                float f3 = defaultSize / defaultSize2;
                switch (this.mCurrentAspectRatio) {
                    case 4:
                        f = 1.7777778f;
                        if (this.mVideoRotationDegree == 90 || this.mVideoRotationDegree == 270) {
                            f2 = 1.0f / 1.7777778f;
                            break;
                        }
                        f2 = f;
                        break;
                    case 5:
                        f = 1.3333334f;
                        if (this.mVideoRotationDegree == 90 || this.mVideoRotationDegree == 270) {
                            f2 = 1.0f / 1.3333334f;
                            break;
                        }
                        f2 = f;
                        break;
                    default:
                        f = this.mVideoWidth / this.mVideoHeight;
                        if (this.mVideoSarNum > 0 && this.mVideoSarDen > 0) {
                            f2 = (f * this.mVideoSarNum) / this.mVideoSarDen;
                            break;
                        }
                        f2 = f;
                        break;
                }
                boolean z = f2 > f3;
                switch (this.mCurrentAspectRatio) {
                    case 0:
                    case 4:
                    case 5:
                        if (!z) {
                            i5 = (int) (defaultSize2 * f2);
                            i4 = defaultSize2;
                            break;
                        } else {
                            i4 = (int) (defaultSize / f2);
                            i5 = defaultSize;
                            break;
                        }
                    case 1:
                        if (!z) {
                            i4 = (int) (defaultSize / f2);
                            i5 = defaultSize;
                            break;
                        } else {
                            i5 = (int) (defaultSize2 * f2);
                            i4 = defaultSize2;
                            break;
                        }
                    case 2:
                    case 3:
                    default:
                        if (!z) {
                            i4 = Math.min(this.mVideoHeight, defaultSize2);
                            i5 = (int) (i4 * f2);
                            break;
                        } else {
                            i5 = Math.min(this.mVideoWidth, defaultSize);
                            i4 = (int) (i5 / f2);
                            break;
                        }
                }
                defaultSize = i5;
                defaultSize2 = i4;
            } else if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.mVideoWidth * defaultSize2 < this.mVideoHeight * defaultSize) {
                    defaultSize = (this.mVideoWidth * defaultSize2) / this.mVideoHeight;
                } else if (this.mVideoWidth * defaultSize2 > this.mVideoHeight * defaultSize) {
                    defaultSize2 = (this.mVideoHeight * defaultSize) / this.mVideoWidth;
                }
            } else if (mode == 1073741824) {
                int i6 = (this.mVideoHeight * defaultSize) / this.mVideoWidth;
                if (mode2 != Integer.MIN_VALUE || i6 <= defaultSize2) {
                    defaultSize2 = i6;
                }
            } else if (mode2 == 1073741824) {
                i3 = (this.mVideoWidth * defaultSize2) / this.mVideoHeight;
                if (mode == Integer.MIN_VALUE) {
                }
                defaultSize = i3;
            } else {
                i3 = this.mVideoWidth;
                int i7 = this.mVideoHeight;
                if (mode2 != Integer.MIN_VALUE || i7 <= defaultSize2) {
                    defaultSize2 = i7;
                } else {
                    i3 = (this.mVideoWidth * defaultSize2) / this.mVideoHeight;
                }
                if (mode == Integer.MIN_VALUE && i3 > defaultSize) {
                    defaultSize2 = (this.mVideoHeight * defaultSize) / this.mVideoWidth;
                }
                defaultSize = i3;
            }
        }
        this.mMeasuredWidth = defaultSize;
        this.mMeasuredHeight = defaultSize2;
    }

    public int getMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    public int getMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    public View getView() {
        if (this.mWeakView == null) {
            return null;
        }
        return this.mWeakView.get();
    }

    public void setAspectRatio(int i) {
        this.mCurrentAspectRatio = i;
    }

    public void setVideoRotation(int i) {
        this.mVideoRotationDegree = i;
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        this.mVideoSarNum = i;
        this.mVideoSarDen = i2;
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }
}
