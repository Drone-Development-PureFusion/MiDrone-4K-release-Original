package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.security.RSAUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import org.codehaus.jackson.smile.SmileConstants;
import org.json.JSONObject;
/* renamed from: com.amap.api.mapcore.util.fi */
/* loaded from: classes.dex */
public class C0999fi {

    /* renamed from: a */
    static String f3151a;

    static {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            sb.append("=");
        }
        f3151a = sb.toString();
    }

    /* renamed from: a */
    public static String m18052a(long j) {
        try {
            return new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS", Locale.CHINA).format(new Date(j));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
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
    /* renamed from: a */
    public static java.lang.String m18046a(java.lang.Throwable r4) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.C0999fi.m18046a(java.lang.Throwable):java.lang.String");
    }

    /* renamed from: a */
    public static String m18045a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (z) {
                    z = false;
                    stringBuffer.append(entry.getKey()).append("=").append(entry.getValue());
                } else {
                    stringBuffer.append("&").append(entry.getKey()).append("=").append(entry.getValue());
                }
                z = z;
            }
        } catch (Throwable th) {
            C1002fl.m18028a(th, "Utils", "assembleParams");
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m18043a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new String(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static PublicKey m18051a(Context context) {
        ByteArrayInputStream byteArrayInputStream;
        PublicKey publicKey = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(C0991fd.m18099b("MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="));
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                KeyFactory keyFactory = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA);
                Certificate generateCertificate = certificateFactory.generateCertificate(byteArrayInputStream);
                if (generateCertificate != null && keyFactory != null) {
                    publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(generateCertificate.getPublicKey().getEncoded()));
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable th) {
                            th = th;
                            return publicKey;
                        }
                    }
                } else if (byteArrayInputStream != null) {
                    try {
                    } catch (Throwable th2) {
                        return publicKey;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    th.printStackTrace();
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable th4) {
                            th = th4;
                            return publicKey;
                        }
                    }
                    return publicKey;
                } finally {
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
            byteArrayInputStream = null;
        }
        return publicKey;
    }

    /* renamed from: a */
    public static void m18050a(Context context, String str, String str2, String str3) {
        m18034f(f3151a);
        m18034f("                                   鉴权错误信息                                  ");
        m18034f(f3151a);
        m18036e("SHA1Package:" + C0976ey.m18167e(context));
        m18036e("key:" + C0976ey.m18166f(context));
        m18036e("csid:" + str);
        m18036e("gsid:" + str2);
        m18036e("json:" + str3);
        m18034f("                                                                               ");
        m18034f("请仔细检查 SHA1Package与Key申请信息是否对应，Key是否删除，平台是否匹配                ");
        m18034f("如若确认无误，仍存在问题，请将全部log信息提交到工单系统，多谢合作                       ");
        m18034f(f3151a);
    }

    /* renamed from: a */
    public static void m18049a(ByteArrayOutputStream byteArrayOutputStream, byte b, byte[] bArr) {
        try {
            byteArrayOutputStream.write(new byte[]{b});
            int i = b & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            if (i < 255 && i > 0) {
                byteArrayOutputStream.write(bArr);
            } else if (i == 255) {
                byteArrayOutputStream.write(bArr, 0, 255);
            }
        } catch (IOException e) {
            C1002fl.m18028a(e, "Utils", "writeField");
        }
    }

    /* renamed from: a */
    public static void m18048a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        int i = 255;
        if (TextUtils.isEmpty(str)) {
            try {
                byteArrayOutputStream.write(new byte[]{0});
                return;
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        int length = str.length();
        if (length <= 255) {
            i = length;
        }
        m18049a(byteArrayOutputStream, (byte) i, m18047a(str));
    }

    /* renamed from: a */
    public static boolean m18044a(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    /* renamed from: a */
    public static byte[] m18053a() {
        try {
            String[] split = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            byte[] bArr = new byte[split.length];
            for (int i = 0; i < split.length; i++) {
                bArr[i] = Byte.parseByte(split[i]);
            }
            String[] split2 = new StringBuffer(new String(C0991fd.m18099b(new String(bArr)))).reverse().toString().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            byte[] bArr2 = new byte[split2.length];
            for (int i2 = 0; i2 < split2.length; i2++) {
                bArr2[i2] = Byte.parseByte(split2[i2]);
            }
            return bArr2;
        } catch (Throwable th) {
            C1002fl.m18028a(th, "Utils", "getIV");
            return new byte[16];
        }
    }

    /* renamed from: a */
    public static byte[] m18047a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str.getBytes();
        }
    }

    /* renamed from: b */
    public static String m18042b(String str) {
        if (str == null) {
            return null;
        }
        String m18098b = C0991fd.m18098b(m18047a(str));
        return ((char) ((m18098b.length() % 26) + 65)) + m18098b;
    }

    /* renamed from: b */
    public static byte[] m18041b(byte[] bArr) {
        try {
            return m18032g(bArr);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "Utils", "gZip");
            return new byte[0];
        }
    }

    /* renamed from: c */
    public static String m18040c(String str) {
        return str.length() < 2 ? "" : C0991fd.m18103a(str.substring(1));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:40)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:203)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:46)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    /* renamed from: c */
    public static byte[] m18039c(byte[] r6) {
        /*
            r0 = 0
            if (r6 == 0) goto L6
            int r1 = r6.length
            if (r1 != 0) goto L7
        L6:
            return r0
        L7:
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L3c
            r2.<init>()     // Catch: java.lang.Throwable -> L3c
            java.util.zip.ZipOutputStream r3 = new java.util.zip.ZipOutputStream     // Catch: java.lang.Throwable -> L90
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L90
            java.util.zip.ZipEntry r1 = new java.util.zip.ZipEntry     // Catch: java.lang.Throwable -> L93
            java.lang.String r4 = "log"
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L93
            r3.putNextEntry(r1)     // Catch: java.lang.Throwable -> L93
            r3.write(r6)     // Catch: java.lang.Throwable -> L93
            r3.closeEntry()     // Catch: java.lang.Throwable -> L93
            r3.finish()     // Catch: java.lang.Throwable -> L93
            byte[] r0 = r2.toByteArray()     // Catch: java.lang.Throwable -> L93
            if (r3 == 0) goto L2d
            r3.close()     // Catch: java.lang.Throwable -> L81
        L2d:
            if (r2 == 0) goto L6
            r2.close()     // Catch: java.lang.Throwable -> L33
            goto L6
        L33:
            r1 = move-exception
            java.lang.String r2 = "Utils"
            java.lang.String r3 = "zip2"
        L38:
            com.amap.api.mapcore.util.C1002fl.m18028a(r1, r2, r3)
            goto L6
        L3c:
            r1 = move-exception
            r2 = r0
            r3 = r0
        L3f:
            java.lang.String r4 = "Utils"
            java.lang.String r5 = "zip"
            com.amap.api.mapcore.util.C1002fl.m18028a(r1, r4, r5)     // Catch: java.lang.Throwable -> L8e
            if (r3 == 0) goto L4b
            r3.close()     // Catch: java.lang.Throwable -> L78
        L4b:
            if (r2 == 0) goto L6
            r2.close()     // Catch: java.lang.Throwable -> L51
            goto L6
        L51:
            r1 = move-exception
            java.lang.String r2 = "Utils"
            java.lang.String r3 = "zip2"
            goto L38
        L57:
            r1 = move-exception
            r2 = r0
            r3 = r0
            r0 = r1
        L5b:
            if (r3 == 0) goto L60
            r3.close()     // Catch: java.lang.Throwable -> L66
        L60:
            if (r2 == 0) goto L65
            r2.close()     // Catch: java.lang.Throwable -> L6f
        L65:
            throw r0
        L66:
            r1 = move-exception
            java.lang.String r3 = "Utils"
            java.lang.String r4 = "zip1"
            com.amap.api.mapcore.util.C1002fl.m18028a(r1, r3, r4)
            goto L60
        L6f:
            r1 = move-exception
            java.lang.String r2 = "Utils"
            java.lang.String r3 = "zip2"
            com.amap.api.mapcore.util.C1002fl.m18028a(r1, r2, r3)
            goto L65
        L78:
            r1 = move-exception
            java.lang.String r3 = "Utils"
            java.lang.String r4 = "zip1"
            com.amap.api.mapcore.util.C1002fl.m18028a(r1, r3, r4)
            goto L4b
        L81:
            r1 = move-exception
            java.lang.String r3 = "Utils"
            java.lang.String r4 = "zip1"
            com.amap.api.mapcore.util.C1002fl.m18028a(r1, r3, r4)
            goto L2d
        L8a:
            r1 = move-exception
            r3 = r0
            r0 = r1
            goto L5b
        L8e:
            r0 = move-exception
            goto L5b
        L90:
            r1 = move-exception
            r3 = r0
            goto L3f
        L93:
            r1 = move-exception
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.C0999fi.m18039c(byte[]):byte[]");
    }

    /* renamed from: d */
    public static String m18038d(String str) {
        try {
        } catch (Throwable th) {
            C1002fl.m18028a(th, "Utils", "sortParams");
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static String m18037d(byte[] bArr) {
        try {
            return m18033f(bArr);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "Utils", "HexString");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static String m18035e(byte[] bArr) {
        try {
            return m18033f(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: e */
    static void m18036e(String str) {
        if (str.length() >= 78) {
            m18034f("|" + str.substring(0, 78) + "|");
            m18036e(str.substring(78));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("|").append(str);
        for (int i = 0; i < 78 - str.length(); i++) {
            sb.append(" ");
        }
        sb.append("|");
        m18034f(sb.toString());
    }

    /* renamed from: f */
    public static String m18033f(byte[] bArr) {
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
    private static void m18034f(String str) {
        Log.i("authErrLog", str);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:40)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:203)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:46)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    /* renamed from: g */
    private static byte[] m18032g(byte[] r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
        L3:
            return r0
        L4:
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L25
            r2.<init>()     // Catch: java.lang.Throwable -> L25
            java.util.zip.GZIPOutputStream r1 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L48
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L48
            r1.write(r4)     // Catch: java.lang.Throwable -> L4d
            r1.finish()     // Catch: java.lang.Throwable -> L4d
            byte[] r0 = r2.toByteArray()     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L1d
            r1.close()     // Catch: java.lang.Throwable -> L3b
        L1d:
            if (r2 == 0) goto L3
            r2.close()     // Catch: java.lang.Throwable -> L23
            goto L3
        L23:
            r0 = move-exception
            throw r0
        L25:
            r1 = move-exception
            r2 = r0
            r3 = r0
            r0 = r1
            r1 = r3
        L2a:
            throw r0     // Catch: java.lang.Throwable -> L2b
        L2b:
            r0 = move-exception
        L2c:
            if (r1 == 0) goto L31
            r1.close()     // Catch: java.lang.Throwable -> L37
        L31:
            if (r2 == 0) goto L36
            r2.close()     // Catch: java.lang.Throwable -> L39
        L36:
            throw r0
        L37:
            r0 = move-exception
            throw r0
        L39:
            r0 = move-exception
            throw r0
        L3b:
            r0 = move-exception
            throw r0
        L3d:
            r1 = move-exception
            r2 = r0
            r3 = r0
            r0 = r1
            r1 = r3
            goto L2c
        L43:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
            goto L2c
        L48:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
            goto L2a
        L4d:
            r0 = move-exception
            goto L2a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.C0999fi.m18032g(byte[]):byte[]");
    }
}
