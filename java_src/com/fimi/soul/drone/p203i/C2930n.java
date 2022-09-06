package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
/* renamed from: com.fimi.soul.drone.i.n */
/* loaded from: classes.dex */
public class C2930n extends C2822e {

    /* renamed from: b */
    private String f11065b = "";

    public C2930n(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public String m10214a() {
        return this.f11065b;
    }

    /* renamed from: a */
    public void m10213a(String str) {
        this.f11065b = str;
        this.f10431a.mo11220a(C2678d.EnumC2679a.DRONEERRORACTIONCODE);
    }
}
