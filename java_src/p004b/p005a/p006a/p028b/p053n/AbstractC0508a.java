package p004b.p005a.p006a.p028b.p053n;

import java.util.List;
import java.util.Map;
import p004b.p005a.p006a.p028b.AbstractC0266a;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.p035g.p037b.C0328d;
/* renamed from: b.a.a.b.n.a */
/* loaded from: classes.dex */
public abstract class AbstractC0508a<E> implements AbstractC0510c<E> {

    /* renamed from: a */
    final List<C0328d> f1146a;

    /* renamed from: b */
    protected String f1147b;

    /* renamed from: c */
    protected Map<String, String> f1148c;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC0508a(List<C0328d> list, String str, Map<String, String> map) {
        this.f1146a = m20302a(list);
        this.f1147b = str;
        this.f1148c = map;
    }

    @Override // p004b.p005a.p006a.p028b.p053n.AbstractC0510c
    /* renamed from: a */
    public AbstractC0266a<E> mo20301a(AbstractC0292f abstractC0292f, String str) {
        AbstractC0515h<E> mo20303a = mo20303a(str);
        mo20303a.a(abstractC0292f);
        mo20303a.mo20280a(this.f1146a);
        return mo20303a.mo20278c();
    }

    /* renamed from: a */
    public abstract AbstractC0515h<E> mo20303a(String str);

    /* renamed from: a */
    public List<C0328d> m20304a() {
        return this.f1146a;
    }

    /* renamed from: a */
    List<C0328d> m20302a(List<C0328d> list) {
        return list.subList(1, list.size() - 1);
    }
}
