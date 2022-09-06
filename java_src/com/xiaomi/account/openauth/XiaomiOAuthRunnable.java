package com.xiaomi.account.openauth;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
abstract class XiaomiOAuthRunnable<V> implements Runnable {
    private static ExecutorService sTaskExecutor = Executors.newCachedThreadPool();
    protected XiaomiOAuthFutureImpl<V> mFuture = new XiaomiOAuthFutureImpl<>();

    protected abstract void doRun();

    @Override // java.lang.Runnable
    public final void run() {
        doRun();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XiaomiOAuthFutureImpl<V> start() {
        sTaskExecutor.execute(this);
        return this.mFuture;
    }
}
