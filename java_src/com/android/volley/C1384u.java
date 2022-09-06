package com.android.volley;
/* renamed from: com.android.volley.u */
/* loaded from: classes.dex */
public class C1384u extends Exception {

    /* renamed from: a */
    public final C1329j f4715a;

    /* renamed from: b */
    private long f4716b;

    public C1384u() {
        this.f4715a = null;
    }

    public C1384u(C1329j c1329j) {
        this.f4715a = c1329j;
    }

    public C1384u(String str) {
        super(str);
        this.f4715a = null;
    }

    public C1384u(String str, Throwable th) {
        super(str, th);
        this.f4715a = null;
    }

    public C1384u(Throwable th) {
        super(th);
        this.f4715a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m16570a(long j) {
        this.f4716b = j;
    }

    /* renamed from: b */
    public long m16569b() {
        return this.f4716b;
    }
}
