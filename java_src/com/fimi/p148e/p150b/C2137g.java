package com.fimi.p148e.p150b;

import com.fimi.p139b.p144e.AbstractC2103b;
import com.fimi.p139b.p144e.C2104c;
import com.fimi.p139b.p144e.C2105d;
/* renamed from: com.fimi.e.b.g */
/* loaded from: classes.dex */
public class C2137g extends AbstractC2103b {

    /* renamed from: a */
    public static final int f7169a = 204;

    /* renamed from: b */
    private final int f7170b = 2;

    /* renamed from: c */
    private byte f7171c;

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    /* renamed from: a */
    public void mo13475a(C2105d c2105d) {
        c2105d.m13688c();
    }

    /* renamed from: b */
    public void m13474b(byte b) {
        this.f7171c = b;
    }

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    /* renamed from: g */
    public C2104c mo13473g() {
        C2104c c2104c = new C2104c();
        c2104c.m13711a(2, e(), f(), c(), d());
        c2104c.f7028b.m13691b(b());
        c2104c.f7028b.m13691b(this.f7171c);
        return c2104c;
    }

    /* renamed from: h */
    public byte m13472h() {
        return this.f7171c;
    }
}
