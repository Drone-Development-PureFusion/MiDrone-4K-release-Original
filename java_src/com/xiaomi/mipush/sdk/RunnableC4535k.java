package com.xiaomi.mipush.sdk;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.mipush.sdk.k */
/* loaded from: classes2.dex */
public final class RunnableC4535k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f18649a;

    /* renamed from: b */
    final /* synthetic */ String f18650b;

    /* renamed from: c */
    final /* synthetic */ String f18651c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC4535k(Context context, String str, String str2) {
        this.f18649a = context;
        this.f18650b = str;
        this.f18651c = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        MiPushClient.initialize(this.f18649a, this.f18650b, this.f18651c, null);
    }
}
