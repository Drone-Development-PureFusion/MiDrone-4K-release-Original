package com.autonavi.amap.mapcore.interfaces;

import android.graphics.Typeface;
/* loaded from: classes.dex */
public interface IText extends IOverlayImage {
    int getAlignX();

    int getAlignY();

    int getBackgroundColor();

    int getFontColor();

    int getFontSize();

    String getText();

    Typeface getTypeface();

    void setAlign(int i, int i2);

    void setBackgroundColor(int i);

    void setFontColor(int i);

    void setFontSize(int i);

    void setText(String str);

    void setTypeface(Typeface typeface);
}
