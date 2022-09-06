package p004b.p005a.p006a.p007a.p018i;

import com.github.moduth.blockcanary.p215b.C3947a;
import java.util.Map;
import java.util.Set;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p007a.p025n.AbstractC0232e;
import p004b.p005a.p006a.p007a.p025n.C0243p;
import p004b.p005a.p006a.p028b.AbstractC0462k;
import p004b.p005a.p006a.p028b.p033e.C0291d;
/* renamed from: b.a.a.a.i.a */
/* loaded from: classes.dex */
public class C0170a extends AbstractC0462k<AbstractC0231d> {

    /* renamed from: a */
    private static final int f259a = 256;

    /* renamed from: b */
    private static final int f260b = 2048;

    /* renamed from: h */
    private StringBuilder f261h = new StringBuilder(256);

    /* renamed from: i */
    private boolean f262i = false;

    /* renamed from: j */
    private boolean f263j = false;

    @Override // p004b.p005a.p006a.p028b.AbstractC0459j
    /* renamed from: a */
    public String mo20455a(AbstractC0231d abstractC0231d) {
        Map<String, String> mo21210l;
        StackTraceElement[] mo21213i;
        if (this.f261h.capacity() > 2048) {
            this.f261h = new StringBuilder(256);
        } else {
            this.f261h.setLength(0);
        }
        this.f261h.append("<log4j:event logger=\"");
        this.f261h.append(abstractC0231d.mo21216f());
        this.f261h.append("\"\r\n");
        this.f261h.append("             timestamp=\"");
        this.f261h.append(abstractC0231d.mo21208n());
        this.f261h.append("\" level=\"");
        this.f261h.append(abstractC0231d.mo21220b());
        this.f261h.append("\" thread=\"");
        this.f261h.append(abstractC0231d.mo21222a());
        this.f261h.append("\">\r\n");
        this.f261h.append("  <log4j:message><![CDATA[");
        C0291d.m21019a(this.f261h, abstractC0231d.mo21217e());
        this.f261h.append("]]></log4j:message>\r\n");
        AbstractC0232e mo21214h = abstractC0231d.mo21214h();
        if (mo21214h != null) {
            C0243p[] mo21169c = mo21214h.mo21169c();
            this.f261h.append("  <log4j:throwable><![CDATA[");
            for (C0243p c0243p : mo21169c) {
                this.f261h.append('\t');
                this.f261h.append(c0243p.toString());
                this.f261h.append(C3947a.f16890a);
            }
            this.f261h.append("]]></log4j:throwable>\r\n");
        }
        if (this.f262i && (mo21213i = abstractC0231d.mo21213i()) != null && mo21213i.length > 0) {
            StackTraceElement stackTraceElement = mo21213i[0];
            this.f261h.append("  <log4j:locationInfo class=\"");
            this.f261h.append(stackTraceElement.getClassName());
            this.f261h.append("\"\r\n");
            this.f261h.append("                      method=\"");
            this.f261h.append(C0291d.m21021a(stackTraceElement.getMethodName()));
            this.f261h.append("\" file=\"");
            this.f261h.append(stackTraceElement.getFileName());
            this.f261h.append("\" line=\"");
            this.f261h.append(stackTraceElement.getLineNumber());
            this.f261h.append("\"/>\r\n");
        }
        if (m21385b() && (mo21210l = abstractC0231d.mo21210l()) != null && mo21210l.size() != 0) {
            Set<Map.Entry<String, String>> entrySet = mo21210l.entrySet();
            this.f261h.append("  <log4j:properties>");
            for (Map.Entry<String, String> entry : entrySet) {
                this.f261h.append("\r\n    <log4j:data");
                this.f261h.append(" name='" + C0291d.m21021a(entry.getKey()) + "'");
                this.f261h.append(" value='" + C0291d.m21021a(entry.getValue()) + "'");
                this.f261h.append(" />");
            }
            this.f261h.append("\r\n  </log4j:properties>");
        }
        this.f261h.append("\r\n</log4j:event>\r\n\r\n");
        return this.f261h.toString();
    }

    /* renamed from: a */
    public void m21386a(boolean z) {
        this.f262i = z;
    }

    /* renamed from: a */
    public boolean m21388a() {
        return this.f262i;
    }

    /* renamed from: b */
    public void m21384b(boolean z) {
        this.f263j = z;
    }

    /* renamed from: b */
    public boolean m21385b() {
        return this.f263j;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0462k, p004b.p005a.p006a.p028b.AbstractC0459j
    /* renamed from: d */
    public String mo20447d() {
        return "text/xml";
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0462k, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        super.mo20156j();
    }
}
