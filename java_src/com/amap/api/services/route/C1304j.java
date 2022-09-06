package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.route.j */
/* loaded from: classes.dex */
class C1304j implements Parcelable.Creator<RouteBusLineItem> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteBusLineItem createFromParcel(Parcel parcel) {
        return new RouteBusLineItem(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteBusLineItem[] newArray(int i) {
        return null;
    }
}
