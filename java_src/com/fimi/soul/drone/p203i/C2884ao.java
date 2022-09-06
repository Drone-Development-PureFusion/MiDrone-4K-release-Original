package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.ao */
/* loaded from: classes.dex */
public class C2884ao extends C2822e {

    /* renamed from: b */
    private byte f10803b;

    /* renamed from: c */
    private byte f10804c;

    /* renamed from: d */
    private byte f10805d;

    /* renamed from: e */
    private byte f10806e;

    /* renamed from: f */
    private byte f10807f;

    public C2884ao(C2657a c2657a) {
        super(c2657a);
        c2657a.mo11220a(C2678d.EnumC2679a.PAIR_CODE);
    }

    /* renamed from: a */
    public byte m10519a() {
        return this.f10803b;
    }

    /* renamed from: a */
    public void m10518a(byte b) {
        this.f10803b = b;
    }

    /* renamed from: b */
    public byte m10517b() {
        return this.f10804c;
    }

    /* renamed from: b */
    public void m10516b(byte b) {
        this.f10804c = b;
    }

    /* renamed from: c */
    public byte m10515c() {
        return this.f10805d;
    }

    /* renamed from: c */
    public void m10514c(byte b) {
        this.f10805d = b;
    }

    /* renamed from: d */
    public byte m10513d() {
        return this.f10806e;
    }

    /* renamed from: d */
    public void m10512d(byte b) {
        this.f10806e = b;
    }

    /* renamed from: e */
    public byte m10511e() {
        return this.f10807f;
    }

    /* renamed from: e */
    public void m10510e(byte b) {
        this.f10807f = b;
    }

    public String toString() {
        return "PairCodeStatus{msg_id=" + ((int) this.f10803b) + ", target_id=" + ((int) this.f10804c) + ", ask_status=" + ((int) this.f10805d) + ", ask_type=" + ((int) this.f10806e) + ", pair_status=" + ((int) this.f10807f) + C0359h.f726w;
    }
}
