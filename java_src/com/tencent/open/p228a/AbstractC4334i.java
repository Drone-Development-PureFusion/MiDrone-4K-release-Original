package com.tencent.open.p228a;

import com.tencent.open.p228a.C4324d;
/* renamed from: com.tencent.open.a.i */
/* loaded from: classes.dex */
public abstract class AbstractC4334i {

    /* renamed from: a */
    private volatile int f18124a;

    /* renamed from: b */
    private volatile boolean f18125b;

    /* renamed from: c */
    private C4333h f18126c;

    public AbstractC4334i() {
        this(C4323c.f18094b, true, C4333h.f18123a);
    }

    public AbstractC4334i(int i, boolean z, C4333h c4333h) {
        this.f18124a = C4323c.f18094b;
        this.f18125b = true;
        this.f18126c = C4333h.f18123a;
        m5432a(i);
        m5429a(z);
        m5430a(c4333h);
    }

    /* renamed from: a */
    public void m5432a(int i) {
        this.f18124a = i;
    }

    /* renamed from: a */
    protected abstract void mo5431a(int i, Thread thread, long j, String str, String str2, Throwable th);

    /* renamed from: a */
    public void m5430a(C4333h c4333h) {
        this.f18126c = c4333h;
    }

    /* renamed from: a */
    public void m5429a(boolean z) {
        this.f18125b = z;
    }

    /* renamed from: b */
    public void m5428b(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (!m5427d() || !C4324d.C4325a.m5462a(this.f18124a, i)) {
            return;
        }
        mo5431a(i, thread, j, str, str2, th);
    }

    /* renamed from: d */
    public boolean m5427d() {
        return this.f18125b;
    }

    /* renamed from: e */
    public C4333h m5426e() {
        return this.f18126c;
    }
}
