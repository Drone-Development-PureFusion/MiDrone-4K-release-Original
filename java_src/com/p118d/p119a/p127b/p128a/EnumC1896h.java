package com.p118d.p119a.p127b.p128a;

import android.widget.ImageView;
/* renamed from: com.d.a.b.a.h */
/* loaded from: classes.dex */
public enum EnumC1896h {
    FIT_INSIDE,
    CROP;

    /* renamed from: com.d.a.b.a.h$1 */
    /* loaded from: classes.dex */
    static /* synthetic */ class C18971 {

        /* renamed from: a */
        static final /* synthetic */ int[] f6683a = new int[ImageView.ScaleType.values().length];

        static {
            try {
                f6683a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6683a[ImageView.ScaleType.FIT_XY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6683a[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6683a[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6683a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f6683a[ImageView.ScaleType.MATRIX.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f6683a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f6683a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* renamed from: a */
    public static EnumC1896h m14149a(ImageView imageView) {
        switch (C18971.f6683a[imageView.getScaleType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return FIT_INSIDE;
            default:
                return CROP;
        }
    }
}
