package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.route.r */
/* loaded from: classes.dex */
class C1312r implements Parcelable.Creator<SearchCity> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public SearchCity createFromParcel(Parcel parcel) {
        return new SearchCity(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public SearchCity[] newArray(int i) {
        return null;
    }
}
