package org.p318d;

import org.p318d.p320b.C5731c;
import org.p318d.p320b.C5741m;
import org.p318d.p321c.C5747c;
/* renamed from: org.d.g */
/* loaded from: classes2.dex */
public class C5757g {

    /* renamed from: a */
    static AbstractC5727b f23064a;

    static {
        try {
            f23064a = m1b();
        } catch (Exception e) {
            C5741m.m123a("Unexpected failure while binding MarkerFactory", e);
        } catch (NoClassDefFoundError e2) {
            f23064a = new C5731c();
        }
    }

    private C5757g() {
    }

    /* renamed from: a */
    public static AbstractC5727b m3a() {
        return f23064a;
    }

    /* renamed from: a */
    public static AbstractC5756f m2a(String str) {
        return f23064a.mo164a(str);
    }

    /* renamed from: b */
    private static AbstractC5727b m1b() {
        try {
            return C5747c.getSingleton().mo22a();
        } catch (NoSuchMethodError e) {
            return C5747c.f23028a.mo22a();
        }
    }

    /* renamed from: b */
    public static AbstractC5756f m0b(String str) {
        return f23064a.mo161d(str);
    }
}
