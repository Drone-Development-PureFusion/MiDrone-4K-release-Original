package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p001v4.view.ViewCompat;
/* loaded from: classes.dex */
public final class CircleOptions implements Parcelable {
    public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();

    /* renamed from: a */
    String f3659a;

    /* renamed from: b */
    private LatLng f3660b = null;

    /* renamed from: c */
    private double f3661c = 0.0d;

    /* renamed from: d */
    private float f3662d = 10.0f;

    /* renamed from: e */
    private int f3663e = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: f */
    private int f3664f = 0;

    /* renamed from: g */
    private float f3665g = 0.0f;

    /* renamed from: h */
    private boolean f3666h = true;

    public CircleOptions center(LatLng latLng) {
        this.f3660b = latLng;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int i) {
        this.f3664f = i;
        return this;
    }

    public LatLng getCenter() {
        return this.f3660b;
    }

    public int getFillColor() {
        return this.f3664f;
    }

    public double getRadius() {
        return this.f3661c;
    }

    public int getStrokeColor() {
        return this.f3663e;
    }

    public float getStrokeWidth() {
        return this.f3662d;
    }

    public float getZIndex() {
        return this.f3665g;
    }

    public boolean isVisible() {
        return this.f3666h;
    }

    public CircleOptions radius(double d) {
        this.f3661c = d;
        return this;
    }

    public CircleOptions strokeColor(int i) {
        this.f3663e = i;
        return this;
    }

    public CircleOptions strokeWidth(float f) {
        this.f3662d = f;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.f3666h = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        if (this.f3660b != null) {
            bundle.putDouble("lat", this.f3660b.latitude);
            bundle.putDouble("lng", this.f3660b.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.f3661c);
        parcel.writeFloat(this.f3662d);
        parcel.writeInt(this.f3663e);
        parcel.writeInt(this.f3664f);
        parcel.writeFloat(this.f3665g);
        parcel.writeByte((byte) (this.f3666h ? 1 : 0));
        parcel.writeString(this.f3659a);
    }

    public CircleOptions zIndex(float f) {
        this.f3665g = f;
        return this;
    }
}
