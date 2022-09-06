package com.fimi.kernel.p157b.p158a;

import it.p235a.p236a.AbstractC4869k;
/* renamed from: com.fimi.kernel.b.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC2183a implements AbstractC4869k {

    /* renamed from: com.fimi.kernel.b.a.a$a */
    /* loaded from: classes.dex */
    public enum EnumC2184a {
        Started,
        Transferred,
        Aborted,
        Completed,
        Failed
    }

    @Override // it.p235a.p236a.AbstractC4869k
    /* renamed from: a */
    public void mo3002a() {
        mo11427a(EnumC2184a.Aborted, 0);
    }

    @Override // it.p235a.p236a.AbstractC4869k
    /* renamed from: a */
    public void mo3001a(int i) {
        mo11427a(EnumC2184a.Transferred, i);
    }

    /* renamed from: a */
    public abstract void mo11427a(EnumC2184a enumC2184a, int i);

    @Override // it.p235a.p236a.AbstractC4869k
    /* renamed from: b */
    public void mo3000b() {
        mo11427a(EnumC2184a.Completed, 0);
    }

    @Override // it.p235a.p236a.AbstractC4869k
    /* renamed from: c */
    public void mo2999c() {
        mo11427a(EnumC2184a.Failed, 0);
    }

    @Override // it.p235a.p236a.AbstractC4869k
    /* renamed from: d */
    public void mo2998d() {
        mo11427a(EnumC2184a.Started, 0);
    }
}
