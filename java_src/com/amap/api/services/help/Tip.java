package com.amap.api.services.help;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class Tip implements Parcelable {
    public static final Parcelable.Creator<Tip> CREATOR = new C1276a();

    /* renamed from: a */
    private String f4291a;

    /* renamed from: b */
    private String f4292b;

    /* renamed from: c */
    private String f4293c;

    public Tip() {
    }

    private Tip(Parcel parcel) {
        this.f4291a = parcel.readString();
        this.f4293c = parcel.readString();
        this.f4292b = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ Tip(Parcel parcel, C1276a c1276a) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f4293c;
    }

    public String getDistrict() {
        return this.f4292b;
    }

    public String getName() {
        return this.f4291a;
    }

    public void setAdcode(String str) {
        this.f4293c = str;
    }

    public void setDistrict(String str) {
        this.f4292b = str;
    }

    public void setName(String str) {
        this.f4291a = str;
    }

    public String toString() {
        return "name:" + this.f4291a + " district:" + this.f4292b + " adcode:" + this.f4293c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4291a);
        parcel.writeString(this.f4293c);
        parcel.writeString(this.f4292b);
    }
}
