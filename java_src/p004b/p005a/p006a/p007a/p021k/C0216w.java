package p004b.p005a.p006a.p007a.p021k;

import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
/* renamed from: b.a.a.a.k.w */
/* loaded from: classes.dex */
public class C0216w extends AbstractC0198e {

    /* renamed from: a */
    long f337a = -1;

    /* renamed from: b */
    String f338b = null;

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0431b
    /* renamed from: a */
    public String mo20376a(AbstractC0231d abstractC0231d) {
        String str;
        long mo21208n = abstractC0231d.mo21208n();
        synchronized (this) {
            if (mo21208n != this.f337a) {
                this.f337a = mo21208n;
                this.f338b = Long.toString(mo21208n - abstractC0231d.mo21215g().m21239c());
            }
            str = this.f338b;
        }
        return str;
    }
}
