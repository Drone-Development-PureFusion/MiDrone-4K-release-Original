package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.maps.model.b */
/* loaded from: classes.dex */
class C1145b implements Parcelable.Creator<Tile> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Tile createFromParcel(Parcel parcel) {
        return new Tile(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Tile[] newArray(int i) {
        return new Tile[i];
    }
}
