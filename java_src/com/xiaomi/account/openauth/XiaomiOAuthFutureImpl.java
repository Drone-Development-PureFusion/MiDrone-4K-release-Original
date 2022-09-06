package com.xiaomi.account.openauth;

import android.accounts.OperationCanceledException;
import android.os.Looper;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes2.dex */
class XiaomiOAuthFutureImpl<V> extends FutureTask<V> implements XiaomiOAuthFuture<V> {
    private static final long DEFAULT_TIMEOUT_MINUTE = 10;

    /* JADX INFO: Access modifiers changed from: package-private */
    public XiaomiOAuthFutureImpl() {
        super(new Callable<V>() { // from class: com.xiaomi.account.openauth.XiaomiOAuthFutureImpl.1
            @Override // java.util.concurrent.Callable
            public V call() {
                throw new IllegalStateException("this should never be called");
            }
        });
    }

    private void ensureNotOnMainThread() {
        Looper myLooper = Looper.myLooper();
        if (myLooper == null || myLooper != Looper.getMainLooper()) {
            return;
        }
        throw new IllegalStateException("calling this from your main thread can lead to deadlock");
    }

    private V internalGetResult(Long l, TimeUnit timeUnit) {
        V v;
        if (!isDone()) {
            ensureNotOnMainThread();
        }
        try {
            try {
                try {
                    if (l == null) {
                        v = get();
                        cancel(true);
                    } else {
                        v = get(l.longValue(), timeUnit);
                        cancel(true);
                    }
                    return v;
                } catch (InterruptedException e) {
                    cancel(true);
                    throw new OperationCanceledException();
                } catch (CancellationException e2) {
                    throw new OperationCanceledException();
                }
            } catch (ExecutionException e3) {
                Throwable cause = e3.getCause();
                if (cause instanceof IOException) {
                    throw ((IOException) cause);
                }
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                if (cause instanceof XMAuthericationException) {
                    throw ((XMAuthericationException) cause);
                }
                if (!(cause instanceof OperationCanceledException)) {
                    throw new IllegalStateException(cause);
                }
                throw ((OperationCanceledException) cause);
            } catch (TimeoutException e4) {
                cancel(true);
                throw new OperationCanceledException();
            }
        } catch (Throwable th) {
            cancel(true);
            throw th;
        }
    }

    @Override // com.xiaomi.account.openauth.XiaomiOAuthFuture
    public V getResult() {
        return internalGetResult(Long.valueOf((long) DEFAULT_TIMEOUT_MINUTE), TimeUnit.MINUTES);
    }

    @Override // com.xiaomi.account.openauth.XiaomiOAuthFuture
    public V getResult(long j, TimeUnit timeUnit) {
        return internalGetResult(Long.valueOf(j), timeUnit);
    }

    @Override // java.util.concurrent.FutureTask, com.xiaomi.account.openauth.XiaomiOAuthFuture
    public void set(V v) {
        super.set(v);
    }

    @Override // java.util.concurrent.FutureTask, com.xiaomi.account.openauth.XiaomiOAuthFuture
    public void setException(Throwable th) {
        super.setException(th);
    }
}
