package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p001v4.view.ViewCompat;
/* loaded from: classes.dex */
public final class ArcOptions implements Parcelable {
    public static final ArcOptionsCreator CREATOR = new ArcOptionsCreator();

    /* renamed from: a */
    String f3643a;

    /* renamed from: b */
    private LatLng f3644b;

    /* renamed from: c */
    private LatLng f3645c;

    /* renamed from: d */
    private LatLng f3646d;

    /* renamed from: e */
    private float f3647e = 10.0f;

    /* renamed from: f */
    private int f3648f = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: g */
    private float f3649g = 0.0f;

    /* renamed from: h */
    private boolean f3650h = true;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLng getEnd() {
        return this.f3646d;
    }

    public LatLng getPassed() {
        return this.f3645c;
    }

    public LatLng getStart() {
        return this.f3644b;
    }

    public int getStrokeColor() {
        return this.f3648f;
    }

    public float getStrokeWidth() {
        return this.f3647e;
    }

    public float getZIndex() {
        return this.f3649g;
    }

    public boolean isVisible() {
        return this.f3650h;
    }

    public ArcOptions point(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        this.f3644b = latLng;
        this.f3645c = latLng2;
        this.f3646d = latLng3;
        return this;
    }

    public ArcOptions strokeColor(int i) {
        this.f3648f = i;
        return this;
    }

    public ArcOptions strokeWidth(float f) {
        this.f3647e = f;
        return this;
    }

    public ArcOptions visible(boolean z) {
        this.f3650h = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        if (this.f3644b != null) {
            bundle.putDouble("startlat", this.f3644b.latitude);
            bundle.putDouble("startlng", this.f3644b.longitude);
        }
        if (this.f3645c != null) {
            bundle.putDouble("passedlat", this.f3645c.latitude);
            bundle.putDouble("passedlng", this.f3645c.longitude);
        }
        if (this.f3646d != null) {
            bundle.putDouble("endlat", this.f3646d.latitude);
            bundle.putDouble("endlng", this.f3646d.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeFloat(this.f3647e);
        parcel.writeInt(this.f3648f);
        parcel.writeFloat(this.f3649g);
        parcel.writeByte((byte) (this.f3650h ? 1 : 0));
        parcel.writeString(this.f3643a);
    }

    public ArcOptions zIndex(float f) {
        this.f3649g = f;
        return this;
    }
}
