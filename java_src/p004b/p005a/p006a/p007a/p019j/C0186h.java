package p004b.p005a.p006a.p007a.p019j;

import java.net.InetAddress;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p028b.p041h.AbstractRunnableC0378b;
import p004b.p005a.p006a.p028b.p054o.AbstractC0536o;
/* renamed from: b.a.a.a.j.h */
/* loaded from: classes.dex */
public class C0186h extends AbstractRunnableC0378b<AbstractC0231d> {

    /* renamed from: d */
    private static final AbstractC0536o<AbstractC0231d> f296d = new C0171a();

    /* renamed from: e */
    private boolean f297e = false;

    public C0186h() {
    }

    @Deprecated
    public C0186h(String str, int i) {
        super(str, i);
    }

    @Deprecated
    public C0186h(InetAddress inetAddress, int i) {
        super(inetAddress.getHostAddress(), i);
    }

    @Override // p004b.p005a.p006a.p028b.p041h.AbstractRunnableC0378b
    /* renamed from: a */
    public AbstractC0536o<AbstractC0231d> mo20733a() {
        return f296d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p028b.p041h.AbstractRunnableC0378b
    /* renamed from: a */
    public void mo20724b(AbstractC0231d abstractC0231d) {
        if (this.f297e) {
            abstractC0231d.mo21213i();
        }
    }

    /* renamed from: a */
    public void m21339a(boolean z) {
        this.f297e = z;
    }
}
