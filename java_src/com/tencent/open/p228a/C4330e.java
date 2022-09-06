package com.tencent.open.p228a;

import android.util.Log;
/* renamed from: com.tencent.open.a.e */
/* loaded from: classes.dex */
public final class C4330e extends AbstractC4334i {

    /* renamed from: a */
    public static final C4330e f18116a = new C4330e();

    @Override // com.tencent.open.p228a.AbstractC4334i
    /* renamed from: a */
    protected void mo5431a(int i, Thread thread, long j, String str, String str2, Throwable th) {
        switch (i) {
            case 1:
                Log.v(str, str2, th);
                return;
            case 2:
                Log.d(str, str2, th);
                return;
            case 4:
                Log.i(str, str2, th);
                return;
            case 8:
                Log.w(str, str2, th);
                return;
            case 16:
                Log.e(str, str2, th);
                return;
            case 32:
                Log.e(str, str2, th);
                return;
            default:
                return;
        }
    }
}
