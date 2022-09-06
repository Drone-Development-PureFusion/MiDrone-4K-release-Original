package com.fimi.p148e.p150b;

import com.fimi.p139b.p144e.AbstractC2103b;
import com.fimi.p139b.p144e.C2104c;
import com.fimi.p139b.p144e.C2105d;
/* renamed from: com.fimi.e.b.f */
/* loaded from: classes.dex */
public class C2136f extends AbstractC2103b {

    /* renamed from: a */
    public static final int f7166a = 203;

    /* renamed from: b */
    private final int f7167b = 2;

    /* renamed from: c */
    private byte f7168c = 1;

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    /* renamed from: a */
    public void mo13475a(C2105d c2105d) {
        c2105d.m13688c();
    }

    /* renamed from: b */
    public void m13477b(byte b) {
        this.f7168c = b;
    }

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    /* renamed from: g */
    public C2104c mo13473g() {
        C2104c c2104c = new C2104c();
        c2104c.m13711a(2, e(), f(), c(), d());
        c2104c.f7028b.m13691b(b());
        c2104c.f7028b.m13691b(m13476h());
        return c2104c;
    }

    /* renamed from: h */
    public byte m13476h() {
        return this.f7168c;
    }
}
