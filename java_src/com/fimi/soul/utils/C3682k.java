package com.fimi.soul.utils;
/* renamed from: com.fimi.soul.utils.k */
/* loaded from: classes.dex */
public class C3682k {
    /* renamed from: a */
    private static double m7455a(double d) {
        return (3.141592653589793d * d) / 180.0d;
    }

    /* renamed from: a */
    public static double m7454a(double d, double d2, double d3, double d4) {
        if (d == d3 && d2 == d4) {
            return 0.0d;
        }
        return m7453a(d, d2, d3, d4, 'K');
    }

    /* renamed from: a */
    public static double m7453a(double d, double d2, double d3, double d4, char c) {
        double m7452b = m7452b(Math.acos((Math.cos(m7455a(d2 - d4)) * Math.cos(m7455a(d)) * Math.cos(m7455a(d3))) + (Math.sin(m7455a(d)) * Math.sin(m7455a(d3))))) * 60.0d * 1.1515d;
        return c == 'K' ? m7452b * 1.609344d : c == 'N' ? m7452b * 0.8684d : m7452b;
    }

    /* renamed from: b */
    private static double m7452b(double d) {
        return (180.0d * d) / 3.141592653589793d;
    }
}
