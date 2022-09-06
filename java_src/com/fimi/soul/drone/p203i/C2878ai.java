package com.fimi.soul.drone.p203i;

import com.fimi.kernel.utils.C2275t;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.ai */
/* loaded from: classes.dex */
public class C2878ai extends C2822e {

    /* renamed from: b */
    public short f10752b;

    /* renamed from: c */
    public short f10753c;

    /* renamed from: d */
    public short f10754d;

    /* renamed from: e */
    public short f10755e;

    /* renamed from: f */
    public short f10756f;

    /* renamed from: g */
    public short f10757g;

    public C2878ai(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public double m10605a(float f, float f2, float f3) {
        return Math.sqrt(StrictMath.pow(f, 2.0d) + StrictMath.pow(f2, 2.0d) + StrictMath.pow(f3, 2.0d));
    }

    /* renamed from: a */
    public float m10606a() {
        return (Math.round(this.f10752b * 100) / 100) / 100.0f;
    }

    /* renamed from: a */
    public void m10604a(short s, short s2, short s3, short s4, short s5, short s6) {
        this.f10752b = s;
        this.f10753c = s2;
        this.f10754d = s3;
        this.f10755e = s4;
        this.f10756f = s5;
        this.f10757g = s6;
        if (this.f10431a != null) {
            this.f10431a.mo11220a(C2678d.EnumC2679a.IMU_INFO);
        }
    }

    /* renamed from: b */
    public float m10603b() {
        return (Math.round(this.f10753c * 100) / 100) / 100.0f;
    }

    /* renamed from: c */
    public float m10602c() {
        return (Math.round(this.f10754d * 100) / 100) / 100.0f;
    }

    /* renamed from: d */
    public String m10601d() {
        return C2275t.m12790b(m10605a(m10606a(), m10603b(), m10602c()), 2);
    }

    /* renamed from: e */
    public float m10600e() {
        return (Math.round(this.f10755e * 100) / 100) / 100.0f;
    }

    /* renamed from: f */
    public float m10599f() {
        return (Math.round(this.f10756f * 100) / 100) / 100.0f;
    }

    /* renamed from: g */
    public float m10598g() {
        return (Math.round(this.f10757g * 100) / 100) / 100.0f;
    }

    /* renamed from: h */
    public String m10597h() {
        return C2275t.m12790b(m10605a(m10600e(), m10599f(), m10598g()), 2);
    }

    public String toString() {
        return "IMUInfo{gyroX=" + ((int) this.f10752b) + ", gyroY=" + ((int) this.f10753c) + ", gyroZ=" + ((int) this.f10754d) + ", accelX=" + ((int) this.f10755e) + ", accelY=" + ((int) this.f10756f) + ", accelZ=" + ((int) this.f10757g) + C0359h.f726w;
    }
}
