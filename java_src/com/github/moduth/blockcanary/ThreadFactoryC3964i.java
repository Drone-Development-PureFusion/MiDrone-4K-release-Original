package com.github.moduth.blockcanary;

import java.util.concurrent.ThreadFactory;
/* renamed from: com.github.moduth.blockcanary.i */
/* loaded from: classes.dex */
final class ThreadFactoryC3964i implements ThreadFactory {

    /* renamed from: a */
    private final String f16975a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThreadFactoryC3964i(String str) {
        this.f16975a = "LeakCanary-" + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f16975a);
    }
}
