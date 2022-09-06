package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;
/* loaded from: classes.dex */
public class AuthMap {

    /* renamed from: a */
    static final /* synthetic */ boolean f17414a;

    /* renamed from: b */
    private static int f17415b;
    public static AuthMap sInstance;
    public HashMap<String, Auth> authMap = new HashMap<>();
    public final String KEY_CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /* loaded from: classes.dex */
    public static class Auth {
        public AuthDialog dialog;
        public String key;
        public IUiListener listener;
    }

    static {
        f17414a = !AuthMap.class.desiredAssertionStatus();
        f17415b = 0;
    }

    /* renamed from: a */
    private String m5902a(String str, String str2) {
        if (f17414a || str.length() % 2 == 0) {
            StringBuilder sb = new StringBuilder();
            int length = str2.length();
            int length2 = str.length() / 2;
            int i = 0;
            for (int i2 = 0; i2 < length2; i2++) {
                sb.append((char) (Integer.parseInt(str.substring(i2 * 2, (i2 * 2) + 2), 16) ^ str2.charAt(i)));
                i = (i + 1) % length;
            }
            return sb.toString();
        }
        throw new AssertionError();
    }

    public static AuthMap getInstance() {
        if (sInstance == null) {
            sInstance = new AuthMap();
        }
        return sInstance;
    }

    public static int getSerial() {
        int i = f17415b + 1;
        f17415b = i;
        return i;
    }

    public String decode(String str, String str2) {
        return m5902a(str, str2);
    }

    public Auth get(String str) {
        return this.authMap.get(str);
    }

    public String makeKey() {
        int ceil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < ceil; i++) {
            stringBuffer.append(charArray[(int) (Math.random() * length)]);
        }
        return stringBuffer.toString();
    }

    public void remove(String str) {
        this.authMap.remove(str);
    }

    public String set(Auth auth) {
        int serial = getSerial();
        try {
            this.authMap.put("" + serial, auth);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "" + serial;
    }
}
