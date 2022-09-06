package com.fimi.soul.module.login;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.p001v4.content.ContextCompat;
/* loaded from: classes.dex */
public class ActivityCompat extends ContextCompat {

    /* renamed from: com.fimi.soul.module.login.ActivityCompat$a */
    /* loaded from: classes.dex */
    public interface AbstractC3335a {
        /* renamed from: a */
        void m8676a(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    /* renamed from: com.fimi.soul.module.login.ActivityCompat$b */
    /* loaded from: classes.dex */
    public interface AbstractC3336b {
        /* renamed from: a */
        void m8675a(int i);
    }

    /* renamed from: a */
    public static int m8677a(@NonNull Context context, @NonNull String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    /* renamed from: a */
    public static void m8678a(@NonNull final Activity activity, @NonNull final String[] strArr, final int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof AbstractC3336b) {
                ((AbstractC3336b) activity).m8675a(i);
            }
            activity.requestPermissions(strArr, i);
        } else if (!(activity instanceof AbstractC3335a)) {
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.fimi.soul.module.login.ActivityCompat.1
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
                    }
                    ((AbstractC3335a) activity).m8676a(i, strArr, iArr);
                }
            });
        }
    }

    /* renamed from: a */
    public static boolean m8679a(@NonNull Activity activity, @NonNull String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }
}
