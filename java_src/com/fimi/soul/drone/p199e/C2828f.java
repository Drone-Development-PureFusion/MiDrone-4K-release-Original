package com.fimi.soul.drone.p199e;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.p195a.C2723bl;
import com.fimi.soul.module.p207b.C3057d;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.module.update.p210a.C3583e;
import com.fimi.soul.utils.C3658ar;
import java.util.Map;
/* renamed from: com.fimi.soul.drone.e.f */
/* loaded from: classes.dex */
public class C2828f {

    /* renamed from: a */
    public static final C2723bl f10442a = new C2723bl();

    /* renamed from: b */
    public static C2770c f10443b = f10442a.mo11073b();

    static {
        f10442a.f10260b = 193;
    }

    /* renamed from: a */
    public static void m10864a() {
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m10863a(Context context) {
        PackageInfo m7564r = C3658ar.m7564r(context);
        if (m7564r != null) {
            int i = m7564r.versionCode;
            String str = m7564r.versionName;
            f10442a.f9920e = (byte) i;
            try {
                String substring = str.substring(str.lastIndexOf(".") + 1, str.length());
                f10442a.f9921f = (byte) Integer.parseInt(substring);
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public static void m10862a(C2657a c2657a) {
        f10442a.f9919d = (byte) 0;
        c2657a.mo11217ab().mo10897a(f10442a.mo11073b());
    }

    /* renamed from: b */
    public static void m10861b(C2657a c2657a) {
        f10442a.f9919d = (byte) 1;
        c2657a.mo11217ab().mo10897a(f10442a.mo11073b());
    }

    /* renamed from: c */
    public static void m10860c(C2657a c2657a) {
        f10442a.f9919d = (byte) 3;
        c2657a.mo11217ab().mo10897a(f10442a.mo11073b());
    }

    /* renamed from: d */
    public static void m10859d(C2657a c2657a) {
        f10442a.f9919d = (byte) 10;
        c2657a.mo11217ab().mo10897a(f10442a.mo11073b());
    }

    /* renamed from: e */
    public static void m10858e(C2657a c2657a) {
        f10442a.f9919d = (byte) -3;
        c2657a.mo11217ab().mo10897a(f10442a.mo11073b());
    }

    /* renamed from: f */
    public static void m10857f(C2657a c2657a) {
        f10442a.f9919d = (byte) 5;
        c2657a.mo11217ab().mo10897a(f10442a.mo11073b());
    }

    /* renamed from: g */
    public static void m10856g(C2657a c2657a) {
        f10442a.f9919d = (byte) 9;
        c2657a.mo11217ab().mo10897a(f10442a.mo11073b());
    }

    /* renamed from: h */
    public static void m10855h(C2657a c2657a) {
        f10442a.f9919d = (byte) 6;
        c2657a.mo11217ab().mo10897a(f10442a.mo11073b());
    }

    /* renamed from: i */
    public static void m10854i(C2657a c2657a) {
        f10442a.f9919d = (byte) 5;
        c2657a.mo11217ab().mo10897a(f10442a.mo11073b());
    }

    /* renamed from: j */
    public static void m10853j(C2657a c2657a) {
        f10442a.f9919d = (byte) 8;
        c2657a.mo11217ab().mo10897a(f10442a.mo11073b());
    }

    /* renamed from: k */
    public static void m10852k(C2657a c2657a) {
        m10860c(c2657a);
        m10864a();
        m10861b(c2657a);
        m10864a();
        m10862a(c2657a);
        m10864a();
        m10856g(c2657a);
        m10864a();
        m10859d(c2657a);
        m10864a();
        m10855h(c2657a);
        m10864a();
    }

    /* renamed from: l */
    public static void m10851l(C2657a c2657a) {
        m10863a(c2657a.f9270d);
        Map<Integer, C3583e> m7966b = C3579a.m7971a().m7966b();
        if (!m7966b.containsKey(3)) {
            C3057d.m9823a(c2657a).m9819b(3);
            m10860c(c2657a);
            m10864a();
        }
        if (!m7966b.containsKey(1)) {
            C3057d.m9823a(c2657a).m9819b(1);
            m10861b(c2657a);
            m10864a();
        }
        if (!m7966b.containsKey(0)) {
            C3057d.m9823a(c2657a).m9819b(0);
            m10862a(c2657a);
            m10864a();
        }
        if (!m7966b.containsKey(9)) {
            C3057d.m9823a(c2657a).m9819b(9);
            m10856g(c2657a);
            m10864a();
        }
        if (!m7966b.containsKey(10)) {
            C3057d.m9823a(c2657a).m9819b(10);
            m10859d(c2657a);
            m10864a();
        }
        if (!m7966b.containsKey(6)) {
            C3057d.m9823a(c2657a).m9819b(6);
            m10855h(c2657a);
            m10864a();
        }
        if (!m7966b.containsKey(253)) {
            C3057d.m9823a(c2657a).m9819b(253);
            m10858e(c2657a);
            m10864a();
        }
        if (!m7966b.containsKey(5)) {
            C3057d.m9823a(c2657a).m9819b(5);
            m10854i(c2657a);
            m10864a();
        }
        if (!m7966b.containsKey(27)) {
            m10853j(c2657a);
            m10864a();
        }
    }
}
