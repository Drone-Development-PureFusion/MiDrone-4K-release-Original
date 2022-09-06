package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.mipush.sdk.n */
/* loaded from: classes2.dex */
public final class RunnableC4538n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String[] f18652a;

    /* renamed from: b */
    final /* synthetic */ Context f18653b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4538n(String[] strArr, Context context) {
        this.f18652a = strArr;
        this.f18653b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        String[] strArr;
        PackageInfo packageInfo;
        try {
            for (String str : this.f18652a) {
                if (!TextUtils.isEmpty(str) && (packageInfo = this.f18653b.getPackageManager().getPackageInfo(str, 4)) != null) {
                    MiPushClient.awakePushServiceByPackageInfo(this.f18653b, packageInfo);
                }
            }
        } catch (Throwable th) {
            AbstractC4478b.m5039a(th);
        }
    }
}
