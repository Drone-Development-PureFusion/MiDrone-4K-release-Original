package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* renamed from: com.amap.api.mapcore.util.dq */
/* loaded from: classes.dex */
public abstract class AbstractC0911dq<Params, Progress, Result> {

    /* renamed from: c */
    public static final Executor f2805c;

    /* renamed from: d */
    public static final Executor f2806d;

    /* renamed from: f */
    private static final HandlerC0917b f2808f;

    /* renamed from: g */
    private static volatile Executor f2809g;

    /* renamed from: a */
    private static final ThreadFactory f2803a = new ThreadFactory() { // from class: com.amap.api.mapcore.util.dq.1

        /* renamed from: a */
        private final AtomicInteger f2815a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.f2815a.getAndIncrement());
        }
    };

    /* renamed from: e */
    private static final BlockingQueue<Runnable> f2807e = new LinkedBlockingQueue(10);

    /* renamed from: b */
    public static final Executor f2804b = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f2807e, f2803a, new ThreadPoolExecutor.DiscardOldestPolicy());

    /* renamed from: j */
    private volatile EnumC0920d f2812j = EnumC0920d.PENDING;

    /* renamed from: k */
    private final AtomicBoolean f2813k = new AtomicBoolean();

    /* renamed from: l */
    private final AtomicBoolean f2814l = new AtomicBoolean();

    /* renamed from: h */
    private final AbstractCallableC0921e<Params, Result> f2810h = new AbstractCallableC0921e<Params, Result>() { // from class: com.amap.api.mapcore.util.dq.2
        @Override // java.util.concurrent.Callable
        public Result call() {
            AbstractC0911dq.this.f2814l.set(true);
            Process.setThreadPriority(10);
            return (Result) AbstractC0911dq.this.m18481d(AbstractC0911dq.this.mo18398a((Object[]) this.f2829b));
        }
    };

    /* renamed from: i */
    private final FutureTask<Result> f2811i = new FutureTask<Result>(this.f2810h) { // from class: com.amap.api.mapcore.util.dq.3
        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                AbstractC0911dq.this.m18484c((AbstractC0911dq) AbstractC0911dq.this.f2811i.get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e);
            } catch (CancellationException e2) {
                AbstractC0911dq.this.m18484c((AbstractC0911dq) null);
            } catch (ExecutionException e3) {
                throw new RuntimeException("An error occured while executing doInBackground()", e3.getCause());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.amap.api.mapcore.util.dq$a */
    /* loaded from: classes.dex */
    public static class C0916a<Data> {

        /* renamed from: a */
        final AbstractC0911dq f2819a;

        /* renamed from: b */
        final Data[] f2820b;

        C0916a(AbstractC0911dq abstractC0911dq, Data... dataArr) {
            this.f2819a = abstractC0911dq;
            this.f2820b = dataArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.amap.api.mapcore.util.dq$b */
    /* loaded from: classes.dex */
    public static class HandlerC0917b extends Handler {
        private HandlerC0917b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.obj == null || !(message.obj instanceof C0916a)) {
                return;
            }
            try {
                C0916a c0916a = (C0916a) message.obj;
                switch (message.what) {
                    case 1:
                        c0916a.f2819a.m18480e(c0916a.f2820b[0]);
                        break;
                    case 2:
                        c0916a.f2819a.m18487b((Object[]) c0916a.f2820b);
                        break;
                }
            } catch (ClassCastException e) {
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.dq$c */
    /* loaded from: classes.dex */
    private static class ExecutorC0918c implements Executor {

        /* renamed from: a */
        final ArrayDeque<Runnable> f2821a;

        /* renamed from: b */
        Runnable f2822b;

        private ExecutorC0918c() {
            this.f2821a = new ArrayDeque<>();
        }

        /* renamed from: a */
        protected synchronized void m18479a() {
            Runnable poll = this.f2821a.poll();
            this.f2822b = poll;
            if (poll != null) {
                AbstractC0911dq.f2804b.execute(this.f2822b);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.f2821a.offer(new Runnable() { // from class: com.amap.api.mapcore.util.dq.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        ExecutorC0918c.this.m18479a();
                    }
                }
            });
            if (this.f2822b == null) {
                m18479a();
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.dq$d */
    /* loaded from: classes.dex */
    public enum EnumC0920d {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.amap.api.mapcore.util.dq$e */
    /* loaded from: classes.dex */
    public static abstract class AbstractCallableC0921e<Params, Result> implements Callable<Result> {

        /* renamed from: b */
        Params[] f2829b;

        private AbstractCallableC0921e() {
        }
    }

    static {
        f2805c = C0945eh.m18313c() ? new ExecutorC0918c() : Executors.newSingleThreadExecutor(f2803a);
        f2806d = Executors.newFixedThreadPool(2, f2803a);
        f2808f = new HandlerC0917b();
        f2809g = f2805c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m18484c(Result result) {
        if (!this.f2814l.get()) {
            m18481d(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public Result m18481d(Result result) {
        f2808f.obtainMessage(1, new C0916a(this, result)).sendToTarget();
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m18480e(Result result) {
        if (m18482d()) {
            mo18400b((AbstractC0911dq<Params, Progress, Result>) result);
        } else {
            mo18403a((AbstractC0911dq<Params, Progress, Result>) result);
        }
        this.f2812j = EnumC0920d.FINISHED;
    }

    /* renamed from: a */
    public final EnumC0920d m18495a() {
        return this.f2812j;
    }

    /* renamed from: a */
    public final AbstractC0911dq<Params, Progress, Result> m18492a(Executor executor, Params... paramsArr) {
        if (this.f2812j != EnumC0920d.PENDING) {
            switch (this.f2812j) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f2812j = EnumC0920d.RUNNING;
        m18490b();
        this.f2810h.f2829b = paramsArr;
        executor.execute(this.f2811i);
        return this;
    }

    /* renamed from: a */
    protected abstract Result mo18398a(Params... paramsArr);

    /* renamed from: a */
    protected void mo18403a(Result result) {
    }

    /* renamed from: a */
    public final boolean m18491a(boolean z) {
        this.f2813k.set(true);
        return this.f2811i.cancel(z);
    }

    /* renamed from: b */
    protected void m18490b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void mo18400b(Result result) {
        m18486c();
    }

    /* renamed from: b */
    protected void m18487b(Progress... progressArr) {
    }

    /* renamed from: c */
    public final AbstractC0911dq<Params, Progress, Result> m18483c(Params... paramsArr) {
        return m18492a(f2809g, paramsArr);
    }

    /* renamed from: c */
    protected void m18486c() {
    }

    /* renamed from: d */
    public final boolean m18482d() {
        return this.f2813k.get();
    }
}
