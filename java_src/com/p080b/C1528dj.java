package com.p080b;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.CoordUtil;
import com.amap.api.location.DPoint;
import java.io.File;
import java.math.BigDecimal;
/* renamed from: com.b.dj */
/* loaded from: classes.dex */
public class C1528dj {

    /* renamed from: b */
    private static boolean f5476b = false;

    /* renamed from: a */
    static double f5475a = 3.141592653589793d;

    /* renamed from: a */
    private static double m15688a(double d) {
        return Math.sin(3000.0d * d * (f5475a / 180.0d)) * 2.0E-5d;
    }

    /* renamed from: a */
    public static double m15687a(double d, double d2) {
        return (Math.cos(d2 / 100000.0d) * (d / 18000.0d)) + (Math.sin(d / 100000.0d) * (d2 / 9000.0d));
    }

    /* renamed from: a */
    private static double m15685a(double d, int i) {
        return new BigDecimal(d).setScale(i, 4).doubleValue();
    }

    /* renamed from: a */
    private static DPoint m15686a(double d, double d2, double d3, double d4) {
        DPoint dPoint = new DPoint();
        double d5 = d - d3;
        double d6 = d2 - d4;
        DPoint m15675d = m15675d(d5, d6);
        dPoint.setLongitude(m15685a((d5 + d) - m15675d.getLongitude(), 8));
        dPoint.setLatitude(m15685a((d2 + d6) - m15675d.getLatitude(), 8));
        return dPoint;
    }

    /* renamed from: a */
    public static DPoint m15684a(Context context, double d, double d2) {
        if (context == null) {
            return null;
        }
        return m15683a(context, new DPoint(d2, d));
    }

    /* renamed from: a */
    public static DPoint m15683a(Context context, DPoint dPoint) {
        if (context == null) {
            return null;
        }
        String m15583a = C1547du.m15583a(context, "libwgs2gcj.so");
        if (!TextUtils.isEmpty(m15583a) && new File(m15583a).exists() && !f5476b) {
            try {
                System.load(m15583a);
                f5476b = true;
            } catch (Throwable th) {
                C1514cx.m15728a(th, "OffsetUtil", "offset");
            }
        }
        return m15680a(dPoint, f5476b);
    }

    /* renamed from: a */
    public static DPoint m15682a(DPoint dPoint) {
        if (dPoint != null) {
            try {
                return m15681a(dPoint, 2);
            } catch (Throwable th) {
                C1514cx.m15728a(th, "OffsetUtil", "B2G");
                return dPoint;
            }
        }
        return dPoint;
    }

    /* renamed from: a */
    private static DPoint m15681a(DPoint dPoint, int i) {
        double d = 0.006401062d;
        double d2 = 0.0060424805d;
        int i2 = 0;
        DPoint dPoint2 = null;
        while (i2 < i) {
            DPoint m15686a = m15686a(dPoint.getLongitude(), dPoint.getLatitude(), d, d2);
            d = dPoint.getLongitude() - m15686a.getLongitude();
            d2 = dPoint.getLatitude() - m15686a.getLatitude();
            i2++;
            dPoint2 = m15686a;
        }
        return dPoint2;
    }

    /* renamed from: a */
    private static DPoint m15680a(DPoint dPoint, boolean z) {
        double[] m15972a;
        try {
            double[] dArr = new double[2];
            if (z) {
                if (CoordUtil.convertToGcj(new double[]{dPoint.getLongitude(), dPoint.getLatitude()}, dArr) != 0) {
                    dArr = C1478bt.m15972a(dPoint.getLongitude(), dPoint.getLatitude());
                }
                m15972a = dArr;
            } else {
                m15972a = C1478bt.m15972a(dPoint.getLongitude(), dPoint.getLatitude());
            }
            dPoint = new DPoint(m15972a[1], m15972a[0]);
            return dPoint;
        } catch (Throwable th) {
            C1514cx.m15728a(th, "OffsetUtil", "cover part2");
            return dPoint;
        }
    }

    /* renamed from: b */
    private static double m15679b(double d) {
        return Math.cos(3000.0d * d * (f5475a / 180.0d)) * 3.0E-6d;
    }

    /* renamed from: b */
    public static double m15678b(double d, double d2) {
        return (Math.sin(d2 / 100000.0d) * (d / 18000.0d)) + (Math.cos(d / 100000.0d) * (d2 / 9000.0d));
    }

    /* renamed from: b */
    public static DPoint m15677b(Context context, DPoint dPoint) {
        try {
            return m15683a(context, m15676c(dPoint.getLongitude(), dPoint.getLatitude()));
        } catch (Throwable th) {
            C1514cx.m15728a(th, "OffsetUtil", "marbar2G");
            return dPoint;
        }
    }

    /* renamed from: c */
    private static DPoint m15676c(double d, double d2) {
        int i;
        int i2;
        double d3 = ((long) (100000.0d * d)) % 36000000;
        double d4 = ((long) (100000.0d * d2)) % 36000000;
        return new DPoint(((int) ((d4 > 0.0d ? 1 : -1) + ((-m15678b(i2, i)) + d4))) / 100000.0d, ((int) ((d3 > 0.0d ? 1 : -1) + ((-m15687a((int) ((-m15687a(d3, d4)) + d3), (int) ((-m15678b(d3, d4)) + d4))) + d3))) / 100000.0d);
    }

    /* renamed from: d */
    private static DPoint m15675d(double d, double d2) {
        DPoint dPoint = new DPoint();
        dPoint.setLongitude(m15685a((Math.cos(m15679b(d) + Math.atan2(d2, d)) * (m15688a(d2) + Math.sqrt((d * d) + (d2 * d2)))) + 0.0065d, 8));
        dPoint.setLatitude(m15685a((Math.sin(m15679b(d) + Math.atan2(d2, d)) * (m15688a(d2) + Math.sqrt((d * d) + (d2 * d2)))) + 0.006d, 8));
        return dPoint;
    }
}
