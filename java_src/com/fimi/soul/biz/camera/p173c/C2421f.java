package com.fimi.soul.biz.camera.p173c;

import com.fimi.kernel.C2238c;
import com.fimi.soul.biz.camera.AbstractC2390c;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2423d;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.camera.entity.BaseX11Cmd;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.entity.CameraValue;
/* renamed from: com.fimi.soul.biz.camera.c.f */
/* loaded from: classes.dex */
public class C2421f extends AbstractC2404a {

    /* renamed from: a */
    int f8160a = 0;

    public C2421f(AbstractC2390c abstractC2390c) {
        super(abstractC2390c);
    }

    /* renamed from: a */
    public void m12241a(boolean z) {
        BaseX11Cmd b = b(C2427e.f8228ae, null, null);
        b.setToken(this.f8160a);
        b.setRval(z ? 0 : -1);
        if (z) {
            b.setToken(this.f8160a);
            a().m12388a(this.f8160a);
        }
        a(b);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.fimi.soul.biz.camera.p173c.AbstractC2404a, com.fimi.soul.biz.camera.p172b.AbstractC2388f
    /* renamed from: a */
    public void mo6450a(boolean z, X11RespCmd x11RespCmd) {
        super.mo6450a(z, x11RespCmd);
        switch (x11RespCmd.getMsg_id()) {
            case 257:
                if (!z) {
                    a().m12388a(x11RespCmd.getRval());
                    return;
                }
                a().m12388a(Integer.parseInt(x11RespCmd.getParam().toString()));
                this.f8160a = a().m12344f();
                a().m12381a(AbstractC2390c.EnumC2400a.Normal);
                a().m12333p();
                ((C2423d) C2379b.m12410a().m12394d()).m12233u().m12291d();
                C2238c.m13123e().m12772c(true);
                C2238c.m13123e().m12768d(true);
                return;
            case C2427e.f8228ae /* 1793 */:
                m12241a(true);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    public void m12240b() {
        if (!CameraValue.hasSession) {
            BaseX11Cmd b = b(257, null, null);
            b.setToken(0);
            a(b);
        }
    }

    /* renamed from: c */
    public void m12239c() {
        a(C2427e.f8175E);
    }
}
