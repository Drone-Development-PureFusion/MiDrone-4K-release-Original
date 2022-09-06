package com.fimi.soul.biz.p185n;

import android.content.Context;
import com.fimi.kernel.utils.C2277v;
/* renamed from: com.fimi.soul.biz.n.p */
/* loaded from: classes.dex */
public class C2582p {

    /* renamed from: a */
    private static String f8920a = "screenlight";

    /* renamed from: b */
    private static String f8921b = "soundmax";

    /* renamed from: c */
    private static String f8922c = "autoupdate";

    /* renamed from: d */
    private static String f8923d = "push_control";

    /* renamed from: e */
    private static String f8924e = "open_position";

    /* renamed from: f */
    private static String f8925f = "mapchangge";

    /* renamed from: g */
    private static C2582p f8926g = null;

    /* renamed from: h */
    private C2277v f8927h;

    public C2582p(Context context) {
        this.f8927h = C2277v.m12784a(context);
    }

    /* renamed from: a */
    public static C2582p m11612a(Context context) {
        if (f8926g == null) {
            f8926g = new C2582p(context);
        }
        return f8926g;
    }

    /* renamed from: a */
    public void m11611a(boolean z) {
        this.f8927h.m12787a().edit().putBoolean(f8923d, z).commit();
    }

    /* renamed from: a */
    public boolean m11613a() {
        return this.f8927h.m12787a().getBoolean(f8920a, false);
    }

    /* renamed from: b */
    public void m11609b(boolean z) {
        this.f8927h.m12787a().edit().putBoolean(f8924e, z).commit();
    }

    /* renamed from: b */
    public boolean m11610b() {
        return this.f8927h.m12787a().getBoolean(f8921b, false);
    }

    /* renamed from: c */
    public void m11607c(boolean z) {
        this.f8927h.m12787a().edit().putBoolean(f8922c, z).commit();
    }

    /* renamed from: c */
    public boolean m11608c() {
        return this.f8927h.m12787a().getBoolean(f8922c, false);
    }

    /* renamed from: d */
    public void m11605d(boolean z) {
        this.f8927h.m12787a().edit().putBoolean(f8921b, z).commit();
    }

    /* renamed from: d */
    public boolean m11606d() {
        return this.f8927h.m12787a().getBoolean(f8924e, true);
    }

    /* renamed from: e */
    public void m11603e(boolean z) {
        this.f8927h.m12787a().edit().putBoolean(f8920a, z).commit();
    }

    /* renamed from: e */
    public boolean m11604e() {
        return this.f8927h.m12787a().getBoolean(f8925f, false);
    }

    /* renamed from: f */
    public void m11601f(boolean z) {
        this.f8927h.m12787a().edit().putBoolean(f8925f, z).commit();
    }

    /* renamed from: f */
    public boolean m11602f() {
        return this.f8927h.m12787a().getBoolean(f8923d, true);
    }
}
