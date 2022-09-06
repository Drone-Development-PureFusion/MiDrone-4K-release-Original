package p244m.framework.p246b;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* renamed from: m.framework.b.a */
/* loaded from: classes2.dex */
public class C4949a {

    /* renamed from: a */
    private static final String f21288a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /* renamed from: b */
    private static C4952d f21289b = new C4952d();

    /* renamed from: a */
    public static String m2561a(long j) {
        String str = j == 0 ? "0" : "";
        while (j > 0) {
            j /= 62;
            str = String.valueOf(f21288a.charAt((int) (j % 62))) + str;
        }
        return str;
    }

    /* renamed from: a */
    public static String m2558a(String str, byte[] bArr) {
        return new String(m2554a(str.getBytes("UTF-8"), bArr), "UTF-8");
    }

    /* renamed from: a */
    public static String m2557a(HashMap<String, Object> hashMap) {
        return f21289b.m2506a(hashMap);
    }

    /* renamed from: a */
    public static String m2556a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i])));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static byte[] m2560a(String str) {
        byte[] bytes = str.getBytes("utf-8");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.update(bytes);
        return messageDigest.digest();
    }

    /* renamed from: a */
    public static byte[] m2559a(String str, String str2) {
        byte[] bytes = str.getBytes("UTF-8");
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, 16));
        byte[] bytes2 = str2.getBytes("UTF-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        cipher.init(1, secretKeySpec);
        byte[] bArr2 = new byte[cipher.getOutputSize(bytes2.length)];
        cipher.doFinal(bArr2, cipher.update(bytes2, 0, bytes2.length, bArr2, 0));
        return bArr2;
    }

    /* renamed from: a */
    public static byte[] m2555a(byte[] bArr, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        cipher.init(1, secretKeySpec);
        byte[] bArr2 = new byte[cipher.getOutputSize(bytes.length)];
        cipher.doFinal(bArr2, cipher.update(bytes, 0, bytes.length, bArr2, 0));
        return bArr2;
    }

    /* renamed from: a */
    public static byte[] m2554a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[16];
        System.arraycopy(bArr, 0, bArr3, 0, Math.min(bArr.length, 16));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr3, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding", "BC");
        cipher.init(2, secretKeySpec);
        byte[] bArr4 = new byte[cipher.getOutputSize(bArr2.length)];
        int update = cipher.update(bArr2, 0, bArr2.length, bArr4, 0);
        int doFinal = cipher.doFinal(bArr4, update) + update;
        return bArr4;
    }

    /* renamed from: b */
    public static String m2552b(String str, String str2) {
        return URLEncoder.encode(str, str2).replace("\\+", "%20");
    }

    /* renamed from: b */
    public static HashMap<String, Object> m2553b(String str) {
        return f21289b.m2510a(str);
    }

    /* renamed from: c */
    public static String m2551c(String str) {
        byte[] m2550d;
        if (str == null || (m2550d = m2550d(str)) == null) {
            return null;
        }
        return C4951c.m2519a(m2550d);
    }

    /* renamed from: d */
    public static byte[] m2550d(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("utf-8"));
            return messageDigest.digest();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
