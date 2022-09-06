package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.route.u */
/* loaded from: classes.dex */
class C1315u implements Parcelable.Creator<WalkStep> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WalkStep createFromParcel(Parcel parcel) {
        return new WalkStep(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WalkStep[] newArray(int i) {
        return null;
    }
}
