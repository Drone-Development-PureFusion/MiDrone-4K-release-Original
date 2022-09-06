package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2822e;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.af */
/* loaded from: classes.dex */
public class C2875af extends C2822e {

    /* renamed from: b */
    private byte f10729b = 0;

    /* renamed from: c */
    private short f10730c = 0;

    /* renamed from: d */
    private byte f10731d = 0;

    public C2875af(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10650a() {
        return this.f10729b;
    }

    /* renamed from: a */
    public void m10649a(byte b) {
        this.f10729b = b;
    }

    /* renamed from: a */
    public void m10648a(short s) {
        this.f10730c = (short) (s & 255);
    }

    /* renamed from: b */
    public short m10647b() {
        return this.f10730c;
    }

    /* renamed from: b */
    public void m10646b(byte b) {
        this.f10731d = b;
    }

    /* renamed from: c */
    public byte m10645c() {
        return this.f10731d;
    }

    public String toString() {
        return "GimbalVariable{roll_angle=" + ((int) this.f10729b) + ", pitch_angle=" + ((int) this.f10730c) + ", yaw_angle=" + ((int) this.f10731d) + C0359h.f726w;
    }
}
