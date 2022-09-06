package com.baidu.tts.p085b.p089b.p090a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.p108l.C1744h;
/* renamed from: com.baidu.tts.b.b.a.h */
/* loaded from: classes.dex */
public class C1650h extends AbstractC1642b {
    public C1650h(C1646f c1646f) {
        super(c1646f);
    }

    @Override // com.baidu.tts.p085b.p089b.p090a.AbstractC1642b, com.baidu.tts.p085b.p089b.p090a.AbstractC1643c
    /* renamed from: a */
    public void mo15122a(C1744h c1744h) {
        mo14683b();
        if (this.f5785a.a() != this) {
            this.f5785a.a(c1744h);
        }
    }

    @Override // com.baidu.tts.p085b.p089b.p090a.AbstractC1642b, com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: b */
    public TtsError mo14683b() {
        TtsError m15130t = this.f5785a.m15130t();
        a((AbstractC1642b) this.f5785a.m15133q());
        return m15130t;
    }

    @Override // com.baidu.tts.p085b.p089b.p090a.AbstractC1642b, com.baidu.tts.p085b.p089b.p090a.AbstractC1643c
    /* renamed from: o */
    public void mo15121o() {
        mo14683b();
        if (this.f5785a.a() != this) {
            this.f5785a.o();
        }
    }
}
