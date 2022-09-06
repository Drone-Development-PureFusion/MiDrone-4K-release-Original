package com.android.volley.toolbox;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import com.android.volley.C1337o;
import java.io.File;
/* renamed from: com.android.volley.toolbox.t */
/* loaded from: classes.dex */
public class C1383t {

    /* renamed from: a */
    private static final String f4714a = "volley";

    /* renamed from: a */
    public static C1337o m16574a(Context context) {
        return m16572a(context, (AbstractC1363i) null);
    }

    /* renamed from: a */
    public static C1337o m16573a(Context context, int i) {
        return m16571a(context, null, i);
    }

    /* renamed from: a */
    public static C1337o m16572a(Context context, AbstractC1363i abstractC1363i) {
        return m16571a(context, abstractC1363i, -1);
    }

    /* renamed from: a */
    public static C1337o m16571a(Context context, AbstractC1363i abstractC1363i, int i) {
        String packageName;
        File file = new File(context.getCacheDir(), f4714a);
        String str = "volley/0";
        try {
            str = context.getPackageName() + "/" + context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
        }
        if (abstractC1363i == null) {
            abstractC1363i = Build.VERSION.SDK_INT >= 9 ? new C1364j() : new C1360g(AndroidHttpClient.newInstance(str));
        }
        C1352c c1352c = new C1352c(abstractC1363i);
        C1337o c1337o = i <= -1 ? new C1337o(new C1356f(file), c1352c) : new C1337o(new C1356f(file, i), c1352c);
        c1337o.m16701a();
        return c1337o;
    }
}
