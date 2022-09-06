package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.route.d */
/* loaded from: classes.dex */
class C1298d implements Parcelable.Creator<District> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public District createFromParcel(Parcel parcel) {
        return new District(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public District[] newArray(int i) {
        return null;
    }
}
