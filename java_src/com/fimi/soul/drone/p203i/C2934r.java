package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import java.util.Arrays;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.r */
/* loaded from: classes.dex */
public class C2934r extends C2822e {

    /* renamed from: b */
    public byte f11079b;

    /* renamed from: c */
    public byte f11080c;

    /* renamed from: d */
    public byte f11081d;

    /* renamed from: e */
    public byte f11082e;

    /* renamed from: f */
    public byte f11083f;

    /* renamed from: g */
    private byte f11084g;

    /* renamed from: h */
    private byte[] f11085h;

    public C2934r(C2657a c2657a) {
        super(c2657a);
        c2657a.mo11220a(C2678d.EnumC2679a.DYNAMIC_RESULT);
    }

    /* renamed from: a */
    public byte m10189a() {
        return this.f11084g;
    }

    /* renamed from: a */
    public void m10188a(byte b) {
        this.f11084g = b;
    }

    /* renamed from: a */
    public void m10187a(byte[] bArr) {
        this.f11085h = bArr;
    }

    /* renamed from: b */
    public byte m10186b() {
        return this.f11079b;
    }

    /* renamed from: b */
    public void m10185b(byte b) {
        this.f11079b = b;
    }

    /* renamed from: c */
    public byte m10184c() {
        return this.f11080c;
    }

    /* renamed from: c */
    public void m10183c(byte b) {
        this.f11080c = b;
    }

    /* renamed from: d */
    public void m10181d(byte b) {
        this.f11081d = b;
    }

    /* renamed from: d */
    public byte[] m10182d() {
        return this.f11085h;
    }

    /* renamed from: e */
    public byte m10180e() {
        return this.f11081d;
    }

    /* renamed from: e */
    public void m10179e(byte b) {
        this.f11082e = b;
    }

    /* renamed from: f */
    public byte m10178f() {
        return this.f11082e;
    }

    /* renamed from: f */
    public void m10177f(byte b) {
        this.f11083f = b;
    }

    /* renamed from: g */
    public byte m10176g() {
        return this.f11083f;
    }

    public String toString() {
        return "DynamicStatus{msg_id=" + ((int) this.f11084g) + ", tagertId=" + ((int) this.f11079b) + ", sourceId=" + ((int) this.f11080c) + ", packetNum=" + Arrays.toString(this.f11085h) + ", gps_status=" + ((int) this.f11081d) + ", received=" + ((int) this.f11082e) + ", report_status=" + ((int) this.f11083f) + C0359h.f726w;
    }
}
