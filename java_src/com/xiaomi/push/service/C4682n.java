package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.android.C4464b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.C4612ak;
import java.util.Locale;
/* renamed from: com.xiaomi.push.service.n */
/* loaded from: classes.dex */
public class C4682n {

    /* renamed from: a */
    public final String f19164a;

    /* renamed from: b */
    public final String f19165b;

    /* renamed from: c */
    public final String f19166c;

    /* renamed from: d */
    public final String f19167d;

    /* renamed from: e */
    public final String f19168e;

    /* renamed from: f */
    public final String f19169f;

    /* renamed from: g */
    public final int f19170g;

    public C4682n(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.f19164a = str;
        this.f19165b = str2;
        this.f19166c = str3;
        this.f19167d = str4;
        this.f19168e = str5;
        this.f19169f = str6;
        this.f19170g = i;
    }

    /* renamed from: a */
    public static boolean m4143a() {
        try {
            return Class.forName("miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m4142a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && m4143a();
    }

    /* renamed from: b */
    private static boolean m4139b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    /* renamed from: a */
    public C4612ak.C4614b m4141a(XMPushService xMPushService) {
        C4612ak.C4614b c4614b = new C4612ak.C4614b(xMPushService);
        m4140a(c4614b, xMPushService, xMPushService.m4459e(), "c");
        return c4614b;
    }

    /* renamed from: a */
    public C4612ak.C4614b m4140a(C4612ak.C4614b c4614b, Context context, C4643b c4643b, String str) {
        c4614b.f18954a = context.getPackageName();
        c4614b.f18955b = this.f19164a;
        c4614b.f18962i = this.f19166c;
        c4614b.f18956c = this.f19165b;
        c4614b.f18961h = "5";
        c4614b.f18957d = "XMPUSH-PASS";
        c4614b.f18958e = false;
        String str2 = "";
        if (m4139b(context)) {
            str2 = C4464b.m5094d(context);
        }
        c4614b.f18959f = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s:%7$s:%8$s", "sdk_ver", 26, "cpvn", "3_2_1", "cpvc", 30201, "aapn", str2);
        c4614b.f18960g = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s,sync:1", "appid", m4139b(context) ? "1000271" : this.f19167d, "locale", Locale.getDefault().toString(), Constants.EXTRA_KEY_MIID, C4670k.m4213a(context).m4206c());
        if (m4142a(context)) {
            c4614b.f18960g += String.format(",%1$s:%2$s", "ab", str);
        }
        c4614b.f18964k = c4643b;
        return c4614b;
    }
}
