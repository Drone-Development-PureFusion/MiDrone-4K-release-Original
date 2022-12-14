package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NavigateArrowOptionsCreator implements Parcelable.Creator<NavigateArrowOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    /* renamed from: createFromParcel */
    public NavigateArrowOptions mo21724createFromParcel(Parcel parcel) {
        boolean z = true;
        NavigateArrowOptions navigateArrowOptions = new NavigateArrowOptions();
        ArrayList arrayList = new ArrayList();
        parcel.readTypedList(arrayList, LatLng.CREATOR);
        float readFloat = parcel.readFloat();
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        float readFloat2 = parcel.readFloat();
        if (parcel.readByte() != 1) {
            z = false;
        }
        navigateArrowOptions.addAll(arrayList);
        navigateArrowOptions.width(readFloat);
        navigateArrowOptions.topColor(readInt);
        navigateArrowOptions.sideColor(readInt2);
        navigateArrowOptions.zIndex(readFloat2);
        navigateArrowOptions.visible(z);
        navigateArrowOptions.f3746a = parcel.readString();
        return navigateArrowOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    /* renamed from: newArray */
    public NavigateArrowOptions[] mo21725newArray(int i) {
        return new NavigateArrowOptions[i];
    }
}
