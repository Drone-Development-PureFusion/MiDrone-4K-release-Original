package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.route.k */
/* loaded from: classes.dex */
class C1305k implements Parcelable.Creator<RouteBusWalkItem> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteBusWalkItem createFromParcel(Parcel parcel) {
        return new RouteBusWalkItem(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RouteBusWalkItem[] newArray(int i) {
        return null;
    }
}
