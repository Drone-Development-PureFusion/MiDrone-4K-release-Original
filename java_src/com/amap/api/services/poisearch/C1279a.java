package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.poisearch.a */
/* loaded from: classes.dex */
class C1279a implements Parcelable.Creator<Cinema> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Cinema createFromParcel(Parcel parcel) {
        return new Cinema(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Cinema[] newArray(int i) {
        return null;
    }
}
