package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p001v4.view.ViewCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public final class PolygonOptions implements Parcelable {
    public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();

    /* renamed from: a */
    String f3759a;

    /* renamed from: c */
    private float f3761c = 10.0f;

    /* renamed from: d */
    private int f3762d = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: e */
    private int f3763e = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: f */
    private float f3764f = 0.0f;

    /* renamed from: g */
    private boolean f3765g = true;

    /* renamed from: b */
    private final List<LatLng> f3760b = new ArrayList();

    public PolygonOptions add(LatLng latLng) {
        this.f3760b.add(latLng);
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        this.f3760b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng latLng : iterable) {
            this.f3760b.add(latLng);
        }
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int i) {
        this.f3763e = i;
        return this;
    }

    public int getFillColor() {
        return this.f3763e;
    }

    public List<LatLng> getPoints() {
        return this.f3760b;
    }

    public int getStrokeColor() {
        return this.f3762d;
    }

    public float getStrokeWidth() {
        return this.f3761c;
    }

    public float getZIndex() {
        return this.f3764f;
    }

    public boolean isVisible() {
        return this.f3765g;
    }

    public PolygonOptions strokeColor(int i) {
        this.f3762d = i;
        return this;
    }

    public PolygonOptions strokeWidth(float f) {
        this.f3761c = f;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.f3765g = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f3760b);
        parcel.writeFloat(this.f3761c);
        parcel.writeInt(this.f3762d);
        parcel.writeInt(this.f3763e);
        parcel.writeFloat(this.f3764f);
        parcel.writeByte((byte) (this.f3765g ? 1 : 0));
        parcel.writeString(this.f3759a);
    }

    public PolygonOptions zIndex(float f) {
        this.f3764f = f;
        return this;
    }
}
