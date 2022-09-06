package com.fimi.p148e.p149a;

import com.fimi.p139b.p144e.AbstractC2103b;
import com.fimi.p139b.p144e.C2104c;
import com.fimi.p139b.p144e.C2105d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.e.a.i */
/* loaded from: classes.dex */
public class C2130i extends AbstractC2103b {

    /* renamed from: a */
    private byte f7125a;

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    /* renamed from: a */
    public void mo13475a(C2105d c2105d) {
        c2105d.m13688c();
        a(c2105d.m13686d());
        m13543b(c2105d.m13686d());
        a(c2105d.m13686d() == 0);
    }

    /* renamed from: b */
    public void m13543b(byte b) {
        this.f7125a = b;
    }

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    /* renamed from: g */
    public C2104c mo13473g() {
        return null;
    }

    /* renamed from: h */
    public byte m13542h() {
        return this.f7125a;
    }

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    public String toString() {
        return "UpgradeCcResponse{newState=" + ((int) this.f7125a) + C0359h.f726w;
    }
}
