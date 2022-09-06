package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.busline.b */
/* loaded from: classes.dex */
class C1161b implements Parcelable.Creator<BusStationItem> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BusStationItem createFromParcel(Parcel parcel) {
        return new BusStationItem(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BusStationItem[] newArray(int i) {
        return null;
    }
}
