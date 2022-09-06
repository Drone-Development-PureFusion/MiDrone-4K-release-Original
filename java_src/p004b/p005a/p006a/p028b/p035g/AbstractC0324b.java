package p004b.p005a.p006a.p028b.p035g;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0302d;
import p004b.p005a.p006a.p028b.p035g.p036a.C0306f;
import p004b.p005a.p006a.p028b.p035g.p036a.C0307g;
import p004b.p005a.p006a.p028b.p035g.p036a.C0308h;
import p004b.p005a.p006a.p028b.p035g.p036a.C0309i;
import p004b.p005a.p006a.p028b.p035g.p036a.C0315o;
import p004b.p005a.p006a.p028b.p035g.p036a.C0317p;
import p004b.p005a.p006a.p028b.p035g.p036a.C0319q;
import p004b.p005a.p006a.p028b.p035g.p036a.C0320r;
import p004b.p005a.p006a.p028b.p035g.p036a.C0321s;
import p004b.p005a.p006a.p028b.p035g.p036a.C0322t;
import p004b.p005a.p006a.p028b.p035g.p036a.C0323u;
import p004b.p005a.p006a.p028b.p035g.p039d.AbstractC0349p;
import p004b.p005a.p006a.p028b.p035g.p039d.C0341h;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p035g.p039d.C0345l;
/* renamed from: b.a.a.b.g.b */
/* loaded from: classes.dex */
public abstract class AbstractC0324b extends AbstractC0298a {
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
        abstractC0349p.mo20842a(new C0341h("configuration/substitutionProperty"), new C0321s());
        abstractC0349p.mo20842a(new C0341h("configuration/timestamp"), new C0323u());
        abstractC0349p.mo20842a(new C0341h("configuration/define"), new C0309i());
        abstractC0349p.mo20842a(new C0341h("configuration/conversionRule"), new C0308h());
        abstractC0349p.mo20842a(new C0341h("configuration/statusListener"), new C0322t());
        abstractC0349p.mo20842a(new C0341h("configuration/appender"), new C0306f());
        abstractC0349p.mo20842a(new C0341h("configuration/appender/appender-ref"), new C0307g());
        abstractC0349p.mo20842a(new C0341h("configuration/newRule"), new C0319q());
        abstractC0349p.mo20842a(new C0341h("*/param"), new C0320r());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p028b.p035g.AbstractC0298a
    /* renamed from: b */
    public void mo20939b() {
        super.mo20939b();
        Map<String, Object> m20868h = this.f539a.m20850c().m20868h();
        m20868h.put(AbstractC0302d.f569m, new HashMap());
        m20868h.put(AbstractC0302d.f570n, new HashMap());
    }

    /* renamed from: c */
    public List m20938c() {
        return null;
    }

    /* renamed from: f */
    public C0344k m20937f() {
        return this.f539a.m20850c();
    }
}
