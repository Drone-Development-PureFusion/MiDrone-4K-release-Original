package com.fimi.p148e.p150b;

import com.fimi.p139b.p144e.AbstractC2103b;
import com.fimi.p139b.p144e.C2104c;
import com.fimi.p139b.p144e.C2105d;
import java.util.Arrays;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.e.b.d */
/* loaded from: classes.dex */
public class C2134d extends AbstractC2103b {

    /* renamed from: a */
    public static final int f7160a = 201;

    /* renamed from: b */
    private short f7161b;

    /* renamed from: c */
    private int f7162c;

    /* renamed from: d */
    private byte[] f7163d;

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    /* renamed from: a */
    public void mo13475a(C2105d c2105d) {
    }

    /* renamed from: a */
    public void m13483a(byte[] bArr) {
        this.f7163d = bArr;
    }

    /* renamed from: e */
    public void m13482e(int i) {
        this.f7161b = (short) i;
    }

    /* renamed from: f */
    public void m13481f(int i) {
        this.f7162c = i;
    }

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    /* renamed from: g */
    public C2104c mo13473g() {
        C2104c c2104c = new C2104c();
        c2104c.m13711a(this.f7162c + 3, e(), f(), c(), d());
        c2104c.f7028b.m13691b(b());
        c2104c.f7028b.m13694a((short) (this.f7161b + 1));
        c2104c.f7028b.m13693a(this.f7163d);
        return c2104c;
    }

    /* renamed from: h */
    public short m13480h() {
        return this.f7161b;
    }

    /* renamed from: i */
    public int m13479i() {
        return this.f7162c;
    }

    /* renamed from: j */
    public byte[] m13478j() {
        return this.f7163d;
    }

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    public String toString() {
        return "UpgradeC9Message{sequence=" + ((int) this.f7161b) + ", dataLen=" + this.f7162c + ", data=" + Arrays.toString(this.f7163d) + C0359h.f726w;
    }
}
