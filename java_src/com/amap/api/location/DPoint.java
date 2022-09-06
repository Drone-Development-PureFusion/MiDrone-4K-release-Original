package com.amap.api.location;
/* loaded from: classes.dex */
public class DPoint {

    /* renamed from: a */
    private double f2008a;

    /* renamed from: b */
    private double f2009b;

    public DPoint() {
    }

    public DPoint(double d, double d2) {
        double d3 = 90.0d;
        double d4 = -180.0d;
        double d5 = -90.0d;
        double d6 = d2 <= 180.0d ? d2 : 180.0d;
        d4 = d6 >= -180.0d ? d6 : d4;
        d3 = d <= 90.0d ? d : d3;
        d5 = d3 >= -90.0d ? d3 : d5;
        this.f2008a = d4;
        this.f2009b = d5;
    }

    public double getLatitude() {
        return this.f2009b;
    }

    public double getLongitude() {
        return this.f2008a;
    }

    public void setLatitude(double d) {
        double d2 = 90.0d;
        double d3 = -90.0d;
        if (d <= 90.0d) {
            d2 = d;
        }
        if (d2 >= -90.0d) {
            d3 = d2;
        }
        this.f2009b = d3;
    }

    public void setLongitude(double d) {
        double d2 = 180.0d;
        double d3 = -180.0d;
        if (d <= 180.0d) {
            d2 = d;
        }
        if (d2 >= -180.0d) {
            d3 = d2;
        }
        this.f2008a = d3;
    }
}
