package com.fimi.kernel.utils;

import com.xiaomi.mipush.sdk.Constants;
import java.text.DecimalFormat;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.fimi.kernel.utils.t */
/* loaded from: classes.dex */
public class C2275t {
    /* renamed from: a */
    private static byte m12794a(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /* renamed from: a */
    public static double m12793a(double d, int i) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i == 1) {
            d = Double.valueOf(new DecimalFormat("0.0").format(d).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, ".")).doubleValue();
        } else if (i != 2) {
            if (i == 7) {
                d = Double.valueOf(new DecimalFormat("0.0000000").format(d).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, ".")).doubleValue();
            }
            return d;
        } else {
            d = Double.valueOf(new DecimalFormat("0.00").format(d).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, ".")).doubleValue();
        }
        return d;
    }

    /* renamed from: a */
    public static String m12791a(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static byte[] m12792a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (m12794a(charArray[i2 + 1]) | (m12794a(charArray[i2]) << 4));
        }
        return bArr;
    }

    /* renamed from: b */
    public static String m12790b(double d, int i) {
        try {
            return i == 1 ? new DecimalFormat("0.0").format(d).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, ".") : i == 2 ? new DecimalFormat("0.00").format(d).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, ".") : i == 7 ? new DecimalFormat("0.0000000").format(d).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, ".") : d + "";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }
}
