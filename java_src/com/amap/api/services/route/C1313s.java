package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.route.s */
/* loaded from: classes.dex */
class C1313s implements Parcelable.Creator<WalkPath> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WalkPath createFromParcel(Parcel parcel) {
        return new WalkPath(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public WalkPath[] newArray(int i) {
        return null;
    }
}
