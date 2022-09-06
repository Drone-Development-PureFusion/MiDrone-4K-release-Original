package com.fimi.soul.utils;

import java.security.MessageDigest;
/* renamed from: com.fimi.soul.utils.aw */
/* loaded from: classes.dex */
public class C3671aw {
    /* renamed from: a */
    public static String m7513a(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return String.valueOf(m7511a(messageDigest.digest()));
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m7512a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        try {
            if (str2.length() < 1 || str2.length() > 128) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update((str + str2).getBytes());
            return String.valueOf(m7511a(messageDigest.digest()));
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m7511a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            if (b == 0) {
                stringBuffer.append("00");
            } else if (b == -1) {
                stringBuffer.append("ff");
            } else {
                String lowerCase = Integer.toHexString(b).toLowerCase();
                if (lowerCase.length() == 8) {
                    lowerCase = lowerCase.substring(6, 8);
                } else if (lowerCase.length() < 2) {
                    lowerCase = "0" + lowerCase;
                }
                stringBuffer.append(lowerCase);
            }
        }
        return stringBuffer.toString();
    }
}
