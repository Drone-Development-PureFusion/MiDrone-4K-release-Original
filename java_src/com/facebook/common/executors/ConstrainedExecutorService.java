package com.facebook.common.executors;

import com.facebook.common.logging.FLog;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ConstrainedExecutorService extends AbstractExecutorService {
    private static final Class<?> TAG = ConstrainedExecutorService.class;
    private final Executor mExecutor;
    private volatile int mMaxConcurrency;
    private final AtomicInteger mMaxQueueSize;
    private final String mName;
    private final AtomicInteger mPendingWorkers;
    private final Worker mTaskRunner;
    private final BlockingQueue<Runnable> mWorkQueue;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class Worker implements Runnable {
        private Worker() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnable = (Runnable) ConstrainedExecutorService.this.mWorkQueue.poll();
                if (runnable != null) {
                    runnable.run();
                } else {
                    FLog.m13782v(ConstrainedExecutorService.TAG, "%s: Worker has nothing to run", ConstrainedExecutorService.this.mName);
                }
                int decrementAndGet = ConstrainedExecutorService.this.mPendingWorkers.decrementAndGet();
                if (!ConstrainedExecutorService.this.mWorkQueue.isEmpty()) {
                    ConstrainedExecutorService.this.startWorkerIfNeeded();
                } else {
                    FLog.m13781v(ConstrainedExecutorService.TAG, "%s: worker finished; %d workers left", ConstrainedExecutorService.this.mName, Integer.valueOf(decrementAndGet));
                }
            } catch (Throwable th) {
                int decrementAndGet2 = ConstrainedExecutorService.this.mPendingWorkers.decrementAndGet();
                if (!ConstrainedExecutorService.this.mWorkQueue.isEmpty()) {
                    ConstrainedExecutorService.this.startWorkerIfNeeded();
                } else {
                    FLog.m13781v(ConstrainedExecutorService.TAG, "%s: worker finished; %d workers left", ConstrainedExecutorService.this.mName, Integer.valueOf(decrementAndGet2));
                }
                throw th;
            }
        }
    }

    public ConstrainedExecutorService(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.mName = str;
        this.mExecutor = executor;
        this.mMaxConcurrency = i;
        this.mWorkQueue = blockingQueue;
        this.mTaskRunner = new Worker();
        this.mPendingWorkers = new AtomicInteger(0);
        this.mMaxQueueSize = new AtomicInteger(0);
    }

    public static ConstrainedExecutorService newConstrainedExecutor(String str, int i, int i2, Executor executor) {
        return new ConstrainedExecutorService(str, i, executor, new LinkedBlockingQueue(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startWorkerIfNeeded() {
        int i = this.mPendingWorkers.get();
        while (i < this.mMaxConcurrency) {
            int i2 = i + 1;
            if (this.mPendingWorkers.compareAndSet(i, i2)) {
                FLog.m13780v(TAG, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.mMaxConcurrency));
                this.mExecutor.execute(this.mTaskRunner);
                return;
            }
            FLog.m13782v(TAG, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.mPendingWorkers.get();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.mWorkQueue.offer(runnable)) {
            throw new RejectedExecutionException(this.mName + " queue is full, size=" + this.mWorkQueue.size());
        }
        int size = this.mWorkQueue.size();
        int i = this.mMaxQueueSize.get();
        if (size > i && this.mMaxQueueSize.compareAndSet(i, size)) {
            FLog.m13781v(TAG, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(size));
        }
        startWorkerIfNeeded();
    }

    public boolean isIdle() {
        return this.mWorkQueue.isEmpty() && this.mPendingWorkers.get() == 0;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }
}
