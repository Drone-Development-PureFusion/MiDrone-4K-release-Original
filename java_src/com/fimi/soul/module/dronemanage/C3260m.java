package com.fimi.soul.module.dronemanage;

import android.os.Handler;
import android.os.Message;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p202h.C2858f;
/* renamed from: com.fimi.soul.module.dronemanage.m */
/* loaded from: classes.dex */
public class C3260m {

    /* renamed from: a */
    static C2858f f12556a = null;

    /* renamed from: b */
    static C2657a f12557b = null;

    /* renamed from: c */
    static C2770c f12558c = null;

    /* renamed from: d */
    static int f12559d = 0;

    /* renamed from: e */
    static Handler f12560e = new Handler() { // from class: com.fimi.soul.module.dronemanage.m.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    if (C3260m.f12556a == null) {
                        return;
                    }
                    C3260m.f12556a.m10747e();
                    C3260m.f12556a.m10746f();
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: f */
    private static final int f12561f = 1;

    /* renamed from: a */
    public static void m8922a() {
        f12559d = 0;
        if (f12556a != null) {
            f12556a.m10751c();
            return;
        }
        f12556a = new C2858f(200, new Runnable() { // from class: com.fimi.soul.module.dronemanage.m.2
            @Override // java.lang.Runnable
            public void run() {
                C3260m.f12559d++;
                C3260m.f12557b.mo11217ab().mo10897a(C3260m.f12558c);
                if (C3260m.f12559d >= 5) {
                    C3260m.f12560e.sendEmptyMessage(1);
                }
            }
        });
        f12556a.m10749d();
    }

    /* renamed from: a */
    public static void m8921a(C2657a c2657a, C2770c c2770c) {
        f12557b = c2657a;
        f12558c = c2770c;
    }

    /* renamed from: b */
    public static void m8920b() {
        f12560e.sendEmptyMessage(1);
    }

    /* renamed from: c */
    public boolean m8919c() {
        return f12556a.m10753b();
    }
}
