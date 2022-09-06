package com.fimi.p148e.p149a;

import com.fimi.p139b.p144e.AbstractC2103b;
import com.fimi.p139b.p144e.C2104c;
import com.fimi.p139b.p144e.C2105d;
import java.util.Arrays;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.e.a.d */
/* loaded from: classes.dex */
public class C2125d extends AbstractC2103b {

    /* renamed from: a */
    private int f7117a;

    /* renamed from: b */
    private int f7118b;

    /* renamed from: c */
    private int f7119c;

    /* renamed from: d */
    private byte[] f7120d = new byte[4];

    /* renamed from: e */
    private byte[] f7121e = new byte[4];

    /* renamed from: f */
    private byte[] f7122f = new byte[4];

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    /* renamed from: a */
    public void mo13475a(C2105d c2105d) {
        c2105d.m13688c();
        a(c2105d.m13686d());
        m13554g(c2105d.m13686d());
        m13556e(c2105d.m13685e());
        m13555f(c2105d.m13685e());
        this.f7120d[0] = c2105d.m13686d();
        this.f7120d[1] = c2105d.m13686d();
        this.f7120d[2] = c2105d.m13686d();
        this.f7120d[3] = c2105d.m13686d();
        this.f7121e[0] = c2105d.m13686d();
        this.f7121e[1] = c2105d.m13686d();
        this.f7121e[2] = c2105d.m13686d();
        this.f7121e[3] = c2105d.m13686d();
        this.f7122f[0] = c2105d.m13686d();
        this.f7122f[1] = c2105d.m13686d();
        this.f7122f[2] = c2105d.m13686d();
        this.f7122f[3] = c2105d.m13686d();
    }

    /* renamed from: e */
    public void m13556e(int i) {
        this.f7118b = i;
    }

    /* renamed from: f */
    public void m13555f(int i) {
        this.f7119c = i;
    }

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    /* renamed from: g */
    public C2104c mo13473g() {
        return null;
    }

    /* renamed from: g */
    public void m13554g(int i) {
        this.f7117a = i;
    }

    /* renamed from: h */
    public byte[] m13553h() {
        return this.f7120d;
    }

    /* renamed from: i */
    public byte[] m13552i() {
        return this.f7121e;
    }

    /* renamed from: j */
    public byte[] m13551j() {
        return this.f7122f;
    }

    /* renamed from: k */
    public int m13550k() {
        return this.f7118b;
    }

    /* renamed from: l */
    public int m13549l() {
        return this.f7119c;
    }

    /* renamed from: m */
    public int m13548m() {
        return this.f7117a;
    }

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    public String toString() {
        return "UpgradeC1Response{model=" + this.f7117a + ", hardwareVersion=" + this.f7118b + ", softwareVersion=" + this.f7119c + ", idA=" + Arrays.toString(this.f7120d) + ", idB=" + Arrays.toString(this.f7121e) + ", idC=" + Arrays.toString(this.f7122f) + C0359h.f726w;
    }
}
