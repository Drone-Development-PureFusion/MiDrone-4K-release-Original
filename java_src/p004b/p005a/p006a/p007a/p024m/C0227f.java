package p004b.p005a.p006a.p007a.p024m;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p007a.p027p.C0261d;
import p004b.p005a.p006a.p028b.AbstractC0266a;
import p004b.p005a.p006a.p028b.p035g.p036a.AbstractC0302d;
import p004b.p005a.p006a.p028b.p035g.p036a.C0306f;
import p004b.p005a.p006a.p028b.p035g.p039d.AbstractC0349p;
import p004b.p005a.p006a.p028b.p035g.p039d.C0339f;
import p004b.p005a.p006a.p028b.p035g.p039d.C0340g;
import p004b.p005a.p006a.p028b.p035g.p039d.C0341h;
import p004b.p005a.p006a.p028b.p053n.AbstractC0515h;
/* renamed from: b.a.a.a.m.f */
/* loaded from: classes.dex */
public class C0227f extends AbstractC0515h<AbstractC0231d> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0227f(String str, String str2, Map<String, String> map) {
        super(str, str2, map);
    }

    @Override // p004b.p005a.p006a.p028b.p035g.AbstractC0298a
    /* renamed from: a */
    protected C0340g mo20991a() {
        return new C0340g("configuration");
    }

    @Override // p004b.p005a.p006a.p028b.p035g.AbstractC0298a
    /* renamed from: a */
    protected void mo20989a(C0339f c0339f) {
        C0261d.m21112a(c0339f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p028b.p053n.AbstractC0515h, p004b.p005a.p006a.p028b.p035g.AbstractC0298a
    /* renamed from: a */
    public void mo20281a(AbstractC0349p abstractC0349p) {
        super.mo20281a(abstractC0349p);
        abstractC0349p.mo20842a(new C0341h("configuration/appender"), new C0306f());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p028b.p035g.AbstractC0298a
    /* renamed from: b */
    public void mo20939b() {
        super.b();
        Map<String, Object> m20868h = this.f539a.m20850c().m20868h();
        m20868h.put(AbstractC0302d.f569m, new HashMap());
        m20868h.put(AbstractC0302d.f570n, new HashMap());
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.f1163d);
        hashMap.put(this.f1161b, this.f1162c);
        this.f539a.m20854a(hashMap);
    }

    @Override // p004b.p005a.p006a.p028b.p053n.AbstractC0515h
    /* renamed from: c */
    public AbstractC0266a<AbstractC0231d> mo20278c() {
        HashMap hashMap = (HashMap) this.f539a.m20850c().m20868h().get(AbstractC0302d.f569m);
        a(hashMap);
        Collection values = hashMap.values();
        if (values.size() == 0) {
            return null;
        }
        return (AbstractC0266a) values.iterator().next();
    }
}
