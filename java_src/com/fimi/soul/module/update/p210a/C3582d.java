package com.fimi.soul.module.update.p210a;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.p193d.p194a.C2770c;
/* renamed from: com.fimi.soul.module.update.a.d */
/* loaded from: classes.dex */
public class C3582d {
    /* renamed from: a */
    public static C2770c m7929a(int i) {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 204;
        c2770c.f10262b = 2;
        c2770c.f10264d.m11055b((byte) i);
        c2770c.f10264d.m11055b((byte) 2);
        return c2770c;
    }

    /* renamed from: a */
    public static void m7928a(C2657a c2657a) {
        m7927a(c2657a, 0);
        m7927a(c2657a, 9);
        m7927a(c2657a, 10);
        m7927a(c2657a, 6);
        m7927a(c2657a, 3);
        m7927a(c2657a, 1);
    }

    /* renamed from: a */
    public static void m7927a(C2657a c2657a, int i) {
        try {
            c2657a.mo11217ab().mo10897a(m7929a(i));
            Thread.sleep(200L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
