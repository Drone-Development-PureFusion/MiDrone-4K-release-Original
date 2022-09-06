package com.fimi.soul.module.setting.gimaltuneparameter;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.p193d.p194a.C2770c;
/* renamed from: com.fimi.soul.module.setting.gimaltuneparameter.a */
/* loaded from: classes.dex */
public class C3507a {

    /* renamed from: a */
    public static final byte f13874a = 0;

    /* renamed from: b */
    public static final byte f13875b = 1;

    /* renamed from: c */
    public static final byte f13876c = 2;

    /* renamed from: d */
    public static final byte f13877d = 0;

    /* renamed from: e */
    public static final byte f13878e = 1;

    /* renamed from: f */
    public static final byte f13879f = 2;

    /* renamed from: g */
    public static final byte f13880g = 3;

    /* renamed from: h */
    public static final byte f13881h = 4;

    /* renamed from: i */
    public static final byte f13882i = 5;

    /* renamed from: j */
    public static final byte f13883j = 0;

    /* renamed from: k */
    public static final byte f13884k = 1;

    /* renamed from: l */
    public static final byte f13885l = 2;

    /* renamed from: m */
    public static final byte f13886m = 3;

    /* renamed from: n */
    public static final byte f13887n = 4;

    /* renamed from: o */
    public static final byte f13888o = 5;

    /* renamed from: p */
    private static final int f13889p = 7;

    /* renamed from: q */
    private C2657a f13890q;

    public C3507a(C2657a c2657a) {
        this.f13890q = c2657a;
    }

    /* renamed from: b */
    private C2770c m8198b(byte b) {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 7;
        c2770c.f10263c = 114;
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b(b);
        c2770c.f10264d.m11055b((byte) 1);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        return c2770c;
    }

    /* renamed from: b */
    private C2770c m8197b(byte b, int i, int i2, int i3) {
        C2770c c2770c = new C2770c();
        c2770c.f10262b = 7;
        c2770c.f10263c = 114;
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b(b);
        c2770c.f10264d.m11055b((byte) 2);
        c2770c.f10264d.m11055b((byte) i);
        c2770c.f10264d.m11055b((byte) i2);
        c2770c.f10264d.m11055b((byte) i3);
        return c2770c;
    }

    /* renamed from: a */
    public void m8200a(byte b) {
        this.f13890q.mo11217ab().mo10897a(m8198b(b));
    }

    /* renamed from: a */
    public void m8199a(byte b, int i, int i2, int i3) {
        this.f13890q.mo11217ab().mo10897a(m8197b(b, i, i2, i3));
    }
}
