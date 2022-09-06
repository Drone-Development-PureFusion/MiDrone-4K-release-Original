package com.facebook.common.executors;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class StatefulRunnable<T> implements Runnable {
    protected static final int STATE_CANCELLED = 2;
    protected static final int STATE_CREATED = 0;
    protected static final int STATE_FAILED = 4;
    protected static final int STATE_FINISHED = 3;
    protected static final int STATE_STARTED = 1;
    protected final AtomicInteger mState = new AtomicInteger(0);

    public void cancel() {
        if (this.mState.compareAndSet(0, 2)) {
            onCancellation();
        }
    }

    protected void disposeResult(T t) {
    }

    /* renamed from: getResult */
    protected abstract T mo21805getResult();

    protected void onCancellation() {
    }

    protected void onFailure(Exception exc) {
    }

    protected void onSuccess(T t) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.mState.compareAndSet(0, 1)) {
            return;
        }
        try {
            T mo21805getResult = mo21805getResult();
            this.mState.set(3);
            try {
                onSuccess(mo21805getResult);
            } finally {
                disposeResult(mo21805getResult);
            }
        } catch (Exception e) {
            this.mState.set(4);
            onFailure(e);
        }
    }
}
