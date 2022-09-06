package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.o */
/* loaded from: classes.dex */
public class C2931o extends C2822e {

    /* renamed from: b */
    public byte f11066b;

    /* renamed from: c */
    public byte f11067c;

    /* renamed from: d */
    public float f11068d;

    /* renamed from: e */
    public byte f11069e;

    public C2931o(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10212a() {
        return this.f11066b;
    }

    /* renamed from: a */
    public void m10211a(byte b) {
        this.f11066b = b;
    }

    /* renamed from: a */
    public void m10210a(byte b, byte b2, float f, byte b3) {
        this.f11066b = b;
        this.f11067c = b2;
        this.f11068d = f;
        this.f11069e = b3;
        this.f10431a.mo11220a(C2678d.EnumC2679a.RETURN_HEIGHT);
    }

    /* renamed from: a */
    public void m10209a(float f) {
        this.f11068d = f;
    }

    /* renamed from: b */
    public byte m10208b() {
        return this.f11067c;
    }

    /* renamed from: b */
    public void m10207b(byte b) {
        this.f11067c = b;
    }

    /* renamed from: c */
    public float m10206c() {
        return this.f11068d;
    }

    /* renamed from: c */
    public void m10205c(byte b) {
        this.f11069e = b;
    }

    /* renamed from: d */
    public byte m10204d() {
        return this.f11069e;
    }

    public String toString() {
        return "DroneRTHVariable{packPacketSequence=" + ((int) this.f11066b) + ", cmdID=" + ((int) this.f11067c) + ", height=" + this.f11068d + ", report=" + ((int) this.f11069e) + C0359h.f726w;
    }
}
