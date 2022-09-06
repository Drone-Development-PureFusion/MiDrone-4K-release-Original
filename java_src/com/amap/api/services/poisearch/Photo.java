package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class Photo implements Parcelable {
    public static final Parcelable.Creator<Photo> CREATOR = new C1284f();

    /* renamed from: a */
    private String f4357a;

    /* renamed from: b */
    private String f4358b;

    public Photo() {
    }

    public Photo(Parcel parcel) {
        this.f4357a = parcel.readString();
        this.f4358b = parcel.readString();
    }

    public Photo(String str, String str2) {
        this.f4357a = str;
        this.f4358b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getTitle() {
        return this.f4357a;
    }

    public String getUrl() {
        return this.f4358b;
    }

    public void setTitle(String str) {
        this.f4357a = str;
    }

    public void setUrl(String str) {
        this.f4358b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4357a);
        parcel.writeString(this.f4358b);
    }
}
