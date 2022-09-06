package com.fimi.soul.biz.camera.p173c;

import com.fimi.soul.biz.camera.AbstractC2390c;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p193d.p194a.p195a.C2746f;
import com.fimi.soul.drone.p202h.C2858f;
import com.fimi.soul.drone.p203i.C2913h;
import com.fimi.soul.drone.p203i.C2924j;
/* renamed from: com.fimi.soul.biz.camera.c.b */
/* loaded from: classes.dex */
public class C2405b extends C2420e {

    /* renamed from: h */
    private static C2858f f8112h;

    /* renamed from: a */
    private C2746f f8113a;

    /* renamed from: b */
    private boolean f8114b = false;

    /* renamed from: c */
    private boolean f8115c = false;

    /* renamed from: d */
    private boolean f8116d = false;

    /* renamed from: e */
    private int f8117e = 0;

    /* renamed from: f */
    private int f8118f = 0;

    /* renamed from: g */
    private C2858f f8119g;

    public C2405b(AbstractC2390c abstractC2390c) {
        super(abstractC2390c);
        f8112h = new C2858f(1000, new Runnable() { // from class: com.fimi.soul.biz.camera.c.b.1
            @Override // java.lang.Runnable
            public void run() {
                C2405b.m12316a(C2405b.this);
                if (C2405b.this.f8117e > 10) {
                    C2405b.this.f8116d = false;
                    C2405b.f8112h.m10747e();
                }
            }
        });
        m12305o();
    }

    /* renamed from: a */
    static /* synthetic */ int m12316a(C2405b c2405b) {
        int i = c2405b.f8117e;
        c2405b.f8117e = i + 1;
        return i;
    }

    /* renamed from: a */
    private void m12317a(AbstractC2390c.EnumC2400a enumC2400a) {
        if (a().m12336m() != null) {
            a().m12336m().mo9548a(enumC2400a, a().m12342g());
        }
    }

    /* renamed from: a */
    private void m12312a(C2657a c2657a) {
        AbstractC2390c.EnumC2400a m12342g = a().m12342g();
        switch (((C2913h) c2657a.f9269c).m10286f()) {
            case VideoRecording:
                a().m12381a(AbstractC2390c.EnumC2400a.Recoding);
                break;
            case PhotoShoting:
                a().m12381a(AbstractC2390c.EnumC2400a.ContinueCapturing);
                break;
            case NormalReady:
                a().m12381a(AbstractC2390c.EnumC2400a.Normal);
                break;
        }
        m12317a(m12342g);
    }

    /* renamed from: c */
    static /* synthetic */ int m12309c(C2405b c2405b) {
        int i = c2405b.f8118f;
        c2405b.f8118f = i + 1;
        return i;
    }

    /* renamed from: o */
    private void m12305o() {
        this.f8119g = new C2858f(1000, new Runnable() { // from class: com.fimi.soul.biz.camera.c.b.3
            @Override // java.lang.Runnable
            public void run() {
                C2405b.m12309c(C2405b.this);
                if (C2405b.this.f8118f > 2) {
                    if (!C2367d.m12459a().m12438k()) {
                        C2405b.this.mo12246i();
                    }
                    C2405b.this.f8118f = 0;
                }
            }
        });
    }

    @Override // com.fimi.soul.biz.camera.p173c.C2420e
    /* renamed from: a */
    public void mo12253a(C2427e.EnumC2428a enumC2428a) {
        if (this.f8113a != null) {
            this.f8113a.m11171a(enumC2428a);
        }
    }

    @Override // com.fimi.soul.biz.camera.p173c.C2420e
    /* renamed from: b */
    public boolean mo12252b() {
        return this.f8116d;
    }

    @Override // com.fimi.soul.biz.camera.p173c.C2420e
    /* renamed from: c */
    public void mo12251c() {
        if (this.f8113a != null) {
            this.f8114b = true;
            this.f8113a.m11154f();
        }
    }

