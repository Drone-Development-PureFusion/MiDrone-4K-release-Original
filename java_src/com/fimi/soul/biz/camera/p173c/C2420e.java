package com.fimi.soul.biz.camera.p173c;

import com.fimi.soul.biz.camera.AbstractC2390c;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.camera.entity.X11RespCmd;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
/* renamed from: com.fimi.soul.biz.camera.c.e */
/* loaded from: classes.dex */
public class C2420e extends AbstractC2404a implements C2678d.AbstractC2680b {
    public C2420e(AbstractC2390c abstractC2390c) {
        super(abstractC2390c);
    }

    /* renamed from: a */
    public void mo12253a(C2427e.EnumC2428a enumC2428a) {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.fimi.soul.biz.camera.p173c.AbstractC2404a, com.fimi.soul.biz.camera.p172b.AbstractC2388f
    /* renamed from: a */
    public void mo6450a(boolean z, X11RespCmd x11RespCmd) {
        super.mo6450a(z, x11RespCmd);
        if (z) {
            switch (x11RespCmd.getMsg_id()) {
                case C2427e.f8179I /* 513 */:
                    a().m12381a(AbstractC2390c.EnumC2400a.Recoding);
                    return;
                case 514:
                case C2427e.f8184N /* 770 */:
                    a().m12381a(AbstractC2390c.EnumC2400a.Normal);
                    return;
                case C2427e.f8183M /* 769 */:
                    if (!a().m12339j().isContinueCaptureMode()) {
                        return;
                    }
                    a().m12381a(AbstractC2390c.EnumC2400a.ContinueCapturing);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: b */
    public boolean mo12252b() {
        return false;
    }

    /* renamed from: c */
    public void mo12251c() {
        a(C2427e.f8183M);
    }

    /* renamed from: d */
    public void mo12250d() {
        a(C2427e.f8184N);
    }

    /* renamed from: e */
    public void mo12249e() {
    }

    /* renamed from: f */
    public void mo12248f() {
        a(C2427e.f8179I);
    }

    /* renamed from: g */
    public void mo12247g() {
        a(514);
    }

    /* renamed from: i */
    public void mo12246i() {
    }

    /* renamed from: j */
    public void mo12245j() {
    }

    /* renamed from: k */
    public void mo12244k() {
    }

    /* renamed from: m */
    public void m12243m() {
        a(C2427e.f8181K);
    }

    /* renamed from: n */
    public void m12242n() {
        a(C2427e.f8182L);
    }

    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
    }
}
