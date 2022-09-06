package com.xiaomi.channel.commonutils.misc;
/* renamed from: com.xiaomi.channel.commonutils.misc.a */
/* loaded from: classes.dex */
public class C4479a {

    /* renamed from: a */
    public static final String f18537a;

    /* renamed from: b */
    public static final boolean f18538b;

    /* renamed from: c */
    public static final boolean f18539c;

    /* renamed from: d */
    public static final boolean f18540d;

    /* renamed from: e */
    public static final boolean f18541e;

    /* renamed from: f */
    public static boolean f18542f;

    /* renamed from: g */
    public static final boolean f18543g;

    /* renamed from: h */
    public static final boolean f18544h;

    /* renamed from: i */
    private static int f18545i;

    static {
        boolean z = false;
        f18537a = C4481c.f18546a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f18538b = f18537a.contains("2A2FE0D7");
        f18539c = f18538b || "DEBUG".equalsIgnoreCase(f18537a);
        f18540d = "LOGABLE".equalsIgnoreCase(f18537a);
        f18541e = f18537a.contains("YY");
        f18542f = f18537a.equalsIgnoreCase("TEST");
        f18543g = "BETA".equalsIgnoreCase(f18537a);
        if (f18537a != null && f18537a.startsWith("RC")) {
            z = true;
        }
        f18544h = z;
        f18545i = 1;
        if (f18537a.equalsIgnoreCase("SANDBOX")) {
            f18545i = 2;
        } else if (f18537a.equalsIgnoreCase("ONEBOX")) {
            f18545i = 3;
        } else {
            f18545i = 1;
        }
    }

    /* renamed from: a */
    public static void m5033a(int i) {
        f18545i = i;
    }

    /* renamed from: a */
    public static boolean m5034a() {
        return f18545i == 2;
    }

    /* renamed from: b */
    public static boolean m5032b() {
        return f18545i == 3;
    }

    /* renamed from: c */
    public static int m5031c() {
        return f18545i;
    }
}
