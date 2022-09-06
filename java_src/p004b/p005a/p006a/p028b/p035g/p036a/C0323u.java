package p004b.p005a.p006a.p028b.p035g.p036a;

import org.xml.sax.Attributes;
import p004b.p005a.p006a.p028b.p035g.p036a.C0303e;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p057r.C0568b;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.b.g.a.u */
/* loaded from: classes.dex */
public class C0323u extends AbstractC0301c {

    /* renamed from: a */
    static String f609a = "datePattern";

    /* renamed from: b */
    static String f610b = "timeReference";

    /* renamed from: c */
    static String f611c = "contextBirth";

    /* renamed from: d */
    boolean f612d = false;

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
        long currentTimeMillis;
        String value = attributes.getValue("key");
        if (C0589u.m20054e(value)) {
            c("Attribute named [key] cannot be empty");
            this.f612d = true;
        }
        String value2 = attributes.getValue(f609a);
        if (C0589u.m20054e(value2)) {
            c("Attribute named [" + f609a + "] cannot be empty");
            this.f612d = true;
        }
        if (f611c.equalsIgnoreCase(attributes.getValue(f610b))) {
            d("Using context birth as time reference.");
            currentTimeMillis = this.f1190s.mo20995q();
        } else {
            currentTimeMillis = System.currentTimeMillis();
            d("Using current interpretation time, i.e. now, as time reference.");
        }
        if (this.f612d) {
            return;
        }
        C0303e.EnumC0305a m20964a = C0303e.m20964a(attributes.getValue("scope"));
        String m20122a = new C0568b(value2).m20122a(currentTimeMillis);
        d("Adding property to the context with key=\"" + value + "\" and value=\"" + m20122a + "\" to the " + m20964a + " scope");
        C0303e.m20966a(c0344k, value, m20122a, m20964a);
    }
}
