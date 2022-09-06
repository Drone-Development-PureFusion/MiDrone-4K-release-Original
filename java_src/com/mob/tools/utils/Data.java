package com.mob.tools.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.security.RSAUtil;
import com.mob.tools.MobLog;
import com.mob.tools.network.BufferedByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.CRC32;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.codehaus.jackson.smile.SmileConstants;
import org.p318d.AbstractC5756f;
/* loaded from: classes.dex */
public class Data {
    private static final String CHAT_SET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String AES128Decode(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return null;
        }
        return new String(AES128Decode(str.getBytes("UTF-8"), bArr), "UTF-8");
    }

    public static byte[] AES128Decode(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
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

    public static byte[] AES128Encode(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
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

    public static byte[] AES128Encode(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        return AES128Encode(bArr, str.getBytes("UTF-8"));
    }

    public static byte[] AES128Encode(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        cipher.init(1, secretKeySpec);
        byte[] bArr3 = new byte[cipher.getOutputSize(bArr2.length)];
        cipher.doFinal(bArr3, cipher.update(bArr2, 0, bArr2.length, bArr3, 0));
        return bArr3;
    }

    public static String Base64AES(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        try {
            String encodeToString = Base64.encodeToString(AES128Encode(str2, str), 0);
            return (TextUtils.isEmpty(encodeToString) || !encodeToString.contains("\n")) ? encodeToString : encodeToString.replace("\n", "");
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            return null;
        }
    }

    public static String CRC32(byte[] bArr) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        long value = crc32.getValue();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 56)) & SmileConstants.BYTE_MARKER_END_OF_CONTENT)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 48)) & SmileConstants.BYTE_MARKER_END_OF_CONTENT)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 40)) & SmileConstants.BYTE_MARKER_END_OF_CONTENT)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 32)) & SmileConstants.BYTE_MARKER_END_OF_CONTENT)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 24)) & SmileConstants.BYTE_MARKER_END_OF_CONTENT)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 16)) & SmileConstants.BYTE_MARKER_END_OF_CONTENT)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 8)) & SmileConstants.BYTE_MARKER_END_OF_CONTENT)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) value) & SmileConstants.BYTE_MARKER_END_OF_CONTENT)));
        while (sb.charAt(0) == '0') {
            sb = sb.deleteCharAt(0);
        }
        return sb.toString().toLowerCase();
    }

    public static String MD5(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] rawMD5 = rawMD5(fileInputStream);
            fileInputStream.close();
            if (rawMD5 == null) {
                return null;
            }
            return toHex(rawMD5);
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            return null;
        }
    }

    public static String MD5(String str) {
        byte[] rawMD5;
        if (str == null || (rawMD5 = rawMD5(str)) == null) {
            return null;
        }
        return toHex(rawMD5);
    }

    public static String MD5(byte[] bArr) {
        byte[] rawMD5;
        if (bArr == null || (rawMD5 = rawMD5(bArr)) == null) {
            return null;
        }
        return toHex(rawMD5);
    }

    public static byte[] SHA1(File file) {
        byte[] bArr = null;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            bArr = SHA1(fileInputStream);
            fileInputStream.close();
            return bArr;
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            return bArr;
        }
    }

    public static byte[] SHA1(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[1024];
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            int read = inputStream.read(bArr);
            while (read != -1) {
                messageDigest.update(bArr, 0, read);
                read = inputStream.read(bArr);
            }
            return messageDigest.digest();
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            return null;
        }
    }

    public static byte[] SHA1(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return SHA1(str.getBytes("utf-8"));
    }

    public static byte[] SHA1(byte[] bArr) {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    public static String base62(long j) {
        String str = j == 0 ? "0" : "";
        while (j > 0) {
            int i = (int) (j % 62);
            j /= 62;
            str = CHAT_SET.charAt(i) + str;
        }
        return str;
    }

    public static String byteToHex(byte[] bArr) {
        return byteToHex(bArr, 0, bArr.length);
    }

    public static String byteToHex(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bArr == null) {
            return stringBuffer.toString();
        }
        while (i < i2) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i])));
            i++;
        }
        return stringBuffer.toString();
    }

    public static byte[] rawMD5(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[1024];
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            int read = inputStream.read(bArr);
            while (read != -1) {
                messageDigest.update(bArr, 0, read);
                read = inputStream.read(bArr);
            }
            return messageDigest.digest();
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            return null;
        }
    }

    public static byte[] rawMD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            return rawMD5(str.getBytes("utf-8"));
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            return null;
        }
    }

    public static byte[] rawMD5(byte[] bArr) {
        byte[] bArr2;
        if (bArr == null) {
            return null;
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            bArr2 = rawMD5(byteArrayInputStream);
            byteArrayInputStream.close();
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            bArr2 = null;
        }
        return bArr2;
    }

    public static byte[] rawRSADecode(byte[] bArr, byte[] bArr2, int i) {
        KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA);
        PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(bArr2);
        Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding");
        cipher.init(2, (RSAPrivateKey) KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePrivate(pKCS8EncodedKeySpec));
        int i2 = i / 8;
        BufferedByteArrayOutputStream bufferedByteArrayOutputStream = new BufferedByteArrayOutputStream();
        for (int i3 = 0; bArr.length - i3 > 0; i3 += i2) {
            byte[] doFinal = cipher.doFinal(bArr, i3, Math.min(bArr.length - i3, i2));
            bufferedByteArrayOutputStream.write(doFinal, 0, doFinal.length);
        }
        bufferedByteArrayOutputStream.close();
        return bufferedByteArrayOutputStream.toByteArray();
    }

    public static byte[] rawRSAEncode(byte[] bArr, byte[] bArr2, int i) {
        int i2 = (i / 8) - 11;
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(bArr2);
        Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding");
        cipher.init(1, (RSAPublicKey) KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(x509EncodedKeySpec));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i3 = 0; bArr.length - i3 > 0; i3 += i2) {
            byte[] doFinal = cipher.doFinal(bArr, i3, Math.min(bArr.length - i3, i2));
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
        }
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private static String toHex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i])));
        }
        return stringBuffer.toString();
    }

    public static String urlEncode(String str) {
        try {
            return urlEncode(str, "utf-8");
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            return null;
        }
    }

    public static String urlEncode(String str, String str2) {
        String encode = URLEncoder.encode(str, str2);
        return TextUtils.isEmpty(encode) ? encode : encode.replace(AbstractC5756f.f23063b, "%20");
    }
}
