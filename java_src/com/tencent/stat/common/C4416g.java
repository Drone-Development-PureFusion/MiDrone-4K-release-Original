package com.tencent.stat.common;
/* renamed from: com.tencent.stat.common.g */
/* loaded from: classes2.dex */
public class C4416g {

    /* renamed from: a */
    static final /* synthetic */ boolean f18438a;

    static {
        f18438a = !C4416g.class.desiredAssertionStatus();
    }

    private C4416g() {
    }

    /* renamed from: a */
    public static byte[] m5218a(byte[] bArr, int i) {
        return m5217a(bArr, 0, bArr.length, i);
    }

    /* renamed from: a */
    public static byte[] m5217a(byte[] bArr, int i, int i2, int i3) {
        C4418i c4418i = new C4418i(i3, new byte[(i2 * 3) / 4]);
        if (!c4418i.m5214a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        if (c4418i.f18440b == c4418i.f18439a.length) {
            return c4418i.f18439a;
        }
        byte[] bArr2 = new byte[c4418i.f18440b];
        System.arraycopy(c4418i.f18439a, 0, bArr2, 0, c4418i.f18440b);
        return bArr2;
    }

    /* renamed from: b */
    public static byte[] m5216b(byte[] bArr, int i) {
        return m5215b(bArr, 0, bArr.length, i);
    }

    /* renamed from: b */
    public static byte[] m5215b(byte[] bArr, int i, int i2, int i3) {
        C4419j c4419j = new C4419j(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!c4419j.f18450d) {
            switch (i2 % 3) {
                case 1:
                    i4 += 2;
                    break;
                case 2:
                    i4 += 3;
                    break;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (c4419j.f18451e && i2 > 0) {
            i4 += (c4419j.f18452f ? 2 : 1) * (((i2 - 1) / 57) + 1);
        }
        c4419j.f18439a = new byte[i4];
        c4419j.m5213a(bArr, i, i2, true);
        if (f18438a || c4419j.f18440b == i4) {
            return c4419j.f18439a;
        }
        throw new AssertionError();
    }
}
