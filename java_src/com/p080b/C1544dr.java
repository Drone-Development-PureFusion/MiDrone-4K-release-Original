package com.p080b;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.b.dr */
/* loaded from: classes.dex */
public class C1544dr {

    /* renamed from: a */
    private static final char[] f5515a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', SignatureVisitor.EXTENDS, '/'};

    /* renamed from: b */
    private static final byte[] f5516b = new byte[128];

    static {
        for (int i = 0; i < 128; i++) {
            f5516b[i] = -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            f5516b[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            f5516b[i3] = (byte) ((i3 - 97) + 26);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            f5516b[i4] = (byte) ((i4 - 48) + 52);
        }
        f5516b[43] = 62;
        f5516b[47] = 63;
    }

    /* renamed from: a */
    public static String m15607a(String str) {
        try {
            return new String(m15603b(str), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new String(m15603b(str));
        }
    }

    /* renamed from: a */
    public static String m15606a(byte[] bArr) {
        try {
            return m15600c(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static byte[] m15605a(byte[] bArr, Key key) {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, key);
        return cipher.doFinal(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static byte[] m15604a(byte[] bArr, byte[] bArr2) {
        try {
            return m15601b(bArr, bArr2);
        } catch (InvalidKeyException e) {
            C1450b.m16187a(e, "Encrypt", "aesEncrypt");
            return null;
        } catch (NoSuchAlgorithmException e2) {
            C1450b.m16187a(e2, "Encrypt", "aesEncrypt");
            return null;
        } catch (BadPaddingException e3) {
            C1450b.m16187a(e3, "Encrypt", "aesEncrypt");
            return null;
        } catch (IllegalBlockSizeException e4) {
            C1450b.m16187a(e4, "Encrypt", "aesEncrypt");
            return null;
        } catch (NoSuchPaddingException e5) {
            C1450b.m16187a(e5, "Encrypt", "aesEncrypt");
            return null;
        } catch (Throwable th) {
            C1450b.m16187a(th, "Encrypt", "aesEncrypt");
            return null;
        }
    }

    /* renamed from: b */
    public static String m15602b(byte[] bArr) {
        try {
            return m15600c(bArr);
        } catch (Throwable th) {
            C1450b.m16187a(th, "Encrypt", "encodeBase64");
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
        if (r5 == (-1)) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005e, code lost:
        r4.write(((r6 & 15) << 4) | ((r5 & 60) >>> 2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
        r1 = r2 + 1;
        r2 = r0[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:
        if (r2 != 61) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0075, code lost:
        r2 = com.p080b.C1544dr.f5516b[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0079, code lost:
        if (r1 >= r3) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007b, code lost:
        if (r2 == (-1)) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0088, code lost:
        r2 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007d, code lost:
        if (r2 == (-1)) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007f, code lost:
        r4.write(r2 | ((r5 & 3) << 6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
        return r4.toByteArray();
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] m15603b(String str) {
        byte[] bytes;
        int i;
        byte b;
        int i2;
        byte b2;
        int i3 = 0;
        if (str == null) {
            return new byte[0];
        }
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        while (i3 < length) {
            while (true) {
                i = i3 + 1;
                b = f5516b[bytes[i3]];
                if (i >= length || b != -1) {
                    break;
                }
                i3 = i;
            }
            if (b != -1) {
                while (true) {
                    i2 = i + 1;
                    b2 = f5516b[bytes[i]];
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
                    byte b3 = bytes[i2];
                    if (b3 == 61) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    byte b4 = f5516b[b3];
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
    private static byte[] m15601b(byte[] bArr, byte[] bArr2) {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(C1552dw.m15563a());
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
    private static String m15600c(byte[] bArr) {
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
                stringBuffer.append(f5515a[i3 >>> 2]);
                stringBuffer.append(f5515a[(i3 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i4 = i2 + 1;
            int i5 = bArr[i2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            if (i4 == length) {
                stringBuffer.append(f5515a[i3 >>> 2]);
                stringBuffer.append(f5515a[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
                stringBuffer.append(f5515a[(i5 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            i = i4 + 1;
            int i6 = bArr[i4] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            stringBuffer.append(f5515a[i3 >>> 2]);
            stringBuffer.append(f5515a[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
            stringBuffer.append(f5515a[((i5 & 15) << 2) | ((i6 & 192) >>> 6)]);
            stringBuffer.append(f5515a[i6 & 63]);
        }
        return stringBuffer.toString();
    }
}
