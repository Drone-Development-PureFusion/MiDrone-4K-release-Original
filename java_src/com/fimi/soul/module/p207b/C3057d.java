package com.fimi.soul.module.p207b;

import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.p195a.C2707aw;
import com.fimi.soul.drone.p193d.p194a.p195a.C2710az;
import com.fimi.soul.drone.p193d.p194a.p195a.C2712ba;
import com.fimi.soul.drone.p193d.p194a.p195a.C2726bo;
import com.fimi.soul.drone.p193d.p194a.p195a.C2729br;
import com.fimi.soul.drone.p202h.C2854c;
import com.fimi.soul.media.player.IMediaPlayer;
import com.fimi.soul.module.calibcompass.C3074a;
import com.fimi.soul.module.droneui.DroneMap;
import com.fimi.soul.module.setting.newhand.C3531c;
/* renamed from: com.fimi.soul.module.b.d */
/* loaded from: classes.dex */
public class C3057d {

    /* renamed from: a */
    private static C3057d f11387a = null;

    /* renamed from: b */
    private static C2657a f11388b;

    /* renamed from: c */
    private C3074a f11389c = C3074a.m9756a();

    /* renamed from: d */
    private C3053b f11390d = C3053b.m9841a();

    private C3057d() {
    }

    /* renamed from: a */
    public static C3057d m9823a(C2657a c2657a) {
        f11388b = c2657a;
        if (f11387a == null) {
            f11387a = new C3057d();
        }
        return f11387a;
    }

    /* renamed from: a */
    private void m9822a(C2770c c2770c) {
        C3050a m9847a = C3050a.m9847a(this.f11390d);
        this.f11389c.m9753a(c2770c.f10263c + "", m9847a);
        if (m9847a != null) {
            if (c2770c.f10263c == 140 || c2770c.f10263c == 139) {
                m9847a.m9851a(IMediaPlayer.MEDIA_INFO_VIDEO_TRACK_LAGGING);
            } else {
                m9847a.m9851a(300);
            }
            m9847a.m9850a(f11388b, c2770c);
            m9847a.m9852a();
            C2854c.m10764a(C2854c.EnumC2855a.PHONESEND);
        }
    }

    /* renamed from: a */
    public void m9835a() {
        if (!f11388b.m11320al()) {
            C2726bo c2726bo = new C2726bo();
            c2726bo.f9946d = (short) 1;
            f11388b.mo11217ab().mo10897a(c2726bo.mo11073b());
            m9822a(c2726bo.mo11073b());
        }
    }

    /* renamed from: a */
    public void m9834a(byte b) {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 154;
        c2770c.f10262b = 25;
        c2770c.f10264d.m11055b((byte) 1);
        c2770c.f10264d.m11055b((byte) 13);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b(b);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        f11388b.mo11217ab().mo10897a(c2770c);
        m9822a(c2770c);
    }

    /* renamed from: a */
    public void m9833a(byte b, byte b2, byte b3) {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 153;
        c2770c.f10262b = 3;
        c2770c.f10264d.m11055b(b);
        c2770c.f10264d.m11055b(b2);
        c2770c.f10264d.m11055b(b3);
        f11388b.mo11217ab().mo10897a(c2770c);
        m9822a(c2770c);
    }

    /* renamed from: a */
    public void m9832a(byte b, byte b2, short s, short s2, byte b3, short s3, float f, float f2) {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 134;
        c2770c.f10262b = 19;
        c2770c.f10264d.m11055b((byte) 1);
        c2770c.f10264d.m11055b(b);
        c2770c.f10264d.m11055b(b2);
        c2770c.f10264d.m11057a(s);
        c2770c.f10264d.m11057a(s2);
        c2770c.f10264d.m11055b(b3);
        c2770c.f10264d.m11057a(s3);
        c2770c.f10264d.m11060a(f);
        c2770c.f10264d.m11060a(f2);
        c2770c.f10264d.m11055b((byte) 0);
        f11388b.mo11217ab().mo10897a(c2770c);
        m9822a(c2770c);
    }

