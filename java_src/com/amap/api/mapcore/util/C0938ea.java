package com.amap.api.mapcore.util;
/* renamed from: com.amap.api.mapcore.util.ea */
/* loaded from: classes.dex */
public class C0938ea {

    /* renamed from: a */
    public int[] f2881a;

    /* renamed from: b */
    public int f2882b;

    /* renamed from: c */
    public boolean f2883c;

    public C0938ea() {
        this(true, 16);
    }

    public C0938ea(boolean z, int i) {
        this.f2883c = z;
        this.f2881a = new int[i];
    }

    /* renamed from: a */
    public void m18396a() {
        this.f2882b = 0;
    }

    /* renamed from: a */
    public void m18395a(int i) {
        int[] iArr = this.f2881a;
        if (this.f2882b == iArr.length) {
            iArr = m18392d(Math.max(8, (int) (this.f2882b * 1.75f)));
        }
        int i2 = this.f2882b;
        this.f2882b = i2 + 1;
        iArr[i2] = i;
    }

    /* renamed from: b */
    public int m18394b(int i) {
        if (i >= this.f2882b) {
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.f2882b);
        }
        int[] iArr = this.f2881a;
        int i2 = iArr[i];
        this.f2882b--;
        if (this.f2883c) {
            System.arraycopy(iArr, i + 1, iArr, i, this.f2882b - i);
        } else {
            iArr[i] = iArr[this.f2882b];
        }
        return i2;
    }

    /* renamed from: c */
    public int[] m18393c(int i) {
        int i2 = this.f2882b + i;
        if (i2 > this.f2881a.length) {
            m18392d(Math.max(8, i2));
        }
        return this.f2881a;
    }

    /* renamed from: d */
    protected int[] m18392d(int i) {
        int[] iArr = new int[i];
        System.arraycopy(this.f2881a, 0, iArr, 0, Math.min(this.f2882b, iArr.length));
        this.f2881a = iArr;
        return iArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0938ea)) {
            return false;
        }
        C0938ea c0938ea = (C0938ea) obj;
        int i = this.f2882b;
        if (i != c0938ea.f2882b) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f2881a[i2] != c0938ea.f2881a[i2]) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        if (this.f2882b == 0) {
            return "[]";
        }
        int[] iArr = this.f2881a;
        StringBuilder sb = new StringBuilder(32);
        sb.append('[');
        sb.append(iArr[0]);
        for (int i = 1; i < this.f2882b; i++) {
            sb.append(", ");
            sb.append(iArr[i]);
        }
        sb.append(']');
        return sb.toString();
    }
}
