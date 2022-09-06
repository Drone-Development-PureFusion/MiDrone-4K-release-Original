package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.fence.a */
/* loaded from: classes.dex */
class C0757a implements Parcelable.Creator<Fence> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Fence createFromParcel(Parcel parcel) {
        return new Fence(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Fence[] newArray(int i) {
        return new Fence[i];
    }
}
