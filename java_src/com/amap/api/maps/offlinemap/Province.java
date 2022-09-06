package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class Province implements Parcelable {
    public static final Parcelable.Creator<Province> CREATOR = new Parcelable.Creator<Province>() { // from class: com.amap.api.maps.offlinemap.Province.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Province createFromParcel(Parcel parcel) {
            return new Province(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Province[] newArray(int i) {
            return new Province[i];
        }
    };

    /* renamed from: a */
    private String f3855a;

    /* renamed from: b */
    private String f3856b;

    /* renamed from: c */
    private String f3857c;

    /* renamed from: d */
    private String f3858d;

    public Province() {
        this.f3855a = "";
        this.f3858d = "";
    }

    public Province(Parcel parcel) {
        this.f3855a = "";
        this.f3858d = "";
        this.f3855a = parcel.readString();
        this.f3856b = parcel.readString();
        this.f3857c = parcel.readString();
        this.f3858d = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getJianpin() {
        return this.f3856b;
    }

    public String getPinyin() {
        return this.f3857c;
    }

    public String getProvinceCode() {
        return this.f3858d;
    }

    public String getProvinceName() {
        return this.f3855a;
    }

    public void setJianpin(String str) {
        this.f3856b = str;
    }

    public void setPinyin(String str) {
        this.f3857c = str;
    }

    public void setProvinceCode(String str) {
        this.f3858d = str;
    }

    public void setProvinceName(String str) {
        this.f3855a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3855a);
        parcel.writeString(this.f3856b);
        parcel.writeString(this.f3857c);
        parcel.writeString(this.f3858d);
    }
}
