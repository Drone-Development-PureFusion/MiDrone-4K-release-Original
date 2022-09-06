package com.android.volley;
/* renamed from: com.android.volley.d */
/* loaded from: classes.dex */
public class C1321d implements AbstractC1345r {

    /* renamed from: a */
    public static final int f4545a = 2500;

    /* renamed from: b */
    public static final int f4546b = 0;

    /* renamed from: c */
    public static final float f4547c = 1.0f;

    /* renamed from: d */
    private int f4548d;

    /* renamed from: e */
    private int f4549e;

    /* renamed from: f */
    private final int f4550f;

    /* renamed from: g */
    private final float f4551g;

    public C1321d() {
        this(f4545a, 0, 1.0f);
    }

    public C1321d(int i, int i2, float f) {
        this.f4548d = i;
        this.f4550f = i2;
        this.f4551g = f;
    }

    @Override // com.android.volley.AbstractC1345r
    /* renamed from: a */
    public int mo16683a() {
        return this.f4548d;
    }

    @Override // com.android.volley.AbstractC1345r
    /* renamed from: a */
    public void mo16682a(C1384u c1384u) {
        this.f4549e++;
        this.f4548d = (int) (this.f4548d + (this.f4548d * this.f4551g));
        if (!m16743d()) {
            throw c1384u;
        }
    }

    @Override // com.android.volley.AbstractC1345r
    /* renamed from: b */
    public int mo16681b() {
        return this.f4549e;
    }

    /* renamed from: c */
    public float m16744c() {
        return this.f4551g;
    }

    /* renamed from: d */
    protected boolean m16743d() {
        return this.f4549e <= this.f4550f;
    }
}
