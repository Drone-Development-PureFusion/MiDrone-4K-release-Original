package com.fimi.p148e.p149a;

import com.fimi.p139b.p144e.AbstractC2103b;
import com.fimi.p139b.p144e.C2104c;
import com.fimi.p139b.p144e.C2105d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.e.a.c */
/* loaded from: classes.dex */
public class C2124c extends AbstractC2103b {

    /* renamed from: a */
    public static final int f7099a = 25;

    /* renamed from: b */
    private int f7100b = 10;

    /* renamed from: c */
    private byte f7101c;

    /* renamed from: d */
    private byte f7102d;

    /* renamed from: e */
    private byte f7103e;

    /* renamed from: f */
    private byte f7104f;

    /* renamed from: g */
    private byte f7105g;

    /* renamed from: h */
    private byte f7106h;

    /* renamed from: i */
    private byte f7107i;

    /* renamed from: j */
    private byte f7108j;

    /* renamed from: k */
    private byte f7109k;

    /* renamed from: l */
    private byte f7110l;

    /* renamed from: m */
    private byte f7111m;

    /* renamed from: n */
    private byte f7112n;

    /* renamed from: o */
    private byte f7113o;

    /* renamed from: p */
    private byte f7114p;

    /* renamed from: q */
    private byte f7115q;

    /* renamed from: r */
    private byte f7116r;

    /* renamed from: A */
    public byte m13592A() {
        return (byte) (this.f7114p | (this.f7115q << 1) | (this.f7116r << 2));
    }

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    /* renamed from: a */
    public void mo13475a(C2105d c2105d) {
        c2105d.m13688c();
        m13584h(c2105d.m13686d());
        m13582i(c2105d.m13686d());
        m13580j(c2105d.m13686d());
        m13578k(c2105d.m13686d());
        m13576l(c2105d.m13686d());
        m13574m(c2105d.m13686d());
        m13572n(c2105d.m13686d());
        m13566q(c2105d.m13686d());
        m13585h();
        m13583i();
    }

    /* renamed from: b */
    public void m13591b(byte b) {
        this.f7111m = b;
    }

    /* renamed from: c */
    public void m13590c(byte b) {
        this.f7112n = b;
    }

    /* renamed from: d */
    public void m13589d(byte b) {
        this.f7113o = b;
    }

    /* renamed from: e */
    public void m13588e(byte b) {
        this.f7114p = b;
    }

    /* renamed from: f */
    public void m13587f(byte b) {
        this.f7115q = b;
    }

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    /* renamed from: g */
    public C2104c mo13473g() {
        return null;
    }

    /* renamed from: g */
    public void m13586g(byte b) {
        this.f7116r = b;
    }

    /* renamed from: h */
    public void m13585h() {
        m13591b((byte) ((this.f7103e >> 0) & 1));
        m13590c((byte) ((this.f7103e >> 1) & 1));
        m13589d((byte) ((this.f7103e >> 2) & 1));
    }

    /* renamed from: h */
    public void m13584h(byte b) {
        this.f7101c = b;
    }

    /* renamed from: i */
    public void m13583i() {
        m13588e((byte) ((this.f7110l >> 0) & 1));
        m13587f((byte) ((this.f7110l >> 1) & 1));
        m13586g((byte) ((this.f7110l >> 2) & 1));
    }

    /* renamed from: i */
    public void m13582i(byte b) {
        this.f7102d = b;
    }

    /* renamed from: j */
    public byte m13581j() {
        return this.f7111m;
    }

    /* renamed from: j */
    public void m13580j(byte b) {
        this.f7103e = b;
    }

    /* renamed from: k */
    public byte m13579k() {
        return this.f7112n;
    }

    /* renamed from: k */
    public void m13578k(byte b) {
        this.f7104f = b;
    }

    /* renamed from: l */
    public byte m13577l() {
        return this.f7113o;
    }

    /* renamed from: l */
    public void m13576l(byte b) {
        this.f7105g = b;
    }

    /* renamed from: m */
    public byte m13575m() {
        return this.f7114p;
    }

    /* renamed from: m */
    public void m13574m(byte b) {
        this.f7106h = b;
    }

    /* renamed from: n */
    public byte m13573n() {
        return this.f7115q;
    }

    /* renamed from: n */
    public void m13572n(byte b) {
        this.f7107i = b;
    }

    /* renamed from: o */
    public byte m13571o() {
        return this.f7116r;
    }

    /* renamed from: o */
    public void m13570o(byte b) {
        this.f7108j = b;
    }

    /* renamed from: p */
    public byte m13569p() {
        return this.f7101c;
    }

    /* renamed from: p */
    public void m13568p(byte b) {
        this.f7109k = b;
    }

    /* renamed from: q */
    public byte m13567q() {
        return this.f7102d;
    }

    /* renamed from: q */
    public void m13566q(byte b) {
        this.f7110l = b;
    }

    /* renamed from: r */
    public byte m13565r() {
        return this.f7103e;
    }

    /* renamed from: s */
    public byte m13564s() {
        return this.f7104f;
    }

    /* renamed from: t */
    public byte m13563t() {
        return this.f7105g;
    }

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    public String toString() {
        return "Scene7bResponse{DATALEN=" + this.f7100b + ", cmdId=" + ((int) this.f7101c) + ", scenarios=" + ((int) this.f7102d) + ", follower=" + ((int) this.f7103e) + ", course_x_1=" + ((int) this.f7104f) + ", course_x_2=" + ((int) this.f7105g) + ", cabrage_y_1=" + ((int) this.f7106h) + ", cabrage_y_2=" + ((int) this.f7107i) + ", vRockerVertical=" + ((int) this.f7108j) + ", vRockerHorizontal=" + ((int) this.f7109k) + ", rockerSetting=" + ((int) this.f7110l) + ", followerBit0=" + ((int) this.f7111m) + ", followerBit1=" + ((int) this.f7112n) + ", followerBit2=" + ((int) this.f7113o) + ", rockerSettingBit0=" + ((int) this.f7114p) + ", rockerSettingBit1=" + ((int) this.f7115q) + ", rockerSettingBit2=" + ((int) this.f7116r) + C0359h.f726w;
    }

    /* renamed from: u */
    public byte m13562u() {
        return this.f7106h;
    }

    /* renamed from: v */
    public byte m13561v() {
        return this.f7107i;
    }

    /* renamed from: w */
    public byte m13560w() {
        return this.f7108j;
    }

    /* renamed from: x */
    public byte m13559x() {
        return this.f7109k;
    }

    /* renamed from: y */
    public byte m13558y() {
        return this.f7110l;
    }

    /* renamed from: z */
    public byte m13557z() {
        return (byte) (this.f7111m | (this.f7112n << 1) | (this.f7113o << 2));
    }
}
