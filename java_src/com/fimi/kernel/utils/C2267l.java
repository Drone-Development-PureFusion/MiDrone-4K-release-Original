package com.fimi.kernel.utils;

import com.fimi.kernel.p156a.C2173a;
import com.fimi.kernel.p156a.C2177e;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.codehaus.jackson.smile.SmileConstants;
import org.p248a.p249a.p261f.p264c.C5122l;
/* renamed from: com.fimi.kernel.utils.l */
/* loaded from: classes.dex */
public class C2267l {
    /* renamed from: a */
    public static char m12924a(int i) {
        switch (i) {
            case 0:
                return '0';
            case 1:
                return '1';
            case 2:
                return '2';
            case 3:
                return '3';
            case 4:
                return '4';
            case 5:
                return '5';
            case 6:
                return '6';
            case 7:
                return '7';
            case 8:
                return '8';
            case 9:
                return '9';
            case 10:
                return 'a';
            case 11:
                return 'b';
            case 12:
                return 'c';
            case 13:
                return 'd';
            case 14:
                return 'e';
            case 15:
                return 'f';
            default:
                return C5122l.f21763c;
        }
    }

    /* renamed from: a */
    public static double m12931a(double d, double d2) {
        return Math.log(d) / Math.log(d2);
    }

    /* renamed from: a */
    public static double m12930a(double d, double d2, double d3, double d4) {
        double d5 = d - d3;
        double d6 = d2 - d4;
        return Math.sqrt((d5 * d5) + (d6 * d6));
    }

    /* renamed from: a */
    public static double m12919a(C2177e c2177e, C2177e c2177e2) {
        return m12930a(c2177e.f7311a, c2177e.f7312b, c2177e2.f7311a, c2177e2.f7312b);
    }

    /* renamed from: a */
    public static int m12917a(double[] dArr) {
        float f = 0.0f;
        for (double d : dArr) {
            f = (float) (f + d);
        }
        return (int) (f / dArr.length);
    }

