package p004b.p005a.p006a.p028b.p044i.p046b;

import java.util.Map;
import p004b.p005a.p006a.p028b.p044i.AbstractC0412a;
import p004b.p005a.p006a.p028b.p044i.AbstractC0431b;
import p004b.p005a.p006a.p028b.p044i.AbstractC0449d;
import p004b.p005a.p006a.p028b.p044i.C0453h;
import p004b.p005a.p006a.p028b.p054o.C0527f;
import p004b.p005a.p006a.p028b.p055p.C0541a;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: b.a.a.b.i.b.a */
/* loaded from: classes.dex */
public class C0432a<E> extends C0527f {

    /* renamed from: a */
    AbstractC0431b<E> f935a;

    /* renamed from: b */
    AbstractC0431b<E> f936b;

    /* renamed from: c */
    final C0435d f937c;

    /* renamed from: d */
    final Map f938d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0432a(C0435d c0435d, Map map) {
        this.f937c = c0435d;
        this.f938d = map;
    }

    /* renamed from: a */
    private void m20537a(AbstractC0431b<E> abstractC0431b) {
        if (this.f935a == null) {
            this.f936b = abstractC0431b;
            this.f935a = abstractC0431b;
            return;
        }
        this.f936b.m20541b(abstractC0431b);
        this.f936b = abstractC0431b;
    }

    /* renamed from: a */
    AbstractC0412a<E> m20539a(C0433b c0433b) {
        String str = (String) c0433b.d();
        String str2 = (String) this.f938d.get(str);
        if (str2 == null) {
            c("There is no conversion class registered for composite conversion word [" + str + "]");
            return null;
        }
        try {
            return (AbstractC0412a) C0589u.m20064a(str2, AbstractC0412a.class, this.f1190s);
        } catch (Exception e) {
            a("Failed to instantiate converter class [" + str2 + "] as a composite converter for keyword [" + str + "]", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public AbstractC0431b<E> m20540a() {
        this.f936b = null;
        this.f935a = null;
        for (C0435d c0435d = this.f937c; c0435d != null; c0435d = c0435d.f946h) {
            switch (c0435d.f944f) {
                case 0:
                    m20537a(new C0453h<>((String) c0435d.m20530d()));
                    break;
                case 1:
                    C0438g c0438g = (C0438g) c0435d;
                    AbstractC0449d<E> m20538a = m20538a(c0438g);
                    if (m20538a != null) {
                        m20538a.a(c0438g.b());
                        m20538a.m20493a(c0438g.m20511g());
                        m20537a(m20538a);
                        break;
                    } else {
                        AbstractC0431b<E> c0453h = new C0453h<>("%PARSER_ERROR[" + c0438g.d() + "]");
                        a(new C0541a("[" + c0438g.d() + "] is not a valid conversion word", this));
                        m20537a(c0453h);
                        break;
                    }
                case 2:
                    C0433b c0433b = (C0433b) c0435d;
                    AbstractC0412a<E> m20539a = m20539a(c0433b);
                    if (m20539a == null) {
                        c("Failed to create converter for [%" + c0433b.d() + "] keyword");
                        m20537a(new C0453h<>("%PARSER_ERROR[" + c0433b.d() + "]"));
                        break;
                    } else {
                        m20539a.a(c0433b.b());
                        m20539a.a(c0433b.g());
                        C0432a c0432a = new C0432a(c0433b.m20536a(), this.f938d);
                        c0432a.a(this.f1190s);
                        m20539a.m20544a((AbstractC0431b) c0432a.m20540a());
                        m20537a(m20539a);
                        break;
                    }
            }
        }
        return this.f935a;
    }

    /* renamed from: a */
    AbstractC0449d<E> m20538a(C0438g c0438g) {
        String str = (String) c0438g.d();
        String str2 = (String) this.f938d.get(str);
        if (str2 == null) {
            c("There is no conversion class registered for conversion word [" + str + "]");
            return null;
        }
        try {
            return (AbstractC0449d) C0589u.m20064a(str2, AbstractC0449d.class, this.f1190s);
        } catch (Exception e) {
            a("Failed to instantiate converter class [" + str2 + "] for keyword [" + str + "]", e);
            return null;
        }
    }
}
