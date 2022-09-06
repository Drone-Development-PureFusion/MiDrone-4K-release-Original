package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.AMapException;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
/* loaded from: classes.dex */
public final class LatLng implements Parcelable, Cloneable {
    public static final LatLngCreator CREATOR = new LatLngCreator();

    /* renamed from: a */
    private static DecimalFormat f3703a = new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US));
    public final double latitude;
    public final double longitude;

    public LatLng(double d, double d2) {
        this(d, d2, true);
    }

    public LatLng(double d, double d2, boolean z) {
        if (!z) {
            this.latitude = d;
            this.longitude = d2;
            return;
        }
        if (-180.0d > d2 || d2 >= 180.0d) {
            this.longitude = m17393a(((((d2 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d);
        } else {
            this.longitude = m17393a(d2);
        }
        if (d < -90.0d || d > 90.0d) {
            try {
                throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);
            } catch (AMapException e) {
                e.printStackTrace();
            }
        }
        this.latitude = m17393a(Math.max(-90.0d, Math.min(90.0d, d)));
    }

    /* renamed from: a */
    private static double m17393a(double d) {
        return Double.parseDouble(f3703a.format(d));
    }

    /* renamed from: clone */
    public LatLng m21715clone() {
        return new LatLng(this.latitude, this.longitude);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(latLng.latitude) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(latLng.longitude);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return (31 * (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31)) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        return "lat/lng: (" + this.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + this.longitude + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
    }
}
