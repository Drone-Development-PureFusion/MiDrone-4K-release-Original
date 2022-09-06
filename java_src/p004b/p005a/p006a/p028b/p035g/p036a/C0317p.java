package p004b.p005a.p006a.p028b.p035g.p036a;

import java.util.Stack;
import org.xml.sax.Attributes;
import p004b.p005a.p006a.p028b.p035g.p039d.C0340g;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p035g.p039d.C0348o;
import p004b.p005a.p006a.p028b.p035g.p040e.C0356f;
import p004b.p005a.p006a.p028b.p054o.AbstractC0526e;
import p004b.p005a.p006a.p028b.p054o.AbstractC0534m;
import p004b.p005a.p006a.p028b.p057r.C0585s;
import p004b.p005a.p006a.p028b.p057r.C0589u;
import p004b.p005a.p006a.p028b.p057r.EnumC0567a;
/* renamed from: b.a.a.b.g.a.p */
/* loaded from: classes.dex */
public class C0317p extends AbstractC0312l {

    /* renamed from: a */
    Stack<C0311k> f599a = new Stack<>();

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
        C0311k pop = this.f599a.pop();
        if (pop.f592d) {
            return;
        }
        C0356f c0356f = new C0356f(pop.m20959b());
        c0356f.a(this.f1190s);
        if (c0356f.m20811a("parent") == EnumC0567a.AS_COMPLEX_PROPERTY) {
            c0356f.m20799b("parent", pop.f589a.m20795c());
        }
        Object m20959b = pop.m20959b();
        if ((m20959b instanceof AbstractC0534m) && C0348o.m20845a(m20959b)) {
            ((AbstractC0534m) m20959b).mo20156j();
        }
        if (c0344k.m20871f() != pop.m20959b()) {
            c("The object on the top the of the stack is not the component pushed earlier.");
            return;
        }
        c0344k.m20869g();
        switch (pop.f590b) {
            case AS_COMPLEX_PROPERTY_COLLECTION:
                pop.f589a.m20807a(str, pop.m20959b());
                return;
            case AS_COMPLEX_PROPERTY:
                pop.f589a.m20799b(str, pop.m20959b());
                return;
            default:
                return;
        }
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
        C0311k peek = this.f599a.peek();
        String m20870f = c0344k.m20870f(attributes.getValue(AbstractC0301c.f553i));
        try {
            Class<?> m20078a = !C0589u.m20054e(m20870f) ? C0585s.m20078a(m20870f, this.f1190s) : peek.f589a.m20809a(peek.m20958c(), peek.m20961a(), c0344k.m20885a());
            if (m20078a == null) {
                peek.f592d = true;
                c("Could not find an appropriate class for property [" + str + "]");
                return;
            }
            if (C0589u.m20054e(m20870f)) {
                d("Assuming default type [" + m20078a.getName() + "] for [" + str + "] property");
            }
            peek.m20960a(m20078a.newInstance());
            if (peek.m20959b() instanceof AbstractC0526e) {
                ((AbstractC0526e) peek.m20959b()).mo20233a(this.f1190s);
            }
            c0344k.m20881a(peek.m20959b());
        } catch (Exception e) {
            peek.f592d = true;
            a("Could not create component [" + str + "] of type [" + m20870f + "]", e);
        }
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0312l
    /* renamed from: a */
    public boolean mo20950a(C0340g c0340g, Attributes attributes, C0344k c0344k) {
        String m20898d = c0340g.m20898d();
        if (c0344k.m20872e()) {
            return false;
        }
        C0356f c0356f = new C0356f(c0344k.m20871f());
        c0356f.a(this.f1190s);
        EnumC0567a m20811a = c0356f.m20811a(m20898d);
        switch (m20811a) {
            case NOT_FOUND:
            case AS_BASIC_PROPERTY:
            case AS_BASIC_PROPERTY_COLLECTION:
                return false;
            case AS_COMPLEX_PROPERTY_COLLECTION:
            case AS_COMPLEX_PROPERTY:
                this.f599a.push(new C0311k(c0356f, m20811a, m20898d));
                return true;
            default:
                c("PropertySetter.computeAggregationType returned " + m20811a);
                return false;
        }
    }
}
