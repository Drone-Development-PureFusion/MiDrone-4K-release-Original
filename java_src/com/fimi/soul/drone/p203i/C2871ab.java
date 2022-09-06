package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.ab */
/* loaded from: classes.dex */
public class C2871ab extends C2822e {

    /* renamed from: b */
    private char f10700b;

    /* renamed from: c */
    private short f10701c;

    /* renamed from: d */
    private byte f10702d;

    /* renamed from: e */
    private byte f10703e = 50;

    /* renamed from: f */
    private long f10704f;

    /* renamed from: g */
    private long f10705g;

    /* renamed from: h */
    private long f10706h;

    /* renamed from: i */
    private long f10707i;

    /* renamed from: j */
    private C2770c f10708j;

    public C2871ab(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10692a() {
        return this.f10703e;
    }

    /* renamed from: a */
    public void m10691a(byte b, char c, short s, byte b2, long j, long j2, long j3, long j4, C2770c c2770c) {
        this.f10700b = c;
        this.f10701c = s;
        this.f10702d = b2;
        this.f10703e = b;
        this.f10704f = j;
        this.f10705g = j2;
        this.f10706h = j3;
        this.f10707i = j4;
        this.f10708j = c2770c;
        this.f10431a.mo11220a(C2678d.EnumC2679a.FCVERSION2);
    }

    /* renamed from: b */
    public char m10690b() {
        return this.f10700b;
    }

    /* renamed from: c */
    public short m10689c() {
        return this.f10701c;
    }

    /* renamed from: d */
    public byte m10688d() {
        return this.f10702d;
    }

    /* renamed from: e */
    public long m10687e() {
        return this.f10704f;
    }

    /* renamed from: f */
    public long m10686f() {
        return this.f10705g;
    }

    /* renamed from: g */
    public long m10685g() {
        return this.f10706h;
    }

    /* renamed from: h */
    public long m10684h() {
        return this.f10707i;
    }

    /* renamed from: i */
    public C2770c m10683i() {
        return this.f10708j;
    }

    public String toString() {
        return "FCVersion2{FC_hardware_version=" + this.f10700b + ", Software_version=" + ((int) this.f10701c) + ", Model=" + ((int) this.f10702d) + ", type=" + ((int) this.f10703e) + ", IDA=" + this.f10704f + ", IDB=" + this.f10705g + ", IDC=" + this.f10706h + ", reserve=" + this.f10707i + ", miLinkPacket=" + this.f10708j + C0359h.f726w;
    }
}
