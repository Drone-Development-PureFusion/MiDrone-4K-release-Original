package com.baidu.tts.p085b.p086a.p087a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.p096e.EnumC1711n;
import com.baidu.tts.p099g.p100a.C1717c;
import com.baidu.tts.p108l.C1741e;
import com.baidu.tts.p108l.C1742f;
import com.baidu.tts.p108l.C1743g;
import com.baidu.tts.p108l.C1744h;
import com.baidu.tts.p108l.C1745i;
/* renamed from: com.baidu.tts.b.a.a.h */
/* loaded from: classes.dex */
public class C1622h extends AbstractC1614b {
    public C1622h(C1615c c1615c) {
        super(c1615c);
    }

    /* renamed from: a */
    private void m15242a(C1744h c1744h) {
        c1744h.m14759a(C1717c.m14880a().m14873b(EnumC1711n.OFFLINE_ENGINE_UNINITIALIZED));
        this.f5716a.e(c1744h);
    }

    @Override // com.baidu.tts.p085b.p086a.p087a.AbstractC1614b, com.baidu.tts.p085b.p086a.p087a.AbstractC1618d
    /* renamed from: a */
    public int mo15245a(C1741e c1741e) {
        m15242a(new C1744h());
        return -1;
    }

    @Override // com.baidu.tts.p085b.p086a.p087a.AbstractC1614b, com.baidu.tts.p085b.p086a.p087a.AbstractC1618d
    /* renamed from: a */
    public int mo15244a(C1742f c1742f) {
        m15242a(new C1744h());
        return -1;
    }

    @Override // com.baidu.tts.p085b.p086a.p087a.AbstractC1614b, com.baidu.tts.p085b.p086a.p087a.AbstractC1618d
    /* renamed from: a */
    public int mo15243a(C1743g c1743g) {
        m15242a(new C1744h());
        return -1;
    }

    @Override // com.baidu.tts.p085b.p086a.p087a.AbstractC1614b, com.baidu.tts.p085b.p086a.p087a.AbstractC1618d
    /* renamed from: a */
    public void mo15241a(C1745i c1745i) {
        m15242a(C1744h.m14749b(c1745i));
    }

    @Override // com.baidu.tts.p085b.p086a.p087a.AbstractC1614b, com.baidu.tts.p085b.p086a.p087a.AbstractC1618d
    /* renamed from: b */
    public int mo15240b(C1741e c1741e) {
        m15242a(new C1744h());
        return -1;
    }

    @Override // com.baidu.tts.p085b.p086a.p087a.AbstractC1614b, com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: b */
    public TtsError mo14683b() {
        TtsError m15256s = this.f5716a.m15256s();
        a((AbstractC1614b) this.f5716a.m15259p());
        return m15256s;
    }
}
