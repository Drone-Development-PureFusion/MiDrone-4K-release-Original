package p004b.p005a.p006a.p007a;

import org.p318d.AbstractC5744c;
import org.p318d.C5748d;
import p004b.p005a.p006a.p007a.p012d.C0147a;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.C0287e;
import p004b.p005a.p006a.p028b.p031c.AbstractC0277c;
import p004b.p005a.p006a.p028b.p055p.AbstractC0551k;
import p004b.p005a.p006a.p028b.p055p.C0542b;
@Deprecated
/* renamed from: b.a.a.a.b */
/* loaded from: classes.dex */
public class C0135b {

    /* renamed from: a */
    static final C0135b f152a = new C0135b();

    private C0135b() {
    }

    /* renamed from: a */
    public static void m21504a() {
        m21503a((C0151f) C5748d.m40c());
    }

    /* renamed from: a */
    public static void m21503a(C0151f c0151f) {
        AbstractC0551k n = c0151f.n();
        if (n != null) {
            n.mo20188a(new C0542b("Setting up default configuration.", c0151f));
        }
        C0287e c0287e = new C0287e();
        c0287e.a((AbstractC0292f) c0151f);
        c0287e.b_("console");
        C0147a c0147a = new C0147a();
        c0147a.a((AbstractC0292f) c0151f);
        c0147a.a("%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n");
        c0147a.mo20156j();
        c0287e.a((AbstractC0277c) c0147a);
        c0287e.mo20156j();
        c0151f.mo126e(AbstractC5744c.f23019c).mo20251a(c0287e);
    }
}
