package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.route.h */
/* loaded from: classes.dex */
class C1302h implements Parcelable.Creator<DriveStep> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DriveStep createFromParcel(Parcel parcel) {
        return new DriveStep(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DriveStep[] newArray(int i) {
        return null;
    }
}
