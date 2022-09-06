package p004b.p005a.p006a.p007a.p015g.p016a;

import org.xml.sax.Attributes;
import p004b.p005a.p006a.p007a.C0151f;
import p004b.p005a.p006a.p007a.p026o.AbstractC0257i;
import p004b.p005a.p006a.p007a.p026o.C0255h;
import p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p055p.C0544d;
import p004b.p005a.p006a.p028b.p057r.C0573g;
import p004b.p005a.p006a.p028b.p057r.C0576j;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.a.g.a.b */
/* loaded from: classes.dex */
public class C0160b extends AbstractC0301c {

    /* renamed from: a */
    static final String f241a = "debug";

    /* renamed from: b */
    static final String f242b = "scan";

    /* renamed from: c */
    static final String f243c = "scanPeriod";

    /* renamed from: d */
    static final String f244d = "logback.debug";

    /* renamed from: a */
    String m21402a(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException e) {
            return null;
        }
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
        d("End of configuration.");
        c0344k.m20869g();
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
        String m20056c = C0589u.m20056c(f244d);
        if (m20056c == null) {
            m20056c = c0344k.m20870f(attributes.getValue("debug"));
        }
        if (C0589u.m20054e(m20056c) || m20056c.equalsIgnoreCase("false") || m20056c.equalsIgnoreCase("null")) {
            d("debug attribute not set");
        } else {
            C0544d.m20207b(this.f1190s);
        }
        m21403a(c0344k, attributes);
        new C0573g(this.f1190s).m20112a();
        c0344k.m20881a((Object) h_());
    }

    /* renamed from: a */
    void m21403a(C0344k c0344k, Attributes attributes) {
        String m20870f = c0344k.m20870f(attributes.getValue(f242b));
        if (C0589u.m20054e(m20870f) || "false".equalsIgnoreCase(m20870f)) {
            return;
        }
        C0255h c0255h = new C0255h();
        c0255h.a(this.f1190s);
        String m20870f2 = c0344k.m20870f(attributes.getValue(f243c));
        if (!C0589u.m20054e(m20870f2)) {
            try {
                C0576j m20106a = C0576j.m20106a(m20870f2);
                c0255h.m21135c(m20106a.m20105b());
                d("Setting ReconfigureOnChangeFilter scanning period to " + m20106a);
            } catch (NumberFormatException e) {
                a("Error while converting [" + m20870f + "] to long", e);
            }
        }
        c0255h.mo20156j();
        d("Adding ReconfigureOnChangeFilter as a turbo filter");
        ((C0151f) this.f1190s).m21442a((AbstractC0257i) c0255h);
    }
}
