package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.reflect.C4500a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* renamed from: com.xiaomi.channel.commonutils.android.j */
/* loaded from: classes.dex */
public class C4473j {

    /* renamed from: a */
    private static Context f18528a;

    /* renamed from: a */
    public static Context m5067a() {
        return f18528a;
    }

    /* renamed from: a */
    public static void m5066a(Context context) {
        f18528a = context.getApplicationContext();
    }

    /* renamed from: b */
    public static String m5065b() {
        String m5082c = C4468e.m5082c(f18528a);
        if (m5082c == null) {
            m5082c = C4468e.m5080e(f18528a);
        }
        if (m5082c != null) {
            try {
                return Base64.encodeToString(MessageDigest.getInstance("SHA1").digest(m5082c.getBytes()), 8).substring(0, 16);
            } catch (NoSuchAlgorithmException e) {
                AbstractC4478b.m5039a(e);
            }
        }
        return null;
    }

    /* renamed from: b */
    public static boolean m5064b(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            AbstractC4478b.m5039a(e);
            return false;
        }
    }

    /* renamed from: c */
    public static int m5063c() {
        try {
            Class<?> cls = Class.forName("miui.os.Build");
            if (cls.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            return cls.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
        } catch (Exception e) {
            return 0;
        }
    }

    /* renamed from: d */
    public static boolean m5062d() {
        return TextUtils.equals((String) C4500a.m4971a("android.os.SystemProperties", "get", "sys.boot_completed"), "1");
    }
}
