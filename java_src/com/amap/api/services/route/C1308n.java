package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
/* renamed from: com.amap.api.services.route.n */
/* loaded from: classes.dex */
class C1308n implements Parcelable.Creator<RouteSearch.DriveRouteQuery> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteSearch.DriveRouteQuery createFromParcel(Parcel parcel) {
        return new RouteSearch.DriveRouteQuery(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteSearch.DriveRouteQuery[] newArray(int i) {
        return new RouteSearch.DriveRouteQuery[i];
    }
}
