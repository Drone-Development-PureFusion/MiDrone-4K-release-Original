package p004b.p005a.p006a.p028b.p035g.p036a;

import java.util.Stack;
import org.xml.sax.Attributes;
import p004b.p005a.p006a.p028b.p035g.p039d.C0340g;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p035g.p040e.C0356f;
import p004b.p005a.p006a.p028b.p057r.EnumC0567a;
/* renamed from: b.a.a.b.g.a.o */
/* loaded from: classes.dex */
public class C0315o extends AbstractC0312l {

    /* renamed from: a */
    Stack<C0310j> f597a = new Stack<>();

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20941a(C0344k c0344k, String str) {
        this.f597a.pop();
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: a */
    public void mo20940a(C0344k c0344k, String str, Attributes attributes) {
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
            case AS_COMPLEX_PROPERTY:
            case AS_COMPLEX_PROPERTY_COLLECTION:
                return false;
            case AS_BASIC_PROPERTY:
            case AS_BASIC_PROPERTY_COLLECTION:
                this.f597a.push(new C0310j(c0356f, m20811a, m20898d));
                return true;
            default:
                c("PropertySetter.canContainComponent returned " + m20811a);
                return false;
        }
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c
    /* renamed from: b */
    public void mo20951b(C0344k c0344k, String str) {
        String m20870f = c0344k.m20870f(str);
        C0310j peek = this.f597a.peek();
        switch (peek.f586b) {
            case AS_BASIC_PROPERTY:
                peek.f585a.m20806a(peek.f587c, m20870f);
                return;
            case AS_BASIC_PROPERTY_COLLECTION:
                peek.f585a.m20798b(peek.f587c, m20870f);
                return;
            default:
                return;
        }
    }
}
