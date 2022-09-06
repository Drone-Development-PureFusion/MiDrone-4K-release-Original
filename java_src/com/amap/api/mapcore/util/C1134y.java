package com.amap.api.mapcore.util;
/* renamed from: com.amap.api.mapcore.util.y */
/* loaded from: classes.dex */
public class C1134y extends AbstractC1133x {

    /* renamed from: i */
    private float f3563i;

    /* renamed from: j */
    private float f3564j;

    public C1134y() {
        mo17437a();
    }

    @Override // com.amap.api.mapcore.util.AbstractC1133x
    /* renamed from: a */
    public void mo17437a() {
        super.mo17437a();
        this.f3563i = 0.0f;
        this.f3564j = 0.0f;
    }

    /* renamed from: c */
    public void m17442c(float f) {
        this.f3563i = f;
        this.f3561g = true;
        this.f3559e = false;
    }

    @Override // com.amap.api.mapcore.util.AbstractC1133x
    /* renamed from: d */
    public void mo17434d() {
        this.f3560f = false;
        if (this.f3561g && this.f3562h && Math.abs(this.f3564j - this.f3563i) > 1.0E-4d) {
            this.f3560f = true;
        }
        this.f3559e = true;
    }

    /* renamed from: d */
    public void m17441d(float f) {
        this.f3564j = f;
        this.f3562h = true;
        this.f3559e = false;
    }

    /* renamed from: e */
    public float m17440e() {
        return this.f3563i;
    }

    /* renamed from: f */
    public float m17439f() {
        return this.f3564j;
    }

    /* renamed from: g */
    public float m17438g() {
        return this.f3563i + ((this.f3564j - this.f3563i) * this.f3558d);
    }
}
