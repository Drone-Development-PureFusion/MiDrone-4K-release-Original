package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class BusPath extends Path implements Parcelable {
    public static final Parcelable.Creator<BusPath> CREATOR = new C1295a();

    /* renamed from: a */
    private float f4429a;

    /* renamed from: b */
    private boolean f4430b;

    /* renamed from: c */
    private float f4431c;

    /* renamed from: d */
    private float f4432d;

    /* renamed from: e */
    private List<BusStep> f4433e;

    public BusPath() {
        this.f4433e = new ArrayList();
    }

    public BusPath(Parcel parcel) {
        super(parcel);
        this.f4433e = new ArrayList();
        this.f4429a = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f4430b = zArr[0];
        this.f4431c = parcel.readFloat();
        this.f4432d = parcel.readFloat();
        this.f4433e = parcel.createTypedArrayList(BusStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBusDistance() {
        return this.f4432d;
    }

    public float getCost() {
        return this.f4429a;
    }

    @Override // com.amap.api.services.route.Path
    public float getDistance() {
        return this.f4431c + this.f4432d;
    }

    public List<BusStep> getSteps() {
        return this.f4433e;
    }

    public float getWalkDistance() {
        return this.f4431c;
    }

    public boolean isNightBus() {
        return this.f4430b;
    }

    public void setBusDistance(float f) {
        this.f4432d = f;
    }

    public void setCost(float f) {
        this.f4429a = f;
    }

    public void setNightBus(boolean z) {
        this.f4430b = z;
    }

    public void setSteps(List<BusStep> list) {
        this.f4433e = list;
    }

    public void setWalkDistance(float f) {
        this.f4431c = f;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f4429a);
        parcel.writeBooleanArray(new boolean[]{this.f4430b});
        parcel.writeFloat(this.f4431c);
        parcel.writeFloat(this.f4432d);
        parcel.writeTypedList(this.f4433e);
    }
}
