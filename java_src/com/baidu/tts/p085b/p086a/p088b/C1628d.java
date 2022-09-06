package com.baidu.tts.p085b.p086a.p088b;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p085b.p086a.AbstractC1623b;
import com.baidu.tts.p085b.p086a.p088b.C1631e;
import com.baidu.tts.p085b.p086a.p088b.C1634f;
import com.baidu.tts.p096e.EnumC1711n;
import com.baidu.tts.p099g.p100a.C1717c;
import com.baidu.tts.p108l.C1738b;
import com.baidu.tts.p108l.C1741e;
import com.baidu.tts.p108l.C1742f;
import com.baidu.tts.p108l.C1743g;
import com.baidu.tts.p108l.C1744h;
import com.baidu.tts.p108l.C1745i;
/* renamed from: com.baidu.tts.b.a.b.d */
/* loaded from: classes.dex */
public class C1628d extends AbstractC1624a {

    /* renamed from: b */
    private C1738b f5729b;

    /* renamed from: f */
    private TtsError f5733f;

    /* renamed from: g */
    private int f5734g = 0;

    /* renamed from: h */
    private int f5735h = 0;

    /* renamed from: c */
    private C1634f f5730c = new C1634f();

    /* renamed from: d */
    private C1631e f5731d = new C1631e();

    /* renamed from: e */
    private C1626c f5732e = new C1626c();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public C1744h m15228b(C1744h c1744h) {
        int m14752b = c1744h.m14752b();
        c1744h.m14751b(m14752b >= 0 ? m14752b + this.f5735h : m14752b - this.f5735h);
        c1744h.m14747c(c1744h.m14748c() + this.f5734g);
        return c1744h;
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1624a, com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: a */
    public int mo15197a(C1741e c1741e) {
        return this.f5731d.mo15197a(c1741e);
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: a */
    public int mo15196a(C1742f c1742f) {
        return this.f5731d.mo15196a(c1742f);
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1624a, com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: a */
    public int mo15195a(C1743g c1743g) {
        if (this.f5733f == null) {
            return this.f5731d.mo15195a(c1743g);
        }
        String m14765a = c1743g.m14765a();
        String m14763b = c1743g.m14763b();
        C1631e.C1632a m14793b = this.f5729b.m14793b();
        m14793b.m15209e(m14765a);
        m14793b.m15207f(m14763b);
        this.f5733f = this.f5731d.mo15222a();
        if (this.f5733f != null) {
            return this.f5733f.getDetailCode();
        }
        return 0;
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1624a, com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: a */
    public TtsError mo15222a() {
        this.f5730c.a(new AbstractC1623b() { // from class: com.baidu.tts.b.a.b.d.1
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
                C1628d.this.f5735h = c1744h.m14752b();
                C1628d.this.f5734g = c1744h.m14748c();
                C1628d.this.a(c1744h);
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
        this.f5731d.a(new AbstractC1623b() { // from class: com.baidu.tts.b.a.b.d.2
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
                C1628d.this.a(C1628d.this.m15228b(c1744h));
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
        this.f5730c.a();
        this.f5733f = this.f5731d.mo15222a();
        if (this.f5733f != null) {
            return C1717c.m14880a().m14873b(EnumC1711n.MIX_ENGINE_OFFLINE_INIT_FAILURE);
        }
        return null;
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1624a, com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: a */
    public TtsError mo15194a(C1745i c1745i) {
        this.f5735h = 0;
        this.f5734g = 0;
        if (this.f5732e.m15237a()) {
            TtsError mo15194a = this.f5730c.mo15194a(c1745i);
            if (mo15194a == null) {
                return mo15194a;
            }
            LoggerProxy.m15091d("MixSynthesizer", "online synthesize ttserror=" + mo15194a.getDetailMessage());
            c1745i.m14738b(c1745i.m14737c().substring(this.f5734g));
            return this.f5731d.mo15194a(c1745i);
        }
        return this.f5731d.mo15194a(c1745i);
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1624a, com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: a */
    public <AllSynthesizerParams> void mo15193a(AllSynthesizerParams allsynthesizerparams) {
        this.f5729b = (C1738b) allsynthesizerparams;
        C1634f.C1636b m14796a = this.f5729b.m14796a();
        m14796a.m15188a(3);
        m14796a.m15183b(500);
        this.f5730c.mo15193a((C1634f) m14796a);
        this.f5731d.mo15193a((C1631e) this.f5729b.m14793b());
        this.f5732e.m15235a(this.f5729b);
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1624a, com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: b */
    public int mo15192b(C1741e c1741e) {
        return this.f5731d.mo15192b(c1741e);
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1624a, com.baidu.tts.p085b.p086a.p088b.AbstractC1625b
    /* renamed from: b */
    public TtsError mo15220b() {
        this.f5730c.b();
        this.f5731d.mo15220b();
        this.f5732e.m15235a((C1738b) null);
        return null;
    }
}
