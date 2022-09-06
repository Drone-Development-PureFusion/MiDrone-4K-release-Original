package com.baidu.tts.p110n.p111a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.p085b.p089b.p091b.C1653b;
import com.baidu.tts.p096e.EnumC1711n;
import com.baidu.tts.p108l.C1741e;
import com.baidu.tts.p108l.C1742f;
import com.baidu.tts.p108l.C1743g;
import com.baidu.tts.p108l.C1745i;
/* renamed from: com.baidu.tts.n.a.d */
/* loaded from: classes.dex */
public class C1773d extends AbstractC1769a {
    public C1773d(C1771c c1771c) {
        super(c1771c);
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: b */
    public TtsError mo14683b() {
        TtsError m14693h = this.f6272a.m14693h();
        if (m14693h != null) {
            EnumC1711n errorEnum = m14693h.getErrorEnum();
            if (errorEnum != null) {
                if (EnumC1711n.EnumC1712a.MIX_ERROR.equals(errorEnum.m14887a())) {
                    a(this.f6272a.m14694g());
                }
            }
        } else {
            a(this.f6272a.m14694g());
        }
        return m14693h;
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: c */
    public void mo14682c() {
        this.f6272a.m14685p();
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: d */
    public void mo14681d() {
        this.f6272a.m14685p();
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: e */
    public void mo14680e() {
        this.f6272a.m14685p();
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: f */
    public void mo14679f() {
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int freeCustomResource(C1741e c1741e) {
        return this.f6272a.m14685p();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadCustomResource(C1741e c1741e) {
        return this.f6272a.m14685p();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadEnglishModel(C1742f c1742f) {
        return this.f6272a.m14685p();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadModel(C1743g c1743g) {
        return this.f6272a.m14685p();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setAudioStreamType(int i) {
        this.f6272a.getTtsParams().m14724e().a(i);
        return 0;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setStereoVolume(float f, float f2) {
        C1653b.C1654a m14724e = this.f6272a.getTtsParams().m14724e();
        m14724e.m15108a(f);
        m14724e.m15106b(f2);
        return 0;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void speak(C1745i c1745i) {
        this.f6272a.m14685p();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void synthesize(C1745i c1745i) {
        this.f6272a.m14685p();
    }
}
