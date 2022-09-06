package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.xmpush.thrift.C4766ab;
import java.util.Map;
/* renamed from: com.xiaomi.push.service.ay */
/* loaded from: classes2.dex */
public class C4641ay {

    /* renamed from: a */
    public static Runnable f19059a;

    /* renamed from: a */
    private static String m4296a(Context context, String str) {
        return context.getSharedPreferences("typed_shield_pref", 0).getString(str + "_title", str);
    }

    /* renamed from: a */
    public static String m4295a(C4766ab c4766ab) {
        Map<String, String> m3271s = c4766ab.m3727m().m3271s();
        if (m3271s == null) {
            return null;
        }
        return m3271s.get("__typed_shield_type");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(19)
    /* renamed from: a */
    public static void m4297a(Context context, C4766ab c4766ab, Notification notification) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        String m4295a = m4295a(c4766ab);
        if (TextUtils.isEmpty(m4295a) || !"com.xiaomi.xmsf".equals(C4600ac.m4421a(c4766ab))) {
            return;
        }
        Bundle bundle = notification.extras;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("miui.category", m4295a);
        bundle.putString("miui.substName", m4296a(context, m4295a));
        notification.extras = bundle;
    }

    /* renamed from: a */
    public static boolean m4298a(Context context, C4766ab c4766ab) {
        if (!"com.xiaomi.xmsf".equals(C4600ac.m4421a(c4766ab))) {
            return false;
        }
        String m4295a = m4295a(c4766ab);
        if (TextUtils.isEmpty(m4295a)) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("typed_shield_pref", 0);
        if (!sharedPreferences.contains(m4295a + "_shield") && f19059a != null) {
            f19059a.run();
        }
        return sharedPreferences.getBoolean(m4295a + "_shield", true);
    }
}
