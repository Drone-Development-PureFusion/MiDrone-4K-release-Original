package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public final class GeocodeAddress implements Parcelable {
    public static final Parcelable.Creator<GeocodeAddress> CREATOR = new C1271b();

    /* renamed from: a */
    private String f4235a;

    /* renamed from: b */
    private String f4236b;

    /* renamed from: c */
    private String f4237c;

    /* renamed from: d */
    private String f4238d;

    /* renamed from: e */
    private String f4239e;

    /* renamed from: f */
    private String f4240f;

    /* renamed from: g */
    private String f4241g;

    /* renamed from: h */
    private String f4242h;

    /* renamed from: i */
    private LatLonPoint f4243i;

    /* renamed from: j */
    private String f4244j;

    public GeocodeAddress() {
    }

    private GeocodeAddress(Parcel parcel) {
        this.f4235a = parcel.readString();
        this.f4236b = parcel.readString();
        this.f4237c = parcel.readString();
        this.f4238d = parcel.readString();
        this.f4239e = parcel.readString();
        this.f4240f = parcel.readString();
        this.f4241g = parcel.readString();
        this.f4242h = parcel.readString();
        this.f4243i = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f4244j = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ GeocodeAddress(Parcel parcel, C1271b c1271b) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f4242h;
    }

    public String getBuilding() {
        return this.f4241g;
    }

    public String getCity() {
        return this.f4237c;
    }

    public String getDistrict() {
        return this.f4238d;
    }

    public String getFormatAddress() {
        return this.f4235a;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f4243i;
    }

    public String getLevel() {
        return this.f4244j;
    }

    public String getNeighborhood() {
        return this.f4240f;
    }

    public String getProvince() {
        return this.f4236b;
    }

    public String getTownship() {
        return this.f4239e;
    }

    public void setAdcode(String str) {
        this.f4242h = str;
    }

    public void setBuilding(String str) {
        this.f4241g = str;
    }

    public void setCity(String str) {
        this.f4237c = str;
    }

    public void setDistrict(String str) {
        this.f4238d = str;
    }

    public void setFormatAddress(String str) {
        this.f4235a = str;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f4243i = latLonPoint;
    }

    public void setLevel(String str) {
        this.f4244j = str;
    }

    public void setNeighborhood(String str) {
        this.f4240f = str;
    }

    public void setProvince(String str) {
        this.f4236b = str;
    }

    public void setTownship(String str) {
        this.f4239e = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4235a);
        parcel.writeString(this.f4236b);
        parcel.writeString(this.f4237c);
        parcel.writeString(this.f4238d);
        parcel.writeString(this.f4239e);
        parcel.writeString(this.f4240f);
        parcel.writeString(this.f4241g);
        parcel.writeString(this.f4242h);
        parcel.writeValue(this.f4243i);
        parcel.writeString(this.f4244j);
    }
}
