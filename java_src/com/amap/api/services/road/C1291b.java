package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.road.b */
/* loaded from: classes.dex */
class C1291b implements Parcelable.Creator<Road> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Road createFromParcel(Parcel parcel) {
        return new Road(parcel, (C1291b) null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Road[] newArray(int i) {
        return null;
    }
}
