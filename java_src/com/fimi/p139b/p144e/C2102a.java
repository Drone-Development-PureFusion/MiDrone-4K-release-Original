package com.fimi.p139b.p144e;
/* renamed from: com.fimi.b.e.a */
/* loaded from: classes.dex */
public class C2102a {

    /* renamed from: a */
    private static final int f7019a = 0;

    /* renamed from: b */
    private int f7020b;

    public C2102a() {
        m13729a();
    }

    /* renamed from: a */
    public void m13729a() {
        this.f7020b = 0;
    }

    /* renamed from: a */
    public void m13728a(int i) {
        this.f7020b = ((i & 255) + this.f7020b) % 65535;
    }

    /* renamed from: b */
    public int m13727b() {
        return (this.f7020b >> 8) & 255;
    }

    /* renamed from: b */
    public void m13726b(int i) {
        int i2 = (i & 255) ^ (this.f7020b & 255);
        int i3 = i2 ^ ((i2 << 4) & 255);
        this.f7020b = ((i3 >> 4) & 15) ^ ((((this.f7020b >> 8) & 255) ^ (i3 << 8)) ^ (i3 << 3));
    }

    /* renamed from: c */
    public int m13725c() {
        return this.f7020b & 255;
    }
}
