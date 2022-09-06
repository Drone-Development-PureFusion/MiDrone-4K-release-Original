package com.baidu.tts.p110n.p111a;

import android.content.Context;
import com.baidu.tts.aop.tts.ITts;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.auth.C1599a;
import com.baidu.tts.p081a.p084c.C1592b;
import com.baidu.tts.p081a.p084c.C1596c;
import com.baidu.tts.p085b.p086a.C1611a;
import com.baidu.tts.p085b.p086a.p087a.AbstractC1618d;
import com.baidu.tts.p085b.p089b.p090a.C1646f;
import com.baidu.tts.p096e.EnumC1703f;
import com.baidu.tts.p096e.EnumC1704g;
import com.baidu.tts.p096e.EnumC1710m;
import com.baidu.tts.p096e.EnumC1711n;
import com.baidu.tts.p099g.p100a.C1717c;
import com.baidu.tts.p099g.p101b.C1719b;
import com.baidu.tts.p108l.C1741e;
import com.baidu.tts.p108l.C1742f;
import com.baidu.tts.p108l.C1743g;
import com.baidu.tts.p108l.C1744h;
import com.baidu.tts.p108l.C1745i;
import com.baidu.tts.p108l.C1746j;
/* renamed from: com.baidu.tts.n.a.c */
/* loaded from: classes.dex */
public class C1771c implements ITts {

    /* renamed from: a */
    static final /* synthetic */ boolean f6273a;

    /* renamed from: c */
    private TtsListener f6275c;

    /* renamed from: d */
    private EnumC1710m f6276d;

    /* renamed from: e */
    private C1596c f6277e;

    /* renamed from: b */
    private C1746j f6274b = new C1746j();

    /* renamed from: g */
    private C1773d f6279g = new C1773d(this);

    /* renamed from: h */
    private C1770b f6280h = new C1770b(this);

    /* renamed from: f */
    private volatile AbstractC1769a f6278f = this.f6279g;

