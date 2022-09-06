package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.geocoder.d */
/* loaded from: classes.dex */
class C1273d implements Parcelable.Creator<RegeocodeRoad> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RegeocodeRoad createFromParcel(Parcel parcel) {
        return new RegeocodeRoad(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RegeocodeRoad[] newArray(int i) {
        return null;
    }
}
