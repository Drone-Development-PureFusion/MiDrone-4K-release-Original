package com.fimi.p148e.p149a;

import com.fimi.p139b.p144e.AbstractC2103b;
import com.fimi.p139b.p144e.C2104c;
import com.fimi.p139b.p144e.C2105d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.e.a.b */
/* loaded from: classes.dex */
public class C2123b extends AbstractC2103b {

    /* renamed from: a */
    public static final int f7093a = 125;

    /* renamed from: b */
    private byte f7094b;

    /* renamed from: c */
    private short f7095c;

    /* renamed from: d */
    private byte f7096d;

    /* renamed from: e */
    private byte f7097e;

    /* renamed from: f */
    private int f7098f;

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    /* renamed from: a */
    public void mo13475a(C2105d c2105d) {
        c2105d.m13688c();
        m13601b(c2105d.m13686d());
        m13602a(c2105d.m13685e());
        m13600c(c2105d.m13686d());
    }

    /* renamed from: a */
    public void m13602a(short s) {
        this.f7095c = s;
        this.f7098f = m13594l();
    }

    /* renamed from: b */
    public void m13601b(byte b) {
        this.f7094b = b;
    }

    /* renamed from: c */
    public void m13600c(byte b) {
        this.f7096d = b;
        m13599d((byte) (b & 1));
    }

    /* renamed from: d */
    public void m13599d(byte b) {
        this.f7097e = b;
    }

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    /* renamed from: g */
    public C2104c mo13473g() {
        return null;
    }

    /* renamed from: h */
    public byte m13598h() {
        return this.f7094b;
    }

    /* renamed from: i */
    public short m13597i() {
        return this.f7095c;
    }

    /* renamed from: j */
    public byte m13596j() {
        return this.f7096d;
    }

    /* renamed from: k */
    public byte m13595k() {
        return this.f7097e;
    }

    /* renamed from: l */
    public int m13594l() {
        if ((this.f7095c & 1) == 1) {
            return 0;
        }
        if (((this.f7095c >> 1) & 1) == 1) {
            return 1;
        }
        if (((this.f7095c >> 9) & 1) == 1) {
            return 9;
        }
        if (((this.f7095c >> 4) & 1) == 1) {
            return 4;
        }
        if (((this.f7095c >> 2) & 1) == 1) {
            return 2;
        }
        if (((this.f7095c >> 3) & 1) == 1) {
            return 3;
        }
        if (((this.f7095c >> 7) & 1) == 1) {
            return 7;
        }
        if (((this.f7095c >> 5) & 1) == 1) {
            return 5;
        }
        if (((this.f7095c >> 6) & 1) == 1) {
            return 6;
        }
        return ((this.f7095c >> 8) & 1) == 1 ? 8 : -1;
    }

    /* renamed from: m */
    public int m13593m() {
        return this.f7098f;
    }

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    public String toString() {
        return "Gimal7DResponse{commadType=" + ((int) this.f7094b) + ", errorCode=" + ((int) this.f7095c) + ", statusCode=" + ((int) this.f7096d) + C0359h.f726w;
    }
}
