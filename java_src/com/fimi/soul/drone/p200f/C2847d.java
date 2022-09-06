package com.fimi.soul.drone.p200f;

import java.io.Serializable;
/* renamed from: com.fimi.soul.drone.f.d */
/* loaded from: classes.dex */
public class C2847d implements Serializable {

    /* renamed from: a */
    private double f10486a;

    /* renamed from: b */
    private double f10487b;

    /* renamed from: a */
    public double m10793a() {
        return this.f10486a;
    }

    /* renamed from: a */
    public void m10792a(double d) {
        this.f10486a = d;
    }

    /* renamed from: b */
    public double m10791b() {
        return this.f10487b;
    }

    /* renamed from: b */
    public void m10790b(double d) {
        this.f10487b = d;
    }

    public String toString() {
        return "GPSBean [lat=" + this.f10486a + ", lon=" + this.f10487b + "]";
    }
}
