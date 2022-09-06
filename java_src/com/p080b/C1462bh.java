package com.p080b;

import java.util.Locale;
/* renamed from: com.b.bh */
/* loaded from: classes.dex */
public class C1462bh {

    /* renamed from: a */
    private String f5079a;

    /* renamed from: b */
    private int f5080b;

    /* renamed from: c */
    private String f5081c;

    /* renamed from: d */
    private long f5082d;

    public C1462bh(String str, long j, int i, String str2) {
        this.f5079a = str;
        this.f5082d = j;
        this.f5080b = i;
        this.f5081c = str2;
    }

    /* renamed from: a */
    public String m16092a() {
        return this.f5079a;
    }

    /* renamed from: b */
    public int m16091b() {
        return this.f5080b;
    }

    public String toString() {
        return String.format(Locale.US, "##h=%s, n=%d, t=%d, ex=%s##", this.f5079a, Integer.valueOf(this.f5080b), Long.valueOf(this.f5082d), this.f5081c);
    }
}
