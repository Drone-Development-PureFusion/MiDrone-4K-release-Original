package com.amap.api.mapcore.util;

import java.io.ByteArrayOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.amap.api.mapcore.util.fd */
/* loaded from: classes.dex */
public class C0991fd {

    /* renamed from: a */
    private static final char[] f3120a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', SignatureVisitor.EXTENDS, '/'};

    /* renamed from: b */
    private static final byte[] f3121b = new byte[128];

    static {
        for (int i = 0; i < 128; i++) {
            f3121b[i] = -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            f3121b[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            f3121b[i3] = (byte) ((i3 - 97) + 26);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            f3121b[i4] = (byte) ((i4 - 48) + 52);
        }
        f3121b[43] = 62;
        f3121b[47] = 63;
    }

    /* renamed from: a */
    public static String m18103a(String str) {
        return C0999fi.m18043a(m18099b(str));
    }

    /* renamed from: a */
    public static String m18102a(byte[] bArr) {
        try {
            return m18096c(bArr);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "Encrypt", "encodeBase64");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static byte[] m18101a(byte[] bArr, Key key) {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, key);
        return cipher.doFinal(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static byte[] m18100a(byte[] bArr, byte[] bArr2) {
        try {
            return m18097b(bArr, bArr2);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "Encrypt", "aesEncrypt");
            return null;
        }
    }

    /* renamed from: b */
    public static String m18098b(byte[] bArr) {
        try {
            return m18096c(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
        if (r5 == (-1)) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
        r4.write(((r6 & 15) << 4) | ((r5 & 60) >>> 2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0062, code lost:
        r0 = r1 + 1;
        r1 = r2[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
        if (r1 != 61) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006d, code lost:
        r1 = com.amap.api.mapcore.util.C0991fd.f3121b[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0071, code lost:
        if (r0 >= r3) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0073, code lost:
        if (r1 == (-1)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0080, code lost:
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0075, code lost:
        if (r1 == (-1)) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0077, code lost:
        r4.write(r1 | ((r5 & 3) << 6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
        return r4.toByteArray();
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] m18099b(String str) {
        int i;
        byte b;
        int i2;
        byte b2;
        int i3 = 0;
        if (str == null) {
            return new byte[0];
        }
        byte[] m18047a = C0999fi.m18047a(str);
        int length = m18047a.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        while (i3 < length) {
            while (true) {
                i = i3 + 1;
                b = f3121b[m18047a[i3]];
                if (i >= length || b != -1) {
                    break;
                }
                i3 = i;
            }
            if (b != -1) {
                while (true) {
                    i2 = i + 1;
                    b2 = f3121b[m18047a[i]];
                    if (i2 >= length || b2 != -1) {
                        break;
                    }
                    i = i2;
                }
                if (b2 == -1) {
                    break;
                }
                byteArrayOutputStream.write((b << 2) | ((b2 & 48) >>> 4));
                while (true) {
                    int i4 = i2 + 1;
                    byte b3 = m18047a[i2];
                    if (b3 == 61) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    byte b4 = f3121b[b3];
                    if (i4 >= length || b4 != -1) {
                        break;
                    }
                    i2 = i4;
                }
            } else {
                break;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: b */
    private static byte[] m18097b(byte[] bArr, byte[] bArr2) {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(C0999fi.m18053a());
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        try {
            cipher.init(1, secretKeySpec, ivParameterSpec);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return cipher.doFinal(bArr2);
    }

    /* renamed from: c */
    private static String m18096c(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            int i3 = bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            if (i2 == length) {
                stringBuffer.append(f3120a[i3 >>> 2]);
                stringBuffer.append(f3120a[(i3 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i4 = i2 + 1;
            int i5 = bArr[i2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            if (i4 == length) {
                stringBuffer.append(f3120a[i3 >>> 2]);
                stringBuffer.append(f3120a[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
                stringBuffer.append(f3120a[(i5 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            i = i4 + 1;
            int i6 = bArr[i4] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            stringBuffer.append(f3120a[i3 >>> 2]);
            stringBuffer.append(f3120a[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
            stringBuffer.append(f3120a[((i5 & 15) << 2) | ((i6 & 192) >>> 6)]);
            stringBuffer.append(f3120a[i6 & 63]);
        }
        return stringBuffer.toString();
    }
}