    static {
        f6273a = !C1771c.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m14710a(float f, float f2) {
        return this.f6277e.m15353a(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m14709a(int i) {
        try {
            return this.f6277e.m15340f().mo15370a().mo15144a(i);
        } catch (Exception e) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m14705a(EnumC1704g enumC1704g, String str) {
        if (this.f6274b != null) {
            return this.f6274b.m14729a(enumC1704g, str);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m14703a(C1741e c1741e) {
        return this.f6277e.m15350a(c1741e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m14702a(C1742f c1742f) {
        return this.f6277e.m15349a(c1742f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m14701a(C1743g c1743g) {
        return this.f6277e.m15348a(c1743g);
    }

    /* renamed from: a */
    public C1773d m14711a() {
        return this.f6279g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m14708a(Context context) {
        C1719b.m14869a().m14868a(context);
    }

    /* renamed from: a */
    public void m14707a(TtsError ttsError) {
        m14700a(C1744h.m14750b(ttsError));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m14706a(TtsListener ttsListener) {
        if (ttsListener == null || ttsListener == this.f6275c) {
            return;
        }
        this.f6275c = ttsListener;
        if (this.f6277e == null) {
            return;
        }
        this.f6277e.m15351a(this.f6275c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m14704a(EnumC1710m enumC1710m) {
        this.f6276d = enumC1710m;
    }

    /* renamed from: a */
    public void m14700a(C1744h c1744h) {
        if (this.f6275c != null) {
            this.f6275c.onError(c1744h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m14699a(C1745i c1745i) {
        this.f6277e.m15347a(c1745i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m14698a(AbstractC1769a abstractC1769a) {
        this.f6278f = abstractC1769a;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public AuthInfo auth(EnumC1710m enumC1710m) {
        return this.f6278f.auth(enumC1710m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public int m14696b(C1741e c1741e) {
        return this.f6277e.m15345b(c1741e);
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: b */
    public TtsError mo14683b() {
        return this.f6278f.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public AuthInfo m14697b(EnumC1710m enumC1710m) {
        return C1599a.m15330a().m15326a(enumC1710m, this.f6274b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m14695b(C1745i c1745i) {
        this.f6277e.m15344b(c1745i);
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: c */
    public void mo14682c() {
        this.f6278f.c();
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: d */
    public void mo14681d() {
        this.f6278f.d();
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: e */
    public void mo14680e() {
        this.f6278f.e();
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: f */
    public void mo14679f() {
        this.f6278f.f();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int freeCustomResource(C1741e c1741e) {
        return this.f6278f.freeCustomResource(c1741e);
    }

    /* renamed from: g */
    public C1770b m14694g() {
        return this.f6280h;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public EnumC1710m getMode() {
        return this.f6278f.getMode();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public TtsListener getTtsListener() {
        return this.f6278f.getTtsListener();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public C1746j getTtsParams() {
        return this.f6278f.getTtsParams();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public TtsError m14693h() {
        AbstractC1618d m15281a;
        Cloneable cloneable = null;
        if (this.f6276d == null) {
            this.f6276d = EnumC1710m.ONLINE;
        }
        if (this.f6274b == null) {
            this.f6274b = new C1746j();
        }
        TtsError mo14683b = C1719b.m14869a().mo14683b();
        if (f6273a || mo14683b == null) {
            switch (this.f6276d) {
                case ONLINE:
                    m15281a = C1611a.m15283a().m15281a(EnumC1703f.ONLINE);
                    cloneable = this.f6274b.m14726c();
                    break;
                case OFFLINE:
                    m15281a = C1611a.m15283a().m15281a(EnumC1703f.OFFLINE);
                    cloneable = this.f6274b.m14725d();
                    break;
                case MIX:
                    m15281a = C1611a.m15283a().m15281a(EnumC1703f.MIX);
                    cloneable = this.f6274b.m14730a();
                    break;
                default:
                    m15281a = null;
                    break;
            }
            if (m15281a == null || cloneable == null) {
                return C1717c.m14880a().m14873b(EnumC1711n.TTS_UNINITIAL);
            }
            m15281a.mo15247a((AbstractC1618d) cloneable);
            C1646f c1646f = new C1646f();
            c1646f.mo15142a((C1646f) this.f6274b.m14728b());
            this.f6277e = new C1596c();
            this.f6277e.m15352a(new C1592b(m15281a, c1646f, this.f6274b));
            if (this.f6275c != null) {
                this.f6277e.m15351a(this.f6275c);
            }
            return this.f6277e.m15354a();
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public void m14692i() {
        this.f6277e.m15346b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public void m14691j() {
        this.f6277e.m15343c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public void m14690k() {
        this.f6277e.m15342d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public void m14689l() {
        this.f6277e.m15341e();
        C1599a.m15330a().m15322b();
        C1719b.m14869a().mo14679f();
        this.f6274b = new C1746j();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadCustomResource(C1741e c1741e) {
        return this.f6278f.loadCustomResource(c1741e);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadEnglishModel(C1742f c1742f) {
        return this.f6278f.loadEnglishModel(c1742f);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadModel(C1743g c1743g) {
        return this.f6278f.loadModel(c1743g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public TtsListener m14688m() {
        return this.f6275c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public EnumC1710m m14687n() {
        return this.f6276d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public C1746j m14686o() {
        return this.f6274b;
    }

    /* renamed from: p */
    public int m14685p() {
        if (this.f6275c == null) {
            throw new IllegalStateException(EnumC1711n.TTS_UNINITIAL.m14885c());
        }
        m14707a(C1717c.m14880a().m14873b(EnumC1711n.TTS_UNINITIAL));
        return -1;
    }

    /* renamed from: q */
    public boolean m14684q() {
        return this.f6280h == this.f6278f;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setAudioStreamType(int i) {
        return this.f6278f.setAudioStreamType(i);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void setContext(Context context) {
        this.f6278f.setContext(context);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void setMode(EnumC1710m enumC1710m) {
        this.f6278f.setMode(enumC1710m);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setParam(EnumC1704g enumC1704g, String str) {
        return this.f6278f.setParam(enumC1704g, str);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setStereoVolume(float f, float f2) {
        return this.f6278f.setStereoVolume(f, f2);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void setTtsListener(TtsListener ttsListener) {
        this.f6278f.setTtsListener(ttsListener);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void speak(C1745i c1745i) {
        this.f6278f.speak(c1745i);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void synthesize(C1745i c1745i) {
        this.f6278f.synthesize(c1745i);
    }
}
