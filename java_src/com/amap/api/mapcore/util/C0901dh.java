package com.amap.api.mapcore.util;
/* renamed from: com.amap.api.mapcore.util.dh */
/* loaded from: classes.dex */
public class C0901dh extends C0902di {

    /* renamed from: a */
    public float f2728a;

    /* renamed from: b */
    public float f2729b;

    /* renamed from: c */
    public float f2730c = 0.0f;

    public C0901dh(float f, float f2) {
        this.f2728a = 0.0f;
        this.f2729b = 1.0f;
        this.f2728a = f;
        this.f2729b = f2;
    }

    @Override // com.amap.api.mapcore.util.C0902di
    /* renamed from: a */
    protected void mo18508a(float f, C0907dn c0907dn) {
        float f2 = this.f2728a;
        this.f2730c = f2 + ((this.f2729b - f2) * f);
        c0907dn.f2782c = this.f2730c;
    }
}
