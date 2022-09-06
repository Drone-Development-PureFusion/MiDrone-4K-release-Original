package p004b.p005a.p006a.p028b.p041h.p043b;

import java.util.ArrayList;
import java.util.Arrays;
import p004b.p005a.p006a.p028b.p054o.C0527f;
import p004b.p005a.p006a.p028b.p057r.C0589u;
import p004b.p005a.p006a.p028b.p057r.C0592x;
/* renamed from: b.a.a.b.h.b.m */
/* loaded from: classes.dex */
public class C0391m extends C0527f {

    /* renamed from: a */
    private String f809a;

    /* renamed from: b */
    private String f810b;

    /* renamed from: c */
    private String f811c;

    /* renamed from: d */
    private String f812d;

    /* renamed from: e */
    private Boolean f813e;

    /* renamed from: f */
    private Boolean f814f;

    /* renamed from: g */
    private String[] f815g;

    /* renamed from: h */
    private String[] f816h;

    /* renamed from: a */
    private String[] m20662a(String[] strArr, String str, String str2) {
        ArrayList arrayList = new ArrayList(strArr.length);
        arrayList.addAll(Arrays.asList(strArr));
        if (str != null) {
            C0592x.m20040a(arrayList, m20650h(str));
        }
        if (str2 != null) {
            C0592x.m20038b(arrayList, m20650h(str2));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: a */
    private String[] m20661a(String[] strArr, String[] strArr2) {
        if (this.f815g == null) {
            if (!C0589u.m20054e(m20666a()) || !C0589u.m20054e(m20660b())) {
                this.f815g = m20662a(strArr, m20666a(), m20660b());
            } else {
                this.f815g = (String[]) Arrays.copyOf(strArr2, strArr2.length);
            }
            String[] strArr3 = this.f815g;
            int length = strArr3.length;
            for (int i = 0; i < length; i++) {
                d("enabled protocol: " + strArr3[i]);
            }
        }
        return this.f815g;
    }

    /* renamed from: b */
    private String[] m20657b(String[] strArr, String[] strArr2) {
        if (this.f816h == null) {
            if (!C0589u.m20054e(m20656c()) || !C0589u.m20054e(m20655d())) {
                this.f816h = m20662a(strArr, m20656c(), m20655d());
            } else {
                this.f816h = (String[]) Arrays.copyOf(strArr2, strArr2.length);
            }
            String[] strArr3 = this.f816h;
            int length = strArr3.length;
            for (int i = 0; i < length; i++) {
                d("enabled cipher suite: " + strArr3[i]);
            }
        }
        return this.f816h;
    }

    /* renamed from: h */
    private String[] m20650h(String str) {
        return str.split("\\s*,\\s*");
    }

    /* renamed from: a */
    public String m20666a() {
        return this.f809a;
    }

    /* renamed from: a */
    public void m20665a(AbstractC0385g abstractC0385g) {
        abstractC0385g.mo20695a(m20661a(abstractC0385g.mo20694b(), abstractC0385g.mo20697a()));
        abstractC0385g.mo20692b(m20657b(abstractC0385g.mo20690d(), abstractC0385g.mo20691c()));
        if (m20654e() != null) {
            abstractC0385g.mo20696a(m20654e().booleanValue());
        }
        if (m20653f() != null) {
            abstractC0385g.mo20693b(m20653f().booleanValue());
        }
    }

    /* renamed from: a */
    public void m20664a(Boolean bool) {
        this.f813e = bool;
    }

    /* renamed from: a */
    public void m20663a(String str) {
        this.f809a = str;
    }

    /* renamed from: b */
    public String m20660b() {
        return this.f810b;
    }

    /* renamed from: b */
    public void m20659b(Boolean bool) {
        this.f814f = bool;
    }

    /* renamed from: b */
    public void m20658b(String str) {
        this.f810b = str;
    }

    /* renamed from: c */
    public String m20656c() {
        return this.f811c;
    }

    /* renamed from: d */
    public String m20655d() {
        return this.f812d;
    }

    /* renamed from: e */
    public Boolean m20654e() {
        return this.f813e;
    }

    /* renamed from: f */
    public Boolean m20653f() {
        return this.f814f;
    }

    /* renamed from: f */
    public void m20652f(String str) {
        this.f811c = str;
    }

    /* renamed from: g */
    public void m20651g(String str) {
        this.f812d = str;
    }
}
