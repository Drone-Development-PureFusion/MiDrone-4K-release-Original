package com.fimi.soul.drone.p203i;

import com.fimi.soul.drone.C2822e;
import com.fimi.soul.drone.p193d.p194a.C2770c;
import com.fimi.soul.drone.p193d.p194a.p195a.C2688ad;
/* renamed from: com.fimi.soul.drone.i.f */
/* loaded from: classes.dex */
public class C2911f extends C2822e {

    /* renamed from: b */
    private byte f10945b;

    /* renamed from: c */
    private byte f10946c;

    /* renamed from: d */
    private short f10947d;

    /* renamed from: e */
    private byte f10948e;

    /* renamed from: f */
    private byte f10949f;

    /* renamed from: a */
    public byte m10320a() {
        return this.f10945b;
    }

    /* renamed from: a */
    public C2770c m10318a(int i, C2911f c2911f) {
        C2688ad c2688ad = new C2688ad();
        c2688ad.f9640d = (byte) 0;
        c2688ad.f9641e = (byte) 13;
        c2688ad.f9642f = (byte) 18;
        c2688ad.f9643g = c2911f.m10315b();
        c2688ad.f9644h = (short) ((i * 1024) / 100.0f);
        c2688ad.f9645i = (byte) 1;
        return c2688ad.mo11073b();
    }

    /* renamed from: a */
    public C2770c m10316a(boolean z, C2911f c2911f) {
        C2688ad c2688ad = new C2688ad();
        c2688ad.f9640d = (byte) 0;
        c2688ad.f9641e = (byte) 13;
        c2688ad.f9642f = (byte) 18;
        if (z) {
            c2688ad.f9643g = (byte) 1;
        } else {
            c2688ad.f9643g = (byte) 0;
        }
        c2688ad.f9644h = c2911f.m10312c();
        c2688ad.f9645i = c2911f.m10310d();
        return c2688ad.mo11073b();
    }

    /* renamed from: a */
    public void m10319a(byte b) {
        this.f10945b = b;
    }

    /* renamed from: a */
    public void m10317a(short s) {
        this.f10947d = s;
    }

    /* renamed from: b */
    public byte m10315b() {
        return this.f10946c;
    }

    /* renamed from: b */
    public C2770c m10313b(int i, C2911f c2911f) {
        C2688ad c2688ad = new C2688ad();
        c2688ad.f9640d = (byte) 0;
        c2688ad.f9641e = (byte) 13;
        c2688ad.f9642f = (byte) 18;
        c2688ad.f9643g = c2911f.m10315b();
        c2688ad.f9644h = c2911f.m10312c();
        if (i == 0) {
            c2688ad.f9645i = (byte) 1;
        } else if (i == 1) {
            c2688ad.f9645i = (byte) 2;
        }
        return c2688ad.mo11073b();
    }

    /* renamed from: b */
    public void m10314b(byte b) {
        this.f10946c = b;
    }

    /* renamed from: c */
    public short m10312c() {
        return this.f10947d;
    }

    /* renamed from: c */
    public void m10311c(byte b) {
        this.f10948e = b;
    }

    /* renamed from: d */
    public byte m10310d() {
        return this.f10948e;
    }

    /* renamed from: d */
    public void m10309d(byte b) {
        this.f10949f = b;
    }

    /* renamed from: e */
    public byte m10308e() {
        return this.f10949f;
    }

    /* renamed from: f */
    public C2770c m10307f() {
        C2688ad c2688ad = new C2688ad();
        c2688ad.f9640d = (byte) 0;
        c2688ad.f9641e = (byte) 13;
        c2688ad.f9642f = (byte) 19;
        c2688ad.f9643g = (byte) 1;
        c2688ad.f9644h = (short) 0;
        c2688ad.f9645i = (byte) 2;
        return c2688ad.mo11073b();
    }

    /* renamed from: g */
    public boolean m10306g() {
        return this.f10948e == 2 && this.f10949f == 0;
    }

    /* renamed from: h */
    public boolean m10305h() {
        return this.f10948e == 2;
    }

    /* renamed from: i */
    public boolean m10304i() {
        return this.f10946c == 1;
    }

    /* renamed from: j */
    public boolean m10303j() {
        return this.f10949f == 0;
    }
}
