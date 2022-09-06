package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class District implements Parcelable {
    public static final Parcelable.Creator<District> CREATOR = new C1298d();

    /* renamed from: a */
    private String f4441a;

    /* renamed from: b */
    private String f4442b;

    public District() {
    }

    public District(Parcel parcel) {
        this.f4441a = parcel.readString();
        this.f4442b = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDistrictAdcode() {
        return this.f4442b;
    }

    public String getDistrictName() {
        return this.f4441a;
    }

    public void setDistrictAdcode(String str) {
        this.f4442b = str;
    }

    public void setDistrictName(String str) {
        this.f4441a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4441a);
        parcel.writeString(this.f4442b);
    }
}
