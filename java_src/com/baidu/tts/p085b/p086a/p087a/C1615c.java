package com.baidu.tts.p085b.p086a.p087a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p085b.p086a.AbstractC1623b;
import com.baidu.tts.p085b.p086a.p088b.AbstractC1625b;
import com.baidu.tts.p096e.EnumC1709l;
import com.baidu.tts.p096e.EnumC1711n;
import com.baidu.tts.p097f.p098a.ThreadFactoryC1714a;
import com.baidu.tts.p099g.p100a.C1717c;
import com.baidu.tts.p108l.C1741e;
import com.baidu.tts.p108l.C1742f;
import com.baidu.tts.p108l.C1743g;
import com.baidu.tts.p108l.C1744h;
import com.baidu.tts.p108l.C1745i;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/* renamed from: com.baidu.tts.b.a.a.c */
/* loaded from: classes.dex */
public class C1615c extends AbstractC1613a {

    /* renamed from: f */
    private ExecutorService f5717f;

    /* renamed from: g */
    private C1622h f5718g = new C1622h(this);

    /* renamed from: h */
    private C1619e f5719h = new C1619e(this);

    /* renamed from: i */
    private C1621g f5720i = new C1621g(this);

    /* renamed from: j */
    private C1620f f5721j = new C1620f(this);

    /* renamed from: com.baidu.tts.b.a.a.c$a */
    /* loaded from: classes.dex */
    private class CallableC1617a implements Callable<Void> {

        /* renamed from: b */
        private C1745i f5724b;

        public CallableC1617a(C1745i c1745i) {
            this.f5724b = c1745i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            try {
                C1615c.this.a(C1744h.m14749b(this.f5724b));
                TtsError mo15194a = C1615c.this.f5713a.mo15194a(this.f5724b);
                if (mo15194a == null) {
                    C1615c.this.c(C1744h.m14749b(this.f5724b));
                } else {
                    C1615c.this.e(C1744h.m14755a(this.f5724b, mo15194a));
                }
            } catch (InterruptedException e) {
            }
            return null;
        }
    }

    public C1615c() {
        this.f5715c = this.f5718g;
    }

    /* renamed from: a */
    private void m15269a(boolean z) {
        if (z) {
            d((C1744h) null);
            return;
        }
        C1744h c1744h = new C1744h();
        c1744h.m14759a(C1717c.m14880a().m14873b(EnumC1711n.TTS_ENGINE_STOP_FAILURE));
        d(c1744h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public int m15266b(C1742f c1742f) {
        return this.f5713a.mo15196a(c1742f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public int m15265b(C1743g c1743g) {
        return this.f5713a.mo15195a(c1743g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m15268b(AbstractC1625b abstractC1625b) {
        this.f5713a = abstractC1625b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m15267b(AbstractC1623b abstractC1623b) {
        if (this.f5714b == null) {
            this.f5714b = new ArrayList();
        }
        if (!this.f5714b.contains(abstractC1623b)) {
            this.f5714b.add(abstractC1623b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m15264b(C1745i c1745i) {
        this.f5717f.submit(new CallableC1617a(c1745i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public <T> void m15263b(T t) {
        this.f5713a.mo15193a((AbstractC1625b) t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public int m15262c(C1741e c1741e) {
        return this.f5713a.mo15197a(c1741e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public int m15261d(C1741e c1741e) {
        return this.f5713a.mo15192b(c1741e);
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: m */
    public boolean mo14837m() {
        return this.f5715c == this.f5721j;
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: n */
    public boolean mo14836n() {
        return Thread.currentThread().isInterrupted() || this.f5715c == this.f5719h;
    }

    /* renamed from: o */
    public C1622h m15260o() {
        return this.f5718g;
    }

    /* renamed from: p */
    public C1619e m15259p() {
        return this.f5719h;
    }

    /* renamed from: q */
    public C1621g m15258q() {
        return this.f5720i;
    }

    /* renamed from: r */
    public C1620f m15257r() {
        return this.f5721j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public TtsError m15256s() {
        if (this.f5714b == null) {
            this.f5714b = new ArrayList();
        }
        this.f5713a.mo15238a(new AbstractC1623b() { // from class: com.baidu.tts.b.a.a.c.1
            @Override // com.baidu.tts.p085b.p086a.AbstractC1623b
            /* renamed from: a */
            public void mo15227a(C1744h c1744h) {
            }

            @Override // com.baidu.tts.p085b.p086a.AbstractC1623b
            /* renamed from: b */
            public void mo15226b(C1744h c1744h) {
            }

            @Override // com.baidu.tts.p085b.p086a.AbstractC1623b
            /* renamed from: c */
            public void mo15225c(C1744h c1744h) {
                C1615c.this.b(c1744h);
            }

            @Override // com.baidu.tts.p085b.p086a.AbstractC1623b
            /* renamed from: d */
            public void mo15224d(C1744h c1744h) {
            }

            @Override // com.baidu.tts.p085b.p086a.AbstractC1623b
            /* renamed from: e */
            public void mo15223e(C1744h c1744h) {
            }
        });
        return this.f5713a.mo15222a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: t */
    public void m15255t() {
        this.f5717f = Executors.newSingleThreadExecutor(new ThreadFactoryC1714a("EngineExecutorPoolThread"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: u */
    public void m15254u() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v */
    public void m15253v() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w */
    public void m15252w() {
        if (this.f5717f != null) {
            if (!this.f5717f.isShutdown()) {
                this.f5717f.shutdownNow();
            }
            try {
                LoggerProxy.m15091d("EngineExecutor", "before awaitTermination");
                boolean awaitTermination = this.f5717f.awaitTermination(EnumC1709l.DEFAULT.m14891a(), TimeUnit.MILLISECONDS);
                LoggerProxy.m15091d("EngineExecutor", "after awaitTermination isTermination=" + awaitTermination);
                m15269a(awaitTermination);
            } catch (InterruptedException e) {
                m15269a(false);
            }
            this.f5717f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: x */
    public void m15251x() {
        this.f5713a.mo15220b();
        this.f5714b = null;
    }
}
