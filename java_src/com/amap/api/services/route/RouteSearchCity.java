package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RouteSearchCity extends SearchCity implements Parcelable {
    public static final Parcelable.Creator<RouteSearchCity> CREATOR = new C1311q();

    /* renamed from: a */
    List<District> f4500a;

    public RouteSearchCity() {
        this.f4500a = new ArrayList();
    }

    public RouteSearchCity(Parcel parcel) {
        super(parcel);
        this.f4500a = new ArrayList();
        this.f4500a = parcel.createTypedArrayList(District.CREATOR);
    }

    @Override // com.amap.api.services.route.SearchCity, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<District> getDistricts() {
        return this.f4500a;
    }

    public void setDistricts(List<District> list) {
        this.f4500a = list;
    }

    @Override // com.amap.api.services.route.SearchCity, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f4500a);
    }
}
