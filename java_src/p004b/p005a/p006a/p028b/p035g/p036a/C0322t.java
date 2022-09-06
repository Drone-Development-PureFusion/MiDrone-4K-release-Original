package p004b.p005a.p006a.p028b.p035g.p036a;

import org.xml.sax.Attributes;
import p004b.p005a.p006a.p028b.p035g.p039d.C0332a;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p054o.AbstractC0526e;
import p004b.p005a.p006a.p028b.p054o.AbstractC0534m;
import p004b.p005a.p006a.p028b.p055p.AbstractC0549i;
import p004b.p005a.p006a.p028b.p055p.C0544d;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.b.g.a.t */
/* loaded from: classes.dex */
public class C0322t extends AbstractC0301c {

    /* renamed from: a */
    boolean f607a = false;

    /* renamed from: b */
    AbstractC0549i f608b = null;

    /* renamed from: a */
    public void m20942a(C0344k c0344k) {
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
        if (this.f607a) {
            return;
        }
        if (this.f608b instanceof AbstractC0534m) {
            ((AbstractC0534m) this.f608b).mo20156j();
        }
        if (c0344k.m20871f() != this.f608b) {
            e("The object at the of the stack is not the statusListener pushed earlier.");
        } else {
            c0344k.m20869g();
        }
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
        this.f607a = false;
        String value = attributes.getValue(AbstractC0301c.f553i);
        if (C0589u.m20054e(value)) {
            c("Missing class name for statusListener. Near [" + str + "] line " + c(c0344k));
            this.f607a = true;
            return;
        }
        try {
            if (C0544d.class.getName().equals(value)) {
                C0544d.m20207b(this.f1190s);
            } else {
                this.f608b = (AbstractC0549i) C0589u.m20064a(value, AbstractC0549i.class, this.f1190s);
                c0344k.h_().mo20997n().mo20187a(this.f608b);
                if (this.f608b instanceof AbstractC0526e) {
                    ((AbstractC0526e) this.f608b).mo20233a(this.f1190s);
                }
            }
            d("Added status listener of type [" + value + "]");
            c0344k.m20881a(this.f608b);
        } catch (Exception e) {
            this.f607a = true;
            a("Could not create an StatusListener of type [" + value + "].", e);
            throw new C0332a(e);
        }
    }
}
