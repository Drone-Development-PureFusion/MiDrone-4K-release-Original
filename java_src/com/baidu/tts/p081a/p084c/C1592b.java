package com.baidu.tts.p081a.p084c;

import android.util.Log;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p085b.p086a.AbstractC1623b;
import com.baidu.tts.p085b.p086a.p087a.AbstractC1618d;
import com.baidu.tts.p085b.p089b.AbstractC1640a;
import com.baidu.tts.p085b.p089b.p090a.AbstractC1643c;
import com.baidu.tts.p096e.EnumC1706i;
import com.baidu.tts.p108l.C1741e;
import com.baidu.tts.p108l.C1742f;
import com.baidu.tts.p108l.C1743g;
import com.baidu.tts.p108l.C1744h;
import com.baidu.tts.p108l.C1745i;
import com.baidu.tts.p108l.C1746j;
/* renamed from: com.baidu.tts.a.c.b */
/* loaded from: classes.dex */
public class C1592b implements AbstractC1591a {

    /* renamed from: a */
    private AbstractC1618d f5653a;

    /* renamed from: b */
    private AbstractC1643c f5654b;

    /* renamed from: c */
    private TtsListener f5655c;

    /* renamed from: d */
    private AbstractC1623b f5656d;

    /* renamed from: e */
    private AbstractC1640a f5657e;

    /* renamed from: f */
    private AbstractC1623b f5658f;

