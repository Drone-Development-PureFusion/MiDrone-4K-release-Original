package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.File;
/* loaded from: classes.dex */
public final class Global {

    /* renamed from: a */
    private static Context f18191a;

    public static final Context getContext() {
        if (f18191a == null) {
            return null;
        }
        return f18191a;
    }

    public static final File getFilesDir() {
        if (getContext() == null) {
            return null;
        }
        return getContext().getFilesDir();
    }

    public static final String getPackageName() {
        return getContext() == null ? "" : getContext().getPackageName();
    }

    public static final SharedPreferences getSharedPreferences(String str, int i) {
        if (getContext() == null) {
            return null;
        }
        return getContext().getSharedPreferences(str, i);
    }

    public static int getVersionCode() {
        return f18191a.getSharedPreferences("openSdk.pref", 0).getInt("app.vercode", 0);
    }

    public static void saveVersionCode() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo == null) {
                return;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("openSdk.pref", 0).edit();
            edit.putInt("app.vercode", packageInfo.versionCode);
            edit.commit();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static final void setContext(Context context) {
        f18191a = context;
    }
}
