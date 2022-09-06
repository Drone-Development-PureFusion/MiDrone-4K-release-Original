package p004b.p005a.p006a.p007a.p021k;

import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
/* renamed from: b.a.a.a.k.v */
/* loaded from: classes.dex */
public final class C0215v extends AbstractC0198e {

    /* renamed from: a */
    String f336a;

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0431b
    /* renamed from: a */
    public String mo20376a(AbstractC0231d abstractC0231d) {
        if (this.f336a == null) {
            return "Property_HAS_NO_KEY";
        }
        String str = abstractC0231d.mo21215g().m21240b().get(this.f336a);
        return str == null ? System.getProperty(this.f336a) : str;
    }

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0449d, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        String d = d();
        if (d != null) {
            this.f336a = d;
            super.j();
        }
    }
}
