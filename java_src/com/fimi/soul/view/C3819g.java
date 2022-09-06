package com.fimi.soul.view;

import android.graphics.Point;
/* renamed from: com.fimi.soul.view.g */
/* loaded from: classes.dex */
class C3819g {
    C3819g() {
    }

    /* renamed from: a */
    public static double m6955a(float f, float f2, int i, int i2) {
        int abs = Math.abs((int) (f - i));
        int abs2 = Math.abs((int) (f2 - i2));
        return Math.round((float) ((Math.asin(abs2 / Math.sqrt((abs * abs) + (abs2 * abs2))) / 3.141592653589793d) * 180.0d));
    }

    /* renamed from: a */
    public static float m6954a(Point point, Point point2) {
        float f = point2.x - point.x;
        float f2 = point2.y - point.y;
        return (point2.y < point.y ? -1 : 1) * ((float) Math.acos(f / ((float) Math.sqrt((f2 * f2) + (f * f)))));
    }

    /* renamed from: a */
    public static int m6956a(float f, float f2, float f3, float f4) {
        return (int) Math.sqrt(Math.pow(f - f3, 2.0d) + Math.pow(f2 - f4, 2.0d));
    }

    /* renamed from: a */
    public static Point m6953a(Point point, Point point2, int i) {
        float m6954a = m6954a(point, point2);
        return new Point(point.x + ((int) (i * Math.cos(m6954a))), ((int) (i * Math.sin(m6954a))) + point.x);
    }
}
