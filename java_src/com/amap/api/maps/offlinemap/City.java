package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class City implements Parcelable {
    public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() { // from class: com.amap.api.maps.offlinemap.City.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public City createFromParcel(Parcel parcel) {
            return new City(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public City[] newArray(int i) {
            return new City[i];
        }
    };

    /* renamed from: a */
    private String f3822a;

    /* renamed from: b */
    private String f3823b;

    /* renamed from: c */
    private String f3824c;

    /* renamed from: d */
    private String f3825d;

    /* renamed from: e */
    private String f3826e;

    public City() {
        this.f3822a = "";
        this.f3823b = "";
        this.f3826e = "";
    }

    public City(Parcel parcel) {
        this.f3822a = "";
        this.f3823b = "";
        this.f3826e = "";
        this.f3822a = parcel.readString();
        this.f3823b = parcel.readString();
        this.f3824c = parcel.readString();
        this.f3825d = parcel.readString();
        this.f3826e = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f3826e;
    }

    public String getCity() {
        return this.f3822a;
    }

    public String getCode() {
        return this.f3823b;
    }

    public String getJianpin() {
        return this.f3824c;
    }

    public String getPinyin() {
        return this.f3825d;
    }

    public void setAdcode(String str) {
        this.f3826e = str;
    }

    public void setCity(String str) {
        this.f3822a = str;
    }

    public void setCode(String str) {
        if (str == null || str.equals("[]")) {
            return;
        }
        this.f3823b = str;
    }

    public void setJianpin(String str) {
        this.f3824c = str;
    }

    public void setPinyin(String str) {
        this.f3825d = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3822a);
        parcel.writeString(this.f3823b);
        parcel.writeString(this.f3824c);
        parcel.writeString(this.f3825d);
        parcel.writeString(this.f3826e);
    }
}
