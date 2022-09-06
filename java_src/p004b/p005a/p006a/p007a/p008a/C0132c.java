package p004b.p005a.p006a.p007a.p008a;

import org.p318d.AbstractC5744c;
import org.p318d.C5748d;
import p004b.p005a.p006a.p007a.C0151f;
import p004b.p005a.p006a.p007a.p012d.C0147a;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.p055p.AbstractC0551k;
import p004b.p005a.p006a.p028b.p055p.C0542b;
/* renamed from: b.a.a.a.a.c */
/* loaded from: classes.dex */
public class C0132c {
    private C0132c() {
    }

    /* renamed from: a */
    public static void m21527a() {
        m21526a((C0151f) C5748d.m40c());
    }

    /* renamed from: a */
    public static void m21526a(C0151f c0151f) {
        AbstractC0551k n = c0151f.n();
        if (n != null) {
            n.mo20188a(new C0542b("Setting up default configuration.", c0151f));
        }
        C0133d c0133d = new C0133d();
        c0133d.a((AbstractC0292f) c0151f);
        c0133d.b_("logcat");
        C0147a c0147a = new C0147a();
        c0147a.a((AbstractC0292f) c0151f);
        c0147a.a("%msg");
        c0147a.mo20156j();
        c0133d.m21524a(c0147a);
        c0133d.mo20156j();
        c0151f.mo126e(AbstractC5744c.f23019c).mo20251a(c0133d);
    }
}
