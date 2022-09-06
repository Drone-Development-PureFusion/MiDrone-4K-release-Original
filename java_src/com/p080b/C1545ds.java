package com.p080b;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* renamed from: com.b.ds */
/* loaded from: classes.dex */
public class C1545ds {
    /* renamed from: a */
    public static String m15599a(String str) {
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
                                C1450b.m16187a(th, "MD5", "getMd5FromFile");
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e) {
                                        C1450b.m16187a(e, "MD5", "getMd5FromFile");
                                    }
                                }
                                return str2;
                            } finally {
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e2) {
                                        C1450b.m16187a(e2, "MD5", "getMd5FromFile");
                                    }
                                }
                            }
                        }
                    }
                    str2 = C1552dw.m15553c(messageDigest.digest());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            C1450b.m16187a(e3, "MD5", "getMd5FromFile");
                        }
                    }
                } else if (0 != 0) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        C1450b.m16187a(e4, "MD5", "getMd5FromFile");
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
    public static String m15598a(byte[] bArr) {
        return C1552dw.m15553c(m15595b(bArr));
    }

    /* renamed from: a */
    public static byte[] m15597a(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            C1450b.m16187a(e, "MD5", "getMd5Bytes");
            return null;
        } catch (Throwable th) {
            C1450b.m16187a(th, "MD5", "getMd5Bytes1");
            return null;
        }
    }

    /* renamed from: b */
    public static String m15596b(String str) {
        if (str == null) {
            return null;
        }
        return C1552dw.m15553c(m15593d(str));
    }

    /* renamed from: b */
    private static byte[] m15595b(byte[] bArr) {
        return m15597a(bArr, "MD5");
    }

    /* renamed from: c */
    public static String m15594c(String str) {
        return C1552dw.m15552d(m15592e(str));
    }

    /* renamed from: d */
    public static byte[] m15593d(String str) {
        try {
            return m15591f(str);
        } catch (UnsupportedEncodingException e) {
            C1450b.m16187a(e, "MD5", "getMd5Bytes");
            return new byte[0];
        } catch (NoSuchAlgorithmException e2) {
            C1450b.m16187a(e2, "MD5", "getMd5Bytes");
            return new byte[0];
        } catch (Throwable th) {
            C1450b.m16187a(th, "MD5", "getMd5Bytes");
            return new byte[0];
        }
    }

    /* renamed from: e */
    private static byte[] m15592e(String str) {
        try {
            return m15591f(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new byte[0];
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return new byte[0];
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    /* renamed from: f */
    private static byte[] m15591f(String str) {
        if (str == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(str.getBytes("UTF-8"));
        return messageDigest.digest();
    }
}
