package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.route.b */
/* loaded from: classes.dex */
class C1296b implements Parcelable.Creator<BusRouteResult> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BusRouteResult createFromParcel(Parcel parcel) {
        return new BusRouteResult(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BusRouteResult[] newArray(int i) {
        return new BusRouteResult[i];
    }
}
