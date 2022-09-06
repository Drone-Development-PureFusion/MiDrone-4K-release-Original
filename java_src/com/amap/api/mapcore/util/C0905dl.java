package com.amap.api.mapcore.util;
/* renamed from: com.amap.api.mapcore.util.dl */
/* loaded from: classes.dex */
public class C0905dl extends C0902di {

    /* renamed from: a */
    public float f2763a;

    /* renamed from: b */
    public float f2764b;

    /* renamed from: c */
    public float f2765c = 0.0f;

    /* renamed from: w */
    private float f2766w = 0.0f;

    /* renamed from: x */
    private float f2767x = 0.0f;

    /* renamed from: y */
    private float f2768y;

    /* renamed from: z */
    private float f2769z;

    public C0905dl(float f, float f2, float f3, float f4, float f5) {
        this.f2763a = 0.0f;
        this.f2764b = 1.0f;
        this.f2763a = f;
        this.f2764b = f2;
    }

    @Override // com.amap.api.mapcore.util.C0902di
    /* renamed from: a */
    protected void mo18508a(float f, C0907dn c0907dn) {
        float f2 = this.f2763a + ((this.f2764b - this.f2763a) * f);
        e();
        this.f2765c = f2;
        if (this.f2768y == 0.0f && this.f2769z == 0.0f) {
            c0907dn.f2783d = f2;
        } else {
            c0907dn.f2783d = f2;
        }
    }
}
