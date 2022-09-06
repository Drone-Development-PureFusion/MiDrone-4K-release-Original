package com.xiaomi.channel.commonutils.misc;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* renamed from: com.xiaomi.channel.commonutils.misc.f */
/* loaded from: classes.dex */
public class C4484f {

    /* renamed from: a */
    private static volatile C4484f f18549a;

    /* renamed from: b */
    private ScheduledThreadPoolExecutor f18550b = new ScheduledThreadPoolExecutor(1);

    /* renamed from: c */
    private SparseArray<ScheduledFuture> f18551c = new SparseArray<>();

    /* renamed from: d */
    private Object f18552d = new Object();

    /* renamed from: e */
    private SharedPreferences f18553e;

    /* renamed from: com.xiaomi.channel.commonutils.misc.f$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractRunnableC4485a implements Runnable {
        /* renamed from: a */
        public abstract int mo4276a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xiaomi.channel.commonutils.misc.f$b */
    /* loaded from: classes2.dex */
    public static class RunnableC4486b implements Runnable {

        /* renamed from: c */
        AbstractRunnableC4485a f18554c;

        public RunnableC4486b(AbstractRunnableC4485a abstractRunnableC4485a) {
            this.f18554c = abstractRunnableC4485a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5018a() {
        }

        /* renamed from: b */
        void mo5017b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            mo5018a();
            this.f18554c.run();
            mo5017b();
        }
    }

    private C4484f(Context context) {
        this.f18553e = context.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
    }

    /* renamed from: a */
    public static C4484f m5025a(Context context) {
        if (f18549a == null) {
            synchronized (C4484f.class) {
                if (f18549a == null) {
                    f18549a = new C4484f(context);
                }
            }
        }
        return f18549a;
    }

    /* renamed from: a */
    private static String m5026a(int i) {
        return "last_job_time" + i;
    }

    /* renamed from: a */
    private ScheduledFuture m5024a(AbstractRunnableC4485a abstractRunnableC4485a) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f18552d) {
            scheduledFuture = this.f18551c.get(abstractRunnableC4485a.mo4276a());
        }
        return scheduledFuture;
    }

    /* renamed from: a */
    public void m5020a(Runnable runnable) {
        m5019a(runnable, 0);
    }

    /* renamed from: a */
    public void m5019a(Runnable runnable, int i) {
        this.f18550b.schedule(runnable, i, TimeUnit.SECONDS);
    }

    /* renamed from: a */
    public boolean m5023a(AbstractRunnableC4485a abstractRunnableC4485a, int i) {
        return m5022a(abstractRunnableC4485a, i, 0);
    }

    /* renamed from: a */
    public boolean m5022a(AbstractRunnableC4485a abstractRunnableC4485a, int i, int i2) {
        if (abstractRunnableC4485a == null || m5024a(abstractRunnableC4485a) != null) {
            return false;
        }
        String m5026a = m5026a(abstractRunnableC4485a.mo4276a());
        C4487g c4487g = new C4487g(this, abstractRunnableC4485a, m5026a);
        long abs = Math.abs(System.currentTimeMillis() - this.f18553e.getLong(m5026a, 0L)) / 1000;
        if (abs < i - i2) {
            i2 = (int) (i - abs);
        }
        ScheduledFuture<?> scheduleAtFixedRate = this.f18550b.scheduleAtFixedRate(c4487g, i2, i, TimeUnit.SECONDS);
        synchronized (this.f18552d) {
            this.f18551c.put(abstractRunnableC4485a.mo4276a(), scheduleAtFixedRate);
        }
        return true;
    }
}
