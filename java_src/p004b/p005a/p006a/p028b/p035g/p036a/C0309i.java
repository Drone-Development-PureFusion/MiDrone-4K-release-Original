package p004b.p005a.p006a.p028b.p035g.p036a;

import org.xml.sax.Attributes;
import p004b.p005a.p006a.p028b.p035g.p036a.C0303e;
import p004b.p005a.p006a.p028b.p035g.p039d.C0332a;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p054o.AbstractC0534m;
import p004b.p005a.p006a.p028b.p054o.AbstractC0538q;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.b.g.a.i */
/* loaded from: classes.dex */
public class C0309i extends AbstractC0301c {

    /* renamed from: a */
    String f580a;

    /* renamed from: b */
    C0303e.EnumC0305a f581b;

    /* renamed from: c */
    String f582c;

    /* renamed from: d */
    AbstractC0538q f583d;

    /* renamed from: m */
    boolean f584m;

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
        if (this.f584m) {
            return;
        }
        if (c0344k.m20871f() != this.f583d) {
            e("The object at the of the stack is not the property definer for property named [" + this.f582c + "] pushed earlier.");
            return;
        }
        d("Popping property definer for property named [" + this.f582c + "] from the object stack");
        c0344k.m20869g();
        String mo20209b = this.f583d.mo20209b();
        if (mo20209b == null) {
            return;
        }
        C0303e.m20966a(c0344k, this.f582c, mo20209b, this.f581b);
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
        this.f580a = null;
        this.f581b = null;
        this.f582c = null;
        this.f583d = null;
        this.f584m = false;
        this.f582c = attributes.getValue("name");
        this.f580a = attributes.getValue("scope");
        this.f581b = C0303e.m20964a(this.f580a);
        if (C0589u.m20054e(this.f582c)) {
            c("Missing property name for property definer. Near [" + str + "] line " + c(c0344k));
            this.f584m = true;
            return;
        }
        String value = attributes.getValue(AbstractC0301c.f553i);
        if (C0589u.m20054e(value)) {
            c("Missing class name for property definer. Near [" + str + "] line " + c(c0344k));
            this.f584m = true;
            return;
        }
        try {
            d("About to instantiate property definer of type [" + value + "]");
            this.f583d = (AbstractC0538q) C0589u.m20064a(value, AbstractC0538q.class, this.f1190s);
            this.f583d.a(this.f1190s);
            if (this.f583d instanceof AbstractC0534m) {
                ((AbstractC0534m) this.f583d).mo20156j();
            }
            c0344k.m20881a(this.f583d);
        } catch (Exception e) {
            this.f584m = true;
            a("Could not create an PropertyDefiner of type [" + value + "].", e);
            throw new C0332a(e);
        }
    }
}
