package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class Poi implements Parcelable {
    public static final PoiCreator CREATOR = new PoiCreator();

    /* renamed from: a */
    private final String f3753a;

    /* renamed from: b */
    private final LatLng f3754b;

    /* renamed from: c */
    private final String f3755c;

    public Poi(String str, LatLng latLng, String str2) {
        this.f3753a = str;
        this.f3754b = latLng;
        this.f3755c = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Poi)) {
            return false;
        }
        Poi poi = (Poi) obj;
        return poi.getName().equals(this.f3753a) && poi.getCoordinate().equals(this.f3754b) && poi.getPoiId().equals(this.f3755c);
    }

    public LatLng getCoordinate() {
        return this.f3754b;
    }

    public String getName() {
        return this.f3753a;
    }

    public String getPoiId() {
        return this.f3755c;
    }

    public int hashCode() {
        return (((this.f3753a.hashCode() * 31) + this.f3754b.hashCode()) * 31) + this.f3755c.hashCode();
    }

    public String toString() {
        return "poiid " + this.f3755c + " name:" + this.f3753a + "  coordinate:" + this.f3754b.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3753a);
        parcel.writeParcelable(this.f3754b, i);
        parcel.writeString(this.f3755c);
    }
}
