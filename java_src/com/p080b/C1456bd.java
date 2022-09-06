package com.p080b;

import com.baidu.android.common.security.RSAUtil;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* renamed from: com.b.bd */
/* loaded from: classes.dex */
public class C1456bd {

    /* renamed from: a */
    private static final char[] f5056a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    private static final byte[] f5057b = {0, 1, 1, 2, 3, 5, 8, 13, 8, 7, 6, 5, 4, 3, 2, 1};

    /* renamed from: c */
    private static final IvParameterSpec f5058c = new IvParameterSpec(f5057b);

    /* renamed from: a */
    public static String m16135a(String str) {
        if (str != null) {
            try {
                if (str.length() == 0) {
                    return null;
                }
                return m16134a("MD5", m16134a("SHA1", str) + str);
            } catch (Throwable th) {
                C1514cx.m15728a(th, "Encrypt", "generatorKey");
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m16134a(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        try {
            return m16129b(C1545ds.m15597a(str2.getBytes("UTF-8"), str));
        } catch (Throwable th) {
            C1514cx.m15728a(th, "Encrypt", "encode");
            return null;
        }
    }

    /* renamed from: a */
    public static String m16133a(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[bArr.length - 16];
            System.arraycopy(bArr, 0, bArr2, 0, 16);
            System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(C1552dw.m15563a()));
            return new String(cipher.doFinal(bArr3), "UTF-8");
        } catch (Throwable th) {
            C1514cx.m15728a(th, "Encrypt", "decryptRsponse");
            return null;
        }
    }

    /* renamed from: a */
    private static byte[] m16136a() {
        return C1552dw.m15563a();
    }

    /* renamed from: a */
    public static synchronized byte[] m16132a(byte[] bArr, String str) {
        byte[] byteArray;
        int i = 0;
        synchronized (C1456bd.class) {
            PrivateKey generatePrivate = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePrivate(new PKCS8EncodedKeySpec(C1544dr.m15603b(str)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, generatePrivate);
            int length = bArr.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i2 = 0;
            while (length - i > 0) {
                byte[] doFinal = length - i > 245 ? cipher.doFinal(bArr, i, 245) : cipher.doFinal(bArr, i, length - i);
                byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                int i3 = i2 + 1;
                i = i3 * 245;
                i2 = i3;
            }
            byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        }
        return byteArray;
    }

    /* renamed from: a */
    public static byte[] m16131a(byte[] bArr, byte[] bArr2) {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, new SecretKeySpec(bArr, "AES"), f5058c);
        return cipher.doFinal(bArr2);
    }

    /* renamed from: b */
    private static String m16129b(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length * 2);
        for (int i = 0; i < length; i++) {
            sb.append(f5056a[(bArr[i] >> 4) & 15]);
            sb.append(f5056a[bArr[i] & 15]);
        }
        return sb.toString();
    }

    /* renamed from: b */
    private static SecretKeySpec m16130b(String str) {
        byte[] bArr = null;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append("0");
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bArr = stringBuffer.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            C1514cx.m15728a(e, "Encrypt", "createKey");
        }
        return new SecretKeySpec(bArr, "AES");
    }

    /* renamed from: b */
    public static synchronized byte[] m16128b(byte[] bArr, String str) {
        byte[] byteArray;
        int i = 0;
        synchronized (C1456bd.class) {
            PrivateKey generatePrivate = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePrivate(new PKCS8EncodedKeySpec(C1544dr.m15603b(str)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, generatePrivate);
            int length = bArr.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i2 = 0;
            while (length - i > 0) {
                byte[] doFinal = length - i > 256 ? cipher.doFinal(bArr, i, 256) : cipher.doFinal(bArr, i, length - i);
                byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                int i3 = i2 + 1;
                i = i3 * 256;
                i2 = i3;
            }
            byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        }
        return byteArray;
    }

    /* renamed from: c */
    public static byte[] m16127c(byte[] bArr, String str) {
        try {
            SecretKeySpec m16130b = m16130b(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(m16136a());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            try {
                cipher.init(1, m16130b, ivParameterSpec);
            } catch (InvalidAlgorithmParameterException e) {
                C1514cx.m15728a(e, "Encrypt", "aesEncrypt1");
            }
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "Encrypt", "aesEncrypt");
            return null;
        }
    }

    /* renamed from: d */
    public static byte[] m16126d(byte[] bArr, String str) {
        try {
            SecretKeySpec m16130b = m16130b(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(m16136a());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            try {
                cipher.init(2, m16130b, ivParameterSpec);
            } catch (InvalidAlgorithmParameterException e) {
                C1514cx.m15728a(e, "Encrypt", "aesDecrypt1");
            }
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            C1514cx.m15728a(th, "Encrypt", "aesDecrypt");
            return null;
        }
    }
}
