package p004b.p005a.p006a.p007a.p024m;

import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p028b.p053n.AbstractC0509b;
/* renamed from: b.a.a.a.m.b */
/* loaded from: classes.dex */
public class C0223b extends AbstractC0509b<AbstractC0231d> {

    /* renamed from: b */
    private static final String f346b = "contextName";

    /* renamed from: c */
    private String f347c;

    @Override // p004b.p005a.p006a.p028b.p053n.AbstractC0513f
    /* renamed from: a */
    public String mo20296a() {
        return f346b;
    }

    @Override // p004b.p005a.p006a.p028b.p053n.AbstractC0513f
    /* renamed from: a */
    public String mo20295a(AbstractC0231d abstractC0231d) {
        String m21241a = abstractC0231d.mo21215g().m21241a();
        return m21241a == null ? this.f347c : m21241a;
    }

    /* renamed from: a */
    public void m21270a(String str) {
        throw new UnsupportedOperationException("Key cannot be set. Using fixed key contextName");
    }

    /* renamed from: b */
    public String m21269b() {
        return this.f347c;
    }

    /* renamed from: b */
    public void m21268b(String str) {
        this.f347c = str;
    }
}
