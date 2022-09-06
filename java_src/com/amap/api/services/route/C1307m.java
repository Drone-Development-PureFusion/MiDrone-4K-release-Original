package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
/* renamed from: com.amap.api.services.route.m */
/* loaded from: classes.dex */
class C1307m implements Parcelable.Creator<RouteSearch.BusRouteQuery> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteSearch.BusRouteQuery createFromParcel(Parcel parcel) {
        return new RouteSearch.BusRouteQuery(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteSearch.BusRouteQuery[] newArray(int i) {
        return new RouteSearch.BusRouteQuery[i];
    }
}
