package p004b.p005a.p006a.p028b.p051m.p052a;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.p044i.AbstractC0431b;
import p004b.p005a.p006a.p028b.p044i.C0443c;
import p004b.p005a.p006a.p028b.p044i.C0453h;
import p004b.p005a.p006a.p028b.p044i.p046b.C0437f;
import p004b.p005a.p006a.p028b.p044i.p047c.C0444a;
import p004b.p005a.p006a.p028b.p054o.C0527f;
import p004b.p005a.p006a.p028b.p054o.C0539r;
/* renamed from: b.a.a.b.m.a.i */
/* loaded from: classes.dex */
public class C0483i extends C0527f {

    /* renamed from: a */
    static final Map<String, String> f1069a = new HashMap();

    /* renamed from: b */
    String f1070b;

    /* renamed from: c */
    AbstractC0431b<Object> f1071c;

    static {
        f1069a.put(C0485k.f1074a, C0485k.class.getName());
        f1069a.put(C0477f.f1054a, C0477f.class.getName());
    }

    public C0483i(String str, AbstractC0292f abstractC0292f) {
        m20382b(C0479h.m20393b(str));
        a(abstractC0292f);
        m20389a();
        C0443c.m20498a(this.f1071c);
    }

    /* renamed from: a */
    public String m20388a(int i) {
        return m20387a(Integer.valueOf(i));
    }

    /* renamed from: a */
    public String m20387a(Object obj) {
        StringBuilder sb = new StringBuilder();
        for (AbstractC0431b<Object> abstractC0431b = this.f1071c; abstractC0431b != null; abstractC0431b = abstractC0431b.m20542b()) {
            sb.append(abstractC0431b.mo20376a(obj));
        }
        return sb.toString();
    }

    /* renamed from: a */
    String m20386a(String str) {
        return this.f1070b.replace(")", "\\)");
    }

    /* renamed from: a */
    public String m20385a(Date date) {
        StringBuilder sb = new StringBuilder();
        for (AbstractC0431b<Object> abstractC0431b = this.f1071c; abstractC0431b != null; abstractC0431b = abstractC0431b.m20542b()) {
            if (abstractC0431b instanceof C0453h) {
                sb.append(abstractC0431b.mo20376a(null));
            } else if (abstractC0431b instanceof C0485k) {
                sb.append("(\\d{1,3})");
            } else if (abstractC0431b instanceof C0477f) {
                sb.append(abstractC0431b.mo20376a(date));
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public String m20384a(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (AbstractC0431b<Object> abstractC0431b = this.f1071c; abstractC0431b != null; abstractC0431b = abstractC0431b.m20542b()) {
            if (abstractC0431b instanceof AbstractC0486l) {
                AbstractC0486l abstractC0486l = (AbstractC0486l) abstractC0431b;
                for (Object obj : objArr) {
                    if (abstractC0486l.mo20375b(obj)) {
                        sb.append(abstractC0431b.mo20376a(obj));
                    }
                }
            } else {
                sb.append(abstractC0431b.mo20376a(objArr));
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    void m20389a() {
        try {
            C0437f c0437f = new C0437f(m20386a(this.f1070b), new C0444a());
            c0437f.a(this.f1190s);
            this.f1071c = c0437f.m20523a(c0437f.m20524a(), f1069a);
        } catch (C0539r e) {
            a("Failed to parse pattern \"" + this.f1070b + "\".", e);
        }
    }

    /* renamed from: b */
    public C0477f m20383b() {
        for (AbstractC0431b<Object> abstractC0431b = this.f1071c; abstractC0431b != null; abstractC0431b = abstractC0431b.m20542b()) {
            if (abstractC0431b instanceof C0477f) {
                C0477f c0477f = (C0477f) abstractC0431b;
                if (c0477f.m20407h()) {
                    return c0477f;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public void m20382b(String str) {
        if (str != null) {
            this.f1070b = str.trim();
        }
    }

    /* renamed from: c */
    public C0485k m20381c() {
        for (AbstractC0431b<Object> abstractC0431b = this.f1071c; abstractC0431b != null; abstractC0431b = abstractC0431b.m20542b()) {
            if (abstractC0431b instanceof C0485k) {
                return (C0485k) abstractC0431b;
            }
        }
        return null;
    }

    /* renamed from: d */
    public String m20380d() {
        return this.f1070b;
    }

    /* renamed from: e */
    public String m20379e() {
        StringBuilder sb = new StringBuilder();
        for (AbstractC0431b<Object> abstractC0431b = this.f1071c; abstractC0431b != null; abstractC0431b = abstractC0431b.m20542b()) {
            if (abstractC0431b instanceof C0453h) {
                sb.append(abstractC0431b.mo20376a(null));
            } else if (abstractC0431b instanceof C0485k) {
                sb.append("\\d{1,2}");
            } else if (abstractC0431b instanceof C0477f) {
                sb.append(((C0477f) abstractC0431b).m20408g());
            }
        }
        return sb.toString();
    }

    public String toString() {
        return this.f1070b;
    }
}
