package com.amap.api.mapcore.util;

import android.content.Context;
import java.lang.Thread;
/* renamed from: com.amap.api.mapcore.util.fl */
/* loaded from: classes.dex */
public class C1002fl {

    /* renamed from: a */
    protected static C1002fl f3157a;

    /* renamed from: b */
    protected Thread.UncaughtExceptionHandler f3158b;

    /* renamed from: c */
    protected boolean f3159c = true;

    /* renamed from: a */
    public static void m18028a(Throwable th, String str, String str2) {
        th.printStackTrace();
        if (f3157a != null) {
            f3157a.mo18014a(th, 1, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo18016a(Context context, C0996fh c0996fh, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo18014a(Throwable th, int i, String str, String str2) {
    }
}
