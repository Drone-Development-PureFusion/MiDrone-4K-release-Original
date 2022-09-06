package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public class RouteResult implements Parcelable {
    public static final Parcelable.Creator<RouteResult> CREATOR = new C1306l();

    /* renamed from: a */
    private LatLonPoint f4474a;

    /* renamed from: b */
    private LatLonPoint f4475b;

    public RouteResult() {
    }

    public RouteResult(Parcel parcel) {
        this.f4474a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f4475b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getStartPos() {
        return this.f4474a;
    }

    public LatLonPoint getTargetPos() {
        return this.f4475b;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f4474a = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.f4475b = latLonPoint;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f4474a, i);
        parcel.writeParcelable(this.f4475b, i);
    }
}
