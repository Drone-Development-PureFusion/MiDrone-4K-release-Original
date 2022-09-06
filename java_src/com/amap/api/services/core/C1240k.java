package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.core.k */
/* loaded from: classes.dex */
class C1240k implements Parcelable.Creator<LatLonPoint> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public LatLonPoint createFromParcel(Parcel parcel) {
        return new LatLonPoint(parcel, (C1240k) null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public LatLonPoint[] newArray(int i) {
        return new LatLonPoint[i];
    }
}
