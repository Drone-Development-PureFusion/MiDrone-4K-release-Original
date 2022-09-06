package com.amap.api.maps.model;
/* loaded from: classes.dex */
public class RoutePara {

    /* renamed from: a */
    private int f3783a = 0;

    /* renamed from: b */
    private int f3784b = 0;

    /* renamed from: c */
    private LatLng f3785c;

    /* renamed from: d */
    private LatLng f3786d;

    /* renamed from: e */
    private String f3787e;

    /* renamed from: f */
    private String f3788f;

    public int getDrivingRouteStyle() {
        return this.f3783a;
    }

    public String getEndName() {
        return this.f3788f;
    }

    public LatLng getEndPoint() {
        return this.f3786d;
    }

    public String getStartName() {
        return this.f3787e;
    }

    public LatLng getStartPoint() {
        return this.f3785c;
    }

    public int getTransitRouteStyle() {
        return this.f3784b;
    }

    public void setDrivingRouteStyle(int i) {
        if (i < 0 || i >= 9) {
            return;
        }
        this.f3783a = i;
    }

    public void setEndName(String str) {
        this.f3788f = str;
    }

    public void setEndPoint(LatLng latLng) {
        this.f3786d = latLng;
    }

    public void setStartName(String str) {
        this.f3787e = str;
    }

    public void setStartPoint(LatLng latLng) {
        this.f3785c = latLng;
    }

    public void setTransitRouteStyle(int i) {
        if (i < 0 || i >= 6) {
            return;
        }
        this.f3784b = i;
    }
}
