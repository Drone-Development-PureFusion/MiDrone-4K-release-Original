package com.fimi.p139b;

import com.fimi.p139b.p141b.EnumC2091b;
import com.fimi.p139b.p142c.AbstractC2094b;
import com.fimi.soul.biz.p176e.C2440a;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.module.login.C3379b;
import com.fimi.soul.module.login.LoginActivity;
import com.fimi.x1bh.p212a.C3888b;
/* renamed from: com.fimi.b.e */
/* loaded from: classes.dex */
public class C2100e implements AbstractC2094b {

    /* renamed from: a */
    AbstractC2094b f7017a;

    public C2100e(LoginActivity loginActivity, C2657a c2657a, EnumC2091b enumC2091b) {
        switch (enumC2091b) {
            case DRONE:
                this.f7017a = new C3379b(loginActivity, c2657a);
                return;
            case X1BH:
                this.f7017a = new C3888b(loginActivity);
                return;
            default:
                return;
        }
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: a */
    public void mo13734a() {
        this.f7017a.mo13734a();
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: a */
    public void mo13733a(int i) {
        this.f7017a.mo13733a(i);
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: a */
    public void mo6654a(C2440a c2440a) {
        this.f7017a.mo6654a(c2440a);
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: a */
    public void mo13732a(Runnable runnable) {
        this.f7017a.mo13732a(runnable);
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: a */
    public void mo13731a(boolean z) {
        this.f7017a.mo13731a(z);
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: b */
    public boolean mo13730b() {
        return this.f7017a.mo13730b();
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: c */
    public int mo6651c() {
        return this.f7017a.mo6651c();
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: d */
    public void mo6649d() {
        this.f7017a.mo6649d();
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: e */
    public void mo6647e() {
        this.f7017a.mo6647e();
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: f */
    public void mo6645f() {
        this.f7017a.mo6645f();
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: g */
    public void mo6643g() {
        this.f7017a.mo6643g();
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: h */
    public void mo6642h() {
        this.f7017a.mo6642h();
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: i */
    public void mo6641i() {
        this.f7017a.mo6641i();
    }
}
