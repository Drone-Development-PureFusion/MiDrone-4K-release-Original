package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class SearchCity implements Parcelable {
    public static final Parcelable.Creator<SearchCity> CREATOR = new C1312r();

    /* renamed from: a */
    private String f4501a;

    /* renamed from: b */
    private String f4502b;

    /* renamed from: c */
    private String f4503c;

    public SearchCity() {
    }

    public SearchCity(Parcel parcel) {
        this.f4501a = parcel.readString();
        this.f4502b = parcel.readString();
        this.f4503c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getSearchCityAdCode() {
        return this.f4503c;
    }

    public String getSearchCityName() {
        return this.f4501a;
    }

    public String getSearchCitycode() {
        return this.f4502b;
    }

    public void setSearchCityName(String str) {
        this.f4501a = str;
    }

    public void setSearchCitycode(String str) {
        this.f4502b = str;
    }

    public void setSearchCityhAdCode(String str) {
        this.f4503c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4501a);
        parcel.writeString(this.f4502b);
        parcel.writeString(this.f4503c);
    }
}
