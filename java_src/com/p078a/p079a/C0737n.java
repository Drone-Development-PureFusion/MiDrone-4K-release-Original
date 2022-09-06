package com.p078a.p079a;
/* renamed from: com.a.a.n */
/* loaded from: classes.dex */
public class C0737n implements AbstractC0724c {

    /* renamed from: a */
    private C0721ab f1820a;

    /* renamed from: b */
    private byte[] f1821b;

    /* renamed from: c */
    private byte[] f1822c;

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: a */
    public C0721ab mo19165a() {
        return this.f1820a;
    }

    /* renamed from: a */
    public void m19228a(C0721ab c0721ab) {
        this.f1820a = c0721ab;
    }

    /* renamed from: a */
    public void m19227a(byte[] bArr) {
        this.f1821b = AbstractC0722ac.m19269a(bArr);
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: a */
    public void mo19164a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        m19227a(bArr2);
    }

    /* renamed from: b */
    public void m19226b(byte[] bArr) {
        this.f1822c = AbstractC0722ac.m19269a(bArr);
    }

    @Override // com.p078a.p079a.AbstractC0724c
    /* renamed from: b */
    public void mo19217b(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        m19226b(bArr2);
        if (this.f1821b == null) {
            m19227a(bArr2);
        }
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: c */
    public byte[] mo19163c() {
        return this.f1822c != null ? AbstractC0722ac.m19269a(this.f1822c) : mo19161e();
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: d */
    public C0721ab mo19162d() {
        return this.f1822c != null ? new C0721ab(this.f1822c.length) : mo19160f();
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: e */
    public byte[] mo19161e() {
        return AbstractC0722ac.m19269a(this.f1821b);
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: f */
    public C0721ab mo19160f() {
        return new C0721ab(this.f1821b.length);
    }
}
