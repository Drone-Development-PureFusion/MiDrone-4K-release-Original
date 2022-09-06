package com.xiaomi.channel.commonutils.android;
/* renamed from: com.xiaomi.channel.commonutils.android.i */
/* loaded from: classes2.dex */
public class C4472i {
    /* renamed from: a */
    public static String m5068a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }
}
