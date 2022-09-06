package com.fimi.p148e.p149a;

import com.fimi.p139b.p144e.AbstractC2103b;
import com.fimi.p139b.p144e.C2104c;
import com.fimi.p139b.p144e.C2105d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.e.a.f */
/* loaded from: classes.dex */
public class C2127f extends AbstractC2103b {

    /* renamed from: a */
    private short f7123a;

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    /* renamed from: a */
    public void mo13475a(C2105d c2105d) {
        c2105d.m13688c();
        a(c2105d.m13686d());
        m13547a(c2105d.m13685e());
        a(c2105d.m13686d() == 0);
    }

    /* renamed from: a */
    public void m13547a(short s) {
        this.f7123a = s;
    }

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    /* renamed from: g */
    public C2104c mo13473g() {
        return null;
    }

    /* renamed from: h */
    public short m13546h() {
        return this.f7123a;
    }

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    public String toString() {
        return "UpgradeC9Response{sequence=" + ((int) this.f7123a) + C0359h.f726w;
    }
}
