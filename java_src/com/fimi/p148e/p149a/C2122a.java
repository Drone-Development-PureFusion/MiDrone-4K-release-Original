package com.fimi.p148e.p149a;

import com.fimi.p139b.p144e.AbstractC2103b;
import com.fimi.p139b.p144e.C2104c;
import com.fimi.p139b.p144e.C2105d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.e.a.a */
/* loaded from: classes.dex */
public class C2122a extends AbstractC2103b {

    /* renamed from: a */
    public static final int f7086a = 65;

    /* renamed from: b */
    private byte f7087b;

    /* renamed from: c */
    private byte f7088c;

    /* renamed from: d */
    private byte f7089d;

    /* renamed from: e */
    private int f7090e;

    /* renamed from: f */
    private boolean f7091f;

    /* renamed from: g */
    private boolean f7092g;

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    /* renamed from: a */
    public void mo13475a(C2105d c2105d) {
        c2105d.m13688c();
        m13614b(c2105d.m13686d());
        m13612c(c2105d.m13686d());
        m13610d(c2105d.m13686d());
    }

    /* renamed from: b */
    public void m13614b(byte b) {
        this.f7087b = b;
    }

    /* renamed from: b */
    public void m13613b(boolean z) {
        this.f7091f = z;
    }

    /* renamed from: c */
    public void m13612c(byte b) {
        this.f7088c = b;
    }

    /* renamed from: c */
    public void m13611c(boolean z) {
        this.f7092g = z;
    }

    /* renamed from: d */
    public void m13610d(byte b) {
        this.f7089d = b;
        this.f7090e = b & 3;
        if ((b & 4) != 0) {
            this.f7091f = true;
        } else {
            this.f7091f = false;
        }
        if ((b & 8) != 0) {
            this.f7091f = true;
        } else {
            this.f7091f = false;
        }
        if ((b & 16) != 0) {
            this.f7092g = true;
        } else {
            this.f7092g = false;
        }
    }

    /* renamed from: e */
    public void m13609e(int i) {
        this.f7090e = i;
    }

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    /* renamed from: g */
    public C2104c mo13473g() {
        return null;
    }

    /* renamed from: h */
    public int m13608h() {
        return this.f7090e;
    }

    /* renamed from: i */
    public boolean m13607i() {
        return this.f7091f;
    }

    /* renamed from: j */
    public boolean m13606j() {
        return this.f7092g;
    }

    /* renamed from: k */
    public byte m13605k() {
        return this.f7087b;
    }

    /* renamed from: l */
    public byte m13604l() {
        return this.f7088c;
    }

    /* renamed from: m */
    public byte m13603m() {
        return this.f7089d;
    }

    @Override // com.fimi.p139b.p144e.AbstractC2103b
    public String toString() {
        return "Battery41Response{batteryCapcity=" + ((int) this.f7087b) + ", batteryVoltage=" + ((int) this.f7088c) + ", batteryInfo=" + ((int) this.f7089d) + ", changeState=" + this.f7090e + ", cameraChange=" + this.f7091f + ", poweOff=" + this.f7092g + C0359h.f726w;
    }
}
