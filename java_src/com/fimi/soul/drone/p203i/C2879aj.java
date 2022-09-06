package com.fimi.soul.drone.p203i;

import com.fimi.kernel.utils.C2275t;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.aj */
/* loaded from: classes.dex */
public class C2879aj extends C2822e {

    /* renamed from: b */
    public double f10758b;

    /* renamed from: c */
    public double f10759c;

    /* renamed from: d */
    public double f10760d;

    /* renamed from: e */
    public double f10761e;

    /* renamed from: f */
    public double f10762f;

    /* renamed from: g */
    public double f10763g;

    /* renamed from: h */
    public byte f10764h;

    public C2879aj(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public byte m10596a() {
        return this.f10764h;
    }

    /* renamed from: a */
    public double m10595a(String str, String str2, String str3) {
        return Math.sqrt(StrictMath.pow(Float.valueOf(str).floatValue(), 2.0d) + StrictMath.pow(Float.valueOf(str2).floatValue(), 2.0d) + StrictMath.pow(Float.valueOf(str3).floatValue(), 2.0d));
    }

    /* renamed from: a */
    public void m10594a(short s, short s2, short s3, short s4, short s5, short s6, byte b) {
        this.f10758b = s;
        this.f10759c = s2;
        this.f10760d = s3;
        this.f10761e = s4;
        this.f10762f = s5;
        this.f10763g = s6;
        this.f10764h = b;
        if (this.f10431a != null) {
            this.f10431a.mo11220a(C2678d.EnumC2679a.IMU_INFO);
        }
    }

    /* renamed from: b */
    public String m10593b() {
        return C2275t.m12790b(this.f10758b / 100.0d, 2);
    }

    /* renamed from: c */
    public String m10592c() {
        return C2275t.m12790b(this.f10759c / 100.0d, 2);
    }

    /* renamed from: d */
    public String m10591d() {
        return C2275t.m12790b(this.f10760d / 100.0d, 2);
    }

    /* renamed from: e */
    public String m10590e() {
        return C2275t.m12790b(m10595a(m10593b(), m10592c(), m10591d()), 2);
    }

    /* renamed from: f */
    public String m10589f() {
        return C2275t.m12790b(this.f10761e / 100.0d, 2);
    }

    /* renamed from: g */
    public String m10588g() {
        return C2275t.m12790b(this.f10762f / 100.0d, 2);
    }

    /* renamed from: h */
    public String m10587h() {
        return C2275t.m12790b(this.f10763g / 100.0d, 2);
    }

    /* renamed from: i */
    public String m10586i() {
        return C2275t.m12790b(m10595a(m10589f(), m10588g(), m10587h()), 2);
    }

    public String toString() {
        return "IMUInfo{gyroX=" + this.f10758b + ", gyroY=" + this.f10759c + ", gyroZ=" + this.f10760d + ", accelX=" + this.f10761e + ", accelY=" + this.f10762f + ", accelZ=" + this.f10763g + ", cmdACK=" + ((int) this.f10764h) + C0359h.f726w;
    }
}
