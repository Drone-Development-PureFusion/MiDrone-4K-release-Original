package p004b.p005a.p006a.p007a.p026o;

import java.util.HashMap;
import java.util.Map;
import org.p318d.AbstractC5756f;
import org.p318d.C5753e;
import p004b.p005a.p006a.p007a.C0146d;
import p004b.p005a.p006a.p007a.C0148e;
import p004b.p005a.p006a.p028b.p054o.EnumC0533l;
/* renamed from: b.a.a.a.o.b */
/* loaded from: classes.dex */
public class C0249b extends AbstractC0257i {

    /* renamed from: c */
    private String f427c;

    /* renamed from: a */
    private Map<String, C0146d> f425a = new HashMap();

    /* renamed from: b */
    private C0146d f426b = C0146d.f202p;

    /* renamed from: d */
    private EnumC0533l f428d = EnumC0533l.NEUTRAL;

    /* renamed from: e */
    private EnumC0533l f429e = EnumC0533l.DENY;

    @Override // p004b.p005a.p006a.p007a.p026o.AbstractC0257i
    /* renamed from: a */
    public EnumC0533l mo21125a(AbstractC5756f abstractC5756f, C0148e c0148e, C0146d c0146d, String str, Object[] objArr, Throwable th) {
        String m19a = C5753e.m19a(this.f427c);
        if (!g_()) {
            return EnumC0533l.NEUTRAL;
        }
        C0146d c0146d2 = null;
        if (m19a != null) {
            c0146d2 = this.f425a.get(m19a);
        }
        if (c0146d2 == null) {
            c0146d2 = this.f426b;
        }
        return c0146d.m21483a(c0146d2) ? this.f428d : this.f429e;
    }

    /* renamed from: a */
    public String m21160a() {
        return this.f427c;
    }

    /* renamed from: a */
    public void m21159a(C0146d c0146d) {
        this.f426b = c0146d;
    }

    /* renamed from: a */
    public void m21158a(C0252e c0252e) {
        if (this.f425a.containsKey(c0252e.m21148a())) {
            c(c0252e.m21148a() + " has been already set");
        } else {
            this.f425a.put(c0252e.m21148a(), c0252e.m21145b());
        }
    }

    /* renamed from: a */
    public void m21157a(EnumC0533l enumC0533l) {
        this.f428d = enumC0533l;
    }

    /* renamed from: a */
    public void m21156a(String str) {
        this.f427c = str;
    }

    /* renamed from: b */
    public C0146d m21155b() {
        return this.f426b;
    }

    /* renamed from: b */
    public void m21154b(EnumC0533l enumC0533l) {
        this.f429e = enumC0533l;
    }

    /* renamed from: d */
    public EnumC0533l m21153d() {
        return this.f428d;
    }

    /* renamed from: e */
    public EnumC0533l m21152e() {
        return this.f429e;
    }

    @Override // p004b.p005a.p006a.p007a.p026o.AbstractC0257i, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        if (this.f427c == null) {
            c("No key name was specified");
        }
        super.mo20156j();
    }
}
