package com.fimi.soul.view.myhorizontalseebar;

import com.fimi.soul.view.myhorizontalseebar.AbstractC3857c;
/* renamed from: com.fimi.soul.view.myhorizontalseebar.f */
/* loaded from: classes.dex */
class C3860f<T extends AbstractC3857c<T>> implements AbstractC3856b<T> {

    /* renamed from: a */
    private final AbstractC3856b<T> f16377a;

    /* renamed from: b */
    private final Object f16378b;

    public C3860f(AbstractC3856b<T> abstractC3856b) {
        this.f16377a = abstractC3856b;
        this.f16378b = this;
    }

    public C3860f(AbstractC3856b<T> abstractC3856b, Object obj) {
        this.f16377a = abstractC3856b;
        this.f16378b = obj;
    }

    @Override // com.fimi.soul.view.myhorizontalseebar.AbstractC3856b
    /* renamed from: a */
    public T mo6772a() {
        T mo6772a;
        synchronized (this.f16378b) {
            mo6772a = this.f16377a.mo6772a();
        }
        return mo6772a;
    }

    @Override // com.fimi.soul.view.myhorizontalseebar.AbstractC3856b
    /* renamed from: a */
    public void mo6771a(T t) {
        synchronized (this.f16378b) {
            this.f16377a.mo6771a(t);
        }
    }
}
