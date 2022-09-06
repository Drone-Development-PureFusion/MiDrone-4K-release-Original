package com.baidu.tts.p110n.p111a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.p108l.C1741e;
import com.baidu.tts.p108l.C1742f;
import com.baidu.tts.p108l.C1743g;
import com.baidu.tts.p108l.C1745i;
/* renamed from: com.baidu.tts.n.a.b */
/* loaded from: classes.dex */
public class C1770b extends AbstractC1769a {
    public C1770b(C1771c c1771c) {
        super(c1771c);
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: b */
    public TtsError mo14683b() {
        return null;
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: c */
    public void mo14682c() {
        this.f6272a.m14692i();
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: d */
    public void mo14681d() {
        this.f6272a.m14691j();
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: e */
    public void mo14680e() {
        this.f6272a.m14690k();
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: f */
    public void mo14679f() {
        this.f6272a.m14689l();
        a(this.f6272a.m14711a());
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int freeCustomResource(C1741e c1741e) {
        return this.f6272a.m14696b(c1741e);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadCustomResource(C1741e c1741e) {
        return this.f6272a.m14703a(c1741e);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadEnglishModel(C1742f c1742f) {
        return this.f6272a.m14702a(c1742f);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadModel(C1743g c1743g) {
        return this.f6272a.m14701a(c1743g);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setAudioStreamType(int i) {
        return this.f6272a.m14709a(i);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setStereoVolume(float f, float f2) {
        return this.f6272a.m14710a(f, f2);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void speak(C1745i c1745i) {
        this.f6272a.m14699a(c1745i);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void synthesize(C1745i c1745i) {
        this.f6272a.m14695b(c1745i);
    }
}
