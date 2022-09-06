package org.p248a.p283b.p286c;
/* renamed from: org.a.b.c.d */
/* loaded from: classes2.dex */
public abstract class AbstractC5385d {
    /* renamed from: a */
    public abstract int mo1215a(byte[] bArr, int i, int i2);

    /* renamed from: a */
    public void mo1216a(int i) {
    }

    /* renamed from: a */
    public byte[] mo1217a() {
        return null;
    }

    /* renamed from: b */
    public int mo1214b() {
        return 0;
    }

    /* renamed from: b */
    public abstract void mo1213b(byte[] bArr, int i, int i2);

    /* renamed from: c */
    public int mo1212c() {
        return -1;
    }

    /* renamed from: d */
    public int m1211d(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int mo1215a = mo1215a(bArr, i + i3, i2 - i3);
            if (mo1215a <= 0) {
                throw new C5386e("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes.");
            }
            i3 += mo1215a;
        }
        return i3;
    }
}
