package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public class RouteBusWalkItem extends WalkPath implements Parcelable {
    public static final Parcelable.Creator<RouteBusWalkItem> CREATOR = new C1305k();

    /* renamed from: a */
    private LatLonPoint f4472a;

    /* renamed from: b */
    private LatLonPoint f4473b;

    public RouteBusWalkItem() {
    }

    public RouteBusWalkItem(Parcel parcel) {
        super(parcel);
        this.f4472a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f4473b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getDestination() {
        return this.f4473b;
    }

    public LatLonPoint getOrigin() {
        return this.f4472a;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.f4473b = latLonPoint;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.f4472a = latLonPoint;
    }

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f4472a, i);
        parcel.writeParcelable(this.f4473b, i);
    }
}
