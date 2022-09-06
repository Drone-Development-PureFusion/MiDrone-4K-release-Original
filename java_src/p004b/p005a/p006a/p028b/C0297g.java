package p004b.p005a.p006a.p028b;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import p004b.p005a.p006a.p028b.p054o.AbstractC0534m;
import p004b.p005a.p006a.p028b.p054o.C0535n;
import p004b.p005a.p006a.p028b.p055p.AbstractC0551k;
import p004b.p005a.p006a.p028b.p057r.C0579m;
/* renamed from: b.a.a.b.g */
/* loaded from: classes.dex */
public class C0297g implements AbstractC0292f, AbstractC0534m {

    /* renamed from: b */
    private String f531b;

    /* renamed from: g */
    private volatile ExecutorService f536g;

    /* renamed from: h */
    private C0464l f537h;

    /* renamed from: i */
    private boolean f538i;

    /* renamed from: a */
    private long f530a = System.currentTimeMillis();

    /* renamed from: f */
    private AbstractC0551k f535f = new C0283d();

    /* renamed from: c */
    Map<String, String> f532c = new HashMap();

    /* renamed from: d */
    Map<String, Object> f533d = new HashMap();

    /* renamed from: e */
    C0535n f534e = new C0535n();

    /* renamed from: a */
    private synchronized void m21005a() {
        if (this.f536g != null) {
            C0579m.m20093a(this.f536g);
            this.f536g = null;
        }
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0292f, p004b.p005a.p006a.p028b.p054o.AbstractC0537p
    /* renamed from: a */
    public String mo20211a(String str) {
        return C0359h.f686P.equals(str) ? mo20996p() : this.f532c.get(str);
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0292f
    /* renamed from: a */
    public void mo21004a(AbstractC0534m abstractC0534m) {
        m20992t().m20435a(abstractC0534m);
    }

    /* renamed from: a */
    public void m21003a(AbstractC0551k abstractC0551k) {
        if (abstractC0551k == null) {
            throw new IllegalArgumentException("null StatusManager not allowed");
        }
        this.f535f = abstractC0551k;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0292f
    /* renamed from: a */
    public void mo21002a(String str, Object obj) {
        this.f533d.put(str, obj);
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0292f
    /* renamed from: a */
    public void mo21001a(String str, String str2) {
        this.f532c.put(str, str2);
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0292f
    /* renamed from: b */
    public void mo21000b(String str) {
        if (str == null || !str.equals(this.f531b)) {
            if (this.f531b != null && !"default".equals(this.f531b)) {
                throw new IllegalStateException("Context has been already given a name");
            }
            this.f531b = str;
        }
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0292f
    /* renamed from: f */
    public Object mo20998f(String str) {
        return this.f533d.get(str);
    }

    /* renamed from: f */
    public void mo20999f() {
        m20992t().m20436a();
        this.f532c.clear();
        this.f533d.clear();
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: g_ */
    public boolean mo20158g_() {
        return this.f538i;
    }

    /* renamed from: j */
    public void mo20156j() {
        this.f538i = true;
    }

    /* renamed from: k */
    public void mo20155k() {
        m21005a();
        this.f538i = false;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0292f
    /* renamed from: n */
    public AbstractC0551k mo20997n() {
        return this.f535f;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0292f, p004b.p005a.p006a.p028b.p054o.AbstractC0537p
    /* renamed from: o */
    public Map<String, String> mo20210o() {
        return new HashMap(this.f532c);
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0292f
    /* renamed from: p */
    public String mo20996p() {
        return this.f531b;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0292f
    /* renamed from: q */
    public long mo20995q() {
        return this.f530a;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0292f
    /* renamed from: r */
    public Object mo20994r() {
        return this.f534e;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0292f
    /* renamed from: s */
    public ExecutorService mo20993s() {
        if (this.f536g == null) {
            synchronized (this) {
                if (this.f536g == null) {
                    this.f536g = C0579m.m20094a();
                }
            }
        }
        return this.f536g;
    }

    /* renamed from: t */
    synchronized C0464l m20992t() {
        if (this.f537h == null) {
            this.f537h = new C0464l();
        }
        return this.f537h;
    }

    public String toString() {
        return this.f531b;
    }
}
