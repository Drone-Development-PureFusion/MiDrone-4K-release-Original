package p004b.p005a.p006a.p007a;

import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p028b.C0273c;
/* renamed from: b.a.a.a.a */
/* loaded from: classes.dex */
public class C0128a extends C0273c<AbstractC0231d> {

    /* renamed from: a */
    boolean f123a = false;

    /* renamed from: a */
    public void m21544a(boolean z) {
        this.f123a = z;
    }

    /* renamed from: a */
    public boolean m21546a() {
        return this.f123a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p028b.C0273c
    /* renamed from: a */
    public boolean mo21082b(AbstractC0231d abstractC0231d) {
        return abstractC0231d.mo21220b().m21486a() <= 20000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p028b.C0273c
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public void mo21085a_(AbstractC0231d abstractC0231d) {
        abstractC0231d.mo20213o();
        if (this.f123a) {
            abstractC0231d.mo21213i();
        }
    }
}
