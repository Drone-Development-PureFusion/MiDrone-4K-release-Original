package com.amap.api.mapcore.util;
/* renamed from: com.amap.api.mapcore.util.eg */
/* loaded from: classes.dex */
public class C0944eg {

    /* renamed from: a */
    public short[] f2897a;

    /* renamed from: b */
    public int f2898b;

    /* renamed from: c */
    public boolean f2899c;

    public C0944eg() {
        this(true, 16);
    }

    public C0944eg(boolean z, int i) {
        this.f2899c = z;
        this.f2897a = new short[i];
    }

    /* renamed from: a */
    public short m18370a(int i) {
        if (i >= this.f2898b) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.f2898b);
        }
        return this.f2897a[i];
    }

    /* renamed from: a */
    public void m18371a() {
        this.f2898b = 0;
    }

    /* renamed from: a */
    public void m18369a(short s) {
        short[] sArr = this.f2897a;
        if (this.f2898b == sArr.length) {
            sArr = m18366d(Math.max(8, (int) (this.f2898b * 1.75f)));
        }
        int i = this.f2898b;
        this.f2898b = i + 1;
        sArr[i] = s;
    }

    /* renamed from: b */
    public short m18368b(int i) {
        if (i >= this.f2898b) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.f2898b);
        }
        short[] sArr = this.f2897a;
        short s = sArr[i];
        this.f2898b--;
        if (this.f2899c) {
            System.arraycopy(sArr, i + 1, sArr, i, this.f2898b - i);
        } else {
            sArr[i] = sArr[this.f2898b];
        }
        return s;
    }

    /* renamed from: c */
    public short[] m18367c(int i) {
        int i2 = this.f2898b + i;
        if (i2 > this.f2897a.length) {
            m18366d(Math.max(8, i2));
        }
        return this.f2897a;
    }

    /* renamed from: d */
    protected short[] m18366d(int i) {
        short[] sArr = new short[i];
        System.arraycopy(this.f2897a, 0, sArr, 0, Math.min(this.f2898b, sArr.length));
        this.f2897a = sArr;
        return sArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0944eg)) {
            return false;
        }
        C0944eg c0944eg = (C0944eg) obj;
        int i = this.f2898b;
        if (i != c0944eg.f2898b) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f2897a[i2] != c0944eg.f2897a[i2]) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        if (this.f2898b == 0) {
            return "[]";
        }
        short[] sArr = this.f2897a;
        StringBuilder sb = new StringBuilder(32);
        sb.append('[');
        sb.append((int) sArr[0]);
        for (int i = 1; i < this.f2898b; i++) {
            sb.append(", ");
            sb.append((int) sArr[i]);
        }
        sb.append(']');
        return sb.toString();
    }
}
