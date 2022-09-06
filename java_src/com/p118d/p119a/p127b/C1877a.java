package com.p118d.p119a.p127b;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import com.p118d.p119a.p120a.p121a.AbstractC1848a;
import com.p118d.p119a.p120a.p121a.p122a.C1862c;
import com.p118d.p119a.p120a.p121a.p122a.p123a.C1857b;
import com.p118d.p119a.p120a.p121a.p124b.AbstractC1863a;
import com.p118d.p119a.p120a.p121a.p124b.C1864b;
import com.p118d.p119a.p120a.p125b.AbstractC1876c;
import com.p118d.p119a.p120a.p125b.p126a.C1872f;
import com.p118d.p119a.p127b.p128a.EnumC1895g;
import com.p118d.p119a.p127b.p128a.p129a.C1882c;
import com.p118d.p119a.p127b.p130b.AbstractC1902b;
import com.p118d.p119a.p127b.p130b.C1899a;
import com.p118d.p119a.p127b.p131c.AbstractC1907a;
import com.p118d.p119a.p127b.p131c.C1913e;
import com.p118d.p119a.p127b.p132d.AbstractC1919b;
import com.p118d.p119a.p127b.p132d.C1917a;
import com.p118d.p119a.p136c.C1949d;
import com.p118d.p119a.p136c.C1952f;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* renamed from: com.d.a.b.a */
/* loaded from: classes.dex */
public class C1877a {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.d.a.b.a$a */
    /* loaded from: classes.dex */
    public static class ThreadFactoryC1878a implements ThreadFactory {

        /* renamed from: a */
        private static final AtomicInteger f6631a = new AtomicInteger(1);

        /* renamed from: d */
        private final String f6634d;

        /* renamed from: e */
        private final int f6635e;

        /* renamed from: c */
        private final AtomicInteger f6633c = new AtomicInteger(1);

        /* renamed from: b */
        private final ThreadGroup f6632b = Thread.currentThread().getThreadGroup();

        ThreadFactoryC1878a(int i, String str) {
            this.f6635e = i;
            this.f6634d = str + f6631a.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f6632b, runnable, this.f6634d + this.f6633c.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.f6635e);
            return thread;
        }
    }

    @TargetApi(11)
    /* renamed from: a */
    private static int m14199a(ActivityManager activityManager) {
        return activityManager.getLargeMemoryClass();
    }

    /* renamed from: a */
    public static AbstractC1848a m14196a(Context context, AbstractC1863a abstractC1863a, long j, int i) {
        File m14193b = m14193b(context);
        if (j > 0 || i > 0) {
            try {
                return new C1857b(C1952f.m13835b(context), m14193b, abstractC1863a, j, i);
            } catch (IOException e) {
                C1949d.m13853a(e);
            }
        }
        return new C1862c(C1952f.m13839a(context), m14193b, abstractC1863a);
    }

    /* renamed from: a */
    public static AbstractC1876c m14197a(Context context, int i) {
        if (i == 0) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            i = (((!m14190d() || !m14191c(context)) ? activityManager.getMemoryClass() : m14199a(activityManager)) * 1048576) / 8;
        }
        return new C1872f(i);
    }

    /* renamed from: a */
    public static AbstractC1902b m14195a(boolean z) {
        return new C1899a(z);
    }

    /* renamed from: a */
    public static AbstractC1919b m14198a(Context context) {
        return new C1917a(context);
    }

    /* renamed from: a */
    public static Executor m14202a() {
        return Executors.newCachedThreadPool(m14200a(5, "uil-pool-d-"));
    }

    /* renamed from: a */
    public static Executor m14201a(int i, int i2, EnumC1895g enumC1895g) {
        return new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, enumC1895g == EnumC1895g.LIFO ? new C1882c() : new LinkedBlockingQueue(), m14200a(i2, "uil-pool-"));
    }

    /* renamed from: a */
    private static ThreadFactory m14200a(int i, String str) {
        return new ThreadFactoryC1878a(i, str);
    }

    /* renamed from: b */
    public static AbstractC1863a m14194b() {
        return new C1864b();
    }

    /* renamed from: b */
    private static File m14193b(Context context) {
        File m13836a = C1952f.m13836a(context, false);
        File file = new File(m13836a, "uil-images");
        return (file.exists() || file.mkdir()) ? file : m13836a;
    }

    /* renamed from: c */
    public static AbstractC1907a m14192c() {
        return new C1913e();
    }

    @TargetApi(11)
    /* renamed from: c */
    private static boolean m14191c(Context context) {
        return (context.getApplicationInfo().flags & 1048576) != 0;
    }

    /* renamed from: d */
    private static boolean m14190d() {
        return Build.VERSION.SDK_INT >= 11;
    }
}
