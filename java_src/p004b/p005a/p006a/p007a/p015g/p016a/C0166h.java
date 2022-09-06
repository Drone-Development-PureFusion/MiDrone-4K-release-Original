package p004b.p005a.p006a.p007a.p015g.p016a;

import org.xml.sax.Attributes;
import p004b.p005a.p006a.p007a.p019j.AbstractC0180b;
import p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c;
import p004b.p005a.p006a.p028b.p035g.p039d.C0332a;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.a.g.a.h */
/* loaded from: classes.dex */
public class C0166h extends AbstractC0301c {

    /* renamed from: a */
    private AbstractC0180b f252a;

    /* renamed from: b */
    private boolean f253b;

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
        if (this.f253b) {
            return;
        }
        c0344k.h_().mo21004a(this.f252a);
        this.f252a.mo20156j();
        if (c0344k.m20871f() != this.f252a) {
            e("The object at the of the stack is not the remote pushed earlier.");
        } else {
            c0344k.m20869g();
        }
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
        String value = attributes.getValue(AbstractC0301c.f553i);
        if (C0589u.m20054e(value)) {
            c("Missing class name for receiver. Near [" + str + "] line " + c(c0344k));
            this.f253b = true;
            return;
        }
        try {
            d("About to instantiate receiver of type [" + value + "]");
            this.f252a = (AbstractC0180b) C0589u.m20064a(value, AbstractC0180b.class, this.f1190s);
            this.f252a.a(this.f1190s);
            c0344k.m20881a(this.f252a);
        } catch (Exception e) {
            this.f253b = true;
            a("Could not create a receiver of type [" + value + "].", e);
            throw new C0332a(e);
        }
    }
}
