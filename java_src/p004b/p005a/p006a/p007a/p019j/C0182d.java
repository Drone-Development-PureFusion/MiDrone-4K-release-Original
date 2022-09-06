package p004b.p005a.p006a.p007a.p019j;

import java.net.InetAddress;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p028b.p041h.AbstractC0360a;
import p004b.p005a.p006a.p028b.p054o.AbstractC0536o;
/* renamed from: b.a.a.a.j.d */
/* loaded from: classes.dex */
public class C0182d extends AbstractC0360a<AbstractC0231d> {

    /* renamed from: d */
    private final AbstractC0536o<AbstractC0231d> f284d = new C0171a();

    /* renamed from: e */
    private boolean f285e;

    public C0182d() {
    }

    @Deprecated
    public C0182d(String str, int i) {
        super(str, i);
    }

    @Deprecated
    public C0182d(InetAddress inetAddress, int i) {
        super(inetAddress.getHostAddress(), i);
    }

    @Override // p004b.p005a.p006a.p028b.p041h.AbstractRunnableC0378b
    /* renamed from: a */
    public AbstractC0536o<AbstractC0231d> mo20733a() {
        return this.f284d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p028b.p041h.AbstractRunnableC0378b
    /* renamed from: a */
    public void mo20724b(AbstractC0231d abstractC0231d) {
        if (this.f285e) {
            abstractC0231d.mo21213i();
        }
    }

    /* renamed from: a */
    public void m21356a(boolean z) {
        this.f285e = z;
    }
}
