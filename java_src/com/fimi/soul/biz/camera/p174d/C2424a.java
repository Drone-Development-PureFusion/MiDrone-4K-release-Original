package com.fimi.soul.biz.camera.p174d;

import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.biz.camera.p172b.AbstractC2384b;
import com.fimi.soul.biz.camera.p172b.AbstractC2388f;
/* renamed from: com.fimi.soul.biz.camera.d.a */
/* loaded from: classes.dex */
public class C2424a implements AbstractC2388f<X11RespCmd> {

    /* renamed from: a */
    private AbstractC2384b f8168a;

    /* renamed from: a */
    public void m12227a(AbstractC2384b abstractC2384b) {
        if (this.f8168a != null) {
            this.f8168a.mo12222a();
        }
    }

    @Override // com.fimi.soul.biz.camera.p172b.AbstractC2388f
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo6450a(boolean z, X11RespCmd x11RespCmd) {
        if (!z || !this.f8168a.mo12223c()) {
            return;
        }
        m12227a(this.f8168a.mo12224b());
    }
}
