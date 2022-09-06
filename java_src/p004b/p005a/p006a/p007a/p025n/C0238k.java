package p004b.p005a.p006a.p007a.p025n;

import java.io.Serializable;
import p004b.p005a.p006a.p007a.C0151f;
/* renamed from: b.a.a.a.n.k */
/* loaded from: classes.dex */
public class C0238k implements Serializable {

    /* renamed from: c */
    static final /* synthetic */ boolean f363c;
    private static final long serialVersionUID = 5028223666108713696L;

    /* renamed from: a */
    final C0237j f364a;

    /* renamed from: b */
    final String f365b;

    static {
        f363c = !C0238k.class.desiredAssertionStatus();
    }

    public C0238k(String str, C0151f c0151f) {
        this.f365b = str;
        if (f363c || c0151f.m21432d() != null) {
            this.f364a = c0151f.m21432d();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public C0237j m21238a() {
        return this.f364a;
    }

    /* renamed from: b */
    public String m21237b() {
        return this.f365b;
    }
}
