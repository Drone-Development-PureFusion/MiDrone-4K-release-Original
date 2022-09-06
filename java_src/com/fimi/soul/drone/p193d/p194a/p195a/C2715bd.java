package com.fimi.soul.drone.p193d.p194a.p195a;

import com.fimi.soul.drone.p193d.p194a.AbstractC2769b;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.C2771d;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.d.a.a.bd */
/* loaded from: classes.dex */
public class C2715bd extends AbstractC2769b {

    /* renamed from: a */
    public static final int f9858a = 3;

    /* renamed from: c */
    public static final int f9859c = 19;
    private static final long serialVersionUID = 3;

    /* renamed from: d */
    public short f9860d;

    /* renamed from: e */
    public byte f9861e;

    /* renamed from: f */
    public float f9862f;

    /* renamed from: g */
    public float f9863g;

    /* renamed from: h */
    public float f9864h;

    /* renamed from: i */
    public float f9865i;

    /* renamed from: j */
    public byte f9866j;

    /* renamed from: k */
    public C2770c f9867k;

    /* renamed from: l */
    private short f9868l;

    public C2715bd() {
        this.f10260b = 3;
    }

    public C2715bd(C2770c c2770c) {
        this.f10260b = 3;
        this.f9867k = c2770c;
        mo11074a(c2770c.f10264d);
    }

    /* renamed from: a */
    public short m11180a() {
        return this.f9868l;
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: a */
    public void mo11074a(C2771d c2771d) {
        c2771d.m11052c();
        this.f9860d = c2771d.m11049e();
        this.f9861e = c2771d.m11050d();
        this.f9862f = c2771d.m11045i();
        this.f9863g = c2771d.m11045i();
        this.f9864h = c2771d.m11044j();
        this.f9865i = c2771d.m11045i();
        this.f9866j = c2771d.m11050d();
        m11179a(c2771d.m11049e());
    }

    /* renamed from: a */
    public void m11179a(short s) {
        this.f9868l = s;
    }

    @Override // com.fimi.soul.drone.p193d.p194a.AbstractC2769b
    /* renamed from: b */
    public C2770c mo11073b() {
        return null;
    }

    public String toString() {
        return "msg_PosionDownlink{flightTime=" + ((int) this.f9860d) + ", SatelliteNumber=" + ((int) this.f9861e) + ", CurrentLongitude=" + this.f9862f + ", CurrentLatitude=" + this.f9863g + ", Height=" + this.f9864h + ", Distance=" + this.f9865i + ", RFsignalstrength=" + ((int) this.f9866j) + C0359h.f726w;
    }
}
