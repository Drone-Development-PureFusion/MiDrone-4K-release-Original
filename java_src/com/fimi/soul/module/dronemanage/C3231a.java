package com.fimi.soul.module.dronemanage;

import android.os.Handler;
import android.os.Message;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p202h.C2858f;
/* renamed from: com.fimi.soul.module.dronemanage.a */
/* loaded from: classes.dex */
public class C3231a {

    /* renamed from: f */
    private static final int f12408f = 1;

    /* renamed from: a */
    C2858f f12409a;

    /* renamed from: b */
    C2657a f12410b;

    /* renamed from: c */
    C2770c f12411c;

    /* renamed from: d */
    int f12412d;

    /* renamed from: e */
    Handler f12413e = new Handler() { // from class: com.fimi.soul.module.dronemanage.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    if (C3231a.this.f12409a == null) {
                        return;
                    }
                    C3231a.this.f12409a.m10747e();
                    C3231a.this.f12409a.m10746f();
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: a */
    public void m9039a() {
        this.f12412d = 0;
        if (this.f12409a != null) {
            this.f12409a.m10751c();
            return;
        }
        this.f12409a = new C2858f(200, new Runnable() { // from class: com.fimi.soul.module.dronemanage.a.2
            @Override // java.lang.Runnable
            public void run() {
                C3231a.this.f12412d++;
                C3231a.this.f12410b.mo11217ab().mo10897a(C3231a.this.f12411c);
                if (C3231a.this.f12412d >= 5) {
                    C3231a.this.f12413e.sendEmptyMessage(1);
                }
            }
        });
        this.f12409a.m10749d();
    }

    /* renamed from: a */
    public void m9038a(C2657a c2657a, C2770c c2770c) {
        this.f12410b = c2657a;
        this.f12411c = c2770c;
    }

    /* renamed from: b */
    public void m9037b() {
        this.f12410b.mo11217ab().mo10897a(this.f12411c);
    }

    /* renamed from: c */
    public void m9036c() {
        this.f12413e.sendEmptyMessage(1);
    }

    /* renamed from: d */
    public boolean m9035d() {
        return this.f12409a.m10753b();
    }
}
