package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.route.f */
/* loaded from: classes.dex */
class C1300f implements Parcelable.Creator<DrivePath> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DrivePath createFromParcel(Parcel parcel) {
        return new DrivePath(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public DrivePath[] newArray(int i) {
        return null;
    }
}
