package com.fimi.p148e.p150b;

import com.fimi.p139b.p144e.AbstractC2103b;
import com.fimi.p139b.p144e.C2104c;
import com.fimi.p139b.p144e.C2105d;
/* renamed from: com.fimi.e.b.c */
/* loaded from: classes.dex */
public class C2133c extends AbstractC2103b {

    /* renamed from: a */
    public static final int f7156a = 199;

    /* renamed from: b */
    private final int f7157b = 3;

    /* renamed from: c */
    private byte f7158c;

    /* renamed from: d */
    private byte f7159d;

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    /* renamed from: a */
    public void mo13475a(C2105d c2105d) {
    }

    /* renamed from: b */
    public void m13487b(byte b) {
        this.f7158c = b;
    }

    /* renamed from: c */
    public void m13486c(byte b) {
        this.f7159d = b;
    }

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    /* renamed from: g */
    public C2104c mo13473g() {
        C2104c c2104c = new C2104c();
        c2104c.m13711a(3, e(), f(), c(), d());
        c2104c.f7028b.m13691b(b());
        c2104c.f7028b.m13691b(this.f7158c);
        c2104c.f7028b.m13691b(this.f7159d);
        return c2104c;
    }

    /* renamed from: h */
    public byte m13485h() {
        return this.f7158c;
    }

    /* renamed from: i */
    public byte m13484i() {
        return this.f7159d;
    }
}
