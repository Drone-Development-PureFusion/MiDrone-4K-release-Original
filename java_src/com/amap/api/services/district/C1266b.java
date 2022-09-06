package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.district.b */
/* loaded from: classes.dex */
class C1266b implements Parcelable.Creator<DistrictResult> {

    /* renamed from: a */
    final /* synthetic */ DistrictResult f4232a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1266b(DistrictResult districtResult) {
        this.f4232a = districtResult;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DistrictResult createFromParcel(Parcel parcel) {
        return new DistrictResult(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DistrictResult[] newArray(int i) {
        return new DistrictResult[i];
    }
}
