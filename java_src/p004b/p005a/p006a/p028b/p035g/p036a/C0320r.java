package p004b.p005a.p006a.p028b.p035g.p036a;

import org.xml.sax.Attributes;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p035g.p040e.C0356f;
/* renamed from: b.a.a.b.g.a.r */
/* loaded from: classes.dex */
public class C0320r extends AbstractC0301c {

    /* renamed from: a */
    static String f602a = "No name attribute in <param> element";

    /* renamed from: b */
    static String f603b = "No value attribute in <param> element";

    /* renamed from: c */
    boolean f604c = false;

    /* renamed from: a */
    public void m20948a(C0344k c0344k) {
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
        String value = attributes.getValue("name");
        String value2 = attributes.getValue("value");
        if (value == null) {
            this.f604c = true;
            c(f602a);
        } else if (value2 == null) {
            this.f604c = true;
            c(f603b);
        } else {
            String trim = value2.trim();
            C0356f c0356f = new C0356f(c0344k.m20871f());
            c0356f.a(this.f1190s);
            c0356f.m20806a(c0344k.m20870f(value), c0344k.m20870f(trim));
        }
    }
}
