package com.fimi.p138a;

import android.os.Looper;
/* renamed from: com.fimi.a.a */
/* loaded from: classes.dex */
public class C2081a extends RuntimeException {
    public C2081a() {
        super("应用程序无响应，快来改BUG啊");
        setStackTrace(Looper.getMainLooper().getThread().getStackTrace());
    }
}