    public C1592b(AbstractC1618d abstractC1618d, AbstractC1643c abstractC1643c, C1746j c1746j) {
        this.f5653a = abstractC1618d;
        this.f5654b = abstractC1643c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m15360a(C1744h c1744h) {
        C1745i m14744e = c1744h.m14744e();
        if (m14744e == null) {
            return false;
        }
        return EnumC1706i.m14893a(m14744e.m14731g());
    }

    @Override // com.baidu.tts.p081a.p084c.AbstractC1591a
    /* renamed from: a */
    public int mo15369a(float f, float f2) {
        return this.f5654b.mo15145a(f, f2);
    }

    @Override // com.baidu.tts.p081a.p084c.AbstractC1591a
    /* renamed from: a */
    public int mo15363a(C1741e c1741e) {
        return this.f5653a.mo15245a(c1741e);
    }

    @Override // com.baidu.tts.p081a.p084c.AbstractC1591a
    /* renamed from: a */
    public int mo15362a(C1742f c1742f) {
        return this.f5653a.mo15244a(c1742f);
    }

    @Override // com.baidu.tts.p081a.p084c.AbstractC1591a
    /* renamed from: a */
    public int mo15361a(C1743g c1743g) {
        return this.f5653a.mo15243a(c1743g);
    }

    @Override // com.baidu.tts.p081a.p084c.AbstractC1591a
    /* renamed from: a */
    public AbstractC1643c mo15370a() {
        return this.f5654b;
    }

    @Override // com.baidu.tts.p081a.p084c.AbstractC1591a
    /* renamed from: a */
    public void mo15366a(TtsListener ttsListener) {
        this.f5655c = ttsListener;
        m15365a(this.f5653a);
        m15364a(this.f5654b);
    }

    /* renamed from: a */
    protected void m15365a(AbstractC1618d abstractC1618d) {
        if (this.f5656d == null) {
            this.f5656d = new AbstractC1623b() { // from class: com.baidu.tts.a.c.b.1
                @Override // com.baidu.tts.p085b.p086a.AbstractC1623b
                /* renamed from: a */
                public void mo15227a(C1744h c1744h) {
                    if (C1592b.this.f5655c != null) {
                        C1592b.this.f5655c.onSynthesizeStart(c1744h);
                    }
                }

                @Override // com.baidu.tts.p085b.p086a.AbstractC1623b
                /* renamed from: b */
                public void mo15226b(C1744h c1744h) {
                    if (C1592b.this.f5655c != null) {
                        C1592b.this.f5655c.onSynthesizeFinished(c1744h);
                    }
                }

                @Override // com.baidu.tts.p085b.p086a.AbstractC1623b
                /* renamed from: c */
                public void mo15225c(C1744h c1744h) {
                    if (C1592b.this.f5655c != null) {
                        C1592b.this.f5655c.onSynthesizeDataArrived(c1744h);
                    }
                }

                @Override // com.baidu.tts.p085b.p086a.AbstractC1623b
                /* renamed from: d */
                public void mo15224d(C1744h c1744h) {
                    if (C1592b.this.f5655c != null) {
                        C1592b.this.f5655c.onError(c1744h);
                    }
                }

                @Override // com.baidu.tts.p085b.p086a.AbstractC1623b
                /* renamed from: e */
                public void mo15223e(C1744h c1744h) {
                    LoggerProxy.m15091d("TtsAdapter", "onSynthesizeStop");
                }
            };
        }
        abstractC1618d.mo15248a(this.f5656d);
    }

    /* renamed from: a */
    protected void m15364a(AbstractC1643c abstractC1643c) {
        if (this.f5657e == null) {
            this.f5657e = new AbstractC1640a() { // from class: com.baidu.tts.a.c.b.2
                @Override // com.baidu.tts.p085b.p089b.AbstractC1640a
                /* renamed from: a */
                public void mo15125a(C1744h c1744h) {
                    if (C1592b.this.f5655c != null) {
                        C1592b.this.f5655c.onPlayStart(c1744h);
                    }
                }

                @Override // com.baidu.tts.p085b.p089b.AbstractC1640a
                /* renamed from: b */
                public void mo15124b(C1744h c1744h) {
                    if (C1592b.this.f5655c != null) {
                        C1592b.this.f5655c.onPlayProgressUpdate(c1744h);
                    }
                }

                @Override // com.baidu.tts.p085b.p089b.AbstractC1640a
                /* renamed from: c */
                public void mo15123c(C1744h c1744h) {
                    if (C1592b.this.f5655c != null) {
                        try {
                            C1592b.this.f5655c.onPlayFinished(c1744h);
                        } catch (Exception e) {
                            Log.e("TtsAdapter", "onPlayFinished exception e=" + e.toString());
                        }
                    }
                }
            };
        }
        abstractC1643c.mo15143a(this.f5657e);
    }

    @Override // com.baidu.tts.p081a.p084c.AbstractC1591a
    /* renamed from: a */
    public void mo15359a(C1745i c1745i) {
        this.f5653a.mo15241a(c1745i);
    }

    @Override // com.baidu.tts.p081a.p084c.AbstractC1591a
    /* renamed from: b */
    public int mo15357b(C1741e c1741e) {
        return this.f5653a.mo15240b(c1741e);
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: b */
    public TtsError mo14683b() {
        TtsError b = this.f5653a.b();
        this.f5654b.b();
        m15355g();
        return b;
    }

    @Override // com.baidu.tts.p081a.p084c.AbstractC1591a
    /* renamed from: b */
    public void mo15356b(C1745i c1745i) {
        this.f5654b.mo15121o();
        this.f5653a.mo15241a(c1745i);
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: c */
    public void mo14682c() {
        this.f5653a.c();
        this.f5654b.c();
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: d */
    public void mo14681d() {
        this.f5653a.d();
        this.f5654b.d();
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: e */
    public void mo14680e() {
        LoggerProxy.m15091d("TtsAdapter", "before engine stop");
        this.f5653a.e();
        LoggerProxy.m15091d("TtsAdapter", "after engine stop");
        this.f5654b.e();
        LoggerProxy.m15091d("TtsAdapter", "after play stop");
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: f */
    public void mo14679f() {
        LoggerProxy.m15091d("TtsAdapter", "before engine destroy");
        this.f5653a.f();
        LoggerProxy.m15091d("TtsAdapter", "after engine destroy");
        this.f5654b.f();
        LoggerProxy.m15091d("TtsAdapter", "after player destroy");
    }

    /* renamed from: g */
    protected void m15355g() {
        this.f5658f = new AbstractC1623b() { // from class: com.baidu.tts.a.c.b.3
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
                if (C1592b.this.m15360a(c1744h)) {
                    C1592b.this.f5654b.mo15122a(c1744h);
                }
            }

            @Override // com.baidu.tts.p085b.p086a.AbstractC1623b
            /* renamed from: d */
            public void mo15224d(C1744h c1744h) {
            }

            @Override // com.baidu.tts.p085b.p086a.AbstractC1623b
            /* renamed from: e */
            public void mo15223e(C1744h c1744h) {
            }
        };
        this.f5653a.mo15248a(this.f5658f);
    }
}
