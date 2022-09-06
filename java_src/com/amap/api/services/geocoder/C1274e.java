package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.geocoder.e */
/* loaded from: classes.dex */
class C1274e implements Parcelable.Creator<StreetNumber> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public StreetNumber createFromParcel(Parcel parcel) {
        return new StreetNumber(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public StreetNumber[] newArray(int i) {
        return null;
    }
}
