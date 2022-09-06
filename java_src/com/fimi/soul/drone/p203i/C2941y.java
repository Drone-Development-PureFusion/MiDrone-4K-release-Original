package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
/* renamed from: com.fimi.soul.drone.i.y */
/* loaded from: classes.dex */
public class C2941y extends C2822e {

    /* renamed from: b */
    private short f11122b;

    /* renamed from: c */
    private byte f11123c = 100;

    public C2941y(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10060a() {
        return this.f11123c;
    }

    /* renamed from: a */
    public void m10059a(short s, byte b) {
        this.f11122b = s;
        this.f11123c = b;
        this.f10431a.mo11220a(C2678d.EnumC2679a.ExecuteWaypoint);
    }

    /* renamed from: b */
    public short m10058b() {
        return this.f11122b;
    }

    /* renamed from: c */
    public void m10057c() {
        this.f11122b = (short) 0;
    }
}
