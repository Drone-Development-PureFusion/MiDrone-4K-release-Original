package com.amap.api.mapcore.util;
/* renamed from: com.amap.api.mapcore.util.dm */
/* loaded from: classes.dex */
public class C0906dm extends C0902di {

    /* renamed from: a */
    private float f2773a;

    /* renamed from: b */
    private float f2774b;

    /* renamed from: c */
    private float f2775c;

    /* renamed from: w */
    private float f2776w;

    /* renamed from: x */
    private int f2777x = 0;

    /* renamed from: y */
    private int f2778y = 0;

    /* renamed from: z */
    private int f2779z = 0;

    /* renamed from: A */
    private int f2770A = 0;

    /* renamed from: B */
    private float f2771B = 0.0f;

    /* renamed from: C */
    private float f2772C = 0.0f;

    public C0906dm(float f, float f2, float f3, float f4) {
        this.f2773a = f;
        this.f2774b = f2;
        this.f2775c = f3;
        this.f2776w = f4;
    }

    @Override // com.amap.api.mapcore.util.C0902di
    /* renamed from: a */
    protected void mo18508a(float f, C0907dn c0907dn) {
        float f2 = 1.0f;
        e();
        float f3 = (this.f2773a == 1.0f && this.f2774b == 1.0f) ? 1.0f : this.f2773a + ((this.f2774b - this.f2773a) * f);
        if (this.f2775c != 1.0f || this.f2776w != 1.0f) {
            f2 = this.f2775c + ((this.f2776w - this.f2775c) * f);
        }
        if (this.f2771B == 0.0f && this.f2772C == 0.0f) {
            c0907dn.f2784e = f3;
            c0907dn.f2785f = f2;
            return;
        }
        c0907dn.f2784e = f3;
        c0907dn.f2785f = f2;
    }
}
