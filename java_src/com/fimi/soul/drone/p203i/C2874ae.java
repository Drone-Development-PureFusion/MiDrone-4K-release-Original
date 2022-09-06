package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.ae */
/* loaded from: classes.dex */
public class C2874ae extends C2822e {

    /* renamed from: b */
    private byte f10722b;

    /* renamed from: c */
    private byte f10723c;

    /* renamed from: d */
    private byte f10724d;

    /* renamed from: e */
    private byte f10725e;

    /* renamed from: f */
    private byte f10726f;

    /* renamed from: g */
    private byte f10727g;

    /* renamed from: h */
    private byte f10728h;

    public C2874ae(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10665a() {
        return this.f10722b;
    }

    /* renamed from: a */
    public void m10664a(byte b) {
        this.f10722b = b;
    }

    /* renamed from: a */
    public void m10663a(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7) {
        this.f10722b = b;
        this.f10723c = b2;
        this.f10724d = b3;
        this.f10725e = b4;
        this.f10726f = b5;
        this.f10727g = b6;
        this.f10728h = b7;
        this.f10431a.mo11220a(C2678d.EnumC2679a.GIMAL_PARAMETER_CONFIG);
    }

    /* renamed from: b */
    public byte m10662b() {
        return this.f10723c;
    }

    /* renamed from: b */
    public void m10661b(byte b) {
        this.f10723c = b;
    }

    /* renamed from: c */
    public byte m10660c() {
        return this.f10724d;
    }

    /* renamed from: c */
    public void m10659c(byte b) {
        this.f10724d = b;
    }

    /* renamed from: d */
    public byte m10658d() {
        return this.f10725e;
    }

    /* renamed from: d */
    public void m10657d(byte b) {
        this.f10725e = b;
    }

    /* renamed from: e */
    public byte m10656e() {
        return this.f10726f;
    }

    /* renamed from: e */
    public void m10655e(byte b) {
        this.f10726f = b;
    }

    /* renamed from: f */
    public byte m10654f() {
        return this.f10727g;
    }

    /* renamed from: f */
    public void m10653f(byte b) {
        this.f10727g = b;
    }

    /* renamed from: g */
    public byte m10652g() {
        return this.f10728h;
    }

    /* renamed from: g */
    public void m10651g(byte b) {
        this.f10728h = b;
    }

    public String toString() {
        return "GimalParameterConfig{version=" + ((int) this.f10722b) + ", report=" + ((int) this.f10723c) + ", configIndex=" + ((int) this.f10724d) + ", commandType=" + ((int) this.f10725e) + ", configData1=" + ((int) this.f10726f) + ", configData2=" + ((int) this.f10727g) + ", configData3=" + ((int) this.f10728h) + C0359h.f726w;
    }
}
