package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class BusRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<BusRouteResult> CREATOR = new C1296b();

    /* renamed from: a */
    private float f4434a;

    /* renamed from: b */
    private List<BusPath> f4435b;

    /* renamed from: c */
    private RouteSearch.BusRouteQuery f4436c;

    public BusRouteResult() {
        this.f4435b = new ArrayList();
    }

    public BusRouteResult(Parcel parcel) {
        super(parcel);
        this.f4435b = new ArrayList();
        this.f4434a = parcel.readFloat();
        this.f4435b = parcel.createTypedArrayList(BusPath.CREATOR);
        this.f4436c = (RouteSearch.BusRouteQuery) parcel.readParcelable(RouteSearch.BusRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearch.BusRouteQuery getBusQuery() {
        return this.f4436c;
    }

    public List<BusPath> getPaths() {
        return this.f4435b;
    }

    public float getTaxiCost() {
        return this.f4434a;
    }

    public void setBusQuery(RouteSearch.BusRouteQuery busRouteQuery) {
        this.f4436c = busRouteQuery;
    }

    public void setPaths(List<BusPath> list) {
        this.f4435b = list;
    }

    public void setTaxiCost(float f) {
        this.f4434a = f;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f4434a);
        parcel.writeTypedList(this.f4435b);
        parcel.writeParcelable(this.f4436c, i);
    }
}
