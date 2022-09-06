package com.amap.api.mapcore.util;
/* renamed from: com.amap.api.mapcore.util.z */
/* loaded from: classes.dex */
public class C1135z extends AbstractC1133x {

    /* renamed from: i */
    public float f3565i;

    /* renamed from: j */
    public float f3566j;

    /* renamed from: k */
    public float f3567k;

    /* renamed from: l */
    public float f3568l;

    public C1135z() {
        mo17437a();
    }

    @Override // com.amap.api.mapcore.util.AbstractC1133x
    /* renamed from: a */
    public void mo17437a() {
        super.mo17437a();
        this.f3565i = 0.0f;
        this.f3566j = 0.0f;
        this.f3567k = 0.0f;
        this.f3568l = 0.0f;
    }

    /* renamed from: a */
    public void m17436a(float f, float f2) {
        this.f3565i = f;
        this.f3567k = f2;
        this.f3561g = true;
        this.f3559e = false;
    }

    /* renamed from: b */
    public void m17435b(float f, float f2) {
        this.f3566j = f;
        this.f3568l = f2;
        this.f3562h = true;
        this.f3559e = false;
    }

    @Override // com.amap.api.mapcore.util.AbstractC1133x
    /* renamed from: d */
    public void mo17434d() {
        this.f3560f = false;
        if (this.f3561g && this.f3562h) {
            float f = this.f3566j - this.f3565i;
            float f2 = this.f3568l - this.f3567k;
            if (Math.abs(f) > 1.0E-4d || Math.abs(f2) > 1.0E-4d) {
                this.f3560f = true;
            }
        }
        this.f3559e = true;
    }

    /* renamed from: e */
    public float m17433e() {
        return this.f3565i;
    }

    /* renamed from: f */
    public float m17432f() {
        return this.f3567k;
    }

    /* renamed from: g */
    public float m17431g() {
        return this.f3566j;
    }

    /* renamed from: h */
    public float m17430h() {
        return this.f3568l;
    }

    /* renamed from: i */
    public float m17429i() {
        return this.f3565i + ((this.f3566j - this.f3565i) * this.f3558d);
    }

    /* renamed from: j */
    public float m17428j() {
        return this.f3567k + ((this.f3568l - this.f3567k) * this.f3558d);
    }
}
