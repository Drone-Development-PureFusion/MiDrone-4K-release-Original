package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class OfflineMapCity extends City {
    public static final Parcelable.Creator<OfflineMapCity> CREATOR = new Parcelable.Creator<OfflineMapCity>() { // from class: com.amap.api.maps.offlinemap.OfflineMapCity.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public OfflineMapCity createFromParcel(Parcel parcel) {
            return new OfflineMapCity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public OfflineMapCity[] newArray(int i) {
            return new OfflineMapCity[i];
        }
    };

    /* renamed from: a */
    private String f3827a;

    /* renamed from: b */
    private long f3828b;

    /* renamed from: c */
    private int f3829c;

    /* renamed from: d */
    private String f3830d;

    /* renamed from: e */
    private int f3831e;

    public OfflineMapCity() {
        this.f3827a = "";
        this.f3828b = 0L;
        this.f3829c = 6;
        this.f3830d = "";
        this.f3831e = 0;
    }

    public OfflineMapCity(Parcel parcel) {
        super(parcel);
        this.f3827a = "";
        this.f3828b = 0L;
        this.f3829c = 6;
        this.f3830d = "";
        this.f3831e = 0;
        this.f3827a = parcel.readString();
        this.f3828b = parcel.readLong();
        this.f3829c = parcel.readInt();
        this.f3830d = parcel.readString();
        this.f3831e = parcel.readInt();
    }

    @Override // com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getSize() {
        return this.f3828b;
    }

    public int getState() {
        return this.f3829c;
    }

    public String getUrl() {
        return this.f3827a;
    }

    public String getVersion() {
        return this.f3830d;
    }

    public int getcompleteCode() {
        return this.f3831e;
    }

    public void setCompleteCode(int i) {
        this.f3831e = i;
    }

    public void setSize(long j) {
        this.f3828b = j;
    }

    public void setState(int i) {
        this.f3829c = i;
    }

    public void setUrl(String str) {
        this.f3827a = str;
    }

    public void setVersion(String str) {
        this.f3830d = str;
    }

    @Override // com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f3827a);
        parcel.writeLong(this.f3828b);
        parcel.writeInt(this.f3829c);
        parcel.writeString(this.f3830d);
        parcel.writeInt(this.f3831e);
    }
}
