package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.k */
/* loaded from: classes.dex */
public class C2927k extends C2822e {

    /* renamed from: b */
    private byte f11054b;

    /* renamed from: c */
    private byte f11055c;

    /* renamed from: d */
    private byte f11056d;

    /* renamed from: e */
    private byte f11057e;

    /* renamed from: f */
    private byte f11058f;

    public C2927k(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10235a() {
        return this.f11054b;
    }

    /* renamed from: a */
    public void m10234a(byte b) {
        this.f11054b = b;
    }

    /* renamed from: a */
    public void m10233a(byte b, byte b2, byte b3, byte b4, byte b5) {
        this.f11054b = b;
        this.f11055c = b2;
        this.f11056d = b3;
        this.f11057e = b4;
        this.f11058f = b5;
        this.f10431a.mo11220a(C2678d.EnumC2679a.CaliCompass);
    }

    /* renamed from: b */
    public byte m10232b() {
        return this.f11058f;
    }

    /* renamed from: b */
    public void m10231b(byte b) {
        this.f11058f = b;
    }

    /* renamed from: c */
    public byte m10230c() {
        return this.f11057e;
    }

    /* renamed from: c */
    public void m10229c(byte b) {
        this.f11057e = b;
    }

    /* renamed from: d */
    public byte m10228d() {
        return this.f11056d;
    }

    /* renamed from: d */
    public void m10227d(byte b) {
        this.f11056d = b;
    }

    /* renamed from: e */
    public byte m10226e() {
        return this.f11055c;
    }

    /* renamed from: e */
    public void m10225e(byte b) {
        this.f11055c = b;
    }

    public String toString() {
        return "Compass{packetSeq=" + ((int) this.f11054b) + ", caliType=" + ((int) this.f11055c) + ", caliStep=" + ((int) this.f11056d) + ", caliStepStatus=" + ((int) this.f11057e) + ", report=" + ((int) this.f11058f) + C0359h.f726w;
    }
}
