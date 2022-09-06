package org.p290c.p299b.p303d.p306c;

import java.lang.Thread;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.p290c.p312f.p313a.AbstractC5647j;
import org.p290c.p312f.p313a.C5643f;
import org.p290c.p312f.p313a.C5652l;
/* renamed from: org.c.b.d.c.c */
/* loaded from: classes.dex */
public class C5531c extends AbstractC5647j {

    /* renamed from: a */
    private final AbstractC5647j f22600a;

    /* renamed from: b */
    private final TimeUnit f22601b;

    /* renamed from: c */
    private final long f22602c;

    /* renamed from: d */
    private final boolean f22603d;

    /* renamed from: e */
    private volatile ThreadGroup f22604e;

    /* renamed from: org.c.b.d.c.c$a */
    /* loaded from: classes2.dex */
    public static class C5533a {

        /* renamed from: a */
        private boolean f22605a;

        /* renamed from: b */
        private long f22606b;

        /* renamed from: c */
        private TimeUnit f22607c;

        private C5533a() {
            this.f22605a = false;
            this.f22606b = 0L;
            this.f22607c = TimeUnit.SECONDS;
        }

        /* renamed from: a */
        public C5533a m851a(long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException("timeout must be non-negative");
            }
            if (timeUnit == null) {
                throw new NullPointerException("TimeUnit cannot be null");
            }
            this.f22606b = j;
            this.f22607c = timeUnit;
            return this;
        }

        /* renamed from: a */
        public C5533a m848a(boolean z) {
            this.f22605a = z;
            return this;
        }

        /* renamed from: a */
        public C5531c m849a(AbstractC5647j abstractC5647j) {
            if (abstractC5647j == null) {
                throw new NullPointerException("statement cannot be null");
            }
            return new C5531c(this, abstractC5647j);
        }
    }

    /* renamed from: org.c.b.d.c.c$b */
    /* loaded from: classes2.dex */
    private class CallableC5534b implements Callable<Throwable> {

        /* renamed from: b */
        private final CountDownLatch f22609b;

        private CallableC5534b() {
            this.f22609b = new CountDownLatch(1);
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Throwable call() {
            try {
                this.f22609b.countDown();
                C5531c.this.f22600a.mo318a();
                return null;
            } catch (Exception e) {
                throw e;
            } catch (Throwable th) {
                return th;
            }
        }

        /* renamed from: b */
        public void m844b() {
            this.f22609b.await();
        }
    }

    private C5531c(C5533a c5533a, AbstractC5647j abstractC5647j) {
        this.f22604e = null;
        this.f22600a = abstractC5647j;
        this.f22602c = c5533a.f22606b;
        this.f22601b = c5533a.f22607c;
        this.f22603d = c5533a.f22605a;
    }

    @Deprecated
    public C5531c(AbstractC5647j abstractC5647j, long j) {
        this(m855b().m851a(j, TimeUnit.MILLISECONDS), abstractC5647j);
    }

    /* renamed from: a */
    private Exception m860a(Thread thread) {
        StackTraceElement[] stackTrace = thread.getStackTrace();
        Thread m853c = this.f22603d ? m853c(thread) : null;
        C5652l c5652l = new C5652l(this.f22602c, this.f22601b);
        if (stackTrace != null) {
            c5652l.setStackTrace(stackTrace);
            thread.interrupt();
        }
        if (m853c != null) {
            Exception exc = new Exception("Appears to be stuck in thread " + m853c.getName());
            exc.setStackTrace(m854b(m853c));
            return new C5643f(Arrays.asList(c5652l, exc));
        }
        return c5652l;
    }

    /* renamed from: a */
    private Throwable m858a(FutureTask<Throwable> futureTask, Thread thread) {
        try {
            return this.f22602c > 0 ? futureTask.get(this.f22602c, this.f22601b) : futureTask.get();
        } catch (InterruptedException e) {
            return e;
        } catch (ExecutionException e2) {
            return e2.getCause();
        } catch (TimeoutException e3) {
            return m860a(thread);
        }
    }

    /* renamed from: a */
    private Thread[] m859a(ThreadGroup threadGroup) {
        int max = Math.max(threadGroup.activeCount() * 2, 100);
        int i = 0;
        do {
            Thread[] threadArr = new Thread[max];
            int enumerate = threadGroup.enumerate(threadArr);
            if (enumerate < max) {
                return m856a(threadArr, enumerate);
            }
            max += 100;
            i++;
        } while (i < 5);
        return null;
    }

    /* renamed from: a */
    private Thread[] m856a(Thread[] threadArr, int i) {
        int min = Math.min(i, threadArr.length);
        Thread[] threadArr2 = new Thread[min];
        for (int i2 = 0; i2 < min; i2++) {
            threadArr2[i2] = threadArr[i2];
        }
        return threadArr2;
    }

    /* renamed from: b */
    public static C5533a m855b() {
        return new C5533a();
    }

    /* renamed from: b */
    private StackTraceElement[] m854b(Thread thread) {
        try {
            return thread.getStackTrace();
        } catch (SecurityException e) {
            return new StackTraceElement[0];
        }
    }

    /* renamed from: c */
    private Thread m853c(Thread thread) {
        Thread[] m859a;
        Thread thread2;
        if (this.f22604e == null || (m859a = m859a(this.f22604e)) == null) {
            return null;
        }
        int length = m859a.length;
        int i = 0;
        Thread thread3 = null;
        long j = 0;
        while (i < length) {
            Thread thread4 = m859a[i];
            if (thread4.getState() == Thread.State.RUNNABLE) {
                long m852d = m852d(thread4);
                if (thread3 == null || m852d > j) {
                    j = m852d;
                    thread2 = thread4;
                    i++;
                    thread3 = thread2;
                }
            }
            thread2 = thread3;
            i++;
            thread3 = thread2;
        }
        if (thread3 == thread) {
            thread3 = null;
        }
        return thread3;
    }

    /* renamed from: d */
    private long m852d(Thread thread) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        if (threadMXBean.isThreadCpuTimeSupported()) {
            try {
                return threadMXBean.getThreadCpuTime(thread.getId());
            } catch (UnsupportedOperationException e) {
            }
        }
        return 0L;
    }

    @Override // org.p290c.p312f.p313a.AbstractC5647j
    /* renamed from: a */
    public void mo318a() {
        CallableC5534b callableC5534b = new CallableC5534b();
        FutureTask<Throwable> futureTask = new FutureTask<>(callableC5534b);
        this.f22604e = new ThreadGroup("FailOnTimeoutGroup");
        Thread thread = new Thread(this.f22604e, futureTask, "Time-limited test");
        thread.setDaemon(true);
        thread.start();
        callableC5534b.m844b();
        Throwable m858a = m858a(futureTask, thread);
        if (m858a != null) {
            throw m858a;
        }
    }
}
