package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.poisearch.h */
/* loaded from: classes.dex */
class C1286h implements Parcelable.Creator<PoiItemDetail> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PoiItemDetail createFromParcel(Parcel parcel) {
        return new PoiItemDetail(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PoiItemDetail[] newArray(int i) {
        return new PoiItemDetail[i];
    }
}
