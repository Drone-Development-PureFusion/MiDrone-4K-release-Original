package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.amap.api.services.geocoder.b */
/* loaded from: classes.dex */
class C1271b implements Parcelable.Creator<GeocodeAddress> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public GeocodeAddress createFromParcel(Parcel parcel) {
        return new GeocodeAddress(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public GeocodeAddress[] newArray(int i) {
        return null;
    }
}
