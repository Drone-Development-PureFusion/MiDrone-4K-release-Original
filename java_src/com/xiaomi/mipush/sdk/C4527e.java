package com.xiaomi.mipush.sdk;

import android.net.wifi.ScanResult;
import java.util.Comparator;
/* renamed from: com.xiaomi.mipush.sdk.e */
/* loaded from: classes2.dex */
class C4527e implements Comparator<ScanResult> {

    /* renamed from: a */
    final /* synthetic */ C4526d f18634a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4527e(C4526d c4526d) {
        this.f18634a = c4526d;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult2.level - scanResult.level;
    }
}
