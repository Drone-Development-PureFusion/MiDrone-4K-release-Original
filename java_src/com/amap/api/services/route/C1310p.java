package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
/* renamed from: com.amap.api.services.route.p */
/* loaded from: classes.dex */
class C1310p implements Parcelable.Creator<RouteSearch.WalkRouteQuery> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteSearch.WalkRouteQuery createFromParcel(Parcel parcel) {
        return new RouteSearch.WalkRouteQuery(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteSearch.WalkRouteQuery[] newArray(int i) {
        return new RouteSearch.WalkRouteQuery[i];
    }
}
