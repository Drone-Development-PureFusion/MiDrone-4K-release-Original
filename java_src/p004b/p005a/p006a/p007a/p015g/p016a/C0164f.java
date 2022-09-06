package p004b.p005a.p006a.p007a.p015g.p016a;

import org.xml.sax.Attributes;
import p004b.p005a.p006a.p007a.C0146d;
import p004b.p005a.p006a.p007a.C0148e;
import p004b.p005a.p006a.p007a.C0151f;
import p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c;
import p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0302d;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.a.g.a.f */
/* loaded from: classes.dex */
public class C0164f extends AbstractC0301c {

    /* renamed from: a */
    public static final String f247a = "level";

    /* renamed from: b */
    boolean f248b = false;

    /* renamed from: c */
    C0148e f249c;

    /* renamed from: a */
    public void m21400a(C0344k c0344k) {
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
        if (this.f248b) {
            return;
        }
        Object m20871f = c0344k.m20871f();
        if (m20871f == this.f249c) {
            c0344k.m20869g();
            return;
        }
        e("The object on the top the of the stack is not " + this.f249c + " pushed earlier");
        e("It is: " + m20871f);
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
        this.f248b = false;
        this.f249c = null;
        C0151f c0151f = (C0151f) this.f1190s;
        String m20870f = c0344k.m20870f(attributes.getValue("name"));
        if (C0589u.m20054e(m20870f)) {
            this.f248b = true;
            c("No 'name' attribute in element " + str + ", around " + d(c0344k));
            return;
        }
        this.f249c = c0151f.mo126e(m20870f);
        String m20870f2 = c0344k.m20870f(attributes.getValue("level"));
        if (!C0589u.m20054e(m20870f2)) {
            if (AbstractC0302d.f566j.equalsIgnoreCase(m20870f2) || AbstractC0302d.f567k.equalsIgnoreCase(m20870f2)) {
                d("Setting level of logger [" + m20870f + "] to null, i.e. INHERITED");
                this.f249c.m21474a((C0146d) null);
            } else {
                C0146d m21482a = C0146d.m21482a(m20870f2);
                d("Setting level of logger [" + m20870f + "] to " + m21482a);
                this.f249c.m21474a(m21482a);
            }
        }
        String m20870f3 = c0344k.m20870f(attributes.getValue(AbstractC0302d.f559c));
        if (!C0589u.m20054e(m20870f3)) {
            boolean booleanValue = Boolean.valueOf(m20870f3).booleanValue();
            d("Setting additivity of logger [" + m20870f + "] to " + booleanValue);
            this.f249c.m21467a(booleanValue);
        }
        c0344k.m20881a(this.f249c);
    }
}
