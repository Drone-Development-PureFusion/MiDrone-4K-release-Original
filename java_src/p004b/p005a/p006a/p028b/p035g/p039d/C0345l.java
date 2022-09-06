package p004b.p005a.p006a.p028b.p035g.p039d;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0301c;
import p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0312l;
import p004b.p005a.p006a.p028b.p035g.p037b.C0325a;
import p004b.p005a.p006a.p028b.p035g.p037b.C0326b;
import p004b.p005a.p006a.p028b.p035g.p037b.C0330f;
/* renamed from: b.a.a.b.g.d.l */
/* loaded from: classes.dex */
public class C0345l {

    /* renamed from: e */
    private static List<AbstractC0301c> f646e = new Vector(0);

    /* renamed from: a */
    Locator f647a;

    /* renamed from: f */
    private final AbstractC0349p f651f;

    /* renamed from: g */
    private final C0344k f652g;

    /* renamed from: i */
    private final C0333b f654i;

    /* renamed from: j */
    private C0340g f655j;

    /* renamed from: d */
    C0340g f650d = null;

    /* renamed from: h */
    private final ArrayList<AbstractC0312l> f653h = new ArrayList<>(3);

    /* renamed from: c */
    Stack<List<AbstractC0301c>> f649c = new Stack<>();

    /* renamed from: b */
    C0342i f648b = new C0342i(this);

    public C0345l(AbstractC0292f abstractC0292f, AbstractC0349p abstractC0349p, C0340g c0340g) {
        this.f654i = new C0333b(abstractC0292f, this);
        this.f651f = abstractC0349p;
        this.f652g = new C0344k(abstractC0292f, this);
        this.f655j = c0340g;
    }

    /* renamed from: a */
    private void m20858a(String str, String str2, String str3) {
        List<AbstractC0301c> pop = this.f649c.pop();
        if (this.f650d != null) {
            if (this.f650d.equals(this.f655j)) {
                this.f650d = null;
            }
        } else if (pop != f646e) {
            m20851b(pop, m20859a(str2, str3));
        }
        this.f655j.m20899c();
    }

    /* renamed from: a */
    private void m20857a(String str, String str2, String str3, Attributes attributes) {
        String m20859a = m20859a(str2, str3);
        this.f655j.m20902a(m20859a);
        if (this.f650d != null) {
            m20846g();
            return;
        }
        List<AbstractC0301c> m20861a = m20861a(this.f655j, attributes);
        if (m20861a != null) {
            this.f649c.add(m20861a);
            m20855a(m20861a, m20859a, attributes);
            return;
        }
        m20846g();
        this.f654i.c("no applicable action for [" + m20859a + "], current ElementPath  is [" + this.f655j + "]");
    }

    /* renamed from: a */
    private void m20856a(List<AbstractC0301c> list, String str) {
        if (list == null) {
            return;
        }
        for (AbstractC0301c abstractC0301c : list) {
            try {
                abstractC0301c.mo20951b(this.f652g, str);
            } catch (C0332a e) {
                this.f654i.a("Exception in end() methd for action [" + abstractC0301c + "]", e);
            }
        }
    }

    /* renamed from: b */
    private void m20851b(List<AbstractC0301c> list, String str) {
        if (list == null) {
            return;
        }
        for (AbstractC0301c abstractC0301c : list) {
            try {
                abstractC0301c.mo20941a(this.f652g, str);
            } catch (C0332a e) {
                this.f654i.a("ActionException in Action for tag [" + str + "]", e);
            } catch (RuntimeException e2) {
                this.f654i.a("RuntimeException in Action for tag [" + str + "]", e2);
            }
        }
    }

    /* renamed from: g */
    private void m20846g() {
        this.f649c.add(f646e);
    }

    /* renamed from: a */
    public C0342i m20866a() {
        return this.f648b;
    }

    /* renamed from: a */
    String m20859a(String str, String str2) {
        return (str == null || str.length() < 1) ? str2 : str;
    }

    /* renamed from: a */
    List<AbstractC0301c> m20861a(C0340g c0340g, Attributes attributes) {
        List<AbstractC0301c> mo20844a = this.f651f.mo20844a(c0340g);
        return mo20844a == null ? m20860a(c0340g, attributes, this.f652g) : mo20844a;
    }

    /* renamed from: a */
    List<AbstractC0301c> m20860a(C0340g c0340g, Attributes attributes, C0344k c0344k) {
        int size = this.f653h.size();
        for (int i = 0; i < size; i++) {
            AbstractC0312l abstractC0312l = this.f653h.get(i);
            if (abstractC0312l.mo20950a(c0340g, attributes, c0344k)) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(abstractC0312l);
                return arrayList;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m20865a(AbstractC0312l abstractC0312l) {
        this.f653h.add(abstractC0312l);
    }

    /* renamed from: a */
    public void m20864a(C0325a c0325a) {
        m20853a(c0325a.f617d);
        String m20936a = c0325a.m20936a();
        List<AbstractC0301c> peek = this.f649c.peek();
        if (m20936a != null) {
            String trim = m20936a.trim();
            if (trim.length() <= 0) {
                return;
            }
            m20856a(peek, trim);
        }
    }

    /* renamed from: a */
    public void m20863a(C0326b c0326b) {
        m20853a(c0326b.f617d);
        m20858a(c0326b.f614a, c0326b.f615b, c0326b.f616c);
    }

    /* renamed from: a */
    public void m20862a(C0330f c0330f) {
        m20853a(c0330f.c());
        m20857a(c0330f.f614a, c0330f.f615b, c0330f.f616c, c0330f.f622e);
    }

    /* renamed from: a */
    void m20855a(List<AbstractC0301c> list, String str, Attributes attributes) {
        if (list == null) {
            return;
        }
        for (AbstractC0301c abstractC0301c : list) {
            try {
                abstractC0301c.mo20940a(this.f652g, str, attributes);
            } catch (C0332a e) {
                this.f650d = this.f655j.m20904a();
                this.f654i.a("ActionException in Action for tag [" + str + "]", e);
            } catch (RuntimeException e2) {
                this.f650d = this.f655j.m20904a();
                this.f654i.a("RuntimeException in Action for tag [" + str + "]", e2);
            }
        }
    }

    /* renamed from: a */
    public void m20854a(Map<String, String> map) {
        this.f652g.m20879a(map);
    }

    /* renamed from: a */
    public void m20853a(Locator locator) {
        this.f647a = locator;
    }

    /* renamed from: b */
    public C0344k m20852b() {
        return m20850c();
    }

    /* renamed from: c */
    public C0344k m20850c() {
        return this.f652g;
    }

    /* renamed from: d */
    public void m20849d() {
    }

    /* renamed from: e */
    public Locator m20848e() {
        return this.f647a;
    }

    /* renamed from: f */
    public AbstractC0349p m20847f() {
        return this.f651f;
    }
}
