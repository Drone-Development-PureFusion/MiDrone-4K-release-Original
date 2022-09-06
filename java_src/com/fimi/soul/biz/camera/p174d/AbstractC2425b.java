package com.fimi.soul.biz.camera.p174d;

import com.fimi.soul.biz.camera.p172b.AbstractC2384b;
/* renamed from: com.fimi.soul.biz.camera.d.b */
/* loaded from: classes.dex */
public abstract class AbstractC2425b implements AbstractC2384b {

    /* renamed from: a */
    private AbstractC2425b f8169a;

    /* renamed from: a */
    public void m12225a(AbstractC2425b abstractC2425b) {
        this.f8169a = abstractC2425b;
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2384b
    /* renamed from: b */
    public AbstractC2384b mo12224b() {
        return this.f8169a;
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2384b
    /* renamed from: c */
    public boolean mo12223c() {
        return this.f8169a != null;
    }
}
