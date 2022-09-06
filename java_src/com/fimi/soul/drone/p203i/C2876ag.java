package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import java.io.Serializable;
import org.codehaus.jackson.smile.SmileConstants;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.ag */
/* loaded from: classes.dex */
public class C2876ag extends C2822e implements Serializable {

    /* renamed from: b */
    private double f10732b;

    /* renamed from: c */
    private double f10733c;

    /* renamed from: d */
    private byte f10734d;

    /* renamed from: e */
    private byte f10735e;

    /* renamed from: f */
    private int f10736f;

    /* renamed from: g */
    private byte f10737g;

    /* renamed from: h */
    private byte f10738h;

    /* renamed from: i */
    private double f10739i;

    /* renamed from: j */
    private double f10740j;

    /* renamed from: k */
    private double f10741k;

    /* renamed from: l */
    private double f10742l;

    /* renamed from: m */
    private double f10743m;

    /* renamed from: n */
    private double f10744n;

    /* renamed from: o */
    private double f10745o;

    public C2876ag() {
    }

    public C2876ag(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public double m10644a() {
        return this.f10732b;
    }

    /* renamed from: a */
    public void m10643a(byte b) {
        this.f10734d = b;
    }

    /* renamed from: a */
    public void m10642a(byte b, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13) {
        this.f10734d = (byte) (b & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
        this.f10739i = d;
        this.f10745o = d2;
        this.f10744n = d3;
        this.f10743m = d4;
        this.f10740j = d5;
        this.f10741k = d6;
        this.f10742l = d7;
        this.f10735e = (byte) d8;
        this.f10736f = (int) d9;
        this.f10732b = d10;
        this.f10733c = d11;
        this.f10737g = (byte) d12;
        this.f10738h = (byte) d13;
    }

    /* renamed from: a */
    public void m10641a(double d) {
        this.f10732b = d;
    }

    /* renamed from: a */
    public void m10640a(double d, double d2, double d3, double d4, double d5, double d6, double d7, byte b, byte b2, int i, byte b3, byte b4, double d8, double d9) {
        this.f10739i = d2;
        this.f10744n = d;
        this.f10740j = d3;
        this.f10741k = d4;
        this.f10742l = d5;
        this.f10743m = d6;
        this.f10745o = d7;
        this.f10732b = d8;
        this.f10733c = d9;
        this.f10734d = b;
        this.f10735e = b2;
        this.f10736f = i;
        this.f10737g = b3;
        this.f10738h = b4;
        this.f10431a.mo11220a(C2678d.EnumC2679a.HEARDATA);
    }

    /* renamed from: a */
    public void m10639a(int i) {
        this.f10736f = i;
    }

    /* renamed from: b */
    public double m10638b() {
        return this.f10733c;
    }

    /* renamed from: b */
    public void m10637b(byte b) {
        this.f10735e = b;
    }

    /* renamed from: b */
    public void m10636b(double d) {
        this.f10733c = d;
    }

    /* renamed from: c */
    public byte m10635c() {
        return this.f10734d;
    }

    /* renamed from: c */
    public void m10634c(double d) {
        this.f10739i = d;
    }

    /* renamed from: d */
    public byte m10633d() {
        return this.f10735e;
    }

    /* renamed from: d */
    public void m10632d(double d) {
        this.f10740j = d;
    }

    /* renamed from: e */
    public int m10631e() {
        return this.f10736f;
    }

    /* renamed from: e */
    public void m10630e(double d) {
        this.f10741k = d;
    }

    /* renamed from: f */
    public byte m10629f() {
        return this.f10737g;
    }

    /* renamed from: f */
    public void m10628f(double d) {
        this.f10742l = d;
    }

    /* renamed from: g */
    public byte m10627g() {
        return this.f10738h;
    }

    /* renamed from: g */
    public void m10626g(double d) {
        this.f10743m = d;
    }

    /* renamed from: h */
    public double m10625h() {
        return this.f10739i;
    }

    /* renamed from: h */
    public void m10624h(double d) {
        this.f10744n = d;
    }

    /* renamed from: i */
    public double m10623i() {
        return this.f10740j;
    }

    /* renamed from: i */
    public void m10622i(double d) {
        this.f10745o = d;
    }

    /* renamed from: j */
    public double m10621j() {
        return this.f10741k;
    }

    /* renamed from: k */
    public double m10620k() {
        return this.f10742l;
    }

    /* renamed from: l */
    public double m10619l() {
        return this.f10743m;
    }

    /* renamed from: m */
    public double m10618m() {
        return this.f10744n;
    }

    /* renamed from: n */
    public double m10617n() {
        return this.f10745o;
    }

    public String toString() {
        return "HeardData{GroundSpeed=" + this.f10732b + ", DownVelocity=" + this.f10733c + ", Heartbeat=" + ((int) this.f10734d) + ", Disarm_count=" + ((int) this.f10735e) + ", FlightMode=" + this.f10736f + ", rcReceiver=" + ((int) this.f10737g) + ", takeoffTag=" + ((int) this.f10738h) + ", ThrottleStick=" + this.f10739i + ", rollangle=" + this.f10740j + ", pitchangle=" + this.f10741k + ", Headingangle=" + this.f10742l + ", YawStick=" + this.f10743m + ", PitchStick=" + this.f10744n + ", RollStick=" + this.f10745o + C0359h.f726w;
    }
}
