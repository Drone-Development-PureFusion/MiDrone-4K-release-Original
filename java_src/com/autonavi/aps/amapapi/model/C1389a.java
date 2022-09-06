package com.autonavi.aps.amapapi.model;

import android.os.Parcel;
import android.os.Parcelable;
/* renamed from: com.autonavi.aps.amapapi.model.a */
/* loaded from: classes.dex */
class C1389a implements Parcelable.Creator<AmapLoc> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public AmapLoc createFromParcel(Parcel parcel) {
        return new AmapLoc(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public AmapLoc[] newArray(int i) {
        return null;
    }
}
