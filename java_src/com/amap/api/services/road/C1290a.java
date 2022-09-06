package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.road.a */
/* loaded from: classes.dex */
class C1290a implements Parcelable.Creator<Crossroad> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Crossroad createFromParcel(Parcel parcel) {
        return new Crossroad(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Crossroad[] newArray(int i) {
        return null;
    }
}
