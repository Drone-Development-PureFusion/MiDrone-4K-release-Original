package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PolylineOptionsCreator implements Parcelable.Creator<PolylineOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    /* renamed from: createFromParcel */
    public PolylineOptions mo21730createFromParcel(Parcel parcel) {
        PolylineOptions polylineOptions = new PolylineOptions();
        ArrayList arrayList = new ArrayList();
        parcel.readTypedList(arrayList, LatLng.CREATOR);
        float readFloat = parcel.readFloat();
        int readInt = parcel.readInt();
        float readFloat2 = parcel.readFloat();
        float readFloat3 = parcel.readFloat();
        polylineOptions.f3767a = parcel.readString();
        boolean[] zArr = new boolean[5];
        parcel.readBooleanArray(zArr);
        polylineOptions.addAll(arrayList);
        polylineOptions.width(readFloat);
        polylineOptions.color(readInt);
        polylineOptions.zIndex(readFloat2);
        polylineOptions.transparency(readFloat3);
        polylineOptions.visible(zArr[0]);
        polylineOptions.setDottedLine(zArr[1]);
        polylineOptions.geodesic(zArr[2]);
        polylineOptions.useGradient(zArr[3]);
        polylineOptions.aboveMaskLayer(zArr[4]);
        polylineOptions.setCustomTexture((BitmapDescriptor) parcel.readParcelable(BitmapDescriptor.class.getClassLoader()));
        polylineOptions.setCustomTextureList(parcel.readArrayList(BitmapDescriptor.class.getClassLoader()));
        polylineOptions.setCustomTextureIndex(parcel.readArrayList(Integer.class.getClassLoader()));
        polylineOptions.colorValues(parcel.readArrayList(Integer.class.getClassLoader()));
        return polylineOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    /* renamed from: newArray */
    public PolylineOptions[] mo21731newArray(int i) {
        return new PolylineOptions[i];
    }
}
