package p004b.p005a.p006a.p007a.p019j;

import java.io.IOException;
import java.io.OutputStream;
import p004b.p005a.p006a.p007a.C0156g;
import p004b.p005a.p006a.p007a.p021k.C0218y;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p007a.p025n.AbstractC0232e;
import p004b.p005a.p006a.p007a.p025n.C0243p;
import p004b.p005a.p006a.p007a.p027p.C0262e;
import p004b.p005a.p006a.p028b.AbstractC0459j;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p041h.AbstractC0408i;
/* renamed from: b.a.a.a.j.k */
/* loaded from: classes.dex */
public class C0189k extends AbstractC0408i<AbstractC0231d> {

    /* renamed from: a */
    public static final String f314a = "[%thread] %logger %msg";

    /* renamed from: b */
    public static final String f315b = "\t";

    /* renamed from: c */
    C0156g f316c = new C0156g();

    /* renamed from: d */
    String f317d = f315b;

    /* renamed from: e */
    boolean f318e = false;

    /* renamed from: a */
    private void m21323a(OutputStream outputStream, AbstractC0232e abstractC0232e, String str, boolean z) {
        StringBuilder append = new StringBuilder().append(str);
        if (!z) {
            append.append(C0359h.f718o);
        }
        append.append(abstractC0232e.mo21170b()).append(": ").append(abstractC0232e.mo21172a());
        outputStream.write(append.toString().getBytes());
        outputStream.flush();
    }

    /* renamed from: r */
    private void m21317r() {
        this.f316c.m().put("syslogStart", C0218y.class.getName());
        this.f316c.f(m21324a() + this.f317d);
        this.f316c.a(h_());
        this.f316c.j();
    }

    /* renamed from: a */
    String m21324a() {
        return "%syslogStart{" + l() + "}%nopex{}";
    }

    @Override // p004b.p005a.p006a.p028b.p041h.AbstractC0408i
    /* renamed from: a */
    protected void mo20573a(Object obj, OutputStream outputStream) {
        AbstractC0231d abstractC0231d;
        AbstractC0232e mo21214h;
        if (!this.f318e && (mo21214h = (abstractC0231d = (AbstractC0231d) obj).mo21214h()) != null) {
            String mo20455a = this.f316c.mo20455a(abstractC0231d);
            boolean z = true;
            while (mo21214h != null) {
                C0243p[] mo21169c = mo21214h.mo21169c();
                try {
                    m21323a(outputStream, mo21214h, mo20455a, z);
                    for (C0243p c0243p : mo21169c) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(mo20455a).append(c0243p);
                        outputStream.write(sb.toString().getBytes());
                        outputStream.flush();
                    }
                    mo21214h = mo21214h.mo21167e();
                    z = false;
                } catch (IOException e) {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public void m21322a(String str) {
        this.f317d = str;
    }

    /* renamed from: a */
    public void m21320a(boolean z) {
        this.f318e = z;
    }

    /* renamed from: a */
    boolean m21321a(StringBuilder sb, boolean z) {
        return false;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.AbstractC0408i
    /* renamed from: b */
    public int mo20570b(Object obj) {
        return C0262e.m21111a((AbstractC0231d) obj);
    }

    @Override // p004b.p005a.p006a.p028b.p041h.AbstractC0408i
    /* renamed from: b */
    public AbstractC0459j<AbstractC0231d> mo20572b() {
        C0156g c0156g = new C0156g();
        c0156g.m().put("syslogStart", C0218y.class.getName());
        if (this.f872n == null) {
            this.f872n = f314a;
        }
        c0156g.f(m21324a() + this.f872n);
        c0156g.a(h_());
        c0156g.j();
        return c0156g;
    }

    /* renamed from: d */
    public boolean m21319d() {
        return this.f318e;
    }

    /* renamed from: e */
    public String m21318e() {
        return this.f317d;
    }

    @Override // p004b.p005a.p006a.p028b.p041h.AbstractC0408i, p004b.p005a.p006a.p028b.AbstractC0269b, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        super.mo20156j();
        m21317r();
    }
}
