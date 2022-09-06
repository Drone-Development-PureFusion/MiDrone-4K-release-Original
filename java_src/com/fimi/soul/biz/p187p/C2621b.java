package com.fimi.soul.biz.p187p;

import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
/* renamed from: com.fimi.soul.biz.p.b */
/* loaded from: classes.dex */
public class C2621b {

    /* renamed from: a */
    private static C2657a f9090a;

    /* renamed from: com.fimi.soul.biz.p.b$a */
    /* loaded from: classes.dex */
    private static class C2623a {

        /* renamed from: a */
        private static final C2621b f9092a = new C2621b();

        private C2623a() {
        }
    }

    /* renamed from: a */
    public static C2621b m11466a(C2657a c2657a) {
        f9090a = c2657a;
        return C2623a.f9092a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11464b(int i) {
        if (!C2619a.m11493a().m11491a(i)) {
            m11468a(i);
            m11463c();
        }
    }

    /* renamed from: c */
    private void m11463c() {
        try {
            Thread.sleep(300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m11469a() {
        C2619a.m11493a().m11472k().clear();
        C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.biz.p.b.1
            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < 5; i++) {
                    C2621b.this.m11464b(0);
                    C2621b.this.m11464b(1);
                    C2621b.this.m11464b(3);
                    C2621b.this.m11464b(10);
                    C2621b.this.m11464b(6);
                    C2621b.this.m11464b(9);
                }
                if (C2621b.f9090a != null) {
                    C2621b.f9090a.mo11220a(C2678d.EnumC2679a.ENDQUESTNOTIFY);
                }
            }
        });
    }

    /* renamed from: a */
    public void m11468a(int i) {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 6;
        c2770c.f10263c = 194;
        C2771d c2771d = c2770c.f10264d;
        if (1 == i) {
            c2771d.m11055b((byte) 1);
        } else {
            c2771d.m11055b((byte) 0);
        }
        c2771d.m11055b((byte) i);
        c2771d.m11057a((short) 1);
        c2771d.m11055b((byte) 0);
        c2771d.m11055b((byte) 17);
        if (f9090a != null) {
            f9090a.mo11217ab().mo10897a(c2770c);
        }
    }
}
