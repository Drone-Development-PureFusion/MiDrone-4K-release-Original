package org.p248a.p283b.p286c;
/* renamed from: org.a.b.c.c */
/* loaded from: classes2.dex */
public final class C5384c extends AbstractC5385d {

    /* renamed from: a */
    private byte[] f22459a;

    /* renamed from: b */
    private int f22460b;

    /* renamed from: c */
    private int f22461c;

    @Override // org.p248a.p283b.p286c.AbstractC5385d
    /* renamed from: a */
    public int mo1215a(byte[] bArr, int i, int i2) {
        int mo1212c = mo1212c();
        if (i2 > mo1212c) {
            i2 = mo1212c;
        }
        if (i2 > 0) {
            System.arraycopy(this.f22459a, this.f22460b, bArr, i, i2);
            mo1216a(i2);
        }
        return i2;
    }

    @Override // org.p248a.p283b.p286c.AbstractC5385d
    /* renamed from: a */
    public void mo1216a(int i) {
        this.f22460b += i;
    }

    /* renamed from: a */
    public void m1219a(byte[] bArr) {
        m1218c(bArr, 0, bArr.length);
    }

    @Override // org.p248a.p283b.p286c.AbstractC5385d
    /* renamed from: a */
    public byte[] mo1217a() {
        return this.f22459a;
    }

    @Override // org.p248a.p283b.p286c.AbstractC5385d
    /* renamed from: b */
    public int mo1214b() {
        return this.f22460b;
    }

    @Override // org.p248a.p283b.p286c.AbstractC5385d
    /* renamed from: b */
    public void mo1213b(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // org.p248a.p283b.p286c.AbstractC5385d
    /* renamed from: c */
    public int mo1212c() {
        return this.f22461c - this.f22460b;
    }

    /* renamed from: c */
    public void m1218c(byte[] bArr, int i, int i2) {
        this.f22459a = bArr;
        this.f22460b = i;
        this.f22461c = i + i2;
    }
}
