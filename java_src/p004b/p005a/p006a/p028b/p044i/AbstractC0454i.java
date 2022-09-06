package p004b.p005a.p006a.p028b.p044i;

import java.util.HashMap;
import java.util.Map;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.AbstractC0462k;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p044i.p046b.C0437f;
import p004b.p005a.p006a.p028b.p054o.C0539r;
import p004b.p005a.p006a.p028b.p055p.C0541a;
/* renamed from: b.a.a.b.i.i */
/* loaded from: classes.dex */
public abstract class AbstractC0454i<E> extends AbstractC0462k<E> {

    /* renamed from: b */
    AbstractC0431b<E> f1004b;

    /* renamed from: h */
    String f1005h;

    /* renamed from: i */
    protected AbstractC0456k<E> f1006i;

    /* renamed from: j */
    Map<String, String> f1007j = new HashMap();

    /* renamed from: k */
    protected boolean f1008k = false;

    /* renamed from: a */
    public abstract Map<String, String> mo20478a();

    /* renamed from: a */
    protected void m20477a(AbstractC0431b<E> abstractC0431b) {
        C0443c.m20499a(h_(), abstractC0431b);
    }

    /* renamed from: a */
    public void m20476a(AbstractC0456k<E> abstractC0456k) {
        this.f1006i = abstractC0456k;
    }

    /* renamed from: a */
    public void m20475a(boolean z) {
        this.f1008k = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public String m20473b(E e) {
        StringBuilder sb = new StringBuilder(128);
        for (AbstractC0431b<E> abstractC0431b = this.f1004b; abstractC0431b != null; abstractC0431b = abstractC0431b.m20542b()) {
            abstractC0431b.mo20480a(sb, e);
        }
        return sb.toString();
    }

    /* renamed from: b */
    public Map<String, String> m20474b() {
        Map map;
        HashMap hashMap = new HashMap();
        Map<String, String> mo20478a = mo20478a();
        if (mo20478a != null) {
            hashMap.putAll(mo20478a);
        }
        AbstractC0292f h_ = h_();
        if (h_ != null && (map = (Map) h_.mo20998f(C0359h.f710g)) != null) {
            hashMap.putAll(map);
        }
        hashMap.putAll(this.f1007j);
        return hashMap;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0462k, p004b.p005a.p006a.p028b.AbstractC0459j
    /* renamed from: f */
    public String mo20444f() {
        return this.f1008k ? m20469n() + this.f1005h : super.mo20444f();
    }

    /* renamed from: f */
    public void m20472f(String str) {
        this.f1005h = str;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0462k, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        if (this.f1005h == null || this.f1005h.length() == 0) {
            c("Empty or null pattern.");
            return;
        }
        try {
            C0437f c0437f = new C0437f(this.f1005h);
            if (h_() != null) {
                c0437f.a(h_());
            }
            this.f1004b = c0437f.m20523a(c0437f.m20524a(), m20474b());
            if (this.f1006i != null) {
                this.f1006i.mo20460a(this.f1004b);
            }
            C0443c.m20499a(h_(), this.f1004b);
            C0443c.m20498a(this.f1004b);
            super.mo20156j();
        } catch (C0539r e) {
            h_().mo20997n().mo20188a(new C0541a("Failed to parse pattern \"" + m20471l() + "\".", this, e));
        }
    }

    /* renamed from: l */
    public String m20471l() {
        return this.f1005h;
    }

    /* renamed from: m */
    public Map<String, String> m20470m() {
        return this.f1007j;
    }

    /* renamed from: n */
    protected String m20469n() {
        return "";
    }

    /* renamed from: o */
    public boolean m20468o() {
        return this.f1008k;
    }

    public String toString() {
        return getClass().getName() + "(\"" + m20471l() + "\")";
    }
}
