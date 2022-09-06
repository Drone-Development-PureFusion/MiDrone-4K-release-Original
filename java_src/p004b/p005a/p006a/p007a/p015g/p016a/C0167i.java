package p004b.p005a.p006a.p007a.p015g.p016a;

import org.p318d.AbstractC5744c;
import org.xml.sax.Attributes;
import p004b.p005a.p006a.p007a.C0146d;
import p004b.p005a.p006a.p007a.C0148e;
import p004b.p005a.p006a.p007a.C0151f;
import p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.a.g.a.i */
/* loaded from: classes.dex */
public class C0167i extends AbstractC0301c {

    /* renamed from: a */
    C0148e f254a;

    /* renamed from: b */
    boolean f255b = false;

    /* renamed from: a */
    public void m21399a(C0344k c0344k) {
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
        if (this.f255b) {
            return;
        }
        Object m20871f = c0344k.m20871f();
        if (m20871f == this.f254a) {
            c0344k.m20869g();
            return;
        }
        e("The object on the top the of the stack is not the root logger");
        e("It is: " + m20871f);
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
        this.f255b = false;
        this.f254a = ((C0151f) this.f1190s).mo126e(AbstractC5744c.f23019c);
        String m20870f = c0344k.m20870f(attributes.getValue("level"));
        if (!C0589u.m20054e(m20870f)) {
            C0146d m21482a = C0146d.m21482a(m20870f);
            d("Setting level of ROOT logger to " + m21482a);
            this.f254a.m21474a(m21482a);
        }
        c0344k.m20881a(this.f254a);
    }
}
