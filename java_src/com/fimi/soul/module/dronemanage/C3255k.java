package com.fimi.soul.module.dronemanage;

import android.os.Handler;
import android.os.Message;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p202h.C2858f;
/* renamed from: com.fimi.soul.module.dronemanage.k */
/* loaded from: classes.dex */
public class C3255k {

    /* renamed from: a */
    static C2858f f12535a = null;

    /* renamed from: b */
    static C2657a f12536b = null;

    /* renamed from: c */
    static C2770c f12537c = null;

    /* renamed from: d */
    static int f12538d = 0;

    /* renamed from: e */
    public static final int f12539e = 0;

    /* renamed from: f */
    public static final int f12540f = 1;

    /* renamed from: g */
    static AbstractC3258a f12541g = null;

    /* renamed from: i */
    private static final int f12542i = 1;

    /* renamed from: j */
    private static final int f12543j = 2;

    /* renamed from: h */
    Handler f12544h = new Handler() { // from class: com.fimi.soul.module.dronemanage.k.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    if (C3255k.f12535a == null) {
                        return;
                    }
                    C3255k.f12535a.m10747e();
                    C3255k.f12535a.m10746f();
                    return;
                case 2:
                    if (C3255k.f12535a != null) {
                        C3255k.f12535a.m10747e();
                        C3255k.f12535a.m10746f();
                    }
                    if (C3255k.f12541g == null) {
                        return;
                    }
                    C3255k.f12541g.mo8430a(1);
                    C3255k.f12541g = null;
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: com.fimi.soul.module.dronemanage.k$a */
    /* loaded from: classes.dex */
    public interface AbstractC3258a {
        /* renamed from: a */
        void mo8430a(int i);
    }

    public C3255k() {
    }

    public C3255k(AbstractC3258a abstractC3258a) {
        f12541g = abstractC3258a;
    }

    /* renamed from: a */
    public static C3255k m8931a() {
        return new C3255k();
    }

    /* renamed from: a */
    public static C3255k m8929a(AbstractC3258a abstractC3258a) {
        return new C3255k(abstractC3258a);
    }

    /* renamed from: a */
    public void m8930a(C2657a c2657a, C2770c c2770c) {
        f12536b = c2657a;
        f12537c = c2770c;
    }

    /* renamed from: b */
    public void m8928b() {
        f12538d = 0;
        if (f12535a != null) {
            f12535a.m10751c();
            return;
        }
        f12535a = new C2858f(200, new Runnable() { // from class: com.fimi.soul.module.dronemanage.k.2
            @Override // java.lang.Runnable
            public void run() {
                C3255k.f12538d++;
                C3255k.f12536b.mo11217ab().mo10897a(C3255k.f12537c);
                if (C3255k.f12538d >= 5) {
                    C3255k.this.f12544h.sendEmptyMessage(2);
                }
            }
        });
        f12535a.m10749d();
    }

    /* renamed from: c */
    public void m8927c() {
        this.f12544h.sendEmptyMessage(1);
    }

    /* renamed from: d */
    public void m8926d() {
        f12541g = null;
    }

    /* renamed from: e */
    public boolean m8925e() {
        return f12535a.m10753b();
    }
}
