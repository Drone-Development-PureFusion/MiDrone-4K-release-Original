package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.mipush.sdk.i */
/* loaded from: classes2.dex */
public final class RunnableC4533i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f18646a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4533i(Context context) {
        this.f18646a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageInfo packageInfo = this.f18646a.getPackageManager().getPackageInfo(this.f18646a.getPackageName(), 4612);
            C4530h.m4849c(this.f18646a);
            C4530h.m4847d(this.f18646a, packageInfo);
            C4530h.m4848c(this.f18646a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
