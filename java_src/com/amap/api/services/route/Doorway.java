package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
/* loaded from: classes.dex */
public class Doorway implements Parcelable {
    public static final Parcelable.Creator<Doorway> CREATOR = new C1299e();

    /* renamed from: a */
    private String f4443a;

    /* renamed from: b */
    private LatLonPoint f4444b;

    public Doorway() {
    }

    public Doorway(Parcel parcel) {
        this.f4443a = parcel.readString();
        this.f4444b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f4444b;
    }

    public String getName() {
        return this.f4443a;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f4444b = latLonPoint;
    }

    public void setName(String str) {
        this.f4443a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4443a);
        parcel.writeParcelable(this.f4444b, i);
    }
}
