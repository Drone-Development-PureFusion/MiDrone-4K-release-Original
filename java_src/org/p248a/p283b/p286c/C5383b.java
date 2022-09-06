package org.p248a.p283b.p286c;

import org.p248a.p283b.C5387d;
/* renamed from: org.a.b.c.b */
/* loaded from: classes2.dex */
public class C5383b extends AbstractC5385d {

    /* renamed from: a */
    private C5387d f22457a;

    /* renamed from: b */
    private int f22458b;

    public C5383b(int i) {
        this.f22457a = new C5387d(i);
    }

    @Override // org.p248a.p283b.p286c.AbstractC5385d
    /* renamed from: a */
    public int mo1215a(byte[] bArr, int i, int i2) {
        byte[] m1210a = this.f22457a.m1210a();
        if (i2 > this.f22457a.m1209b() - this.f22458b) {
            i2 = this.f22457a.m1209b() - this.f22458b;
        }
        if (i2 > 0) {
            System.arraycopy(m1210a, this.f22458b, bArr, i, i2);
            this.f22458b += i2;
        }
        return i2;
    }

    @Override // org.p248a.p283b.p286c.AbstractC5385d
    /* renamed from: b */
    public void mo1213b(byte[] bArr, int i, int i2) {
        this.f22457a.write(bArr, i, i2);
    }

    /* renamed from: m_ */
    public int m1220m_() {
        return this.f22457a.size();
    }
}
