package com.fimi.kernel.p156a;

import com.xiaomi.mipush.sdk.Constants;
/* renamed from: com.fimi.kernel.a.e */
/* loaded from: classes.dex */
public class C2177e {

    /* renamed from: a */
    public double f7311a;

    /* renamed from: b */
    public double f7312b;

    public C2177e() {
    }

    public C2177e(double d, double d2) {
        this.f7311a = d;
        this.f7312b = d2;
    }

    public boolean equals(Object obj) {
        C2177e c2177e = (C2177e) obj;
        return this.f7311a == c2177e.f7311a && this.f7312b == c2177e.f7312b;
    }

    public int hashCode() {
        return ((int) (this.f7311a * this.f7312b)) ^ 8;
    }

    public String toString() {
        return "(" + this.f7311a + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f7312b + ")";
    }
}
