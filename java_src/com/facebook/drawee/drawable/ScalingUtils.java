package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;
/* loaded from: classes.dex */
public class ScalingUtils {

    /* loaded from: classes.dex */
    public enum ScaleType {
        FIT_XY,
        FIT_START,
        FIT_CENTER,
        FIT_END,
        CENTER,
        CENTER_INSIDE,
        CENTER_CROP,
        FOCUS_CROP
    }

    public static Matrix getTransform(Matrix matrix, Rect rect, int i, int i2, float f, float f2, ScaleType scaleType) {
        float f3;
        float max;
        float f4;
        float f5;
        int width = rect.width();
        int height = rect.height();
        float f6 = width / i;
        float f7 = height / i2;
        switch (scaleType) {
            case FIT_XY:
                matrix.setScale(f6, f7);
                matrix.postTranslate((int) (rect.left + 0.5f), (int) (rect.top + 0.5f));
                break;
            case FIT_START:
                float min = Math.min(f6, f7);
                matrix.setScale(min, min);
                matrix.postTranslate((int) (rect.left + 0.5f), (int) (rect.top + 0.5f));
                break;
            case FIT_CENTER:
                float min2 = Math.min(f6, f7);
                float f8 = ((width - (i * min2)) * 0.5f) + rect.left;
                matrix.setScale(min2, min2);
                matrix.postTranslate((int) (f8 + 0.5f), (int) (rect.top + ((height - (i2 * min2)) * 0.5f) + 0.5f));
                break;
            case FIT_END:
                float min3 = Math.min(f6, f7);
                float f9 = (width - (i * min3)) + rect.left;
                matrix.setScale(min3, min3);
                matrix.postTranslate((int) (f9 + 0.5f), (int) (rect.top + (height - (i2 * min3)) + 0.5f));
                break;
            case CENTER:
                matrix.setTranslate((int) (((width - i) * 0.5f) + rect.left + 0.5f), (int) (rect.top + ((height - i2) * 0.5f) + 0.5f));
                break;
            case CENTER_INSIDE:
                float min4 = Math.min(Math.min(f6, f7), 1.0f);
                float f10 = ((width - (i * min4)) * 0.5f) + rect.left;
                matrix.setScale(min4, min4);
                matrix.postTranslate((int) (f10 + 0.5f), (int) (rect.top + ((height - (i2 * min4)) * 0.5f) + 0.5f));
                break;
            case CENTER_CROP:
                if (f7 > f6) {
                    f4 = rect.left + ((width - (i * f7)) * 0.5f);
                    f5 = rect.top;
                } else {
                    f4 = rect.left;
                    f5 = rect.top + ((height - (i2 * f6)) * 0.5f);
                    f7 = f6;
                }
                matrix.setScale(f7, f7);
                matrix.postTranslate((int) (f4 + 0.5f), (int) (f5 + 0.5f));
                break;
            case FOCUS_CROP:
                if (f7 > f6) {
                    f3 = rect.left + Math.max(Math.min((width * 0.5f) - ((i * f7) * f), 0.0f), width - (i * f7));
                    max = rect.top;
                } else {
                    f3 = rect.left;
                    max = Math.max(Math.min((height * 0.5f) - ((i2 * f6) * f2), 0.0f), height - (i2 * f6)) + rect.top;
                    f7 = f6;
                }
                matrix.setScale(f7, f7);
                matrix.postTranslate((int) (f3 + 0.5f), (int) (max + 0.5f));
                break;
            default:
                throw new UnsupportedOperationException("Unsupported scale type: " + scaleType);
        }
        return matrix;
    }
}