    @Override // com.fimi.soul.biz.camera.p173c.C2420e
    /* renamed from: d */
    public void mo12250d() {
        m12307h();
    }

    @Override // com.fimi.soul.biz.camera.p173c.C2420e
    /* renamed from: e */
    public void mo12249e() {
        if (this.f8113a != null) {
            this.f8115c = true;
            this.f8113a.m11151i();
        }
    }

    @Override // com.fimi.soul.biz.camera.p173c.C2420e
    /* renamed from: f */
    public void mo12248f() {
        if (this.f8113a != null) {
            this.f8115c = true;
            this.f8113a.m11160b();
        }
    }

    @Override // com.fimi.soul.biz.camera.p173c.C2420e
    /* renamed from: g */
    public void mo12247g() {
        if (this.f8113a != null) {
            this.f8115c = true;
            this.f8113a.m11156d();
        }
    }

    /* renamed from: h */
    public void m12307h() {
        if (this.f8113a != null) {
            this.f8115c = true;
            this.f8113a.m11152h();
        }
    }

    @Override // com.fimi.soul.biz.camera.p173c.C2420e
    /* renamed from: i */
    public void mo12246i() {
        if (this.f8113a != null) {
            this.f8115c = true;
            this.f8113a.m11174a();
        }
    }

    @Override // com.fimi.soul.biz.camera.p173c.C2420e
    /* renamed from: j */
    public void mo12245j() {
        if (this.f8113a != null) {
            this.f8115c = true;
            this.f8113a.m11158c();
        }
    }

    @Override // com.fimi.soul.biz.camera.p173c.C2420e
    /* renamed from: k */
    public void mo12244k() {
        if (this.f8113a != null) {
            this.f8114b = true;
            this.f8113a.m11153g();
        }
    }

    @Override // com.fimi.soul.biz.camera.p173c.C2420e, com.fimi.soul.drone.C2678d.AbstractC2680b
    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        if (!c2657a.mo11216ac() || !c2657a.mo11217ab().mo10898a()) {
            if (f8112h != null) {
                f8112h.m10747e();
            }
            this.f8116d = false;
            if (this.f8119g == null) {
                return;
            }
            this.f8119g.m10746f();
            this.f8119g = null;
            return;
        }
        if (this.f8119g == null) {
            m12305o();
            this.f8119g.m10751c();
        }
        if (this.f8113a == null && c2657a != null) {
            this.f8113a = C2746f.m11170a(c2657a);
            this.f8113a.m11174a();
        }
        if (enumC2679a != C2678d.EnumC2679a.OnRecivedCloudCameraCommandInfo || c2657a.f9269c == null) {
            return;
        }
        int mo10745a = c2657a.f9269c.mo10745a();
        if (mo10745a == 50) {
            this.f8118f = 0;
            switch (((C2913h) c2657a.f9269c).m10286f()) {
                case VideoRecording:
                    this.f8116d = true;
                    this.f8117e = 0;
                    if (f8112h == null) {
                        f8112h = new C2858f(1000, new Runnable() { // from class: com.fimi.soul.biz.camera.c.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                C2405b.m12316a(C2405b.this);
                                if (C2405b.this.f8117e > 10) {
                                    C2405b.this.f8116d = false;
                                    C2405b.f8112h.m10747e();
                                }
                            }
                        });
                    }
                    f8112h.m10749d();
                    return;
                default:
                    return;
            }
        } else if (mo10745a != 49) {
        } else {
            C2924j c2924j = (C2924j) c2657a.f9269c;
            if (c2924j.m10238e() == C2924j.EnumC2925a.StartRecord) {
                this.f8116d = true;
                this.f8117e = 0;
                if (f8112h == null) {
                    return;
                }
                f8112h.m10749d();
            } else if (c2924j.m10238e() != C2924j.EnumC2925a.StopRecrod) {
            } else {
                this.f8116d = false;
                if (f8112h == null) {
                    return;
                }
                f8112h.m10747e();
            }
        }
    }
}
