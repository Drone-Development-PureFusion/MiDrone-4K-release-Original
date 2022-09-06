package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.poisearch.e */
/* loaded from: classes.dex */
class C1283e implements Parcelable.Creator<Hotel> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Hotel createFromParcel(Parcel parcel) {
        return new Hotel(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Hotel[] newArray(int i) {
        return null;
    }
}
