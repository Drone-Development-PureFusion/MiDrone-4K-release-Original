package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.route.g */
/* loaded from: classes.dex */
class C1301g implements Parcelable.Creator<DriveRouteResult> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DriveRouteResult createFromParcel(Parcel parcel) {
        return new DriveRouteResult(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DriveRouteResult[] newArray(int i) {
        return new DriveRouteResult[i];
    }
}
