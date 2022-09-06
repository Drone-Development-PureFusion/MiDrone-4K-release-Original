package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
/* renamed from: com.amap.api.services.route.o */
/* loaded from: classes.dex */
class C1309o implements Parcelable.Creator<RouteSearch.FromAndTo> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteSearch.FromAndTo createFromParcel(Parcel parcel) {
        return new RouteSearch.FromAndTo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteSearch.FromAndTo[] newArray(int i) {
        return new RouteSearch.FromAndTo[i];
    }
}
