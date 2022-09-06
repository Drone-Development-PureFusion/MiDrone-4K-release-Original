package com.p080b;

import android.content.Context;
import java.lang.Thread;
/* renamed from: com.b.b */
/* loaded from: classes.dex */
public class C1450b {

    /* renamed from: a */
    protected static C1450b f5023a;

    /* renamed from: b */
    protected Thread.UncaughtExceptionHandler f5024b;

    /* renamed from: c */
    protected boolean f5025c = true;

    /* renamed from: a */
    public static void m16187a(Throwable th, String str, String str2) {
        th.printStackTrace();
        if (f5023a != null) {
            f5023a.mo15875a(th, 1, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15878a(Context context, C1549dv c1549dv, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15876a(C1549dv c1549dv, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15875a(Throwable th, int i, String str, String str2) {
    }
}
