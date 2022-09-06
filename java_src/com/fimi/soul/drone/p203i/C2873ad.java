package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import org.codehaus.jackson.smile.SmileConstants;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.ad */
/* loaded from: classes.dex */
public class C2873ad extends C2822e {

    /* renamed from: b */
    private byte f10716b;

    /* renamed from: c */
    private byte f10717c;

    /* renamed from: d */
    private byte f10718d;

    /* renamed from: e */
    private byte f10719e;

    /* renamed from: f */
    private byte f10720f;

    /* renamed from: g */
    private byte f10721g;

    public C2873ad(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10674a() {
        return this.f10718d;
    }

    /* renamed from: a */
    public void m10673a(byte b) {
        this.f10720f = b;
    }

    /* renamed from: a */
    public void m10672a(byte b, byte b2, byte b3, byte b4, byte b5, byte b6) {
        this.f10716b = b;
        this.f10717c = b2;
        this.f10718d = b3;
        this.f10719e = b4;
        this.f10720f = b4;
        this.f10721g = b6;
        this.f10431a.mo11220a(C2678d.EnumC2679a.GimbalCalibration);
    }

    /* renamed from: b */
    public byte m10671b() {
        return this.f10719e;
    }

    /* renamed from: b */
    public void m10670b(byte b) {
        this.f10721g = b;
    }

    /* renamed from: c */
    public byte m10669c() {
        return this.f10716b;
    }

    /* renamed from: d */
    public byte m10668d() {
        return this.f10717c;
    }

    /* renamed from: e */
    public byte m10667e() {
        return this.f10720f;
    }

    /* renamed from: f */
    public byte m10666f() {
        return (byte) (this.f10721g & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
    }

    public String toString() {
        return "GimalCalibrationVarable{type=" + ((int) this.f10716b) + ", progress=" + ((int) this.f10717c) + ", temp=" + ((int) this.f10718d) + ", errCode=" + ((int) this.f10719e) + ", fault=" + ((int) this.f10720f) + ", testData=" + ((int) this.f10721g) + C0359h.f726w;
    }
}
