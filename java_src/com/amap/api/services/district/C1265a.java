package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.district.a */
/* loaded from: classes.dex */
class C1265a implements Parcelable.Creator<DistrictItem> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DistrictItem createFromParcel(Parcel parcel) {
        return new DistrictItem(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DistrictItem[] newArray(int i) {
        return new DistrictItem[i];
    }
}
