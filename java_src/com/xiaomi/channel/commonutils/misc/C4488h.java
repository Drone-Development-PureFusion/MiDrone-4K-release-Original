package com.xiaomi.channel.commonutils.misc;

import android.os.Handler;
import android.os.Looper;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* renamed from: com.xiaomi.channel.commonutils.misc.h */
/* loaded from: classes2.dex */
public class C4488h {

    /* renamed from: a */
    private C4489a f18557a;

    /* renamed from: b */
    private Handler f18558b;

    /* renamed from: c */
    private volatile boolean f18559c;

    /* renamed from: d */
    private final boolean f18560d;

    /* renamed from: e */
    private int f18561e;

    /* renamed from: f */
    private volatile AbstractC4490b f18562f;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xiaomi.channel.commonutils.misc.h$a */
    /* loaded from: classes2.dex */
    public class C4489a extends Thread {

        /* renamed from: b */
        private final LinkedBlockingQueue<AbstractC4490b> f18564b = new LinkedBlockingQueue<>();

        public C4489a() {
            super("PackageProcessor");
        }

        /* renamed from: a */
        public void m5007a(AbstractC4490b abstractC4490b) {
            this.f18564b.add(abstractC4490b);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int i = C4488h.this.f18561e > 0 ? C4488h.this.f18561e : 1;
            while (!C4488h.this.f18559c) {
                try {
                    C4488h.this.f18562f = this.f18564b.poll(i, TimeUnit.SECONDS);
                    if (C4488h.this.f18562f != null) {
                        C4488h.this.f18558b.sendMessage(C4488h.this.f18558b.obtainMessage(0, C4488h.this.f18562f));
                        C4488h.this.f18562f.mo3817b();
                        C4488h.this.f18558b.sendMessage(C4488h.this.f18558b.obtainMessage(1, C4488h.this.f18562f));
                    } else if (C4488h.this.f18561e > 0) {
                        C4488h.this.m5016a();
                    }
                } catch (InterruptedException e) {
                    AbstractC4478b.m5039a(e);
                }
            }
        }
    }

    /* renamed from: com.xiaomi.channel.commonutils.misc.h$b */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC4490b {
        /* renamed from: a */
        public void m5006a() {
        }

        /* renamed from: b */
        public abstract void mo3817b();

        /* renamed from: c */
        public void mo4323c() {
        }
    }

    public C4488h() {
        this(false);
    }

    public C4488h(boolean z) {
        this(z, 0);
    }

    public C4488h(boolean z, int i) {
        this.f18558b = null;
        this.f18559c = false;
        this.f18561e = 0;
        this.f18558b = new HandlerC4491i(this, Looper.getMainLooper());
        this.f18560d = z;
        this.f18561e = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m5016a() {
        this.f18557a = null;
        this.f18559c = true;
    }

    /* renamed from: a */
    public synchronized void m5015a(AbstractC4490b abstractC4490b) {
        if (this.f18557a == null) {
            this.f18557a = new C4489a();
            this.f18557a.setDaemon(this.f18560d);
            this.f18559c = false;
            this.f18557a.start();
        }
        this.f18557a.m5007a(abstractC4490b);
    }

    /* renamed from: a */
    public void m5014a(AbstractC4490b abstractC4490b, long j) {
        this.f18558b.postDelayed(new RunnableC4492j(this, abstractC4490b), j);
    }
}
