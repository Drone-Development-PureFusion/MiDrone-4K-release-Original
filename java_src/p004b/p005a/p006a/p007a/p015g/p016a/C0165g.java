package p004b.p005a.p006a.p007a.p015g.p016a;

import org.xml.sax.Attributes;
import p004b.p005a.p006a.p007a.C0151f;
import p004b.p005a.p006a.p007a.p025n.AbstractC0236i;
import p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p054o.AbstractC0526e;
import p004b.p005a.p006a.p028b.p054o.AbstractC0534m;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.a.g.a.g */
/* loaded from: classes.dex */
public class C0165g extends AbstractC0301c {

    /* renamed from: a */
    boolean f250a = false;

    /* renamed from: b */
    AbstractC0236i f251b;

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
        if (this.f250a) {
            return;
        }
        if (c0344k.m20871f() != this.f251b) {
            e("The object on the top the of the stack is not the LoggerContextListener pushed earlier.");
            return;
        }
        if (this.f251b instanceof AbstractC0534m) {
            ((AbstractC0534m) this.f251b).mo20156j();
            d("Starting LoggerContextListener");
        }
        ((C0151f) this.f1190s).m21443a(this.f251b);
        c0344k.m20869g();
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
        this.f250a = false;
        String value = attributes.getValue(AbstractC0301c.f553i);
        if (C0589u.m20054e(value)) {
            c("Mandatory \"class\" attribute not set for <loggerContextListener> element");
            this.f250a = true;
            return;
        }
        try {
            this.f251b = (AbstractC0236i) C0589u.m20064a(value, AbstractC0236i.class, this.f1190s);
            if (this.f251b instanceof AbstractC0526e) {
                ((AbstractC0526e) this.f251b).mo20233a(this.f1190s);
            }
            c0344k.m20881a(this.f251b);
            d("Adding LoggerContextListener of type [" + value + "] to the object stack");
        } catch (Exception e) {
            this.f250a = true;
            a("Could not create LoggerContextListener of type " + value + "].", e);
        }
    }
}
