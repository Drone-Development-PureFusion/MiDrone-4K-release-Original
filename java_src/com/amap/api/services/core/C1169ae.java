package com.amap.api.services.core;

import android.content.Context;
import com.baidu.android.common.security.RSAUtil;
import com.fimi.soul.drone.p193d.p194a.p195a.C2760r;
import com.fimi.soul.module.droneui.DroneMap;
import com.fimi.soul.module.setting.newhand.C3531c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.amap.api.services.core.ae */
/* loaded from: classes.dex */
public class C1169ae {
    /* renamed from: a */
    public static String m17247a(String str) {
        if (str == null) {
            return null;
        }
        try {
            String[] split = str.split("&");
            Arrays.sort(split);
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
                stringBuffer.append("&");
            }
            String stringBuffer2 = stringBuffer.toString();
            if (stringBuffer2.length() > 1) {
                return (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C1190ay.m17177a(th, "Utils", "sortParams");
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static PublicKey m17248a(Context context) {
        KeyFactory keyFactory;
        ByteArrayInputStream byteArrayInputStream;
        Certificate certificate;
        CertificateFactory certificateFactory;
        try {
            byteArrayInputStream = new ByteArrayInputStream(new byte[]{48, -126, 2, -98, 48, -126, 2, 7, -96, 3, 2, 1, 2, 2, 9, 0, -99, 15, 119, SmileConstants.HEADER_BYTE_1, 44, -19, -105, -40, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 48, 104, 49, 11, 48, 9, 6, 3, C3531c.f14197f, 4, 6, 19, 2, DroneMap.f12612o, 78, 49, 19, 48, 17, 6, 3, C3531c.f14197f, 4, 8, 12, 10, 83, 111, 109, 101, 45, 83, 116, 97, 116, 101, 49, 16, 48, 14, 6, 3, C3531c.f14197f, 4, 7, 12, 7, 66, 101, 105, 106, 105, 110, 103, 49, 17, 48, 15, 6, 3, C3531c.f14197f, 4, 10, 12, 8, 65, 117, 116, 111, 110, 97, 118, 105, 49, 31, 48, 29, 6, 3, C3531c.f14197f, 4, 3, 12, 22, 99, 111, 109, 46, 97, 117, 116, 111, 110, 97, 118, 105, 46, 97, 112, 105, C2760r.f10172a, 101, 114, 118, 101, 114, 48, 30, 23, 13, 49, 51, 48, 56, 49, 53, 48, 55, 53, 54, 53, 53, 90, 23, 13, 50, 51, 48, 56, 49, 51, 48, 55, 53, 54, 53, 53, 90, 48, 104, 49, 11, 48, 9, 6, 3, C3531c.f14197f, 4, 6, 19, 2, DroneMap.f12612o, 78, 49, 19, 48, 17, 6, 3, C3531c.f14197f, 4, 8, 12, 10, 83, 111, 109, 101, 45, 83, 116, 97, 116, 101, 49, 16, 48, 14, 6, 3, C3531c.f14197f, 4, 7, 12, 7, 66, 101, 105, 106, 105, 110, 103, 49, 17, 48, 15, 6, 3, C3531c.f14197f, 4, 10, 12, 8, 65, 117, 116, 111, 110, 97, 118, 105, 49, 31, 48, 29, 6, 3, C3531c.f14197f, 4, 3, 12, 22, 99, 111, 109, 46, 97, 117, 116, 111, 110, 97, 118, 105, 46, 97, 112, 105, C2760r.f10172a, 101, 114, 118, 101, 114, 48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -15, -27, Byte.MIN_VALUE, -56, 118, -59, 62, -127, 79, 125, -36, 121, 0, 63, -125, -30, 118, 5, -85, -121, 91, 39, 90, 123, 72, -126, -83, -41, -45, -77, -42, -120, -81, 23, -2, -121, -29, 123, -7, 22, -114, -20, -25, 74, DroneMap.f12612o, -43, 65, 124, -7, 11, -72, 38, -123, 16, -58, DroneMap.f12610m, 32, SmileConstants.HEADER_BYTE_1, -33, 14, 11, 36, 60, 13, -121, 100, 105, -32, 123, -31, 114, -101, -41, 12, 100, SmileConstants.TOKEN_LITERAL_NULL, -120, 63, 126, -123, 48, 55, DroneMap.f12610m, -116, 28, -10, 125, 59, -41, -95, -126, 118, -70, 43, -127, 9, 93, -100, 81, -19, -114, -41, C3531c.f14197f, -103, -37, -116, 118, 72, 86, 125, -43, -92, -11, 63, 69, -38, -10, -65, 126, -53, -115, 60, 62, C3531c.f14198g, -80, 1, 39, 19, 2, 3, 1, 0, 1, -93, DroneMap.f12610m, 48, 78, 48, 29, 6, 3, C3531c.f14197f, 29, 14, 4, 22, 4, 20, -29, 63, 48, -79, -113, -13, 26, C3531c.f14197f, 22, -27, 93, -5, 122, -103, -109, 14, -18, 6, -13, -109, 48, 31, 6, 3, C3531c.f14197f, 29, SmileConstants.TOKEN_LITERAL_TRUE, 4, 24, 48, 22, Byte.MIN_VALUE, 20, -29, 63, 48, -79, -113, -13, 26, C3531c.f14197f, 22, -27, 93, -5, 122, -103, -109, 14, -18, 6, -13, -109, 48, 12, 6, 3, C3531c.f14197f, 29, 19, 4, 5, 48, 3, 1, 1, -1, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 3, -127, -127, 0, -32, -74, 55, -125, -58, Byte.MIN_VALUE, 15, -62, 100, -60, 3, C3531c.f14198g, 81, 112, -61, -56, -69, -126, 8, 99, -100, -38, -108, -56, -122, 125, 19, -64, -61, 90, C3531c.f14197f, -47, -8, -123, -103, 105, 77, -32, -65, -62, -28, DroneMap.f12612o, -28, -78, 116, -49, 120, -2, SmileConstants.TOKEN_LITERAL_NULL, 13, 47, 46, -5, -112, 3, -101, -125, -115, 92, -124, SmileConstants.HEADER_BYTE_1, DroneMap.f12610m, 107, -67, DroneMap.f12611n, 6, -63, 39, -90, -1, C3531c.f14197f, -58, DroneMap.f12611n, -115, 119, 13, -4, -32, 0, -98, 100, -41, 94, -75, 75, -103, 126, -80, C3531c.f14197f, 40, -27, 60, 105, 28, -27, -21, -15, -98, 103, -88, -109, SmileConstants.TOKEN_LITERAL_TRUE, -119, -27, -26, -122, 113, 63, SmileConstants.TOKEN_LITERAL_TRUE, -33, 70, 23, SmileConstants.TOKEN_LITERAL_NULL, -23, 66, 108, 56, 112, 46, -85, -123, -123, SmileConstants.TOKEN_LITERAL_NULL, 118, 27, 96, -7, -103});
            try {
                certificateFactory = CertificateFactory.getInstance("X.509");
                keyFactory = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA);
            } catch (Throwable th) {
                th = th;
                keyFactory = null;
            }
            try {
                certificate = certificateFactory.generateCertificate(byteArrayInputStream);
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                        certificate = null;
                    } else {
                        certificate = null;
                    }
                    return certificate == null ? null : null;
                } finally {
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            keyFactory = null;
            byteArrayInputStream = null;
        }
        if (certificate == null && keyFactory != null) {
            return keyFactory.generatePublic(new X509EncodedKeySpec(certificate.getPublicKey().getEncoded()));
        }
    }

    /* renamed from: a */
    public static byte[] m17246a(byte[] bArr) {
        try {
            return m17241f(bArr);
        } catch (IOException e) {
            C1190ay.m17177a(e, "Utils", "gZip");
            e.printStackTrace();
            return new byte[0];
        } catch (Throwable th) {
            C1190ay.m17177a(th, "Utils", "gZip");
            th.printStackTrace();
            return new byte[0];
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:40)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:203)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:46)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    /* renamed from: b */
    public static byte[] m17245b(byte[] r6) {
        /*
            Method dump skipped, instructions count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.core.C1169ae.m17245b(byte[]):byte[]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static String m17244c(byte[] bArr) {
        try {
            return m17242e(bArr);
        } catch (Throwable th) {
            C1190ay.m17177a(th, "Utils", "HexString");
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static String m17243d(byte[] bArr) {
        try {
            return m17242e(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: e */
    private static String m17242e(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* renamed from: f */
    private static byte[] m17241f(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        byte[] bArr2 = null;
        try {
            if (bArr != null) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                        try {
                            gZIPOutputStream2.write(bArr);
                            gZIPOutputStream2.finish();
                            bArr2 = byteArrayOutputStream.toByteArray();
                            if (gZIPOutputStream2 != null) {
                                gZIPOutputStream2.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                        } catch (IOException e) {
                            throw e;
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable th2) {
                        gZIPOutputStream = null;
                        th = th2;
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable th3) {
                    byteArrayOutputStream = null;
                    th = th3;
                    gZIPOutputStream = null;
                }
            }
            return bArr2;
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
