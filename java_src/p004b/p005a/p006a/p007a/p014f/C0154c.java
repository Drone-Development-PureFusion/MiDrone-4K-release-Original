package p004b.p005a.p006a.p007a.p014f;

import java.util.Map;
import p004b.p005a.p006a.p007a.C0156g;
import p004b.p005a.p006a.p007a.p021k.C0209p;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p034f.AbstractC0294b;
import p004b.p005a.p006a.p028b.p034f.AbstractC0295c;
import p004b.p005a.p006a.p028b.p044i.AbstractC0431b;
/* renamed from: b.a.a.a.f.c */
/* loaded from: classes.dex */
public class C0154c extends AbstractC0294b<AbstractC0231d> {

    /* renamed from: a */
    static final String f235a = "%date%thread%level%logger%mdc%msg";

    /* renamed from: b */
    AbstractC0295c<AbstractC0231d> f236b = new C0153b();

    public C0154c() {
        this.f525h = f235a;
        this.f528k = new C0152a();
    }

    /* renamed from: a */
    private void m21412a(StringBuilder sb, AbstractC0431b<AbstractC0231d> abstractC0431b, AbstractC0231d abstractC0231d) {
        sb.append("<td class=\"");
        sb.append(mo21015a((AbstractC0431b) abstractC0431b));
        sb.append("\">");
        abstractC0431b.mo20480a(sb, abstractC0231d);
        sb.append("</td>");
        sb.append(C0359h.f706c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p004b.p005a.p006a.p028b.AbstractC0459j
    /* renamed from: a */
    public String mo20455a(AbstractC0231d abstractC0231d) {
        StringBuilder sb = new StringBuilder();
        a(sb);
        boolean z = true;
        long j = this.f529l;
        this.f529l = j + 1;
        if ((j & 1) == 0) {
            z = false;
        }
        String lowerCase = abstractC0231d.mo21220b().toString().toLowerCase();
        sb.append(C0359h.f706c);
        sb.append("<tr class=\"");
        sb.append(lowerCase);
        if (z) {
            sb.append(" odd\">");
        } else {
            sb.append(" even\">");
        }
        sb.append(C0359h.f706c);
        for (AbstractC0431b abstractC0431b = this.f526i; abstractC0431b != null; abstractC0431b = abstractC0431b.m20542b()) {
            m21412a(sb, abstractC0431b, abstractC0231d);
        }
        sb.append("</tr>");
        sb.append(C0359h.f706c);
        if (abstractC0231d.mo21214h() != null) {
            this.f236b.mo21006a(sb, abstractC0231d);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p028b.p034f.AbstractC0294b
    /* renamed from: a */
    public String mo21015a(AbstractC0431b abstractC0431b) {
        if (abstractC0431b instanceof C0209p) {
            String d = ((C0209p) abstractC0431b).d();
            return d != null ? d : "MDC";
        }
        return super.mo21015a(abstractC0431b);
    }

    @Override // p004b.p005a.p006a.p028b.p034f.AbstractC0294b
    /* renamed from: a */
    protected Map<String, String> mo21017a() {
        return C0156g.f238a;
    }

    /* renamed from: a */
    public void m21413a(AbstractC0295c<AbstractC0231d> abstractC0295c) {
        this.f236b = abstractC0295c;
    }

    /* renamed from: b */
    public AbstractC0295c m21411b() {
        return this.f236b;
    }

    @Override // p004b.p005a.p006a.p028b.p034f.AbstractC0294b, p004b.p005a.p006a.p028b.AbstractC0462k, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        boolean z = false;
        if (this.f236b == null) {
            c("ThrowableRender cannot be null.");
            z = true;
        }
        if (!z) {
            super.mo20156j();
        }
    }
}
