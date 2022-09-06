package com.xiaomi.push.service;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.metok.geofencing.C4513a;
import com.xiaomi.xmpush.thrift.C4809j;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: com.xiaomi.push.service.h */
/* loaded from: classes2.dex */
public class C4662h {
    /* renamed from: a */
    public static void m4250a(Context context, String str) {
        ArrayList<C4809j> m4266b = C4659e.m4274a(context).m4266b(str);
        if (m4266b == null || m4266b.size() < 1) {
            return;
        }
        if (C4659e.m4274a(context).m4261e(str) == 0) {
            AbstractC4478b.m5041a("appIsUninstalled. failed to delete geofencing with package name. name:" + str);
        }
        Iterator<C4809j> it2 = m4266b.iterator();
        while (it2.hasNext()) {
            C4809j next = it2.next();
            if (next == null) {
                AbstractC4478b.m5041a("appIsUninstalled. failed to find geofence with package name. name:" + str);
                return;
            }
            m4249a(next.m3417a(), context);
            if (C4661g.m4257a(context).m4253b(next.m3417a()) == 0) {
                AbstractC4478b.m5041a("appIsUninstalled. failed to delete geoMessage with package name. name:" + str + ", geoId:" + next.m3417a());
            }
        }
    }

    /* renamed from: a */
    public static void m4249a(String str, Context context) {
        new C4513a(context).m4936a(context, "com.xiaomi.xmsf", str);
    }

    /* renamed from: a */
    public static boolean m4251a(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo("com.xiaomi.metok", 8192);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        return packageInfo != null && packageInfo.versionCode >= 20;
    }

    /* renamed from: b */
    public static boolean m4248b(Context context) {
        return TextUtils.equals(context.getPackageName(), "com.xiaomi.xmsf");
    }
}
