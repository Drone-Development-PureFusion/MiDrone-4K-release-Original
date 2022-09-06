package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class OfflineMapProvince extends Province {
    public static final Parcelable.Creator<OfflineMapProvince> CREATOR = new Parcelable.Creator<OfflineMapProvince>() { // from class: com.amap.api.maps.offlinemap.OfflineMapProvince.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public OfflineMapProvince createFromParcel(Parcel parcel) {
            return new OfflineMapProvince(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public OfflineMapProvince[] newArray(int i) {
            return new OfflineMapProvince[i];
        }
    };

    /* renamed from: a */
    private String f3849a;

    /* renamed from: b */
    private int f3850b;

    /* renamed from: c */
    private long f3851c;

    /* renamed from: d */
    private String f3852d;

    /* renamed from: e */
    private int f3853e;

    /* renamed from: f */
    private ArrayList<OfflineMapCity> f3854f;

    public OfflineMapProvince() {
        this.f3850b = 6;
        this.f3853e = 0;
    }

    public OfflineMapProvince(Parcel parcel) {
        super(parcel);
        this.f3850b = 6;
        this.f3853e = 0;
        this.f3849a = parcel.readString();
        this.f3850b = parcel.readInt();
        this.f3851c = parcel.readLong();
        this.f3852d = parcel.readString();
        this.f3853e = parcel.readInt();
        this.f3854f = parcel.createTypedArrayList(OfflineMapCity.CREATOR);
    }

    @Override // com.amap.api.maps.offlinemap.Province, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<OfflineMapCity> getCityList() {
        return this.f3854f == null ? new ArrayList<>() : this.f3854f;
    }

    public long getSize() {
        return this.f3851c;
    }

    public int getState() {
        return this.f3850b;
    }

    public String getUrl() {
        return this.f3849a;
    }

    public String getVersion() {
        return this.f3852d;
    }

    public int getcompleteCode() {
        return this.f3853e;
    }

    public void setCityList(ArrayList<OfflineMapCity> arrayList) {
        this.f3854f = arrayList;
    }

    public void setCompleteCode(int i) {
        this.f3853e = i;
    }

    public void setSize(long j) {
        this.f3851c = j;
    }

    public void setState(int i) {
        this.f3850b = i;
    }

    public void setUrl(String str) {
        this.f3849a = str;
    }

    public void setVersion(String str) {
        this.f3852d = str;
    }

    @Override // com.amap.api.maps.offlinemap.Province, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f3849a);
        parcel.writeInt(this.f3850b);
        parcel.writeLong(this.f3851c);
        parcel.writeString(this.f3852d);
        parcel.writeInt(this.f3853e);
        parcel.writeTypedList(this.f3854f);
    }
}