    /* renamed from: a */
    public void m9831a(double d, double d2) {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 128;
        c2770c.f10262b = 14;
        c2770c.f10264d.m11055b((byte) 1);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11060a((float) d);
        c2770c.f10264d.m11060a((float) d2);
        c2770c.f10264d.m11057a((short) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        f11388b.mo11217ab().mo10897a(c2770c);
        m9822a(c2770c);
    }

    /* renamed from: a */
    public void m9830a(int i) {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 130;
        c2770c.f10262b = 2;
        c2770c.f10264d.m11057a((short) i);
        f11388b.mo11217ab().mo10897a(c2770c);
        m9822a(c2770c);
    }

    /* renamed from: a */
    public void m9829a(int i, double d, double d2, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 129;
        c2770c.f10262b = 19;
        c2770c.f10264d.m11055b((byte) i);
        c2770c.f10264d.m11055b((byte) i3);
        c2770c.f10264d.m11060a((float) d);
        c2770c.f10264d.m11060a((float) d2);
        c2770c.f10264d.m11057a((short) i2);
        c2770c.f10264d.m11057a((short) i4);
        c2770c.f10264d.m11055b((byte) i5);
        c2770c.f10264d.m11055b((byte) i6);
        c2770c.f10264d.m11055b((byte) i7);
        c2770c.f10264d.m11055b((byte) i8);
        c2770c.f10264d.m11055b((byte) 0);
        f11388b.mo11217ab().mo10897a(c2770c);
        m9822a(c2770c);
    }

    /* renamed from: a */
    public void m9828a(int i, double d, double d2, short s, int i2, int i3) {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 133;
        c2770c.f10262b = 16;
        c2770c.f10264d.m11055b((byte) i);
        c2770c.f10264d.m11055b((byte) i3);
        c2770c.f10264d.m11060a((float) d);
        c2770c.f10264d.m11060a((float) d2);
        c2770c.f10264d.m11057a(s);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) i2);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        f11388b.mo11217ab().mo10897a(c2770c);
        m9822a(c2770c);
    }

    /* renamed from: a */
    public void m9827a(int i, double d, double d2, short s, short s2, int i2) {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 131;
        c2770c.f10262b = 19;
        c2770c.f10264d.m11057a((short) i);
        c2770c.f10264d.m11060a((float) d);
        c2770c.f10264d.m11060a((float) d2);
        c2770c.f10264d.m11057a(s);
        c2770c.f10264d.m11057a((short) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) i2);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11057a(s2);
        f11388b.mo11217ab().mo10897a(c2770c);
        m9822a(c2770c);
    }

    /* renamed from: a */
    public void m9826a(int i, int i2, int i3, int i4, long j) {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 139;
        c2770c.f10262b = 17;
        c2770c.f10264d.m11055b((byte) 1);
        c2770c.f10264d.m11055b((byte) 1);
        c2770c.f10264d.m11055b((byte) 15);
        c2770c.f10264d.m11055b((byte) 13);
        c2770c.f10264d.m11055b((byte) -96);
        c2770c.f10264d.m11057a((short) i);
        c2770c.f10264d.m11057a((short) i2);
        c2770c.f10264d.m11055b((byte) i3);
        c2770c.f10264d.m11055b((byte) i4);
        c2770c.f10264d.m11054b((int) j);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        f11388b.mo11217ab().mo10897a(c2770c);
        m9822a(c2770c);
    }

    /* renamed from: a */
    public void m9825a(int i, int i2, byte[] bArr) {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 139;
        c2770c.f10262b = 9;
        c2770c.f10264d.m11055b((byte) 1);
        c2770c.f10264d.m11055b((byte) 1);
        c2770c.f10264d.m11055b((byte) 15);
        c2770c.f10264d.m11055b((byte) 13);
        c2770c.f10264d.m11055b((byte) -95);
        c2770c.f10264d.m11057a((short) i);
        c2770c.f10264d.m11057a((short) i2);
        f11388b.mo11217ab().mo10897a(c2770c);
        m9822a(c2770c);
    }

    /* renamed from: a */
    public void m9824a(int i, byte[] bArr) {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 140;
        c2770c.f10262b = bArr.length + 5;
        c2770c.f10264d.m11055b((byte) 1);
        c2770c.f10264d.m11055b((byte) 15);
        c2770c.f10264d.m11055b((byte) 13);
        c2770c.f10264d.m11057a((short) i);
        for (byte b : bArr) {
            c2770c.f10264d.m11055b(b);
        }
        f11388b.mo11217ab().mo10897a(c2770c);
        m9822a(c2770c);
    }

    /* renamed from: b */
    public void m9821b() {
        C2712ba c2712ba = new C2712ba();
        c2712ba.f9843d = (short) 1;
        f11388b.mo11217ab().mo10897a(c2712ba.mo11073b());
        m9822a(c2712ba.mo11073b());
    }

    /* renamed from: b */
    public void m9820b(byte b, byte b2, byte b3) {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 153;
        c2770c.f10262b = 3;
        c2770c.f10264d.m11055b(b);
        c2770c.f10264d.m11055b(b2);
        c2770c.f10264d.m11055b(b3);
        f11388b.mo11217ab().mo10897a(c2770c);
        m9822a(c2770c);
    }

    /* renamed from: b */
    public void m9819b(int i) {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 204;
        c2770c.f10262b = 2;
        c2770c.f10264d.m11055b((byte) i);
        c2770c.f10264d.m11055b((byte) 2);
        f11388b.mo11217ab().mo10897a(c2770c);
        m9822a(c2770c);
    }

    /* renamed from: c */
    public void m9818c() {
        C2707aw c2707aw = new C2707aw();
        c2707aw.f9808d = (short) 1;
        f11388b.mo11217ab().mo10897a(c2707aw.mo11073b());
        m9822a(c2707aw.mo11073b());
    }

    /* renamed from: c */
    public void m9817c(int i) {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 138;
        c2770c.f10262b = 8;
        c2770c.f10264d.m11055b((byte) 1);
        c2770c.f10264d.m11055b((byte) 13);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 17);
        c2770c.f10264d.m11055b((byte) i);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        c2770c.f10264d.m11055b((byte) 0);
        f11388b.mo11217ab().mo10897a(c2770c);
        m9822a(c2770c);
    }

    /* renamed from: d */
    public void m9816d() {
        C2710az c2710az = new C2710az();
        c2710az.f9833d = (short) 1;
        c2710az.f9834e = DroneMap.f12612o;
        f11388b.mo11217ab().mo10897a(c2710az.mo11073b());
        m9822a(c2710az.mo11073b());
    }

    /* renamed from: d */
    public void m9815d(int i) {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 139;
        c2770c.f10262b = 6;
        c2770c.f10264d.m11055b((byte) 1);
        c2770c.f10264d.m11055b((byte) 1);
        c2770c.f10264d.m11055b((byte) 15);
        c2770c.f10264d.m11055b((byte) 13);
        c2770c.f10264d.m11055b((byte) -94);
        c2770c.f10264d.m11055b((byte) i);
        f11388b.mo11217ab().mo10897a(c2770c);
        m9822a(c2770c);
    }

    /* renamed from: e */
    public void m9814e() {
        C2710az c2710az = new C2710az();
        c2710az.f9833d = (short) 1;
        c2710az.f9834e = DroneMap.f12611n;
        f11388b.mo11217ab().mo10897a(c2710az.mo11073b());
        m9822a(c2710az.mo11073b());
    }

    /* renamed from: e */
    public void m9813e(int i) {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 193;
        c2770c.f10262b = 1;
        c2770c.f10264d.m11055b((byte) i);
        f11388b.mo11217ab().mo10897a(c2770c);
        m9822a(c2770c);
    }

    /* renamed from: f */
    public void m9812f() {
        C2710az c2710az = new C2710az();
        c2710az.f9833d = (short) 1;
        c2710az.f9834e = DroneMap.f12610m;
        f11388b.mo11217ab().mo10897a(c2710az.mo11073b());
        m9822a(c2710az.mo11073b());
    }

    /* renamed from: f */
    public void m9811f(int i) {
        this.f11389c.m9754a(i + "");
    }

    /* renamed from: g */
    public void m9810g() {
        C2729br c2729br = new C2729br();
        c2729br.f9967e = (byte) 1;
        c2729br.f9966d = (byte) 114;
        c2729br.f9968f = (byte) 3;
        f11388b.mo11217ab().mo10897a(c2729br.mo11073b());
        m9822a(c2729br.mo11073b());
    }

    /* renamed from: h */
    public void m9809h() {
        C2729br c2729br = new C2729br();
        c2729br.f9967e = (byte) 1;
        c2729br.f9966d = (byte) 114;
        c2729br.f9968f = (byte) 1;
        f11388b.mo11217ab().mo10897a(c2729br.mo11073b());
        m9822a(c2729br.mo11073b());
    }

    /* renamed from: i */
    public void m9808i() {
        C2729br c2729br = new C2729br();
        c2729br.f9967e = (byte) 1;
        c2729br.f9966d = (byte) 114;
        c2729br.f9968f = (byte) 2;
        f11388b.mo11217ab().mo10897a(c2729br.mo11073b());
        m9822a(c2729br.mo11073b());
    }

    /* renamed from: j */
    public void m9807j() {
        C2729br c2729br = new C2729br();
        c2729br.f9967e = (byte) 1;
        c2729br.f9966d = (byte) 87;
        c2729br.f9968f = (byte) 0;
        f11388b.mo11217ab().mo10897a(c2729br.mo11073b());
        m9822a(c2729br.mo11073b());
    }

    /* renamed from: k */
    public void m9806k() {
        C2729br c2729br = new C2729br();
        c2729br.f9967e = (byte) 2;
        c2729br.f9966d = DroneMap.f12611n;
        c2729br.f9968f = (byte) 0;
        f11388b.mo11217ab().mo10897a(c2729br.mo11073b());
        m9822a(c2729br.mo11073b());
    }

    /* renamed from: l */
    public void m9805l() {
        C2729br c2729br = new C2729br();
        c2729br.f9967e = (byte) 1;
        c2729br.f9966d = (byte) 84;
        c2729br.f9968f = (byte) 0;
        f11388b.mo11217ab().mo10897a(c2729br.mo11073b());
        m9822a(c2729br.mo11073b());
    }

    /* renamed from: m */
    public void m9804m() {
        C2729br c2729br = new C2729br();
        c2729br.f9967e = (byte) 1;
        c2729br.f9966d = (byte) 88;
        c2729br.f9968f = (byte) 0;
        f11388b.mo11217ab().mo10897a(c2729br.mo11073b());
        m9822a(c2729br.mo11073b());
    }

    /* renamed from: n */
    public void m9803n() {
        C2729br c2729br = new C2729br();
        c2729br.f9967e = (byte) 1;
        c2729br.f9966d = (byte) 86;
        c2729br.f9968f = (byte) 2;
        f11388b.mo11217ab().mo10897a(c2729br.mo11073b());
        m9822a(c2729br.mo11073b());
    }

    /* renamed from: o */
    public void m9802o() {
        C2729br c2729br = new C2729br();
        c2729br.f9967e = (byte) 1;
        c2729br.f9966d = C3531c.f14197f;
        c2729br.f9968f = (byte) 1;
        f11388b.mo11217ab().mo10897a(c2729br.mo11073b());
        m9822a(c2729br.mo11073b());
    }

    /* renamed from: p */
    public void m9801p() {
        C2729br c2729br = new C2729br();
        c2729br.f9967e = (byte) 1;
        c2729br.f9966d = (byte) 86;
        c2729br.f9968f = (byte) 1;
        f11388b.mo11217ab().mo10897a(c2729br.mo11073b());
        m9822a(c2729br.mo11073b());
    }

    /* renamed from: q */
    public void m9800q() {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 148;
        c2770c.f10262b = 2;
        c2770c.f10264d.m11057a((short) 1);
        f11388b.mo11217ab().mo10897a(c2770c);
        m9822a(c2770c);
    }

    /* renamed from: r */
    public void m9799r() {
        C2770c c2770c = new C2770c();
        c2770c.f10263c = 122;
        c2770c.f10262b = 2;
        c2770c.f10264d.m11055b((byte) 10);
        c2770c.f10264d.m11055b((byte) 0);
        f11388b.mo11217ab().mo10897a(c2770c);
        m9822a(c2770c);
    }
}
