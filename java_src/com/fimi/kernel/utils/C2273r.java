package com.fimi.kernel.utils;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
/* renamed from: com.fimi.kernel.utils.r */
/* loaded from: classes.dex */
public class C2273r {

    /* renamed from: a */
    private static final String f7551a = "0123456789ABCDEF";

    /* renamed from: a */
    public static String m12840a(String str, String str2) {
        try {
            return new String(m12835b(m12841a(str), str2));
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    /* renamed from: a */
    private static String m12838a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            m12839a(stringBuffer, b);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static void m12839a(StringBuffer stringBuffer, byte b) {
        stringBuffer.append(f7551a.charAt((b >> 4) & 15)).append(f7551a.charAt(b & 15));
    }

    /* renamed from: a */
    private static byte[] m12841a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = Integer.valueOf(str.substring(i * 2, (i * 2) + 2), 16).byteValue();
        }
        return bArr;
    }

    /* renamed from: a */
    private static byte[] m12837a(byte[] bArr, String str) {
        try {
            SecureRandom secureRandom = new SecureRandom();
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes("utf-8")));
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(1, generateSecret, secureRandom);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static String m12836b(String str, String str2) {
        try {
            return m12838a(m12837a(str.getBytes("utf-8"), str2));
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    /* renamed from: b */
    private static byte[] m12835b(byte[] bArr, String str) {
        SecureRandom secureRandom = new SecureRandom();
        SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes("utf-8")));
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(2, generateSecret, secureRandom);
        return cipher.doFinal(bArr);
    }
}
