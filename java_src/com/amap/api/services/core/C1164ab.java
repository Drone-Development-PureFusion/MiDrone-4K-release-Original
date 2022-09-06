package com.amap.api.services.core;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* renamed from: com.amap.api.services.core.ab */
/* loaded from: classes.dex */
public class C1164ab {
    /* renamed from: a */
    public static String m17277a(String str) {
        if (str == null) {
            return null;
        }
        return C1169ae.m17244c(m17273c(str));
    }

    /* renamed from: a */
    public static String m17276a(byte[] bArr) {
        return C1169ae.m17244c(m17274b(bArr));
    }

    /* renamed from: b */
    public static String m17275b(String str) {
        return C1169ae.m17243d(m17272d(str));
    }

    /* renamed from: b */
    private static byte[] m17274b(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            C1190ay.m17177a(e, "MD5", "getMd5Bytes");
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            C1190ay.m17177a(th, "MD5", "getMd5Bytes1");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static byte[] m17273c(String str) {
        try {
            return m17271e(str);
        } catch (UnsupportedEncodingException e) {
            C1190ay.m17177a(e, "MD5", "getMd5Bytes");
            e.printStackTrace();
            return new byte[0];
        } catch (NoSuchAlgorithmException e2) {
            C1190ay.m17177a(e2, "MD5", "getMd5Bytes");
            e2.printStackTrace();
            return new byte[0];
        } catch (Throwable th) {
            C1190ay.m17177a(th, "MD5", "getMd5Bytes");
            th.printStackTrace();
            return new byte[0];
        }
    }

    /* renamed from: d */
    private static byte[] m17272d(String str) {
        try {
            return m17271e(str);
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

    /* renamed from: e */
    private static byte[] m17271e(String str) {
        if (str == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(str.getBytes("utf-8"));
        return messageDigest.digest();
    }
}
