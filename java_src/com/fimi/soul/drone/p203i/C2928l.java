package com.fimi.soul.drone.p203i;

import com.fimi.kernel.utils.C2275t;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.drone.C2822e;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.drone.i.l */
/* loaded from: classes.dex */
public class C2928l extends C2822e {

    /* renamed from: b */
    public double f11059b;

    /* renamed from: c */
    public double f11060c;

    /* renamed from: d */
    public double f11061d;

    public C2928l(C2657a c2657a) {
        super(c2657a);
    }

    /* renamed from: a */
    public double m10223a(String str, String str2, String str3) {
        return Math.sqrt(StrictMath.pow(Float.valueOf(str).floatValue(), 2.0d) + StrictMath.pow(Float.valueOf(str2).floatValue(), 2.0d) + StrictMath.pow(Float.valueOf(str3).floatValue(), 2.0d));
    }

    /* renamed from: a */
    public String m10224a() {
        return C2275t.m12790b(this.f11059b / 100.0d, 2);
    }

    /* renamed from: a */
    public void m10222a(short s, short s2, short s3) {
        this.f11059b = s;
        this.f11060c = s2;
        this.f11061d = s3;
        if (this.f10431a != null) {
            this.f10431a.mo11220a(C2678d.EnumC2679a.IMU_COMPASS);
        }
    }

    /* renamed from: b */
    public String m10221b() {
        return C2275t.m12790b(this.f11060c / 100.0d, 2);
    }

    /* renamed from: c */
    public String m10220c() {
        return C2275t.m12790b(this.f11061d / 100.0d, 2);
    }

    /* renamed from: d */
    public String m10219d() {
        return C2275t.m12790b(m10223a(m10224a(), m10221b(), m10220c()), 2);
    }

    public String toString() {
        return "CompassInfo{compassOneX=" + this.f11059b + ", compassOneY=" + this.f11060c + ", compassOneZ=" + this.f11061d + C0359h.f726w;
    }
}
