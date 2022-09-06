package com.xiaomi.push.service;

import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import java.util.concurrent.RejectedExecutionException;
/* renamed from: com.xiaomi.push.service.i */
/* loaded from: classes.dex */
public class C4663i {

    /* renamed from: a */
    private static long f19094a;

    /* renamed from: b */
    private static long f19095b;

    /* renamed from: c */
    private static long f19096c;

    /* renamed from: d */
    private final C4666c f19097d;

    /* renamed from: e */
    private final C4664a f19098e;

    /* renamed from: com.xiaomi.push.service.i$a */
    /* loaded from: classes.dex */
    private static final class C4664a {

        /* renamed from: a */
        private final C4666c f19099a;

        C4664a(C4666c c4666c) {
            this.f19099a = c4666c;
        }

        protected void finalize() {
            try {
                synchronized (this.f19099a) {
                    this.f19099a.f19105e = true;
                    this.f19099a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.i$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractRunnableC4665b implements Runnable {

        /* renamed from: a */
        protected int f19100a;

        public AbstractRunnableC4665b(int i) {
            this.f19100a = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xiaomi.push.service.i$c */
    /* loaded from: classes.dex */
    public static final class C4666c extends Thread {

        /* renamed from: d */
        private boolean f19104d;

        /* renamed from: e */
        private boolean f19105e;

        /* renamed from: a */
        private volatile long f19101a = 0;

        /* renamed from: b */
        private volatile boolean f19102b = false;

        /* renamed from: c */
        private long f19103c = 50;

        /* renamed from: f */
        private C4667a f19106f = new C4667a();

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.xiaomi.push.service.i$c$a */
        /* loaded from: classes.dex */
        public static final class C4667a {

            /* renamed from: a */
            private int f19107a;

            /* renamed from: b */
            private C4668d[] f19108b;

            /* renamed from: c */
            private int f19109c;

            /* renamed from: d */
            private int f19110d;

            private C4667a() {
                this.f19107a = 256;
                this.f19108b = new C4668d[this.f19107a];
                this.f19109c = 0;
                this.f19110d = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: b */
            public int m4222b(C4668d c4668d) {
                for (int i = 0; i < this.f19108b.length; i++) {
                    if (this.f19108b[i] == c4668d) {
                        return i;
                    }
                }
                return -1;
            }

            /* renamed from: d */
            private void m4218d(int i) {
                int i2 = (i * 2) + 1;
                while (i2 < this.f19109c && this.f19109c > 0) {
                    int i3 = (i2 + 1 >= this.f19109c || this.f19108b[i2 + 1].f19113c >= this.f19108b[i2].f19113c) ? i2 : i2 + 1;
                    if (this.f19108b[i].f19113c < this.f19108b[i3].f19113c) {
                        return;
                    }
                    C4668d c4668d = this.f19108b[i];
                    this.f19108b[i] = this.f19108b[i3];
                    this.f19108b[i3] = c4668d;
                    i2 = (i3 * 2) + 1;
                    i = i3;
                }
            }

            /* renamed from: e */
            private void m4217e() {
                int i = this.f19109c - 1;
                for (int i2 = (i - 1) / 2; this.f19108b[i].f19113c < this.f19108b[i2].f19113c; i2 = (i2 - 1) / 2) {
                    C4668d c4668d = this.f19108b[i];
                    this.f19108b[i] = this.f19108b[i2];
                    this.f19108b[i2] = c4668d;
                    i = i2;
                }
            }

            /* renamed from: a */
            public C4668d m4229a() {
                return this.f19108b[0];
            }

            /* renamed from: a */
            public void m4227a(int i, AbstractRunnableC4665b abstractRunnableC4665b) {
                for (int i2 = 0; i2 < this.f19109c; i2++) {
                    if (this.f19108b[i2].f19114d == abstractRunnableC4665b) {
                        this.f19108b[i2].m4216a();
                    }
                }
                m4219d();
            }

            /* renamed from: a */
            public void m4225a(C4668d c4668d) {
                if (this.f19108b.length == this.f19109c) {
                    C4668d[] c4668dArr = new C4668d[this.f19109c * 2];
                    System.arraycopy(this.f19108b, 0, c4668dArr, 0, this.f19109c);
                    this.f19108b = c4668dArr;
                }
                C4668d[] c4668dArr2 = this.f19108b;
                int i = this.f19109c;
                this.f19109c = i + 1;
                c4668dArr2[i] = c4668d;
                m4217e();
            }

            /* renamed from: a */
            public boolean m4228a(int i) {
                for (int i2 = 0; i2 < this.f19109c; i2++) {
                    if (this.f19108b[i2].f19115e == i) {
                        return true;
                    }
                }
                return false;
            }

            /* renamed from: b */
            public void m4223b(int i) {
                for (int i2 = 0; i2 < this.f19109c; i2++) {
                    if (this.f19108b[i2].f19115e == i) {
                        this.f19108b[i2].m4216a();
                    }
                }
                m4219d();
            }

            /* renamed from: b */
            public boolean m4224b() {
                return this.f19109c == 0;
            }

            /* renamed from: c */
            public void m4221c() {
                this.f19108b = new C4668d[this.f19107a];
                this.f19109c = 0;
            }

            /* renamed from: c */
            public void m4220c(int i) {
                if (i < 0 || i >= this.f19109c) {
                    return;
                }
                C4668d[] c4668dArr = this.f19108b;
                C4668d[] c4668dArr2 = this.f19108b;
                int i2 = this.f19109c - 1;
                this.f19109c = i2;
                c4668dArr[i] = c4668dArr2[i2];
                this.f19108b[this.f19109c] = null;
                m4218d(i);
            }

            /* renamed from: d */
            public void m4219d() {
                int i = 0;
                while (i < this.f19109c) {
                    if (this.f19108b[i].f19112b) {
                        this.f19110d++;
                        m4220c(i);
                        i--;
                    }
                    i++;
                }
            }
        }

        C4666c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m4232a(C4668d c4668d) {
            this.f19106f.m4225a(c4668d);
            notify();
        }

        /* renamed from: a */
        public synchronized void m4236a() {
            this.f19104d = true;
            this.f19106f.m4221c();
            notify();
        }

        /* renamed from: b */
        public boolean m4231b() {
            return this.f19102b && SystemClock.uptimeMillis() - this.f19101a > 600000;
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x00a4, code lost:
            r8.f19101a = android.os.SystemClock.uptimeMillis();
            r8.f19102b = true;
            r2.f19114d.run();
            r8.f19102b = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00b7, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00b8, code lost:
            monitor-enter(r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00ba, code lost:
            r8.f19104d = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00bd, code lost:
            throw r0;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            while (true) {
                synchronized (this) {
                    if (this.f19104d) {
                        return;
                    }
                    if (!this.f19106f.m4224b()) {
                        long m4247a = C4663i.m4247a();
                        C4668d m4229a = this.f19106f.m4229a();
                        synchronized (m4229a.f19111a) {
                            if (m4229a.f19112b) {
                                this.f19106f.m4220c(0);
                            } else {
                                long j = m4229a.f19113c - m4247a;
                                if (j > 0) {
                                    if (j > this.f19103c) {
                                        j = this.f19103c;
                                    }
                                    this.f19103c += 50;
                                    if (this.f19103c > 500) {
                                        this.f19103c = 500L;
                                    }
                                    try {
                                        wait(j);
                                    } catch (InterruptedException e) {
                                    }
                                } else {
                                    this.f19103c = 50L;
                                    synchronized (m4229a.f19111a) {
                                        int i = 0;
                                        if (this.f19106f.m4229a().f19113c != m4229a.f19113c) {
                                            i = this.f19106f.m4222b(m4229a);
                                        }
                                        if (m4229a.f19112b) {
                                            this.f19106f.m4220c(this.f19106f.m4222b(m4229a));
                                        } else {
                                            m4229a.m4215a(m4229a.f19113c);
                                            this.f19106f.m4220c(i);
                                            m4229a.f19113c = 0L;
                                        }
                                    }
                                }
                            }
                        }
                    } else if (this.f19105e) {
                        return;
                    } else {
                        try {
                            wait();
                        } catch (InterruptedException e2) {
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.i$d */
    /* loaded from: classes.dex */
    public static class C4668d {

        /* renamed from: a */
        final Object f19111a = new Object();

        /* renamed from: b */
        boolean f19112b;

        /* renamed from: c */
        long f19113c;

        /* renamed from: d */
        AbstractRunnableC4665b f19114d;

        /* renamed from: e */
        int f19115e;

        /* renamed from: f */
        private long f19116f;

        C4668d() {
        }

        /* renamed from: a */
        void m4215a(long j) {
            synchronized (this.f19111a) {
                this.f19116f = j;
            }
        }

        /* renamed from: a */
        public boolean m4216a() {
            boolean z = true;
            synchronized (this.f19111a) {
                if (this.f19112b || this.f19113c <= 0) {
                    z = false;
                }
                this.f19112b = true;
            }
            return z;
        }
    }

    static {
        long j = 0;
        if (SystemClock.elapsedRealtime() > 0) {
            j = SystemClock.elapsedRealtime();
        }
        f19094a = j;
        f19095b = f19094a;
    }

    public C4663i() {
        this(false);
    }

    public C4663i(String str) {
        this(str, false);
    }

    public C4663i(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        this.f19097d = new C4666c(str, z);
        this.f19098e = new C4664a(this.f19097d);
    }

    public C4663i(boolean z) {
        this("Timer-" + m4237e(), z);
    }

    /* renamed from: a */
    static synchronized long m4247a() {
        long j;
        synchronized (C4663i.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime > f19095b) {
                f19094a += elapsedRealtime - f19095b;
            }
            f19095b = elapsedRealtime;
            j = f19094a;
        }
        return j;
    }

    /* renamed from: b */
    private void m4240b(AbstractRunnableC4665b abstractRunnableC4665b, long j) {
        synchronized (this.f19097d) {
            if (this.f19097d.f19104d) {
                throw new IllegalStateException("Timer was canceled");
            }
            long m4247a = m4247a() + j;
            if (m4247a < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + m4247a);
            }
            C4668d c4668d = new C4668d();
            c4668d.f19115e = abstractRunnableC4665b.f19100a;
            c4668d.f19114d = abstractRunnableC4665b;
            c4668d.f19113c = m4247a;
            this.f19097d.m4232a(c4668d);
        }
    }

    /* renamed from: e */
    private static synchronized long m4237e() {
        long j;
        synchronized (C4663i.class) {
            j = f19096c;
            f19096c = 1 + j;
        }
        return j;
    }

    /* renamed from: a */
    public void m4245a(int i, AbstractRunnableC4665b abstractRunnableC4665b) {
        synchronized (this.f19097d) {
            this.f19097d.f19106f.m4227a(i, abstractRunnableC4665b);
        }
    }

    /* renamed from: a */
    public void m4244a(AbstractRunnableC4665b abstractRunnableC4665b) {
        if (AbstractC4478b.m5047a() >= 1 || Thread.currentThread() == this.f19097d) {
            abstractRunnableC4665b.run();
        } else {
            AbstractC4478b.m5036d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
    }

    /* renamed from: a */
    public void m4243a(AbstractRunnableC4665b abstractRunnableC4665b, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("delay < 0: " + j);
        }
        m4240b(abstractRunnableC4665b, j);
    }

    /* renamed from: a */
    public boolean m4246a(int i) {
        boolean m4228a;
        synchronized (this.f19097d) {
            m4228a = this.f19097d.f19106f.m4228a(i);
        }
        return m4228a;
    }

    /* renamed from: b */
    public void m4242b() {
        this.f19097d.m4236a();
    }

    /* renamed from: b */
    public void m4241b(int i) {
        synchronized (this.f19097d) {
            this.f19097d.f19106f.m4223b(i);
        }
    }

    /* renamed from: c */
    public void m4239c() {
        synchronized (this.f19097d) {
            this.f19097d.f19106f.m4221c();
        }
    }

    /* renamed from: d */
    public boolean m4238d() {
        return this.f19097d.m4231b();
    }
}
