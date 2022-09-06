package com.p078a.p079a;
/* renamed from: com.a.a.m */
/* loaded from: classes.dex */
public final class C0736m implements AbstractC0724c {

    /* renamed from: a */
    private static final C0721ab f1817a = new C0721ab(44225);

    /* renamed from: b */
    private byte[] f1818b;

    /* renamed from: c */
    private byte[] f1819c;

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: a */
    public C0721ab mo19165a() {
        return f1817a;
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: a */
    public void mo19164a(byte[] bArr, int i, int i2) {
        this.f1818b = new byte[i2];
        System.arraycopy(bArr, i, this.f1818b, 0, i2);
    }

    @Override // com.p078a.p079a.AbstractC0724c
    /* renamed from: b */
    public void mo19217b(byte[] bArr, int i, int i2) {
        this.f1819c = new byte[i2];
        System.arraycopy(bArr, i, this.f1819c, 0, i2);
        if (this.f1818b == null) {
            mo19164a(bArr, i, i2);
        }
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: c */
    public byte[] mo19163c() {
        return this.f1819c == null ? mo19161e() : AbstractC0722ac.m19269a(this.f1819c);
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: d */
    public C0721ab mo19162d() {
        return this.f1819c == null ? mo19160f() : new C0721ab(this.f1819c.length);
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: e */
    public byte[] mo19161e() {
        return AbstractC0722ac.m19269a(this.f1818b);
    }

    @Override // com.p078a.p079a.AbstractC0749x
    /* renamed from: f */
    public C0721ab mo19160f() {
        return new C0721ab(this.f1818b == null ? 0 : this.f1818b.length);
    }
}
