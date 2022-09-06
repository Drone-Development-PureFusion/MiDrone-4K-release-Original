package com.amap.api.trace;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
/* loaded from: classes.dex */
public class TraceLocation {

    /* renamed from: f */
    private static DecimalFormat f4516f = new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US));

    /* renamed from: a */
    private double f4517a;

    /* renamed from: b */
    private double f4518b;

    /* renamed from: c */
    private float f4519c;

    /* renamed from: d */
    private float f4520d;

    /* renamed from: e */
    private long f4521e;

    public TraceLocation() {
    }

    public TraceLocation(double d, double d2, float f, float f2, long j) {
        this.f4517a = m16751a(d);
        this.f4518b = m16751a(d2);
        this.f4519c = (int) ((3600.0f * f) / 1000.0f);
        this.f4520d = (int) f2;
        this.f4521e = j;
    }

    /* renamed from: a */
    private static double m16751a(double d) {
        return Double.parseDouble(f4516f.format(d));
    }

    public TraceLocation copy() {
        TraceLocation traceLocation = new TraceLocation();
        traceLocation.f4520d = this.f4520d;
        traceLocation.f4517a = this.f4517a;
        traceLocation.f4518b = this.f4518b;
        traceLocation.f4519c = this.f4519c;
        traceLocation.f4521e = this.f4521e;
        return traceLocation;
    }

    public float getBearing() {
        return this.f4520d;
    }

    public double getLatitude() {
        return this.f4517a;
    }

    public double getLongitude() {
        return this.f4518b;
    }

    public float getSpeed() {
        return this.f4519c;
    }

    public long getTime() {
        return this.f4521e;
    }

    public void setBearing(float f) {
        this.f4520d = (int) f;
    }

    public void setLatitude(double d) {
        this.f4517a = m16751a(d);
    }

    public void setLongitude(double d) {
        this.f4518b = m16751a(d);
    }

    public void setSpeed(float f) {
        this.f4519c = (int) ((3600.0f * f) / 1000.0f);
    }

    public void setTime(long j) {
        this.f4521e = j;
    }

    public String toString() {
        return this.f4517a + ",longtitude " + this.f4518b + ",speed " + this.f4519c + ",bearing " + this.f4520d + ",time " + this.f4521e;
    }
}
