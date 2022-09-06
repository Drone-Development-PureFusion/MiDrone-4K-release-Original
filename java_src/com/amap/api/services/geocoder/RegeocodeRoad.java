package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public final class RegeocodeRoad implements Parcelable {
    public static final Parcelable.Creator<RegeocodeRoad> CREATOR = new C1273d();

    /* renamed from: a */
    private String f4275a;

    /* renamed from: b */
    private String f4276b;

    /* renamed from: c */
    private float f4277c;

    /* renamed from: d */
    private String f4278d;

    /* renamed from: e */
    private LatLonPoint f4279e;

    public RegeocodeRoad() {
    }

    private RegeocodeRoad(Parcel parcel) {
        this.f4275a = parcel.readString();
        this.f4276b = parcel.readString();
        this.f4277c = parcel.readFloat();
        this.f4278d = parcel.readString();
        this.f4279e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ RegeocodeRoad(Parcel parcel, C1273d c1273d) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDirection() {
        return this.f4278d;
    }

    public float getDistance() {
        return this.f4277c;
    }

    public String getId() {
        return this.f4275a;
    }

    public LatLonPoint getLatLngPoint() {
        return this.f4279e;
    }

    public String getName() {
        return this.f4276b;
    }

    public void setDirection(String str) {
        this.f4278d = str;
    }

    public void setDistance(float f) {
        this.f4277c = f;
    }

    public void setId(String str) {
        this.f4275a = str;
    }

    public void setLatLngPoint(LatLonPoint latLonPoint) {
        this.f4279e = latLonPoint;
    }

    public void setName(String str) {
        this.f4276b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4275a);
        parcel.writeString(this.f4276b);
        parcel.writeFloat(this.f4277c);
        parcel.writeString(this.f4278d);
        parcel.writeValue(this.f4279e);
    }
}
