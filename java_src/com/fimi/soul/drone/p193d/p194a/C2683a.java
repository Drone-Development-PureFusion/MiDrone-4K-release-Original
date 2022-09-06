package com.fimi.soul.drone.p193d.p194a;
/* renamed from: com.fimi.soul.drone.d.a.a */
/* loaded from: classes.dex */
public class C2683a {

    /* renamed from: a */
    private static final int f9604a = 0;

    /* renamed from: b */
    private int f9605b;

    public C2683a() {
        m11191a();
    }

    /* renamed from: a */
    public void m11191a() {
        this.f9605b = 0;
    }

    /* renamed from: a */
    public void m11190a(int i) {
        this.f9605b = ((i & 255) + this.f9605b) % 65535;
    }

    /* renamed from: b */
    public int m11189b() {
        return (this.f9605b >> 8) & 255;
    }

    /* renamed from: b */
    public void m11188b(int i) {
        int i2 = (i & 255) ^ (this.f9605b & 255);
        int i3 = i2 ^ ((i2 << 4) & 255);
        this.f9605b = ((i3 >> 4) & 15) ^ ((((this.f9605b >> 8) & 255) ^ (i3 << 8)) ^ (i3 << 3));
    }

    /* renamed from: c */
    public int m11187c() {
        return this.f9605b & 255;
    }
}