    /* renamed from: a */
    public static String m12918a(byte[] bArr, int i) {
        String str = "";
        int i2 = 0;
        while (i2 < i) {
            String hexString = Integer.toHexString(bArr[i2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            i2++;
            str = (hexString.length() == 1 ? str + "0" + hexString : str + hexString) + Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        return str.toUpperCase();
    }

    /* renamed from: a */
    public static BigDecimal m12926a(double d, int i) {
        return new BigDecimal(d).setScale(i, 4);
    }

    /* renamed from: a */
    public static List<C2177e> m12923a(C2173a c2173a, C2173a c2173a2) {
        ArrayList arrayList = new ArrayList();
        double d = c2173a.f7293b * 2.0d * (c2173a.f7292a.f7311a - c2173a2.f7292a.f7311a);
        double d2 = c2173a.f7293b * 2.0d * (c2173a.f7292a.f7312b - c2173a2.f7292a.f7312b);
        double pow = ((Math.pow(c2173a2.f7293b, 2.0d) - Math.pow(c2173a.f7293b, 2.0d)) - Math.pow(c2173a.f7292a.f7311a - c2173a2.f7292a.f7311a, 2.0d)) - Math.pow(c2173a.f7292a.f7312b - c2173a2.f7292a.f7312b, 2.0d);
        double pow2 = Math.pow(d, 2.0d) + Math.pow(d2, 2.0d);
        double d3 = d * (-2.0d) * pow;
        double pow3 = Math.pow(d3, 2.0d) - ((Math.pow(pow, 2.0d) - Math.pow(d2, 2.0d)) * (4.0d * pow2));
        double d4 = ((-Math.sqrt(pow3)) - d3) / (2.0d * pow2);
        double sqrt = (c2173a.f7293b * ((Math.sqrt(pow3) - d3) / (2.0d * pow2))) + c2173a.f7292a.f7311a;
        double sqrt2 = Math.sqrt(Math.pow(c2173a.f7293b, 2.0d) - Math.pow(sqrt - c2173a.f7292a.f7311a, 2.0d)) + c2173a.f7292a.f7312b;
        double d5 = (-Math.sqrt(Math.pow(c2173a.f7293b, 2.0d) - Math.pow(sqrt - c2173a.f7292a.f7311a, 2.0d))) + c2173a.f7292a.f7312b;
        HashSet<C2177e> hashSet = new HashSet();
        C2177e c2177e = new C2177e(sqrt, sqrt2);
        if (m12921a(c2177e, c2173a, c2173a2)) {
            hashSet.add(c2177e);
        }
        C2177e c2177e2 = new C2177e(sqrt, d5);
        if (m12921a(c2177e2, c2173a, c2173a2)) {
            hashSet.add(c2177e2);
        }
        double d6 = (d4 * c2173a.f7293b) + c2173a.f7292a.f7311a;
        double sqrt3 = Math.sqrt(Math.pow(c2173a.f7293b, 2.0d) - Math.pow(d6 - c2173a.f7292a.f7311a, 2.0d)) + c2173a.f7292a.f7312b;
        double d7 = (-Math.sqrt(Math.pow(c2173a.f7293b, 2.0d) - Math.pow(d6 - c2173a.f7292a.f7311a, 2.0d))) + c2173a.f7292a.f7312b;
        C2177e c2177e3 = new C2177e(d6, sqrt3);
        if (m12921a(c2177e3, c2173a, c2173a2)) {
            hashSet.add(c2177e3);
        }
        C2177e c2177e4 = new C2177e(d6, d7);
        if (m12921a(c2177e4, c2173a, c2173a2)) {
            hashSet.add(c2177e4);
        }
        for (C2177e c2177e5 : hashSet) {
            arrayList.add(c2177e5);
        }
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m12928a(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        if (d < Math.min(d4, d6) || d > Math.max(d4, d6) || d2 < Math.min(d5, d7) || d2 > Math.max(d5, d7)) {
            return false;
        }
        return d3 <= Math.abs(d - d4) && d3 <= Math.abs(d2 - d7) && d3 <= Math.abs(d - d6) && d3 <= Math.abs(d2 - d7);
    }

    /* renamed from: a */
    public static boolean m12927a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        if ((d4 - d2) / (d3 - d) == (d8 - d6) / (d7 - d5)) {
            return false;
        }
        double d9 = (((d * d4) - (d2 * d3)) - ((((((d * d4) - (d2 * d3)) * (d5 - d7)) - (((d5 * d8) - (d6 * d7)) * (d - d3))) / (((d4 - d2) * (d5 - d7)) - ((d8 - d6) * (d - d3)))) * (d4 - d2))) / (d - d3);
        return true;
    }

    /* renamed from: a */
    public static boolean m12925a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (f5 <= f || f5 <= f + f3) {
            if (f5 < f && f5 < f - f7) {
                return false;
            }
            if (f6 > f2 && f6 > f2 + f4) {
                return false;
            }
            return f6 >= f2 || f6 >= f2 - f8;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m12922a(C2177e c2177e, C2173a c2173a) {
        return Math.pow(c2177e.f7311a - c2173a.f7292a.f7311a, 2.0d) + Math.pow(c2177e.f7312b - c2173a.f7292a.f7312b, 2.0d) <= Math.pow(c2173a.f7293b, 2.0d);
    }

    /* renamed from: a */
    public static boolean m12921a(C2177e c2177e, C2173a c2173a, C2173a c2173a2) {
        return Math.pow(c2177e.f7311a - c2173a2.f7292a.f7311a, 2.0d) + Math.pow(c2177e.f7312b - c2173a2.f7292a.f7312b, 2.0d) == Math.pow(c2173a2.f7293b, 2.0d) && Math.pow(c2177e.f7311a - c2173a.f7292a.f7311a, 2.0d) + Math.pow(c2177e.f7312b - c2173a.f7292a.f7312b, 2.0d) == Math.pow(c2173a.f7293b, 2.0d);
    }

    /* renamed from: a */
    public static boolean m12920a(C2177e c2177e, C2173a c2173a, C2173a c2173a2, float f) {
        return Math.pow(c2177e.f7311a - c2173a2.f7292a.f7311a, 2.0d) + Math.pow(c2177e.f7312b - c2173a2.f7292a.f7312b, 2.0d) <= Math.pow(c2173a2.f7293b, 2.0d) + ((double) f) && Math.pow(c2177e.f7311a - c2173a2.f7292a.f7311a, 2.0d) + Math.pow(c2177e.f7312b - c2173a2.f7292a.f7312b, 2.0d) >= Math.pow(c2173a2.f7293b, 2.0d) - ((double) f) && Math.pow(c2177e.f7311a - c2173a.f7292a.f7311a, 2.0d) + Math.pow(c2177e.f7312b - c2173a.f7292a.f7312b, 2.0d) <= Math.pow(c2173a.f7293b, 2.0d) + ((double) f) && Math.pow(c2177e.f7311a - c2173a.f7292a.f7311a, 2.0d) + Math.pow(c2177e.f7312b - c2173a.f7292a.f7312b, 2.0d) >= Math.pow(c2173a.f7293b, 2.0d) - ((double) f);
    }

    /* renamed from: a */
    public static double[] m12916a(int[] iArr) {
        int length = iArr.length;
        double[] dArr = new double[length];
        for (int i = 0; i < length; i++) {
            dArr[i] = Double.valueOf(String.valueOf(iArr[i])).doubleValue();
        }
        return dArr;
    }

    /* renamed from: a */
    public static double[] m12914a(double[][] dArr) {
        double[] dArr2 = new double[dArr.length * dArr[0].length];
        for (int i = 0; i < dArr.length; i++) {
            for (int i2 = 0; i2 < dArr[i].length; i2++) {
                dArr2[(dArr.length * i2) + i] = dArr[i][i2];
            }
        }
        return dArr2;
    }

    /* renamed from: a */
    public static double[][] m12913a(int[][] iArr) {
        int length = iArr.length;
        int length2 = iArr[0].length;
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, length, length2);
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < length2; i2++) {
                dArr[i][i2] = Double.valueOf(String.valueOf(iArr[i][i2])).doubleValue();
            }
        }
        return dArr;
    }

    /* renamed from: a */
    public static int[][] m12915a(int[] iArr, int i, int i2) {
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, i2, i);
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                iArr2[i3][i4] = iArr[(i4 * i2) + i3];
            }
        }
        return iArr2;
    }

    /* renamed from: b */
    public static int m12910b(int[] iArr) {
        float f = 0.0f;
        for (int i : iArr) {
            f += i;
        }
        return (int) (f / iArr.length);
    }

    /* renamed from: b */
    public static boolean m12912b(double d, double d2, double d3, double d4, double d5, double d6) {
        return ((d - d3) * (d6 - d4)) - ((d2 - d4) * (d5 - d3)) == 0.0d && d >= Math.min(d3, d5) && d <= Math.max(d3, d5) && d2 >= Math.min(d4, d6) && d2 <= Math.max(d4, d6);
    }

    /* renamed from: b */
    public static boolean m12911b(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        if ((d4 - d2) / (d3 - d) == (d8 - d6) / (d7 - d5)) {
            return false;
        }
        double d9 = ((((d * d4) - (d2 * d3)) * (d5 - d7)) - (((d5 * d8) - (d6 * d7)) * (d - d3))) / (((d4 - d2) * (d5 - d7)) - ((d8 - d6) * (d - d3)));
        double d10 = (((d * d4) - (d2 * d3)) - ((d4 - d2) * d9)) / (d - d3);
        return d9 >= Math.min(d, d3) && d9 <= Math.max(d, d3) && d10 >= Math.min(d2, d4) && d10 <= Math.max(d2, d4) && d9 >= Math.min(d5, d7) && d9 <= Math.max(d5, d7) && d10 >= Math.min(d6, d8) && d10 <= Math.max(d6, d8);
    }

    /* renamed from: c */
    public static boolean m12909c(double d, double d2, double d3, double d4, double d5, double d6) {
        return d >= Math.min(d3, d5) && d <= Math.max(d3, d5) && d2 >= Math.min(d4, d6) && d2 <= Math.max(d4, d6);
    }

    /* renamed from: c */
    public static boolean m12908c(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        if ((d4 - d2) / (d3 - d) == (d8 - d6) / (d7 - d5)) {
            return false;
        }
        double d9 = ((((d * d4) - (d2 * d3)) * (d5 - d7)) - (((d5 * d8) - (d6 * d7)) * (d - d3))) / (((d4 - d2) * (d5 - d7)) - ((d8 - d6) * (d - d3)));
        double d10 = (((d * d4) - (d2 * d3)) - ((d4 - d2) * d9)) / (d - d3);
        return d9 >= Math.min(d, d3) && d9 <= Math.max(d, d3) && d10 >= Math.min(d2, d4) && d10 <= Math.max(d2, d4);
    }

    /* renamed from: d */
    public static boolean m12907d(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        return d >= Math.min(d5, d7) && d <= Math.max(d5, d7) && d2 >= Math.min(d6, d8) && d2 <= Math.max(d6, d8) && d3 >= Math.min(d5, d7) && d3 <= Math.max(d5, d7) && d4 >= Math.min(d6, d8) && d4 <= Math.max(d6, d8);
    }

    /* renamed from: a */
    public boolean m12929a(double d, double d2, double d3, double d4, double d5, double d6) {
        return ((d - d3) * (d6 - d4)) - ((d2 - d4) * (d5 - d3)) == 0.0d;
    }
}
