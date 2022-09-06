package org.p290c.p309e;

import org.p290c.p299b.AbstractC5555g;
import org.p290c.p299b.C5559i;
import org.p290c.p299b.C5560j;
import org.p290c.p299b.p303d.C5539e;
import org.p290c.p309e.p311b.C5606b;
import org.p290c.p309e.p311b.C5608c;
import p069c.p071b.AbstractC0618i;
import p069c.p072c.C0628c;
/* renamed from: org.c.e.h */
/* loaded from: classes2.dex */
public class C5626h {

    /* renamed from: a */
    private final C5608c f22728a = new C5608c();

    /* renamed from: a */
    public static C5629j m509a(C5593a c5593a, Class<?>... clsArr) {
        return new C5626h().m502b(c5593a, clsArr);
    }

    /* renamed from: a */
    public static C5629j m505a(Class<?>... clsArr) {
        return m509a(m503b(), clsArr);
    }

    /* renamed from: a */
    public static void m504a(String... strArr) {
        System.exit(new C5626h().m510a(new C5559i(), strArr).m478f() ? 0 : 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static C5593a m503b() {
        return new C5593a();
    }

    /* renamed from: a */
    public String m512a() {
        return C0628c.m19801a();
    }

    /* renamed from: a */
    public C5629j m511a(AbstractC0618i abstractC0618i) {
        return m506a(new C5539e(abstractC0618i));
    }

    /* renamed from: a */
    C5629j m510a(AbstractC5555g abstractC5555g, String... strArr) {
        abstractC5555g.mo776a().println("JUnit version " + C0628c.m19801a());
        C5624g m518a = C5624g.m518a(strArr);
        m508a(new C5560j(abstractC5555g));
        return m507a(m518a.m520a(m503b()));
    }

    /* renamed from: a */
    public C5629j m507a(AbstractC5627i abstractC5627i) {
        return m506a(abstractC5627i.mo489a());
    }

    /* renamed from: a */
    public C5629j m506a(AbstractC5634l abstractC5634l) {
        C5629j c5629j = new C5629j();
        C5606b m477g = c5629j.m477g();
        this.f22728a.m557d(m477g);
        try {
            this.f22728a.m564a(abstractC5634l.mo327d());
            abstractC5634l.mo341a(this.f22728a);
            this.f22728a.m563a(c5629j);
            return c5629j;
        } finally {
            m501b(m477g);
        }
    }

    /* renamed from: a */
    public void m508a(C5606b c5606b) {
        this.f22728a.m567a(c5606b);
    }

    /* renamed from: b */
    public C5629j m502b(C5593a c5593a, Class<?>... clsArr) {
        return m507a(AbstractC5627i.m494a(c5593a, clsArr));
    }

    /* renamed from: b */
    public C5629j m500b(Class<?>... clsArr) {
        return m502b(m503b(), clsArr);
    }

    /* renamed from: b */
    public void m501b(C5606b c5606b) {
        this.f22728a.m561b(c5606b);
    }
}
