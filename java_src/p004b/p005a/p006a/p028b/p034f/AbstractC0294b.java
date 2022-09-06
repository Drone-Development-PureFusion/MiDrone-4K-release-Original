package p004b.p005a.p006a.p028b.p034f;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.AbstractC0462k;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p044i.AbstractC0431b;
import p004b.p005a.p006a.p028b.p044i.C0443c;
import p004b.p005a.p006a.p028b.p044i.p046b.C0437f;
import p004b.p005a.p006a.p028b.p054o.AbstractC0517a;
import p004b.p005a.p006a.p028b.p054o.C0539r;
/* renamed from: b.a.a.b.f.b */
/* loaded from: classes.dex */
public abstract class AbstractC0294b<E> extends AbstractC0462k<E> {

    /* renamed from: h */
    protected String f525h;

    /* renamed from: i */
    protected AbstractC0431b<E> f526i;

    /* renamed from: k */
    protected AbstractC0293a f528k;

    /* renamed from: j */
    protected String f527j = "Logback Log Messages";

    /* renamed from: l */
    protected long f529l = 0;

    /* renamed from: b */
    private void m21013b(StringBuilder sb) {
        AbstractC0431b<E> abstractC0431b = this.f526i;
        sb.append("<tr class=\"header\">");
        sb.append(C0359h.f706c);
        while (abstractC0431b != null) {
            if (mo21015a((AbstractC0431b) abstractC0431b) == null) {
                abstractC0431b = abstractC0431b.m20542b();
            } else {
                sb.append("<td class=\"");
                sb.append(mo21015a((AbstractC0431b) abstractC0431b));
                sb.append("\">");
                sb.append(mo21015a((AbstractC0431b) abstractC0431b));
                sb.append("</td>");
                sb.append(C0359h.f706c);
                abstractC0431b = abstractC0431b.m20542b();
            }
        }
        sb.append("</tr>");
        sb.append(C0359h.f706c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public String mo21015a(AbstractC0431b abstractC0431b) {
        String simpleName = abstractC0431b.getClass().getSimpleName();
        int indexOf = simpleName.indexOf("Converter");
        return indexOf == -1 ? simpleName : simpleName.substring(0, indexOf);
    }

    /* renamed from: a */
    protected abstract Map<String, String> mo21017a();

    /* renamed from: a */
    public void m21016a(AbstractC0293a abstractC0293a) {
        this.f528k = abstractC0293a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m21014a(StringBuilder sb) {
        if (this.f529l >= AbstractC0517a.f1169e) {
            this.f529l = 0L;
            sb.append("</table>");
            sb.append(C0359h.f706c);
            sb.append("<p></p>");
            sb.append("<table cellspacing=\"0\">");
            sb.append(C0359h.f706c);
            m21013b(sb);
        }
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0462k, p004b.p005a.p006a.p028b.AbstractC0459j
    /* renamed from: d */
    public String mo20447d() {
        return "text/html";
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0462k, p004b.p005a.p006a.p028b.AbstractC0459j
    /* renamed from: e */
    public String mo20445e() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"");
        sb.append(" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
        sb.append(C0359h.f706c);
        sb.append("<html>");
        sb.append(C0359h.f706c);
        sb.append("  <head>");
        sb.append(C0359h.f706c);
        sb.append("    <title>");
        sb.append(this.f527j);
        sb.append("</title>");
        sb.append(C0359h.f706c);
        this.f528k.mo21018a(sb);
        sb.append(C0359h.f706c);
        sb.append("  </head>");
        sb.append(C0359h.f706c);
        sb.append("<body>");
        sb.append(C0359h.f706c);
        return sb.toString();
    }

    /* renamed from: e_ */
    public void m21012e_(String str) {
        this.f525h = str;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0462k, p004b.p005a.p006a.p028b.AbstractC0459j
    /* renamed from: f */
    public String mo20444f() {
        StringBuilder sb = new StringBuilder();
        sb.append("<hr/>");
        sb.append(C0359h.f706c);
        sb.append("<p>Log session start time ");
        sb.append(new Date());
        sb.append("</p><p></p>");
        sb.append(C0359h.f706c);
        sb.append(C0359h.f706c);
        sb.append("<table cellspacing=\"0\">");
        sb.append(C0359h.f706c);
        m21013b(sb);
        return sb.toString();
    }

    /* renamed from: f */
    public void m21011f(String str) {
        this.f527j = str;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0462k, p004b.p005a.p006a.p028b.AbstractC0459j
    /* renamed from: g */
    public String mo20443g() {
        return "</table>";
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0462k, p004b.p005a.p006a.p028b.AbstractC0459j
    /* renamed from: h */
    public String mo20442h() {
        return C0359h.f706c + "</body></html>";
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0462k, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        boolean z = false;
        try {
            C0437f c0437f = new C0437f(this.f525h);
            c0437f.a(h_());
            this.f526i = c0437f.m20523a(c0437f.m20524a(), m21008n());
            C0443c.m20498a(this.f526i);
        } catch (C0539r e) {
            a("Incorrect pattern found", e);
            z = true;
        }
        if (!z) {
            this.f1017c = true;
        }
    }

    /* renamed from: l */
    public String m21010l() {
        return this.f525h;
    }

    /* renamed from: m */
    public AbstractC0293a m21009m() {
        return this.f528k;
    }

    /* renamed from: n */
    public Map<String, String> m21008n() {
        Map map;
        HashMap hashMap = new HashMap();
        Map<String, String> mo21017a = mo21017a();
        if (mo21017a != null) {
            hashMap.putAll(mo21017a);
        }
        AbstractC0292f h_ = h_();
        if (h_ != null && (map = (Map) h_.mo20998f(C0359h.f710g)) != null) {
            hashMap.putAll(map);
        }
        return hashMap;
    }

    /* renamed from: o */
    public String m21007o() {
        return this.f527j;
    }
}
