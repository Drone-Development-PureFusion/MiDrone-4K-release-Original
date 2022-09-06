package com.fimi.kernel.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.TextPaint;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.kernel.utils.h */
/* loaded from: classes.dex */
public final class C2261h {
    /* renamed from: a */
    public static float m12969a(TextPaint textPaint) {
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        return (float) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    /* renamed from: a */
    public static float m12967a(String str, TextPaint textPaint) {
        return textPaint.measureText(str);
    }

    /* renamed from: a */
    public static int m12970a(Canvas canvas, String str, int i, TextPaint textPaint, int i2, int i3) {
        if (C2269n.m12889b(str)) {
            return 1;
        }
        List<String> m12966b = m12966b(str, i, textPaint);
        int m12969a = (int) m12969a(textPaint);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= m12966b.size()) {
                return m12966b.size();
            }
            canvas.drawText(m12966b.get(i5), i2, (m12969a * i5) + (m12969a / 2) + i3, textPaint);
            i4 = i5 + 1;
        }
    }

    /* renamed from: a */
    public static int m12968a(String str, int i, TextPaint textPaint) {
        if (C2269n.m12889b(str)) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= str.length()) {
                i2 = 0;
                break;
            }
            float measureText = textPaint.measureText(str.substring(0, i2 + 1));
            if (measureText <= i) {
                if (measureText == i) {
                    break;
                }
                i2++;
            } else {
                i2--;
                break;
            }
        }
        if (i2 == 0) {
            i2 = str.length() - 1;
        }
        return i2;
    }

    /* renamed from: b */
    public static float m12965b(String str, TextPaint textPaint) {
        return Layout.getDesiredWidth(str, textPaint);
    }

    /* renamed from: b */
    public static List<String> m12966b(String str, int i, TextPaint textPaint) {
        String[] split = str.indexOf("\n") != -1 ? str.split("\n") : new String[]{str};
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            while (true) {
                int m12968a = m12968a(str2, i, textPaint);
                if (m12968a <= 0) {
                    arrayList.add(str2);
                } else if (m12968a == str2.length() - 1) {
                    arrayList.add(str2);
                } else {
                    arrayList.add(str2.substring(0, m12968a + 1));
                }
                if (str2.length() > m12968a + 1) {
                    str2 = str2.substring(m12968a + 1);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public static int m12964c(String str, int i, TextPaint textPaint) {
        String[] split = str.indexOf("\n") != -1 ? str.split("\n") : new String[]{str};
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            while (true) {
                int m12968a = m12968a(str2, i, textPaint);
                if (m12968a <= 0) {
                    arrayList.add(str2);
                } else if (m12968a == str2.length() - 1) {
                    arrayList.add(str2);
                } else {
                    arrayList.add(str2.substring(0, m12968a + 1));
                }
                if (str2.length() > m12968a + 1) {
                    str2 = str2.substring(m12968a + 1);
                }
            }
        }
        return arrayList.size();
    }
}
