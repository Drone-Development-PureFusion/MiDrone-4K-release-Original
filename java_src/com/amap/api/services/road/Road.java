package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public class Road implements Parcelable {
    public static final Parcelable.Creator<Road> CREATOR = new C1291b();

    /* renamed from: a */
    private String f4423a;

    /* renamed from: b */
    private String f4424b;

    /* renamed from: c */
    private String f4425c;

    /* renamed from: d */
    private float f4426d;

    /* renamed from: e */
    private String f4427e;

    /* renamed from: f */
    private LatLonPoint f4428f;

    public Road() {
    }

    private Road(Parcel parcel) {
        this.f4423a = parcel.readString();
        this.f4424b = parcel.readString();
        this.f4425c = parcel.readString();
        this.f4426d = parcel.readFloat();
        this.f4427e = parcel.readString();
        this.f4428f = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ Road(Parcel parcel, C1291b c1291b) {
        this(parcel);
    }

    public Road(String str, String str2) {
        this.f4423a = str;
        this.f4424b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getCenterPoint() {
        return this.f4428f;
    }

    public String getCityCode() {
        return this.f4425c;
    }

    public String getId() {
        return this.f4423a;
    }

    public String getName() {
        return this.f4424b;
    }

    public float getRoadWidth() {
        return this.f4426d;
    }

    public String getType() {
        return this.f4427e;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.f4428f = latLonPoint;
    }

    public void setCityCode(String str) {
        this.f4425c = str;
    }

    public void setId(String str) {
        this.f4423a = str;
    }

    public void setName(String str) {
        this.f4424b = str;
    }

    public void setRoadWidth(float f) {
        this.f4426d = f;
    }

    public void setType(String str) {
        this.f4427e = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4423a);
        parcel.writeString(this.f4424b);
        parcel.writeString(this.f4425c);
        parcel.writeFloat(this.f4426d);
        parcel.writeString(this.f4427e);
        parcel.writeValue(this.f4428f);
    }
}
