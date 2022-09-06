package com.p080b;

import android.text.TextUtils;
import com.p080b.AbstractC1445ax;
import java.util.Locale;
/* renamed from: com.b.ay */
/* loaded from: classes.dex */
public class C1448ay {

    /* renamed from: a */
    private static final char[] f5014a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* renamed from: b */
    private static final int[] f5015b = {16, 8, 4, 2, 1};

    private C1448ay() {
    }

    /* renamed from: a */
    public static final String m16213a(double d, double d2) {
        return m16212a(d, d2, 6);
    }

    /* renamed from: a */
    public static final String m16212a(double d, double d2, int i) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        int i2 = 0;
        int i3 = 0;
        double[] dArr = {-90.0d, 90.0d};
        double[] dArr2 = {-180.0d, 180.0d};
        while (sb.length() < i) {
            if (z) {
                double d3 = (dArr2[0] + dArr2[1]) / 2.0d;
                if (d2 > d3) {
                    i3 |= f5015b[i2];
                    dArr2[0] = d3;
                } else {
                    dArr2[1] = d3;
                }
            } else {
                double d4 = (dArr[0] + dArr[1]) / 2.0d;
                if (d > d4) {
                    i3 |= f5015b[i2];
                    dArr[0] = d4;
                } else {
                    dArr[1] = d4;
                }
            }
            z = !z;
            if (i2 < 4) {
                i2++;
            } else {
                sb.append(f5014a[i3]);
                i2 = 0;
                i3 = 0;
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static final String m16210a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String lowerCase = str.toLowerCase(Locale.US);
            char charAt = lowerCase.charAt(lowerCase.length() - 1);
            String str3 = lowerCase.length() % 2 == 0 ? "odd" : "even";
            String substring = lowerCase.substring(0, lowerCase.length() - 1);
            if (AbstractC1445ax.C1446a.f5012a.get(str2).get(str3).indexOf(charAt) != -1 && !TextUtils.isEmpty(substring)) {
                substring = m16210a(substring, str2);
            }
            return substring + f5014a[AbstractC1445ax.C1447b.f5013a.get(str2).get(str3).indexOf(charAt)];
        }
        return null;
    }

    /* renamed from: a */
    public static final String[] m16211a(String str) {
        String[] strArr = {m16210a(str, "right"), m16210a(str, "btm"), m16210a(str, "left"), m16210a(str, "top"), m16210a(strArr[0], "top"), m16210a(strArr[0], "btm"), m16210a(strArr[2], "top"), m16210a(strArr[2], "btm"), m16210a(strArr[0], "right"), m16210a(strArr[8], "top"), m16210a(strArr[9], "top"), m16210a(strArr[10], "left"), m16210a(strArr[11], "left"), m16210a(strArr[12], "left"), m16210a(strArr[13], "left"), m16210a(strArr[14], "btm"), m16210a(strArr[15], "btm"), m16210a(strArr[16], "btm"), m16210a(strArr[17], "btm"), m16210a(strArr[18], "right"), m16210a(strArr[19], "right"), m16210a(strArr[20], "right"), m16210a(strArr[21], "right"), m16210a(strArr[22], "top")};
        return strArr;
    }
}
