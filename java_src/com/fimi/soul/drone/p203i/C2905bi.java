package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
/* renamed from: com.fimi.soul.drone.i.bi */
/* loaded from: classes.dex */
public class C2905bi extends C2822e {

    /* renamed from: b */
    public byte f10905b;

    /* renamed from: c */
    public byte f10906c;

    public C2905bi(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10366a() {
        return this.f10905b;
    }

    /* renamed from: a */
    public void m10365a(byte b, byte b2) {
        this.f10905b = b;
        this.f10906c = b2;
        this.f10431a.mo11220a(C2678d.EnumC2679a.UPDATEDRONEORDERREPORT);
    }

    /* renamed from: b */
    public byte m10364b() {
        return this.f10906c;
    }
}
