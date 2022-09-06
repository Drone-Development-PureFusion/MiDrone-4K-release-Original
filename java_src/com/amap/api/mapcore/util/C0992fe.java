package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
/* renamed from: com.amap.api.mapcore.util.fe */
/* loaded from: classes.dex */
public class C0992fe {
    /* renamed from: a */
    public static String m18095a(String str) {
        String str2;
        FileInputStream fileInputStream = null;
        fileInputStream = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.isFile() && file.exists()) {
                    byte[] bArr = new byte[2048];
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    fileInputStream = new FileInputStream(file);
                    while (true) {
                        try {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            messageDigest.update(bArr, 0, read);
                        } catch (Throwable th) {
                            th = th;
                            try {
                                C1002fl.m18028a(th, "MD5", "getMd5FromFile");
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e) {
                                        C1002fl.m18028a(e, "MD5", "getMd5FromFile");
                                    }
                                }
                                return str2;
                            } finally {
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e2) {
                                        C1002fl.m18028a(e2, "MD5", "getMd5FromFile");
                                    }
                                }
                            }
                        }
                    }
                    str2 = C0999fi.m18037d(messageDigest.digest());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            C1002fl.m18028a(e3, "MD5", "getMd5FromFile");
                        }
                    }
                } else if (0 != 0) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        C1002fl.m18028a(e4, "MD5", "getMd5FromFile");
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        return str2;
    }

    /* renamed from: a */
    public static String m18094a(byte[] bArr) {
        return C0999fi.m18037d(m18091b(bArr));
    }

    /* renamed from: a */
    public static byte[] m18093a(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable th) {
            C1002fl.m18028a(th, "MD5", "getMd5Bytes1");
            return null;
        }
    }

    /* renamed from: b */
    public static String m18092b(String str) {
        if (str == null) {
            return null;
        }
        return C0999fi.m18037d(m18089d(str));
    }

    /* renamed from: b */
    private static byte[] m18091b(byte[] bArr) {
        return m18093a(bArr, "MD5");
    }

    /* renamed from: c */
    public static String m18090c(String str) {
        return C0999fi.m18035e(m18088e(str));
    }

    /* renamed from: d */
    public static byte[] m18089d(String str) {
        try {
            return m18087f(str);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "MD5", "getMd5Bytes");
            return new byte[0];
        }
    }

    /* renamed from: e */
    private static byte[] m18088e(String str) {
        try {
            return m18087f(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    /* renamed from: f */
    private static byte[] m18087f(String str) {
        if (str == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(C0999fi.m18047a(str));
        return messageDigest.digest();
    }
}
