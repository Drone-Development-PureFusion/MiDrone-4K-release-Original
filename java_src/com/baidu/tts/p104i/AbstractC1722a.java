package com.baidu.tts.p104i;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* renamed from: com.baidu.tts.i.a */
/* loaded from: classes.dex */
public abstract class AbstractC1722a implements AbstractC1724b {

    /* renamed from: d */
    protected final Lock f6216d = new ReentrantLock();

    /* renamed from: e */
    protected final Condition f6217e = this.f6216d.newCondition();

    /* renamed from: com.baidu.tts.i.a$a */
    /* loaded from: classes.dex */
    public interface AbstractC1723a {
        /* renamed from: a */
        void m14833a();
    }

    /* renamed from: A */
    public boolean m14846A() {
        try {
            m14845a(null);
        } catch (InterruptedException e) {
            m14834z();
        }
        return !mo14836n();
    }

    /* renamed from: a */
    public void m14845a(AbstractC1723a abstractC1723a) {
        while (mo14837m()) {
            m14844b(abstractC1723a);
        }
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: b */
    public synchronized TtsError mo14683b() {
        return mo14843g();
    }

    /* renamed from: b */
    public void m14844b(AbstractC1723a abstractC1723a) {
        try {
            this.f6216d.lock();
            if (abstractC1723a != null) {
                abstractC1723a.m14833a();
            }
            LoggerProxy.m15091d("ASafeLife", "before await");
            this.f6217e.await();
            LoggerProxy.m15091d("ASafeLife", "after await");
        } finally {
            this.f6216d.unlock();
        }
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: c */
    public synchronized void mo14682c() {
        mo14841i();
        try {
            this.f6216d.lock();
            this.f6217e.signalAll();
            this.f6216d.unlock();
        } catch (Exception e) {
            e.printStackTrace();
            this.f6216d.unlock();
        }
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: d */
    public synchronized void mo14681d() {
        mo14840j();
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: e */
    public synchronized void mo14680e() {
        mo14839k();
    }

    @Override // com.baidu.tts.p104i.AbstractC1724b
    /* renamed from: f */
    public synchronized void mo14679f() {
        mo14838l();
    }

    /* renamed from: g */
    protected abstract TtsError mo14843g();

    /* renamed from: h */
    protected abstract void mo14842h();

    /* renamed from: i */
    protected abstract void mo14841i();

    /* renamed from: j */
    protected abstract void mo14840j();

    /* renamed from: k */
    protected abstract void mo14839k();

    /* renamed from: l */
    protected abstract void mo14838l();

    /* renamed from: m */
    public abstract boolean mo14837m();

    /* renamed from: n */
    public abstract boolean mo14836n();

    /* renamed from: y */
    public synchronized void m14835y() {
        mo14842h();
    }

    /* renamed from: z */
    public void m14834z() {
        Thread.currentThread().interrupt();
    }
}
