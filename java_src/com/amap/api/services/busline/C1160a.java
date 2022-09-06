package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.busline.a */
/* loaded from: classes.dex */
class C1160a implements Parcelable.Creator<BusLineItem> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BusLineItem createFromParcel(Parcel parcel) {
        return new BusLineItem(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BusLineItem[] newArray(int i) {
        return null;
    }
}
