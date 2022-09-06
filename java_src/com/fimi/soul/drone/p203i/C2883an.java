package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import org.codehaus.jackson.smile.SmileConstants;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.an */
/* loaded from: classes.dex */
public class C2883an extends C2822e {

    /* renamed from: b */
    private byte f10791b;

    /* renamed from: c */
    private short f10792c;

    /* renamed from: d */
    private short f10793d;

    /* renamed from: e */
    private short f10794e;

    /* renamed from: f */
    private short f10795f;

    /* renamed from: g */
    private short f10796g;

    /* renamed from: h */
    private short f10797h;

    /* renamed from: i */
    private byte f10798i;

    /* renamed from: j */
    private byte f10799j;

    /* renamed from: k */
    private byte f10800k;

    /* renamed from: l */
    private byte f10801l;

    /* renamed from: m */
    private byte f10802m;

    public C2883an(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10540a() {
        return this.f10791b;
    }

    /* renamed from: a */
    public void m10539a(byte b) {
        this.f10791b = b;
    }

    /* renamed from: a */
    public void m10538a(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, byte b12) {
        this.f10791b = b;
        this.f10792c = (short) (b2 & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
        this.f10793d = (short) (b3 & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
        this.f10794e = (short) (b4 & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
        this.f10795f = (short) (b5 & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
        this.f10796g = (short) (b6 & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
        this.f10797h = (short) (b6 & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
        this.f10798i = b8;
        this.f10799j = b9;
        this.f10800k = b10;
        this.f10801l = b11;
        this.f10802m = b12;
        this.f10431a.mo11220a(C2678d.EnumC2679a.PTZ_GAIN);
    }

    /* renamed from: a */
    public void m10537a(short s) {
        this.f10792c = s;
    }

    /* renamed from: b */
    public short m10536b() {
        return this.f10792c;
    }

    /* renamed from: b */
    public void m10535b(byte b) {
        this.f10798i = b;
    }

    /* renamed from: b */
    public void m10534b(short s) {
        this.f10793d = s;
    }

    /* renamed from: c */
    public short m10533c() {
        return this.f10793d;
    }

    /* renamed from: c */
    public void m10532c(byte b) {
        this.f10799j = b;
    }

    /* renamed from: c */
    public void m10531c(short s) {
        this.f10794e = s;
    }

    /* renamed from: d */
    public short m10530d() {
        return this.f10794e;
    }

    /* renamed from: d */
    public void m10529d(byte b) {
        this.f10801l = b;
    }

    /* renamed from: d */
    public void m10528d(short s) {
        this.f10795f = s;
    }

    /* renamed from: e */
    public short m10527e() {
        return this.f10795f;
    }

    /* renamed from: e */
    public void m10526e(short s) {
        this.f10796g = s;
    }

    /* renamed from: f */
    public short m10525f() {
        return this.f10796g;
    }

    /* renamed from: f */
    public void m10524f(short s) {
        this.f10797h = s;
    }

    /* renamed from: g */
    public short m10523g() {
        return this.f10797h;
    }

    /* renamed from: h */
    public byte m10522h() {
        return this.f10798i;
    }

    /* renamed from: i */
    public byte m10521i() {
        return this.f10799j;
    }

    /* renamed from: j */
    public byte m10520j() {
        return this.f10801l;
    }

    public String toString() {
        return "PTZGainVariable{hearbest=" + ((int) this.f10791b) + ", rollPosition=" + ((int) this.f10792c) + ", pitchPosition=" + ((int) this.f10793d) + ", yawPosition=" + ((int) this.f10794e) + ", rollCurrent=" + ((int) this.f10795f) + ", pitchCurrent=" + ((int) this.f10796g) + ", yawCurrent=" + ((int) this.f10797h) + ", driverStatus=" + ((int) this.f10798i) + ", gimalErrode=" + ((int) this.f10799j) + ", rev=" + ((int) this.f10800k) + ", pitchAngle=" + ((int) this.f10801l) + ", rev1=" + ((int) this.f10802m) + C0359h.f726w;
    }
}
