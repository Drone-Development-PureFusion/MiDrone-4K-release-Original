package com.p080b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.security.RSAUtil;
import com.fimi.soul.drone.p193d.p194a.p195a.C2760r;
import com.fimi.soul.module.droneui.DroneMap;
import com.fimi.soul.module.setting.newhand.C3531c;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.codehaus.jackson.smile.SmileConstants;
import org.json.JSONObject;
/* renamed from: com.b.dw */
/* loaded from: classes.dex */
public class C1552dw {
    /* renamed from: a */
    public static String m15562a(long j) {
        try {
            return new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS", Locale.CHINA).format(new Date(j));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m15560a(String str) {
        try {
        } catch (Throwable th) {
            C1450b.m16187a(th, "Utils", "sortParams");
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
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
        return str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:40)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:203)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:46)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    /* renamed from: a */
    public static java.lang.String m15559a(java.lang.Throwable r4) {
        /*
            r0 = 0
            java.io.StringWriter r3 = new java.io.StringWriter     // Catch: java.lang.Throwable -> L2b
            r3.<init>()     // Catch: java.lang.Throwable -> L2b
            java.io.PrintWriter r2 = new java.io.PrintWriter     // Catch: java.lang.Throwable -> L6c
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L6c
            r4.printStackTrace(r2)     // Catch: java.lang.Throwable -> L6f
            java.lang.Throwable r1 = r4.getCause()     // Catch: java.lang.Throwable -> L6f
        L12:
            if (r1 == 0) goto L1c
            r1.printStackTrace(r2)     // Catch: java.lang.Throwable -> L6f
            java.lang.Throwable r1 = r1.getCause()     // Catch: java.lang.Throwable -> L6f
            goto L12
        L1c:
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L6f
            if (r3 == 0) goto L25
            r3.close()     // Catch: java.lang.Throwable -> L5f
        L25:
            if (r2 == 0) goto L2a
            r2.close()     // Catch: java.lang.Throwable -> L64
        L2a:
            return r0
        L2b:
            r1 = move-exception
            r2 = r0
            r3 = r0
        L2e:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L6a
            if (r3 == 0) goto L36
            r3.close()     // Catch: java.lang.Throwable -> L5a
        L36:
            if (r2 == 0) goto L2a
            r2.close()     // Catch: java.lang.Throwable -> L3c
            goto L2a
        L3c:
            r1 = move-exception
        L3d:
            r1.printStackTrace()
            goto L2a
        L41:
            r1 = move-exception
            r2 = r0
            r3 = r0
            r0 = r1
        L45:
            if (r3 == 0) goto L4a
            r3.close()     // Catch: java.lang.Throwable -> L50
        L4a:
            if (r2 == 0) goto L4f
            r2.close()     // Catch: java.lang.Throwable -> L55
        L4f:
            throw r0
        L50:
            r1 = move-exception
            r1.printStackTrace()
            goto L4a
        L55:
            r1 = move-exception
            r1.printStackTrace()
            goto L4f
        L5a:
            r1 = move-exception
            r1.printStackTrace()
            goto L36
        L5f:
            r1 = move-exception
            r1.printStackTrace()
            goto L25
        L64:
            r1 = move-exception
            goto L3d
        L66:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L45
        L6a:
            r0 = move-exception
            goto L45
        L6c:
            r1 = move-exception
            r2 = r0
            goto L2e
        L6f:
            r1 = move-exception
            goto L2e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p080b.C1552dw.m15559a(java.lang.Throwable):java.lang.String");
    }

    /* renamed from: a */
    static String m15558a(Map<String, String> map) {
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
            }
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0038, code lost:
        if (r2 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0040, code lost:
        if (r2 == null) goto L11;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PublicKey m15561a(Context context) {
        ByteArrayInputStream byteArrayInputStream;
        PublicKey publicKey = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(new byte[]{48, -126, 2, -98, 48, -126, 2, 7, -96, 3, 2, 1, 2, 2, 9, 0, -99, 15, 119, SmileConstants.HEADER_BYTE_1, 44, -19, -105, -40, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 48, 104, 49, 11, 48, 9, 6, 3, C3531c.f14197f, 4, 6, 19, 2, DroneMap.f12612o, 78, 49, 19, 48, 17, 6, 3, C3531c.f14197f, 4, 8, 12, 10, 83, 111, 109, 101, 45, 83, 116, 97, 116, 101, 49, 16, 48, 14, 6, 3, C3531c.f14197f, 4, 7, 12, 7, 66, 101, 105, 106, 105, 110, 103, 49, 17, 48, 15, 6, 3, C3531c.f14197f, 4, 10, 12, 8, 65, 117, 116, 111, 110, 97, 118, 105, 49, 31, 48, 29, 6, 3, C3531c.f14197f, 4, 3, 12, 22, 99, 111, 109, 46, 97, 117, 116, 111, 110, 97, 118, 105, 46, 97, 112, 105, C2760r.f10172a, 101, 114, 118, 101, 114, 48, 30, 23, 13, 49, 51, 48, 56, 49, 53, 48, 55, 53, 54, 53, 53, 90, 23, 13, 50, 51, 48, 56, 49, 51, 48, 55, 53, 54, 53, 53, 90, 48, 104, 49, 11, 48, 9, 6, 3, C3531c.f14197f, 4, 6, 19, 2, DroneMap.f12612o, 78, 49, 19, 48, 17, 6, 3, C3531c.f14197f, 4, 8, 12, 10, 83, 111, 109, 101, 45, 83, 116, 97, 116, 101, 49, 16, 48, 14, 6, 3, C3531c.f14197f, 4, 7, 12, 7, 66, 101, 105, 106, 105, 110, 103, 49, 17, 48, 15, 6, 3, C3531c.f14197f, 4, 10, 12, 8, 65, 117, 116, 111, 110, 97, 118, 105, 49, 31, 48, 29, 6, 3, C3531c.f14197f, 4, 3, 12, 22, 99, 111, 109, 46, 97, 117, 116, 111, 110, 97, 118, 105, 46, 97, 112, 105, C2760r.f10172a, 101, 114, 118, 101, 114, 48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -15, -27, Byte.MIN_VALUE, -56, 118, -59, 62, -127, 79, 125, -36, 121, 0, 63, -125, -30, 118, 5, -85, -121, 91, 39, 90, 123, 72, -126, -83, -41, -45, -77, -42, -120, -81, 23, -2, -121, -29, 123, -7, 22, -114, -20, -25, 74, DroneMap.f12612o, -43, 65, 124, -7, 11, -72, 38, -123, 16, -58, DroneMap.f12610m, 32, SmileConstants.HEADER_BYTE_1, -33, 14, 11, 36, 60, 13, -121, 100, 105, -32, 123, -31, 114, -101, -41, 12, 100, SmileConstants.TOKEN_LITERAL_NULL, -120, 63, 126, -123, 48, 55, DroneMap.f12610m, -116, 28, -10, 125, 59, -41, -95, -126, 118, -70, 43, -127, 9, 93, -100, 81, -19, -114, -41, C3531c.f14197f, -103, -37, -116, 118, 72, 86, 125, -43, -92, -11, 63, 69, -38, -10, -65, 126, -53, -115, 60, 62, C3531c.f14198g, -80, 1, 39, 19, 2, 3, 1, 0, 1, -93, DroneMap.f12610m, 48, 78, 48, 29, 6, 3, C3531c.f14197f, 29, 14, 4, 22, 4, 20, -29, 63, 48, -79, -113, -13, 26, C3531c.f14197f, 22, -27, 93, -5, 122, -103, -109, 14, -18, 6, -13, -109, 48, 31, 6, 3, C3531c.f14197f, 29, SmileConstants.TOKEN_LITERAL_TRUE, 4, 24, 48, 22, Byte.MIN_VALUE, 20, -29, 63, 48, -79, -113, -13, 26, C3531c.f14197f, 22, -27, 93, -5, 122, -103, -109, 14, -18, 6, -13, -109, 48, 12, 6, 3, C3531c.f14197f, 29, 19, 4, 5, 48, 3, 1, 1, -1, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 3, -127, -127, 0, -32, -74, 55, -125, -58, Byte.MIN_VALUE, 15, -62, 100, -60, 3, C3531c.f14198g, 81, 112, -61, -56, -69, -126, 8, 99, -100, -38, -108, -56, -122, 125, 19, -64, -61, 90, C3531c.f14197f, -47, -8, -123, -103, 105, 77, -32, -65, -62, -28, DroneMap.f12612o, -28, -78, 116, -49, 120, -2, SmileConstants.TOKEN_LITERAL_NULL, 13, 47, 46, -5, -112, 3, -101, -125, -115, 92, -124, SmileConstants.HEADER_BYTE_1, DroneMap.f12610m, 107, -67, DroneMap.f12611n, 6, -63, 39, -90, -1, C3531c.f14197f, -58, DroneMap.f12611n, -115, 119, 13, -4, -32, 0, -98, 100, -41, 94, -75, 75, -103, 126, -80, C3531c.f14197f, 40, -27, 60, 105, 28, -27, -21, -15, -98, 103, -88, -109, SmileConstants.TOKEN_LITERAL_TRUE, -119, -27, -26, -122, 113, 63, SmileConstants.TOKEN_LITERAL_TRUE, -33, 70, 23, SmileConstants.TOKEN_LITERAL_NULL, -23, 66, 108, 56, 112, 46, -85, -123, -123, SmileConstants.TOKEN_LITERAL_NULL, 118, 27, 96, -7, -103});
        } catch (Throwable th) {
            th = th;
            byteArrayInputStream = null;
        }
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyFactory keyFactory = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA);
            Certificate generateCertificate = certificateFactory.generateCertificate(byteArrayInputStream);
            if (generateCertificate != null && keyFactory != null) {
                publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(generateCertificate.getPublicKey().getEncoded()));
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                th.printStackTrace();
            } finally {
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
            }
        }
        return publicKey;
    }

    /* renamed from: a */
    public static boolean m15557a(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    /* renamed from: a */
    public static byte[] m15563a() {
        try {
            String[] split = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            byte[] bArr = new byte[split.length];
            for (int i = 0; i < split.length; i++) {
                bArr[i] = Byte.parseByte(split[i]);
            }
            String[] split2 = new StringBuffer(new String(C1544dr.m15603b(new String(bArr)))).reverse().toString().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            byte[] bArr2 = new byte[split2.length];
            for (int i2 = 0; i2 < split2.length; i2++) {
                bArr2[i2] = Byte.parseByte(split2[i2]);
            }
            return bArr2;
        } catch (Throwable th) {
            C1450b.m16187a(th, "Utils", "getIV");
            return new byte[16];
        }
    }

    /* renamed from: a */
    public static byte[] m15556a(byte[] bArr) {
        try {
            return m15550f(bArr);
        } catch (IOException e) {
            C1450b.m16187a(e, "Utils", "gZip");
            return new byte[0];
        } catch (Throwable th) {
            C1450b.m16187a(th, "Utils", "gZip");
            return new byte[0];
        }
    }

    /* renamed from: b */
    public static String m15555b(Map<String, String> map) {
        return m15560a(m15558a(map));
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
    public static byte[] m15554b(byte[] r6) {
        /*
            r0 = 0
            if (r6 == 0) goto L6
            int r1 = r6.length
            if (r1 != 0) goto L7
        L6:
            return r0
        L7:
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L3f
            r2.<init>()     // Catch: java.lang.Throwable -> L3f
            java.util.zip.ZipOutputStream r3 = new java.util.zip.ZipOutputStream     // Catch: java.lang.Throwable -> La2
            r3.<init>(r2)     // Catch: java.lang.Throwable -> La2
            java.util.zip.ZipEntry r1 = new java.util.zip.ZipEntry     // Catch: java.lang.Throwable -> La5
            java.lang.String r4 = "log"
            r1.<init>(r4)     // Catch: java.lang.Throwable -> La5
            r3.putNextEntry(r1)     // Catch: java.lang.Throwable -> La5
            r3.write(r6)     // Catch: java.lang.Throwable -> La5
            r3.closeEntry()     // Catch: java.lang.Throwable -> La5
            r3.finish()     // Catch: java.lang.Throwable -> La5
            byte[] r0 = r2.toByteArray()     // Catch: java.lang.Throwable -> La5
            if (r3 == 0) goto L2d
            r3.close()     // Catch: java.lang.Throwable -> L90
        L2d:
            if (r2 == 0) goto L6
            r2.close()     // Catch: java.lang.Throwable -> L33
            goto L6
        L33:
            r1 = move-exception
            java.lang.String r2 = "Utils"
            java.lang.String r3 = "zip2"
            com.p080b.C1450b.m16187a(r1, r2, r3)
        L3b:
            r1.printStackTrace()
            goto L6
        L3f:
            r1 = move-exception
            r2 = r0
            r3 = r0
        L42:
            java.lang.String r4 = "Utils"
            java.lang.String r5 = "zip"
            com.p080b.C1450b.m16187a(r1, r4, r5)     // Catch: java.lang.Throwable -> La0
            if (r3 == 0) goto L4e
            r3.close()     // Catch: java.lang.Throwable -> L84
        L4e:
            if (r2 == 0) goto L6
            r2.close()     // Catch: java.lang.Throwable -> L54
            goto L6
        L54:
            r1 = move-exception
            java.lang.String r2 = "Utils"
            java.lang.String r3 = "zip2"
            com.p080b.C1450b.m16187a(r1, r2, r3)
            goto L3b
        L5d:
            r1 = move-exception
            r2 = r0
            r3 = r0
            r0 = r1
        L61:
            if (r3 == 0) goto L66
            r3.close()     // Catch: java.lang.Throwable -> L6c
        L66:
            if (r2 == 0) goto L6b
            r2.close()     // Catch: java.lang.Throwable -> L78
        L6b:
            throw r0
        L6c:
            r1 = move-exception
            java.lang.String r3 = "Utils"
            java.lang.String r4 = "zip1"
            com.p080b.C1450b.m16187a(r1, r3, r4)
            r1.printStackTrace()
            goto L66
        L78:
            r1 = move-exception
            java.lang.String r2 = "Utils"
            java.lang.String r3 = "zip2"
            com.p080b.C1450b.m16187a(r1, r2, r3)
            r1.printStackTrace()
            goto L6b
        L84:
            r1 = move-exception
            java.lang.String r3 = "Utils"
            java.lang.String r4 = "zip1"
            com.p080b.C1450b.m16187a(r1, r3, r4)
            r1.printStackTrace()
            goto L4e
        L90:
            r1 = move-exception
            java.lang.String r3 = "Utils"
            java.lang.String r4 = "zip1"
            com.p080b.C1450b.m16187a(r1, r3, r4)
            r1.printStackTrace()
            goto L2d
        L9c:
            r1 = move-exception
            r3 = r0
            r0 = r1
            goto L61
        La0:
            r0 = move-exception
            goto L61
        La2:
            r1 = move-exception
            r3 = r0
            goto L42
        La5:
            r1 = move-exception
            goto L42
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p080b.C1552dw.m15554b(byte[]):byte[]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static String m15553c(byte[] bArr) {
        try {
            return m15551e(bArr);
        } catch (Throwable th) {
            C1450b.m16187a(th, "Utils", "HexString");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static String m15552d(byte[] bArr) {
        try {
            return m15551e(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: e */
    public static String m15551e(byte[] bArr) {
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
    private static byte[] m15550f(byte[] bArr) {
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
