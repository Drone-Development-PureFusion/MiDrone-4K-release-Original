package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.district.c */
/* loaded from: classes.dex */
class C1267c implements Parcelable.Creator<DistrictSearchQuery> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DistrictSearchQuery createFromParcel(Parcel parcel) {
        boolean z = true;
        DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
        districtSearchQuery.setKeywords(parcel.readString());
        districtSearchQuery.setKeywordsLevel(parcel.readString());
        districtSearchQuery.setPageNum(parcel.readInt());
        districtSearchQuery.setPageSize(parcel.readInt());
        districtSearchQuery.setShowChild(parcel.readByte() == 1);
        if (parcel.readByte() != 1) {
            z = false;
        }
        districtSearchQuery.setShowBoundary(z);
        return districtSearchQuery;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DistrictSearchQuery[] newArray(int i) {
        return new DistrictSearchQuery[i];
    }
}
