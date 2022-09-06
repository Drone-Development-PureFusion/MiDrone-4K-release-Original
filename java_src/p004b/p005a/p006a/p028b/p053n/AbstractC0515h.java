package p004b.p005a.p006a.p028b.p053n;

import java.util.List;
import java.util.Map;
import p004b.p005a.p006a.p028b.AbstractC0266a;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p035g.AbstractC0298a;
import p004b.p005a.p006a.p028b.p035g.p036a.C0309i;
import p004b.p005a.p006a.p028b.p035g.p036a.C0315o;
import p004b.p005a.p006a.p028b.p035g.p036a.C0317p;
import p004b.p005a.p006a.p028b.p035g.p036a.C0321s;
import p004b.p005a.p006a.p028b.p035g.p036a.C0323u;
import p004b.p005a.p006a.p028b.p035g.p037b.C0328d;
import p004b.p005a.p006a.p028b.p035g.p039d.AbstractC0349p;
import p004b.p005a.p006a.p028b.p035g.p039d.C0341h;
import p004b.p005a.p006a.p028b.p035g.p039d.C0345l;
/* renamed from: b.a.a.b.n.h */
/* loaded from: classes.dex */
public abstract class AbstractC0515h<E> extends AbstractC0298a {

    /* renamed from: e */
    static final String f1160e = "http://logback.qos.ch/codes.html#1andOnly1";

    /* renamed from: b */
    protected final String f1161b;

    /* renamed from: c */
    protected final String f1162c;

    /* renamed from: d */
    protected final Map<String, String> f1163d;

    /* renamed from: f */
    int f1164f = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0515h(String str, String str2, Map<String, String> map) {
        this.f1161b = str;
        this.f1162c = str2;
        this.f1163d = map;
    }

    @Override // p004b.p005a.p006a.p028b.p035g.AbstractC0298a
    /* renamed from: a */
    protected void mo20282a(C0345l c0345l) {
        C0317p c0317p = new C0317p();
        c0317p.a(this.f1190s);
        c0345l.m20865a(c0317p);
        C0315o c0315o = new C0315o();
        c0315o.a(this.f1190s);
        c0345l.m20865a(c0315o);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p028b.p035g.AbstractC0298a
    /* renamed from: a */
    public void mo20281a(AbstractC0349p abstractC0349p) {
        abstractC0349p.mo20842a(new C0341h("configuration/property"), new C0321s());
        abstractC0349p.mo20842a(new C0341h("configuration/timestamp"), new C0323u());
        abstractC0349p.mo20842a(new C0341h("configuration/define"), new C0309i());
    }

    @Override // p004b.p005a.p006a.p028b.p035g.AbstractC0298a
    /* renamed from: a */
    public void mo20280a(List<C0328d> list) {
        super.mo20280a(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m20279a(Map<?, ?> map) {
        String str = null;
        if (map.size() == 0) {
            this.f1164f++;
            str = "No nested appenders found within the <sift> element in SiftingAppender.";
        } else if (map.size() > 1) {
            this.f1164f++;
            str = "Only and only one appender can be nested the <sift> element in SiftingAppender. See also http://logback.qos.ch/codes.html#1andOnly1";
        }
        if (str == null || this.f1164f >= 4) {
            return;
        }
        c(str);
    }

    /* renamed from: c */
    public abstract AbstractC0266a<E> mo20278c();

    public String toString() {
        return getClass().getName() + "{" + this.f1161b + "=" + this.f1162c + C0359h.f726w;
    }
}
