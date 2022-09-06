package com.fimi.soul.module.login;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Message;
import com.android.volley.C1321d;
import com.fimi.kernel.p157b.p161d.C2225c;
import com.fimi.p139b.AbstractC2089b;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.camera.p171a.C2377b;
import com.fimi.soul.biz.camera.p172b.AbstractC2385c;
import com.fimi.soul.biz.p168a.C2364c;
import com.fimi.soul.biz.p168a.C2367d;
import com.fimi.soul.biz.p176e.C2440a;
import com.fimi.soul.biz.p177f.C2441a;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.droneconnection.connection.C2779b;
import com.fimi.soul.drone.droneconnection.connection.p196a.C2778a;
import com.fimi.soul.drone.p199e.C2837o;
import com.fimi.soul.drone.p202h.C2854c;
import com.fimi.soul.module.setting.GimalCalibration.C3450a;
import com.fimi.soul.utils.C3658ar;
/* renamed from: com.fimi.soul.module.login.b */
/* loaded from: classes.dex */
public class C3379b extends AbstractC2089b {

    /* renamed from: r */
    private C2657a f13152r;

    /* renamed from: s */
    private LoginActivity f13153s;

    /* renamed from: t */
    private C2440a f13154t;

    /* renamed from: w */
    private C3450a f13157w;

    /* renamed from: q */
    private final int f13151q = 35000;

