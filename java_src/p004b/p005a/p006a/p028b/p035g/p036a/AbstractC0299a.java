package p004b.p005a.p006a.p028b.p035g.p036a;

import java.util.Map;
import org.xml.sax.Attributes;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p030b.AbstractC0271b;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p054o.AbstractC0534m;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.b.g.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC0299a extends AbstractC0301c {

    /* renamed from: a */
    AbstractC0271b<?> f540a;

    /* renamed from: b */
    boolean f541b = false;

    /* renamed from: a */
    protected abstract String m20981a();

    /* renamed from: a */
    public void m20980a(C0344k c0344k) {
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
        if (this.f541b) {
            return;
        }
        if (this.f540a instanceof AbstractC0534m) {
            this.f540a.mo20156j();
            d("Starting evaluator named [" + this.f540a.mo21089a() + "]");
        }
        if (c0344k.m20871f() != this.f540a) {
            e("The object on the top the of the stack is not the evaluator pushed earlier.");
            return;
        }
        c0344k.m20869g();
        try {
            Map map = (Map) this.f1190s.mo20998f(C0359h.f715l);
            if (map == null) {
                c("Could not find EvaluatorMap");
            } else {
                map.put(this.f540a.mo21089a(), this.f540a);
            }
        } catch (Exception e) {
            a("Could not set evaluator named [" + this.f540a + "].", e);
        }
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
        this.f541b = false;
        this.f540a = null;
        String value = attributes.getValue(AbstractC0301c.f553i);
        if (C0589u.m20054e(value)) {
            value = m20981a();
            d("Assuming default evaluator class [" + value + "]");
        }
        String str2 = value;
        if (C0589u.m20054e(str2)) {
            m20981a();
            this.f541b = true;
            c("Mandatory \"class\" attribute not set for <evaluator>");
            return;
        }
        String value2 = attributes.getValue("name");
        if (C0589u.m20054e(value2)) {
            this.f541b = true;
            c("Mandatory \"name\" attribute not set for <evaluator>");
            return;
        }
        try {
            this.f540a = (AbstractC0271b) C0589u.m20064a(str2, AbstractC0271b.class, this.f1190s);
            this.f540a.a(this.f1190s);
            this.f540a.mo21088b(value2);
            c0344k.m20881a(this.f540a);
            d("Adding evaluator named [" + value2 + "] to the object stack");
        } catch (Exception e) {
            this.f541b = true;
            a("Could not create evaluator of type " + str2 + "].", e);
        }
    }
}
