package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class Crossroad extends Road implements Parcelable {
    public static final Parcelable.Creator<Crossroad> CREATOR = new C1290a();

    /* renamed from: a */
    private float f4417a;

    /* renamed from: b */
    private String f4418b;

    /* renamed from: c */
    private String f4419c;

    /* renamed from: d */
    private String f4420d;

    /* renamed from: e */
    private String f4421e;

    /* renamed from: f */
    private String f4422f;

    public Crossroad() {
    }

    private Crossroad(Parcel parcel) {
        this.f4417a = parcel.readFloat();
        this.f4418b = parcel.readString();
        this.f4419c = parcel.readString();
        this.f4420d = parcel.readString();
        this.f4421e = parcel.readString();
        this.f4422f = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ Crossroad(Parcel parcel, C1290a c1290a) {
        this(parcel);
    }

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDirection() {
        return this.f4418b;
    }

    public float getDistance() {
        return this.f4417a;
    }

    public String getFirstRoadId() {
        return this.f4419c;
    }

    public String getFirstRoadName() {
        return this.f4420d;
    }

    public String getSecondRoadId() {
        return this.f4421e;
    }

    public String getSecondRoadName() {
        return this.f4422f;
    }

    public void setDirection(String str) {
        this.f4418b = str;
    }

    public void setDistance(float f) {
        this.f4417a = f;
    }

    public void setFirstRoadId(String str) {
        this.f4419c = str;
    }

    public void setFirstRoadName(String str) {
        this.f4420d = str;
    }

    public void setSecondRoadId(String str) {
        this.f4421e = str;
    }

    public void setSecondRoadName(String str) {
        this.f4422f = str;
    }

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f4417a);
        parcel.writeString(this.f4418b);
        parcel.writeString(this.f4419c);
        parcel.writeString(this.f4420d);
        parcel.writeString(this.f4421e);
        parcel.writeString(this.f4422f);
    }
}
