package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.route.t */
/* loaded from: classes.dex */
class C1314t implements Parcelable.Creator<WalkRouteResult> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WalkRouteResult createFromParcel(Parcel parcel) {
        return new WalkRouteResult(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WalkRouteResult[] newArray(int i) {
        return new WalkRouteResult[i];
    }
}
