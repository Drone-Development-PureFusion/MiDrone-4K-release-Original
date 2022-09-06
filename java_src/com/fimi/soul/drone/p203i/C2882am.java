package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2822e;
import com.fimi.soul.utils.C3658ar;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.am */
/* loaded from: classes.dex */
public class C2882am extends C2822e {

    /* renamed from: b */
    private byte f10781b;

    /* renamed from: c */
    private short f10782c;

    /* renamed from: d */
    private short f10783d;

    /* renamed from: e */
    private short f10784e;

    /* renamed from: f */
    private short f10785f;

    /* renamed from: g */
    private short f10786g;

    /* renamed from: h */
    private short f10787h;

    /* renamed from: i */
    private short f10788i;

    /* renamed from: j */
    private volatile short f10789j;

    /* renamed from: k */
    private byte f10790k;

    public C2882am() {
    }

    public C2882am(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public int m10563a(int i, int i2) {
        return ((1 << i2) & i) >> i2;
    }

    /* renamed from: a */
    public void m10564a(byte b) {
        this.f10781b = b;
    }

    /* renamed from: a */
    public void m10562a(short s) {
        this.f10789j = s;
    }

    /* renamed from: a */
    public boolean m10565a() {
        return 1 == m10563a(this.f10789j, 4);
    }

    /* renamed from: b */
    public short m10561b() {
        return this.f10789j;
    }

    /* renamed from: b */
    public void m10560b(byte b) {
        this.f10790k = b;
    }

    /* renamed from: b */
    public void m10559b(short s) {
        this.f10788i = s;
    }

    /* renamed from: c */
    public short m10558c() {
        return this.f10788i;
    }

    /* renamed from: c */
    public void m10557c(short s) {
        this.f10787h = s;
    }

    /* renamed from: d */
    public short m10556d() {
        return this.f10787h;
    }

    /* renamed from: d */
    public void m10555d(short s) {
        this.f10786g = s;
    }

    /* renamed from: e */
    public short m10554e() {
        return this.f10786g;
    }

    /* renamed from: e */
    public void m10553e(short s) {
        this.f10785f = s;
    }

    /* renamed from: f */
    public short m10552f() {
        return this.f10785f;
    }

    /* renamed from: f */
    public void m10551f(short s) {
        this.f10784e = s;
    }

    /* renamed from: g */
    public short m10550g() {
        return this.f10784e;
    }

    /* renamed from: g */
    public void m10549g(short s) {
        this.f10783d = s;
    }

    /* renamed from: h */
    public short m10548h() {
        return this.f10783d;
    }

    /* renamed from: h */
    public void m10547h(short s) {
        this.f10782c = s;
    }

    /* renamed from: i */
    public short m10546i() {
        return this.f10782c;
    }

    /* renamed from: j */
    public byte m10545j() {
        return this.f10781b;
    }

    /* renamed from: k */
    public boolean m10544k() {
        return C3658ar.m7621a(this.f10789j, 4) == 0;
    }

    /* renamed from: l */
    public byte m10543l() {
        return this.f10790k;
    }

    /* renamed from: m */
    public boolean m10542m() {
        return C3658ar.m7621a(this.f10790k, Math.abs(0)) > 0;
    }

    /* renamed from: n */
    public boolean m10541n() {
        return C3658ar.m7621a(this.f10790k, Math.abs(1)) > 0;
    }

    public String toString() {
        return "NewRemoteMode{type=" + ((int) this.f10781b) + ", AD_Value0=" + ((int) this.f10782c) + ", AD_Value1=" + ((int) this.f10783d) + ", AD_Value2=" + ((int) this.f10784e) + ", AD_Value3=" + ((int) this.f10785f) + ", AD_Value4=" + ((int) this.f10786g) + ", AD_Value5=" + ((int) this.f10787h) + ", battery_voltage=" + ((int) this.f10788i) + ", statuts=" + ((int) this.f10789j) + C0359h.f726w;
    }
}
