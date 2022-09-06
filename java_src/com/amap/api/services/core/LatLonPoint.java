package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public final class LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonPoint> CREATOR = new C1240k();

    /* renamed from: a */
    private double f3948a;

    /* renamed from: b */
    private double f3949b;

    public LatLonPoint(double d, double d2) {
        this.f3948a = d;
        this.f3949b = d2;
    }

    private LatLonPoint(Parcel parcel) {
        this.f3948a = parcel.readDouble();
        this.f3949b = parcel.readDouble();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ LatLonPoint(Parcel parcel, C1240k c1240k) {
        this(parcel);
    }

    public LatLonPoint copy() {
        return new LatLonPoint(this.f3948a, this.f3949b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            LatLonPoint latLonPoint = (LatLonPoint) obj;
            return Double.doubleToLongBits(this.f3948a) == Double.doubleToLongBits(latLonPoint.f3948a) && Double.doubleToLongBits(this.f3949b) == Double.doubleToLongBits(latLonPoint.f3949b);
        }
        return false;
    }

    public double getLatitude() {
        return this.f3948a;
    }

    public double getLongitude() {
        return this.f3949b;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f3948a);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f3949b);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public void setLatitude(double d) {
        this.f3948a = d;
    }

    public void setLongitude(double d) {
        this.f3949b = d;
    }

    public String toString() {
        return "" + this.f3948a + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f3949b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f3948a);
        parcel.writeDouble(this.f3949b);
    }
}
