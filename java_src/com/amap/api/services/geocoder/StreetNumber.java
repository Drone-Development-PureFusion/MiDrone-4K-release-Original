package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public final class StreetNumber implements Parcelable {
    public static final Parcelable.Creator<StreetNumber> CREATOR = new C1274e();

    /* renamed from: a */
    private String f4280a;

    /* renamed from: b */
    private String f4281b;

    /* renamed from: c */
    private LatLonPoint f4282c;

    /* renamed from: d */
    private String f4283d;

    /* renamed from: e */
    private float f4284e;

    public StreetNumber() {
    }

    private StreetNumber(Parcel parcel) {
        this.f4280a = parcel.readString();
        this.f4281b = parcel.readString();
        this.f4282c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f4283d = parcel.readString();
        this.f4284e = parcel.readFloat();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ StreetNumber(Parcel parcel, C1274e c1274e) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDirection() {
        return this.f4283d;
    }

    public float getDistance() {
        return this.f4284e;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f4282c;
    }

    public String getNumber() {
        return this.f4281b;
    }

    public String getStreet() {
        return this.f4280a;
    }

    public void setDirection(String str) {
        this.f4283d = str;
    }

    public void setDistance(float f) {
        this.f4284e = f;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f4282c = latLonPoint;
    }

    public void setNumber(String str) {
        this.f4281b = str;
    }

    public void setStreet(String str) {
        this.f4280a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4280a);
        parcel.writeString(this.f4281b);
        parcel.writeValue(this.f4282c);
        parcel.writeString(this.f4283d);
        parcel.writeFloat(this.f4284e);
    }
}
