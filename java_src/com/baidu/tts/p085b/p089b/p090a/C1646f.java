package com.baidu.tts.p085b.p089b.p090a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p085b.p089b.AbstractC1640a;
import com.baidu.tts.p085b.p089b.C1651b;
import com.baidu.tts.p085b.p089b.p091b.AbstractC1655c;
import com.baidu.tts.p092c.C1656a;
import com.baidu.tts.p096e.EnumC1709l;
import com.baidu.tts.p108l.C1737a;
import com.baidu.tts.p108l.C1744h;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* renamed from: com.baidu.tts.b.b.a.f */
/* loaded from: classes.dex */
public class C1646f extends AbstractC1641a {

    /* renamed from: c */
    private ThreadPoolExecutor f5786c;

    /* renamed from: g */
    private C1650h f5788g = new C1650h(this);

    /* renamed from: h */
    private C1644d f5789h = new C1644d(this);

    /* renamed from: i */
    private C1649g f5790i = new C1649g(this);

    /* renamed from: j */
    private C1645e f5791j = new C1645e(this);

    /* renamed from: f */
    private AbstractC1655c f5787f = C1651b.m15120a().m15119b();

    /* renamed from: com.baidu.tts.b.b.a.f$a */
    /* loaded from: classes.dex */
    private class RunnableC1648a implements Runnable {

        /* renamed from: b */
        private C1744h f5794b;

        public RunnableC1648a(C1744h c1744h) {
            this.f5794b = c1744h;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoggerProxy.m15091d("PlayQueueMachine", "enter run");
            C1646f.this.f5787f.mo15097a(this.f5794b);
            LoggerProxy.m15091d("PlayQueueMachine", "end run");
        }
    }

    public C1646f() {
        this.f5784b = this.f5788g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public int m15139b(float f, float f2) {
        return this.f5787f.mo15100a(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public int m15138b(int i) {
        return this.f5787f.mo15099a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m15137b(AbstractC1640a abstractC1640a) {
        this.f5783a = abstractC1640a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public <T> void m15136b(T t) {
        this.f5787f.mo15096a((AbstractC1655c) ((C1737a) t).m14798a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public void m15135e(C1744h c1744h) {
        this.f5786c.execute(new RunnableC1648a(c1744h));
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: m */
    public boolean mo14837m() {
        return this.f5784b == this.f5791j;
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: n */
    public boolean mo14836n() {
        return Thread.currentThread().isInterrupted() || this.f5784b == this.f5789h;
    }

    /* renamed from: p */
    public C1650h m15134p() {
        return this.f5788g;
    }

    /* renamed from: q */
    public C1644d m15133q() {
        return this.f5789h;
    }

    /* renamed from: r */
    public C1649g m15132r() {
        return this.f5790i;
    }

    /* renamed from: s */
    public C1645e m15131s() {
        return this.f5791j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: t */
    public TtsError m15130t() {
        this.f5787f.mo15098a(new AbstractC1640a() { // from class: com.baidu.tts.b.b.a.f.1
            @Override // com.baidu.tts.p085b.p089b.AbstractC1640a
            /* renamed from: a */
            public void mo15125a(C1744h c1744h) {
                C1646f.this.b(c1744h);
            }

            @Override // com.baidu.tts.p085b.p089b.AbstractC1640a
            /* renamed from: b */
            public void mo15124b(C1744h c1744h) {
                C1646f.this.c(c1744h);
            }

            @Override // com.baidu.tts.p085b.p089b.AbstractC1640a
            /* renamed from: c */
            public void mo15123c(C1744h c1744h) {
                C1646f.this.d(c1744h);
            }
        });
        return this.f5787f.mo15101a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: u */
    public void m15129u() {
        this.f5786c = new C1656a(100, "PlayExecutorPoolThread");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v */
    public void m15128v() {
        this.f5787f.mo15094c();
        if (this.f5786c != null) {
            if (!this.f5786c.isShutdown()) {
                this.f5786c.shutdownNow();
            }
            try {
                LoggerProxy.m15091d("PlayQueueMachine", "before await");
                LoggerProxy.m15091d("PlayQueueMachine", "after await isTer=" + this.f5786c.awaitTermination(EnumC1709l.DEFAULT.m14891a(), TimeUnit.MILLISECONDS));
            } catch (InterruptedException e) {
                LoggerProxy.m15091d("PlayQueueMachine", "InterruptedException");
            }
            this.f5786c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w */
    public void m15127w() {
        this.f5787f.mo15093d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: x */
    public void m15126x() {
        this.f5787f.mo15095b();
    }
}
