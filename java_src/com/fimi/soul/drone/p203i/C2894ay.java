package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import com.fimi.soul.utils.C3658ar;
/* renamed from: com.fimi.soul.drone.i.ay */
/* loaded from: classes.dex */
public class C2894ay extends C2822e {

    /* renamed from: b */
    private byte f10859b;

    /* renamed from: c */
    private byte f10860c;

    /* renamed from: d */
    private byte f10861d;

    /* renamed from: e */
    private byte f10862e;

    /* renamed from: f */
    private byte f10863f;

    /* renamed from: g */
    private byte f10864g;

    public C2894ay() {
    }

    public C2894ay(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10447a() {
        return this.f10859b;
    }

    /* renamed from: a */
    public void m10446a(byte b) {
        this.f10859b = b;
    }

    /* renamed from: a */
    public void m10445a(byte b, byte b2, byte b3, byte b4, byte b5, byte b6) {
        this.f10859b = b;
        this.f10860c = b2;
        this.f10861d = b3;
        this.f10862e = b4;
        this.f10863f = b5;
        this.f10864g = b6;
        if (this.f10431a != null) {
            this.f10431a.mo11220a(C2678d.EnumC2679a.Remotecontrol);
        }
    }

    /* renamed from: b */
    public byte m10444b() {
        return this.f10860c;
    }

    /* renamed from: b */
    public void m10443b(byte b) {
        this.f10864g = b;
    }

    /* renamed from: c */
    public byte m10442c() {
        return this.f10861d;
    }

    /* renamed from: d */
    public byte m10441d() {
        return this.f10862e;
    }

    /* renamed from: e */
    public byte m10440e() {
        return this.f10863f;
    }

    /* renamed from: f */
    public byte m10439f() {
        return this.f10864g;
    }

    /* renamed from: g */
    public boolean m10438g() {
        return C3658ar.m7621a(this.f10863f, Math.abs(0)) > 0;
    }

    /* renamed from: h */
    public boolean m10437h() {
        return C3658ar.m7621a(this.f10863f, Math.abs(1)) > 0;
    }
}
