package com.android.volley;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.android.volley.f */
/* loaded from: classes.dex */
class C1325f {

    /* renamed from: a */
    private static final char[] f4559a = "0123456789ABCDEF".toCharArray();

    C1325f() {
    }

    /* renamed from: a */
    public static String m16742a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bytes = str.getBytes("UTF-8");
            messageDigest.update(bytes, 0, bytes.length);
            return m16741a(messageDigest.digest());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static String m16741a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            cArr[i * 2] = f4559a[i2 >>> 4];
            cArr[(i * 2) + 1] = f4559a[i2 & 15];
        }
        return new String(cArr);
    }
}
