package com.fimi.soul.module.p207b;

import android.os.Handler;
import android.os.Message;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p202h.C2858f;
/* renamed from: com.fimi.soul.module.b.a */
/* loaded from: classes.dex */
public class C3050a {

    /* renamed from: a */
    static int f11374a = 0;

    /* renamed from: f */
    private static final int f11375f = 1;

    /* renamed from: g */
    private static final int f11376g = 2;

    /* renamed from: c */
    private C2858f f11378c;

    /* renamed from: d */
    private C2657a f11379d;

    /* renamed from: e */
    private volatile C2770c f11380e;

    /* renamed from: h */
    private C3053b f11381h;

    /* renamed from: i */
    private int f11382i = 300;

    /* renamed from: b */
    Handler f11377b = new Handler() { // from class: com.fimi.soul.module.b.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    if (C3050a.this.f11378c != null) {
                        C3050a.this.f11378c.m10747e();
                        C3050a.this.f11378c.m10746f();
                    }
                    if (C3050a.this.f11381h == null || C3050a.this.f11380e == null) {
                        return;
                    }
                    C3050a.this.f11381h.mo9836a(C3050a.this.f11380e.f10263c);
                    C3050a.this.f11380e = null;
                    return;
                case 2:
                    if (C3050a.this.f11378c == null) {
                        return;
                    }
                    C3050a.this.f11378c.m10747e();
                    return;
                default:
                    return;
            }
        }
    };

    public C3050a(C3053b c3053b) {
        this.f11381h = c3053b;
    }

    /* renamed from: a */
    public static C3050a m9847a(C3053b c3053b) {
        return new C3050a(c3053b);
    }

    /* renamed from: a */
    public void m9852a() {
        f11374a = 0;
        if (this.f11378c != null && !this.f11378c.m10753b()) {
            this.f11378c.m10751c();
            return;
        }
        this.f11378c = new C2858f(this.f11382i, new Runnable() { // from class: com.fimi.soul.module.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (C3050a.this.f11380e != null) {
                    C3050a.f11374a++;
                    C3050a.this.f11379d.mo11217ab().mo10897a(C3050a.this.f11380e);
                    if (C3050a.f11374a < 5) {
                        return;
                    }
                    C3050a.this.f11377b.sendEmptyMessage(1);
                }
            }
        });
        this.f11378c.m10749d();
    }

    /* renamed from: a */
    public void m9851a(int i) {
        this.f11382i = i;
    }

    /* renamed from: a */
    public void m9850a(C2657a c2657a, C2770c c2770c) {
        this.f11379d = c2657a;
        this.f11380e = c2770c;
    }

    /* renamed from: b */
    public void m9846b() {
        this.f11377b.sendEmptyMessage(2);
    }

    /* renamed from: c */
    public boolean m9844c() {
        return this.f11378c.m10753b();
    }
}
