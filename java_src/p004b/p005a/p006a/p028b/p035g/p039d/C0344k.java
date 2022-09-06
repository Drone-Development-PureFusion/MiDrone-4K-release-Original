package p004b.p005a.p006a.p028b.p035g.p039d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;
import org.xml.sax.Locator;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.p035g.p037b.AbstractC0327c;
import p004b.p005a.p006a.p028b.p035g.p037b.C0328d;
import p004b.p005a.p006a.p028b.p054o.AbstractC0537p;
import p004b.p005a.p006a.p028b.p054o.C0527f;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.b.g.d.k */
/* loaded from: classes.dex */
public class C0344k extends C0527f implements AbstractC0537p {

    /* renamed from: d */
    C0345l f643d;

    /* renamed from: e */
    final List<AbstractC0327c> f644e = new ArrayList();

    /* renamed from: f */
    C0339f f645f = new C0339f();

    /* renamed from: a */
    Stack<Object> f640a = new Stack<>();

    /* renamed from: b */
    Map<String, Object> f641b = new HashMap(5);

    /* renamed from: c */
    Map<String, String> f642c = new HashMap(5);

    public C0344k(AbstractC0292f abstractC0292f, C0345l c0345l) {
        this.f1190s = abstractC0292f;
        this.f643d = c0345l;
    }

    /* renamed from: a */
    public C0339f m20885a() {
        return this.f645f;
    }

    /* renamed from: a */
    public Object m20884a(int i) {
        return this.f640a.get(i);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0537p
    /* renamed from: a */
    public String mo20211a(String str) {
        String str2 = this.f642c.get(str);
        return str2 != null ? str2 : this.f1190s.mo20211a(str);
    }

    /* renamed from: a */
    public void m20883a(AbstractC0327c abstractC0327c) {
        if (this.f644e.contains(abstractC0327c)) {
            e("InPlayListener " + abstractC0327c + " has been already registered");
        } else {
            this.f644e.add(abstractC0327c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m20882a(C0328d c0328d) {
        for (AbstractC0327c abstractC0327c : this.f644e) {
            abstractC0327c.mo20934a(c0328d);
        }
    }

    /* renamed from: a */
    public void m20881a(Object obj) {
        this.f640a.push(obj);
    }

    /* renamed from: a */
    public void m20880a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f642c.put(str, str2.trim());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m20879a(Map<String, String> map) {
        this.f642c = map;
    }

    /* renamed from: a */
    public void m20878a(Properties properties) {
        if (properties == null) {
            return;
        }
        for (String str : properties.keySet()) {
            m20880a(str, properties.getProperty(str));
        }
    }

    /* renamed from: b */
    String m20875b(String str) {
        Locator m20848e = this.f643d.m20848e();
        return m20848e != null ? str + m20848e.getLineNumber() + ":" + m20848e.getColumnNumber() : str;
    }

    /* renamed from: b */
    public Locator m20877b() {
        return this.f643d.m20848e();
    }

    /* renamed from: b */
    public boolean m20876b(AbstractC0327c abstractC0327c) {
        return this.f644e.remove(abstractC0327c);
    }

    /* renamed from: c */
    public C0345l m20874c() {
        return this.f643d;
    }

    /* renamed from: d */
    public Stack<Object> m20873d() {
        return this.f640a;
    }

    /* renamed from: e */
    public boolean m20872e() {
        return this.f640a.isEmpty();
    }

    /* renamed from: f */
    public Object m20871f() {
        return this.f640a.peek();
    }

    /* renamed from: f */
    public String m20870f(String str) {
        if (str == null) {
            return null;
        }
        return C0589u.m20065a(str, this, this.f1190s);
    }

    /* renamed from: g */
    public Object m20869g() {
        return this.f640a.pop();
    }

    /* renamed from: h */
    public Map<String, Object> m20868h() {
        return this.f641b;
    }

    /* renamed from: j */
    public boolean m20867j() {
        return this.f644e.isEmpty();
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0537p
    /* renamed from: o */
    public Map<String, String> mo20210o() {
        return new HashMap(this.f642c);
    }
}
