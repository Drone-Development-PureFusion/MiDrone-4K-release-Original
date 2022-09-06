package com.baidu.tts.p110n.p111a;

import android.content.Context;
import com.baidu.tts.aop.tts.ITts;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.p096e.EnumC1704g;
import com.baidu.tts.p096e.EnumC1710m;
import com.baidu.tts.p108l.C1746j;
/* renamed from: com.baidu.tts.n.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC1769a implements ITts {

    /* renamed from: a */
    protected C1771c f6272a;

    public AbstractC1769a(C1771c c1771c) {
        this.f6272a = c1771c;
    }

    /* renamed from: a */
    public void m14712a(AbstractC1769a abstractC1769a) {
        this.f6272a.m14698a(abstractC1769a);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public AuthInfo auth(EnumC1710m enumC1710m) {
        return this.f6272a.m14697b(enumC1710m);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public EnumC1710m getMode() {
        return this.f6272a.m14687n();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public TtsListener getTtsListener() {
        return this.f6272a.m14688m();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public C1746j getTtsParams() {
        return this.f6272a.m14686o();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void setContext(Context context) {
        this.f6272a.m14708a(context);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void setMode(EnumC1710m enumC1710m) {
        this.f6272a.m14704a(enumC1710m);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setParam(EnumC1704g enumC1704g, String str) {
        return this.f6272a.m14705a(enumC1704g, str);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void setTtsListener(TtsListener ttsListener) {
        this.f6272a.m14706a(ttsListener);
    }
}
