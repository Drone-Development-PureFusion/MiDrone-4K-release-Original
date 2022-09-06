package com.fimi.soul.drone.p203i.p204a;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import com.fimi.soul.entity.DroneModelType;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.a.f */
/* loaded from: classes.dex */
public class C2867f extends C2822e {

    /* renamed from: b */
    private byte f10681b;

    /* renamed from: d */
    private byte f10683d;

    /* renamed from: f */
    private byte f10685f;

    /* renamed from: g */
    private byte f10686g;

    /* renamed from: h */
    private byte f10687h;

    /* renamed from: c */
    private byte f10682c = 50;

    /* renamed from: e */
    private byte f10684e = 90;

    /* renamed from: i */
    private DroneModelType f10688i = new DroneModelType();

    public C2867f() {
    }

    public C2867f(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10707a() {
        return this.f10684e;
    }

    /* renamed from: a */
    public void m10706a(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7) {
        this.f10681b = b;
        this.f10682c = b2;
        this.f10688i.setCtrlType(b);
        this.f10688i.setCtrlMode(b2);
        this.f10684e = b4;
        this.f10685f = b5;
        this.f10686g = b6;
        this.f10683d = b3;
        this.f10687h = b7;
        if (this.f10431a != null) {
            this.f10431a.mo11220a(C2678d.EnumC2679a.NEWFRONEMODEL);
        }
    }

    /* renamed from: b */
    public byte m10705b() {
        return this.f10686g;
    }

    /* renamed from: c */
    public byte m10704c() {
        return this.f10685f;
    }

    /* renamed from: d */
    public byte m10703d() {
        return this.f10681b;
    }

    /* renamed from: e */
    public byte m10702e() {
        return this.f10682c;
    }

    /* renamed from: f */
    public byte m10701f() {
        return this.f10683d;
    }

    /* renamed from: g */
    public DroneModelType m10700g() {
        return this.f10688i;
    }

    /* renamed from: h */
    public byte m10699h() {
        return this.f10687h;
    }

    public String toString() {
        return "NewDroneModel{CtrlType=" + ((int) this.f10681b) + ", CtrlMode=" + ((int) this.f10682c) + ", WP_STA=" + ((int) this.f10683d) + C0359h.f726w;
    }
}
