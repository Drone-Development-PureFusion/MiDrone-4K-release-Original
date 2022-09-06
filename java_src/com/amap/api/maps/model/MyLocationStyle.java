package com.amap.api.maps.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import it.p235a.p236a.AbstractC4863e;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
/* loaded from: classes.dex */
public class MyLocationStyle implements Parcelable {

    /* renamed from: a */
    private BitmapDescriptor f3733a;

    /* renamed from: b */
    private float f3734b = 0.5f;

    /* renamed from: c */
    private float f3735c = 0.5f;

    /* renamed from: d */
    private int f3736d = Color.argb(100, 0, 0, (int) Opcodes.GETFIELD);

    /* renamed from: e */
    private int f3737e = Color.argb(255, 0, 0, (int) AbstractC4863e.f20780A);

    /* renamed from: f */
    private float f3738f = 1.0f;

    public MyLocationStyle anchor(float f, float f2) {
        this.f3734b = f;
        this.f3735c = f2;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.f3734b;
    }

    public float getAnchorV() {
        return this.f3735c;
    }

    public BitmapDescriptor getMyLocationIcon() {
        return this.f3733a;
    }

    public int getRadiusFillColor() {
        return this.f3736d;
    }

    public int getStrokeColor() {
        return this.f3737e;
    }

    public float getStrokeWidth() {
        return this.f3738f;
    }

    public MyLocationStyle myLocationIcon(BitmapDescriptor bitmapDescriptor) {
        this.f3733a = bitmapDescriptor;
        return this;
    }

    public MyLocationStyle radiusFillColor(int i) {
        this.f3736d = i;
        return this;
    }

    public MyLocationStyle strokeColor(int i) {
        this.f3737e = i;
        return this;
    }

    public MyLocationStyle strokeWidth(float f) {
        this.f3738f = f;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3733a, i);
        parcel.writeFloat(this.f3734b);
        parcel.writeFloat(this.f3735c);
        parcel.writeInt(this.f3736d);
        parcel.writeInt(this.f3737e);
        parcel.writeFloat(this.f3738f);
    }
}
