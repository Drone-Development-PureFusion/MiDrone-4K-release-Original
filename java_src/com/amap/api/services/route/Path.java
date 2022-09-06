package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class Path implements Parcelable {
    public static final Parcelable.Creator<Path> CREATOR = new C1303i();

    /* renamed from: a */
    private float f4464a;

    /* renamed from: b */
    private long f4465b;

    public Path() {
    }

    public Path(Parcel parcel) {
        this.f4464a = parcel.readFloat();
        this.f4465b = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f4464a;
    }

    public long getDuration() {
        return this.f4465b;
    }

    public void setDistance(float f) {
        this.f4464a = f;
    }

    public void setDuration(long j) {
        this.f4465b = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f4464a);
        parcel.writeLong(this.f4465b);
    }
}
