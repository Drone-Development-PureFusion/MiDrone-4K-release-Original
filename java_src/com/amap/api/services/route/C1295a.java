package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.route.a */
/* loaded from: classes.dex */
class C1295a implements Parcelable.Creator<BusPath> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BusPath createFromParcel(Parcel parcel) {
        return new BusPath(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BusPath[] newArray(int i) {
        return null;
    }
}
