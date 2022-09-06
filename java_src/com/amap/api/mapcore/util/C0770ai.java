package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.CoordUtil;
import com.autonavi.amap.mapcore.DPoint;
import java.io.File;
import java.math.BigDecimal;
/* renamed from: com.amap.api.mapcore.util.ai */
/* loaded from: classes.dex */
public class C0770ai {

    /* renamed from: b */
    private static boolean f2051b = false;

    /* renamed from: a */
    static double f2050a = 3.141592653589793d;

    /* renamed from: a */
    private static double m19089a(double d) {
        return Math.sin(3000.0d * d * (f2050a / 180.0d)) * 2.0E-5d;
    }

    /* renamed from: a */
    public static double m19088a(double d, double d2) {
        return (Math.cos(d2 / 100000.0d) * (d / 18000.0d)) + (Math.sin(d / 100000.0d) * (d2 / 9000.0d));
    }

    /* renamed from: a */
    private static double m19086a(double d, int i) {
        return new BigDecimal(d).setScale(i, 4).doubleValue();
    }

    /* renamed from: a */
    public static LatLng m19085a(Context context, LatLng latLng) {
        if (context == null) {
            return null;
        }
        String m18077a = C0994fg.m18077a(context, "libwgs2gcj.so");
        if (!TextUtils.isEmpty(m18077a) && new File(m18077a).exists() && !f2051b) {
            try {
                System.load(m18077a);
                f2051b = true;
            } catch (Throwable th) {
            }
        }
        DPoint m19082a = m19082a(new DPoint(latLng.longitude, latLng.latitude), f2051b);
        return new LatLng(m19082a.f4727y, m19082a.f4726x, false);
    }

    /* renamed from: a */
    public static LatLng m19084a(LatLng latLng) {
        if (latLng != null) {
            try {
                DPoint m19083a = m19083a(new DPoint(latLng.longitude, latLng.latitude), 2);
                return new LatLng(m19083a.f4727y, m19083a.f4726x, false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return latLng;
    }

    /* renamed from: a */
    private static DPoint m19087a(double d, double d2, double d3, double d4) {
        DPoint dPoint = new DPoint();
        double d5 = d - d3;
        double d6 = d2 - d4;
        DPoint m19077d = m19077d(d5, d6);
        dPoint.f4726x = m19086a((d5 + d) - m19077d.f4726x, 8);
        dPoint.f4727y = m19086a((d2 + d6) - m19077d.f4727y, 8);
        return dPoint;
    }

    /* renamed from: a */
    private static DPoint m19083a(DPoint dPoint, int i) {
        double d = 0.006401062d;
        double d2 = 0.0060424805d;
        int i2 = 0;
        DPoint dPoint2 = null;
        while (i2 < i) {
            DPoint m19087a = m19087a(dPoint.f4726x, dPoint.f4727y, d, d2);
            d = dPoint.f4726x - m19087a.f4726x;
            d2 = dPoint.f4727y - m19087a.f4727y;
            i2++;
            dPoint2 = m19087a;
        }
        return dPoint2;
    }

    /* renamed from: a */
    private static DPoint m19082a(DPoint dPoint, boolean z) {
        double[] m17653a;
        try {
            double[] dArr = new double[2];
            if (z) {
                if (CoordUtil.convertToGcj(new double[]{dPoint.f4726x, dPoint.f4727y}, dArr) != 0) {
                    dArr = C1088hn.m17653a(dPoint.f4726x, dPoint.f4727y);
                }
                m17653a = dArr;
            } else {
                m17653a = C1088hn.m17653a(dPoint.f4726x, dPoint.f4727y);
            }
            dPoint = new DPoint(m17653a[0], m17653a[1]);
            return dPoint;
        } catch (Throwable th) {
            return dPoint;
        }
    }

    /* renamed from: b */
    private static double m19081b(double d) {
        return Math.cos(3000.0d * d * (f2050a / 180.0d)) * 3.0E-6d;
    }

    /* renamed from: b */
    public static double m19080b(double d, double d2) {
        return (Math.sin(d2 / 100000.0d) * (d / 18000.0d)) + (Math.cos(d / 100000.0d) * (d2 / 9000.0d));
    }

    /* renamed from: b */
    public static LatLng m19079b(Context context, LatLng latLng) {
        try {
            DPoint m19078c = m19078c(latLng.longitude, latLng.latitude);
            return m19085a(context, new LatLng(m19078c.f4727y, m19078c.f4726x, false));
        } catch (Throwable th) {
            th.printStackTrace();
            return latLng;
        }
    }

    /* renamed from: c */
    private static DPoint m19078c(double d, double d2) {
        int i;
        int i2;
        double d3 = ((long) (100000.0d * d)) % 36000000;
        double d4 = ((long) (100000.0d * d2)) % 36000000;
        return new DPoint(((int) ((d3 > 0.0d ? 1 : -1) + ((-m19088a((int) ((-m19088a(d3, d4)) + d3), (int) ((-m19080b(d3, d4)) + d4))) + d3))) / 100000.0d, ((int) ((d4 > 0.0d ? 1 : -1) + ((-m19080b(i2, i)) + d4))) / 100000.0d);
    }

    /* renamed from: d */
    private static DPoint m19077d(double d, double d2) {
        DPoint dPoint = new DPoint();
        dPoint.f4726x = m19086a((Math.cos(m19081b(d) + Math.atan2(d2, d)) * (m19089a(d2) + Math.sqrt((d * d) + (d2 * d2)))) + 0.0065d, 8);
        dPoint.f4727y = m19086a((Math.sin(m19081b(d) + Math.atan2(d2, d)) * (m19089a(d2) + Math.sqrt((d * d) + (d2 * d2)))) + 0.006d, 8);
        return dPoint;
    }
}
