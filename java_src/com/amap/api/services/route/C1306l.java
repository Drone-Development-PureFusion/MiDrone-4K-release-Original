package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.route.l */
/* loaded from: classes.dex */
class C1306l implements Parcelable.Creator<RouteResult> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteResult createFromParcel(Parcel parcel) {
        return new RouteResult(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteResult[] newArray(int i) {
        return new RouteResult[i];
    }
}
