package p004b.p005a.p006a.p028b.p044i.p046b;

import com.autonavi.amap.mapcore.ERROR_CODE;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p004b.p005a.p006a.p028b.p044i.AbstractC0431b;
import p004b.p005a.p006a.p028b.p044i.C0450e;
import p004b.p005a.p006a.p028b.p044i.C0452g;
import p004b.p005a.p006a.p028b.p044i.C0457l;
import p004b.p005a.p006a.p028b.p044i.p047c.AbstractC0446c;
import p004b.p005a.p006a.p028b.p044i.p047c.C0447d;
import p004b.p005a.p006a.p028b.p054o.C0527f;
import p004b.p005a.p006a.p028b.p054o.C0539r;
/* renamed from: b.a.a.b.i.b.f */
/* loaded from: classes.dex */
public class C0437f<E> extends C0527f {

    /* renamed from: a */
    public static final String f956a = "http://logback.qos.ch/codes.html#missingRightParenthesis";

    /* renamed from: b */
    public static final Map<String, String> f957b = new HashMap();

    /* renamed from: c */
    public static final String f958c = "replace";

    /* renamed from: d */
    final List f959d;

    /* renamed from: e */
    int f960e;

    static {
        f957b.put(C0439h.f976o.m20509b().toString(), C0452g.class.getName());
        f957b.put(f958c, C0457l.class.getName());
    }

    C0437f(C0440i c0440i) {
        this.f960e = 0;
        this.f959d = c0440i.m20508a();
    }

    public C0437f(String str) {
        this(str, new C0447d());
    }

    public C0437f(String str, AbstractC0446c abstractC0446c) {
        this.f960e = 0;
        try {
            this.f959d = new C0440i(str, abstractC0446c).m20508a();
        } catch (IllegalArgumentException e) {
            throw new C0539r("Failed to initialize Parser", e);
        }
    }

    /* renamed from: a */
    C0434c m20521a(String str) {
        C0433b c0433b = new C0433b(str);
        c0433b.m20535a(m20520b());
        C0439h m20515g = m20515g();
        if (m20515g == null || m20515g.m20510a() != 41) {
            String str2 = "Expecting RIGHT_PARENTHESIS token but got " + m20515g;
            c(str2);
            c("See also http://logback.qos.ch/codes.html#missingRightParenthesis");
            throw new C0539r(str2);
        }
        C0439h m20514h = m20514h();
        if (m20514h != null && m20514h.m20510a() == 1006) {
            c0433b.a((List) m20514h.m20509b());
            m20513j();
        }
        return c0433b;
    }

    /* renamed from: a */
    public C0435d m20524a() {
        return m20520b();
    }

    /* renamed from: a */
    public AbstractC0431b<E> m20523a(C0435d c0435d, Map map) {
        C0432a c0432a = new C0432a(c0435d, map);
        c0432a.a(this.f1190s);
        return c0432a.m20540a();
    }

    /* renamed from: a */
    void m20522a(C0439h c0439h, String str) {
        if (c0439h == null) {
            throw new IllegalStateException("All tokens consumed but was expecting " + str);
        }
    }

    /* renamed from: b */
    C0435d m20520b() {
        C0435d m20518d = m20518d();
        if (m20518d == null) {
            return null;
        }
        C0435d m20519c = m20519c();
        if (m20519c == null) {
            return m20518d;
        }
        m20518d.m20532b(m20519c);
        return m20518d;
    }

    /* renamed from: c */
    C0435d m20519c() {
        if (m20514h() == null) {
            return null;
        }
        return m20520b();
    }

    /* renamed from: d */
    C0435d m20518d() {
        C0439h m20514h = m20514h();
        m20522a(m20514h, "a LITERAL or '%'");
        switch (m20514h.m20510a()) {
            case 37:
                m20513j();
                C0439h m20514h2 = m20514h();
                m20522a(m20514h2, "a FORMAT_MODIFIER, SIMPLE_KEYWORD or COMPOUND_KEYWORD");
                if (m20514h2.m20510a() != 1002) {
                    return m20517e();
                }
                C0450e m20488a = C0450e.m20488a((String) m20514h2.m20509b());
                m20513j();
                C0434c m20517e = m20517e();
                m20517e.m20534a(m20488a);
                return m20517e;
            case 1000:
                m20513j();
                return new C0435d(0, m20514h.m20509b());
            default:
                return null;
        }
    }

    /* renamed from: e */
    C0434c m20517e() {
        C0439h m20514h = m20514h();
        m20522a(m20514h, "a LEFT_PARENTHESIS or KEYWORD");
        switch (m20514h.m20510a()) {
            case ERROR_CODE.CANCEL_ERROR /* 1004 */:
                return m20516f();
            case 1005:
                m20513j();
                return m20521a(m20514h.m20509b().toString());
            default:
                throw new IllegalStateException("Unexpected token " + m20514h);
        }
    }

    /* renamed from: f */
    C0434c m20516f() {
        C0438g c0438g = new C0438g(m20515g().m20509b());
        C0439h m20514h = m20514h();
        if (m20514h != null && m20514h.m20510a() == 1006) {
            c0438g.m20512a((List) m20514h.m20509b());
            m20513j();
        }
        return c0438g;
    }

    /* renamed from: g */
    C0439h m20515g() {
        if (this.f960e < this.f959d.size()) {
            List list = this.f959d;
            int i = this.f960e;
            this.f960e = i + 1;
            return (C0439h) list.get(i);
        }
        return null;
    }

    /* renamed from: h */
    C0439h m20514h() {
        if (this.f960e < this.f959d.size()) {
            return (C0439h) this.f959d.get(this.f960e);
        }
        return null;
    }

    /* renamed from: j */
    void m20513j() {
        this.f960e++;
    }
}
