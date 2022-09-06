package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class WalkPath extends Path implements Parcelable {
    public static final Parcelable.Creator<WalkPath> CREATOR = new C1313s();

    /* renamed from: a */
    private List<WalkStep> f4504a;

    public WalkPath() {
        this.f4504a = new ArrayList();
    }

    public WalkPath(Parcel parcel) {
        super(parcel);
        this.f4504a = new ArrayList();
        this.f4504a = parcel.createTypedArrayList(WalkStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkStep> getSteps() {
        return this.f4504a;
    }

    public void setSteps(List<WalkStep> list) {
        this.f4504a = list;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f4504a);
    }
}
