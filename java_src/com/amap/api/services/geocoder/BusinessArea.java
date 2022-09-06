package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public class BusinessArea implements Parcelable {
    public static final Parcelable.Creator<BusinessArea> CREATOR = new C1270a();

    /* renamed from: a */
    private LatLonPoint f4233a;

    /* renamed from: b */
    private String f4234b;

    public BusinessArea() {
    }

    public BusinessArea(Parcel parcel) {
        this.f4233a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f4234b = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getCenterPoint() {
        return this.f4233a;
    }

    public String getName() {
        return this.f4234b;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.f4233a = latLonPoint;
    }

    public void setName(String str) {
        this.f4234b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f4233a, i);
        parcel.writeString(this.f4234b);
    }
}
