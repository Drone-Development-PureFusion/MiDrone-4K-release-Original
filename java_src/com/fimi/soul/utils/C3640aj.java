package com.fimi.soul.utils;

import java.util.Locale;
/* renamed from: com.fimi.soul.utils.aj */
/* loaded from: classes.dex */
public class C3640aj {

    /* renamed from: a */
    private double f14798a;

    public C3640aj(double d) {
        m7697a(d);
    }

    /* renamed from: a */
    public double m7698a() {
        return this.f14798a;
    }

    /* renamed from: a */
    public void m7697a(double d) {
        this.f14798a = d;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C3640aj) && this.f14798a == ((C3640aj) obj).f14798a;
    }

    public String toString() {
        return this.f14798a >= 1000.0d ? String.format(Locale.US, "%2.1f km", Double.valueOf(this.f14798a / 1000.0d)) : this.f14798a >= 1.0d ? String.format(Locale.US, "%2.1f m", Double.valueOf(this.f14798a)) : this.f14798a >= 0.001d ? String.format(Locale.US, "%2.1f mm", Double.valueOf(this.f14798a * 1000.0d)) : this.f14798a + " m";
    }
}
