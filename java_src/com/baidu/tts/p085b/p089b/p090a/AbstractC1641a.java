package com.baidu.tts.p085b.p089b.p090a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.p085b.p089b.AbstractC1640a;
import com.baidu.tts.p104i.AbstractC1722a;
import com.baidu.tts.p108l.C1744h;
/* renamed from: com.baidu.tts.b.b.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC1641a extends AbstractC1722a implements AbstractC1643c {

    /* renamed from: a */
    protected AbstractC1640a f5783a;

    /* renamed from: b */
    protected volatile AbstractC1642b f5784b;

    @Override // com.baidu.tts.p085b.p089b.p090a.AbstractC1643c
    /* renamed from: a */
    public int mo15145a(float f, float f2) {
        return this.f5784b.mo15145a(f, f2);
    }

    @Override // com.baidu.tts.p085b.p089b.p090a.AbstractC1643c
    /* renamed from: a */
    public int mo15144a(int i) {
        return this.f5784b.mo15144a(i);
    }

    /* renamed from: a */
    public AbstractC1642b m15151a() {
        return this.f5784b;
    }

    /* renamed from: a */
    public void m15150a(AbstractC1642b abstractC1642b) {
        this.f5784b = abstractC1642b;
    }

    @Override // com.baidu.tts.p085b.p089b.p090a.AbstractC1643c
    /* renamed from: a */
    public void mo15143a(AbstractC1640a abstractC1640a) {
        this.f5784b.mo15143a(abstractC1640a);
    }

    @Override // com.baidu.tts.p085b.p089b.p090a.AbstractC1643c
    /* renamed from: a */
    public void mo15122a(C1744h c1744h) {
        this.f5784b.mo15122a(c1744h);
    }

    @Override // com.baidu.tts.p085b.p089b.p090a.AbstractC1643c
    /* renamed from: a */
    public <T> void mo15142a(T t) {
        this.f5784b.mo15142a((AbstractC1642b) t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m15149b(C1744h c1744h) {
        if (!A() || this.f5783a == null) {
            return;
        }
        this.f5783a.mo15125a(c1744h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void m15148c(C1744h c1744h) {
        if (!A() || this.f5783a == null) {
            return;
        }
        this.f5783a.mo15124b(c1744h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public void m15147d(C1744h c1744h) {
        if (!A() || this.f5783a == null) {
            return;
        }
        this.f5783a.mo15123c(c1744h);
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: g */
    protected TtsError mo14843g() {
        return this.f5784b.mo14683b();
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: h */
    protected void mo14842h() {
        this.f5784b.mo15141a();
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: i */
    protected void mo14841i() {
        this.f5784b.mo14682c();
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: j */
    protected void mo14840j() {
        this.f5784b.mo14681d();
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: k */
    protected void mo14839k() {
        this.f5784b.mo14680e();
    }

    @Override // com.baidu.tts.p104i.AbstractC1722a
    /* renamed from: l */
    protected void mo14838l() {
        this.f5784b.mo14679f();
    }

    @Override // com.baidu.tts.p085b.p089b.p090a.AbstractC1643c
    /* renamed from: o */
    public void mo15121o() {
        this.f5784b.mo15121o();
    }
}
