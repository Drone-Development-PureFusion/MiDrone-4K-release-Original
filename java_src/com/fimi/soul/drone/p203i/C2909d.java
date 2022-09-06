package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import org.codehaus.jackson.smile.SmileConstants;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.d */
/* loaded from: classes.dex */
public class C2909d extends C2822e {

    /* renamed from: b */
    public byte f10927b;

    /* renamed from: c */
    public byte f10928c;

    /* renamed from: d */
    public byte f10929d;

    /* renamed from: e */
    public byte f10930e;

    /* renamed from: f */
    public byte f10931f;

    /* renamed from: g */
    public byte f10932g;

    /* renamed from: h */
    public short f10933h;

    /* renamed from: i */
    public short f10934i;

    /* renamed from: j */
    public byte f10935j;

    /* renamed from: k */
    public byte f10936k;

    /* renamed from: l */
    public byte f10937l;

    /* renamed from: m */
    public byte f10938m;

    /* renamed from: n */
    public byte f10939n;

    public C2909d() {
    }

    public C2909d(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public int m10340a() {
        return this.f10927b & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
    }

    /* renamed from: a */
    public void m10339a(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, short s, short s2, byte b7, byte b8, byte b9, byte b10, byte b11) {
        this.f10927b = b;
        this.f10928c = b2;
        this.f10929d = b3;
        this.f10930e = b4;
        this.f10931f = b5;
        this.f10932g = b6;
        this.f10933h = s;
        this.f10934i = s2;
        this.f10935j = b7;
        this.f10936k = b8;
        this.f10937l = b9;
        this.f10938m = b10;
        this.f10939n = b11;
        if (this.f10431a != null) {
            this.f10431a.mo11220a(C2678d.EnumC2679a.BATTERY);
        }
    }

    /* renamed from: b */
    public int m10338b() {
        return this.f10928c & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
    }

    /* renamed from: c */
    public int m10337c() {
        return this.f10929d & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
    }

    /* renamed from: d */
    public int m10336d() {
        return this.f10930e & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
    }

    /* renamed from: e */
    public byte m10335e() {
        return this.f10931f;
    }

    /* renamed from: f */
    public byte m10334f() {
        return this.f10932g;
    }

    /* renamed from: g */
    public short m10333g() {
        return this.f10933h;
    }

    /* renamed from: h */
    public short m10332h() {
        return this.f10934i;
    }

    /* renamed from: i */
    public int m10331i() {
        return this.f10935j & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
    }

    /* renamed from: j */
    public short m10330j() {
        return this.f10936k;
    }

    /* renamed from: k */
    public byte m10329k() {
        return this.f10937l;
    }

    /* renamed from: l */
    public byte m10328l() {
        return this.f10938m;
    }

    /* renamed from: m */
    public byte m10327m() {
        return this.f10939n;
    }

    public String toString() {
        return "Battery{Cell_1_Voltage=" + ((int) this.f10927b) + ", Cell_2_Voltage=" + ((int) this.f10928c) + ", Cell_3_Voltage=" + ((int) this.f10929d) + ", Cell_4_Voltage=" + ((int) this.f10930e) + ", Cell_5_Voltage=" + ((int) this.f10931f) + ", Cell_6_Voltage=" + ((int) this.f10932g) + ", Current_Capacity=" + ((int) this.f10933h) + ", Current=" + ((int) this.f10934i) + ", battery_temperature=" + ((int) this.f10935j) + ", batteryLevel=" + ((int) this.f10936k) + ", battery_parameter_err=" + ((int) this.f10937l) + ", battery_over_discharge=" + ((int) this.f10938m) + ", RCNoUpdateCnt=" + ((int) this.f10939n) + C0359h.f726w;
    }
}