    /* renamed from: x */
    private final Handler f13158x = new Handler() { // from class: com.fimi.soul.module.login.b.2
        @Override // android.os.Handler
        @TargetApi(17)
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    if (C3379b.this.f13153s.m8615o() != 2 || C3379b.this.f6997n > 0) {
                        return;
                    }
                    C3379b.this.f13153s.m8646a(4);
                    if (C2441a.m12168a().m12166b() == 1) {
                        C3379b.this.f13153s.m8645a(C2300R.C2303string.rc_tip_error, C2300R.C2303string.unconnetremote);
                    } else {
                        C3379b.this.f13153s.m8645a(C2300R.C2303string.rc_tip_error2, C2300R.C2303string.unconnetremote);
                    }
                    C3379b.this.a();
                    return;
                case 1:
                    if (C3379b.this.f13153s.m8615o() != 2 || C3379b.this.f6997n > 0) {
                        return;
                    }
                    for (int i = 0; !C3379b.this.f13152r.mo11216ac() && i < 5; i++) {
                        C3379b.this.a(50);
                    }
                    if (!C3379b.this.f13152r.mo11216ac()) {
                        C3379b.this.f13153s.m8645a(C2300R.C2303string.fc_tip_error, C2300R.C2303string.unconnectdrone);
                    } else {
                        C3379b.this.f13157w.m8423d();
                        if (C3379b.this.f13152r.m11319am()) {
                            C3379b.this.f13153s.m8646a(3);
                            C3379b.this.f13153s.m8617m();
                            C3379b.this.f13153s.m8618l();
                        } else {
                            C3379b.this.f13153s.m8619k();
                        }
                        C2779b.m11019a(true);
                    }
                    C3379b.this.f13154t.m12169d();
                    return;
                case 2:
                case 3:
                default:
                    return;
                case 4:
                    if (C3379b.this.f13153s.m8615o() == 1) {
                        return;
                    }
                    if (C3379b.this.f13154t != null) {
                        C3379b.this.f13154t.m12172a(false);
                    }
                    C3379b.this.a();
                    C3379b.this.a(C3379b.this.f13159y);
                    C3379b.this.f13150p.sendEmptyMessageDelayed(0, 35000L);
                    C2779b.m11019a(false);
                    return;
            }
        }
    };

    /* renamed from: p */
    public Handler f13150p = new Handler() { // from class: com.fimi.soul.module.login.b.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    if (C3379b.this.f13153s.m8615o() != 2 || C3379b.this.f6997n > 0) {
                        return;
                    }
                    C3379b.this.f13153s.m8646a(4);
                    if (C2441a.m12168a().m12166b() == 1) {
                        C3379b.this.f13153s.m8645a(C2300R.C2303string.rc_tip_error, C2300R.C2303string.unconnetremote);
                    } else {
                        C3379b.this.f13153s.m8645a(C2300R.C2303string.rc_tip_error2, C2300R.C2303string.unconnetremote);
                    }
                    C3379b.this.a();
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: y */
    private Runnable f13159y = new Runnable() { // from class: com.fimi.soul.module.login.b.4
        @Override // java.lang.Runnable
        public void run() {
            C2779b.m11013c(true);
            C3379b.this.a(false);
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i = 0; !C3379b.this.b() && i < 25; i++) {
                z = C3379b.this.f13154t.m12170c();
                if (z) {
                    if (!z2) {
                        z2 = C3658ar.m7587d(C2854c.m10763b());
                    }
                    if (z2 && !C3379b.this.f13152r.mo11217ab().mo10898a()) {
                        C3379b.this.m8547j();
                    }
                    C3379b.this.a(1500);
                    if (C3379b.this.f13152r.mo11217ab().mo10898a() && !z3) {
                        C2837o.f10459a.f9714d = (byte) 0;
                        C2837o.f10459a.f9715e = (byte) 2;
                        C3379b.this.f13152r.mo11217ab().mo10897a(C2837o.f10459a.mo11073b());
                        z3 = true;
                    }
                    if ((C3379b.this.f13152r.mo11217ab().mo10898a() || C3379b.this.f13152r.mo11216ac()) && z) {
                        break;
                    }
                } else {
                    C3379b.this.f13154t.m12173a();
                    C3379b.this.f13156v.m12466b();
                    C3379b.this.a(C1321d.f4545a);
                }
            }
            if (C3379b.this.f13150p.hasMessages(0)) {
                C3379b.this.f13150p.removeMessages(0);
            }
            if (!C3379b.this.f13152r.mo11217ab().mo10898a() || !z) {
                C3379b.this.f13158x.sendEmptyMessage(0);
            } else {
                C3379b.this.f13158x.sendEmptyMessageDelayed(1, 1500L);
            }
            C2779b.m11013c(false);
        }
    };

    /* renamed from: u */
    private C2367d f13155u = C2367d.m12459a();

    /* renamed from: v */
    private C2364c f13156v = C2364c.m12469a();

    public C3379b(LoginActivity loginActivity, C2657a c2657a) {
        this.f13152r = c2657a;
        this.f13153s = loginActivity;
        this.f13157w = new C3450a(null, c2657a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m8547j() {
        C2778a.m11026a(C2854c.f10616d);
        this.f13152r.mo11217ab().mo10891b();
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: a */
    public void mo6654a(C2440a c2440a) {
        this.f13154t = c2440a;
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: c */
    public int mo6651c() {
        getClass();
        return 35000;
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: d */
    public void mo6649d() {
        this.f13155u.m12434o().m13167f().a(C2427e.m12220b());
        this.f13156v.m12460f().m13167f().a(C2427e.m12219c());
        mo6647e();
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: e */
    public void mo6647e() {
        AbstractC2385c m12392e = C2379b.m12410a().m12392e();
        if (m12392e == null || !(m12392e instanceof C2377b)) {
            return;
        }
        C2377b c2377b = (C2377b) m12392e;
        C2225c m12411g = c2377b.m12411g();
        if (m12411g != null) {
            m12411g.m13167f().a(C2427e.m12221a());
        }
        C2225c m12412f = c2377b.m12412f();
        if (m12412f == null) {
            return;
        }
        m12412f.m13167f().a(C2427e.m12221a());
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: f */
    public void mo6645f() {
        this.f13158x.sendEmptyMessageDelayed(4, 500L);
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: g */
    public void mo6643g() {
        this.f13158x.removeCallbacks(this.f13159y);
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: h */
    public void mo6642h() {
        if (this.f13150p.hasMessages(0)) {
            this.f13150p.removeMessages(0);
        }
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: i */
    public void mo6641i() {
        this.f13150p.postDelayed(new Runnable() { // from class: com.fimi.soul.module.login.b.1
            @Override // java.lang.Runnable
            public void run() {
                C3379b.this.f13153s.m8621j();
            }
        }, 1000L);
    }
}
