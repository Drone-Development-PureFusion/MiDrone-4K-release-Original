package com.fimi.soul.utils;
/* renamed from: com.fimi.soul.utils.ac */
/* loaded from: classes.dex */
public class C3633ac {

    /* renamed from: a */
    static final double f14786a = 3.141592653589793d;

    /* renamed from: b */
    static final double f14787b = 6378245.0d;

    /* renamed from: c */
    static final double f14788c = 0.006693421622965943d;

    /* renamed from: a */
    static double m7724a(double d, double d2, double d3, double d4) {
        double cos = ((float) (d - d3)) * ((float) Math.cos((float) (Math.abs(d2) * 0.0174532925d)));
        double d5 = (float) (d2 - d4);
        return Math.sqrt(((d5 * 1.0E7d * 1.0E7d * d5) + (cos * 1.0E7d * 1.0E7d * cos)) * 1.2392029762268066d);
    }

    /* renamed from: a */
    public static C3639ai m7726a(double d, double d2) {
        C3639ai c3639ai = new C3639ai();
        double m7720d = m7720d(d2 - 105.0d, d - 35.0d);
        double m7719e = m7719e(d2 - 105.0d, d - 35.0d);
        double d3 = (d / 180.0d) * f14786a;
        double sin = Math.sin(d3);
        double d4 = 1.0d - (sin * (f14788c * sin));
        double sqrt = Math.sqrt(d4);
        double d5 = (m7720d * 180.0d) / ((6335552.717000426d / (d4 * sqrt)) * f14786a);
        double d6 = f14787b / sqrt;
        c3639ai.m7701a(d5 + d);
        c3639ai.m7699b(((m7719e * 180.0d) / ((Math.cos(d3) * d6) * f14786a)) + d2);
        return c3639ai;
    }

    /* renamed from: a */
    public static C3639ai m7725a(double d, double d2, double d3) {
        new C3639ai();
        C3639ai c3639ai = new C3639ai();
        C3639ai c3639ai2 = new C3639ai();
        c3639ai.m7701a(d2);
        c3639ai.m7699b(d3);
        C3639ai m7722b = m7722b(c3639ai.m7702a(), c3639ai.m7700b());
        C3639ai m7726a = m7726a(m7722b.m7702a(), m7722b.m7700b());
        while (true) {
            c3639ai2.m7699b((d3 - m7726a.m7700b()) + m7722b.m7700b());
            c3639ai2.m7701a((d2 - m7726a.m7702a()) + m7722b.m7702a());
            m7722b.m7699b(c3639ai2.m7700b());
            m7722b.m7701a(c3639ai2.m7702a());
            C3639ai m7726a2 = m7726a(m7722b.m7702a(), m7722b.m7700b());
            if (d >= m7724a(d3, d2, m7726a2.m7700b(), m7726a2.m7702a())) {
                return c3639ai2;
            }
            m7726a = m7726a2;
        }
    }

    /* renamed from: a */
    public static void m7723a(double d, double d2, double[] dArr) {
        if (m7721c(d, d2)) {
            dArr[0] = d;
            dArr[1] = d2;
            return;
        }
        double m7720d = m7720d(d2 - 105.0d, d - 35.0d);
        double m7719e = m7719e(d2 - 105.0d, d - 35.0d);
        double d3 = (d / 180.0d) * f14786a;
        double sin = Math.sin(d3);
        double d4 = 1.0d - (sin * (f14788c * sin));
        double sqrt = Math.sqrt(d4);
        double d5 = (m7720d * 180.0d) / ((6335552.717000426d / (d4 * sqrt)) * f14786a);
        double d6 = f14787b / sqrt;
        dArr[0] = d5 + d;
        dArr[1] = ((m7719e * 180.0d) / ((Math.cos(d3) * d6) * f14786a)) + d2;
    }

    /* renamed from: b */
    public static C3639ai m7722b(double d, double d2) {
        C3639ai c3639ai = new C3639ai();
        double m7720d = m7720d(d2 - 105.0d, d - 35.0d);
        double m7719e = m7719e(d2 - 105.0d, d - 35.0d);
        double d3 = (d / 180.0d) * f14786a;
        double sin = Math.sin(d3);
        double d4 = 1.0d - (sin * (f14788c * sin));
        double sqrt = Math.sqrt(d4);
        double d5 = (m7720d * 180.0d) / ((6335552.717000426d / (d4 * sqrt)) * f14786a);
        double d6 = f14787b / sqrt;
        c3639ai.m7701a(d - d5);
        c3639ai.m7699b(d2 - ((m7719e * 180.0d) / ((Math.cos(d3) * d6) * f14786a)));
        return c3639ai;
    }

    /* renamed from: c */
    private static boolean m7721c(double d, double d2) {
        return d2 < 72.004d || d2 > 137.8347d || d < 0.8293d || d > 55.8271d;
    }

    /* renamed from: d */
    private static double m7720d(double d, double d2) {
        return (-100.0d) + (2.0d * d) + (3.0d * d2) + (0.2d * d2 * d2) + (0.1d * d * d2) + (0.2d * Math.sqrt(Math.abs(d))) + ((((20.0d * Math.sin((6.0d * d) * f14786a)) + (20.0d * Math.sin((2.0d * d) * f14786a))) * 2.0d) / 3.0d) + ((((20.0d * Math.sin(f14786a * d2)) + (40.0d * Math.sin((d2 / 3.0d) * f14786a))) * 2.0d) / 3.0d) + ((((160.0d * Math.sin((d2 / 12.0d) * f14786a)) + (320.0d * Math.sin((f14786a * d2) / 30.0d))) * 2.0d) / 3.0d);
    }

    /* renamed from: e */
    private static double m7719e(double d, double d2) {
        return 300.0d + d + (2.0d * d2) + (0.1d * d * d) + (0.1d * d * d2) + (0.1d * Math.sqrt(Math.abs(d))) + ((((20.0d * Math.sin((6.0d * d) * f14786a)) + (20.0d * Math.sin((2.0d * d) * f14786a))) * 2.0d) / 3.0d) + ((((20.0d * Math.sin(f14786a * d)) + (40.0d * Math.sin((d / 3.0d) * f14786a))) * 2.0d) / 3.0d) + ((((150.0d * Math.sin((d / 12.0d) * f14786a)) + (300.0d * Math.sin((d / 30.0d) * f14786a))) * 2.0d) / 3.0d);
    }
}
