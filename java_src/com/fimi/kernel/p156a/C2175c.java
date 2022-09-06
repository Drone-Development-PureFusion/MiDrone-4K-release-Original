package com.fimi.kernel.p156a;

import android.graphics.drawable.Drawable;
/* renamed from: com.fimi.kernel.a.c */
/* loaded from: classes.dex */
public class C2175c implements Comparable<C2175c> {

    /* renamed from: a */
    public String f7298a;

    /* renamed from: b */
    public String f7299b;

    /* renamed from: c */
    public int f7300c;

    /* renamed from: d */
    public int f7301d;

    /* renamed from: e */
    public Drawable f7302e;

    /* renamed from: f */
    public long f7303f;

    /* renamed from: g */
    public String f7304g;

    /* renamed from: h */
    public String f7305h;

    /* renamed from: i */
    public String f7306i;

    public C2175c() {
    }

    public C2175c(String str, int i, int i2) {
        this.f7299b = str;
        this.f7300c = i;
        this.f7301d = i2;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(C2175c c2175c) {
        if (this.f7299b.compareTo(c2175c.f7299b) == 0) {
            if (this.f7303f < c2175c.f7303f) {
                return 1;
            }
            return this.f7303f == c2175c.f7303f ? 0 : -1;
        }
        return this.f7299b.compareTo(c2175c.f7299b);
    }
}
