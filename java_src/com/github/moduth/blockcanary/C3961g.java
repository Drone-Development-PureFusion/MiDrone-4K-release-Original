package com.github.moduth.blockcanary;

import android.os.Handler;
import android.os.HandlerThread;
/* renamed from: com.github.moduth.blockcanary.g */
/* loaded from: classes.dex */
class C3961g {

    /* renamed from: a */
    private static C3962a f16972a = new C3962a("loop");

    /* renamed from: b */
    private static C3962a f16973b = new C3962a("writelog");

    /* renamed from: com.github.moduth.blockcanary.g$a */
    /* loaded from: classes.dex */
    private static class C3962a {

        /* renamed from: a */
        private Handler f16974a;

        public C3962a(String str) {
            this.f16974a = null;
            HandlerThread handlerThread = new HandlerThread("BlockCanaryThread_" + str);
            handlerThread.start();
            this.f16974a = new Handler(handlerThread.getLooper());
        }

        /* renamed from: a */
        public Handler m6371a() {
            return this.f16974a;
        }
    }

    private C3961g() {
        throw new InstantiationError("Must not instantiate this class");
    }

    /* renamed from: a */
    public static Handler m6373a() {
        return f16972a.m6371a();
    }

    /* renamed from: b */
    public static Handler m6372b() {
        return f16973b.m6371a();
    }
}
