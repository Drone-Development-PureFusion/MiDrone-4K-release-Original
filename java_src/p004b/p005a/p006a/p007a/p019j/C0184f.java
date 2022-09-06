package p004b.p005a.p006a.p007a.p019j;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLContext;
import p004b.p005a.p006a.p007a.C0151f;
import p004b.p005a.p006a.p028b.p041h.p043b.C0379a;
import p004b.p005a.p006a.p028b.p041h.p043b.C0391m;
/* renamed from: b.a.a.a.j.f */
/* loaded from: classes.dex */
public class C0184f extends C0185g {

    /* renamed from: b */
    private final ServerSocketFactory f288b;

    public C0184f(C0151f c0151f, int i) {
        this(c0151f, i, SSLContext.getDefault());
    }

    public C0184f(C0151f c0151f, int i, SSLContext sSLContext) {
        super(c0151f, i);
        if (sSLContext == null) {
            throw new NullPointerException("SSL context required");
        }
        C0391m c0391m = new C0391m();
        c0391m.a(c0151f);
        this.f288b = new C0379a(c0391m, sSLContext.getServerSocketFactory());
    }

    /* renamed from: a */
    public static void m21355a(String[] strArr) {
        a(C0184f.class, strArr);
    }

    @Override // p004b.p005a.p006a.p007a.p019j.C0185g
    /* renamed from: a */
    protected ServerSocketFactory mo21354a() {
        return this.f288b;
    }
}
