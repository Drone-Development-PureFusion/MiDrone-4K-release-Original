package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.geocoder.a */
/* loaded from: classes.dex */
class C1270a implements Parcelable.Creator<BusinessArea> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BusinessArea createFromParcel(Parcel parcel) {
        return new BusinessArea(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BusinessArea[] newArray(int i) {
        return new BusinessArea[i];
    }
}
