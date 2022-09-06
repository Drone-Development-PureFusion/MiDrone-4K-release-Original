package p004b.p005a.p006a.p028b.p056q;

import java.util.List;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p054o.C0539r;
import p004b.p005a.p006a.p028b.p056q.C0555a;
import p004b.p005a.p006a.p028b.p056q.C0562d;
/* renamed from: b.a.a.b.q.c */
/* loaded from: classes.dex */
public class C0560c {

    /* renamed from: a */
    final List<C0562d> f1238a;

    /* renamed from: b */
    int f1239b = 0;

    public C0560c(List<C0562d> list) {
        this.f1238a = list;
    }

    /* renamed from: a */
    private C0555a m20136a(String str) {
        return new C0555a(C0555a.EnumC0557a.LITERAL, str);
    }

    /* renamed from: b */
    private boolean m20134b(C0562d c0562d) {
        return c0562d != null && c0562d.f1245e == C0562d.EnumC0563a.DEFAULT;
    }

    /* renamed from: d */
    private C0555a m20132d() {
        C0555a m20130f = m20130f();
        if (m20130f == null) {
            return null;
        }
        C0555a m20131e = m20131e();
        if (m20131e == null) {
            return m20130f;
        }
        m20130f.m20153a(m20131e);
        return m20130f;
    }

    /* renamed from: e */
    private C0555a m20131e() {
        if (m20133c() == null) {
            return null;
        }
        return m20132d();
    }

    /* renamed from: f */
    private C0555a m20130f() {
        C0562d m20133c = m20133c();
        if (m20133c == null) {
            return null;
        }
        switch (m20133c.f1245e) {
            case LITERAL:
                m20135b();
                return m20136a(m20133c.f1246f);
            case CURLY_LEFT:
                m20135b();
                C0555a m20128h = m20128h();
                m20138a(m20133c());
                m20135b();
                C0555a m20136a = m20136a(C0359h.f703af);
                m20136a.m20153a(m20128h);
                m20136a.m20153a(m20136a(C0359h.f704ag));
                return m20136a;
            case START:
                m20135b();
                C0555a m20129g = m20129g();
                m20138a(m20133c());
                m20135b();
                return m20129g;
            default:
                return null;
        }
    }

    /* renamed from: g */
    private C0555a m20129g() {
        C0555a c0555a = new C0555a(C0555a.EnumC0557a.VARIABLE, m20132d());
        if (m20134b(m20133c())) {
            m20135b();
            c0555a.f1228c = m20132d();
        }
        return c0555a;
    }

    /* renamed from: h */
    private C0555a m20128h() {
        C0555a m20132d = m20132d();
        if (m20134b(m20133c())) {
            m20135b();
            m20132d.m20153a(m20136a(C0359h.f673C));
            m20132d.m20153a(m20132d());
        }
        return m20132d;
    }

    /* renamed from: a */
    public C0555a m20139a() {
        return m20132d();
    }

    /* renamed from: a */
    void m20138a(C0562d c0562d) {
        m20137a(c0562d, "}");
        if (c0562d.f1245e != C0562d.EnumC0563a.CURLY_RIGHT) {
            throw new C0539r("Expecting }");
        }
    }

    /* renamed from: a */
    void m20137a(C0562d c0562d, String str) {
        if (c0562d == null) {
            throw new IllegalArgumentException("All tokens consumed but was expecting \"" + str + "\"");
        }
    }

    /* renamed from: b */
    void m20135b() {
        this.f1239b++;
    }

    /* renamed from: c */
    C0562d m20133c() {
        if (this.f1239b < this.f1238a.size()) {
            return this.f1238a.get(this.f1239b);
        }
        return null;
    }
}
