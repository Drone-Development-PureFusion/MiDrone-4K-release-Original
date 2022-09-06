package p004b.p005a.p006a.p028b.p035g.p039d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.p318d.AbstractC5756f;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c;
import p004b.p005a.p006a.p028b.p054o.C0527f;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.b.g.d.q */
/* loaded from: classes.dex */
public class C0350q extends C0527f implements AbstractC0349p {

    /* renamed from: a */
    static String f656a = AbstractC5756f.f23062a;

    /* renamed from: b */
    HashMap<C0341h, List<AbstractC0301c>> f657b = new HashMap<>();

    public C0350q(AbstractC0292f abstractC0292f) {
        a(abstractC0292f);
    }

    /* renamed from: a */
    private boolean m20843a(C0341h c0341h) {
        return c0341h.e() > 1 && c0341h.a(0).equals(f656a);
    }

    /* renamed from: a */
    private boolean m20840a(String str) {
        return f656a.equals(str);
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p039d.AbstractC0349p
    /* renamed from: a */
    public List<AbstractC0301c> mo20844a(C0340g c0340g) {
        List<AbstractC0301c> m20839b = m20839b(c0340g);
        if (m20839b != null) {
            return m20839b;
        }
        List<AbstractC0301c> m20838c = m20838c(c0340g);
        if (m20838c != null) {
            return m20838c;
        }
        List<AbstractC0301c> m20837d = m20837d(c0340g);
        if (m20837d != null) {
            return m20837d;
        }
        List<AbstractC0301c> m20836e = m20836e(c0340g);
        if (m20836e != null) {
            return m20836e;
        }
        return null;
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p039d.AbstractC0349p
    /* renamed from: a */
    public void mo20842a(C0341h c0341h, AbstractC0301c abstractC0301c) {
        abstractC0301c.a(this.f1190s);
        List<AbstractC0301c> list = this.f657b.get(c0341h);
        if (list == null) {
            list = new ArrayList<>();
            this.f657b.put(c0341h, list);
        }
        list.add(abstractC0301c);
    }

    @Override // p004b.p005a.p006a.p028b.p035g.p039d.AbstractC0349p
    /* renamed from: a */
    public void mo20841a(C0341h c0341h, String str) {
        AbstractC0301c abstractC0301c;
        try {
            abstractC0301c = (AbstractC0301c) C0589u.m20064a(str, AbstractC0301c.class, this.f1190s);
        } catch (Exception e) {
            a("Could not instantiate class [" + str + "]", e);
            abstractC0301c = null;
        }
        if (abstractC0301c != null) {
            mo20842a(c0341h, abstractC0301c);
        }
    }

    /* renamed from: b */
    List<AbstractC0301c> m20839b(C0340g c0340g) {
        for (C0341h c0341h : this.f657b.keySet()) {
            if (c0341h.m20895a(c0340g)) {
                return this.f657b.get(c0341h);
            }
        }
        return null;
    }

    /* renamed from: c */
    List<AbstractC0301c> m20838c(C0340g c0340g) {
        int i;
        int m20893b;
        int i2 = 0;
        C0341h c0341h = null;
        for (C0341h c0341h2 : this.f657b.keySet()) {
            if (!m20843a(c0341h2) || (m20893b = c0341h2.m20893b(c0340g)) <= i2) {
                c0341h2 = c0341h;
                i = i2;
            } else {
                i = m20893b;
            }
            i2 = i;
            c0341h = c0341h2;
        }
        if (c0341h != null) {
            return this.f657b.get(c0341h);
        }
        return null;
    }

    /* renamed from: d */
    List<AbstractC0301c> m20837d(C0340g c0340g) {
        int i;
        int m20891d;
        int i2 = 0;
        C0341h c0341h = null;
        for (C0341h c0341h2 : this.f657b.keySet()) {
            if (!m20840a(c0341h2.d()) || (m20891d = c0341h2.m20891d(c0340g)) != c0341h2.e() - 1 || m20891d <= i2) {
                c0341h2 = c0341h;
                i = i2;
            } else {
                i = m20891d;
            }
            i2 = i;
            c0341h = c0341h2;
        }
        if (c0341h != null) {
            return this.f657b.get(c0341h);
        }
        return null;
    }

    /* renamed from: e */
    List<AbstractC0301c> m20836e(C0340g c0340g) {
        int i;
        C0341h c0341h = null;
        int i2 = 0;
        for (C0341h c0341h2 : this.f657b.keySet()) {
            String d = c0341h2.d();
            String a = c0341h2.e() > 1 ? c0341h2.a(0) : null;
            if (m20840a(d) && m20840a(a)) {
                List<String> b = c0341h2.b();
                if (b.size() > 2) {
                    b.remove(0);
                    b.remove(b.size() - 1);
                }
                C0341h c0341h3 = new C0341h(b);
                int e = c0341h3.m20892c(c0340g) ? c0341h3.e() : 0;
                if (e > i2) {
                    i = e;
                    i2 = i;
                    c0341h = c0341h2;
                }
            }
            c0341h2 = c0341h;
            i = i2;
            i2 = i;
            c0341h = c0341h2;
        }
        if (c0341h != null) {
            return this.f657b.get(c0341h);
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SimpleRuleStore ( ").append("rules = ").append(this.f657b).append("  ").append(" )");
        return sb.toString();
    }
}
