package com.google.p217a.p218a;
/* renamed from: com.google.a.a.a */
/* loaded from: classes.dex */
public final class C3990a {

    /* renamed from: a */
    public static final C3990a f17056a = new C3990a(new byte[0]);

    /* renamed from: b */
    private final byte[] f17057b;

    /* renamed from: c */
    private volatile int f17058c = 0;

    private C3990a(byte[] bArr) {
        this.f17057b = bArr;
    }

    /* renamed from: a */
    public static C3990a m6308a(byte[] bArr) {
        return m6307a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static C3990a m6307a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new C3990a(bArr2);
    }

    /* renamed from: a */
    public int m6309a() {
        return this.f17057b.length;
    }

    /* renamed from: b */
    public byte[] m6306b() {
        int length = this.f17057b.length;
        byte[] bArr = new byte[length];
        System.arraycopy(this.f17057b, 0, bArr, 0, length);
        return bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3990a)) {
            return false;
        }
        C3990a c3990a = (C3990a) obj;
        int length = this.f17057b.length;
        if (length != c3990a.f17057b.length) {
            return false;
        }
        byte[] bArr = this.f17057b;
        byte[] bArr2 = c3990a.f17057b;
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f17058c;
        if (i == 0) {
            byte[] bArr = this.f17057b;
            int length = this.f17057b.length;
            int i2 = 0;
            i = length;
            while (i2 < length) {
                i2++;
                i = bArr[i2] + (i * 31);
            }
            if (i == 0) {
                i = 1;
            }
            this.f17058c = i;
        }
        return i;
    }
}
