package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class DrivePath extends Path implements Parcelable {
    public static final Parcelable.Creator<DrivePath> CREATOR = new C1300f();

    /* renamed from: a */
    private String f4445a;

    /* renamed from: b */
    private float f4446b;

    /* renamed from: c */
    private float f4447c;

    /* renamed from: d */
    private List<DriveStep> f4448d;

    public DrivePath() {
        this.f4448d = new ArrayList();
    }

    public DrivePath(Parcel parcel) {
        super(parcel);
        this.f4448d = new ArrayList();
        this.f4445a = parcel.readString();
        this.f4446b = parcel.readFloat();
        this.f4447c = parcel.readFloat();
        this.f4448d = parcel.createTypedArrayList(DriveStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DriveStep> getSteps() {
        return this.f4448d;
    }

    public String getStrategy() {
        return this.f4445a;
    }

    public float getTollDistance() {
        return this.f4447c;
    }

    public float getTolls() {
        return this.f4446b;
    }

    public void setSteps(List<DriveStep> list) {
        this.f4448d = list;
    }

    public void setStrategy(String str) {
        this.f4445a = str;
    }

    public void setTollDistance(float f) {
        this.f4447c = f;
    }

    public void setTolls(float f) {
        this.f4446b = f;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f4445a);
        parcel.writeFloat(this.f4446b);
        parcel.writeFloat(this.f4447c);
        parcel.writeTypedList(this.f4448d);
    }
}
