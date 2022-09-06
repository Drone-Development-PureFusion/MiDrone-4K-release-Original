package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.geocoder.c */
/* loaded from: classes.dex */
class C1272c implements Parcelable.Creator<RegeocodeAddress> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RegeocodeAddress createFromParcel(Parcel parcel) {
        return new RegeocodeAddress(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public RegeocodeAddress[] newArray(int i) {
        return null;
    }
}
