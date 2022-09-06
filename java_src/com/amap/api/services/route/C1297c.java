package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.route.c */
/* loaded from: classes.dex */
class C1297c implements Parcelable.Creator<BusStep> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BusStep createFromParcel(Parcel parcel) {
        return new BusStep(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BusStep[] newArray(int i) {
        return null;
    }
}
