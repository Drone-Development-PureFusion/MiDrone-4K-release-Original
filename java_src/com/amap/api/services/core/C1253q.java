package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.core.q */
/* loaded from: classes.dex */
class C1253q implements Parcelable.Creator<PoiItem> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PoiItem createFromParcel(Parcel parcel) {
        return new PoiItem(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PoiItem[] newArray(int i) {
        return new PoiItem[i];
    }
}
