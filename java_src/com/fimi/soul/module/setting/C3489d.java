package com.fimi.soul.module.setting;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.p193d.p194a.C2770c;
/* renamed from: com.fimi.soul.module.setting.d */
/* loaded from: classes.dex */
public class C3489d {

    /* renamed from: a */
    public static final int f13748a = 7;

    /* renamed from: b */
    public static final int f13749b = 120;

    /* renamed from: c */
    public static final int f13750c = 30;

    /* renamed from: d */
    public static int f13751d = 16;

    /* renamed from: e */
    public static int f13752e = 17;

    /* renamed from: f */
    public static int f13753f = 0;

    /* renamed from: g */
    public static int f13754g = 1880;

    /* renamed from: h */
    private static C2657a f13755h;

    /* renamed from: i */
    private static C3489d f13756i;

    /* renamed from: a */
    public static C3489d m8302a(C2657a c2657a) {
        f13755h = c2657a;
        if (f13756i == null) {
            f13756i = new C3489d();
        }
        return f13756i;
    }

    /* renamed from: b */
    private C2770c m8301b() {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 7;
        c2770c.f10263c = 134;
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) f13752e);
        c2770c.f10264d.m11060a(0.0f);
        c2770c.f10264d.m11055b((byte) 0);
        return c2770c;
    }

    /* renamed from: b */
    private C2770c m8300b(float f) {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 6;
        c2770c.f10263c = 134;
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) f13751d);
        c2770c.f10264d.m11060a(f);
        return c2770c;
    }

    /* renamed from: a */
    public void m8304a() {
        f13755h.mo11217ab().mo10897a(m8301b());
    }

    /* renamed from: a */
    public void m8303a(float f) {
        f13755h.mo11217ab().mo10897a(m8300b(f));
    }
}
