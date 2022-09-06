package com.p219mi.live.openlivesdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.util.List;
/* renamed from: com.mi.live.openlivesdk.d */
/* loaded from: classes.dex */
public class C4100d {

    /* renamed from: a */
    public static final String f17123a = "com.wali.live";

    /* renamed from: b */
    public static final int f17124b = 101020;

    /* renamed from: c */
    public static final int f17125c = 1;

    /* renamed from: d */
    public static final int f17126d = -2;

    /* renamed from: e */
    public static final int f17127e = -3;

    /* renamed from: a */
    public static int m6203a(Context context) {
        int i = 0;
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            while (true) {
                int i2 = i;
                if (i2 >= installedPackages.size()) {
                    break;
                }
                PackageInfo packageInfo = installedPackages.get(i2);
                if (f17123a.equals(packageInfo.packageName)) {
                    return packageInfo.versionCode >= 101020 ? 1 : -3;
                }
                i = i2 + 1;
            }
        }
        return -2;
    }
}
