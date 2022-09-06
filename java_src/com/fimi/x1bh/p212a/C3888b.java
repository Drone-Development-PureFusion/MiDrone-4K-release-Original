package com.fimi.x1bh.p212a;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Message;
import com.fimi.kernel.p157b.p161d.C2225c;
import com.fimi.p139b.AbstractC2089b;
import com.fimi.soul.C2300R;
import com.fimi.soul.biz.camera.C2379b;
import com.fimi.soul.biz.camera.C2427e;
import com.fimi.soul.biz.camera.p171a.C2377b;
import com.fimi.soul.biz.camera.p172b.AbstractC2385c;
import com.fimi.soul.biz.p176e.C2440a;
import com.fimi.soul.biz.p177f.C2441a;
import com.fimi.soul.module.login.LoginActivity;
import com.fimi.soul.utils.C3658ar;
/* renamed from: com.fimi.x1bh.a.b */
/* loaded from: classes.dex */
public class C3888b extends AbstractC2089b {

    /* renamed from: r */
    private LoginActivity f16554r;

    /* renamed from: q */
    private final int f16553q = 35000;

    /* renamed from: s */
    private final Handler f16555s = new Handler() { // from class: com.fimi.x1bh.a.b.2
        @Override // android.os.Handler
        @TargetApi(17)
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    if (C3888b.this.f16554r.m8615o() != 2 || C3888b.this.f6997n > 0) {
                        return;
                    }
                    C3888b.this.f16554r.m8646a(4);
                    if (C2441a.m12168a().m12166b() == 1) {
                        C3888b.this.f16554r.m8645a(C2300R.C2303string.rc_tip_error_x1bh, C2300R.C2303string.unconnetremote_x1bh);
                    } else {
                        C3888b.this.f16554r.m8645a(C2300R.C2303string.rc_tip_error_x1bh, C2300R.C2303string.unconnetremote_x1bh);
                    }
                    C3888b.this.a();
                    return;
                case 1:
                    if (C3888b.this.f16554r.m8615o() != 2 || C3888b.this.f6997n > 0) {
                        return;
                    }
                    C3888b.this.f16554r.m8646a(3);
                    C3888b.this.f16554r.m8616n();
                    C3888b.this.f16554r.m8618l();
                    return;
                case 2:
                case 3:
                default:
                    return;
                case 4:
                    if (C3888b.this.f16554r.m8615o() == 1) {
                        return;
                    }
                    C3888b.this.a();
                    C3888b.this.a(C3888b.this.f16556t);
                    C3888b.this.f16552p.sendEmptyMessageDelayed(0, 35000L);
                    return;
            }
        }
    };

    /* renamed from: p */
    public Handler f16552p = new Handler() { // from class: com.fimi.x1bh.a.b.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    if (C3888b.this.f16554r.m8615o() != 2 || C3888b.this.f6997n > 0) {
                        return;
                    }
                    C3888b.this.f16554r.m8646a(4);
                    if (C2441a.m12168a().m12166b() == 1) {
                        C3888b.this.f16554r.m8645a(C2300R.C2303string.rc_tip_error_x1bh, C2300R.C2303string.unconnetremote_x1bh);
                    } else {
                        C3888b.this.f16554r.m8645a(C2300R.C2303string.rc_tip_error_x1bh, C2300R.C2303string.unconnetremote_x1bh);
                    }
                    C3888b.this.a();
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: t */
    private Runnable f16556t = new Runnable() { // from class: com.fimi.x1bh.a.b.4
        @Override // java.lang.Runnable
        public void run() {
            C3888b.this.a(false);
            boolean z = false;
            for (int i = 0; !C3888b.this.b() && i < 25 && !z; i++) {
                z = C3658ar.m7587d(C2427e.f8197a);
                C3888b.this.a(1500);
            }
            if (C3888b.this.f16552p.hasMessages(0)) {
                C3888b.this.f16552p.removeMessages(0);
            }
            if (z) {
                C3888b.this.f16555s.sendEmptyMessageDelayed(1, 1500L);
            } else {
                C3888b.this.f16555s.sendEmptyMessage(0);
            }
        }
    };

    public C3888b(LoginActivity loginActivity) {
        this.f16554r = loginActivity;
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: a */
    public void mo6654a(C2440a c2440a) {
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: c */
    public int mo6651c() {
        return 35000;
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: d */
    public void mo6649d() {
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
        this.f16555s.sendEmptyMessageDelayed(4, 500L);
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: g */
    public void mo6643g() {
        this.f16555s.removeCallbacks(this.f16556t);
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: h */
    public void mo6642h() {
        if (this.f16552p.hasMessages(0)) {
            this.f16552p.removeMessages(0);
        }
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: i */
    public void mo6641i() {
        this.f16552p.postDelayed(new Runnable() { // from class: com.fimi.x1bh.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                C3888b.this.f16554r.m8621j();
            }
        }, 1000L);
    }
}
