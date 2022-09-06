package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.route.i */
/* loaded from: classes.dex */
class C1303i implements Parcelable.Creator<Path> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Path createFromParcel(Parcel parcel) {
        return new Path(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public Path[] newArray(int i) {
        return null;
    }
}
