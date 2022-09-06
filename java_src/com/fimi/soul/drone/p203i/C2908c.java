package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
/* renamed from: com.fimi.soul.drone.i.c */
/* loaded from: classes.dex */
public class C2908c extends C2822e {

    /* renamed from: b */
    public byte f10924b;

    /* renamed from: c */
    public byte f10925c;

    /* renamed from: d */
    public byte f10926d;

    public C2908c() {
    }

    public C2908c(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10345a() {
        return this.f10926d;
    }

    /* renamed from: a */
    public void m10344a(byte b, byte b2, byte b3) {
        this.f10924b = b;
        this.f10925c = b2;
        this.f10926d = b3;
        if (this.f10431a != null) {
            this.f10431a.mo11220a(C2678d.EnumC2679a.backControl);
        }
    }

    /* renamed from: b */
    public byte m10343b() {
        return this.f10924b;
    }

    /* renamed from: c */
    public byte m10342c() {
        return this.f10925c;
    }

    /* renamed from: d */
    public byte m10341d() {
        return this.f10926d;
    }

    public String toString() {
        return "BackControl [model=" + ((int) this.f10924b) + ", status=" + ((int) this.f10925c) + ", action=" + ((int) this.f10926d) + "]";
    }
}
