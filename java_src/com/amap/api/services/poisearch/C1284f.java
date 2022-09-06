package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.poisearch.f */
/* loaded from: classes.dex */
class C1284f implements Parcelable.Creator<Photo> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Photo createFromParcel(Parcel parcel) {
        return new Photo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Photo[] newArray(int i) {
        return null;
    }
}
