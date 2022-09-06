package com.fimi.kernel.utils;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.fimi.kernel.utils.d */
/* loaded from: classes.dex */
public final class C2256d {

    /* renamed from: a */
    private static final char[] f7519a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', SignatureVisitor.EXTENDS, '/'};

    /* renamed from: b */
    private static final byte[] f7520b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, SmileConstants.TOKEN_KEY_LONG_STRING, 53, 54, 55, 56, 57, SmileConstants.HEADER_BYTE_1, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, SmileConstants.TOKEN_LITERAL_NULL, SmileConstants.TOKEN_LITERAL_FALSE, SmileConstants.TOKEN_LITERAL_TRUE, 36, 37, 38, 39, 40, SmileConstants.HEADER_BYTE_2, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    /* renamed from: a */
    public static final String m13041a(String str, String str2) {
        return m13040a(str, str2, 0);
    }

    /* renamed from: a */
    public static final String m13040a(String str, String str2, int i) {
        int i2 = 0;
        try {
            byte[] bytes = str.getBytes(str2);
            int length = bytes.length;
            int ceil = (int) Math.ceil(length * 1.36d);
            int i3 = i > 0 ? ceil / i : 0;
            StringBuffer stringBuffer = new StringBuffer(ceil + i3);
            int i4 = length % 3;
            int i5 = length - i4;
            while (i2 < i5) {
                int i6 = i2 + 1;
                int i7 = i6 + 1;
                int i8 = ((bytes[i6] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | ((bytes[i2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16);
                i2 = i7 + 1;
                int i9 = i8 | (bytes[i7] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
                stringBuffer.append(f7519a[i9 >> 18]);
                stringBuffer.append(f7519a[(i9 >> 12) & 63]);
                stringBuffer.append(f7519a[(i9 >> 6) & 63]);
                stringBuffer.append(f7519a[i9 & 63]);
            }
            if (i4 == 1) {
                int i10 = i2 + 1;
                int i11 = bytes[i2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
                stringBuffer.append(f7519a[i11 >> 2]);
                stringBuffer.append(f7519a[(i11 & 3) << 4]);
                stringBuffer.append("==");
            } else if (i4 == 2) {
                int i12 = i2 + 1;
                int i13 = i12 + 1;
                int i14 = ((bytes[i2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (bytes[i12] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
                stringBuffer.append(f7519a[i14 >> 10]);
                stringBuffer.append(f7519a[(i14 >> 4) & 63]);
                stringBuffer.append(f7519a[(i14 & 15) << 2]);
                stringBuffer.append("=");
            }
            if (i3 > 0) {
                int i15 = i;
                while (i15 < stringBuffer.length()) {
                    stringBuffer.insert(i15, '\n');
                    i15 = i15 + i + 1;
                }
            }
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0088, code lost:
        r4 = r1;
        r1 = r3;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String m13039b(String str, String str2) {
        byte b;
        byte b2;
        byte b3;
        int i;
        byte b4;
        try {
            byte[] bytes = str.getBytes(str2);
            int length = bytes.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) (length * 0.67d));
            int i2 = 0;
            while (i2 < length) {
                while (i2 < length) {
                    int i3 = i2 + 1;
                    byte b5 = f7520b[bytes[i2]];
                    if (i3 >= length || b5 != -1) {
                        b = b5;
                        i2 = i3;
                        break;
                    }
                    i2 = i3;
                }
                b = -1;
                if (b != -1) {
                    while (i2 < length) {
                        int i4 = i2 + 1;
                        byte b6 = f7520b[bytes[i2]];
                        if (i4 >= length || b6 != -1) {
                            b2 = b6;
                            i2 = i4;
                            break;
                        }
                        i2 = i4;
                    }
                    b2 = -1;
                    if (b2 != -1) {
                        byteArrayOutputStream.write((b << 2) | ((b2 & 48) >>> 4));
                        while (true) {
                            if (i2 >= length) {
                                b3 = -1;
                                break;
                            }
                            int i5 = i2 + 1;
                            byte b7 = bytes[i2];
                            if (b7 == 61) {
                                b3 = -1;
                                i2 = i5;
                                break;
                            }
                            byte b8 = f7520b[b7];
                            if (i5 >= length || b8 != -1) {
                                break;
                            }
                            i2 = i5;
                        }
                        if (b3 != -1) {
                            byteArrayOutputStream.write(((b2 & 15) << 4) | ((b3 & 60) >>> 2));
                            while (true) {
                                if (i2 < length) {
                                    i = i2 + 1;
                                    byte b9 = bytes[i2];
                                    if (b9 != 61) {
                                        b4 = f7520b[b9];
                                        if (b4 != -1) {
                                            break;
                                        }
                                        i2 = i;
                                    } else {
                                        b4 = -1;
                                        break;
                                    }
                                } else {
                                    i = i2;
                                    b4 = -1;
                                    break;
                                }
                            }
                            if (b4 != -1) {
                                byteArrayOutputStream.write(b4 | ((b3 & 3) << 6));
                                i2 = i;
                            }
                        }
                    }
                }
            }
            try {
                return byteArrayOutputStream.toString(str2);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
